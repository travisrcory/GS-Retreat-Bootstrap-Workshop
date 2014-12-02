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

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken;
import com.liferay.portal.workflow.kaleo.model.KaleoTaskInstanceToken;
import com.liferay.portal.workflow.kaleo.runtime.ExecutionContext;
import com.liferay.portal.workflow.kaleo.service.KaleoInstanceTokenLocalServiceUtil;
import com.liferay.portal.workflow.kaleo.service.KaleoTaskInstanceTokenLocalServiceUtil;
import com.liferay.portal.workflow.kaleo.util.WorkflowContextUtil;

import java.io.Serializable;

import java.util.Map;

/**
 * @author Marcellus Tavares
 */
public class ExecutionContextUtil {

	public static String convert(ExecutionContext executionContext) {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		KaleoInstanceToken kaleoInstanceToken =
			executionContext.getKaleoInstanceToken();

		if (kaleoInstanceToken != null) {
			jsonObject.put(
				"kaleoInstanceTokenId",
				kaleoInstanceToken.getKaleoInstanceTokenId());
		}

		KaleoTaskInstanceToken kaleoTaskInstanceToken =
			executionContext.getKaleoTaskInstanceToken();

		if (kaleoTaskInstanceToken != null) {
			jsonObject.put(
				"kaleoTaskInstanceTokenId",
				kaleoTaskInstanceToken.getKaleoTaskInstanceTokenId());
		}

		Map<String, Serializable> workflowContext =
			executionContext.getWorkflowContext();

		jsonObject.put(
			"workflowContext", WorkflowContextUtil.convert(workflowContext));

		ServiceContext serviceContext = executionContext.getServiceContext();

		jsonObject.put(
			"serviceContext", JSONFactoryUtil.serialize(serviceContext));

		jsonObject.put("transitionName", executionContext.getTransitionName());

		return jsonObject.toString();
	}

	public static ExecutionContext convert(String json) throws Exception {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(json);

		KaleoInstanceToken kaleoInstanceToken = null;

		long kaleoInstanceTokenId = jsonObject.getLong("kaleoInstanceTokenId");

		if (kaleoInstanceTokenId > 0) {
			kaleoInstanceToken =
				KaleoInstanceTokenLocalServiceUtil.getKaleoInstanceToken(
					kaleoInstanceTokenId);
		}

		KaleoTaskInstanceToken kaleoTaskInstanceToken = null;

		long kaleoTaskInstanceTokenId = jsonObject.getLong(
			"kaleoTaskInstanceTokenId");

		if (kaleoTaskInstanceTokenId > 0) {
			kaleoTaskInstanceToken =
				KaleoTaskInstanceTokenLocalServiceUtil.
					getKaleoTaskInstanceToken(kaleoTaskInstanceTokenId);
		}

		Map<String, Serializable> workflowContext = WorkflowContextUtil.convert(
			jsonObject.getString("workflowContext"));

		ServiceContext serviceContext =
			(ServiceContext)JSONFactoryUtil.deserialize(
					jsonObject.getString("serviceContext"));

		return new ExecutionContext(
			kaleoInstanceToken, kaleoTaskInstanceToken, workflowContext,
			serviceContext);
	}

}