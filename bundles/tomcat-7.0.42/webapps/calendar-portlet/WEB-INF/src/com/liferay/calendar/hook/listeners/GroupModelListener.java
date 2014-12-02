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
import com.liferay.portal.model.BaseModelListener;
import com.liferay.portal.model.Group;
import com.liferay.portal.util.PortalUtil;

/**
 * @author Marcellus Tavares
 */
public class GroupModelListener extends BaseModelListener<Group> {


	public void onAfterRemove(Group group) throws ModelListenerException {
		try {

			// Global calendar resource

			long classNameId = PortalUtil.getClassNameId(Group.class);

			CalendarResource calendarResource =
				CalendarResourceLocalServiceUtil.fetchCalendarResource(
					classNameId, group.getGroupId());

			if (calendarResource != null) {
				CalendarResourceLocalServiceUtil.deleteCalendarResource(
					calendarResource);
			}

			// Local calendar resources

			CalendarResourceLocalServiceUtil.deleteCalendarResources(
				group.getGroupId());
		}
		catch (Exception e) {
			throw new ModelListenerException(e);
		}
	}

}