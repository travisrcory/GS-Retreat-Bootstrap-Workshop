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

package com.liferay.calendar.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.pacl.permission.PortalRuntimePermission;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Marcellus Tavares
 */
public class CalendarDataHandlerFactory {

	public static CalendarDataHandler getCalendarDataHandler(
			CalendarDataFormat calendarDataFormat)
		throws PortalException {

		CalendarDataHandler calendarDataHandler = _calendarDataHandlers.get(
			calendarDataFormat);

		if (calendarDataHandler == null) {
			throw new PortalException(
				"Invalid format type " + calendarDataFormat);
		}

		return calendarDataHandler;
	}

	public void setCalendarDataHandlers(
		Map<String, CalendarDataHandler> calendarDataHandlers) {

		PortalRuntimePermission.checkSetBeanProperty(getClass());

		_calendarDataHandlers =
			new HashMap<CalendarDataFormat, CalendarDataHandler>();

		for (Map.Entry<String, CalendarDataHandler> entry :
				calendarDataHandlers.entrySet()) {

			CalendarDataFormat calendarDataFormat = CalendarDataFormat.parse(
				entry.getKey());

			_calendarDataHandlers.put(calendarDataFormat, entry.getValue());
		}
	}

	private static Map<CalendarDataFormat, CalendarDataHandler>
		_calendarDataHandlers;

}