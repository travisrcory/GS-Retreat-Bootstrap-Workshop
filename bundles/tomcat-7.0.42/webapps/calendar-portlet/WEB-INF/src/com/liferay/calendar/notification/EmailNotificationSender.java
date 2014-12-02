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

import com.liferay.calendar.model.Calendar;
import com.liferay.calendar.model.CalendarNotificationTemplate;
import com.liferay.calendar.model.CalendarNotificationTemplateConstants;
import com.liferay.calendar.service.CalendarLocalServiceUtil;
import com.liferay.calendar.util.NotificationUtil;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.model.User;

import javax.mail.internet.InternetAddress;

/**
 * @author Eduardo Lundgren
 */
public class EmailNotificationSender implements NotificationSender {


	public void sendNotification(
			NotificationRecipient notificationRecipient,
			NotificationTemplateContext notificationTemplateContext)
		throws NotificationSenderException {

		try {
			CalendarNotificationTemplate calendarNotificationTemplate =
				notificationTemplateContext.getCalendarNotificationTemplate();

			Calendar calendar = CalendarLocalServiceUtil.getCalendar(
				notificationTemplateContext.getCalendarId());

			User defaultSenderUser = NotificationUtil.getDefaultSenderUser(
				calendar);

			String fromAddress = NotificationUtil.getTemplatePropertyValue(
				calendarNotificationTemplate,
				CalendarNotificationTemplateConstants.PROPERTY_FROM_ADDRESS,
				defaultSenderUser.getEmailAddress());
			String fromName = NotificationUtil.getTemplatePropertyValue(
				calendarNotificationTemplate,
				CalendarNotificationTemplateConstants.PROPERTY_FROM_NAME,
				defaultSenderUser.getFullName());

			sendNotification(
				fromAddress, fromName, notificationRecipient,
				notificationTemplateContext.getSubject(),
				notificationTemplateContext.getBody());
		}
		catch (Exception e) {
			throw new NotificationSenderException(e);
		}
	}


	public void sendNotification(
			String fromAddress, String fromName,
			NotificationRecipient notificationRecipient, String subject,
			String notificationMessage)
		throws NotificationSenderException {

		try {
			InternetAddress fromInternetAddress = new InternetAddress(
				fromAddress, fromName);

			MailMessage mailMessage = new MailMessage(
				fromInternetAddress, subject, notificationMessage, true);

			mailMessage.setHTMLFormat(notificationRecipient.isHTMLFormat());

			InternetAddress toInternetAddress = new InternetAddress(
				notificationRecipient.getEmailAddress());

			mailMessage.setTo(toInternetAddress);

			MailServiceUtil.sendEmail(mailMessage);
		}
		catch (Exception e) {
			throw new NotificationSenderException(
				"Unable to send mail message", e);
		}
	}

}