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

import com.liferay.calendar.model.Calendar;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * @author Eduardo Lundgren
 * @author Fabio Pezzutto
 */
public class CalendarNameComparator extends OrderByComparator {

	public static final String ORDER_BY_ASC = "Calendar.name ASC";

	public static final String ORDER_BY_DESC = "Calendar.name DESC";

	public static final String[] ORDER_BY_FIELDS = {"name"};

	public CalendarNameComparator() {
		this(false);
	}

	public CalendarNameComparator(boolean ascending) {
		_ascending = ascending;
	}


	public int compare(Object obj1, Object obj2) {
		Calendar calendar1 = (Calendar)obj1;
		Calendar calendar2 = (Calendar)obj2;

		String name1 = calendar1.getName();
		String name2 = calendar2.getName();

		int value = name1.compareTo(name2);

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