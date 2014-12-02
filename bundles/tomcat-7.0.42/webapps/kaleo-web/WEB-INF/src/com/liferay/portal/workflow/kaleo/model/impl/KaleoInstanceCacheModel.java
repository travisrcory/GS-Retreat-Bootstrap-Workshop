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
import com.liferay.portal.workflow.kaleo.model.KaleoInstance;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing KaleoInstance in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see KaleoInstance
 * @generated
 */
public class KaleoInstanceCacheModel implements CacheModel<KaleoInstance>,
	Externalizable {

	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{kaleoInstanceId=");
		sb.append(kaleoInstanceId);
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
		sb.append(", kaleoDefinitionName=");
		sb.append(kaleoDefinitionName);
		sb.append(", kaleoDefinitionVersion=");
		sb.append(kaleoDefinitionVersion);
		sb.append(", rootKaleoInstanceTokenId=");
		sb.append(rootKaleoInstanceTokenId);
		sb.append(", className=");
		sb.append(className);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append(", completed=");
		sb.append(completed);
		sb.append(", completionDate=");
		sb.append(completionDate);
		sb.append(", workflowContext=");
		sb.append(workflowContext);
		sb.append("}");

		return sb.toString();
	}


	public KaleoInstance toEntityModel() {
		KaleoInstanceImpl kaleoInstanceImpl = new KaleoInstanceImpl();

		kaleoInstanceImpl.setKaleoInstanceId(kaleoInstanceId);
		kaleoInstanceImpl.setGroupId(groupId);
		kaleoInstanceImpl.setCompanyId(companyId);
		kaleoInstanceImpl.setUserId(userId);

		if (userName == null) {
			kaleoInstanceImpl.setUserName(StringPool.BLANK);
		}
		else {
			kaleoInstanceImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			kaleoInstanceImpl.setCreateDate(null);
		}
		else {
			kaleoInstanceImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			kaleoInstanceImpl.setModifiedDate(null);
		}
		else {
			kaleoInstanceImpl.setModifiedDate(new Date(modifiedDate));
		}

		kaleoInstanceImpl.setKaleoDefinitionId(kaleoDefinitionId);

		if (kaleoDefinitionName == null) {
			kaleoInstanceImpl.setKaleoDefinitionName(StringPool.BLANK);
		}
		else {
			kaleoInstanceImpl.setKaleoDefinitionName(kaleoDefinitionName);
		}

		kaleoInstanceImpl.setKaleoDefinitionVersion(kaleoDefinitionVersion);
		kaleoInstanceImpl.setRootKaleoInstanceTokenId(rootKaleoInstanceTokenId);

		if (className == null) {
			kaleoInstanceImpl.setClassName(StringPool.BLANK);
		}
		else {
			kaleoInstanceImpl.setClassName(className);
		}

		kaleoInstanceImpl.setClassPK(classPK);
		kaleoInstanceImpl.setCompleted(completed);

		if (completionDate == Long.MIN_VALUE) {
			kaleoInstanceImpl.setCompletionDate(null);
		}
		else {
			kaleoInstanceImpl.setCompletionDate(new Date(completionDate));
		}

		if (workflowContext == null) {
			kaleoInstanceImpl.setWorkflowContext(StringPool.BLANK);
		}
		else {
			kaleoInstanceImpl.setWorkflowContext(workflowContext);
		}

		kaleoInstanceImpl.resetOriginalValues();

		return kaleoInstanceImpl;
	}


	public void readExternal(ObjectInput objectInput) throws IOException {
		kaleoInstanceId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		kaleoDefinitionId = objectInput.readLong();
		kaleoDefinitionName = objectInput.readUTF();
		kaleoDefinitionVersion = objectInput.readInt();
		rootKaleoInstanceTokenId = objectInput.readLong();
		className = objectInput.readUTF();
		classPK = objectInput.readLong();
		completed = objectInput.readBoolean();
		completionDate = objectInput.readLong();
		workflowContext = objectInput.readUTF();
	}


	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(kaleoInstanceId);
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

		if (kaleoDefinitionName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(kaleoDefinitionName);
		}

		objectOutput.writeInt(kaleoDefinitionVersion);
		objectOutput.writeLong(rootKaleoInstanceTokenId);

		if (className == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(className);
		}

		objectOutput.writeLong(classPK);
		objectOutput.writeBoolean(completed);
		objectOutput.writeLong(completionDate);

		if (workflowContext == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(workflowContext);
		}
	}

	public long kaleoInstanceId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long kaleoDefinitionId;
	public String kaleoDefinitionName;
	public int kaleoDefinitionVersion;
	public long rootKaleoInstanceTokenId;
	public String className;
	public long classPK;
	public boolean completed;
	public long completionDate;
	public String workflowContext;
}