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

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.workflow.kaleo.runtime.ExecutionContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Michael C. Han
 */
public class WorkflowContextUtil {

	public static final String WORKFLOW_CONTEXT_NAME = "workflowContext";

	public static String convert(Map<String, Serializable> workflowContext) {
		if (workflowContext == null) {
			return StringPool.BLANK;
		}

		return JSONFactoryUtil.serialize(workflowContext);
	}

	public static Map<String, Serializable> convert(String json) {
		if (Validator.isNull(json)) {
			return new HashMap<String, Serializable>();
		}

		return (Map<String, Serializable>)JSONFactoryUtil.deserialize(json);
	}

	public static void mergeWorkflowContexts(
		ExecutionContext executionContext,
		Map<String, Serializable> workflowContext) {

		if ((workflowContext != null) && !workflowContext.isEmpty()) {
			Map<String, Serializable> executionContextWorkflowContext =
				executionContext.getWorkflowContext();

			executionContextWorkflowContext.putAll(workflowContext);
		}
	}

}