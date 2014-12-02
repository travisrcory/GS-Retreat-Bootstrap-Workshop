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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.workflow.kaleo.definition.ScriptLanguage;
import com.liferay.portal.workflow.kaleo.model.KaleoCondition;
import com.liferay.portal.workflow.kaleo.runtime.ExecutionContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Michael C. Han
 */
public class MultiLanguageConditionEvaluator implements ConditionEvaluator {


	public String evaluate(
			KaleoCondition kaleoCondition, ExecutionContext executionContext,
			ClassLoader... classLoaders)
		throws PortalException, SystemException {

		ScriptLanguage scriptLanguage = ScriptLanguage.parse(
			kaleoCondition.getScriptLanguage());

		ConditionEvaluator conditionEvaluator = _conditionEvaluators.get(
			scriptLanguage);

		if (conditionEvaluator == null) {
			throw new IllegalArgumentException(
				"No condition evaluator found for script language " +
					scriptLanguage);
		}

		return conditionEvaluator.evaluate(
			kaleoCondition, executionContext, classLoaders);
	}

	public void setConditionEvaluators(
		Map<String, ConditionEvaluator> conditionEvaluators) {

		for (Map.Entry<String, ConditionEvaluator> entry :
				conditionEvaluators.entrySet()) {

			ScriptLanguage scriptLanguage = ScriptLanguage.parse(
				entry.getKey());

			_conditionEvaluators.put(scriptLanguage, entry.getValue());
		}
	}

	private Map<ScriptLanguage, ConditionEvaluator> _conditionEvaluators =
		new HashMap<ScriptLanguage, ConditionEvaluator>();

}