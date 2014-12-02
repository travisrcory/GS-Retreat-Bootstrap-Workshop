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

package com.liferay.calendar.service.permission;

import com.liferay.calendar.model.CalendarResource;
import com.liferay.calendar.service.CalendarResourceLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

/**
 * @author Eduardo Lundgren
 * @author Michael C. Han
 */
public class CalendarResourcePermission {

	public static void check(
			PermissionChecker permissionChecker,
			CalendarResource calendarResource, String actionId)
		throws PortalException {

		if (!contains(permissionChecker, calendarResource, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(
			PermissionChecker permissionChecker, long calendarResourceId,
			String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, calendarResourceId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(
		PermissionChecker permissionChecker, CalendarResource calendarResource,
		String actionId) {

		if (permissionChecker.hasOwnerPermission(
				calendarResource.getCompanyId(),
				CalendarResource.class.getName(),
				calendarResource.getCalendarResourceId(),
				calendarResource.getUserId(), actionId)) {

			return true;
		}

		return permissionChecker.hasPermission(
			calendarResource.getGroupId(), CalendarResource.class.getName(),
			calendarResource.getCalendarResourceId(), actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long calendarResourceId,
			String actionId)
		throws PortalException, SystemException {

		CalendarResource calendarResource =
			CalendarResourceLocalServiceUtil.getCalendarResource(
				calendarResourceId);

		return contains(permissionChecker, calendarResource, actionId);
	}

}