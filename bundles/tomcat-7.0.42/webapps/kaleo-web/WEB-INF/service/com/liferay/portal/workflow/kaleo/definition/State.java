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

import java.util.Map;

/**
 * @author Michael C. Han
 */
public class State extends Node {

	public State(String name, String description, boolean initial) {
		super(NodeType.STATE, name, description);

		_initial = initial;
	}

	public boolean isInitial() {
		return _initial;
	}

	public boolean isTerminal() {
		Map<String, Transition> outgoingTransitions = getOutgoingTransitions();

		return outgoingTransitions.isEmpty();
	}

	private boolean _initial;

}