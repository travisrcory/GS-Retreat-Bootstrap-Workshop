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
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.workflow.kaleo.BaseKaleoBean;
import com.liferay.portal.workflow.kaleo.definition.ExecutionType;
import com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken;
import com.liferay.portal.workflow.kaleo.model.KaleoNode;
import com.liferay.portal.workflow.kaleo.model.KaleoTimer;
import com.liferay.portal.workflow.kaleo.model.KaleoTimerInstanceToken;
import com.liferay.portal.workflow.kaleo.runtime.ExecutionContext;
import com.liferay.portal.workflow.kaleo.runtime.action.ActionExecutorUtil;
import com.liferay.portal.workflow.kaleo.runtime.graph.PathElement;
import com.liferay.portal.workflow.kaleo.runtime.notification.NotificationUtil;
import com.liferay.portal.workflow.kaleo.runtime.util.ExecutionUtil;

import java.util.List;

/**
 * @author Michael C. Han
 */
public abstract class BaseNodeExecutor
	extends BaseKaleoBean implements NodeExecutor {


	public boolean enter(
			KaleoNode currentKaleoNode, ExecutionContext executionContext)
		throws PortalException, SystemException {

		KaleoInstanceToken kaleoInstanceToken =
			executionContext.getKaleoInstanceToken();

		kaleoInstanceToken.setCurrentKaleoNode(currentKaleoNode);

		boolean performExecute = doEnter(currentKaleoNode, executionContext);

		ActionExecutorUtil.executeKaleoActions(
			KaleoNode.class.getName(), currentKaleoNode.getKaleoNodeId(),
			ExecutionType.ON_ENTRY, executionContext);

		NotificationUtil.sendKaleoNotifications(
			KaleoNode.class.getName(), currentKaleoNode.getKaleoNodeId(),
			ExecutionType.ON_ENTRY, executionContext);

		List<KaleoTimer> kaleoTimers = kaleoTimerLocalService.getKaleoTimers(
			KaleoNode.class.getName(), currentKaleoNode.getKaleoNodeId());

		kaleoTimerInstanceTokenLocalService.addKaleoTimerInstanceTokens(
			executionContext.getKaleoInstanceToken(),
			executionContext.getKaleoTaskInstanceToken(), kaleoTimers,
			executionContext.getWorkflowContext(),
			executionContext.getServiceContext());

		return performExecute;
	}


	public void execute(
			KaleoNode currentKaleoNode, ExecutionContext executionContext,
			List<PathElement> remainingPathElements)
		throws PortalException, SystemException {

		if (ExecutionUtil.isKaleoInstanceBlocked(executionContext)) {
			return;
		}

		doExecute(currentKaleoNode, executionContext, remainingPathElements);
	}


	public void executeTimer(
			KaleoNode currentKaleoNode, ExecutionContext executionContext)
		throws PortalException, SystemException {

		ServiceContext serviceContext = executionContext.getServiceContext();

		KaleoTimerInstanceToken kaleoTimerInstanceToken =
			executionContext.getKaleoTimerInstanceToken();

		KaleoTimer kaleoTimer = kaleoTimerInstanceToken.getKaleoTimer();

		ActionExecutorUtil.executeKaleoActions(
			KaleoTimer.class.getName(), kaleoTimer.getKaleoTimerId(),
			ExecutionType.ON_TIMER, executionContext);

		NotificationUtil.sendKaleoNotifications(
			KaleoTimer.class.getName(), kaleoTimer.getKaleoTimerId(),
			ExecutionType.ON_TIMER, executionContext);

		doExecuteTimer(currentKaleoNode, kaleoTimer, executionContext);

		if (!kaleoTimer.isRecurring()) {
			kaleoTimerInstanceTokenLocalService.completeKaleoTimerInstanceToken(
				kaleoTimerInstanceToken.getKaleoTimerInstanceTokenId(),
				serviceContext);
		}
	}


	public void exit(
			KaleoNode currentKaleoNode, ExecutionContext executionContext,
			List<PathElement> remainingPathElements)
		throws PortalException, SystemException {

		ExecutionUtil.completeKaleoTimerInstances(executionContext);

		doExit(currentKaleoNode, executionContext, remainingPathElements);

		ActionExecutorUtil.executeKaleoActions(
			KaleoNode.class.getName(), currentKaleoNode.getKaleoNodeId(),
			ExecutionType.ON_EXIT, executionContext);

		NotificationUtil.sendKaleoNotifications(
			KaleoNode.class.getName(), currentKaleoNode.getKaleoNodeId(),
			ExecutionType.ON_EXIT, executionContext);
	}

	protected abstract boolean doEnter(
			KaleoNode currentKaleoNode, ExecutionContext executionContext)
		throws PortalException, SystemException;

	protected abstract void doExecute(
			KaleoNode currentKaleoNode, ExecutionContext executionContext,
			List<PathElement> remainingPathElements)
		throws PortalException, SystemException;

	protected abstract void doExecuteTimer(
			KaleoNode currentKaleoNode, KaleoTimer kaleoTimer,
			ExecutionContext executionContext)
		throws PortalException, SystemException;

	protected abstract void doExit(
			KaleoNode currentKaleoNode, ExecutionContext executionContext,
			List<PathElement> remainingPathElements)
		throws PortalException, SystemException;

}