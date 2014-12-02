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

package com.liferay.calendar.notification;

/**
 * @author Eduardo Lundgren
 * @author Pier Paolo Ramon
 */
public enum NotificationTemplateType {

	INVITE("invite"), MOVED_TO_TRASH("moved-to-trash"), REMINDER("reminder");

	public static NotificationTemplateType parse(String value) {
		if (INVITE.getValue().equals(value)) {
			return INVITE;
		}
		else if (MOVED_TO_TRASH.getValue().equals(value)) {
			return MOVED_TO_TRASH;
		}
		else if (REMINDER.getValue().equals(value)) {
			return REMINDER;
		}

		throw new IllegalArgumentException("Invalid value " + value);
	}

	public String getValue() {
		return _value;
	}


	public String toString() {
		return _value;
	}

	private NotificationTemplateType(String value) {
		_value = value;
	}

	private String _value;

}