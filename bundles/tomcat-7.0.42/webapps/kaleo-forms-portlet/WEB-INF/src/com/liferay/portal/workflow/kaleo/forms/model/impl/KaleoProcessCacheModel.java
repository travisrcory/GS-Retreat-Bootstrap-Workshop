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

package com.liferay.portal.workflow.kaleo.forms.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing KaleoProcess in entity cache.
 *
 * @author Marcellus Tavares
 * @see KaleoProcess
 * @generated
 */
public class KaleoProcessCacheModel implements CacheModel<KaleoProcess>,
	Externalizable {

	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{kaleoProcessId=");
		sb.append(kaleoProcessId);
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
		sb.append(", DDLRecordSetId=");
		sb.append(DDLRecordSetId);
		sb.append(", DDMTemplateId=");
		sb.append(DDMTemplateId);
		sb.append("}");

		return sb.toString();
	}


	public KaleoProcess toEntityModel() {
		KaleoProcessImpl kaleoProcessImpl = new KaleoProcessImpl();

		kaleoProcessImpl.setKaleoProcessId(kaleoProcessId);
		kaleoProcessImpl.setGroupId(groupId);
		kaleoProcessImpl.setCompanyId(companyId);
		kaleoProcessImpl.setUserId(userId);

		if (userName == null) {
			kaleoProcessImpl.setUserName(StringPool.BLANK);
		}
		else {
			kaleoProcessImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			kaleoProcessImpl.setCreateDate(null);
		}
		else {
			kaleoProcessImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			kaleoProcessImpl.setModifiedDate(null);
		}
		else {
			kaleoProcessImpl.setModifiedDate(new Date(modifiedDate));
		}

		kaleoProcessImpl.setDDLRecordSetId(DDLRecordSetId);
		kaleoProcessImpl.setDDMTemplateId(DDMTemplateId);

		kaleoProcessImpl.resetOriginalValues();

		return kaleoProcessImpl;
	}


	public void readExternal(ObjectInput objectInput) throws IOException {
		kaleoProcessId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		DDLRecordSetId = objectInput.readLong();
		DDMTemplateId = objectInput.readLong();
	}


	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(kaleoProcessId);
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
		objectOutput.writeLong(DDLRecordSetId);
		objectOutput.writeLong(DDMTemplateId);
	}

	public long kaleoProcessId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long DDLRecordSetId;
	public long DDMTemplateId;
}