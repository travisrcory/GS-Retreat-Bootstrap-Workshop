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
import com.liferay.portal.workflow.kaleo.definition.State;

/**
 * @author Michael C. Han
 * @author Marcellus Tavares
 */
public class StateNodeValidator extends BaseNodeValidator<State> {


	protected void doValidate(Definition definition, State state)
		throws WorkflowException {

		if (state.isInitial()) {
			validateInitialState(definition, state);
		}
		else if (state.getIncomingTransitionsCount() == 0) {
			throw new WorkflowException(
				"No incoming transition found for state " + state.getName());
		}
	}

	protected void validateInitialState(Definition definition, State state)
		throws WorkflowException {

		State initialState = definition.getInitialState();

		if (!Validator.equals(initialState, state)) {
			throw new WorkflowException(
				"Multiple initial states " + state.getName() + " and " +
					initialState.getName());
		}

		if (state.getIncomingTransitionsCount() > 0) {
			throw new WorkflowException(
				"An incoming transition was found for initial state " +
					state.getName());
		}

		if (state.getOutgoingTransitionsCount() == 0) {
			throw new WorkflowException(
				"No outgoing transition found for initial state " +
					state.getName());
		}
	}

}