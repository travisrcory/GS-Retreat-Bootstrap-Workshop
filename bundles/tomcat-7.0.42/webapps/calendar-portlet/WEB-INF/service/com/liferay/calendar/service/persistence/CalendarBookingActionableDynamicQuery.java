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

import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.service.CalendarBookingLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Eduardo Lundgren
 * @generated
 */
public abstract class CalendarBookingActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public CalendarBookingActionableDynamicQuery() throws SystemException {
		setBaseLocalService(CalendarBookingLocalServiceUtil.getService());
		setClass(CalendarBooking.class);

		setClassLoader(com.liferay.calendar.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("calendarBookingId");
	}
}