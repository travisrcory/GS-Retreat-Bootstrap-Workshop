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

package com.liferay.portal.workflow.kaleo.export.builder;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.workflow.kaleo.BaseKaleoBean;
import com.liferay.portal.workflow.kaleo.definition.Definition;
import com.liferay.portal.workflow.kaleo.definition.Node;
import com.liferay.portal.workflow.kaleo.definition.Transition;
import com.liferay.portal.workflow.kaleo.model.KaleoDefinition;
import com.liferay.portal.workflow.kaleo.model.KaleoNode;
import com.liferay.portal.workflow.kaleo.model.KaleoTransition;

import java.util.List;

/**
 * @author Michael C. Han
 */
public class DefaultDefinitionBuilder
	extends BaseKaleoBean implements DefinitionBuilder {


	public Definition buildDefinition(long kaleoDefinitionId)
		throws PortalException, SystemException {

		KaleoDefinition kaleoDefinition =
			kaleoDefinitionLocalService.getKaleoDefinition(kaleoDefinitionId);

		return doBuildDefinition(kaleoDefinition);
	}


	public Definition buildDefinition(long companyId, String name, int version)
		throws PortalException, SystemException {

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setCompanyId(companyId);

		KaleoDefinition kaleoDefinition =
			kaleoDefinitionLocalService.getKaleoDefinition(
				name, version, serviceContext);

		return doBuildDefinition(kaleoDefinition);
	}

	protected Definition doBuildDefinition(KaleoDefinition kaleoDefinition)
		throws PortalException, SystemException {

		Definition definition = new Definition(
			kaleoDefinition.getName(), kaleoDefinition.getDescription(),
			kaleoDefinition.getContent(), kaleoDefinition.getVersion());

		List<KaleoNode> kaleoNodes =
			kaleoNodeLocalService.getKaleoDefinitionKaleoNodes(
				kaleoDefinition.getKaleoDefinitionId());

		for (KaleoNode kaleoNode : kaleoNodes) {
			NodeBuilder nodeBuilder = NodeBuilderRegistry.getNodeBuilder(
				kaleoNode.getType());

			Node node = nodeBuilder.buildNode(kaleoNode);

			definition.addNode(node);
		}

		List<KaleoTransition> kaleoTransitions =
			kaleoTransitionLocalService.getKaleoDefinitionKaleoTransitions(
				kaleoDefinition.getKaleoDefinitionId());

		for (KaleoTransition kaleoTransition : kaleoTransitions) {
			String sourceNodeName = kaleoTransition.getSourceKaleoNodeName();

			Node sourceNode = definition.getNode(sourceNodeName);

			String targetNodeName = kaleoTransition.getTargetKaleoNodeName();

			Node targetNode = definition.getNode(targetNodeName);

			Transition transition = new Transition(
				kaleoTransition.getName(), sourceNode, targetNode,
				kaleoTransition.isDefaultTransition());

			sourceNode.addOutgoingTransition(transition);

			targetNode.addIncomingTransition(transition);
		}

		return definition;
	}

}