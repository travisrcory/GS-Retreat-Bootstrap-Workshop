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

import com.liferay.calendar.model.CalendarResource;
import com.liferay.calendar.service.base.CalendarResourceServiceBaseImpl;
import com.liferay.calendar.service.permission.CalendarPortletPermission;
import com.liferay.calendar.service.permission.CalendarResourcePermission;
import com.liferay.calendar.util.ActionKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author Eduardo Lundgren
 * @author Fabio Pezzutto
 * @author Andrea Di Giorgi
 */
public class CalendarResourceServiceImpl
	extends CalendarResourceServiceBaseImpl {


	public CalendarResource addCalendarResource(
			long groupId, long classNameId, long classPK, String classUuid,
			String code, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, boolean active,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		CalendarPortletPermission.check(
			getPermissionChecker(), groupId, ActionKeys.ADD_RESOURCE);

		return calendarResourceLocalService.addCalendarResource(
			getUserId(), groupId, classNameId, classPK, classUuid, code,
			nameMap, descriptionMap, active, serviceContext);
	}


	public CalendarResource deleteCalendarResource(long calendarResourceId)
		throws PortalException, SystemException {

		CalendarResourcePermission.check(
			getPermissionChecker(), calendarResourceId, ActionKeys.DELETE);

		return calendarResourceLocalService.deleteCalendarResource(
			calendarResourceId);
	}


	public CalendarResource fetchCalendarResource(
			long classNameId, long classPK)
		throws PortalException, SystemException {

		CalendarResource calendarResource =
			calendarResourcePersistence.fetchByC_C(classNameId, classPK);

		if (calendarResource == null) {
			return null;
		}

		CalendarResourcePermission.check(
			getPermissionChecker(), calendarResource, ActionKeys.VIEW);

		return calendarResource;
	}


	public CalendarResource getCalendarResource(long calendarResourceId)
		throws PortalException, SystemException {

		CalendarResourcePermission.check(
			getPermissionChecker(), calendarResourceId, ActionKeys.VIEW);

		return calendarResourcePersistence.findByPrimaryKey(calendarResourceId);
	}


	public List<CalendarResource> search(
			long companyId, long[] groupIds, long[] classNameIds,
			String keywords, boolean active, boolean andOperator, int start,
			int end, OrderByComparator orderByComparator)
		throws SystemException {

		return calendarResourceFinder.filterFindByKeywords(
			companyId, groupIds, classNameIds, keywords, active, start, end,
			orderByComparator);
	}


	public List<CalendarResource> search(
			long companyId, long[] groupIds, long[] classNameIds, String code,
			String name, String description, boolean active,
			boolean andOperator, int start, int end,
			OrderByComparator orderByComparator)
		throws SystemException {

		return calendarResourceFinder.filterFindByC_G_C_C_N_D_A(
			companyId, groupIds, classNameIds, code, name, description, active,
			andOperator, start, end, orderByComparator);
	}


	public int searchCount(
			long companyId, long[] groupIds, long[] classNameIds,
			String keywords, boolean active)
		throws SystemException {

		return calendarResourceFinder.filterCountByKeywords(
			companyId, groupIds, classNameIds, keywords, active);
	}


	public int searchCount(
			long companyId, long[] groupIds, long[] classNameIds, String code,
			String name, String description, boolean active,
			boolean andOperator)
		throws SystemException {

		return calendarResourceFinder.filterCountByC_G_C_C_N_D_A(
			companyId, groupIds, classNameIds, code, name, description, active,
			andOperator);
	}


	public CalendarResource updateCalendarResource(
			long calendarResourceId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, boolean active,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		CalendarResourcePermission.check(
			getPermissionChecker(), calendarResourceId, ActionKeys.UPDATE);

		return calendarResourceLocalService.updateCalendarResource(
			calendarResourceId, nameMap, descriptionMap, active,
			serviceContext);
	}

}