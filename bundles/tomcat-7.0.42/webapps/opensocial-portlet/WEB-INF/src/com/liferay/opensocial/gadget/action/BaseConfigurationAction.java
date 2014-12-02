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

package com.liferay.opensocial.gadget.action;

import com.liferay.opensocial.model.Gadget;
import com.liferay.opensocial.shindig.util.ShindigUtil;
import com.liferay.opensocial.util.WebKeys;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.Layout;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.expando.service.ExpandoValueServiceUtil;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.shindig.gadgets.spec.GadgetSpec;
import org.apache.shindig.gadgets.spec.UserPref;

/**
 * @author Michael Young
 */
public abstract class BaseConfigurationAction
	extends DefaultConfigurationAction {

	protected void doProcessAction(
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		Layout layout = themeDisplay.getLayout();

		JSONObject userPrefsJSONObject = JSONFactoryUtil.createJSONObject();

		Map<String, UserPref> userPrefs = getUserPrefs(
			portletConfig, actionRequest);

		for (UserPref userPref : userPrefs.values()) {
			String name = userPref.getName();

			String value = ParamUtil.getString(actionRequest, name);

			userPrefsJSONObject.put(name, value);
		}

		String namespace = ShindigUtil.getPortletResourceNamespace(
			actionRequest, themeDisplay);

		String columnName = ShindigUtil.getColumnUserPrefs(
			namespace, themeDisplay);

		ExpandoValueServiceUtil.addValue(
			themeDisplay.getCompanyId(), Layout.class.getName(),
			ShindigUtil.getTableOpenSocial(), columnName, layout.getPlid(),
			userPrefsJSONObject.toString());

		String portletResource = ParamUtil.getString(
			actionRequest, "portletResource");

		SessionMessages.add(
			actionRequest,
			PortalUtil.getPortletId(actionRequest) +
				SessionMessages.KEY_SUFFIX_REFRESH_PORTLET,
			portletResource);

		SessionMessages.add(
			actionRequest,
			PortalUtil.getPortletId(actionRequest) +
				SessionMessages.KEY_SUFFIX_UPDATED_CONFIGURATION);
	}

	protected void doRender(
			PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse)
		throws Exception {

		Map<String, UserPref> userPrefs = getUserPrefs(
			portletConfig, renderRequest);

		renderRequest.setAttribute(WebKeys.USER_PREFS, userPrefs);
	}

	protected abstract Gadget getGadget(
			PortletConfig portletConfig, PortletRequest portletRequest)
		throws Exception;

	protected Map<String, UserPref> getUserPrefs(
			PortletConfig portletConfig, PortletRequest portletRequest)
		throws Exception {

		Gadget gadget = getGadget(portletConfig, portletRequest);

		GadgetSpec gadgetSpec = ShindigUtil.getGadgetSpec(gadget.getUrl());

		return gadgetSpec.getUserPrefs();
	}

	protected boolean hasUserPrefs(
		PortletConfig portletConfig, PortletRequest portletRequest) {

		try {
			Map<String, UserPref> userPrefs = getUserPrefs(
				portletConfig, portletRequest);

			return ShindigUtil.hasUserPrefs(userPrefs);
		}
		catch (Exception e) {
			return false;
		}
	}

}