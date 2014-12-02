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

package com.liferay.portal.workflow.kaleo.parser;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowException;
import com.liferay.portal.workflow.kaleo.definition.Definition;
import com.liferay.portal.workflow.kaleo.definition.Fork;
import com.liferay.portal.workflow.kaleo.definition.Join;
import com.liferay.portal.workflow.kaleo.definition.Node;
import com.liferay.portal.workflow.kaleo.definition.NodeType;
import com.liferay.portal.workflow.kaleo.definition.Transition;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Michael C. Han
 * @author Marcellus Tavares
 * @author Norbert Kocsis
 */
public class ForkNodeValidator extends BaseNodeValidator<Fork> {


	protected void doValidate(Definition definition, Fork fork)
		throws WorkflowException {

		if (fork.getIncomingTransitionsCount() == 0) {
			throw new WorkflowException(
				"No incoming transition found for fork " + fork.getName());
		}

		if (fork.getOutgoingTransitionsCount() < 2) {
			throw new WorkflowException(
				"Less than 2 outgoing transitions found for fork " +
					fork.getName());
		}

		traverse(fork);
	}

	protected List<Node> getUnvisitedNodes(
		List<Node> nodes, Collection<Transition> transitions, boolean target) {

		List<Node> unvisitedNodes = new ArrayList<Node>();

		for (Transition transition : transitions) {
			Node node = transition.getSourceNode();

			if (target) {
				node = transition.getTargetNode();
			}

			if (!nodes.contains(node)) {
				unvisitedNodes.add(node);
			}
		}

		return unvisitedNodes;
	}

	protected void reverseTraverse(
			Fork fork, Join join, List<Node> targetNodes,
			Map<Join, Fork> joinForkMap)
		throws WorkflowException {

		List<Node> sourceNodes = new ArrayList<Node>();

		sourceNodes.add(join);

		for (Transition transition : join.getIncomingTransitions()) {
			sourceNodes.add(transition.getSourceNode());
		}

		for (int i = 1; i < sourceNodes.size(); i++) {
			Node sourceNode = sourceNodes.get(i);

			NodeType nodeType = sourceNode.getNodeType();

			if (nodeType.equals(NodeType.FORK) &&
				Validator.equals(fork, sourceNode)) {

				continue;
			}
			else if (nodeType.equals(NodeType.JOIN) ||
					 nodeType.equals(NodeType.JOIN_XOR)) {

				sourceNode = joinForkMap.get((Join)sourceNode);

				sourceNodes.set(i, sourceNode);
			}

			List<Node> unvisitedSourceNodes = getUnvisitedNodes(
				sourceNodes, sourceNode.getIncomingTransitions(), false);

			sourceNodes.addAll(unvisitedSourceNodes);
		}

		if ((sourceNodes.size() != targetNodes.size()) ||
			!sourceNodes.containsAll(targetNodes)) {

			throw new WorkflowException(
				"There are errors between fork " + fork.getName() +
					" and join " + join.getName());
		}
	}

	protected Join traverse(Fork fork) throws WorkflowException {
		Join join = null;

		List<Node> targetNodes = new ArrayList<Node>();

		Map<Join, Fork> joinForkMap = new HashMap<Join, Fork>();

		targetNodes.add(fork);

		for (Transition transition : fork.getOutgoingTransitionsList()) {
			targetNodes.add(transition.getTargetNode());
		}

		for (int i = 1; i < targetNodes.size(); i++) {
			Node targetNode = targetNodes.get(i);

			NodeType nodeType = targetNode.getNodeType();

			if (nodeType.equals(NodeType.FORK)) {
				Join localJoin = traverse((Fork)targetNode);

				joinForkMap.put(localJoin, (Fork)targetNode);

				List<Node> unvisitedTargetNodes = getUnvisitedNodes(
					targetNodes, localJoin.getOutgoingTransitionsList(), true);

				targetNodes.addAll(unvisitedTargetNodes);
			}
			else if (nodeType.equals(NodeType.JOIN) ||
					 nodeType.equals(NodeType.JOIN_XOR)) {

				if (Validator.isNull(join)) {
					join = (Join)targetNode;
				}
				else if (!Validator.equals(join, targetNode)) {
					throw new WorkflowException(
						"Fork " + fork.getName() + " and join " +
							targetNode.getName() + " are not paired");
				}
			}
			else {
				List<Node> unvisitedTargetNodes = getUnvisitedNodes(
					targetNodes, targetNode.getOutgoingTransitionsList(), true);

				targetNodes.addAll(unvisitedTargetNodes);
			}
		}

		if (join == null) {
			throw new WorkflowException(
				"No matching join found for fork " + fork.getName());
		}

		reverseTraverse(fork, join, targetNodes, joinForkMap);

		return join;
	}

}