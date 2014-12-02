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

package com.liferay.opensocial.shindig.servlet;

import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.BasePortalLifecycle;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author Michael Young
 */
public class GuiceServletContextListener extends BasePortalLifecycle
	implements ServletContextListener {


	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		_guiceServletContextListener.contextDestroyed(servletContextEvent);
	}


	public void contextInitialized(ServletContextEvent servletContextEvent) {
		_initializedServletContextEvent = servletContextEvent;

		registerPortalLifecycle();
	}


	protected void doPortalDestroy() throws Exception {
	}


	protected void doPortalInit() throws Exception {
		ClassLoader portletClassLoader =
			PortletClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portletClassLoader) {
				currentThread.setContextClassLoader(portletClassLoader);
			}

			_guiceServletContextListener.contextInitialized(
				_initializedServletContextEvent);
		}
		finally {
			if (contextClassLoader != portletClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	private ServletContextListener _guiceServletContextListener =
		new org.apache.shindig.common.servlet.GuiceServletContextListener();
	private ServletContextEvent _initializedServletContextEvent;

}