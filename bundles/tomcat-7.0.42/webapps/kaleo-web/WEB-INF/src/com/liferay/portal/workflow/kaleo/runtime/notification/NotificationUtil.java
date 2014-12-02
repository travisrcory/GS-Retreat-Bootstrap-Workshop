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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.workflow.kaleo.definition.ExecutionType;
import com.liferay.portal.workflow.kaleo.model.KaleoNotification;
import com.liferay.portal.workflow.kaleo.model.KaleoNotificationRecipient;
import com.liferay.portal.workflow.kaleo.runtime.ExecutionContext;
import com.liferay.portal.workflow.kaleo.service.KaleoNotificationLocalServiceUtil;
import com.liferay.portal.workflow.kaleo.service.KaleoNotificationRecipientLocalServiceUtil;

import java.util.List;

/**
 * @author Michael C. Han
 */
public class NotificationUtil {

	public static void sendKaleoNotifications(
			String kaleoClassName, long kaleoClassPK,
			ExecutionType executionType, ExecutionContext executionContext)
		throws PortalException, SystemException {

		List<KaleoNotification> kaleoNotifications =
			KaleoNotificationLocalServiceUtil.getKaleoNotifications(
				kaleoClassName, kaleoClassPK, executionType.getValue());

		for (KaleoNotification kaleoNotification : kaleoNotifications) {
			_sendKaleoNotification(kaleoNotification, executionContext);
		}
	}

	private static void _sendKaleoNotification(
			KaleoNotification kaleoNotification,
			ExecutionContext executionContext)
		throws PortalException, SystemException {

		NotificationMessageGenerator notificationMessageGenerator =
			NotificationMessageGeneratorFactory.getNotificationMessageGenerator(
				kaleoNotification.getTemplateLanguage());

		String notificationMessage =
			notificationMessageGenerator.generateMessage(
				kaleoNotification.getKaleoClassName(),
				kaleoNotification.getKaleoClassPK(),
				kaleoNotification.getName(),
				kaleoNotification.getTemplateLanguage(),
				kaleoNotification.getTemplate(), executionContext);

		String notificationSubject = kaleoNotification.getDescription();

		String[] notificationTypes = StringUtil.split(
			kaleoNotification.getNotificationTypes());

		List<KaleoNotificationRecipient> kaleoNotificationRecipient =
			KaleoNotificationRecipientLocalServiceUtil.
				getKaleoNotificationRecipients(
					kaleoNotification.getKaleoNotificationId());

		for (String notificationType : notificationTypes) {
			NotificationSender notificationSender =
				NotificationSenderFactory.getNotificationSender(
					notificationType);

			notificationSender.sendNotification(
				kaleoNotificationRecipient, notificationSubject,
				notificationMessage, executionContext);
		}
	}

}