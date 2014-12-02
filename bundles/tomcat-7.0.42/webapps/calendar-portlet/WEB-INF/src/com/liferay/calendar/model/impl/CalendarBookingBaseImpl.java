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

package com.liferay.calendar.model.impl;

import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.service.CalendarBookingLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the CalendarBooking service. Represents a row in the &quot;CalendarBooking&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CalendarBookingImpl}.
 * </p>
 *
 * @author Eduardo Lundgren
 * @see CalendarBookingImpl
 * @see com.liferay.calendar.model.CalendarBooking
 * @generated
 */
public abstract class CalendarBookingBaseImpl extends CalendarBookingModelImpl
	implements CalendarBooking {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a calendar booking model instance should use the {@link CalendarBooking} interface instead.
	 */

	public void persist() throws SystemException {
		if (this.isNew()) {
			CalendarBookingLocalServiceUtil.addCalendarBooking(this);
		}
		else {
			CalendarBookingLocalServiceUtil.updateCalendarBooking(this);
		}
	}
}