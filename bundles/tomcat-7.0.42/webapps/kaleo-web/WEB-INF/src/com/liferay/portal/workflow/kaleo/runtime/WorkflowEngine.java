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

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.workflow.WorkflowDefinition;
import com.liferay.portal.kernel.workflow.WorkflowException;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.service.ServiceContext;

import java.io.InputStream;
import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * @author Michael C. Han
 * @author Marcellus Tavares
 */
public interface WorkflowEngine {

	public void deleteWorkflowDefinition(
			String name, int version, ServiceContext serviceContext)
		throws WorkflowException;

	public void deleteWorkflowInstance(
			long workflowInstanceId, ServiceContext serviceContext)
		throws WorkflowException;

	public WorkflowDefinition deployWorkflowDefinition(
			String title, InputStream inputStream,
			ServiceContext serviceContext)
		throws WorkflowException;

	public ExecutionContext executeTimerWorkflowInstance(
			long kaleoTimerInstanceTokenId, ServiceContext serviceContext,
			Map<String, Serializable> workflowContext)
		throws WorkflowException;

	public List<String> getNextTransitionNames(
			long workflowInstanceId, ServiceContext serviceContext)
		throws WorkflowException;

	public WorkflowInstance getWorkflowInstance(
			long workflowInstanceId, ServiceContext serviceContext)
		throws WorkflowException;

	public int getWorkflowInstanceCount(
			Long userId, String assetClassName, Long assetClassPK,
			Boolean completed, ServiceContext serviceContext)
		throws WorkflowException;

	public int getWorkflowInstanceCount(
			Long userId, String[] assetClassNames, Boolean completed,
			ServiceContext serviceContext)
		throws WorkflowException;

	public int getWorkflowInstanceCount(
			String workflowDefinitionName, int workflowDefinitionVersion,
			boolean completed, ServiceContext serviceContext)
		throws WorkflowException;

	public List<WorkflowInstance> getWorkflowInstances(
			Long userId, String assetClassName, Long assetClassPK,
			Boolean completed, int start, int end,
			OrderByComparator orderByComparator, ServiceContext serviceContext)
		throws WorkflowException;

	public List<WorkflowInstance> getWorkflowInstances(
			Long userId, String[] assetClassNames, Boolean completed, int start,
			int end, OrderByComparator orderByComparator,
			ServiceContext serviceContext)
		throws WorkflowException;

	public List<WorkflowInstance> getWorkflowInstances(
			String workflowDefinitionName, int workflowDefinitionVersion,
			boolean completed, int start, int end,
			OrderByComparator orderByComparator, ServiceContext serviceContext)
		throws WorkflowException;

	public WorkflowInstance signalWorkflowInstance(
			long workflowInstanceId, String transitionName,
			Map<String, Serializable> workflowContext,
			ServiceContext serviceContext)
		throws WorkflowException;

	public WorkflowInstance startWorkflowInstance(
			String workflowDefinitionName, Integer workflowDefinitionVersion,
			String transitionName, Map<String, Serializable> workflowContext,
			ServiceContext serviceContext)
		throws WorkflowException;

	public WorkflowInstance updateContext(
			long workflowInstanceId, Map<String, Serializable> workflowContext,
			ServiceContext serviceContext)
		throws WorkflowException;

	public void validateWorkflowDefinition(InputStream inputStream)
		throws WorkflowException;

}