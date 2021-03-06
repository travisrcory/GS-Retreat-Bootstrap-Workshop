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

import com.liferay.calendar.model.CalendarNotificationTemplate;
import com.liferay.calendar.service.CalendarNotificationTemplateLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the CalendarNotificationTemplate service. Represents a row in the &quot;CalendarNotificationTemplate&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CalendarNotificationTemplateImpl}.
 * </p>
 *
 * @author Eduardo Lundgren
 * @see CalendarNotificationTemplateImpl
 * @see com.liferay.calendar.model.CalendarNotificationTemplate
 * @generated
 */
public abstract class CalendarNotificationTemplateBaseImpl
	extends CalendarNotificationTemplateModelImpl
	implements CalendarNotificationTemplate {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a calendar notification template model instance should use the {@link CalendarNotificationTemplate} interface instead.
	 */

	public void persist() throws SystemException {
		if (this.isNew()) {
			CalendarNotificationTemplateLocalServiceUtil.addCalendarNotificationTemplate(this);
		}
		else {
			CalendarNotificationTemplateLocalServiceUtil.updateCalendarNotificationTemplate(this);
		}
	}
}