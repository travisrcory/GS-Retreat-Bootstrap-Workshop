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

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author Michael C. Han
 */
public class UserRecipient extends Recipient {

	public UserRecipient() {
		this(0, null, null);
	}

	public UserRecipient(long userId, String screenName, String emailAddress) {
		super(RecipientType.USER);

		_userId = userId;
		_screenName = GetterUtil.getString(screenName);
		_emailAddress = GetterUtil.getString(emailAddress);
	}


	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserRecipient)) {
			return false;
		}

		UserRecipient userRecipient = (UserRecipient)obj;

		if (Validator.equals(_emailAddress, userRecipient._emailAddress) &&
			Validator.equals(_screenName, userRecipient._screenName) &&
			(_userId == userRecipient._userId)) {

			return true;
		}

		return true;
	}

	public String getEmailAddress() {
		return _emailAddress;
	}

	public String getScreenName() {
		return _screenName;
	}

	public long getUserId() {
		return _userId;
	}


	public int hashCode() {
		return _emailAddress.concat(_screenName).concat(
			String.valueOf(_userId)).hashCode();
	}


	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{emailAddress=");
		sb.append(_emailAddress);
		sb.append(", screenName=");
		sb.append(_screenName);
		sb.append(", userId=");
		sb.append(_userId);
		sb.append("}");

		return sb.toString();
	}

	private String _emailAddress;
	private String _screenName;
	private long _userId;

}