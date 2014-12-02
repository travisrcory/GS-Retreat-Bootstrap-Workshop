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

package com.liferay.calendar.model.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;

import java.io.IOException;

/**
 * @author Adam Brandizzi
 */
public class CalendarNotificationTemplateImpl
	extends CalendarNotificationTemplateBaseImpl {

	public CalendarNotificationTemplateImpl() {
	}


	public String getNotificationTypeSettings() {
		if (_notificationTypeSettingsProperties == null) {
			return super.getNotificationTypeSettings();
		}
		else {
			return _notificationTypeSettingsProperties.toString();
		}
	}


	public UnicodeProperties getNotificationTypeSettingsProperties() {
		if (_notificationTypeSettingsProperties == null) {
			_notificationTypeSettingsProperties = new UnicodeProperties(true);

			try {
				_notificationTypeSettingsProperties.load(
					super.getNotificationTypeSettings());
			}
			catch (IOException ioe) {
				_log.error(ioe, ioe);
			}
		}

		return _notificationTypeSettingsProperties;
	}


	public void setNotificationTypeSettings(String notificationTypeSettings) {
		_notificationTypeSettingsProperties = null;

		super.setNotificationTypeSettings(notificationTypeSettings);
	}


	public void setTypeSettingsProperties(
		UnicodeProperties notificationTypeSettingsProperties) {

		_notificationTypeSettingsProperties =
			notificationTypeSettingsProperties;

		super.setNotificationTypeSettings(
			_notificationTypeSettingsProperties.toString());
	}

	private static Log _log = LogFactoryUtil.getLog(
		CalendarNotificationTemplateImpl.class);

	private UnicodeProperties _notificationTypeSettingsProperties;

}