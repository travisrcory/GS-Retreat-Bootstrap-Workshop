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
import com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken;
import com.liferay.portal.workflow.kaleo.model.KaleoNode;
import com.liferay.portal.workflow.kaleo.model.KaleoTimer;
import com.liferay.portal.workflow.kaleo.model.KaleoTransition;
import com.liferay.portal.workflow.kaleo.runtime.ExecutionContext;
import com.liferay.portal.workflow.kaleo.runtime.graph.PathElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Michael C. Han
 */
public class ForkNodeExecutor extends BaseNodeExecutor {


	protected boolean doEnter(
		KaleoNode currentKaleoNode, ExecutionContext executionContext) {

		return true;
	}


	protected void doExecute(
			KaleoNode currentKaleoNode, ExecutionContext executionContext,
			List<PathElement> remainingPathElements)
		throws PortalException, SystemException {

		List<KaleoTransition> kaleoTransitions =
			currentKaleoNode.getKaleoTransitions();

		Map<String, KaleoInstanceToken> childKaleoInstanceTokens =
			new HashMap<String, KaleoInstanceToken>();

		for (KaleoTransition kaleoTransition : kaleoTransitions) {
			KaleoInstanceToken parentKaleoInstanceToken =
				executionContext.getKaleoInstanceToken();

			KaleoInstanceToken childKaleoInstanceToken =
				kaleoInstanceTokenLocalService.addKaleoInstanceToken(
					parentKaleoInstanceToken.getKaleoInstanceTokenId(),
					executionContext.getWorkflowContext(),
					executionContext.getServiceContext());

			childKaleoInstanceTokens.put(
				kaleoTransition.getName(), childKaleoInstanceToken);
		}

		for (KaleoTransition kaleoTransition : kaleoTransitions) {
			KaleoInstanceToken childKaleoInstanceToken =
				childKaleoInstanceTokens.get(kaleoTransition.getName());

			ExecutionContext forkedExecutionContext = new ExecutionContext(
				childKaleoInstanceToken, executionContext.getWorkflowContext(),
				executionContext.getServiceContext());

			PathElement pathElement = new PathElement(
				currentKaleoNode, kaleoTransition.getTargetKaleoNode(),
				forkedExecutionContext);

			remainingPathElements.add(pathElement);
		}
	}


	protected void doExecuteTimer(
		KaleoNode currentKaleoNode, KaleoTimer kaleoTimer,
		ExecutionContext executionContext) {
	}


	protected void doExit(
		KaleoNode currentKaleoNode, ExecutionContext executionContext,
		List<PathElement> remainingPathElements) {
	}

}