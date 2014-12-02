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

package com.liferay.calendar.util;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.util.portlet.PortletProps;

/**
 * @author Eduardo Lundgren
 * @author Fabio Pezzutto
 * @author Andrea Di Giorgi
 * @author Bruno Basto
 */
public class PortletPropsValues {

	public static final int CALENDAR_COLOR_DEFAULT = Integer.decode(
		PortletProps.get(PortletPropsKeys.CALENDAR_COLOR_DEFAULT));

	public static final int CALENDAR_NOTIFICATION_CHECK_INTERVAL =
		GetterUtil.getInteger(
			PortletProps.get(
				PortletPropsKeys.CALENDAR_NOTIFICATION_CHECK_INTERVAL));

	public static final String CALENDAR_NOTIFICATION_DEFAULT_TYPE =
		PortletProps.get(PortletPropsKeys.CALENDAR_NOTIFICATION_DEFAULT_TYPE);

	public static final boolean CALENDAR_RESOURCE_FORCE_AUTOGENERATE_CODE =
		GetterUtil.getBoolean(
			PortletProps.get(
				PortletPropsKeys.CALENDAR_RESOURCE_FORCE_AUTOGENERATE_CODE));

	public static final boolean CALENDAR_SYNC_CALEVENTS_ON_STARTUP =
		GetterUtil.getBoolean(
			PortletProps.get(
				PortletPropsKeys.CALENDAR_SYNC_CALEVENTS_ON_STARTUP));

}