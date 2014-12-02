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

package com.liferay.portal.workflow.kaleo.runtime.condition;

import com.liferay.portal.kernel.bi.rules.Fact;
import com.liferay.portal.kernel.bi.rules.Query;
import com.liferay.portal.kernel.bi.rules.RulesEngineUtil;
import com.liferay.portal.kernel.bi.rules.RulesResourceRetriever;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.resource.StringResourceRetriever;
import com.liferay.portal.workflow.kaleo.model.KaleoCondition;
import com.liferay.portal.workflow.kaleo.runtime.ExecutionContext;
import com.liferay.portal.workflow.kaleo.runtime.util.RulesContextBuilder;
import com.liferay.portal.workflow.kaleo.util.WorkflowContextUtil;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * @author Michael C. Han
 */
public class DRLConditionEvaluator implements ConditionEvaluator {


	public String evaluate(
			KaleoCondition kaleoCondition, ExecutionContext executionContext,
			ClassLoader... classloaders)
		throws PortalException, SystemException {

		List<Fact<?>> facts = RulesContextBuilder.buildRulesContext(
			executionContext);

		RulesResourceRetriever rulesResourceRetriever =
			new RulesResourceRetriever(
				new StringResourceRetriever(kaleoCondition.getScript()));

		Query query = Query.createStandardQuery();

		Map<String, ?> results = RulesEngineUtil.execute(
			rulesResourceRetriever, facts, query, classloaders);

		String returnValue = (String)results.get(_RETURN_VALUE);

		Map<String, Serializable> resultsWorkflowContext =
			(Map<String, Serializable>)results.get(
				WorkflowContextUtil.WORKFLOW_CONTEXT_NAME);

		WorkflowContextUtil.mergeWorkflowContexts(
			executionContext, resultsWorkflowContext);

		if (returnValue != null) {
			return returnValue;
		}

		throw new IllegalStateException(
			"Conditional did not return value for script " +
				kaleoCondition.getScript());
	}

	private static final String _RETURN_VALUE = "returnValue";

}