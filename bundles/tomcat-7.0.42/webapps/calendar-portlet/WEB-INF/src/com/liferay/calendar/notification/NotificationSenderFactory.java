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

package com.liferay.calendar.notification;

import com.liferay.portal.kernel.exception.PortalException;

import java.util.Map;

/**
 * @author Eduardo Lundgren
 */
public class NotificationSenderFactory {

	public static NotificationSender getNotificationSender(
			String notificationType)
		throws PortalException {

		NotificationSender notificationSender = _notificationSenders.get(
			notificationType);

		if (notificationSender == null) {
			throw new PortalException(
				"Invalid notification type " + notificationType);
		}

		return notificationSender;
	}

	public void setNotificationSenders(
		Map<String, NotificationSender> notificationSenders) {

		_notificationSenders = notificationSenders;
	}

	private static Map<String, NotificationSender> _notificationSenders;

}