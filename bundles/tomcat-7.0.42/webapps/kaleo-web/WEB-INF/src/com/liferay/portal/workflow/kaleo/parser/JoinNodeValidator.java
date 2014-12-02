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
import com.liferay.portal.workflow.kaleo.definition.Join;

/**
 * @author Michael C. Han
 * @author Marcellus Tavares
 */
public class JoinNodeValidator extends BaseNodeValidator<Join> {


	protected void doValidate(Definition definition, Join join)
		throws WorkflowException {

		if (join.getIncomingTransitionsCount() == 0) {
			throw new WorkflowException(
				"No incoming transition found for join " + join.getName());
		}

		if (join.getOutgoingTransitionsCount() == 0) {
			throw new WorkflowException(
				"No outgoing transition found for join " + join.getName());
		}
	}

}