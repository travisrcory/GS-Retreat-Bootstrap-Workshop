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
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.workflow.kaleo.model.KaleoDefinition;
import com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken;
import com.liferay.portal.workflow.kaleo.service.KaleoDefinitionLocalServiceUtil;
import com.liferay.portal.workflow.kaleo.service.KaleoInstanceTokenLocalServiceUtil;

import java.io.Serializable;

import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class KaleoInstanceImpl extends KaleoInstanceBaseImpl {

	public KaleoInstanceImpl() {
	}


	public KaleoDefinition getKaleoDefinition()
		throws PortalException, SystemException {

		return KaleoDefinitionLocalServiceUtil.getKaleoDefinition(
			getKaleoDefinitionId());
	}


	public KaleoInstanceToken getRootKaleoInstanceToken(
			Map<String, Serializable> workflowContext,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		return KaleoInstanceTokenLocalServiceUtil.getRootKaleoInstanceToken(
			getKaleoInstanceId(), workflowContext, serviceContext);
	}


	public KaleoInstanceToken getRootKaleoInstanceToken(
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		return getRootKaleoInstanceToken(null, serviceContext);
	}

}