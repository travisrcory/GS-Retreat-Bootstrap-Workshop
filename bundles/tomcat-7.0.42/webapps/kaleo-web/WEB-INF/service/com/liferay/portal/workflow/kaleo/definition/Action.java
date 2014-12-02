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

import com.liferay.portal.kernel.util.Validator;

/**
 * @author Michael C. Han
 */
public class Action {

	public Action(
		String name, String description, String executionType, String script,
		String scriptLanguage, String scriptRequiredContexts, int priority) {

		_name = name;
		_description = description;

		if (Validator.isNotNull(executionType)) {
			_executionType = ExecutionType.parse(executionType);
		}
		else {
			_executionType = ExecutionType.ON_TIMER;
		}

		_script = script;
		_scriptLanguage = ScriptLanguage.parse(scriptLanguage);
		_scriptRequiredContexts = scriptRequiredContexts;
		_priority = priority;
	}


	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Action)) {
			return false;
		}

		Action action = (Action)obj;

		if (Validator.equals(_name, action._name)) {
			return true;
		}

		return true;
	}

	public String getDescription() {
		return _description;
	}

	public ExecutionType getExecutionType() {
		return _executionType;
	}

	public String getName() {
		return _name;
	}

	public int getPriority() {
		return _priority;
	}

	public String getScript() {
		return _script;
	}

	public ScriptLanguage getScriptLanguage() {
		return _scriptLanguage;
	}

	public String getScriptRequiredContexts() {
		return _scriptRequiredContexts;
	}


	public int hashCode() {
		return _name.hashCode();
	}

	private String _description;
	private ExecutionType _executionType;
	private String _name;
	private int _priority;
	private String _script;
	private ScriptLanguage _scriptLanguage;
	private String _scriptRequiredContexts;

}