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
 * Provides a wrapper for {@link CalendarImporterLocalService}.
 *
 * @author Eduardo Lundgren
 * @see CalendarImporterLocalService
 * @generated
 */
public class CalendarImporterLocalServiceWrapper
	implements CalendarImporterLocalService,
		ServiceWrapper<CalendarImporterLocalService> {
	public CalendarImporterLocalServiceWrapper(
		CalendarImporterLocalService calendarImporterLocalService) {
		_calendarImporterLocalService = calendarImporterLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/

	public java.lang.String getBeanIdentifier() {
		return _calendarImporterLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/

	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_calendarImporterLocalService.setBeanIdentifier(beanIdentifier);
	}


	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _calendarImporterLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}


	public void importCalEvent(
		com.liferay.portlet.calendar.model.CalEvent calEvent)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_calendarImporterLocalService.importCalEvent(calEvent);
	}


	public void importCalEvents()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_calendarImporterLocalService.importCalEvents();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CalendarImporterLocalService getWrappedCalendarImporterLocalService() {
		return _calendarImporterLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCalendarImporterLocalService(
		CalendarImporterLocalService calendarImporterLocalService) {
		_calendarImporterLocalService = calendarImporterLocalService;
	}


	public CalendarImporterLocalService getWrappedService() {
		return _calendarImporterLocalService;
	}


	public void setWrappedService(
		CalendarImporterLocalService calendarImporterLocalService) {
		_calendarImporterLocalService = calendarImporterLocalService;
	}

	private CalendarImporterLocalService _calendarImporterLocalService;
}