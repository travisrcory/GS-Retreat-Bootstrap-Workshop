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

package com.liferay.portal.workflow.kaleo.hook.upgrade;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.workflow.kaleo.hook.upgrade.v1_2_0.UpgradeKaleoLog;
import com.liferay.portal.workflow.kaleo.hook.upgrade.v1_2_0.UpgradeKaleoNotificationRecipient;

/**
 * @author Michael C. Han
 */
public class UpgradeProcess_1_2_0 extends UpgradeProcess {


	public int getThreshold() {
		return 120;
	}


	protected void doUpgrade() throws Exception {
		upgrade(UpgradeKaleoLog.class);
		upgrade(UpgradeKaleoNotificationRecipient.class);
	}

}