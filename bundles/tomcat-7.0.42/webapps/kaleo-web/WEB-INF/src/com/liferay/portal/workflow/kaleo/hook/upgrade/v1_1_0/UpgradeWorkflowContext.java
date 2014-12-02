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

package com.liferay.portal.workflow.kaleo.hook.upgrade.v1_1_0;

import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.workflow.kaleo.util.WorkflowContextUtil;

import java.io.Serializable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.Map;

import org.jabsorb.JSONSerializer;

/**
 * @author Jang Kim
 */
public class UpgradeWorkflowContext extends UpgradeProcess {


	protected void doUpgrade() throws Exception {
		updateTable("KaleoInstance", "kaleoInstanceId");
		updateTable("KaleoLog", "kaleoLogId");
		updateTable("KaleoTaskInstanceToken", "kaleoTaskInstanceTokenId");
	}

	protected void updateTable(String tableName, String fieldName)
		throws Exception {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DataAccess.getConnection();

			ps = con.prepareStatement(
				"select " + fieldName + ", workflowContext from " + tableName +
					" where workflowContext is not null and workflowContext " +
						"not like '%serializable%'");

			rs = ps.executeQuery();

			JSONSerializer jsonSerializer = new JSONSerializer();

			jsonSerializer.registerDefaultSerializers();

			while (rs.next()) {
				long fieldValue = rs.getLong(fieldName);
				String workflowContext = rs.getString("workflowContext");

				if (Validator.isNull(workflowContext)) {
					continue;
				}

				workflowContext = WorkflowContextUtil.convert(
					(Map<String, Serializable>)jsonSerializer.fromJSON(
						workflowContext));

				updateWorkflowContext(
					tableName, fieldName, fieldValue, workflowContext);
			}
		}
		finally {
			DataAccess.cleanUp(con, ps, rs);
		}
	}

	protected void updateWorkflowContext(
			String tableName, String fieldName, long fieldValue,
			String workflowContext)
		throws Exception {

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DataAccess.getUpgradeOptimizedConnection();

			ps = con.prepareStatement(
				"update " + tableName + " set workflowContext = ? where " +
					fieldName + " = ?");

			ps.setString(1, workflowContext);
			ps.setLong(2, fieldValue);

			ps.executeUpdate();
		}
		finally {
			DataAccess.cleanUp(con, ps);
		}
	}

}