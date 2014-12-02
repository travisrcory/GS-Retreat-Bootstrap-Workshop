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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.workflow.kaleo.definition.Notification;
import com.liferay.portal.workflow.kaleo.definition.NotificationType;
import com.liferay.portal.workflow.kaleo.definition.Recipient;
import com.liferay.portal.workflow.kaleo.model.KaleoNotification;
import com.liferay.portal.workflow.kaleo.service.base.KaleoNotificationLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Brian Wing Shun Chan
 */
public class KaleoNotificationLocalServiceImpl
	extends KaleoNotificationLocalServiceBaseImpl {


	public KaleoNotification addKaleoNotification(
			String kaleoClassName, long kaleoClassPK, long kaleoDefinitionId,
			String kaleoNodeName, Notification notification,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		// Kaleo notification

		User user = userPersistence.findByPrimaryKey(
			serviceContext.getGuestOrUserId());
		Date now = new Date();

		long kaleoNotificationId = counterLocalService.increment();

		KaleoNotification kaleoNotification =
			kaleoNotificationPersistence.create(kaleoNotificationId);

		kaleoNotification.setCompanyId(user.getCompanyId());
		kaleoNotification.setUserId(user.getUserId());
		kaleoNotification.setUserName(user.getFullName());
		kaleoNotification.setCreateDate(now);
		kaleoNotification.setModifiedDate(now);
		kaleoNotification.setKaleoClassName(kaleoClassName);
		kaleoNotification.setKaleoClassPK(kaleoClassPK);
		kaleoNotification.setKaleoDefinitionId(kaleoDefinitionId);
		kaleoNotification.setKaleoNodeName(kaleoNodeName);
		kaleoNotification.setName(notification.getName());
		kaleoNotification.setDescription(notification.getDescription());
		kaleoNotification.setExecutionType(
			notification.getExecutionType().getValue());
		kaleoNotification.setTemplate(notification.getTemplate());
		kaleoNotification.setTemplateLanguage(
			notification.getTemplateLanguage().getValue());

		Set<NotificationType> notificationTypes =
			notification.getNotificationTypes();

		if (!notificationTypes.isEmpty()) {
			StringBundler sb = new StringBundler(notificationTypes.size() * 2);

			for (NotificationType notificationType : notificationTypes) {
				sb.append(notificationType.getValue());
				sb.append(StringPool.COMMA);
			}

			sb.setIndex(sb.index() - 1);

			kaleoNotification.setNotificationTypes(sb.toString());
		}

		kaleoNotificationPersistence.update(kaleoNotification);

		// Kaleo notification recipients

		Set<Recipient> recipients = notification.getRecipients();

		for (Recipient recipient : recipients) {
			kaleoNotificationRecipientLocalService.
				addKaleoNotificationRecipient(
					kaleoDefinitionId, kaleoNotificationId, recipient,
					serviceContext);
		}

		return kaleoNotification;
	}


	public void deleteCompanyKaleoNotifications(long companyId)
		throws SystemException {

		// Kaleo notifications

		kaleoNotificationPersistence.removeByCompanyId(companyId);

		// Kaleo notification recipients

		kaleoNotificationRecipientLocalService.
			deleteCompanyKaleoNotificationRecipients(companyId);
	}


	public void deleteKaleoDefinitionKaleoNotifications(long kaleoDefinitionId)
		throws SystemException {

		// Kaleo notifications

		kaleoNotificationPersistence.removeByKaleoDefinitionId(
			kaleoDefinitionId);

		// Kaleo notification recipients

		kaleoNotificationRecipientLocalService.
			deleteKaleoDefinitionKaleoNotificationRecipients(kaleoDefinitionId);
	}


	public List<KaleoNotification> getKaleoNotifications(
			String kaleoClassName, long kaleoClassPK)
		throws SystemException {

		return kaleoNotificationPersistence.findByKCN_KCPK(
			kaleoClassName, kaleoClassPK);
	}


	public List<KaleoNotification> getKaleoNotifications(
			String kaleoClassName, long kaleoClassPK, String executionType)
		throws SystemException {

		return kaleoNotificationPersistence.findByKCN_KCPK_ET(
			kaleoClassName, kaleoClassPK, executionType);
	}

}