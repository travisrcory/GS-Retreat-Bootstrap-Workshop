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

package com.liferay.portal.workflow.kaleo.runtime.graph;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.workflow.kaleo.BaseKaleoBean;
import com.liferay.portal.workflow.kaleo.model.KaleoNode;
import com.liferay.portal.workflow.kaleo.runtime.ExecutionContext;
import com.liferay.portal.workflow.kaleo.runtime.node.NodeExecutor;
import com.liferay.portal.workflow.kaleo.runtime.node.NodeExecutorFactory;
import com.liferay.portal.workflow.kaleo.runtime.util.ExecutionUtil;

import java.util.List;

/**
 * @author Michael C. Han
 */
@Transactional(
	isolation = Isolation.PORTAL, propagation = Propagation.REQUIRES_NEW,
	rollbackFor = {Exception.class})
public class DefaultGraphWalker extends BaseKaleoBean implements GraphWalker {


	public void follow(
			KaleoNode sourceKaleoNode, KaleoNode targetKaleoNode,
			List<PathElement> remainingPathElements,
			ExecutionContext executionContext)
		throws PortalException, SystemException {

		if (sourceKaleoNode != null) {
			NodeExecutor nodeExecutor = NodeExecutorFactory.getNodeExecutor(
				sourceKaleoNode.getType());

			nodeExecutor.exit(
				sourceKaleoNode, executionContext, remainingPathElements);
		}

		if (targetKaleoNode != null) {
			kaleoLogLocalService.addNodeEntryKaleoLog(
				executionContext.getKaleoInstanceToken(), sourceKaleoNode,
				targetKaleoNode, executionContext.getServiceContext());

			NodeExecutor nodeExecutor = NodeExecutorFactory.getNodeExecutor(
				targetKaleoNode.getType());

			boolean performExecute = nodeExecutor.enter(
				targetKaleoNode, executionContext);

			if (performExecute) {
				nodeExecutor.execute(
					targetKaleoNode, executionContext, remainingPathElements);
			}
		}

		ExecutionUtil.checkKaleoInstanceComplete(executionContext);
	}

}