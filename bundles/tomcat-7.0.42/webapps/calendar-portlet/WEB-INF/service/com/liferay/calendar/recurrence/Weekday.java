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

/**
 * @author Marcellus Tavares
 */
public enum Weekday {

	SUNDAY("SU"), MONDAY("MO"), TUESDAY("TU"), WEDNESDAY("WE"), THURSDAY("TH"),
	FRIDAY("FR"), SATURDAY("SA");

	public static Weekday parse(String value) {
		if (SUNDAY.getValue().equals(value)) {
			return SUNDAY;
		}
		else if (MONDAY.getValue().equals(value)) {
			return MONDAY;
		}
		else if (TUESDAY.getValue().equals(value)) {
			return TUESDAY;
		}
		else if (WEDNESDAY.getValue().equals(value)) {
			return WEDNESDAY;
		}
		else if (THURSDAY.getValue().equals(value)) {
			return THURSDAY;
		}
		else if (FRIDAY.getValue().equals(value)) {
			return FRIDAY;
		}
		else if (SATURDAY.getValue().equals(value)) {
			return SATURDAY;
		}

		throw new IllegalArgumentException("Invalid value " + value);
	}

	public int getPosition() {
		return _position;
	}

	public String getValue() {
		return _value;
	}

	public void setPosition(int position) {
		if ((position < -53) || (position > 53)) {
			throw new IllegalArgumentException();
		}

		_position = position;
	}


	public String toString() {
		return _value;
	}

	private Weekday(String value) {
		_value = value;
	}

	private int _position;
	private String _value;

}