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

package com.liferay.portal.workflow.kaleo.runtime;

import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken;
import com.liferay.portal.workflow.kaleo.model.KaleoTaskInstanceToken;
import com.liferay.portal.workflow.kaleo.model.KaleoTimerInstanceToken;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Michael C. Han
 */
public class ExecutionContext implements Serializable {

	public ExecutionContext(
		KaleoInstanceToken kaleoInstanceToken,
		KaleoTaskInstanceToken kaleoTaskInstanceToken,
		Map<String, Serializable> workflowContext,
		ServiceContext serviceContext) {

		this(kaleoInstanceToken, workflowContext, serviceContext);

		_kaleoTaskInstanceToken = kaleoTaskInstanceToken;
	}

	public ExecutionContext(
		KaleoInstanceToken kaleoInstanceToken,
		KaleoTimerInstanceToken kaleoTimerInstanceToken,
		Map<String, Serializable> workflowContext,
		ServiceContext serviceContext) {

		this(kaleoInstanceToken, workflowContext, serviceContext);

		_kaleoTimerInstanceToken = kaleoTimerInstanceToken;
	}

	public ExecutionContext(
		KaleoInstanceToken kaleoInstanceToken,
		Map<String, Serializable> workflowContext,
		ServiceContext serviceContext) {

		_kaleoInstanceToken = kaleoInstanceToken;
		_workflowContext = new HashMap<String, Serializable>(workflowContext);
		_serviceContext = serviceContext;
	}

	public KaleoInstanceToken getKaleoInstanceToken() {
		return _kaleoInstanceToken;
	}

	public KaleoTaskInstanceToken getKaleoTaskInstanceToken() {
		return _kaleoTaskInstanceToken;
	}

	public KaleoTimerInstanceToken getKaleoTimerInstanceToken() {
		return _kaleoTimerInstanceToken;
	}

	public ServiceContext getServiceContext() {
		return _serviceContext;
	}

	public String getTransitionName() {
		return _transitionName;
	}

	public Map<String, Serializable> getWorkflowContext() {
		return _workflowContext;
	}

	public void setKaleoTaskInstanceToken(
		KaleoTaskInstanceToken kaleoTaskInstanceToken) {

		_kaleoTaskInstanceToken = kaleoTaskInstanceToken;
	}

	public void setKaleoTimerInstanceToken(
		KaleoTimerInstanceToken kaleoTimerInstanceToken) {

		_kaleoTimerInstanceToken = kaleoTimerInstanceToken;
	}

	public void setTransitionName(String transitionName) {
		_transitionName = transitionName;
	}

	private KaleoInstanceToken _kaleoInstanceToken;
	private KaleoTaskInstanceToken _kaleoTaskInstanceToken;
	private KaleoTimerInstanceToken _kaleoTimerInstanceToken;
	private ServiceContext _serviceContext;
	private String _transitionName;
	private Map<String, Serializable> _workflowContext;

}