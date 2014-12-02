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

package com.liferay.portal.workflow.kaleo.definition;

/**
 * @author Michael C. Han
 */
public enum LogType {

	ACTION_EXECUTION, NODE_ENTRY, NODE_EXIT, TASK_ASSIGNMENT, TASK_COMPLETION,
	TASK_UPDATE, WORKFLOW_INSTANCE_END, WORKFLOW_INSTANCE_START

}