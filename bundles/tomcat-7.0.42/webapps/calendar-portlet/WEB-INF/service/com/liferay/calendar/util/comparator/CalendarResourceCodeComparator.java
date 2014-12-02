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

package com.liferay.calendar.util.comparator;

import com.liferay.calendar.model.CalendarResource;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * @author Eduardo Lundgren
 * @author Fabio Pezzutto
 */
public class CalendarResourceCodeComparator extends OrderByComparator {

	public static final String ORDER_BY_ASC =
		"CalendarResource.code_, CalendarResource.name ASC";

	public static final String ORDER_BY_DESC =
		"CalendarResource.code_, CalendarResource.name DESC";

	public static final String[] ORDER_BY_FIELDS = {"code_", "name"};

	public CalendarResourceCodeComparator() {
		this(false);
	}

	public CalendarResourceCodeComparator(boolean ascending) {
		_ascending = ascending;
	}


	public int compare(Object obj1, Object obj2) {
		CalendarResource calendarResource1 = (CalendarResource)obj1;
		CalendarResource calendarResource2 = (CalendarResource)obj2;

		String code1 = calendarResource1.getCode();
		String code2 = calendarResource2.getCode();

		int value = code1.compareTo(code2);

		if (value == 0) {
			String name1 = calendarResource1.getName();
			String name2 = calendarResource2.getName();

			value = name1.compareTo(name2);
		}

		if (_ascending) {
			return value;
		}
		else {
			return -value;
		}
	}


	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}


	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}


	public boolean isAscending() {
		return _ascending;
	}

	private boolean _ascending;

}