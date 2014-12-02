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

package com.liferay.portal.workflow.kaleo.util;

import com.liferay.portal.kernel.workflow.WorkflowLog;
import com.liferay.portal.workflow.kaleo.definition.LogType;

/**
 * @author Michael C. Han
 */
public class KaleoLogUtil {

	public static String convert(int type) {
		if (type == WorkflowLog.TASK_ASSIGN) {
			return LogType.TASK_ASSIGNMENT.name();
		}
		else if (type == WorkflowLog.TASK_COMPLETION) {
			return LogType.TASK_COMPLETION.name();
		}
		else if (type == WorkflowLog.TASK_UPDATE) {
			return LogType.TASK_UPDATE.name();
		}
		else if (type == WorkflowLog.TRANSITION) {
			return LogType.NODE_EXIT.name();
		}

		return null;
	}

	public static int convert(String type) {
		LogType logType = LogType.valueOf(type);

		if (logType.equals(LogType.NODE_EXIT)) {
			return WorkflowLog.TRANSITION;
		}
		else if (logType.equals(LogType.TASK_ASSIGNMENT)) {
			return WorkflowLog.TASK_ASSIGN;
		}
		else if (logType.equals(LogType.TASK_COMPLETION)) {
			return WorkflowLog.TASK_COMPLETION;
		}
		else if (logType.equals(LogType.TASK_UPDATE)) {
			return WorkflowLog.TASK_UPDATE;
		}

		return -1;
	}

}