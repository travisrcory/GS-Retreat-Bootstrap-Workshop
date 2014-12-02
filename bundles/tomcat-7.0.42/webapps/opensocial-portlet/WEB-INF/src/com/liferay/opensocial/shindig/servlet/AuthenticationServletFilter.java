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

import com.google.inject.Injector;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.UnavailableException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shindig.common.servlet.GuiceServletContextListener;

/**
 * @author Igor Spasic
 */
public class AuthenticationServletFilter
	extends org.apache.shindig.auth.AuthenticationServletFilter {


	public void doFilter(
			ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain)
		throws IOException, ServletException {

		if (injector == null) {
			HttpServletRequest request = (HttpServletRequest)servletRequest;

			HttpSession session = request.getSession();

			_init(session.getServletContext());
		}

		super.doFilter(servletRequest, servletResponse, filterChain);
	}


	public void init(FilterConfig filterConfig) throws ServletException {

		// LPS-23577 and LPS-41715

		injector = null;
	}

	private void _init(ServletContext servletContext) throws ServletException {
		injector = (Injector)servletContext.getAttribute(
			GuiceServletContextListener.INJECTOR_ATTRIBUTE);

		if (injector == null) {
			injector = (Injector)servletContext.getAttribute(
				GuiceServletContextListener.INJECTOR_NAME);

			if (injector == null) {
				throw new UnavailableException(
					"Guice injector is not available. Please register " +
						GuiceServletContextListener.class.getName() + ".");
			}
		}

		injector.injectMembers(this);
	}

}