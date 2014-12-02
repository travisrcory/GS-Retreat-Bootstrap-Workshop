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

package com.liferay.marketplace.service.base;

import com.liferay.marketplace.service.AppServiceUtil;

import java.util.Arrays;

/**
 * @author Ryan Park
 * @generated
 */
public class AppServiceClpInvoker {
	public AppServiceClpInvoker() {
		_methodName22 = "getBeanIdentifier";

		_methodParameterTypes22 = new String[] {  };

		_methodName23 = "setBeanIdentifier";

		_methodParameterTypes23 = new String[] { "java.lang.String" };

		_methodName28 = "deleteApp";

		_methodParameterTypes28 = new String[] { "long" };

		_methodName29 = "installApp";

		_methodParameterTypes29 = new String[] { "long" };

		_methodName30 = "uninstallApp";

		_methodParameterTypes30 = new String[] { "long" };

		_methodName31 = "updateApp";

		_methodParameterTypes31 = new String[] {
				"long", "java.lang.String", "java.io.File"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName22.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes22, parameterTypes)) {
			return AppServiceUtil.getBeanIdentifier();
		}

		if (_methodName23.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes23, parameterTypes)) {
			AppServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName28.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
			return AppServiceUtil.deleteApp(((Long)arguments[0]).longValue());
		}

		if (_methodName29.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
			AppServiceUtil.installApp(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName30.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes30, parameterTypes)) {
			AppServiceUtil.uninstallApp(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName31.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes31, parameterTypes)) {
			return AppServiceUtil.updateApp(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.io.File)arguments[2]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName22;
	private String[] _methodParameterTypes22;
	private String _methodName23;
	private String[] _methodParameterTypes23;
	private String _methodName28;
	private String[] _methodParameterTypes28;
	private String _methodName29;
	private String[] _methodParameterTypes29;
	private String _methodName30;
	private String[] _methodParameterTypes30;
	private String _methodName31;
	private String[] _methodParameterTypes31;
}