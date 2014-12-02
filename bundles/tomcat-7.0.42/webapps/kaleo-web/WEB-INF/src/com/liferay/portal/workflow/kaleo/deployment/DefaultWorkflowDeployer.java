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

package com.liferay.portal.workflow.kaleo.deployment;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.workflow.WorkflowDefinition;
import com.liferay.portal.kernel.workflow.WorkflowException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.workflow.kaleo.NoSuchDefinitionException;
import com.liferay.portal.workflow.kaleo.definition.Condition;
import com.liferay.portal.workflow.kaleo.definition.Definition;
import com.liferay.portal.workflow.kaleo.definition.Node;
import com.liferay.portal.workflow.kaleo.definition.NodeType;
import com.liferay.portal.workflow.kaleo.definition.State;
import com.liferay.portal.workflow.kaleo.definition.Task;
import com.liferay.portal.workflow.kaleo.definition.Transition;
import com.liferay.portal.workflow.kaleo.model.KaleoDefinition;
import com.liferay.portal.workflow.kaleo.model.KaleoNode;
import com.liferay.portal.workflow.kaleo.service.KaleoConditionLocalServiceUtil;
import com.liferay.portal.workflow.kaleo.service.KaleoDefinitionLocalServiceUtil;
import com.liferay.portal.workflow.kaleo.service.KaleoNodeLocalServiceUtil;
import com.liferay.portal.workflow.kaleo.service.KaleoTaskLocalServiceUtil;
import com.liferay.portal.workflow.kaleo.service.KaleoTransitionLocalServiceUtil;
import com.liferay.portal.workflow.kaleo.util.WorkflowModelUtil;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Michael C. Han
 */
public class DefaultWorkflowDeployer implements WorkflowDeployer {


	public WorkflowDefinition deploy(
			String title, Definition definition, ServiceContext serviceContext)
		throws PortalException, SystemException {

		KaleoDefinition kaleoDefinition = null;

		try {
			kaleoDefinition =
				KaleoDefinitionLocalServiceUtil.incrementKaleoDefinition(
					definition, title, serviceContext);
		}
		catch (NoSuchDefinitionException nsde) {
			kaleoDefinition =
				KaleoDefinitionLocalServiceUtil.addKaleoDefinition(
					definition.getName(), title, definition.getDescription(),
					definition.getContent(), definition.getVersion(),
					serviceContext);
		}

		long kaleoDefinitionId = kaleoDefinition.getKaleoDefinitionId();

		Collection<Node> nodes = definition.getNodes();

		Map<String, KaleoNode> kaleoNodesMap = new HashMap<String, KaleoNode>();

		for (Node node : nodes) {
			KaleoNode kaleoNode = KaleoNodeLocalServiceUtil.addKaleoNode(
				kaleoDefinitionId, node, serviceContext);

			kaleoNodesMap.put(node.getName(), kaleoNode);

			NodeType nodeType = node.getNodeType();

			if (nodeType.equals(NodeType.TASK)) {
				Task task = (Task)node;

				KaleoTaskLocalServiceUtil.addKaleoTask(
					kaleoDefinitionId, kaleoNode.getKaleoNodeId(), task,
					serviceContext);
			}
			else if (nodeType.equals(NodeType.CONDITION)) {
				Condition condition = (Condition)node;

				KaleoConditionLocalServiceUtil.addKaleoCondition(
					kaleoDefinitionId, kaleoNode.getKaleoNodeId(), condition,
					serviceContext);
			}
		}

		for (Node node : nodes) {
			KaleoNode kaleoNode = kaleoNodesMap.get(node.getName());

			for (Transition transition : node.getOutgoingTransitionsList()) {
				KaleoNode sourceKaleoNode = kaleoNodesMap.get(
					transition.getSourceNode().getName());

				if (sourceKaleoNode == null) {
					throw new WorkflowException(
						"Unable to find source node " +
							transition.getSourceNode());
				}

				KaleoNode targetKaleoNode = kaleoNodesMap.get(
					transition.getTargetNode().getName());

				if (targetKaleoNode == null) {
					throw new WorkflowException(
						"Unable to find target node " +
							transition.getTargetNode());
				}

				KaleoTransitionLocalServiceUtil.addKaleoTransition(
					kaleoNode.getKaleoDefinitionId(),
					kaleoNode.getKaleoNodeId(), transition, sourceKaleoNode,
					targetKaleoNode, serviceContext);
			}
		}

		State initialState = definition.getInitialState();

		if (initialState == null) {
			throw new WorkflowException("No initial state found in definition");
		}

		String startKaleoNodeName = initialState.getName();

		KaleoNode kaleoNode = kaleoNodesMap.get(startKaleoNodeName);

		KaleoDefinitionLocalServiceUtil.activateKaleoDefinition(
			kaleoDefinitionId, kaleoNode.getKaleoNodeId(), serviceContext);

		return WorkflowModelUtil.toWorkflowDefinition(kaleoDefinition);
	}

}