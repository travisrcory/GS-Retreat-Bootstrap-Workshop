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

import com.liferay.portal.kernel.upgrade.util.UpgradeTable;
import com.liferay.portal.model.ServiceComponent;

import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class KaleoTaskAssignmentUpgradeTableListener
	extends BaseKaleoUpgradeTableListener {


	public void onAfterUpdateTable(
			ServiceComponent previousServiceComponent,
			UpgradeTable upgradeTable)
		throws Exception {

		if (_keyValueMap == null) {
			return;
		}

		Map<Long, Long> keyValueMap = _keyValueMap;

		_keyValueMap = null;

		updateKeyValueMap(
			keyValueMap, "com.liferay.portal.workflow.kaleo.model.KaleoTask",
			"KaleoTaskAssignment", "kaleoTaskAssignmentId");
	}


	public void onBeforeUpdateTable(
			ServiceComponent previousServiceComponent,
			UpgradeTable upgradeTable)
		throws Exception {

		if (!isFixAutoUpgrade(previousServiceComponent)) {
			return;
		}

		_keyValueMap = getKeyValueMap(
			"KaleoTaskAssignment", "kaleoTaskAssignmentId", "kaleoTaskId");
	}

	private Map<Long, Long> _keyValueMap;

}