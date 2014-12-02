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

package com.liferay.calendar.recurrence;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author Marcellus Tavares
 */
public class Recurrence {

	public void addExceptionDate(Calendar calendar) {
		_exceptionJCalendars.add(calendar);
	}

	public int getCount() {
		return _count;
	}

	public List<Calendar> getExceptionJCalendars() {
		return _exceptionJCalendars;
	}

	public Frequency getFrequency() {
		return _frequency;
	}

	public int getInterval() {
		return _interval;
	}

	public Calendar getUntilJCalendar() {
		return _untilJCalendar;
	}

	public List<Weekday> getWeekdays() {
		return _weekdays;
	}

	public void setCount(int count) {
		_count = count;
	}

	public void setExceptionJCalendars(List<Calendar> exceptionJCalendars) {
		_exceptionJCalendars = exceptionJCalendars;
	}

	public void setFrequency(Frequency frequency) {
		_frequency = frequency;
	}

	public void setInterval(int interval) {
		_interval = interval;
	}

	public void setUntilJCalendar(Calendar untilJCalendar) {
		_untilJCalendar = untilJCalendar;
	}

	public void setWeekdays(List<Weekday> weekdays) {
		_weekdays = weekdays;
	}

	private int _count;
	private List<Calendar> _exceptionJCalendars = new ArrayList<Calendar>();
	private Frequency _frequency;
	private int _interval;
	private Calendar _untilJCalendar;
	private List<Weekday> _weekdays;

}