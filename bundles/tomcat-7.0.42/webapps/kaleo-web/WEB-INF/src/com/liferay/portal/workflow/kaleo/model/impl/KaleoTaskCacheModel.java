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
import com.liferay.portal.workflow.kaleo.model.KaleoTask;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing KaleoTask in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see KaleoTask
 * @generated
 */
public class KaleoTaskCacheModel implements CacheModel<KaleoTask>,
	Externalizable {

	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{kaleoTaskId=");
		sb.append(kaleoTaskId);
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
		sb.append(", kaleoNodeId=");
		sb.append(kaleoNodeId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}


	public KaleoTask toEntityModel() {
		KaleoTaskImpl kaleoTaskImpl = new KaleoTaskImpl();

		kaleoTaskImpl.setKaleoTaskId(kaleoTaskId);
		kaleoTaskImpl.setGroupId(groupId);
		kaleoTaskImpl.setCompanyId(companyId);
		kaleoTaskImpl.setUserId(userId);

		if (userName == null) {
			kaleoTaskImpl.setUserName(StringPool.BLANK);
		}
		else {
			kaleoTaskImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			kaleoTaskImpl.setCreateDate(null);
		}
		else {
			kaleoTaskImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			kaleoTaskImpl.setModifiedDate(null);
		}
		else {
			kaleoTaskImpl.setModifiedDate(new Date(modifiedDate));
		}

		kaleoTaskImpl.setKaleoDefinitionId(kaleoDefinitionId);
		kaleoTaskImpl.setKaleoNodeId(kaleoNodeId);

		if (name == null) {
			kaleoTaskImpl.setName(StringPool.BLANK);
		}
		else {
			kaleoTaskImpl.setName(name);
		}

		if (description == null) {
			kaleoTaskImpl.setDescription(StringPool.BLANK);
		}
		else {
			kaleoTaskImpl.setDescription(description);
		}

		kaleoTaskImpl.resetOriginalValues();

		return kaleoTaskImpl;
	}


	public void readExternal(ObjectInput objectInput) throws IOException {
		kaleoTaskId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		kaleoDefinitionId = objectInput.readLong();
		kaleoNodeId = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
	}


	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(kaleoTaskId);
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
		objectOutput.writeLong(kaleoNodeId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public long kaleoTaskId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long kaleoDefinitionId;
	public long kaleoNodeId;
	public String name;
	public String description;
}