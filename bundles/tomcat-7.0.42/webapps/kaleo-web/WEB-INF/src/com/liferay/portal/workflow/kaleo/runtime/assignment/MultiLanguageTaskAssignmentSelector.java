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

package com.liferay.portal.workflow.kaleo.runtime.assignment;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.ResourceAction;
import com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken;
import com.liferay.portal.workflow.kaleo.model.KaleoTaskAssignment;
import com.liferay.portal.workflow.kaleo.runtime.ExecutionContext;
import com.liferay.portal.workflow.kaleo.service.KaleoInstanceLocalServiceUtil;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Michael C. Han
 */
public class MultiLanguageTaskAssignmentSelector
	extends BaseTaskAssignmentSelector {


	public Collection<KaleoTaskAssignment> calculateTaskAssignments(
			KaleoTaskAssignment kaleoTaskAssignment,
			ExecutionContext executionContext, ClassLoader... classLoaders)
		throws PortalException, SystemException {

		String assigneeClassName = kaleoTaskAssignment.getAssigneeClassName();

		TaskAssignmentSelector taskAssignmentSelector = null;

		if (assigneeClassName.equals(ResourceAction.class.getName())) {
			taskAssignmentSelector = _taskAssignmentSelectors.get(
				assigneeClassName);
		}
		else {
			String assigneeScriptLanguage =
				kaleoTaskAssignment.getAssigneeScriptLanguage();

			taskAssignmentSelector = _taskAssignmentSelectors.get(
				assigneeScriptLanguage);
		}

		if (taskAssignmentSelector == null) {
			throw new IllegalArgumentException(
				"No task assignment selector found for " +
					kaleoTaskAssignment.toXmlString());
		}

		Collection<KaleoTaskAssignment> taskAssignments =
			taskAssignmentSelector.calculateTaskAssignments(
				kaleoTaskAssignment, executionContext, classLoaders);

		KaleoInstanceToken kaleoInstanceToken =
			executionContext.getKaleoInstanceToken();

		KaleoInstanceLocalServiceUtil.updateKaleoInstance(
			kaleoInstanceToken.getKaleoInstanceId(),
			executionContext.getWorkflowContext(),
			executionContext.getServiceContext());

		return taskAssignments;
	}

	public void setTaskAssignmentSelectors(
		Map<String, TaskAssignmentSelector> taskAssignmentSelectors) {

		_taskAssignmentSelectors.putAll(taskAssignmentSelectors);
	}

	private Map<String, TaskAssignmentSelector> _taskAssignmentSelectors =
		new HashMap<String, TaskAssignmentSelector>();

}