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

package com.liferay.calendar.hook.listeners;

import com.liferay.calendar.model.CalendarResource;
import com.liferay.calendar.service.CalendarResourceLocalServiceUtil;
import com.liferay.portal.ModelListenerException;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.model.BaseModelListener;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;

import java.util.Locale;

/**
 * @author Antonio Junior
 */
public class UserModelListener extends BaseModelListener<User> {


	public void onAfterUpdate(User user) throws ModelListenerException {
		try {
			long classNameId = PortalUtil.getClassNameId(User.class);

			CalendarResource calendarResource =
				CalendarResourceLocalServiceUtil.fetchCalendarResource(
					classNameId, user.getUserId());

			if (calendarResource == null) {
				return;
			}

			Locale locale = LocaleUtil.getDefault();

			calendarResource.setName(user.getFullName(), locale);

			CalendarResourceLocalServiceUtil.updateCalendarResource(
				calendarResource);
		}
		catch (Exception e) {
			throw new ModelListenerException(e);
		}
	}

}