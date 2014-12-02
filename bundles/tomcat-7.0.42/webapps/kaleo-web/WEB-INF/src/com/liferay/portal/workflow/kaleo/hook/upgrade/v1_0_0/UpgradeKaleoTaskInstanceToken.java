/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.portal.workflow.kaleo.hook.upgrade.v1_0_0;

import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.workflow.kaleo.definition.NodeType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Marcellus Tavares
 */
public class UpgradeKaleoTaskInstanceToken extends UpgradeProcess {

	protected void deleteKaleoInstanceTokens() throws Exception {
		if (_kaleoInstanceTokenIds.isEmpty()) {
			return;
		}

		StringBundler sb = new StringBundler(
			_kaleoInstanceTokenIds.size() * 4 + 1);

		sb.append("delete from KaleoInstanceToken where ");

		for (long kaleoInstanceTokenId : _kaleoInstanceTokenIds) {
			sb.append("(kaleoInstanceTokenId = ");
			sb.append(kaleoInstanceTokenId);
			sb.append(StringPool.CLOSE_PARENTHESIS);
			sb.append(" OR ");
		}

		sb.setIndex(sb.index() - 1);

		String sql = sb.toString();

		runSQL(sql);
	}


	protected void doUpgrade() throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DataAccess.getUpgradeOptimizedConnection();

			ps = con.prepareStatement(
				"select kaleoTaskInstanceTokenId, kaleoInstanceTokenId from " +
					"KaleoTaskInstanceToken");

			rs = ps.executeQuery();

			while (rs.next()) {
				long kaleoTaskInstanceTokenId = rs.getLong(
					"kaleoTaskInstanceTokenId");
				long oldKaleoInstanceTokenId = rs.getLong(
					"kaleoInstanceTokenId");

				long newKaleoInstanceTokenId = getKaleoInstanceTokenId(
					oldKaleoInstanceTokenId);

				if (oldKaleoInstanceTokenId == newKaleoInstanceTokenId) {
					continue;
				}

				StringBundler sb = new StringBundler();

				sb.append("update KaleoTaskInstanceToken set ");
				sb.append("kaleoInstanceTokenId = ");
				sb.append(newKaleoInstanceTokenId);
				sb.append(" where kaleoTaskInstanceTokenId = ");
				sb.append(kaleoTaskInstanceTokenId);

				String sql = sb.toString();

				runSQL(sql);
			}
		}
		finally {
			DataAccess.cleanUp(con, ps, rs);
		}

		deleteKaleoInstanceTokens();
	}

	protected long getKaleoInstanceTokenId(long kaleoInstanceTokenId)
		throws Exception {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DataAccess.getUpgradeOptimizedConnection();

			StringBundler sb = new StringBundler();

			sb.append("select KaleoNode.type_, ");
			sb.append("KaleoInstanceToken.kaleoInstanceTokenId ");
			sb.append("from KaleoNode inner join KaleoInstanceToken on ");
			sb.append("(KaleoNode.kaleoNodeId = ");
			sb.append("KaleoInstanceToken.currentKaleoNodeId) ");
			sb.append("where KaleoInstanceToken.kaleoInstanceTokenId = ");
			sb.append("(select parentKaleoInstanceTokenId from ");
			sb.append("KaleoInstanceToken where KaleoInstanceTokenId = ?)");

			String sql = sb.toString();

			ps = con.prepareStatement(sql);

			ps.setLong(1, kaleoInstanceTokenId);

			rs = ps.executeQuery();

			if (rs.next()) {
				String type = rs.getString("type_");

				if (!type.equals(NodeType.TASK.toString())) {
					return kaleoInstanceTokenId;
				}

				long parentKaleoInstanceTokenId = rs.getLong(
					"kaleoInstanceTokenId");

				_kaleoInstanceTokenIds.add(kaleoInstanceTokenId);

				return getKaleoInstanceTokenId(parentKaleoInstanceTokenId);
			}
			else {
				return kaleoInstanceTokenId;
			}
		}
		finally {
			DataAccess.cleanUp(con, ps, rs);
		}
	}

	private Set<Long> _kaleoInstanceTokenIds = new HashSet<Long>();

}