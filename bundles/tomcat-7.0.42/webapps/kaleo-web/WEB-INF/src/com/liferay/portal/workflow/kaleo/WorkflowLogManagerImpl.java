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

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.workflow.WorkflowException;
import com.liferay.portal.kernel.workflow.WorkflowLog;
import com.liferay.portal.kernel.workflow.WorkflowLogManager;
import com.liferay.portal.workflow.kaleo.model.KaleoLog;
import com.liferay.portal.workflow.kaleo.service.KaleoLogLocalServiceUtil;
import com.liferay.portal.workflow.kaleo.util.WorkflowModelUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael C. Han
 */
public class WorkflowLogManagerImpl implements WorkflowLogManager {


	public int getWorkflowLogCountByWorkflowInstance(
			long companyId, long workflowInstanceId, List<Integer> logTypes)
		throws WorkflowException {

		try {
			return KaleoLogLocalServiceUtil.getKaleoInstanceKaleoLogsCount(
				workflowInstanceId, logTypes);
		}
		catch (Exception e) {
			throw new WorkflowException(e);
		}
	}


	public int getWorkflowLogCountByWorkflowTask(
			long companyId, long workflowTaskId, List<Integer> logTypes)
		throws WorkflowException {

		try {
			return KaleoLogLocalServiceUtil.
				getKaleoTaskInstanceTokenKaleoLogsCount(
					workflowTaskId, logTypes);
		}
		catch (Exception e) {
			throw new WorkflowException(e);
		}
	}


	public List<WorkflowLog> getWorkflowLogsByWorkflowInstance(
			long companyId, long workflowInstanceId, List<Integer> logTypes,
			int start, int end, OrderByComparator orderByComparator)
		throws WorkflowException {

		try {
			List<KaleoLog> kaleoLogs =
				KaleoLogLocalServiceUtil.getKaleoInstanceKaleoLogs(
					workflowInstanceId, logTypes, start, end,
					orderByComparator);

			return toWorkflowLogs(kaleoLogs);
		}
		catch (Exception e) {
			throw new WorkflowException(e);
		}
	}


	public List<WorkflowLog> getWorkflowLogsByWorkflowTask(
			long companyId, long workflowTaskId, List<Integer> logTypes,
			int start, int end, OrderByComparator orderByComparator)
		throws WorkflowException {

		try {
			List<KaleoLog> kaleoLogs =
				KaleoLogLocalServiceUtil.getKaleoTaskInstanceTokenKaleoLogs(
					workflowTaskId, logTypes, start, end, orderByComparator);

			return toWorkflowLogs(kaleoLogs);
		}
		catch (Exception e) {
			throw new WorkflowException(e);
		}
	}

	protected List<WorkflowLog> toWorkflowLogs(List<KaleoLog> kaleoLogs) {
		List<WorkflowLog> workflowLogs = new ArrayList<WorkflowLog>(
			kaleoLogs.size());

		for (KaleoLog kaleoLog : kaleoLogs) {
			workflowLogs.add(WorkflowModelUtil.toWorkflowLog(kaleoLog));
		}

		return workflowLogs;
	}

}