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

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the CalendarNotificationTemplate service. Represents a row in the &quot;CalendarNotificationTemplate&quot; database table, with each column mapped to a property of this class.
 *
 * @author Eduardo Lundgren
 * @see CalendarNotificationTemplateModel
 * @see com.liferay.calendar.model.impl.CalendarNotificationTemplateImpl
 * @see com.liferay.calendar.model.impl.CalendarNotificationTemplateModelImpl
 * @generated
 */
public interface CalendarNotificationTemplate
	extends CalendarNotificationTemplateModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.calendar.model.impl.CalendarNotificationTemplateImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public com.liferay.portal.kernel.util.UnicodeProperties getNotificationTypeSettingsProperties();

	public void setTypeSettingsProperties(
		com.liferay.portal.kernel.util.UnicodeProperties notificationTypeSettingsProperties);
}