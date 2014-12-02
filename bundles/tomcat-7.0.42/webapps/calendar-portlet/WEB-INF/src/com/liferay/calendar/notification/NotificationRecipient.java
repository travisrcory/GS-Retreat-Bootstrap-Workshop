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

import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.model.User;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * @author Eduardo Lundgren
 */
public class NotificationRecipient {

	public NotificationRecipient(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public NotificationRecipient(User user) {
		_user = user;

		_emailAddress = user.getEmailAddress();
	}

	public String getEmailAddress() {
		return _emailAddress;
	}

	public String getFormat() {
		return _format;
	}

	public InternetAddress getInternetAddress() throws AddressException {
		return new InternetAddress(_emailAddress);
	}

	public String getName() {
		return _name;
	}

	public User getUser() {
		return _user;
	}

	public User getUserRecipient() {
		return _user;
	}

	public boolean isHTMLFormat() {
		return _format.equals(ContentTypes.TEXT_HTML);
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public void setFormat(String format) {
		_format = format;
	}

	public void setName(String name) {
		_name = name;
	}

	public void setUser(User user) {
		_user = user;
	}

	private String _emailAddress;
	private String _format = ContentTypes.TEXT_HTML;
	private String _name;
	private User _user;

}