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

package com.liferay.portal.workflow.kaleo.forms;

import com.liferay.portal.NoSuchModelException;

/**
 * @author Marcellus Tavares
 */
public class NoSuchKaleoProcessLinkException extends NoSuchModelException {

	public NoSuchKaleoProcessLinkException() {
		super();
	}

	public NoSuchKaleoProcessLinkException(String msg) {
		super(msg);
	}

	public NoSuchKaleoProcessLinkException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchKaleoProcessLinkException(Throwable cause) {
		super(cause);
	}

}