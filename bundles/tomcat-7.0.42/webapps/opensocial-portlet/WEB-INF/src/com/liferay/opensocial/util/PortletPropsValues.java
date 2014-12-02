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

package com.liferay.opensocial.util;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.util.portlet.PortletProps;

/**
 * @author Michael Young
 */
public class PortletPropsValues {

	public static final int PUBSUB_URI_LOAD_TIMEOUT = GetterUtil.getInteger(
		PortletProps.get(PortletPropsKeys.PUBSUB_URI_LOAD_TIMEOUT));

	public static final boolean SHINDIG_JS_DEBUG = GetterUtil.getBoolean(
		PortletProps.get(PortletPropsKeys.SHINDIG_JS_DEBUG));

	public static final boolean SHINDIG_NO_CACHE = GetterUtil.getBoolean(
		PortletProps.get(PortletPropsKeys.SHINDIG_NO_CACHE));

	public static final String SHINDIG_OAUTH_CALLBACK_URL =
		GetterUtil.getString(
			PortletProps.get(PortletPropsKeys.SHINDIG_OAUTH_CALLBACK_URL));

	public static final String SHINDIG_OAUTH_KEY_FILE_NAME =
		GetterUtil.getString(
			PortletProps.get(PortletPropsKeys.SHINDIG_OAUTH_KEY_FILE_NAME));

	public static final String SHINDIG_OAUTH_KEY_NAME = GetterUtil.getString(
		PortletProps.get(PortletPropsKeys.SHINDIG_OAUTH_KEY_NAME));

}