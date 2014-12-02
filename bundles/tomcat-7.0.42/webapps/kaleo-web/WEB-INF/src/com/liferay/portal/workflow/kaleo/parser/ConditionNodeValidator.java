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
import com.liferay.portal.workflow.kaleo.definition.Condition;
import com.liferay.portal.workflow.kaleo.definition.Definition;

/**
 * @author Michael C. Han
 * @author Marcellus Tavares
 */
public class ConditionNodeValidator extends BaseNodeValidator<Condition> {


	protected void doValidate(Definition definition, Condition condition)
		throws WorkflowException {

		if (condition.getIncomingTransitionsCount() == 0) {
			throw new WorkflowException(
				"No incoming transition found for condition " +
					condition.getName());
		}

		if (condition.getOutgoingTransitionsCount() < 2) {
			throw new WorkflowException(
				"Less than 2 outgoing transitions found for condition " +
					condition.getName());
		}
	}

}