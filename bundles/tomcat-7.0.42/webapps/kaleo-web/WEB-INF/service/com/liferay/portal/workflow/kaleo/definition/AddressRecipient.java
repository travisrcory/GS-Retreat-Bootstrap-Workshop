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

import com.liferay.portal.kernel.util.Validator;

/**
 * @author Michael C. Han
 */
public class AddressRecipient extends Recipient {

	public AddressRecipient(String address) {
		super(RecipientType.ADDRESS);

		_address = address;
	}


	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AddressRecipient)) {
			return false;
		}

		AddressRecipient addressRecipient = (AddressRecipient)obj;

		if (Validator.equals(_address, addressRecipient._address)) {
			return true;
		}

		return true;
	}

	public String getAddress() {
		return _address;
	}


	public int hashCode() {
		return _address.hashCode();
	}

	private String _address;

}