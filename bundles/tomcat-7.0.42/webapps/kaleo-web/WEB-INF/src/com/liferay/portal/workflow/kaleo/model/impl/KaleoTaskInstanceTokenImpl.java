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
import com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken;
import com.liferay.portal.workflow.kaleo.model.KaleoTask;
import com.liferay.portal.workflow.kaleo.model.KaleoTaskAssignmentInstance;
import com.liferay.portal.workflow.kaleo.service.KaleoInstanceTokenLocalServiceUtil;
import com.liferay.portal.workflow.kaleo.service.KaleoTaskAssignmentInstanceLocalServiceUtil;
import com.liferay.portal.workflow.kaleo.service.KaleoTaskLocalServiceUtil;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class KaleoTaskInstanceTokenImpl extends KaleoTaskInstanceTokenBaseImpl {

	public KaleoTaskInstanceTokenImpl() {
	}


	public KaleoInstanceToken getKaleoInstanceToken()
		throws PortalException, SystemException {

		return KaleoInstanceTokenLocalServiceUtil.getKaleoInstanceToken(
			getKaleoInstanceTokenId());
	}


	public KaleoTask getKaleoTask() throws PortalException, SystemException {
		return KaleoTaskLocalServiceUtil.getKaleoTask(getKaleoTaskId());
	}


	public List<KaleoTaskAssignmentInstance> getKaleoTaskAssignmentInstances()
		throws SystemException {

		return KaleoTaskAssignmentInstanceLocalServiceUtil.
			getKaleoTaskAssignmentInstances(getKaleoTaskInstanceTokenId());
	}

}