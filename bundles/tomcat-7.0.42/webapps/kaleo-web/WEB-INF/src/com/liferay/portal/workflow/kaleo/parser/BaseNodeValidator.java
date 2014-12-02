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

import com.liferay.portal.kernel.workflow.WorkflowException;
import com.liferay.portal.workflow.kaleo.definition.Definition;
import com.liferay.portal.workflow.kaleo.definition.Node;
import com.liferay.portal.workflow.kaleo.definition.Transition;

import java.util.Map;

/**
 * @author Michael C. Han
 */
public abstract class BaseNodeValidator<T extends Node>
	implements NodeValidator<T> {


	public void validate(Definition definition, T node)
		throws WorkflowException {

		doValidate(definition, node);

		validateTransitions(node.getOutgoingTransitions());
	}

	protected abstract void doValidate(Definition definition, T node)
		throws WorkflowException;

	protected void validateTransition(Transition transition)
		throws WorkflowException {

		if (transition.getTargetNode() == null) {
			throw new WorkflowException(
				"Unable to find target node for transition " +
					transition.getName());
		}
	}

	protected void validateTransitions(Map<String, Transition> transitions)
		throws WorkflowException {

		for (Transition transition : transitions.values()) {
			validateTransition(transition);
		}
	}

}