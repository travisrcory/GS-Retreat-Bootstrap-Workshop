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

package com.liferay.portal.workflow.kaleo.runtime.util;

import com.liferay.portal.kernel.servlet.PluginContextListener;
import com.liferay.portal.kernel.servlet.ServletContextPool;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

/**
 * @author Michael C. Han
 */
public class ClassLoaderUtil {

	public static ClassLoader[] getClassLoaders(String[] servletContextNames) {
		List<ClassLoader> classLoaders = new ArrayList<ClassLoader>(
			servletContextNames.length + 2);

		classLoaders.add(_getContextClassLoader());
		classLoaders.add(PortalClassLoaderUtil.getClassLoader());

		for (String servletContextName : servletContextNames) {
			ServletContext servletContext = ServletContextPool.get(
				servletContextName);

			ClassLoader pluginClassLoader =
				(ClassLoader)servletContext.getAttribute(
					PluginContextListener.PLUGIN_CLASS_LOADER);

			classLoaders.add(pluginClassLoader);
		}

		return classLoaders.toArray(new ClassLoader[classLoaders.size()]);
	}

	private static ClassLoader _getContextClassLoader() {
		Thread currentThread = Thread.currentThread();

		return currentThread.getContextClassLoader();
	}

}