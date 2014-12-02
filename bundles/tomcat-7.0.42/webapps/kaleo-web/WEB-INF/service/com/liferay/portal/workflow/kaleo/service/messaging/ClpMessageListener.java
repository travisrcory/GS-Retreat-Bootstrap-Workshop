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

package com.liferay.portal.workflow.kaleo.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.workflow.kaleo.service.ClpSerializer;
import com.liferay.portal.workflow.kaleo.service.KaleoActionLocalServiceUtil;
import com.liferay.portal.workflow.kaleo.service.KaleoConditionLocalServiceUtil;
import com.liferay.portal.workflow.kaleo.service.KaleoDefinitionLocalServiceUtil;
import com.liferay.portal.workflow.kaleo.service.KaleoDefinitionServiceUtil;
import com.liferay.portal.workflow.kaleo.service.KaleoInstanceLocalServiceUtil;
import com.liferay.portal.workflow.kaleo.service.KaleoInstanceTokenLocalServiceUtil;
import com.liferay.portal.workflow.kaleo.service.KaleoLogLocalServiceUtil;
import com.liferay.portal.workflow.kaleo.service.KaleoNodeLocalServiceUtil;
import com.liferay.portal.workflow.kaleo.service.KaleoNotificationLocalServiceUtil;
import com.liferay.portal.workflow.kaleo.service.KaleoNotificationRecipientLocalServiceUtil;
import com.liferay.portal.workflow.kaleo.service.KaleoTaskAssignmentInstanceLocalServiceUtil;
import com.liferay.portal.workflow.kaleo.service.KaleoTaskAssignmentLocalServiceUtil;
import com.liferay.portal.workflow.kaleo.service.KaleoTaskInstanceTokenLocalServiceUtil;
import com.liferay.portal.workflow.kaleo.service.KaleoTaskLocalServiceUtil;
import com.liferay.portal.workflow.kaleo.service.KaleoTimerInstanceTokenLocalServiceUtil;
import com.liferay.portal.workflow.kaleo.service.KaleoTimerLocalServiceUtil;
import com.liferay.portal.workflow.kaleo.service.KaleoTransitionLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}


	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			KaleoActionLocalServiceUtil.clearService();

			KaleoConditionLocalServiceUtil.clearService();

			KaleoDefinitionLocalServiceUtil.clearService();

			KaleoDefinitionServiceUtil.clearService();
			KaleoInstanceLocalServiceUtil.clearService();

			KaleoInstanceTokenLocalServiceUtil.clearService();

			KaleoLogLocalServiceUtil.clearService();

			KaleoNodeLocalServiceUtil.clearService();

			KaleoNotificationLocalServiceUtil.clearService();

			KaleoNotificationRecipientLocalServiceUtil.clearService();

			KaleoTaskLocalServiceUtil.clearService();

			KaleoTaskAssignmentLocalServiceUtil.clearService();

			KaleoTaskAssignmentInstanceLocalServiceUtil.clearService();

			KaleoTaskInstanceTokenLocalServiceUtil.clearService();

			KaleoTimerLocalServiceUtil.clearService();

			KaleoTimerInstanceTokenLocalServiceUtil.clearService();

			KaleoTransitionLocalServiceUtil.clearService();
		}
	}
}