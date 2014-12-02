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
import com.liferay.portal.workflow.kaleo.definition.Condition;
import com.liferay.portal.workflow.kaleo.model.KaleoCondition;
import com.liferay.portal.workflow.kaleo.service.base.KaleoConditionLocalServiceBaseImpl;

import java.util.Date;

/**
 * @author Michael C. Han
 * @author Brian Wing Shun Chan
 */
public class KaleoConditionLocalServiceImpl
	extends KaleoConditionLocalServiceBaseImpl {


	public KaleoCondition addKaleoCondition(
			long kaleoDefinitionId, long kaleoNodeId, Condition condition,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		User user = userPersistence.findByPrimaryKey(
			serviceContext.getGuestOrUserId());
		Date now = new Date();

		long kaleoConditionId = counterLocalService.increment();

		KaleoCondition kaleoCondition = kaleoConditionPersistence.create(
			kaleoConditionId);

		kaleoCondition.setCompanyId(user.getCompanyId());
		kaleoCondition.setUserId(user.getUserId());
		kaleoCondition.setUserName(user.getFullName());
		kaleoCondition.setCreateDate(now);
		kaleoCondition.setModifiedDate(now);
		kaleoCondition.setKaleoDefinitionId(kaleoDefinitionId);
		kaleoCondition.setKaleoNodeId(kaleoNodeId);
		kaleoCondition.setScript(condition.getScript());
		kaleoCondition.setScriptLanguage(
			condition.getScriptLanguage().getValue());
		kaleoCondition.setScriptRequiredContexts(
			condition.getScriptRequiredContexts());

		kaleoConditionPersistence.update(kaleoCondition);

		return kaleoCondition;
	}


	public void deleteCompanyKaleoConditions(long companyId)
		throws SystemException {

		kaleoConditionPersistence.removeByCompanyId(companyId);
	}


	public void deleteKaleoDefinitionKaleoCondition(long kaleoDefinitionId)
		throws SystemException {

		kaleoConditionPersistence.removeByKaleoDefinitionId(kaleoDefinitionId);
	}


	public KaleoCondition getKaleoNodeKaleoCondition(long kaleoNodeId)
		throws PortalException, SystemException {

		return kaleoConditionPersistence.findByKaleoNodeId(kaleoNodeId);
	}

}