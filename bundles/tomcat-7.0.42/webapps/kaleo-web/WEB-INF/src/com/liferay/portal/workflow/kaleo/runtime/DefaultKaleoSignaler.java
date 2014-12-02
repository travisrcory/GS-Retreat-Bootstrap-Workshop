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

package com.liferay.portal.workflow.kaleo.runtime;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.messaging.sender.DefaultSingleDestinationMessageSender;
import com.liferay.portal.kernel.messaging.sender.SingleDestinationMessageSender;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.workflow.kaleo.BaseKaleoBean;
import com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken;
import com.liferay.portal.workflow.kaleo.model.KaleoNode;
import com.liferay.portal.workflow.kaleo.runtime.graph.PathElement;
import com.liferay.portal.workflow.kaleo.runtime.node.NodeExecutor;
import com.liferay.portal.workflow.kaleo.runtime.node.NodeExecutorFactory;
import com.liferay.portal.workflow.kaleo.runtime.util.ExecutionUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael C. Han
 */
@Transactional(
	isolation = Isolation.PORTAL, propagation = Propagation.SUPPORTS,
	rollbackFor = {Exception.class})
public class DefaultKaleoSignaler
	extends BaseKaleoBean implements KaleoSignaler {

	public void setDestinationName(String destinationName) {
		DefaultSingleDestinationMessageSender singleDestinationMessageSender =
			new DefaultSingleDestinationMessageSender();

		singleDestinationMessageSender.setDestinationName(destinationName);
		singleDestinationMessageSender.setMessageSender(
			MessageBusUtil.getMessageSender());

		_singleDestinationMessageSender = singleDestinationMessageSender;
	}


	public void signalEntry(
			String transitionName, ExecutionContext executionContext)
		throws PortalException, SystemException {

		KaleoInstanceToken kaleoInstanceToken =
			executionContext.getKaleoInstanceToken();

		executionContext.setTransitionName(transitionName);

		PathElement startPathElement = new PathElement(
			null, kaleoInstanceToken.getCurrentKaleoNode(), executionContext);

		_singleDestinationMessageSender.send(startPathElement);
	}


	@Transactional(
		isolation = Isolation.PORTAL, propagation = Propagation.REQUIRED,
		rollbackFor = {Exception.class})
	public void signalExecute(
			KaleoNode currentKaleoNode, ExecutionContext executionContext)
		throws PortalException, SystemException {

		NodeExecutor nodeExecutor = NodeExecutorFactory.getNodeExecutor(
			currentKaleoNode.getType());

		List<PathElement> remainingPathElements = new ArrayList<PathElement>();

		nodeExecutor.execute(
			currentKaleoNode, executionContext, remainingPathElements);

		ExecutionUtil.checkKaleoInstanceComplete(executionContext);

		for (PathElement remainingPathElement : remainingPathElements) {
			_singleDestinationMessageSender.send(remainingPathElement);
		}
	}


	public void signalExit(
			String transitionName, ExecutionContext executionContext)
		throws PortalException, SystemException {

		KaleoInstanceToken kaleoInstanceToken =
			executionContext.getKaleoInstanceToken();

		executionContext.setTransitionName(transitionName);

		KaleoNode currentKaleoNode = kaleoInstanceToken.getCurrentKaleoNode();

		PathElement pathElement = new PathElement(
			currentKaleoNode, null, executionContext);

		_singleDestinationMessageSender.send(pathElement);
	}

	private SingleDestinationMessageSender _singleDestinationMessageSender;

}