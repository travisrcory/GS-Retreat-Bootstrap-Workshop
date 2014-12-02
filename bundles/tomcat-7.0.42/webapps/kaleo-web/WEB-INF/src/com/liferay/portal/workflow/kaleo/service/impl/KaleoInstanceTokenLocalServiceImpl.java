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
import com.liferay.portal.kernel.staging.StagingUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.workflow.kaleo.model.KaleoInstance;
import com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken;
import com.liferay.portal.workflow.kaleo.model.KaleoNode;
import com.liferay.portal.workflow.kaleo.model.impl.KaleoInstanceTokenImpl;
import com.liferay.portal.workflow.kaleo.service.base.KaleoInstanceTokenLocalServiceBaseImpl;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class KaleoInstanceTokenLocalServiceImpl
	extends KaleoInstanceTokenLocalServiceBaseImpl {


	public KaleoInstanceToken addKaleoInstanceToken(
			long parentKaleoInstanceTokenId,
			Map<String, Serializable> workflowContext,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		User user = userPersistence.findByPrimaryKey(
			serviceContext.getGuestOrUserId());
		KaleoInstanceToken parentKaleoInstanceToken =
			kaleoInstanceTokenPersistence.findByPrimaryKey(
				parentKaleoInstanceTokenId);
		Date now = new Date();

		long kaleoInstanceTokenId = counterLocalService.increment();

		KaleoInstanceToken kaleoInstanceToken =
			kaleoInstanceTokenPersistence.create(kaleoInstanceTokenId);

		long groupId = StagingUtil.getLiveGroupId(
			serviceContext.getScopeGroupId());

		kaleoInstanceToken.setGroupId(groupId);

		kaleoInstanceToken.setCompanyId(user.getCompanyId());
		kaleoInstanceToken.setUserId(user.getUserId());
		kaleoInstanceToken.setUserName(user.getFullName());
		kaleoInstanceToken.setCreateDate(now);
		kaleoInstanceToken.setModifiedDate(now);
		kaleoInstanceToken.setKaleoDefinitionId(
			parentKaleoInstanceToken.getKaleoDefinitionId());
		kaleoInstanceToken.setKaleoInstanceId(
			parentKaleoInstanceToken.getKaleoInstanceId());
		kaleoInstanceToken.setParentKaleoInstanceTokenId(
			parentKaleoInstanceToken.getKaleoInstanceTokenId());

		setCurrentKaleoNode(
			kaleoInstanceToken,
			parentKaleoInstanceToken.getCurrentKaleoNodeId());

		kaleoInstanceToken.setClassName(
			(String)workflowContext.get(
				WorkflowConstants.CONTEXT_ENTRY_CLASS_NAME));

		if (workflowContext.containsKey(
				WorkflowConstants.CONTEXT_ENTRY_CLASS_PK)) {

			kaleoInstanceToken.setClassPK(
				GetterUtil.getLong(
					(String)workflowContext.get(
						WorkflowConstants.CONTEXT_ENTRY_CLASS_PK)));
		}

		kaleoInstanceToken.setCompleted(false);

		kaleoInstanceTokenPersistence.update(kaleoInstanceToken);

		return kaleoInstanceToken;
	}


	public KaleoInstanceToken completeKaleoInstanceToken(
			long kaleoInstanceTokenId)
		throws PortalException, SystemException {

		KaleoInstanceToken kaleoInstanceToken =
			kaleoInstanceTokenPersistence.findByPrimaryKey(
				kaleoInstanceTokenId);

		kaleoInstanceToken.setCompleted(true);
		kaleoInstanceToken.setCompletionDate(new Date());

		kaleoInstanceTokenPersistence.update(kaleoInstanceToken);

		return kaleoInstanceToken;
	}


	public void deleteCompanyKaleoInstanceTokens(long companyId)
		throws SystemException {

		kaleoInstanceTokenPersistence.removeByCompanyId(companyId);
	}


	public void deleteKaleoDefinitionKaleoInstanceTokens(long kaleoDefinitionId)
		throws SystemException {

		kaleoInstanceTokenPersistence.removeByKaleoDefinitionId(
			kaleoDefinitionId);
	}


	public void deleteKaleoInstanceKaleoInstanceTokens(long kaleoInstanceId)
		throws SystemException {

		kaleoInstanceTokenPersistence.removeByKaleoInstanceId(kaleoInstanceId);
	}


	public List<KaleoInstanceToken> getKaleoInstanceTokens(
			long parentKaleoInstanceTokenId, Date completionDate,
			ServiceContext serviceContext)
		throws SystemException {

		return kaleoInstanceTokenPersistence.findByC_PKITI_CD(
			serviceContext.getCompanyId(), parentKaleoInstanceTokenId,
			completionDate);
	}


	public List<KaleoInstanceToken> getKaleoInstanceTokens(
			long parentKaleoInstanceTokenId, ServiceContext serviceContext)
		throws SystemException {

		return kaleoInstanceTokenPersistence.findByC_PKITI(
			serviceContext.getCompanyId(), parentKaleoInstanceTokenId);
	}


	public int getKaleoInstanceTokensCount(
			long parentKaleoInstanceTokenId, Date completionDate,
			ServiceContext serviceContext)
		throws SystemException {

		return kaleoInstanceTokenPersistence.countByC_PKITI_CD(
			serviceContext.getCompanyId(), parentKaleoInstanceTokenId,
			completionDate);
	}


	public int getKaleoInstanceTokensCount(
			long parentKaleoInstanceTokenId, ServiceContext serviceContext)
		throws SystemException {

		return kaleoInstanceTokenPersistence.countByC_PKITI(
			serviceContext.getCompanyId(), parentKaleoInstanceTokenId);
	}


	public KaleoInstanceToken getRootKaleoInstanceToken(
			long kaleoInstanceId, Map<String, Serializable> workflowContext,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		KaleoInstance kaleoInstance = kaleoInstancePersistence.findByPrimaryKey(
			kaleoInstanceId);

		long rootKaleoInstanceTokenId =
			kaleoInstance.getRootKaleoInstanceTokenId();

		if (rootKaleoInstanceTokenId > 0) {
			return kaleoInstanceTokenPersistence.findByPrimaryKey(
				rootKaleoInstanceTokenId);
		}

		// Kaleo instance token

		User user = userPersistence.findByPrimaryKey(
			serviceContext.getGuestOrUserId());
		Date now = new Date();

		rootKaleoInstanceTokenId = counterLocalService.increment();

		KaleoInstanceToken kaleoInstanceToken =
			kaleoInstanceTokenPersistence.create(rootKaleoInstanceTokenId);

		long groupId = StagingUtil.getLiveGroupId(
			serviceContext.getScopeGroupId());

		kaleoInstanceToken.setGroupId(groupId);

		kaleoInstanceToken.setCompanyId(user.getCompanyId());
		kaleoInstanceToken.setUserId(user.getUserId());
		kaleoInstanceToken.setUserName(user.getFullName());
		kaleoInstanceToken.setCreateDate(now);
		kaleoInstanceToken.setModifiedDate(now);
		kaleoInstanceToken.setKaleoDefinitionId(
			kaleoInstance.getKaleoDefinitionId());
		kaleoInstanceToken.setKaleoInstanceId(
			kaleoInstance.getKaleoInstanceId());
		kaleoInstanceToken.setParentKaleoInstanceTokenId(
			KaleoInstanceTokenImpl.DEFAULT_PARENT_KALEO_INSTANCE_TOKEN_ID);
		kaleoInstanceToken.setClassName(
			(String)workflowContext.get(
				WorkflowConstants.CONTEXT_ENTRY_CLASS_NAME));

		if (workflowContext.containsKey(
				WorkflowConstants.CONTEXT_ENTRY_CLASS_PK)) {

			kaleoInstanceToken.setClassPK(
				GetterUtil.getLong(
					(String)workflowContext.get(
						WorkflowConstants.CONTEXT_ENTRY_CLASS_PK)));
		}

		kaleoInstanceTokenPersistence.update(kaleoInstanceToken);

		// Kaleo instance

		kaleoInstance.setRootKaleoInstanceTokenId(rootKaleoInstanceTokenId);

		kaleoInstancePersistence.update(kaleoInstance);

		return kaleoInstanceToken;
	}


	public KaleoInstanceToken updateKaleoInstanceToken(
			long kaleoInstanceTokenId, long currentKaleoNodeId)
		throws PortalException, SystemException {

		KaleoInstanceToken kaleoInstanceToken =
			kaleoInstanceTokenPersistence.findByPrimaryKey(
				kaleoInstanceTokenId);

		kaleoInstanceToken.setModifiedDate(new Date());

		setCurrentKaleoNode(kaleoInstanceToken, currentKaleoNodeId);

		kaleoInstanceTokenPersistence.update(kaleoInstanceToken);

		return kaleoInstanceToken;
	}

	protected void setCurrentKaleoNode(
			KaleoInstanceToken kaleoInstanceToken, long currentKaleoNodeId)
		throws PortalException, SystemException {

		kaleoInstanceToken.setCurrentKaleoNodeId(currentKaleoNodeId);

		KaleoNode currentKaleoNode = kaleoNodeLocalService.getKaleoNode(
			currentKaleoNodeId);

		kaleoInstanceToken.setCurrentKaleoNodeName(currentKaleoNode.getName());
	}

}