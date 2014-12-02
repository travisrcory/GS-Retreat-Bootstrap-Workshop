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

import java.util.List;

/**
 * @author Michael C. Han
 */
public class JoinXorNodeExecutor extends BaseNodeExecutor {


	protected boolean doEnter(
			KaleoNode currentKaleoNode, ExecutionContext executionContext)
		throws PortalException, SystemException {

		KaleoInstanceToken kaleoInstanceToken =
			executionContext.getKaleoInstanceToken();

		kaleoInstanceToken =
			kaleoInstanceTokenLocalService.getKaleoInstanceToken(
				kaleoInstanceToken.getKaleoInstanceTokenId());

		if (kaleoInstanceToken.isCompleted()) {
			return false;
		}

		kaleoInstanceToken =
			kaleoInstanceTokenLocalService.completeKaleoInstanceToken(
				kaleoInstanceToken.getKaleoInstanceTokenId());

		KaleoInstanceToken parentKaleoInstanceToken =
			kaleoInstanceToken.getParentKaleoInstanceToken();

		if (!parentKaleoInstanceToken.
				hasIncompleteChildrenKaleoInstanceToken()) {

			return false;
		}

		List<KaleoInstanceToken> childrenKaleoInstanceTokens =
			parentKaleoInstanceToken.getChildrenKaleoInstanceTokens();

		for (KaleoInstanceToken childrenKaleoInstanceToken :
				childrenKaleoInstanceTokens) {

			kaleoInstanceTokenLocalService.completeKaleoInstanceToken(
				childrenKaleoInstanceToken.getKaleoInstanceTokenId());
		}

		return true;
	}


	protected void doExecute(
			KaleoNode currentKaleoNode, ExecutionContext executionContext,
			List<PathElement> remainingPathElements)
		throws PortalException, SystemException {

		KaleoInstanceToken kaleoInstanceToken =
			executionContext.getKaleoInstanceToken();

		KaleoInstanceToken parentKaleoInstanceToken =
			kaleoInstanceToken.getParentKaleoInstanceToken();

		if (parentKaleoInstanceToken.getCurrentKaleoNodeId() ==
				currentKaleoNode.getKaleoNodeId()) {

			return;
		}

		parentKaleoInstanceToken =
			kaleoInstanceTokenLocalService.updateKaleoInstanceToken(
				parentKaleoInstanceToken.getKaleoInstanceTokenId(),
				currentKaleoNode.getKaleoNodeId());

		KaleoTransition kaleoTransition =
			currentKaleoNode.getDefaultKaleoTransition();

		ExecutionContext newExecutionContext = new ExecutionContext(
			parentKaleoInstanceToken, executionContext.getWorkflowContext(),
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