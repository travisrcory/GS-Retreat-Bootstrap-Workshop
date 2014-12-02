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

/**
 * @author Marcellus Tavares
 */
public enum CalendarDataFormat {

	ICAL("ics");

	public static CalendarDataFormat parse(String value) {
		if (ICAL.getValue().equals(value)) {
			return ICAL;
		}

		throw new IllegalArgumentException("Invalid value " + value);
	}

	public String getValue() {
		return _value;
	}


	public String toString() {
		return _value;
	}

	private CalendarDataFormat(String value) {
		_value = value;
	}

	private String _value;

}