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
public class ScriptAssignment extends Assignment {

	public ScriptAssignment(
		String script, String scriptLanguage, String scriptRequiredContexts) {

		super(AssignmentType.SCRIPT);

		_script = script;
		_scriptLanguage = ScriptLanguage.parse(scriptLanguage);
		_scriptRequiredContexts = scriptRequiredContexts;
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

	public void setScript(String script) {
		_script = script;
	}

	public void setScriptLanguage(ScriptLanguage scriptLanguage) {
		_scriptLanguage = scriptLanguage;
	}

	private String _script;
	private ScriptLanguage _scriptLanguage;
	private String _scriptRequiredContexts;

}