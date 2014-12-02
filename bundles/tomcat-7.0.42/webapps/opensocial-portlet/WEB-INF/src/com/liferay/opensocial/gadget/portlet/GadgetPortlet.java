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

package com.liferay.opensocial.gadget.portlet;

import com.liferay.opensocial.gadget.action.ConfigurationActionImpl;
import com.liferay.opensocial.model.Gadget;
import com.liferay.opensocial.shindig.util.ShindigUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.theme.PortletDisplay;
import com.liferay.portal.theme.ThemeDisplay;

import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;

import org.apache.shindig.gadgets.spec.GadgetSpec;

/**
 * @author Michael Young
 */
public class GadgetPortlet extends BaseGadgetPortlet {


	protected Gadget getGadget(RenderRequest renderRequest) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		PortletConfig portletConfig = getPortletConfig();

		return ShindigUtil.getGadget(
			portletConfig.getPortletName(), themeDisplay.getCompanyId());
	}


	protected void overrideConfiguration(
			GadgetSpec gadgetSpec, Portlet portlet,
			PortletDisplay portletDisplay)
		throws Exception {

		String urlConfiguration = portletDisplay.getURLConfiguration();

		if (ShindigUtil.hasUserPrefs(gadgetSpec)) {
			portlet.setConfigurationActionClass(
				ConfigurationActionImpl.class.getName());

			urlConfiguration = urlConfiguration.replaceAll(
				"edit_permissions", "edit_configuration");
		}
		else {
			portlet.setConfigurationActionClass(null);

			urlConfiguration = urlConfiguration.replaceAll(
				"edit_configuration", "edit_permissions");
		}

		portletDisplay.setURLConfiguration(urlConfiguration);
	}

}