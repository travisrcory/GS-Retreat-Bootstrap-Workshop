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

package com.liferay.portal.workflow.kaleo.definition;

import com.liferay.portal.kernel.scheduler.CronText;

/**
 * @author Michael C. Han
 */
public enum DurationScale {

	DAY("day"), HOUR("hour"), MINUTE("minute"), MONTH("month"),
	SECOND("second"), WEEK("week"), YEAR("year");

	public static DurationScale parse(String value) {
		if (DAY.getValue().equals(value)) {
			return DAY;
		}
		else if (HOUR.getValue().equals(value)) {
			return HOUR;
		}
		else if (MINUTE.getValue().equals(value)) {
			return MINUTE;
		}
		else if (MONTH.getValue().equals(value)) {
			return MONTH;
		}
		else if (SECOND.getValue().equals(value)) {
			return SECOND;
		}
		else if (YEAR.getValue().equals(value)) {
			return YEAR;
		}

		throw new IllegalArgumentException("Invalid value " + value);
	}

	public int getIntegerValue() {
		if (equals(DAY)) {
			return CronText.DAILY_FREQUENCY;
		}
		else if (equals(HOUR)) {
			return CronText.HOURLY_FREQUENCY;
		}
		else if (equals(MINUTE)) {
			return CronText.MINUTELY_FREQUENCY;
		}
		else if (equals(MONTH)) {
			return CronText.MONTHLY_FREQUENCY;
		}
		else if (equals(WEEK)) {
			return CronText.WEEKLY_FREQUENCY;
		}
		else {
			return CronText.YEARLY_FREQUENCY;
		}
	}

	public String getValue() {
		return _value;
	}


	public String toString() {
		return _value;
	}

	private DurationScale(String value) {
		_value = value;
	}

	private String _value;

}