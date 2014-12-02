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
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken;
import com.liferay.portal.workflow.kaleo.model.KaleoTaskAssignment;
import com.liferay.portal.workflow.kaleo.runtime.ExecutionContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Michael C. Han
 */
public class GroupAwareRoleTaskAssignmentSelector
	implements TaskAssignmentSelector {


	public Collection<KaleoTaskAssignment> calculateTaskAssignments(
			KaleoTaskAssignment kaleoTaskAssignment,
			ExecutionContext executionContext, ClassLoader... classLoaders)
		throws PortalException, SystemException {

		KaleoInstanceToken kaleoInstanceToken =
			executionContext.getKaleoInstanceToken();

		Group group = null;

		long groupId = kaleoInstanceToken.getGroupId();

		if (groupId != WorkflowConstants.DEFAULT_GROUP_ID) {
			group = GroupLocalServiceUtil.getGroup(groupId);

			if (group.isLayout()) {
				group = GroupLocalServiceUtil.getGroup(
					group.getParentGroupId());
			}
		}

		List<KaleoTaskAssignment> calculatedKaleoTaskAssignments =
			new ArrayList<KaleoTaskAssignment>();

		if (isValidAssignment(kaleoTaskAssignment, group)) {
			calculatedKaleoTaskAssignments.add(kaleoTaskAssignment);
		}

		return calculatedKaleoTaskAssignments;
	}

	protected boolean isValidAssignment(
			KaleoTaskAssignment kaleoTaskAssignment, Group group)
		throws PortalException, SystemException {

		long roleId = kaleoTaskAssignment.getAssigneeClassPK();

		Role role = RoleLocalServiceUtil.getRole(roleId);

		if (role.getType() == RoleConstants.TYPE_REGULAR) {
			return true;
		}
		else if ((group != null) && group.isOrganization() &&
				 (role.getType() == RoleConstants.TYPE_ORGANIZATION)) {

			return true;
		}
		else if ((group != null) && group.isSite() &&
				 (role.getType() == RoleConstants.TYPE_SITE)) {

			return true;
		}

		return false;
	}

}