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

import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Time;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author Eduardo Lundgren
 * @author Peter Shin
 * @author Fabio Pezzutto
 */
public class JCalendarUtil {

	public static final long DAY = Time.HOUR * 24;

	public static final long HOUR = Time.MINUTE * 60;

	public static final long MINUTE = Time.SECOND * 60;

	public static final long MONTH = Time.DAY * 30;

	public static final long SECOND = 1000;

	public static long getDaysBetween(
		Calendar startTimeJCalendar, Calendar endTimeJCalendar) {

		startTimeJCalendar = toMidnightJCalendar(startTimeJCalendar);
		endTimeJCalendar = toMidnightJCalendar(endTimeJCalendar);

		long startTime = startTimeJCalendar.getTimeInMillis();
		long endTime = endTimeJCalendar.getTimeInMillis();

		return (endTime - startTime) / DAY;
	}

	public static Calendar getJCalendar(
		int year, int month, int day, int hour, int minutes, int seconds,
		int milliseconds, TimeZone timeZone) {

		Calendar jCalendar = CalendarFactoryUtil.getCalendar(timeZone);

		jCalendar.set(Calendar.YEAR, year);
		jCalendar.set(Calendar.MONTH, month);
		jCalendar.set(Calendar.DATE, day);
		jCalendar.set(Calendar.HOUR_OF_DAY, hour);
		jCalendar.set(Calendar.MINUTE, minutes);
		jCalendar.set(Calendar.SECOND, seconds);
		jCalendar.set(Calendar.MILLISECOND, milliseconds);

		return jCalendar;
	}

	public static Calendar getJCalendar(long time) {
		return getJCalendar(time, _utcTimeZone);
	}

	public static Calendar getJCalendar(long time, TimeZone timeZone) {
		Calendar jCalendar = CalendarFactoryUtil.getCalendar(timeZone);

		jCalendar.setTimeInMillis(time);

		return jCalendar;
	}

	public static int getTimeZoneOffset(TimeZone timeZone) {
		int offset = timeZone.getRawOffset();

		boolean inDaylightTime = timeZone.inDaylightTime(new Date());

		if (inDaylightTime) {
			offset += timeZone.getDSTSavings();
		}

		return offset;
	}

	public static Calendar toLastHourJCalendar(Calendar jCalendar) {
		Calendar lastHourJCalendar = (Calendar)jCalendar.clone();

		lastHourJCalendar.set(Calendar.HOUR_OF_DAY, 23);
		lastHourJCalendar.set(Calendar.MINUTE, 59);
		lastHourJCalendar.set(Calendar.SECOND, 59);
		lastHourJCalendar.set(Calendar.MILLISECOND, 999);

		return lastHourJCalendar;
	}

	public static Calendar toMidnightJCalendar(Calendar jCalendar) {
		Calendar midnightJCalendar = (Calendar)jCalendar.clone();

		midnightJCalendar.set(Calendar.HOUR_OF_DAY, 0);
		midnightJCalendar.set(Calendar.MINUTE, 0);
		midnightJCalendar.set(Calendar.SECOND, 0);
		midnightJCalendar.set(Calendar.MILLISECOND, 0);

		return midnightJCalendar;
	}

	private static TimeZone _utcTimeZone = TimeZone.getTimeZone(StringPool.UTC);

}