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

package com.liferay.calendar.service.persistence;

import com.liferay.calendar.model.Calendar;
import com.liferay.calendar.service.CalendarLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Eduardo Lundgren
 * @generated
 */
public abstract class CalendarActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public CalendarActionableDynamicQuery() throws SystemException {
		setBaseLocalService(CalendarLocalServiceUtil.getService());
		setClass(Calendar.class);

		setClassLoader(com.liferay.calendar.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("calendarId");
	}
}