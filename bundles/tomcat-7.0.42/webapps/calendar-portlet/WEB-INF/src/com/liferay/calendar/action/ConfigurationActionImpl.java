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

package com.liferay.calendar.action;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;

/**
 * @author Eduardo Lundgren
 * @author Fabio Pezzutto
 */
public class ConfigurationActionImpl extends DefaultConfigurationAction {


	public void processAction(
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse)
		throws Exception {

		String tabs2 = ParamUtil.getString(actionRequest, "tabs2");

		if (tabs2.equals("user-settings")) {
			updateUserSettings(actionRequest, actionResponse);
		}

		super.processAction(portletConfig, actionRequest, actionResponse);
	}

	protected void updateUserSettings(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		PortletPreferences portletPreferences = actionRequest.getPreferences();

		int defaultDuration = ParamUtil.getInteger(
			actionRequest, "defaultDuration");
		String defaultView = ParamUtil.getString(actionRequest, "defaultView");
		boolean isoTimeFormat = ParamUtil.getBoolean(
			actionRequest, "isoTimeFormat");
		String timeZoneId = ParamUtil.getString(actionRequest, "timeZoneId");
		boolean usePortalTimeZone = ParamUtil.getBoolean(
			actionRequest, "usePortalTimeZone");
		int weekStartsOn = ParamUtil.getInteger(actionRequest, "weekStartsOn");

		portletPreferences.setValue(
			"defaultDuration", String.valueOf(defaultDuration));
		portletPreferences.setValue("defaultView", defaultView);
		portletPreferences.setValue(
			"isoTimeFormat", String.valueOf(isoTimeFormat));
		portletPreferences.setValue("timeZoneId", timeZoneId);
		portletPreferences.setValue(
			"usePortalTimeZone", String.valueOf(usePortalTimeZone));
		portletPreferences.setValue(
			"weekStartsOn", String.valueOf(weekStartsOn));

		portletPreferences.store();
	}

}