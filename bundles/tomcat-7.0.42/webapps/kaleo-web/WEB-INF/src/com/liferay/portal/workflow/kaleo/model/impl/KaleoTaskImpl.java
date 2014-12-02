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

package com.liferay.portal.workflow.kaleo.model.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.workflow.kaleo.model.KaleoNode;
import com.liferay.portal.workflow.kaleo.model.KaleoTask;
import com.liferay.portal.workflow.kaleo.model.KaleoTaskAssignment;
import com.liferay.portal.workflow.kaleo.service.KaleoNodeLocalServiceUtil;
import com.liferay.portal.workflow.kaleo.service.KaleoTaskAssignmentLocalServiceUtil;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class KaleoTaskImpl extends KaleoTaskBaseImpl {

	public KaleoTaskImpl() {
	}


	public KaleoNode getKaleoNode() throws PortalException, SystemException {
		return KaleoNodeLocalServiceUtil.getKaleoNode(getKaleoNodeId());
	}


	public List<KaleoTaskAssignment> getKaleoTaskAssignments()
		throws SystemException {

		return KaleoTaskAssignmentLocalServiceUtil.getKaleoTaskAssignments(
			KaleoTask.class.getName(), getKaleoTaskId());
	}

}