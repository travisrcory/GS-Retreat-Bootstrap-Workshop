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

/**
 * @author Eduardo Lundgren
 */
public interface CalendarBookingFinder {
	public int countByKeywords(long companyId, long[] groupIds,
		long[] calendarIds, long[] calendarResourceIds,
		long parentCalendarBookingId, java.lang.String keywords,
		long startTime, long endTime, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByC_G_C_C_P_T_D_L_S_E_S(long companyId, long[] groupIds,
		long[] calendarIds, long[] calendarResourceIds,
		long parentCalendarBookingId, java.lang.String title,
		java.lang.String description, java.lang.String location,
		long startTime, long endTime, int[] statuses, boolean andOperator)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByC_G_C_C_P_T_D_L_S_E_S(long companyId, long[] groupIds,
		long[] calendarIds, long[] calendarResourceIds,
		long parentCalendarBookingId, java.lang.String[] titles,
		java.lang.String[] descriptions, java.lang.String[] locations,
		long startTime, long endTime, int[] statuses, boolean andOperator)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int filterCountByKeywords(long companyId, long[] groupIds,
		long[] calendarIds, long[] calendarResourceIds,
		long parentCalendarBookingId, java.lang.String keywords,
		long startTime, long endTime, int[] statuses)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int filterCountByC_G_C_C_P_T_D_L_S_E_S(long companyId,
		long[] groupIds, long[] calendarIds, long[] calendarResourceIds,
		long parentCalendarBookingId, java.lang.String title,
		java.lang.String description, java.lang.String location,
		long startTime, long endTime, int[] statuses, boolean andOperator)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int filterCountByC_G_C_C_P_T_D_L_S_E_S(long companyId,
		long[] groupIds, long[] calendarIds, long[] calendarResourceIds,
		long parentCalendarBookingId, java.lang.String[] titles,
		java.lang.String[] descriptions, java.lang.String[] locations,
		long startTime, long endTime, int[] statuses, boolean andOperator)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.liferay.calendar.model.CalendarBooking> filterFindByKeywords(
		long companyId, long[] groupIds, long[] calendarIds,
		long[] calendarResourceIds, long parentCalendarBookingId,
		java.lang.String keywords, long startTime, long endTime,
		boolean recurring, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.liferay.calendar.model.CalendarBooking> filterFindByC_G_C_C_P_T_D_L_S_E_S(
		long companyId, long[] groupIds, long[] calendarIds,
		long[] calendarResourceIds, long parentCalendarBookingId,
		java.lang.String title, java.lang.String description,
		java.lang.String location, long startTime, long endTime,
		boolean recurring, int[] statuses, boolean andOperator, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.liferay.calendar.model.CalendarBooking> filterFindByC_G_C_C_P_T_D_L_S_E_S(
		long companyId, long[] groupIds, long[] calendarIds,
		long[] calendarResourceIds, long parentCalendarBookingId,
		java.lang.String[] titles, java.lang.String[] descriptions,
		java.lang.String[] locations, long startTime, long endTime,
		boolean recurring, int[] statuses, boolean andOperator, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.liferay.calendar.model.CalendarBooking> findByFutureReminders(
		long startTime)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.liferay.calendar.model.CalendarBooking> findByKeywords(
		long companyId, long[] groupIds, long[] calendarIds,
		long[] calendarResourceIds, long parentCalendarBookingId,
		java.lang.String keywords, long startTime, long endTime,
		boolean recurring, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.liferay.calendar.model.CalendarBooking> findByC_G_C_C_P_T_D_L_S_E_S(
		long companyId, long[] groupIds, long[] calendarIds,
		long[] calendarResourceIds, long parentCalendarBookingId,
		java.lang.String title, java.lang.String description,
		java.lang.String location, long startTime, long endTime,
		boolean recurring, int[] statuses, boolean andOperator, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.liferay.calendar.model.CalendarBooking> findByC_G_C_C_P_T_D_L_S_E_S(
		long companyId, long[] groupIds, long[] calendarIds,
		long[] calendarResourceIds, long parentCalendarBookingId,
		java.lang.String[] titles, java.lang.String[] descriptions,
		java.lang.String[] locations, long startTime, long endTime,
		boolean recurring, int[] statuses, boolean andOperator, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;
}