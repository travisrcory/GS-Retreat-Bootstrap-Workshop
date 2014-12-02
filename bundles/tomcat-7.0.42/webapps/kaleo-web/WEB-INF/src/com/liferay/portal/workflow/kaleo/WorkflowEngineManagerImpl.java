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

import com.liferay.portal.kernel.workflow.WorkflowEngineManager;

import java.util.Collections;
import java.util.Map;

/**
 * @author Michael C. Han
 */
public class WorkflowEngineManagerImpl implements WorkflowEngineManager {


	public String getKey() {
		return _KEY;
	}


	public String getName() {
		return _NAME;
	}


	public Map<String, Object> getOptionalAttributes() {
		return _OPTIONAL_ATTRIBUTES;
	}


	public String getVersion() {
		return _VERSION;
	}


	public boolean isDeployed() {
		return true;
	}

	private static final String _KEY = "liferay";

	private static final String _NAME = "Liferay Kaleo Workflow Engine";

	private static final Map<String, Object> _OPTIONAL_ATTRIBUTES =
		Collections.emptyMap();

	private static final String _VERSION = "6.0.0";

}