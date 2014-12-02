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

import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.workflow.kaleo.model.KaleoTaskAssignment;
import com.liferay.portal.workflow.kaleo.model.impl.KaleoTaskAssignmentImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author Michael C. Han
 */
public abstract class BaseTaskAssignmentSelector
	implements TaskAssignmentSelector {

	protected Collection<KaleoTaskAssignment> getKaleoTaskAssignments(
		Map<String, ?> results) {

		List<KaleoTaskAssignment> kaleoTaskAssignments =
			new ArrayList<KaleoTaskAssignment>();

		User user = (User)results.get(USER_ASSIGNMENT);

		if (user != null) {
			KaleoTaskAssignment kaleoTaskAssignment =
				getUserKaleoTaskAssignment(user);

			kaleoTaskAssignments.add(kaleoTaskAssignment);
		}
		else {
			List<Role> roles = (List<Role>)results.get(ROLES_ASSIGNMENT);

			getRoleKaleoTaskAssignments(roles, kaleoTaskAssignments);
		}

		return kaleoTaskAssignments;
	}

	protected void getRoleKaleoTaskAssignments(
		List<Role> roles, List<KaleoTaskAssignment> kaleoTaskAssignments) {

		if (roles == null) {
			return;
		}

		for (Role role : roles) {
			KaleoTaskAssignment kaleoTaskAssignment =
				new KaleoTaskAssignmentImpl();

			kaleoTaskAssignment.setAssigneeClassName(Role.class.getName());
			kaleoTaskAssignment.setAssigneeClassPK(role.getRoleId());

			kaleoTaskAssignments.add(kaleoTaskAssignment);
		}
	}

	protected KaleoTaskAssignment getUserKaleoTaskAssignment(User user) {
		KaleoTaskAssignment kaleoTaskAssignment = new KaleoTaskAssignmentImpl();

		kaleoTaskAssignment.setAssigneeClassName(User.class.getName());
		kaleoTaskAssignment.setAssigneeClassPK(user.getUserId());

		return kaleoTaskAssignment;
	}

	protected static final String ROLES_ASSIGNMENT = "roles";

	protected static final String USER_ASSIGNMENT = "user";

}