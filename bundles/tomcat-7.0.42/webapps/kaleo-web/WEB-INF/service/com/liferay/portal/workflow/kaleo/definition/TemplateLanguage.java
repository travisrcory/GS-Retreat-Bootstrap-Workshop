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
public enum TemplateLanguage {

	FREEMARKER("freemarker"), TEXT("text"), VELOCITY("velocity");

	public static TemplateLanguage parse(String value) {
		if (FREEMARKER.getValue().equals(value)) {
			return FREEMARKER;
		}
		else if (TEXT.getValue().equals(value)) {
			return TEXT;
		}
		else if (VELOCITY.getValue().equals(value)) {
			return VELOCITY;
		}

		throw new IllegalArgumentException("Invalid value " + value);
	}

	public String getValue() {
		return _value;
	}


	public String toString() {
		return _value;
	}

	private TemplateLanguage(String value) {
		_value = value;
	}

	private String _value;

}