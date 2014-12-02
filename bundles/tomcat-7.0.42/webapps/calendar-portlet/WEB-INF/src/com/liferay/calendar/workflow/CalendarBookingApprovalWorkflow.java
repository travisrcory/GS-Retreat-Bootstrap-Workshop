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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.ServiceContext;

import java.util.List;
import java.util.Map;

/**
 * @author Michael C. Han
 * @author Eduardo Lundgren
 */
public interface CalendarBookingApprovalWorkflow {

	public Map<Long, List<String>> getActionNames(
			PermissionChecker permissionChecker, long[] calendarBookingIds)
		throws PortalException, SystemException;

	public void invokeTransition(
			long userId, long calendarBookingId, int status,
			ServiceContext serviceContext)
		throws PortalException, SystemException;

	public void startWorkflow(
			long userId, long calendarBookingId, ServiceContext serviceContext)
		throws PortalException, SystemException;

}