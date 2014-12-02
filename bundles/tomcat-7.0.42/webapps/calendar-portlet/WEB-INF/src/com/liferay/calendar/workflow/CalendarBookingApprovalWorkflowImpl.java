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

package com.liferay.calendar.workflow;

import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.model.CalendarResource;
import com.liferay.calendar.service.CalendarBookingLocalServiceUtil;
import com.liferay.calendar.service.permission.CalendarPermission;
import com.liferay.calendar.util.ActionKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.ServiceContext;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Michael C. Han
 * @author Eduardo Lundgren
 */
public class CalendarBookingApprovalWorkflowImpl
	implements CalendarBookingApprovalWorkflow {


	public Map<Long, List<String>> getActionNames(
			PermissionChecker permissionChecker, long[] calendarBookingIds)
		throws PortalException, SystemException {

		Map<Long, List<String>> actionNames =
			new LinkedHashMap<Long, List<String>>();

		for (long calendarBookingId : calendarBookingIds) {
			CalendarBooking calendarBooking =
				CalendarBookingLocalServiceUtil.getCalendarBooking(
					calendarBookingId);

			List<String> transitions = new ArrayList<String>();

			if (CalendarPermission.contains(
					permissionChecker, calendarBooking.getCalendarId(),
					ActionKeys.MANAGE_BOOKINGS)) {

				if (calendarBooking.getStatus() !=
						CalendarBookingWorkflowConstants.STATUS_APPROVED) {

					transitions.add("accept");
				}

				transitions.add("decline");
			}

			actionNames.put(calendarBookingId, transitions);
		}

		return actionNames;
	}


	public void invokeTransition(
			long userId, long calendarBookingId, int status,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		if (status == CalendarBookingWorkflowConstants.STATUS_PENDING) {
			CalendarBooking calendarBooking =
				CalendarBookingLocalServiceUtil.getCalendarBooking(
					calendarBookingId);

			if (isAutoApproveCalendarBooking(userId, calendarBooking)) {
				CalendarBookingLocalServiceUtil.updateStatus(
					userId, calendarBookingId,
					CalendarBookingWorkflowConstants.STATUS_APPROVED,
					serviceContext);
			}
			else {
				CalendarBookingLocalServiceUtil.updateStatus(
					userId, calendarBooking.getCalendarBookingId(),
					CalendarBookingWorkflowConstants.STATUS_PENDING,
					serviceContext);
			}
		}
		else {
			CalendarBookingLocalServiceUtil.updateStatus(
				userId, calendarBookingId, status, serviceContext);
		}
	}


	public void startWorkflow(
			long userId, long calendarBookingId, ServiceContext serviceContext)
		throws PortalException, SystemException {

		invokeTransition(
			userId, calendarBookingId,
			CalendarBookingWorkflowConstants.STATUS_PENDING, serviceContext);
	}

	protected boolean isAutoApproveCalendarBooking(
			long userId, CalendarBooking calendarBooking)
		throws PortalException, SystemException {

		if (calendarBooking.getStatus() ==
				CalendarBookingWorkflowConstants.STATUS_DENIED) {

			return false;
		}

		if (userId != calendarBooking.getUserId()) {
			return false;
		}

		CalendarResource calendarResource =
			calendarBooking.getCalendarResource();

		if (userId != calendarResource.getUserId()) {
			return false;
		}

		return true;
	}

}