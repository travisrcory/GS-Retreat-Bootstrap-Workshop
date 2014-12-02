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
import com.liferay.portal.workflow.kaleo.definition.Assignment;
import com.liferay.portal.workflow.kaleo.definition.Definition;
import com.liferay.portal.workflow.kaleo.definition.Task;

import java.util.Set;

/**
 * @author Michael C. Han
 * @author Marcellus Tavares
 */
public class TaskNodeValidator extends BaseNodeValidator<Task> {


	protected void doValidate(Definition definition, Task task)
		throws WorkflowException {

		if (task.getIncomingTransitionsCount() == 0) {
			throw new WorkflowException(
				"No incoming transition found for task " + task.getName());
		}

		if (task.getOutgoingTransitionsCount() == 0) {
			throw new WorkflowException(
				"No outgoing transition found for task " + task.getName());
		}

		Set<Assignment> assignments = task.getAssignments();

		if ((assignments == null) || assignments.isEmpty()) {
			throw new WorkflowException(
				"No assignments for task " + task.getName());
		}
	}

}