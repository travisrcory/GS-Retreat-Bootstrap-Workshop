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
import com.liferay.portal.workflow.kaleo.definition.Assignment;
import com.liferay.portal.workflow.kaleo.definition.DelayDuration;
import com.liferay.portal.workflow.kaleo.definition.Notification;
import com.liferay.portal.workflow.kaleo.definition.Timer;
import com.liferay.portal.workflow.kaleo.model.KaleoTimer;
import com.liferay.portal.workflow.kaleo.service.base.KaleoTimerLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Marcellus Tavares
 */
public class KaleoTimerLocalServiceImpl extends KaleoTimerLocalServiceBaseImpl {


	public KaleoTimer addKaleoTimer(
			String kaleoClassName, long kaleoClassPK, long kaleoDefinitionId,
			Timer timer, ServiceContext serviceContext)
		throws PortalException, SystemException {

		// Kaleo timer

		User user = userPersistence.findByPrimaryKey(
			serviceContext.getGuestOrUserId());
		Date now = new Date();

		long kaleoTimerId = counterLocalService.increment();

		KaleoTimer kaleoTimer = kaleoTimerPersistence.create(kaleoTimerId);

		kaleoTimer.setCompanyId(user.getCompanyId());
		kaleoTimer.setUserId(user.getUserId());
		kaleoTimer.setUserName(user.getFullName());
		kaleoTimer.setCreateDate(now);
		kaleoTimer.setModifiedDate(now);
		kaleoTimer.setKaleoClassName(kaleoClassName);
		kaleoTimer.setKaleoClassPK(kaleoClassPK);
		kaleoTimer.setKaleoDefinitionId(kaleoDefinitionId);
		kaleoTimer.setName(timer.getName());
		kaleoTimer.setBlocking(timer.isBlocking());

		DelayDuration delayDuration = timer.getDelayDuration();

		kaleoTimer.setDuration(delayDuration.getDuration());
		kaleoTimer.setScale(delayDuration.getDurationScale().getValue());

		DelayDuration recurrenceDelayDuration = timer.getRecurrence();

		if (recurrenceDelayDuration != null) {
			kaleoTimer.setRecurrenceDuration(
				recurrenceDelayDuration.getDuration());
			kaleoTimer.setRecurrenceScale(
				recurrenceDelayDuration.getDurationScale().getValue());
		}

		kaleoTimerPersistence.update(kaleoTimer);

		// Kaleo actions

		Set<Action> actions = timer.getActions();

		for (Action action : actions) {
			kaleoActionLocalService.addKaleoAction(
				KaleoTimer.class.getName(), kaleoTimerId, kaleoDefinitionId,
				timer.getName(), action, serviceContext);
		}

		// Kaleo assignments

		Set<Assignment> reassignments = timer.getReassignments();

		for (Assignment reassignment : reassignments) {
			kaleoTaskAssignmentLocalService.addKaleoTaskAssignment(
				KaleoTimer.class.getName(), kaleoTimerId, kaleoDefinitionId,
				reassignment, serviceContext);
		}

		// Kaleo notifications

		Set<Notification> notifications = timer.getNotifications();

		for (Notification notification : notifications) {
			kaleoNotificationLocalService.addKaleoNotification(
				KaleoTimer.class.getName(), kaleoTimerId, kaleoDefinitionId,
				timer.getName(), notification, serviceContext);
		}

		return kaleoTimer;
	}


	public List<KaleoTimer> getKaleoTimers(
			String kaleoClassName, long kaleoClassPK)
		throws SystemException {

		return kaleoTimerPersistence.findByKCN_KCPK(
			kaleoClassName, kaleoClassPK);
	}


	public List<KaleoTimer> getKaleoTimers(
			String kaleoClassName, long kaleoClassPK, boolean blocking)
		throws SystemException {

		return kaleoTimerPersistence.findByKCN_KCPK_Blocking(
			kaleoClassName, kaleoClassPK, blocking);
	}

}