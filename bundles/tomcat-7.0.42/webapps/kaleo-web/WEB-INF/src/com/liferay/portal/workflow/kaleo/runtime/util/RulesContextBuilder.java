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

package com.liferay.portal.workflow.kaleo.runtime.util;

import com.liferay.portal.kernel.bi.rules.Fact;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.workflow.WorkflowTaskAssignee;
import com.liferay.portal.workflow.kaleo.model.KaleoInstance;
import com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken;
import com.liferay.portal.workflow.kaleo.model.KaleoTask;
import com.liferay.portal.workflow.kaleo.model.KaleoTaskInstanceToken;
import com.liferay.portal.workflow.kaleo.runtime.ExecutionContext;
import com.liferay.portal.workflow.kaleo.util.KaleoTaskAssignmentInstanceUtil;
import com.liferay.portal.workflow.kaleo.util.WorkflowContextUtil;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Michael C. Han
 */
public class RulesContextBuilder {

	public static List<Fact<?>> buildRulesContext(
			ExecutionContext executionContext)
		throws PortalException, SystemException {

		Map<String, Serializable> workflowContext =
			executionContext.getWorkflowContext();

		if (workflowContext == null) {
			KaleoInstanceToken kaleoInstanceToken =
				executionContext.getKaleoInstanceToken();

			KaleoInstance kaleoInstance = kaleoInstanceToken.getKaleoInstance();

			workflowContext = WorkflowContextUtil.convert(
				kaleoInstance.getWorkflowContext());
		}

		List<Fact<?>> facts = new ArrayList<Fact<?>>(
			workflowContext.size() + 4);

		facts.add(
			new Fact<Map<String, Serializable>>(
				"workflowContext", workflowContext));

		KaleoTaskInstanceToken kaleoTaskInstanceToken =
			executionContext.getKaleoTaskInstanceToken();

		if (kaleoTaskInstanceToken != null) {
			KaleoTask kaleoTask = kaleoTaskInstanceToken.getKaleoTask();

			facts.add(new Fact<String>("taskName", kaleoTask.getName()));

			facts.add(
				new Fact<Long>("userId", kaleoTaskInstanceToken.getUserId()));

			List<WorkflowTaskAssignee> workflowTaskAssignees =
				KaleoTaskAssignmentInstanceUtil.getWorkflowTaskAssignees(
					kaleoTaskInstanceToken);

			facts.add(
				new Fact<List<WorkflowTaskAssignee>>(
					"workflowTaskAssignees", workflowTaskAssignees));
		}
		else {
			KaleoInstanceToken kaleoInstanceToken =
				executionContext.getKaleoInstanceToken();

			facts.add(new Fact<Long>("userId", kaleoInstanceToken.getUserId()));
		}

		return facts;
	}

}