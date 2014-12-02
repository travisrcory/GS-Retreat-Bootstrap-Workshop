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

package com.liferay.portal.workflow.kaleo.export.builder;

import com.liferay.portal.workflow.kaleo.definition.Fork;
import com.liferay.portal.workflow.kaleo.definition.Node;
import com.liferay.portal.workflow.kaleo.model.KaleoNode;

/**
 * @author Michael C. Han
 */
public class ForkNodeBuilder extends BaseNodeBuilder implements NodeBuilder {


	protected Node createNode(KaleoNode kaleoNode) {
		return new Fork(kaleoNode.getName(), kaleoNode.getDescription());
	}

}