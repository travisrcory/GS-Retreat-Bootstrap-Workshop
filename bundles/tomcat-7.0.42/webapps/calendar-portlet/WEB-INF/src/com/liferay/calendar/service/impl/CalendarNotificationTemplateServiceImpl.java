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

package com.liferay.calendar.service.impl;

import com.liferay.calendar.model.CalendarNotificationTemplate;
import com.liferay.calendar.notification.NotificationTemplateType;
import com.liferay.calendar.notification.NotificationType;
import com.liferay.calendar.service.base.CalendarNotificationTemplateServiceBaseImpl;
import com.liferay.calendar.service.permission.CalendarPermission;
import com.liferay.calendar.util.ActionKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

/**
 * @author Marcellus Tavares
 */
public class CalendarNotificationTemplateServiceImpl
	extends CalendarNotificationTemplateServiceBaseImpl {


	public CalendarNotificationTemplate addCalendarNotificationTemplate(
			long calendarId, NotificationType notificationType,
			String notificationTypeSettings,
			NotificationTemplateType notificationTemplateType, String subject,
			String body, ServiceContext serviceContext)
		throws PortalException, SystemException {

		CalendarPermission.check(
			getPermissionChecker(), calendarId, ActionKeys.UPDATE);

		return calendarNotificationTemplateLocalService.
			addCalendarNotificationTemplate(
				getUserId(), calendarId, notificationType,
				notificationTypeSettings, notificationTemplateType, subject,
				body, serviceContext);
	}


	public CalendarNotificationTemplate updateCalendarNotificationTemplate(
			long calendarNotificationTemplateId,
			String notificationTypeSettings, String subject, String body,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		CalendarNotificationTemplate calendarNotificationTemplate =
			calendarNotificationTemplatePersistence.findByPrimaryKey(
				calendarNotificationTemplateId);

		CalendarPermission.check(
			getPermissionChecker(),
			calendarNotificationTemplate.getCalendarId(), ActionKeys.UPDATE);

		return calendarNotificationTemplateLocalService.
			updateCalendarNotificationTemplate(
				calendarNotificationTemplateId, notificationTypeSettings,
				subject, body, serviceContext);
	}

}