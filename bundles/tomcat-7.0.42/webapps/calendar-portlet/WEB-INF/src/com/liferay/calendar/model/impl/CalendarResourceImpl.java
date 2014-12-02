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

package com.liferay.calendar.model.impl;

import com.liferay.calendar.model.Calendar;
import com.liferay.calendar.model.CalendarResource;
import com.liferay.calendar.service.CalendarLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;

import java.util.List;

/**
 * @author Eduardo Lundgren
 * @author Marcellus Tavares
 */
public class CalendarResourceImpl extends CalendarResourceBaseImpl {


	public List<Calendar> getCalendars() throws SystemException {
		List<Calendar> calendars =
			CalendarLocalServiceUtil.getCalendarResourceCalendars(
				getGroupId(), getCalendarResourceId());

		return calendars;
	}


	public Calendar getDefaultCalendar() throws SystemException {
		List<Calendar> calendars =
			CalendarLocalServiceUtil.getCalendarResourceCalendars(
				getGroupId(), getCalendarResourceId(), true);

		if (!calendars.isEmpty()) {
			return calendars.get(0);
		}

		return null;
	}


	public long getDefaultCalendarId() throws SystemException {
		Calendar calendar = getDefaultCalendar();

		if (calendar != null) {
			return calendar.getCalendarId();
		}

		return 0;
	}


	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(CalendarResource.class.getName()));
	}


	public boolean isGroup() {
		long groupClassNameId = PortalUtil.getClassNameId(Group.class);

		if (groupClassNameId == getClassNameId()) {
			return true;
		}

		return false;
	}


	public boolean isUser() {
		long userClassNameId = PortalUtil.getClassNameId(User.class);

		if (userClassNameId == getClassNameId()) {
			return true;
		}

		return false;
	}

}