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

package com.liferay.opensocial.model.impl;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringUtil;

/**
 * @author Dennis Ju
 */
public class GadgetConstants {

	public static final String ADHOC_PREFIX = "ADHOC_";

	public static final String PUBLISHED_PREFIX = "PUBLISHED_";

	public static boolean isAdhocGadget(String gadgetKey) {
		return StringUtil.contains(gadgetKey, ADHOC_PREFIX);
	}

	public static boolean isPublishedGadget(String gadgetKey) {
		return StringUtil.contains(gadgetKey, PUBLISHED_PREFIX);
	}

	public static long toAdhocGadgetId(String gadgetKey) {
		String moduleIdString = StringUtil.remove(gadgetKey, ADHOC_PREFIX);

		return GetterUtil.getLong(moduleIdString);
	}

	public static String toAdhocGadgetKey(long moduleId) {
		return ADHOC_PREFIX.concat(String.valueOf(moduleId));
	}

	public static long toPublishedGadgetId(String gadgetKey) {
		String gadgetIdString = StringUtil.remove(gadgetKey, PUBLISHED_PREFIX);

		return GetterUtil.getLong(gadgetIdString);
	}

	public static String toPublishedGadgetKey(long gadgetId) {
		return PUBLISHED_PREFIX.concat(String.valueOf(gadgetId));
	}

}