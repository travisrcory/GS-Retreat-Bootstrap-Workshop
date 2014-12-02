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

package com.liferay.portal.workflow.kaleo.runtime.action;

import com.liferay.portal.kernel.workflow.WorkflowException;

import java.util.Map;

/**
 * @author Michael C. Han
 */
public class ActionExecutorFactory {

	public static ActionExecutor getActionExecutor(String scriptLanguage)
		throws WorkflowException {

		ActionExecutor actionExecutor = _actionExecutors.get(scriptLanguage);

		if (actionExecutor == null) {
			throw new WorkflowException(
				"Invalid script language " + scriptLanguage);
		}

		return actionExecutor;
	}

	public void setActionExecutors(
		Map<String, ActionExecutor> actionExecutors) {

		_actionExecutors = actionExecutors;
	}

	private static Map<String, ActionExecutor> _actionExecutors;

}