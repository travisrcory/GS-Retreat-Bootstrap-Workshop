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

package com.liferay.calendar.model;

import com.liferay.portal.model.PermissionedModel;

/**
 * The extended model interface for the CalendarBooking service. Represents a row in the &quot;CalendarBooking&quot; database table, with each column mapped to a property of this class.
 *
 * @author Eduardo Lundgren
 * @see CalendarBookingModel
 * @see com.liferay.calendar.model.impl.CalendarBookingImpl
 * @see com.liferay.calendar.model.impl.CalendarBookingModelImpl
 * @generated
 */
public interface CalendarBooking extends CalendarBookingModel, PermissionedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.calendar.model.impl.CalendarBookingImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public com.liferay.calendar.model.Calendar getCalendar()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.calendar.model.CalendarResource getCalendarResource()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.liferay.calendar.model.CalendarBooking> getChildCalendarBookings()
		throws com.liferay.portal.kernel.exception.SystemException;

	public long getDuration();

	public com.liferay.calendar.notification.NotificationType getFirstReminderNotificationType();

	public com.liferay.calendar.model.CalendarBooking getParentCalendarBooking()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.calendar.recurrence.Recurrence getRecurrenceObj();

	public com.liferay.calendar.notification.NotificationType getSecondReminderNotificationType();

	public boolean isMasterBooking();

	public boolean isRecurring();
}