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

package com.liferay.opensocial.shindig.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Brian Wing Shun Chan
 */
public class HttpServletRequestThreadLocal {

	public static HttpServletRequest getHttpServletRequest() {
		return _httpServletRequest.get();
	}

	public static void setHttpServletRequest(
		HttpServletRequest httpServletRequest) {

		_httpServletRequest.set(httpServletRequest);
	}

	private static ThreadLocal<HttpServletRequest> _httpServletRequest =
		new ThreadLocal<HttpServletRequest>();

}