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

import com.liferay.portal.kernel.scripting.ScriptingUtil;
import com.liferay.portal.workflow.kaleo.model.KaleoAction;
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
public class ScriptActionExecutor implements ActionExecutor {

	public ScriptActionExecutor() {
		_outputObjects.add(WorkflowContextUtil.WORKFLOW_CONTEXT_NAME);
	}


	public void execute(
			KaleoAction kaleoAction, ExecutionContext executionContext,
			ClassLoader... classLoaders)
		throws ActionExecutorException {

		try {
			doExecute(kaleoAction, executionContext, classLoaders);
		}
		catch (Exception e) {
			throw new ActionExecutorException(e);
		}
	}

	public void setOutputObjects(Set<String> outputObjects) {
		_outputObjects.addAll(outputObjects);
	}

	protected void doExecute(
			KaleoAction kaleoAction, ExecutionContext executionContext,
			ClassLoader... classLoaders)
		throws Exception {

		Map<String, Object> inputObjects =
			ScriptingContextBuilderUtil.buildScriptingContext(executionContext);

		Map<String, Object> results = ScriptingUtil.eval(
			null, inputObjects, _outputObjects, kaleoAction.getScriptLanguage(),
			kaleoAction.getScript(), classLoaders);

		Map<String, Serializable> resultsWorkflowContext =
			(Map<String, Serializable>)results.get(
				WorkflowContextUtil.WORKFLOW_CONTEXT_NAME);

		WorkflowContextUtil.mergeWorkflowContexts(
			executionContext, resultsWorkflowContext);
	}

	private Set<String> _outputObjects = new HashSet<String>();

}