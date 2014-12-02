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
import com.liferay.portal.workflow.kaleo.definition.Timer;
import com.liferay.portal.workflow.kaleo.definition.Transition;
import com.liferay.portal.workflow.kaleo.model.KaleoNode;
import com.liferay.portal.workflow.kaleo.model.KaleoTransition;
import com.liferay.portal.workflow.kaleo.service.base.KaleoTransitionLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class KaleoTransitionLocalServiceImpl
	extends KaleoTransitionLocalServiceBaseImpl {


	public KaleoTransition addKaleoTransition(
			long kaleoDefinitionId, long kaleoNodeId, Transition transition,
			KaleoNode sourceKaleoNode, KaleoNode targetKaleoNode,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		// Kaleo transition

		User user = userPersistence.findByPrimaryKey(
			serviceContext.getGuestOrUserId());
		Date now = new Date();

		long kaleoTransitionId = counterLocalService.increment();

		KaleoTransition kaleoTransition = kaleoTransitionPersistence.create(
			kaleoTransitionId);

		kaleoTransition.setCompanyId(user.getCompanyId());
		kaleoTransition.setUserId(user.getUserId());
		kaleoTransition.setUserName(user.getFullName());
		kaleoTransition.setCreateDate(now);
		kaleoTransition.setModifiedDate(now);
		kaleoTransition.setKaleoDefinitionId(kaleoDefinitionId);
		kaleoTransition.setKaleoNodeId(kaleoNodeId);
		kaleoTransition.setName(transition.getName());
		kaleoTransition.setSourceKaleoNodeId(sourceKaleoNode.getKaleoNodeId());
		kaleoTransition.setSourceKaleoNodeName(sourceKaleoNode.getName());
		kaleoTransition.setTargetKaleoNodeId(targetKaleoNode.getKaleoNodeId());
		kaleoTransition.setTargetKaleoNodeName(targetKaleoNode.getName());
		kaleoTransition.setDefaultTransition(transition.isDefault());

		kaleoTransitionPersistence.update(kaleoTransition);

		// Kaleo timer

		Timer timer = transition.getTimer();

		if (timer != null) {
			kaleoTimerLocalService.addKaleoTimer(
				KaleoTransition.class.getName(), kaleoTransitionId,
				kaleoDefinitionId, timer, serviceContext);
		}

		return kaleoTransition;
	}


	public void deleteCompanyKaleoTransitions(long companyId)
		throws SystemException {

		kaleoTransitionPersistence.removeByCompanyId(companyId);
	}


	public void deleteKaleoDefinitionKaleoTransitions(long kaleoDefinitionId)
		throws SystemException {

		kaleoTransitionPersistence.removeByKaleoDefinitionId(kaleoDefinitionId);
	}


	public KaleoTransition getDefaultKaleoTransition(long kaleoNodeId)
		throws PortalException, SystemException {

		return kaleoTransitionPersistence.findByKNI_DT(kaleoNodeId, true);
	}


	public List<KaleoTransition> getKaleoDefinitionKaleoTransitions(
			long kaleoDefinitionId)
		throws SystemException {

		return kaleoTransitionPersistence.findByKaleoDefinitionId(
			kaleoDefinitionId);
	}


	public KaleoTransition getKaleoTransition(long kaleoNodeId, String name)
		throws PortalException, SystemException {

		return kaleoTransitionPersistence.findByKNI_N(kaleoNodeId, name);
	}


	public List<KaleoTransition> getKaleoTransitions(long kaleoNodeId)
		throws SystemException {

		return kaleoTransitionPersistence.findByKaleoNodeId(kaleoNodeId);
	}


	public int getKaleoTransitionsCount(long kaleoNodeId)
		throws SystemException {

		return kaleoTransitionPersistence.countByKaleoNodeId(kaleoNodeId);
	}

}