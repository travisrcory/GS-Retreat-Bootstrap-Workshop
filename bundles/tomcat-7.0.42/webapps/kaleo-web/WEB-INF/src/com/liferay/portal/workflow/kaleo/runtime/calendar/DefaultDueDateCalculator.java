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

package com.liferay.portal.workflow.kaleo.runtime.calendar;

import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.workflow.kaleo.definition.DelayDuration;
import com.liferay.portal.workflow.kaleo.definition.DurationScale;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Michael C. Han
 */
public class DefaultDueDateCalculator implements DueDateCalculator {


	public Date getDueDate(Date startDate, DelayDuration delayDuration) {
		Calendar cal = CalendarFactoryUtil.getCalendar();

		cal.setTime(startDate);

		DurationScale durationScale = delayDuration.getDurationScale();

		int duration = (int)Math.round(delayDuration.getDuration());

		if (durationScale.equals(DurationScale.SECOND)) {
			cal.add(Calendar.SECOND, duration);
		}
		else if (durationScale.equals(DurationScale.MINUTE)) {
			cal.add(Calendar.MINUTE, duration);
		}
		else if (durationScale.equals(DurationScale.HOUR)) {
			cal.add(Calendar.HOUR, duration);
		}
		else if (durationScale.equals(DurationScale.DAY)) {
			cal.add(Calendar.DAY_OF_YEAR, duration);
		}
		else if (durationScale.equals(DurationScale.MONTH)) {
			cal.add(Calendar.MONTH, duration);
		}
		else if (durationScale.equals(DurationScale.YEAR)) {
			cal.add(Calendar.YEAR, duration);
		}

		return cal.getTime();
	}

}