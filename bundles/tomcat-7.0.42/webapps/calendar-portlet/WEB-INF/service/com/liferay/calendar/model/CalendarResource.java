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
 * The extended model interface for the CalendarResource service. Represents a row in the &quot;CalendarResource&quot; database table, with each column mapped to a property of this class.
 *
 * @author Eduardo Lundgren
 * @see CalendarResourceModel
 * @see com.liferay.calendar.model.impl.CalendarResourceImpl
 * @see com.liferay.calendar.model.impl.CalendarResourceModelImpl
 * @generated
 */
public interface CalendarResource extends CalendarResourceModel,
	PermissionedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.calendar.model.impl.CalendarResourceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public java.util.List<com.liferay.calendar.model.Calendar> getCalendars()
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.calendar.model.Calendar getDefaultCalendar()
		throws com.liferay.portal.kernel.exception.SystemException;

	public long getDefaultCalendarId()
		throws com.liferay.portal.kernel.exception.SystemException;

	public boolean isGroup();

	public boolean isUser();
}