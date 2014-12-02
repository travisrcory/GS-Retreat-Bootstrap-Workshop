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
 * Provides a wrapper for {@link CalendarResourceService}.
 *
 * @author Eduardo Lundgren
 * @see CalendarResourceService
 * @generated
 */
public class CalendarResourceServiceWrapper implements CalendarResourceService,
	ServiceWrapper<CalendarResourceService> {
	public CalendarResourceServiceWrapper(
		CalendarResourceService calendarResourceService) {
		_calendarResourceService = calendarResourceService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/

	public java.lang.String getBeanIdentifier() {
		return _calendarResourceService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/

	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_calendarResourceService.setBeanIdentifier(beanIdentifier);
	}


	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _calendarResourceService.invokeMethod(name, parameterTypes,
			arguments);
	}


	public com.liferay.calendar.model.CalendarResource addCalendarResource(
		long groupId, long classNameId, long classPK,
		java.lang.String classUuid, java.lang.String code,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		boolean active, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _calendarResourceService.addCalendarResource(groupId,
			classNameId, classPK, classUuid, code, nameMap, descriptionMap,
			active, serviceContext);
	}


	public com.liferay.calendar.model.CalendarResource deleteCalendarResource(
		long calendarResourceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _calendarResourceService.deleteCalendarResource(calendarResourceId);
	}


	public com.liferay.calendar.model.CalendarResource fetchCalendarResource(
		long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _calendarResourceService.fetchCalendarResource(classNameId,
			classPK);
	}


	public com.liferay.calendar.model.CalendarResource getCalendarResource(
		long calendarResourceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _calendarResourceService.getCalendarResource(calendarResourceId);
	}


	public java.util.List<com.liferay.calendar.model.CalendarResource> search(
		long companyId, long[] groupIds, long[] classNameIds,
		java.lang.String keywords, boolean active, boolean andOperator,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _calendarResourceService.search(companyId, groupIds,
			classNameIds, keywords, active, andOperator, start, end,
			orderByComparator);
	}


	public java.util.List<com.liferay.calendar.model.CalendarResource> search(
		long companyId, long[] groupIds, long[] classNameIds,
		java.lang.String code, java.lang.String name,
		java.lang.String description, boolean active, boolean andOperator,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _calendarResourceService.search(companyId, groupIds,
			classNameIds, code, name, description, active, andOperator, start,
			end, orderByComparator);
	}


	public int searchCount(long companyId, long[] groupIds,
		long[] classNameIds, java.lang.String keywords, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _calendarResourceService.searchCount(companyId, groupIds,
			classNameIds, keywords, active);
	}


	public int searchCount(long companyId, long[] groupIds,
		long[] classNameIds, java.lang.String code, java.lang.String name,
		java.lang.String description, boolean active, boolean andOperator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _calendarResourceService.searchCount(companyId, groupIds,
			classNameIds, code, name, description, active, andOperator);
	}


	public com.liferay.calendar.model.CalendarResource updateCalendarResource(
		long calendarResourceId,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		boolean active, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _calendarResourceService.updateCalendarResource(calendarResourceId,
			nameMap, descriptionMap, active, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CalendarResourceService getWrappedCalendarResourceService() {
		return _calendarResourceService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCalendarResourceService(
		CalendarResourceService calendarResourceService) {
		_calendarResourceService = calendarResourceService;
	}


	public CalendarResourceService getWrappedService() {
		return _calendarResourceService;
	}


	public void setWrappedService(
		CalendarResourceService calendarResourceService) {
		_calendarResourceService = calendarResourceService;
	}

	private CalendarResourceService _calendarResourceService;
}