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

package com.liferay.portal.workflow.kaleo.runtime.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.workflow.kaleo.definition.ExecutionType;
import com.liferay.portal.workflow.kaleo.model.KaleoAction;
import com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken;
import com.liferay.portal.workflow.kaleo.runtime.ExecutionContext;
import com.liferay.portal.workflow.kaleo.runtime.util.ClassLoaderUtil;
import com.liferay.portal.workflow.kaleo.service.KaleoActionLocalServiceUtil;
import com.liferay.portal.workflow.kaleo.service.KaleoInstanceLocalServiceUtil;
import com.liferay.portal.workflow.kaleo.service.KaleoLogLocalServiceUtil;

import java.util.List;

/**
 * @author Michael C. Han
 */
public class ActionExecutorUtil {

	public static void executeKaleoActions(
			String kaleoClassName, long kaleoClassPK,
			ExecutionType executionType, ExecutionContext executionContext)
		throws PortalException, SystemException {

		List<KaleoAction> kaleoActions =
			KaleoActionLocalServiceUtil.getKaleoActions(
				kaleoClassName, kaleoClassPK, executionType.getValue());

		for (KaleoAction kaleoAction : kaleoActions) {
			long startTime = System.currentTimeMillis();

			String comment = _COMMENT_ACTION_SUCCESS;

			try {
				String[] scriptRequiredContexts = StringUtil.split(
					kaleoAction.getScriptRequiredContexts());

				ClassLoader[] classLoaders = ClassLoaderUtil.getClassLoaders(
					scriptRequiredContexts);

				ActionExecutor actionExecutor =
					ActionExecutorFactory.getActionExecutor(
						kaleoAction.getScriptLanguage());

				actionExecutor.execute(
					kaleoAction, executionContext, classLoaders);

				KaleoInstanceToken kaleoInstanceToken =
					executionContext.getKaleoInstanceToken();

				KaleoInstanceLocalServiceUtil.updateKaleoInstance(
					kaleoInstanceToken.getKaleoInstanceId(),
					executionContext.getWorkflowContext(),
					executionContext.getServiceContext());
			}
			catch (Exception e) {
				if (_log.isDebugEnabled()) {
					_log.debug(e, e);
				}

				comment = e.getMessage();
			}
			finally {
				KaleoLogLocalServiceUtil.addActionExecutionKaleoLog(
					executionContext.getKaleoInstanceToken(), kaleoAction,
					startTime, System.currentTimeMillis(), comment,
					executionContext.getServiceContext());
			}
		}
	}

	private static final String _COMMENT_ACTION_SUCCESS =
		"Action completed successfully.";

	private static Log _log = LogFactoryUtil.getLog(ActionExecutorUtil.class);

}