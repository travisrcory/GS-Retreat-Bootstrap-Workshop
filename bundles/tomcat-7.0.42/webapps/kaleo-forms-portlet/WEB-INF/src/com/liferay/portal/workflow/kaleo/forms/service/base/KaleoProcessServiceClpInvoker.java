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

package com.liferay.portal.workflow.kaleo.forms.service.base;

import com.liferay.portal.workflow.kaleo.forms.service.KaleoProcessServiceUtil;

import java.util.Arrays;

/**
 * @author Marcellus Tavares
 * @generated
 */
public class KaleoProcessServiceClpInvoker {
	public KaleoProcessServiceClpInvoker() {
		_methodName44 = "getBeanIdentifier";

		_methodParameterTypes44 = new String[] {  };

		_methodName45 = "setBeanIdentifier";

		_methodParameterTypes45 = new String[] { "java.lang.String" };

		_methodName50 = "addKaleoProcess";

		_methodParameterTypes50 = new String[] {
				"long", "long", "long", "long[][]",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName51 = "deleteKaleoProcess";

		_methodParameterTypes51 = new String[] { "long" };

		_methodName52 = "deleteKaleoProcessData";

		_methodParameterTypes52 = new String[] { "long" };

		_methodName53 = "getKaleoProcess";

		_methodParameterTypes53 = new String[] { "long" };

		_methodName54 = "getKaleoProcesses";

		_methodParameterTypes54 = new String[] {
				"long", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName55 = "getKaleoProcessesCount";

		_methodParameterTypes55 = new String[] { "long" };

		_methodName56 = "updateKaleoProcess";

		_methodParameterTypes56 = new String[] {
				"long", "long", "long[][]",
				"com.liferay.portal.service.ServiceContext"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName44.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes44, parameterTypes)) {
			return KaleoProcessServiceUtil.getBeanIdentifier();
		}

		if (_methodName45.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes45, parameterTypes)) {
			KaleoProcessServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName50.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes50, parameterTypes)) {
			return KaleoProcessServiceUtil.addKaleoProcess(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(), (long[])arguments[3],
				(com.liferay.portal.service.ServiceContext)arguments[4]);
		}

		if (_methodName51.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes51, parameterTypes)) {
			return KaleoProcessServiceUtil.deleteKaleoProcess(((Long)arguments[0]).longValue());
		}

		if (_methodName52.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes52, parameterTypes)) {
			KaleoProcessServiceUtil.deleteKaleoProcessData(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName53.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes53, parameterTypes)) {
			return KaleoProcessServiceUtil.getKaleoProcess(((Long)arguments[0]).longValue());
		}

		if (_methodName54.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
			return KaleoProcessServiceUtil.getKaleoProcesses(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName55.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
			return KaleoProcessServiceUtil.getKaleoProcessesCount(((Long)arguments[0]).longValue());
		}

		if (_methodName56.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
			return KaleoProcessServiceUtil.updateKaleoProcess(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(), (long[])arguments[2],
				(com.liferay.portal.service.ServiceContext)arguments[3]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName44;
	private String[] _methodParameterTypes44;
	private String _methodName45;
	private String[] _methodParameterTypes45;
	private String _methodName50;
	private String[] _methodParameterTypes50;
	private String _methodName51;
	private String[] _methodParameterTypes51;
	private String _methodName52;
	private String[] _methodParameterTypes52;
	private String _methodName53;
	private String[] _methodParameterTypes53;
	private String _methodName54;
	private String[] _methodParameterTypes54;
	private String _methodName55;
	private String[] _methodParameterTypes55;
	private String _methodName56;
	private String[] _methodParameterTypes56;
}