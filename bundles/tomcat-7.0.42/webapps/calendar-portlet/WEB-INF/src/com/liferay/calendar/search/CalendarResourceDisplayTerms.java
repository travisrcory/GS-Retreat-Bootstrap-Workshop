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

package com.liferay.calendar.search;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletRequest;

/**
 * @author Eduardo Lundgren
 * @author Fabio Pezzutto
 */
public class CalendarResourceDisplayTerms extends DisplayTerms {

	public static final String ACTIVE = "active";

	public static final String CODE = "code";

	public static final String DESCRIPTION = "description";

	public static final String NAME = "name";

	public static final String SCOPE = "scope";

	public CalendarResourceDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);

		active = ParamUtil.getBoolean(portletRequest, ACTIVE, true);
		code = ParamUtil.getString(portletRequest, CODE);
		description = ParamUtil.getString(portletRequest, DESCRIPTION);
		name = ParamUtil.getString(portletRequest, NAME);
		scope = ParamUtil.getLong(portletRequest, SCOPE);
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public long getScope() {
		return scope;
	}

	public boolean isActive() {
		return active;
	}

	protected boolean active;
	protected String code;
	protected String description;
	protected String name;
	protected long scope;

}