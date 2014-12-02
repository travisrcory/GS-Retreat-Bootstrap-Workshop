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
import com.liferay.portal.workflow.kaleo.definition.State;

/**
 * @author Michael C. Han
 */
public class StateNodeExporter
	extends BaseNodeExporter implements NodeExporter {


	protected Element createNodeElement(Element element, String namespace) {
		return element.addElement("state", namespace);
	}


	protected void exportAdditionalNodeElements(
		Node node, Element nodeElement) {

		exportTimersElement(node, nodeElement, "timers", "timer");

		State state = (State)node;

		boolean initial = state.isInitial();

		if (initial) {
			addTextElement(nodeElement, "initial", String.valueOf(initial));
		}
	}

}