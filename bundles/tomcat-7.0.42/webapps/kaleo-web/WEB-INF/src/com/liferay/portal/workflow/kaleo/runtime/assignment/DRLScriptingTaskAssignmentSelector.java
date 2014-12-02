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

import com.liferay.portal.kernel.bi.rules.Fact;
import com.liferay.portal.kernel.bi.rules.Query;
import com.liferay.portal.kernel.bi.rules.RulesEngineUtil;
import com.liferay.portal.kernel.bi.rules.RulesResourceRetriever;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.resource.StringResourceRetriever;
import com.liferay.portal.workflow.kaleo.model.KaleoTaskAssignment;
import com.liferay.portal.workflow.kaleo.runtime.ExecutionContext;
import com.liferay.portal.workflow.kaleo.runtime.util.RulesContextBuilder;
import com.liferay.portal.workflow.kaleo.util.WorkflowContextUtil;

import java.io.Serializable;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author Michael C. Han
 */
public class DRLScriptingTaskAssignmentSelector
	extends BaseTaskAssignmentSelector {


	public Collection<KaleoTaskAssignment> calculateTaskAssignments(
			KaleoTaskAssignment kaleoTaskAssignment,
			ExecutionContext executionContext, ClassLoader... classLoaders)
		throws PortalException, SystemException {

		List<Fact<?>> facts = RulesContextBuilder.buildRulesContext(
			executionContext);

		String assigneeScript = kaleoTaskAssignment.getAssigneeScript();

		RulesResourceRetriever rulesResourceRetriever =
			new RulesResourceRetriever(
				new StringResourceRetriever(assigneeScript));

		Query query = Query.createStandardQuery();

		Map<String, ?> results = RulesEngineUtil.execute(
			rulesResourceRetriever, facts, query, classLoaders);

		Map<String, Serializable> resultsWorkflowContext =
			(Map<String, Serializable>)results.get(
				WorkflowContextUtil.WORKFLOW_CONTEXT_NAME);

		WorkflowContextUtil.mergeWorkflowContexts(
			executionContext, resultsWorkflowContext);

		return getKaleoTaskAssignments(results);
	}

}