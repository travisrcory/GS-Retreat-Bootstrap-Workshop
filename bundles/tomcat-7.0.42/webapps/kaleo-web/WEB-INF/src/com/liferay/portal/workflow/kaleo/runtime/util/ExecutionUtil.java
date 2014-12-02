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

package com.liferay.portal.workflow.kaleo.runtime.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.workflow.kaleo.model.KaleoInstance;
import com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken;
import com.liferay.portal.workflow.kaleo.model.KaleoTimerInstanceToken;
import com.liferay.portal.workflow.kaleo.runtime.ExecutionContext;
import com.liferay.portal.workflow.kaleo.service.KaleoLogLocalServiceUtil;
import com.liferay.portal.workflow.kaleo.service.KaleoTimerInstanceTokenLocalServiceUtil;

import java.util.List;

/**
 * @author Marcellus Tavares
 */
public class ExecutionUtil {

	public static void checkKaleoInstanceComplete(
			ExecutionContext executionContext)
		throws PortalException, SystemException {

		KaleoInstanceToken kaleoInstanceToken =
			executionContext.getKaleoInstanceToken();

		if (!kaleoInstanceToken.isCompleted()) {
			return;
		}

		KaleoInstance kaleoInstance = kaleoInstanceToken.getKaleoInstance();

		if (!kaleoInstance.isCompleted()) {
			return;
		}

		KaleoLogLocalServiceUtil.addWorkflowInstanceEndKaleoLog(
			kaleoInstanceToken, executionContext.getServiceContext());
	}

	public static void completeKaleoTimerInstances(
			ExecutionContext executionContext)
		throws PortalException, SystemException {

		KaleoInstanceToken kaleoInstanceToken =
			executionContext.getKaleoInstanceToken();

		List<KaleoTimerInstanceToken> kaleoTimerInstanceTokens =
			KaleoTimerInstanceTokenLocalServiceUtil.getKaleoTimerInstanceTokens(
				kaleoInstanceToken.getKaleoInstanceTokenId(), false, false,
				executionContext.getServiceContext());

		KaleoTimerInstanceTokenLocalServiceUtil.
			completeKaleoTimerInstanceTokens(
				kaleoTimerInstanceTokens, executionContext.getServiceContext());
	}

	public static boolean isKaleoInstanceBlocked(
			ExecutionContext executionContext)
		throws SystemException {

		KaleoInstanceToken kaleoInstanceToken =
			executionContext.getKaleoInstanceToken();

		int count =
			KaleoTimerInstanceTokenLocalServiceUtil.
				getKaleoTimerInstanceTokensCount(
					kaleoInstanceToken.getKaleoInstanceTokenId(), false, true,
					executionContext.getServiceContext());

		if (count > 0) {
			return true;
		}

		return false;
	}

}