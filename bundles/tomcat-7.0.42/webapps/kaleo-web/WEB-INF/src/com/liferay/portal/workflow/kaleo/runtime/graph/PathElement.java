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

import com.liferay.portal.workflow.kaleo.model.KaleoNode;
import com.liferay.portal.workflow.kaleo.runtime.ExecutionContext;

import java.io.Serializable;

/**
 * @author Michael C. Han
 */
public class PathElement implements Serializable {

	public PathElement(
		KaleoNode startKaleoNode, KaleoNode targetKaleoNode,
		ExecutionContext executionContext) {

		_startNode = startKaleoNode;
		_targetNode = targetKaleoNode;
		_executionContext = executionContext;
	}

	public ExecutionContext getExecutionContext() {
		return _executionContext;
	}

	public KaleoNode getStartNode() {
		return _startNode;
	}

	public KaleoNode getTargetNode() {
		return _targetNode;
	}

	private ExecutionContext _executionContext;
	private KaleoNode _startNode;
	private KaleoNode _targetNode;

}