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
public enum ExecutionType {

	ON_ASSIGNMENT("onAssignment"), ON_ENTRY("onEntry"), ON_EXIT("onExit"),
	ON_TIMER("onTimer");

	public static ExecutionType parse(String value) {
		if (ON_ASSIGNMENT.getValue().equals(value)) {
			return ON_ASSIGNMENT;
		}
		else if (ON_ENTRY.getValue().equals(value)) {
			return ON_ENTRY;
		}
		else if (ON_EXIT.getValue().equals(value)) {
			return ON_EXIT;
		}
		else if (ON_TIMER.getValue().equals(value)) {
			return ON_TIMER;
		}
		else {
			throw new IllegalArgumentException("Invalid value " + value);
		}
	}

	public String getValue() {
		return _value;
	}


	public String toString() {
		return _value;
	}

	private ExecutionType(String value) {
		_value = value;
	}

	private String _value;

}