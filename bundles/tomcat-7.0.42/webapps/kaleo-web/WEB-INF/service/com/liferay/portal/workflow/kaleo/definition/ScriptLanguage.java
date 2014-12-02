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
public enum ScriptLanguage {

	BEANSHELL("beanshell"), DRL("drl"), GROOVY("groovy"),
	JAVASCRIPT("javascript"), PYTHON("python"), RUBY("ruby");

	public static ScriptLanguage parse(String value) {
		if (BEANSHELL.getValue().equals(value)) {
			return BEANSHELL;
		}
		else if (DRL.getValue().equals(value)) {
			return DRL;
		}
		else if (GROOVY.getValue().equals(value)) {
			return GROOVY;
		}
		else if (JAVASCRIPT.getValue().equals(value)) {
			return JAVASCRIPT;
		}
		else if (PYTHON.getValue().equals(value)) {
			return PYTHON;
		}
		else if (RUBY.getValue().equals(value)) {
			return RUBY;
		}

		throw new IllegalArgumentException("Invalid value " + value);
	}

	public String getValue() {
		return _value;
	}


	public String toString() {
		return _value;
	}

	private ScriptLanguage(String value) {
		_value = value;
	}

	private String _value;

}