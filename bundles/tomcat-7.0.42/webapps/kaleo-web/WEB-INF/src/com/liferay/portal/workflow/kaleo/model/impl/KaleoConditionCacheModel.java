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
import com.liferay.portal.workflow.kaleo.model.KaleoCondition;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing KaleoCondition in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see KaleoCondition
 * @generated
 */
public class KaleoConditionCacheModel implements CacheModel<KaleoCondition>,
	Externalizable {

	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{kaleoConditionId=");
		sb.append(kaleoConditionId);
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
		sb.append(", script=");
		sb.append(script);
		sb.append(", scriptLanguage=");
		sb.append(scriptLanguage);
		sb.append(", scriptRequiredContexts=");
		sb.append(scriptRequiredContexts);
		sb.append("}");

		return sb.toString();
	}


	public KaleoCondition toEntityModel() {
		KaleoConditionImpl kaleoConditionImpl = new KaleoConditionImpl();

		kaleoConditionImpl.setKaleoConditionId(kaleoConditionId);
		kaleoConditionImpl.setGroupId(groupId);
		kaleoConditionImpl.setCompanyId(companyId);
		kaleoConditionImpl.setUserId(userId);

		if (userName == null) {
			kaleoConditionImpl.setUserName(StringPool.BLANK);
		}
		else {
			kaleoConditionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			kaleoConditionImpl.setCreateDate(null);
		}
		else {
			kaleoConditionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			kaleoConditionImpl.setModifiedDate(null);
		}
		else {
			kaleoConditionImpl.setModifiedDate(new Date(modifiedDate));
		}

		kaleoConditionImpl.setKaleoDefinitionId(kaleoDefinitionId);
		kaleoConditionImpl.setKaleoNodeId(kaleoNodeId);

		if (script == null) {
			kaleoConditionImpl.setScript(StringPool.BLANK);
		}
		else {
			kaleoConditionImpl.setScript(script);
		}

		if (scriptLanguage == null) {
			kaleoConditionImpl.setScriptLanguage(StringPool.BLANK);
		}
		else {
			kaleoConditionImpl.setScriptLanguage(scriptLanguage);
		}

		if (scriptRequiredContexts == null) {
			kaleoConditionImpl.setScriptRequiredContexts(StringPool.BLANK);
		}
		else {
			kaleoConditionImpl.setScriptRequiredContexts(scriptRequiredContexts);
		}

		kaleoConditionImpl.resetOriginalValues();

		return kaleoConditionImpl;
	}


	public void readExternal(ObjectInput objectInput) throws IOException {
		kaleoConditionId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		kaleoDefinitionId = objectInput.readLong();
		kaleoNodeId = objectInput.readLong();
		script = objectInput.readUTF();
		scriptLanguage = objectInput.readUTF();
		scriptRequiredContexts = objectInput.readUTF();
	}


	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(kaleoConditionId);
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

		if (script == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(script);
		}

		if (scriptLanguage == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(scriptLanguage);
		}

		if (scriptRequiredContexts == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(scriptRequiredContexts);
		}
	}

	public long kaleoConditionId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long kaleoDefinitionId;
	public long kaleoNodeId;
	public String script;
	public String scriptLanguage;
	public String scriptRequiredContexts;
}