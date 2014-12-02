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

package com.liferay.portal.workflow.kaleo.designer.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.workflow.kaleo.designer.model.KaleoDraftDefinition;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing KaleoDraftDefinition in entity cache.
 *
 * @author Eduardo Lundgren
 * @see KaleoDraftDefinition
 * @generated
 */
public class KaleoDraftDefinitionCacheModel implements CacheModel<KaleoDraftDefinition>,
	Externalizable {

	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{kaleoDraftDefinitionId=");
		sb.append(kaleoDraftDefinitionId);
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
		sb.append(", name=");
		sb.append(name);
		sb.append(", title=");
		sb.append(title);
		sb.append(", content=");
		sb.append(content);
		sb.append(", version=");
		sb.append(version);
		sb.append(", draftVersion=");
		sb.append(draftVersion);
		sb.append("}");

		return sb.toString();
	}


	public KaleoDraftDefinition toEntityModel() {
		KaleoDraftDefinitionImpl kaleoDraftDefinitionImpl = new KaleoDraftDefinitionImpl();

		kaleoDraftDefinitionImpl.setKaleoDraftDefinitionId(kaleoDraftDefinitionId);
		kaleoDraftDefinitionImpl.setGroupId(groupId);
		kaleoDraftDefinitionImpl.setCompanyId(companyId);
		kaleoDraftDefinitionImpl.setUserId(userId);

		if (userName == null) {
			kaleoDraftDefinitionImpl.setUserName(StringPool.BLANK);
		}
		else {
			kaleoDraftDefinitionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			kaleoDraftDefinitionImpl.setCreateDate(null);
		}
		else {
			kaleoDraftDefinitionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			kaleoDraftDefinitionImpl.setModifiedDate(null);
		}
		else {
			kaleoDraftDefinitionImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			kaleoDraftDefinitionImpl.setName(StringPool.BLANK);
		}
		else {
			kaleoDraftDefinitionImpl.setName(name);
		}

		if (title == null) {
			kaleoDraftDefinitionImpl.setTitle(StringPool.BLANK);
		}
		else {
			kaleoDraftDefinitionImpl.setTitle(title);
		}

		if (content == null) {
			kaleoDraftDefinitionImpl.setContent(StringPool.BLANK);
		}
		else {
			kaleoDraftDefinitionImpl.setContent(content);
		}

		kaleoDraftDefinitionImpl.setVersion(version);
		kaleoDraftDefinitionImpl.setDraftVersion(draftVersion);

		kaleoDraftDefinitionImpl.resetOriginalValues();

		return kaleoDraftDefinitionImpl;
	}


	public void readExternal(ObjectInput objectInput) throws IOException {
		kaleoDraftDefinitionId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		title = objectInput.readUTF();
		content = objectInput.readUTF();
		version = objectInput.readInt();
		draftVersion = objectInput.readInt();
	}


	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(kaleoDraftDefinitionId);
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

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (content == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(content);
		}

		objectOutput.writeInt(version);
		objectOutput.writeInt(draftVersion);
	}

	public long kaleoDraftDefinitionId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String title;
	public String content;
	public int version;
	public int draftVersion;
}