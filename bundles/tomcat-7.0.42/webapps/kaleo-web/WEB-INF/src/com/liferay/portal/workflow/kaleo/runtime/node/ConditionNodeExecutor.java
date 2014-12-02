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

package com.liferay.portal.workflow.kaleo.runtime.node;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.workflow.kaleo.model.KaleoCondition;
import com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken;
import com.liferay.portal.workflow.kaleo.model.KaleoNode;
import com.liferay.portal.workflow.kaleo.model.KaleoTimer;
import com.liferay.portal.workflow.kaleo.model.KaleoTransition;
import com.liferay.portal.workflow.kaleo.runtime.ExecutionContext;
import com.liferay.portal.workflow.kaleo.runtime.condition.ConditionEvaluator;
import com.liferay.portal.workflow.kaleo.runtime.graph.PathElement;
import com.liferay.portal.workflow.kaleo.runtime.util.ClassLoaderUtil;

import java.util.List;

/**
 * @author Michael C. Han
 */
public class ConditionNodeExecutor extends BaseNodeExecutor {

	public void setConditionEvaluator(ConditionEvaluator conditionEvaluator) {
		_conditionEvaluator = conditionEvaluator;
	}


	protected boolean doEnter(
		KaleoNode currentKaleoNode, ExecutionContext executionContext) {

		return true;
	}


	protected void doExecute(
			KaleoNode currentKaleoNode, ExecutionContext executionContext,
			List<PathElement> remainingPathElements)
		throws PortalException, SystemException {

		KaleoInstanceToken kaleoInstanceToken =
			executionContext.getKaleoInstanceToken();

		KaleoCondition kaleoCondition =
			kaleoConditionLocalService.getKaleoNodeKaleoCondition(
				currentKaleoNode.getKaleoNodeId());

		String[] scriptRequiredContexts = StringUtil.split(
			kaleoCondition.getScriptRequiredContexts());

		ClassLoader[] classloaders = ClassLoaderUtil.getClassLoaders(
			scriptRequiredContexts);

		String transitionName = _conditionEvaluator.evaluate(
			kaleoCondition, executionContext, classloaders);

		kaleoInstanceLocalService.updateKaleoInstance(
			kaleoInstanceToken.getKaleoInstanceId(),
			executionContext.getWorkflowContext(),
			executionContext.getServiceContext());

		KaleoTransition kaleoTransition = currentKaleoNode.getKaleoTransition(
			transitionName);

		ExecutionContext newExecutionContext = new ExecutionContext(
			kaleoInstanceToken, executionContext.getWorkflowContext(),
			executionContext.getServiceContext());

		PathElement pathElement = new PathElement(
			currentKaleoNode, kaleoTransition.getTargetKaleoNode(),
			newExecutionContext);

		remainingPathElements.add(pathElement);
	}


	protected void doExecuteTimer(
		KaleoNode currentKaleoNode, KaleoTimer kaleoTimer,
		ExecutionContext executionContext) {
	}


	protected void doExit(
		KaleoNode currentKaleoNode, ExecutionContext executionContext,
		List<PathElement> remainingPathElements) {
	}

	private ConditionEvaluator _conditionEvaluator;

}