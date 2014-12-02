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

package com.liferay.portal.workflow.kaleo.definition;

/**
 * @author Michael C. Han
 */
public class Transition {

	public Transition(
		String name, Node sourceNode, Node targetNode, boolean defaultValue) {

		_name = name;
		_sourceNode = sourceNode;
		_targetNode = targetNode;
		_default = defaultValue;
	}

	public String getName() {
		return _name;
	}

	public Node getSourceNode() {
		return _sourceNode;
	}

	public Node getTargetNode() {
		return _targetNode;
	}

	public Timer getTimer() {
		return _timer;
	}

	public boolean isDefault() {
		return _default;
	}

	public void setTimers(Timer timer) {
		_timer = timer;
	}

	private boolean _default;
	private String _name;
	private Node _sourceNode;
	private Node _targetNode;
	private Timer _timer;

}