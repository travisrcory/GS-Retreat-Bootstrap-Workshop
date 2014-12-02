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

package com.liferay.portal.workflow.kaleo.runtime.notification;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.notifications.NotificationEvent;
import com.liferay.portal.kernel.notifications.NotificationEventFactoryUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken;
import com.liferay.portal.workflow.kaleo.model.KaleoTaskInstanceToken;
import com.liferay.portal.workflow.kaleo.runtime.ExecutionContext;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * @author Michael C. Han
 */
public class UserNotificationMessageSender
	extends BaseNotificationSender implements NotificationSender {


	protected void doSendNotification(
			Set<NotificationRecipient> notificationRecipients,
			String defaultSubject, String notificationMessage,
			ExecutionContext executionContext)
		throws Exception {

		JSONObject jsonObject = populateJSONObject(
			notificationMessage, executionContext);

		NotificationEvent notificationEvent =
			NotificationEventFactoryUtil.createNotificationEvent(
				System.currentTimeMillis(), PortletKeys.MY_WORKFLOW_TASKS,
				jsonObject);

		notificationEvent.setDeliveryRequired(0);

		for (NotificationRecipient notificationRecipient :
				notificationRecipients) {

			if (notificationRecipient.getUserId() > 0) {
				UserNotificationEventLocalServiceUtil.addUserNotificationEvent(
					notificationRecipient.getUserId(), notificationEvent);
			}
		}
	}

	protected JSONObject populateJSONObject(
		String notificationMessage, ExecutionContext executionContext) {

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		Map<String, Serializable> workflowContext =
			executionContext.getWorkflowContext();

		jsonObject.put(
			WorkflowConstants.CONTEXT_COMPANY_ID,
			String.valueOf(
				workflowContext.get(WorkflowConstants.CONTEXT_COMPANY_ID)));
		jsonObject.put(
			WorkflowConstants.CONTEXT_ENTRY_CLASS_NAME,
			(String)workflowContext.get(
				WorkflowConstants.CONTEXT_ENTRY_CLASS_NAME));
		jsonObject.put(
			WorkflowConstants.CONTEXT_ENTRY_CLASS_PK,
			String.valueOf(
				workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK)));
		jsonObject.put(
			WorkflowConstants.CONTEXT_ENTRY_TYPE,
			(String)workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_TYPE));
		jsonObject.put(
			WorkflowConstants.CONTEXT_GROUP_ID,
			String.valueOf(
				workflowContext.get(WorkflowConstants.CONTEXT_GROUP_ID)));
		jsonObject.put(
			WorkflowConstants.CONTEXT_USER_ID,
			String.valueOf(
				workflowContext.get(WorkflowConstants.CONTEXT_USER_ID)));

		jsonObject.put("notificationMessage", notificationMessage);

		KaleoInstanceToken kaleoInstanceToken =
			executionContext.getKaleoInstanceToken();

		jsonObject.put(
			"workflowInstanceId", kaleoInstanceToken.getKaleoInstanceId());

		KaleoTaskInstanceToken kaleoTaskInstanceToken =
			executionContext.getKaleoTaskInstanceToken();

		jsonObject.put(
			"workflowTaskId",
			kaleoTaskInstanceToken.getKaleoTaskInstanceTokenId());

		return jsonObject;
	}

}