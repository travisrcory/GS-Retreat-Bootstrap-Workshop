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

package com.liferay.portal.workflow.kaleo.model.upgrade;

import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upgrade.util.BaseUpgradeTableListener;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.ServiceComponent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class BaseKaleoUpgradeTableListener extends BaseUpgradeTableListener {

	protected Map<Long, Long> getKeyValueMap(
			String tableName, String keyColumnName, String valueColumnName)
		throws SystemException {

		Map<Long, Long> keyValueMap = new HashMap<Long, Long>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DataAccess.getUpgradeOptimizedConnection();

			ps = con.prepareStatement(
				"select " + keyColumnName + ", " + valueColumnName + " from " +
					tableName);

			rs = ps.executeQuery();

			while (rs.next()) {
				long key = rs.getLong(keyColumnName);
				long value = rs.getLong(valueColumnName);

				if (_log.isDebugEnabled()) {
					_log.debug(
						"{" + keyColumnName + "=" + key + ", " +
							valueColumnName + "=" + value + "}");
				}

				keyValueMap.put(key, value);
			}
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			DataAccess.cleanUp(con, ps, rs);
		}

		return keyValueMap;
	}

	protected boolean isFixAutoUpgrade(
		ServiceComponent previousServiceComponent) {

		if (previousServiceComponent.getBuildNumber() >= 4) {
			return false;
		}

		return true;
	}

	protected void updateKeyValueMap(
			Map<Long, Long> keyValueMap, String kaleoClassName,
			String tableName, String keyColumnName)
		throws Exception {

		for (Map.Entry<Long, Long> entry : keyValueMap.entrySet()) {
			StringBundler sb = new StringBundler(10);

			sb.append("update ");
			sb.append(tableName);
			sb.append(" set kaleoClassName = '");
			sb.append(kaleoClassName);
			sb.append("', kaleoClassPK = ");
			sb.append(entry.getValue());
			sb.append(" where ");
			sb.append(keyColumnName);
			sb.append(" = ");
			sb.append(entry.getKey());

			runSQL(sb.toString());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		BaseKaleoUpgradeTableListener.class);

}