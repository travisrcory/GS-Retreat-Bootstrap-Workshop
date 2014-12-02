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

package com.liferay.portal.workflow.kaleo;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.workflow.kaleo.service.KaleoActionLocalService;
import com.liferay.portal.workflow.kaleo.service.KaleoConditionLocalService;
import com.liferay.portal.workflow.kaleo.service.KaleoDefinitionLocalService;
import com.liferay.portal.workflow.kaleo.service.KaleoInstanceLocalService;
import com.liferay.portal.workflow.kaleo.service.KaleoInstanceTokenLocalService;
import com.liferay.portal.workflow.kaleo.service.KaleoLogLocalService;
import com.liferay.portal.workflow.kaleo.service.KaleoNodeLocalService;
import com.liferay.portal.workflow.kaleo.service.KaleoNotificationLocalService;
import com.liferay.portal.workflow.kaleo.service.KaleoNotificationRecipientLocalService;
import com.liferay.portal.workflow.kaleo.service.KaleoTaskAssignmentLocalService;
import com.liferay.portal.workflow.kaleo.service.KaleoTaskInstanceTokenLocalService;
import com.liferay.portal.workflow.kaleo.service.KaleoTaskLocalService;
import com.liferay.portal.workflow.kaleo.service.KaleoTimerInstanceTokenLocalService;
import com.liferay.portal.workflow.kaleo.service.KaleoTimerLocalService;
import com.liferay.portal.workflow.kaleo.service.KaleoTransitionLocalService;

/**
 * @author Brian Wing Shun Chan
 */
public class BaseKaleoBean {

	@BeanReference(type = KaleoActionLocalService.class)
	protected KaleoActionLocalService kaleoActionLocalService;

	@BeanReference(type = KaleoConditionLocalService.class)
	protected KaleoConditionLocalService kaleoConditionLocalService;

	@BeanReference(type = KaleoDefinitionLocalService.class)
	protected KaleoDefinitionLocalService kaleoDefinitionLocalService;

	@BeanReference(type = KaleoInstanceLocalService.class)
	protected KaleoInstanceLocalService kaleoInstanceLocalService;

	@BeanReference(type = KaleoInstanceTokenLocalService.class)
	protected KaleoInstanceTokenLocalService kaleoInstanceTokenLocalService;

	@BeanReference(type = KaleoLogLocalService.class)
	protected KaleoLogLocalService kaleoLogLocalService;

	@BeanReference(type = KaleoNodeLocalService.class)
	protected KaleoNodeLocalService kaleoNodeLocalService;

	@BeanReference(type = KaleoNotificationLocalService.class)
	protected KaleoNotificationLocalService kaleoNotificationLocalService;

	@BeanReference(type = KaleoNotificationRecipientLocalService.class)
	protected KaleoNotificationRecipientLocalService
		kaleoNotificationRecipientLocalService;

	@BeanReference(type = KaleoTaskAssignmentLocalService.class)
	protected KaleoTaskAssignmentLocalService kaleoTaskAssignmentLocalService;

	@BeanReference(type = KaleoTaskInstanceTokenLocalService.class)
	protected KaleoTaskInstanceTokenLocalService
		kaleoTaskInstanceTokenLocalService;

	@BeanReference(type = KaleoTaskLocalService.class)
	protected KaleoTaskLocalService kaleoTaskLocalService;

	@BeanReference(type = KaleoTimerInstanceTokenLocalService.class)
	protected KaleoTimerInstanceTokenLocalService
		kaleoTimerInstanceTokenLocalService;

	@BeanReference(type = KaleoTimerLocalService.class)
	protected KaleoTimerLocalService kaleoTimerLocalService;

	@BeanReference(type = KaleoTransitionLocalService.class)
	protected KaleoTransitionLocalService kaleoTransitionLocalService;

}