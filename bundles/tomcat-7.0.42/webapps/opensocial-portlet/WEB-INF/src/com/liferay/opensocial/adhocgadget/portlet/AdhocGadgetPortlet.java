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

package com.liferay.opensocial.adhocgadget.portlet;

import com.liferay.opensocial.gadget.portlet.BaseGadgetPortlet;
import com.liferay.opensocial.model.Gadget;
import com.liferay.opensocial.shindig.util.ShindigUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Portlet;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;

/**
 * @author Michael Young
 */
public class AdhocGadgetPortlet extends BaseGadgetPortlet {


	protected Gadget getGadget(RenderRequest renderRequest) throws Exception {
		Portlet portlet = (Portlet)renderRequest.getAttribute(
			WebKeys.RENDER_PORTLET);

		PortletPreferences portletPreferences =
			PortletPreferencesFactoryUtil.getPortletSetup(
				renderRequest, portlet.getPortletId());

		return ShindigUtil.getGadget(portletPreferences);
	}

}