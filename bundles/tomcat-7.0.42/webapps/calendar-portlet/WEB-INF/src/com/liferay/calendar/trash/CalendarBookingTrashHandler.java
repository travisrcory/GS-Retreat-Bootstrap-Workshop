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

package com.liferay.calendar.trash;

import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.service.CalendarBookingLocalServiceUtil;
import com.liferay.calendar.service.permission.CalendarPermission;
import com.liferay.calendar.util.ActionKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.trash.BaseTrashHandler;
import com.liferay.portal.security.permission.PermissionChecker;

/**
 * @author Pier Paolo Ramon
 */
public class CalendarBookingTrashHandler extends BaseTrashHandler {


	public void deleteTrashEntry(long classPK)
		throws PortalException, SystemException {

		CalendarBookingLocalServiceUtil.deleteCalendarBooking(classPK);
	}


	public String getClassName() {
		return CalendarBooking.class.getName();
	}


	public boolean isInTrash(long classPK)
		throws PortalException, SystemException {

		CalendarBooking calendarBooking =
			CalendarBookingLocalServiceUtil.getCalendarBooking(classPK);

		return calendarBooking.isInTrash();
	}


	public boolean isRestorable(long classPK)
		throws PortalException, SystemException {

		CalendarBooking calendarBooking =
			CalendarBookingLocalServiceUtil.getCalendarBooking(classPK);

		if (calendarBooking.isMasterBooking()) {
			return true;
		}

		return false;
	}


	public void restoreTrashEntry(long userId, long classPK)
		throws PortalException, SystemException {

		CalendarBookingLocalServiceUtil.restoreCalendarBookingFromTrash(
			userId, classPK);
	}


	protected boolean hasPermission(
			PermissionChecker permissionChecker, long classPK, String actionId)
		throws PortalException, SystemException {

		CalendarBooking calendarBooking =
			CalendarBookingLocalServiceUtil.getCalendarBooking(classPK);

		return CalendarPermission.contains(
			permissionChecker, calendarBooking.getCalendar(),
			ActionKeys.MANAGE_BOOKINGS);
	}

}