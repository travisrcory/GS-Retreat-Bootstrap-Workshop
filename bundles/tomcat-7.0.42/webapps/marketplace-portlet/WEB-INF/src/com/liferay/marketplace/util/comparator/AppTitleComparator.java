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

package com.liferay.marketplace.util.comparator;

import com.liferay.marketplace.model.App;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringUtil;

/**
 * @author Ryan Park
 */
public class AppTitleComparator extends OrderByComparator {

	public static final String ORDER_BY_ASC = "title ASC";

	public static final String ORDER_BY_DESC = "title DESC";

	public static final String[] ORDER_BY_FIELDS = {"title"};

	public AppTitleComparator() {
		this(true);
	}

	public AppTitleComparator(boolean asc) {
		_asc = asc;
	}


	public int compare(Object obj1, Object obj2) {
		App app1 = (App)obj1;
		App app2 = (App)obj2;

		int value = StringUtil.toLowerCase(app1.getTitle()).compareTo(
			StringUtil.toLowerCase(app2.getTitle()));

		if (_asc) {
			return value;
		}
		else {
			return -value;
		}
	}


	public String getOrderBy() {
		if (_asc) {
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
		return _asc;
	}

	private boolean _asc;

}