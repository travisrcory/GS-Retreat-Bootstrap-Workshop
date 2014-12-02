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

package com.liferay.portal.workflow.kaleo.export.builder;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.workflow.kaleo.definition.Assignment;
import com.liferay.portal.workflow.kaleo.definition.Node;
import com.liferay.portal.workflow.kaleo.definition.Task;
import com.liferay.portal.workflow.kaleo.model.KaleoNode;
import com.liferay.portal.workflow.kaleo.model.KaleoTask;

import java.util.Set;

/**
 * @author Michael C. Han
 */
public class TaskNodeBuilder extends BaseNodeBuilder implements NodeBuilder {


	protected Node createNode(KaleoNode kaleoNode)
		throws PortalException, SystemException {

		KaleoTask kaleoTask = kaleoTaskLocalService.getKaleoNodeKaleoTask(
			kaleoNode.getKaleoNodeId());

		Task task = new Task(kaleoNode.getName(), kaleoNode.getDescription());

		Set<Assignment> assignments = buildAssigments(
			KaleoTask.class.getName(), kaleoTask.getKaleoTaskId());

		task.setAssignments(assignments);

		return task;
	}

}