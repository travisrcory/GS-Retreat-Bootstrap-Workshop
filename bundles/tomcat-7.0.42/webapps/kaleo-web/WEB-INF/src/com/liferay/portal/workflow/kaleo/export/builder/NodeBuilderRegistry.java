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

import com.liferay.portal.workflow.kaleo.util.NodeTypeDependentObjectRegistry;

import java.util.Map;

/**
 * @author Michael C. Han
 */
public class NodeBuilderRegistry {

	public static NodeBuilder getNodeBuilder(String nodeTypeString) {
		return _nodeBuilders.getNodeTypeDependentObjects(nodeTypeString);
	}

	public void setNodeBuilders(Map<String, NodeBuilder> nodeBuilders) {
		_nodeBuilders.setNodeTypeDependentObjects(nodeBuilders);
	}

	protected static NodeTypeDependentObjectRegistry<NodeBuilder>
		_nodeBuilders = new NodeTypeDependentObjectRegistry<NodeBuilder>();

}