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
public enum NotificationType {

	EMAIL("email"), IM("im"), PRIVATE_MESSAGE("private-message"),
	USER_NOTIFICATION("user-notification");

	public static NotificationType parse(String value) {
		if (EMAIL.getValue().equals(value)) {
			return EMAIL;
		}
		else if (IM.getValue().equals(value)) {
			return IM;
		}
		else if (PRIVATE_MESSAGE.getValue().equals(value)) {
			return PRIVATE_MESSAGE;
		}
		else if (USER_NOTIFICATION.getValue().equals(value)) {
			return USER_NOTIFICATION;
		}

		throw new IllegalArgumentException("Invalid value " + value);
	}

	public String getValue() {
		return _value;
	}


	public String toString() {
		return _value;
	}

	private NotificationType(String value) {
		_value = value;
	}

	private String _value;

}