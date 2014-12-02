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
import com.liferay.portal.workflow.kaleo.definition.Action;
import com.liferay.portal.workflow.kaleo.model.KaleoAction;
import com.liferay.portal.workflow.kaleo.service.base.KaleoActionLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class KaleoActionLocalServiceImpl
	extends KaleoActionLocalServiceBaseImpl {


	public KaleoAction addKaleoAction(
			String kaleoClassName, long kaleoClassPK, long kaleoDefinitionId,
			String kaleoNodeName, Action action, ServiceContext serviceContext)
		throws PortalException, SystemException {

		User user = userPersistence.findByPrimaryKey(
			serviceContext.getGuestOrUserId());
		Date now = new Date();

		long kaleoActionId = counterLocalService.increment();

		KaleoAction kaleoAction = kaleoActionPersistence.create(kaleoActionId);

		kaleoAction.setCompanyId(user.getCompanyId());
		kaleoAction.setUserId(user.getUserId());
		kaleoAction.setUserName(user.getFullName());
		kaleoAction.setCreateDate(now);
		kaleoAction.setModifiedDate(now);
		kaleoAction.setKaleoClassName(kaleoClassName);
		kaleoAction.setKaleoClassPK(kaleoClassPK);
		kaleoAction.setKaleoDefinitionId(kaleoDefinitionId);
		kaleoAction.setKaleoNodeName(kaleoNodeName);
		kaleoAction.setName(action.getName());
		kaleoAction.setDescription(action.getDescription());
		kaleoAction.setExecutionType(action.getExecutionType().getValue());
		kaleoAction.setScript(action.getScript());
		kaleoAction.setScriptLanguage(action.getScriptLanguage().getValue());
		kaleoAction.setScriptRequiredContexts(
			action.getScriptRequiredContexts());
		kaleoAction.setPriority(action.getPriority());

		kaleoActionPersistence.update(kaleoAction);

		return kaleoAction;
	}


	public void deleteCompanyKaleoActions(long companyId)
		throws SystemException {

		kaleoActionPersistence.removeByCompanyId(companyId);
	}


	public void deleteKaleoDefinitionKaleoActions(long kaleoDefinitionId)
		throws SystemException {

		kaleoActionPersistence.removeByKaleoDefinitionId(kaleoDefinitionId);
	}


	public List<KaleoAction> getKaleoActions(
			String kaleoClassName, long kaleoClassPK)
		throws SystemException {

		return kaleoActionPersistence.findByKCN_KCPK(
			kaleoClassName, kaleoClassPK);
	}


	public List<KaleoAction> getKaleoActions(
			String kaleoClassName, long kaleoClassPK, String executionType)
		throws SystemException {

		return kaleoActionPersistence.findByKCN_KCPK_ET(
			kaleoClassName, kaleoClassPK, executionType);
	}

}