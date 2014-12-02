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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.workflow.WorkflowTaskAssignee;
import com.liferay.portal.workflow.kaleo.model.KaleoTaskAssignmentInstance;
import com.liferay.portal.workflow.kaleo.model.KaleoTaskInstanceToken;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael C. Han
 */
public class KaleoTaskAssignmentInstanceUtil {

	public static List<WorkflowTaskAssignee> getWorkflowTaskAssignees(
			KaleoTaskInstanceToken kaleoTaskInstanceToken)
		throws SystemException {

		List<KaleoTaskAssignmentInstance> kaleoTaskAssignmentInstances =
			kaleoTaskInstanceToken.getKaleoTaskAssignmentInstances();

		List<WorkflowTaskAssignee> workflowTaskAssignees =
			new ArrayList<WorkflowTaskAssignee>(
				kaleoTaskAssignmentInstances.size());

		for (KaleoTaskAssignmentInstance kaleoTaskAssignmentInstance :
				kaleoTaskAssignmentInstances) {

			WorkflowTaskAssignee workflowTaskAssignee =
				new WorkflowTaskAssignee(
					kaleoTaskAssignmentInstance.getAssigneeClassName(),
					kaleoTaskAssignmentInstance.getAssigneeClassPK());

			workflowTaskAssignees.add(workflowTaskAssignee);
		}

		return workflowTaskAssignees;
	}

}