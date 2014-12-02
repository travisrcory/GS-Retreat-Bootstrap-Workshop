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

import com.liferay.calendar.model.Calendar;
import com.liferay.calendar.service.CalendarLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

/**
 * @author Eduardo Lundgren
 * @author Fabio Pezzutto
 */
public class CalendarPermission {

	public static void check(
			PermissionChecker permissionChecker, Calendar calendar,
			String actionId)
		throws PortalException {

		if (!contains(permissionChecker, calendar, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(
			PermissionChecker permissionChecker, long calendarId,
			String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, calendarId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(
		PermissionChecker permissionChecker, Calendar calendar,
		String actionId) {

		if (permissionChecker.hasOwnerPermission(
				calendar.getCompanyId(), Calendar.class.getName(),
				calendar.getCalendarId(), calendar.getUserId(), actionId)) {

			return true;
		}

		return permissionChecker.hasPermission(
			calendar.getGroupId(), Calendar.class.getName(),
			calendar.getCalendarId(), actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long calendarId,
			String actionId)
		throws PortalException, SystemException {

		Calendar calendar = CalendarLocalServiceUtil.getCalendar(calendarId);

		return contains(permissionChecker, calendar, actionId);
	}

}