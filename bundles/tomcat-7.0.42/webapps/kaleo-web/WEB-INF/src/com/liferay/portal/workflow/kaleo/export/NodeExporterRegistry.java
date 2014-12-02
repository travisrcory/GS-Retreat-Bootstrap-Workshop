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

package com.liferay.portal.workflow.kaleo.export;

import com.liferay.portal.workflow.kaleo.definition.NodeType;
import com.liferay.portal.workflow.kaleo.util.NodeTypeDependentObjectRegistry;

import java.util.Map;

/**
 * @author Michael C. Han
 */
public class NodeExporterRegistry {

	public static NodeExporter getNodeExporter(NodeType nodeType) {
		return _nodeExporters.getNodeTypeDependentObjects(nodeType);
	}

	public void setNodeExporter(Map<String, NodeExporter> nodeExporters) {
		_nodeExporters.setNodeTypeDependentObjects(nodeExporters);
	}

	private static NodeTypeDependentObjectRegistry<NodeExporter>
		_nodeExporters = new NodeTypeDependentObjectRegistry<NodeExporter>();

}