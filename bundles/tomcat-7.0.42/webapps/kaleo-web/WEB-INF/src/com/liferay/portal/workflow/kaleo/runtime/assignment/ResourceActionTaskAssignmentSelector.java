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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.workflow.kaleo.model.KaleoTaskAssignment;
import com.liferay.portal.workflow.kaleo.runtime.ExecutionContext;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author Michael C. Han
 * @author Eduardo Lundgren
 */
public class ResourceActionTaskAssignmentSelector
	extends BaseTaskAssignmentSelector {


	public Collection<KaleoTaskAssignment> calculateTaskAssignments(
			KaleoTaskAssignment kaleoTaskAssignment,
			ExecutionContext executionContext, ClassLoader... classLoaders)
		throws SystemException {

		ServiceContext serviceContext = executionContext.getServiceContext();

		Map<String, Serializable> workflowContext =
			executionContext.getWorkflowContext();

		ServiceContext workflowContextServiceContext =
			(ServiceContext)workflowContext.get(
				WorkflowConstants.CONTEXT_SERVICE_CONTEXT);

		String resourceName = GetterUtil.getString(
			(String)workflowContextServiceContext.getAttribute(
				WorkflowConstants.CONTEXT_ENTRY_CLASS_NAME),
			(String)workflowContext.get(
				WorkflowConstants.CONTEXT_ENTRY_CLASS_NAME));

		String resourceClassPK = GetterUtil.getString(
			(String)workflowContextServiceContext.getAttribute(
				WorkflowConstants.CONTEXT_ENTRY_CLASS_PK),
			(String)workflowContext.get(
				WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

		List<Role> roles = RoleLocalServiceUtil.getResourceRoles(
			serviceContext.getCompanyId(), resourceName,
			ResourceConstants.SCOPE_INDIVIDUAL, resourceClassPK,
			kaleoTaskAssignment.getAssigneeActionId());

		List<KaleoTaskAssignment> kaleoTaskAssignments =
			new ArrayList<KaleoTaskAssignment>(roles.size());

		getRoleKaleoTaskAssignments(roles, kaleoTaskAssignments);

		return kaleoTaskAssignments;
	}

}