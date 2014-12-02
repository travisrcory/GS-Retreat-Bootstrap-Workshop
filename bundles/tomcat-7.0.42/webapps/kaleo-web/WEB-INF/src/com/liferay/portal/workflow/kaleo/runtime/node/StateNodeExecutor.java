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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken;
import com.liferay.portal.workflow.kaleo.model.KaleoNode;
import com.liferay.portal.workflow.kaleo.model.KaleoTimer;
import com.liferay.portal.workflow.kaleo.model.KaleoTransition;
import com.liferay.portal.workflow.kaleo.model.impl.KaleoInstanceTokenImpl;
import com.liferay.portal.workflow.kaleo.runtime.ExecutionContext;
import com.liferay.portal.workflow.kaleo.runtime.graph.PathElement;

import java.util.List;

/**
 * @author Michael C. Han
 */
public class StateNodeExecutor extends BaseNodeExecutor {


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

		String transitionName = executionContext.getTransitionName();

		if (!currentKaleoNode.hasKaleoTransition()) {
			kaleoInstanceToken =
				kaleoInstanceTokenLocalService.completeKaleoInstanceToken(
					kaleoInstanceToken.getKaleoInstanceTokenId());

			if (kaleoInstanceToken.getParentKaleoInstanceTokenId() ==
					KaleoInstanceTokenImpl.
						DEFAULT_PARENT_KALEO_INSTANCE_TOKEN_ID) {

				kaleoInstanceLocalService.completeKaleoInstance(
					kaleoInstanceToken.getKaleoInstanceId());
			}

			return;
		}

		KaleoTransition kaleoTransition = null;

		if (Validator.isNull(transitionName)) {
			kaleoTransition = currentKaleoNode.getDefaultKaleoTransition();
		}
		else {
			kaleoTransition = currentKaleoNode.getKaleoTransition(
				transitionName);
		}

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

}