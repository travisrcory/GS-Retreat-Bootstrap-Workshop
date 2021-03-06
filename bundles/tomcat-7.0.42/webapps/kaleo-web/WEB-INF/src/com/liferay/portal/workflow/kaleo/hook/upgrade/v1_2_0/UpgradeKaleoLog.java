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

package com.liferay.portal.workflow.kaleo.hook.upgrade.v1_2_0;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.workflow.kaleo.hook.upgrade.v1_2_0.util.KaleoLogTable;

import java.sql.SQLException;

/**
 * @author Kenneth Chang
 */
public class UpgradeKaleoLog extends UpgradeProcess {


	protected void doUpgrade() throws Exception {
		try {
			runSQL("alter_column_type KaleoLog comment TEXT null");
		}
		catch (SQLException sqle) {
			upgradeTable(
				KaleoLogTable.TABLE_NAME, KaleoLogTable.TABLE_COLUMNS,
				KaleoLogTable.TABLE_SQL_CREATE,
				KaleoLogTable.TABLE_SQL_ADD_INDEXES);
		}
	}

}