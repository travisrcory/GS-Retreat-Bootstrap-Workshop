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

package com.liferay.portal.workflow.kaleo.runtime.graph.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.messaging.sender.DefaultSingleDestinationMessageSender;
import com.liferay.portal.kernel.messaging.sender.SingleDestinationMessageSender;
import com.liferay.portal.workflow.kaleo.runtime.graph.GraphWalker;
import com.liferay.portal.workflow.kaleo.runtime.graph.PathElement;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael C. Han
 */
public class PathElementMessageListener extends BaseMessageListener {

	public void setDestinationName(String destinationName) {
		DefaultSingleDestinationMessageSender singleDestinationMessageSender =
			new DefaultSingleDestinationMessageSender();

		singleDestinationMessageSender.setDestinationName(destinationName);
		singleDestinationMessageSender.setMessageSender(
			MessageBusUtil.getMessageSender());

		_singleDestinationMessageSender = singleDestinationMessageSender;
	}

	public void setGraphWalker(GraphWalker graphWalker) {
		_graphWalker = graphWalker;
	}


	protected void doReceive(Message message) throws Exception {
		PathElement pathElement = (PathElement)message.getPayload();

		List<PathElement> remainingPathElements = new ArrayList<PathElement>();

		_graphWalker.follow(
			pathElement.getStartNode(), pathElement.getTargetNode(),
			remainingPathElements, pathElement.getExecutionContext());

		for (PathElement remainingPathElement : remainingPathElements) {
			_singleDestinationMessageSender.send(remainingPathElement);
		}
	}

	private GraphWalker _graphWalker;
	private SingleDestinationMessageSender _singleDestinationMessageSender;

}