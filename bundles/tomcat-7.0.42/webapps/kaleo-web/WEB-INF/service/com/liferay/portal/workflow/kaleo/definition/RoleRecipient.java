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
public class RoleRecipient extends Recipient {

	public RoleRecipient(long roleId, String roleType) {
		super(RecipientType.ROLE);

		_roleId = roleId;
		_roleType = roleType;
	}

	public RoleRecipient(String roleName, String roleType) {
		super(RecipientType.ROLE);

		_roleName = roleName;
		_roleType = roleType;
	}


	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RoleRecipient)) {
			return false;
		}

		RoleRecipient roleRecipient = (RoleRecipient)obj;

		if (Validator.equals(_roleName, roleRecipient._roleName) &&
			(_roleId == roleRecipient._roleId)) {

			return true;
		}

		return true;
	}

	public long getRoleId() {
		return _roleId;
	}

	public String getRoleName() {
		return _roleName;
	}

	public String getRoleType() {
		return _roleType;
	}


	public int hashCode() {
		if (Validator.isNotNull(_roleName)) {
			return _roleName.hashCode();
		}

		String roleIdString = String.valueOf(_roleId);

		return roleIdString.hashCode();
	}

	public boolean isAutoCreate() {
		return _autoCreate;
	}

	public void setAutoCreate(boolean autoCreate) {
		_autoCreate = autoCreate;
	}

	private boolean _autoCreate;
	private long _roleId;
	private String _roleName;
	private String _roleType;

}