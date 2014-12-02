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

package com.liferay.portal.workflow.kaleo.util;

import com.liferay.portal.workflow.kaleo.definition.NodeType;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Michael C. Han
 */
public class NodeTypeDependentObjectRegistry<T> {

	public T getNodeTypeDependentObjects(NodeType nodeType) {
		T nodeTypeDependentObject = _nodeTypeDependentObjects.get(nodeType);

		if (nodeTypeDependentObject == null) {
			throw new IllegalArgumentException("Invalid node type " + nodeType);
		}

		return nodeTypeDependentObject;
	}

	public T getNodeTypeDependentObjects(String nodeTypeString) {
		NodeType nodeType = NodeType.valueOf(nodeTypeString);

		return getNodeTypeDependentObjects(nodeType);
	}

	public void setNodeTypeDependentObjects(
		Map<String, T> nodeTypeDependentObjects) {

		_nodeTypeDependentObjects = new HashMap<NodeType, T>();

		for (Map.Entry<String, T> entry : nodeTypeDependentObjects.entrySet()) {
			NodeType nodeType = NodeType.valueOf(entry.getKey());

			_nodeTypeDependentObjects.put(nodeType, entry.getValue());
		}
	}

	private Map<NodeType, T> _nodeTypeDependentObjects;

}