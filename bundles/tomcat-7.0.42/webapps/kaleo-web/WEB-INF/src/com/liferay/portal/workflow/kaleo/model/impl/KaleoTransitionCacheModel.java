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
import com.liferay.portal.workflow.kaleo.model.KaleoTransition;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing KaleoTransition in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see KaleoTransition
 * @generated
 */
public class KaleoTransitionCacheModel implements CacheModel<KaleoTransition>,
	Externalizable {

	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{kaleoTransitionId=");
		sb.append(kaleoTransitionId);
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
		sb.append(", sourceKaleoNodeId=");
		sb.append(sourceKaleoNodeId);
		sb.append(", sourceKaleoNodeName=");
		sb.append(sourceKaleoNodeName);
		sb.append(", targetKaleoNodeId=");
		sb.append(targetKaleoNodeId);
		sb.append(", targetKaleoNodeName=");
		sb.append(targetKaleoNodeName);
		sb.append(", defaultTransition=");
		sb.append(defaultTransition);
		sb.append("}");

		return sb.toString();
	}


	public KaleoTransition toEntityModel() {
		KaleoTransitionImpl kaleoTransitionImpl = new KaleoTransitionImpl();

		kaleoTransitionImpl.setKaleoTransitionId(kaleoTransitionId);
		kaleoTransitionImpl.setGroupId(groupId);
		kaleoTransitionImpl.setCompanyId(companyId);
		kaleoTransitionImpl.setUserId(userId);

		if (userName == null) {
			kaleoTransitionImpl.setUserName(StringPool.BLANK);
		}
		else {
			kaleoTransitionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			kaleoTransitionImpl.setCreateDate(null);
		}
		else {
			kaleoTransitionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			kaleoTransitionImpl.setModifiedDate(null);
		}
		else {
			kaleoTransitionImpl.setModifiedDate(new Date(modifiedDate));
		}

		kaleoTransitionImpl.setKaleoDefinitionId(kaleoDefinitionId);
		kaleoTransitionImpl.setKaleoNodeId(kaleoNodeId);

		if (name == null) {
			kaleoTransitionImpl.setName(StringPool.BLANK);
		}
		else {
			kaleoTransitionImpl.setName(name);
		}

		if (description == null) {
			kaleoTransitionImpl.setDescription(StringPool.BLANK);
		}
		else {
			kaleoTransitionImpl.setDescription(description);
		}

		kaleoTransitionImpl.setSourceKaleoNodeId(sourceKaleoNodeId);

		if (sourceKaleoNodeName == null) {
			kaleoTransitionImpl.setSourceKaleoNodeName(StringPool.BLANK);
		}
		else {
			kaleoTransitionImpl.setSourceKaleoNodeName(sourceKaleoNodeName);
		}

		kaleoTransitionImpl.setTargetKaleoNodeId(targetKaleoNodeId);

		if (targetKaleoNodeName == null) {
			kaleoTransitionImpl.setTargetKaleoNodeName(StringPool.BLANK);
		}
		else {
			kaleoTransitionImpl.setTargetKaleoNodeName(targetKaleoNodeName);
		}

		kaleoTransitionImpl.setDefaultTransition(defaultTransition);

		kaleoTransitionImpl.resetOriginalValues();

		return kaleoTransitionImpl;
	}


	public void readExternal(ObjectInput objectInput) throws IOException {
		kaleoTransitionId = objectInput.readLong();
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
		sourceKaleoNodeId = objectInput.readLong();
		sourceKaleoNodeName = objectInput.readUTF();
		targetKaleoNodeId = objectInput.readLong();
		targetKaleoNodeName = objectInput.readUTF();
		defaultTransition = objectInput.readBoolean();
	}


	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(kaleoTransitionId);
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

		objectOutput.writeLong(sourceKaleoNodeId);

		if (sourceKaleoNodeName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sourceKaleoNodeName);
		}

		objectOutput.writeLong(targetKaleoNodeId);

		if (targetKaleoNodeName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(targetKaleoNodeName);
		}

		objectOutput.writeBoolean(defaultTransition);
	}

	public long kaleoTransitionId;
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
	public long sourceKaleoNodeId;
	public String sourceKaleoNodeName;
	public long targetKaleoNodeId;
	public String targetKaleoNodeName;
	public boolean defaultTransition;
}