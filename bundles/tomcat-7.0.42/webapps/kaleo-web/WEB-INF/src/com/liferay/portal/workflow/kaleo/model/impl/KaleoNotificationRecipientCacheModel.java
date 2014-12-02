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

package com.liferay.portal.workflow.kaleo.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.workflow.kaleo.model.KaleoNotificationRecipient;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing KaleoNotificationRecipient in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see KaleoNotificationRecipient
 * @generated
 */
public class KaleoNotificationRecipientCacheModel implements CacheModel<KaleoNotificationRecipient>,
	Externalizable {

	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{kaleoNotificationRecipientId=");
		sb.append(kaleoNotificationRecipientId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", kaleoDefinitionId=");
		sb.append(kaleoDefinitionId);
		sb.append(", kaleoNotificationId=");
		sb.append(kaleoNotificationId);
		sb.append(", recipientClassName=");
		sb.append(recipientClassName);
		sb.append(", recipientClassPK=");
		sb.append(recipientClassPK);
		sb.append(", recipientRoleType=");
		sb.append(recipientRoleType);
		sb.append(", address=");
		sb.append(address);
		sb.append("}");

		return sb.toString();
	}


	public KaleoNotificationRecipient toEntityModel() {
		KaleoNotificationRecipientImpl kaleoNotificationRecipientImpl = new KaleoNotificationRecipientImpl();

		kaleoNotificationRecipientImpl.setKaleoNotificationRecipientId(kaleoNotificationRecipientId);
		kaleoNotificationRecipientImpl.setGroupId(groupId);
		kaleoNotificationRecipientImpl.setCompanyId(companyId);
		kaleoNotificationRecipientImpl.setUserId(userId);

		if (userName == null) {
			kaleoNotificationRecipientImpl.setUserName(StringPool.BLANK);
		}
		else {
			kaleoNotificationRecipientImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			kaleoNotificationRecipientImpl.setCreateDate(null);
		}
		else {
			kaleoNotificationRecipientImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			kaleoNotificationRecipientImpl.setModifiedDate(null);
		}
		else {
			kaleoNotificationRecipientImpl.setModifiedDate(new Date(
					modifiedDate));
		}

		kaleoNotificationRecipientImpl.setKaleoDefinitionId(kaleoDefinitionId);
		kaleoNotificationRecipientImpl.setKaleoNotificationId(kaleoNotificationId);

		if (recipientClassName == null) {
			kaleoNotificationRecipientImpl.setRecipientClassName(StringPool.BLANK);
		}
		else {
			kaleoNotificationRecipientImpl.setRecipientClassName(recipientClassName);
		}

		kaleoNotificationRecipientImpl.setRecipientClassPK(recipientClassPK);
		kaleoNotificationRecipientImpl.setRecipientRoleType(recipientRoleType);

		if (address == null) {
			kaleoNotificationRecipientImpl.setAddress(StringPool.BLANK);
		}
		else {
			kaleoNotificationRecipientImpl.setAddress(address);
		}

		kaleoNotificationRecipientImpl.resetOriginalValues();

		return kaleoNotificationRecipientImpl;
	}


	public void readExternal(ObjectInput objectInput) throws IOException {
		kaleoNotificationRecipientId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		kaleoDefinitionId = objectInput.readLong();
		kaleoNotificationId = objectInput.readLong();
		recipientClassName = objectInput.readUTF();
		recipientClassPK = objectInput.readLong();
		recipientRoleType = objectInput.readInt();
		address = objectInput.readUTF();
	}


	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(kaleoNotificationRecipientId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(kaleoDefinitionId);
		objectOutput.writeLong(kaleoNotificationId);

		if (recipientClassName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(recipientClassName);
		}

		objectOutput.writeLong(recipientClassPK);
		objectOutput.writeInt(recipientRoleType);

		if (address == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(address);
		}
	}

	public long kaleoNotificationRecipientId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long kaleoDefinitionId;
	public long kaleoNotificationId;
	public String recipientClassName;
	public long recipientClassPK;
	public int recipientRoleType;
	public String address;
}