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

package com.liferay.marketplace.util;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.util.portlet.PortletProps;

/**
 * @author Ryan Park
 */
public class PortletPropsValues {

	public static final boolean MARKETPLACE_STORE_ENABLED =
		GetterUtil.getBoolean(
			PortletProps.get(PortletPropsKeys.MARKETPLACE_STORE_ENABLED), true);

	public static final String MARKETPLACE_URL_LOGOUT = PortletProps.get(
		PortletPropsKeys.MARKETPLACE_URL_LOGOUT);

}