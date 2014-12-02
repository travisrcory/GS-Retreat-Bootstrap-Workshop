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

package com.liferay.webform.util;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.util.portlet.PortletProps;

/**
 * @author Brian Wing Shun Chan
 */
public class PortletPropsValues {

	public static final String EMAIL_FROM_ADDRESS = GetterUtil.getString(
		PortletProps.get(PortletPropsKeys.EMAIL_FROM_ADDRESS));

	public static final String EMAIL_FROM_NAME = GetterUtil.getString(
		PortletProps.get(PortletPropsKeys.EMAIL_FROM_NAME));

	public static final boolean VALIDATION_SCRIPT_ENABLED =
		GetterUtil.getBoolean(
			PortletProps.get(PortletPropsKeys.VALIDATION_SCRIPT_ENABLED));

}