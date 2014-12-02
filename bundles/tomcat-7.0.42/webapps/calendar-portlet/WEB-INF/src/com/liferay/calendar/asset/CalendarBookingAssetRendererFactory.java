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

package com.liferay.calendar.asset;

import com.liferay.calendar.model.Calendar;
import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.model.CalendarResource;
import com.liferay.calendar.service.CalendarBookingLocalServiceUtil;
import com.liferay.calendar.service.permission.CalendarPermission;
import com.liferay.calendar.util.ActionKeys;
import com.liferay.calendar.util.CalendarResourceUtil;
import com.liferay.calendar.util.PortletKeys;
import com.liferay.calendar.util.WebKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

/**
 * @author Fabio Pezzutto
 * @author Eduardo Lundgren
 */
public class CalendarBookingAssetRendererFactory
	extends BaseAssetRendererFactory {

	public static final String TYPE = "calendar";


	public AssetRenderer getAssetRenderer(long classPK, int type)
		throws PortalException, SystemException {

		CalendarBooking calendarBooking =
			CalendarBookingLocalServiceUtil.getCalendarBooking(classPK);

		CalendarBookingAssetRenderer calendarBookingAssetRenderer =
			new CalendarBookingAssetRenderer(calendarBooking);

		calendarBookingAssetRenderer.setAssetRendererType(type);

		return calendarBookingAssetRenderer;
	}


	public String getClassName() {
		return CalendarBooking.class.getName();
	}


	public String getType() {
		return TYPE;
	}


	public PortletURL getURLAdd(
			LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse)
		throws PortalException, SystemException {

		ThemeDisplay themeDisplay =
			(ThemeDisplay)liferayPortletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		CalendarResource calendarResource =
			CalendarResourceUtil.getGroupCalendarResource(
				liferayPortletRequest, themeDisplay.getScopeGroupId());

		if (calendarResource == null) {
			return null;
		}

		Calendar calendar = calendarResource.getDefaultCalendar();

		if (!CalendarPermission.contains(
				themeDisplay.getPermissionChecker(), calendar.getCalendarId(),
				ActionKeys.ADD_CALENDAR)) {

			return null;
		}

		PortletURL portletURL = PortletURLFactoryUtil.create(
			liferayPortletRequest, PortletKeys.CALENDAR,
			getControlPanelPlid(themeDisplay), PortletRequest.RENDER_PHASE);

		portletURL.setParameter("mvcPath", "/edit_calendar_booking.jsp");
		portletURL.setParameter(
			"calendarId", String.valueOf(calendar.getCalendarId()));

		return portletURL;
	}


	public boolean hasPermission(
			PermissionChecker permissionChecker, long classPK, String actionId)
		throws Exception {

		CalendarBooking calendarBooking =
			CalendarBookingLocalServiceUtil.getCalendarBooking(classPK);

		if (actionId.equals(ActionKeys.DELETE) ||
			actionId.equals(ActionKeys.UPDATE)) {

			actionId = ActionKeys.MANAGE_BOOKINGS;
		}

		return CalendarPermission.contains(
			permissionChecker, calendarBooking.getCalendarId(), actionId);
	}


	public boolean isLinkable() {
		return _LINKABLE;
	}


	protected String getIconPath(ThemeDisplay themeDisplay) {
		return themeDisplay.getPathThemeImages() + "/common/date.png";
	}

	private static final boolean _LINKABLE = true;

}