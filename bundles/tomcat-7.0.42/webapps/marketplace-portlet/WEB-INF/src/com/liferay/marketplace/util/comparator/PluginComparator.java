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

package com.liferay.marketplace.util.comparator;

import com.liferay.portal.kernel.servlet.ServletContextPool;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.LayoutTemplate;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.model.Theme;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.util.Comparator;
import java.util.Locale;

import javax.servlet.ServletContext;

/**
 * @author Ryan Park
 */
public class PluginComparator implements Comparator, Serializable {

	public PluginComparator() {
		_locale = LocaleUtil.getDefault();
		_servletContext = ServletContextPool.get(PortalUtil.getPathContext());
	}

	public PluginComparator(ServletContext servletContext, Locale locale) {
		_locale = locale;
		_servletContext = servletContext;
	}


	public int compare(Object plugin1, Object plugin2) {
		String name1 = _getName(plugin1);
		String name2 = _getName(plugin2);

		return name1.compareTo(name2);
	}

	private String _getName(Object plugin) {
		String name = StringPool.BLANK;

		if (plugin instanceof LayoutTemplate) {
			LayoutTemplate layoutTemplate = (LayoutTemplate)plugin;

			name = layoutTemplate.getName();
		}
		else if (plugin instanceof Portlet) {
			Portlet portlet = (Portlet)plugin;

			name = PortalUtil.getPortletTitle(
				portlet, _servletContext, _locale);
		}
		else if (plugin instanceof Theme) {
			Theme theme = (Theme)plugin;

			name = theme.getName();
		}

		return StringUtil.toLowerCase(name);
	}

	private Locale _locale;
	private ServletContext _servletContext;

}