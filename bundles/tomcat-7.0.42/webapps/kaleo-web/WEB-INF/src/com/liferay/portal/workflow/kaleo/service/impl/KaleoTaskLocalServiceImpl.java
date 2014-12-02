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

package com.liferay.portal.workflow.kaleo.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.workflow.kaleo.definition.Assignment;
import com.liferay.portal.workflow.kaleo.definition.Task;
import com.liferay.portal.workflow.kaleo.model.KaleoTask;
import com.liferay.portal.workflow.kaleo.service.base.KaleoTaskLocalServiceBaseImpl;

import java.util.Date;
import java.util.Set;

/**
 * @author Brian Wing Shun Chan
 */
public class KaleoTaskLocalServiceImpl extends KaleoTaskLocalServiceBaseImpl {


	public KaleoTask addKaleoTask(
			long kaleoDefinitionId, long kaleoNodeId, Task task,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		// Kaleo task

		User user = userPersistence.findByPrimaryKey(
			serviceContext.getGuestOrUserId());
		Date now = new Date();

		long kaleoTaskId = counterLocalService.increment();

		KaleoTask kaleoTask = kaleoTaskPersistence.create(kaleoTaskId);

		kaleoTask.setCompanyId(user.getCompanyId());
		kaleoTask.setUserId(user.getUserId());
		kaleoTask.setUserName(user.getFullName());
		kaleoTask.setCreateDate(now);
		kaleoTask.setModifiedDate(now);
		kaleoTask.setKaleoDefinitionId(kaleoDefinitionId);
		kaleoTask.setKaleoNodeId(kaleoNodeId);
		kaleoTask.setName(task.getName());

		kaleoTaskPersistence.update(kaleoTask);

		// Kaleo assignments

		Set<Assignment> assignments = task.getAssignments();

		for (Assignment assignment : assignments) {
			kaleoTaskAssignmentLocalService.addKaleoTaskAssignment(
				KaleoTask.class.getName(), kaleoTaskId, kaleoDefinitionId,
				assignment, serviceContext);
		}

		return kaleoTask;
	}


	public void deleteCompanyKaleoTasks(long companyId) throws SystemException {

		// Kaleo tasks

		kaleoTaskPersistence.removeByCompanyId(companyId);

		// Kaleo task assignments

		kaleoTaskAssignmentLocalService.deleteCompanyKaleoTaskAssignments(
			companyId);
	}


	public void deleteKaleoDefinitionKaleoTasks(long kaleoDefinitionId)
		throws SystemException {

		// Kaleo tasks

		kaleoTaskPersistence.removeByKaleoDefinitionId(kaleoDefinitionId);

		// Kaleo task assignments

		kaleoTaskAssignmentLocalService.
			deleteKaleoDefinitionKaleoTaskAssignments(kaleoDefinitionId);
	}


	public KaleoTask getKaleoNodeKaleoTask(long kaleoNodeId)
		throws PortalException, SystemException {

		return kaleoTaskPersistence.findByKaleoNodeId(kaleoNodeId);
	}

}