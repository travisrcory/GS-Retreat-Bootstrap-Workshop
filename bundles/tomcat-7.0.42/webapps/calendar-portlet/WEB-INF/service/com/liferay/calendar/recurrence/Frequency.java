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
public enum Frequency {

	DAILY("DAILY"), MONTHLY("MONTHLY"), WEEKLY("WEEKLY"), YEARLY("YEARLY");

	public static Frequency parse(String value) {
		if (DAILY.getValue().equals(value)) {
			return DAILY;
		}
		else if (MONTHLY.getValue().equals(value)) {
			return MONTHLY;
		}
		else if (WEEKLY.getValue().equals(value)) {
			return WEEKLY;
		}
		else if (YEARLY.getValue().equals(value)) {
			return YEARLY;
		}

		throw new IllegalArgumentException("Invalid value " + value);
	}

	public String getValue() {
		return _value;
	}


	public String toString() {
		return _value;
	}

	private Frequency(String value) {
		_value = value;
	}

	private String _value;

}