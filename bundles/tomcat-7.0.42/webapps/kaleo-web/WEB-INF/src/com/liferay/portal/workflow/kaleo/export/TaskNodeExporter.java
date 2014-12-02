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

package com.liferay.portal.workflow.kaleo.export;

import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.workflow.kaleo.definition.Node;
import com.liferay.portal.workflow.kaleo.definition.Task;

/**
 * @author Michael C. Han
 */
public class TaskNodeExporter extends BaseNodeExporter implements NodeExporter {


	protected Element createNodeElement(Element element, String namespace) {
		return element.addElement("task", namespace);
	}


	protected void exportAdditionalNodeElements(
		Node node, Element nodeElement) {

		Task task = (Task)node;

		exportAssignmentsElement(
			task.getAssignments(), nodeElement, "assignments");

		exportTimersElement(task, nodeElement, "task-timers", "task-timer");
	}

}