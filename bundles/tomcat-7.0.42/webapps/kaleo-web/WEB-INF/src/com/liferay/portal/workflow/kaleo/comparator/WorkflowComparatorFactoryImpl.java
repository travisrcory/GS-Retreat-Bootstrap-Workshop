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

package com.liferay.portal.workflow.kaleo.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.workflow.comparator.WorkflowComparatorFactory;
import com.liferay.portal.kernel.workflow.comparator.WorkflowDefinitionNameComparator;
import com.liferay.portal.kernel.workflow.comparator.WorkflowInstanceEndDateComparator;
import com.liferay.portal.kernel.workflow.comparator.WorkflowInstanceStartDateComparator;
import com.liferay.portal.kernel.workflow.comparator.WorkflowInstanceStateComparator;
import com.liferay.portal.kernel.workflow.comparator.WorkflowLogCreateDateComparator;
import com.liferay.portal.kernel.workflow.comparator.WorkflowLogUserIdComparator;
import com.liferay.portal.kernel.workflow.comparator.WorkflowTaskCompletionDateComparator;
import com.liferay.portal.kernel.workflow.comparator.WorkflowTaskCreateDateComparator;
import com.liferay.portal.kernel.workflow.comparator.WorkflowTaskDueDateComparator;
import com.liferay.portal.kernel.workflow.comparator.WorkflowTaskNameComparator;
import com.liferay.portal.kernel.workflow.comparator.WorkflowTaskUserIdComparator;

/**
 * @author Michael C. Han
 */
public class WorkflowComparatorFactoryImpl
	implements WorkflowComparatorFactory {


	public OrderByComparator getDefinitionNameComparator(boolean ascending) {
		return new WorkflowDefinitionNameComparator(
			ascending, "name ASC, version ASC", "name DESC, version DESC",
			new String[] {"name", "version"});
	}


	public OrderByComparator getInstanceEndDateComparator(boolean ascending) {
		return new WorkflowInstanceEndDateComparator(
			ascending, "endDate ASC, kaleoInstanceId ASC",
			"endDate DESC, kaleoInstanceId DESC",
			new String[] {"endDate", "kaleoInstanceId"});
	}


	public OrderByComparator getInstanceStartDateComparator(boolean ascending) {
		return new WorkflowInstanceStartDateComparator(
			ascending, "createDate ASC, kaleoInstanceId ASC",
			"createDate DESC, kaleoInstanceId DESC",
			new String[] {"createDate", "kaleoInstanceId"});
	}


	public OrderByComparator getInstanceStateComparator(boolean ascending) {
		return new WorkflowInstanceStateComparator(
			ascending, "state ASC, kaleoInstanceId ASC",
			"state DESC, kaleoInstanceId DESC",
			new String[] {"state", "kaleoInstanceId"});
	}


	public OrderByComparator getLogCreateDateComparator(boolean ascending) {
		return new WorkflowLogCreateDateComparator(
			ascending, "createDate ASC, kaleoLogId ASC",
			"createDate DESC, kaleoLogId DESC",
			new String[] {"createDate", "kaleoLogId"});
	}


	public OrderByComparator getLogUserIdComparator(boolean ascending) {
		return new WorkflowLogUserIdComparator(
			ascending, "userId ASC, kaleoLogId ASC",
			"userId DESC, kaleoLogId DESC",
			new String[] {"userId", "kaleoLogId"});
	}


	public OrderByComparator getTaskCompletionDateComparator(
		boolean ascending) {

		return new WorkflowTaskCompletionDateComparator(
			ascending, "completionDate ASC, kaleoTaskId ASC",
			"completionDate DESC, kaleoTaskId DESC",
			new String[] {"completionDate", "kaleoTaskId"});
	}


	public OrderByComparator getTaskCreateDateComparator(boolean ascending) {
		return new WorkflowTaskCreateDateComparator(
			ascending, "createDate ASC, kaleoTaskInstanceTokenId ASC",
			"createDate DESC, kaleoTaskInstanceTokenId DESC",
			new String[] {"createDate", "kaleoTaskInstanceTokenId"});
	}


	public OrderByComparator getTaskDueDateComparator(boolean ascending) {
		return new WorkflowTaskDueDateComparator(
			ascending, "dueDate ASC, modifiedDate ASC, kaleoTaskId ASC",
			"dueDate DESC, modifiedDate DESC, kaleoTaskId DESC",
			new String[] {"dueDate", "modifiedDate", "kaleoTaskId"});
	}


	public OrderByComparator getTaskNameComparator(boolean ascending) {
		return new WorkflowTaskNameComparator(
			ascending, "name ASC, kaleoTaskId ASC",
			"name DESC, kaleoTaskId DESC",
			new String[] {"name", "kaleoTaskId"});
	}


	public OrderByComparator getTaskUserIdComparator(boolean ascending) {
		return new WorkflowTaskUserIdComparator(
			ascending, "userId ASC, kaleoTaskId ASC",
			"userId DESC, kaleoTaskId DESC",
			new String[] {"userId", "kaleoTaskId"});
	}

}