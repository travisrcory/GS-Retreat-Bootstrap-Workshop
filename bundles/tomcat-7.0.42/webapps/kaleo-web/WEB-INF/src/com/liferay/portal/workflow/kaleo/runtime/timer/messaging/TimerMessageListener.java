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

package com.liferay.portal.workflow.kaleo.runtime.timer.messaging;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelperUtil;
import com.liferay.portal.kernel.scheduler.StorageType;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.workflow.kaleo.model.KaleoTimerInstanceToken;
import com.liferay.portal.workflow.kaleo.runtime.WorkflowEngine;
import com.liferay.portal.workflow.kaleo.service.KaleoTimerInstanceTokenLocalServiceUtil;
import com.liferay.portal.workflow.kaleo.util.SchedulerUtil;
import com.liferay.portal.workflow.kaleo.util.WorkflowContextUtil;

import java.io.Serializable;

import java.util.Map;

/**
 * @author Marcellus Tavares
 */
public class TimerMessageListener extends BaseMessageListener {

	public void setWorkflowEngine(WorkflowEngine workflowEngine) {
		_workflowEngine = workflowEngine;
	}


	protected void doReceive(Message message) throws Exception {
		long kaleoTimerInstanceTokenId = message.getLong(
			"kaleoTimerInstanceTokenId");

		try {
			KaleoTimerInstanceToken kaleoTimerInstanceToken =
				getKaleoTimerInstanceToken(message);

			Map<String, Serializable> workflowContext =
				WorkflowContextUtil.convert(
					kaleoTimerInstanceToken.getWorkflowContext());

			ServiceContext serviceContext = (ServiceContext)workflowContext.get(
				WorkflowConstants.CONTEXT_SERVICE_CONTEXT);

			_workflowEngine.executeTimerWorkflowInstance(
				kaleoTimerInstanceTokenId, serviceContext, workflowContext);
		}
		catch (Exception e) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"Unable to execute scheduled job. Unregistering job " +
						message,
					e);
			}

			String groupName = SchedulerUtil.getGroupName(
				kaleoTimerInstanceTokenId);

			SchedulerEngineHelperUtil.delete(groupName, StorageType.PERSISTED);
		}
	}

	protected KaleoTimerInstanceToken getKaleoTimerInstanceToken(
			Message message)
		throws PortalException, SystemException {

		long kaleoTimerInstanceTokenId = message.getLong(
			"kaleoTimerInstanceTokenId");

		KaleoTimerInstanceToken kaleoTimerInstanceToken =
			KaleoTimerInstanceTokenLocalServiceUtil.getKaleoTimerInstanceToken(
				kaleoTimerInstanceTokenId);

		return kaleoTimerInstanceToken;
	}

	private static Log _log = LogFactoryUtil.getLog(TimerMessageListener.class);

	private WorkflowEngine _workflowEngine;

}