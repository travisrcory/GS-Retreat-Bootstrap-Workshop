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

package com.liferay.calendar.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CalendarNotificationTemplateService}.
 *
 * @author Eduardo Lundgren
 * @see CalendarNotificationTemplateService
 * @generated
 */
public class CalendarNotificationTemplateServiceWrapper
	implements CalendarNotificationTemplateService,
		ServiceWrapper<CalendarNotificationTemplateService> {
	public CalendarNotificationTemplateServiceWrapper(
		CalendarNotificationTemplateService calendarNotificationTemplateService) {
		_calendarNotificationTemplateService = calendarNotificationTemplateService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/

	public java.lang.String getBeanIdentifier() {
		return _calendarNotificationTemplateService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/

	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_calendarNotificationTemplateService.setBeanIdentifier(beanIdentifier);
	}


	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _calendarNotificationTemplateService.invokeMethod(name,
			parameterTypes, arguments);
	}


	public com.liferay.calendar.model.CalendarNotificationTemplate addCalendarNotificationTemplate(
		long calendarId,
		com.liferay.calendar.notification.NotificationType notificationType,
		java.lang.String notificationTypeSettings,
		com.liferay.calendar.notification.NotificationTemplateType notificationTemplateType,
		java.lang.String subject, java.lang.String body,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _calendarNotificationTemplateService.addCalendarNotificationTemplate(calendarId,
			notificationType, notificationTypeSettings,
			notificationTemplateType, subject, body, serviceContext);
	}


	public com.liferay.calendar.model.CalendarNotificationTemplate updateCalendarNotificationTemplate(
		long calendarNotificationTemplateId,
		java.lang.String notificationTypeSettings, java.lang.String subject,
		java.lang.String body,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _calendarNotificationTemplateService.updateCalendarNotificationTemplate(calendarNotificationTemplateId,
			notificationTypeSettings, subject, body, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CalendarNotificationTemplateService getWrappedCalendarNotificationTemplateService() {
		return _calendarNotificationTemplateService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCalendarNotificationTemplateService(
		CalendarNotificationTemplateService calendarNotificationTemplateService) {
		_calendarNotificationTemplateService = calendarNotificationTemplateService;
	}


	public CalendarNotificationTemplateService getWrappedService() {
		return _calendarNotificationTemplateService;
	}


	public void setWrappedService(
		CalendarNotificationTemplateService calendarNotificationTemplateService) {
		_calendarNotificationTemplateService = calendarNotificationTemplateService;
	}

	private CalendarNotificationTemplateService _calendarNotificationTemplateService;
}