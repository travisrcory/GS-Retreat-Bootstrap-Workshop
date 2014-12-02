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

package com.liferay.portal.workflow.kaleo.runtime.condition;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.scripting.ScriptingUtil;
import com.liferay.portal.workflow.kaleo.model.KaleoCondition;
import com.liferay.portal.workflow.kaleo.runtime.ExecutionContext;
import com.liferay.portal.workflow.kaleo.runtime.util.ScriptingContextBuilderUtil;
import com.liferay.portal.workflow.kaleo.util.WorkflowContextUtil;

import java.io.Serializable;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Michael C. Han
 */
public class ScriptingConditionEvaluator implements ConditionEvaluator {


	public String evaluate(
			KaleoCondition kaleoCondition, ExecutionContext executionContext,
			ClassLoader... classLoaders)
		throws PortalException, SystemException {

		Map<String, Object> inputObjects =
			ScriptingContextBuilderUtil.buildScriptingContext(executionContext);

		Map<String, Object> results = ScriptingUtil.eval(
			null, inputObjects, _outputNames,
			kaleoCondition.getScriptLanguage(), kaleoCondition.getScript(),
			classLoaders);

		Map<String, Serializable> resultsWorkflowContext =
			(Map<String, Serializable>)results.get(
				WorkflowContextUtil.WORKFLOW_CONTEXT_NAME);

		WorkflowContextUtil.mergeWorkflowContexts(
			executionContext, resultsWorkflowContext);

		String returnValue = (String)results.get(_RETURN_VALUE);

		if (returnValue != null) {
			return returnValue;
		}

		throw new IllegalStateException(
			"Conditional did not return value for script " +
				kaleoCondition.getScript());
	}

	private static final String _RETURN_VALUE = "returnValue";

	private static Set<String> _outputNames = new HashSet<String>();

	static {
		_outputNames.add(_RETURN_VALUE);
		_outputNames.add(WorkflowContextUtil.WORKFLOW_CONTEXT_NAME);
	}

}