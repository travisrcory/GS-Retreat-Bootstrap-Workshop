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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.workflow.kaleo.model.KaleoTaskAssignment;
import com.liferay.portal.workflow.kaleo.model.KaleoTaskInstanceToken;
import com.liferay.portal.workflow.kaleo.runtime.ExecutionContext;
import com.liferay.portal.workflow.kaleo.runtime.util.ClassLoaderUtil;
import com.liferay.portal.workflow.kaleo.service.KaleoTaskAssignmentInstanceLocalServiceUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Marcellus Tavares
 */
public class TaskAssignerUtil {

	public static void reassignKaleoTask(
			List<KaleoTaskAssignment> kaleoTaskAssignments,
			ExecutionContext executionContext)
		throws PortalException, SystemException {

		List<KaleoTaskAssignment> reassignedKaleoTaskAssignments =
			new ArrayList<KaleoTaskAssignment>();

		for (KaleoTaskAssignment kaleoTaskAssignment : kaleoTaskAssignments) {
			String[] assigneeScriptRequiredContexts = StringUtil.split(
				kaleoTaskAssignment.getAssigneeScriptRequiredContexts());

			ClassLoader[] classLoaders = ClassLoaderUtil.getClassLoaders(
				assigneeScriptRequiredContexts);

			Collection<KaleoTaskAssignment> calculatedKaleoTaskAssignments =
				_taskAssignmentSelector.calculateTaskAssignments(
					kaleoTaskAssignment, executionContext, classLoaders);

			reassignedKaleoTaskAssignments.addAll(
				calculatedKaleoTaskAssignments);
		}

		KaleoTaskInstanceToken kaleoTaskInstanceToken =
			executionContext.getKaleoTaskInstanceToken();

		KaleoTaskAssignmentInstanceLocalServiceUtil.
			deleteKaleoTaskAssignmentInstances(kaleoTaskInstanceToken);

		KaleoTaskAssignmentInstanceLocalServiceUtil.addTaskAssignmentInstances(
			kaleoTaskInstanceToken, reassignedKaleoTaskAssignments,
			executionContext.getWorkflowContext(),
			executionContext.getServiceContext());
	}

	public void setTaskAssignmentSelector(
		TaskAssignmentSelector taskAssignmentSelector) {

		_taskAssignmentSelector = taskAssignmentSelector;
	}

	private static TaskAssignmentSelector _taskAssignmentSelector;

}