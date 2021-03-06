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
import com.liferay.portal.workflow.kaleo.model.KaleoTimerInstanceToken;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing KaleoTimerInstanceToken in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see KaleoTimerInstanceToken
 * @generated
 */
public class KaleoTimerInstanceTokenCacheModel implements CacheModel<KaleoTimerInstanceToken>,
	Externalizable {

	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{kaleoTimerInstanceTokenId=");
		sb.append(kaleoTimerInstanceTokenId);
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
		sb.append(", kaleoClassName=");
		sb.append(kaleoClassName);
		sb.append(", kaleoClassPK=");
		sb.append(kaleoClassPK);
		sb.append(", kaleoDefinitionId=");
		sb.append(kaleoDefinitionId);
		sb.append(", kaleoInstanceId=");
		sb.append(kaleoInstanceId);
		sb.append(", kaleoInstanceTokenId=");
		sb.append(kaleoInstanceTokenId);
		sb.append(", kaleoTaskInstanceTokenId=");
		sb.append(kaleoTaskInstanceTokenId);
		sb.append(", kaleoTimerId=");
		sb.append(kaleoTimerId);
		sb.append(", kaleoTimerName=");
		sb.append(kaleoTimerName);
		sb.append(", blocking=");
		sb.append(blocking);
		sb.append(", completionUserId=");
		sb.append(completionUserId);
		sb.append(", completed=");
		sb.append(completed);
		sb.append(", completionDate=");
		sb.append(completionDate);
		sb.append(", workflowContext=");
		sb.append(workflowContext);
		sb.append("}");

		return sb.toString();
	}


	public KaleoTimerInstanceToken toEntityModel() {
		KaleoTimerInstanceTokenImpl kaleoTimerInstanceTokenImpl = new KaleoTimerInstanceTokenImpl();

		kaleoTimerInstanceTokenImpl.setKaleoTimerInstanceTokenId(kaleoTimerInstanceTokenId);
		kaleoTimerInstanceTokenImpl.setGroupId(groupId);
		kaleoTimerInstanceTokenImpl.setCompanyId(companyId);
		kaleoTimerInstanceTokenImpl.setUserId(userId);

		if (userName == null) {
			kaleoTimerInstanceTokenImpl.setUserName(StringPool.BLANK);
		}
		else {
			kaleoTimerInstanceTokenImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			kaleoTimerInstanceTokenImpl.setCreateDate(null);
		}
		else {
			kaleoTimerInstanceTokenImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			kaleoTimerInstanceTokenImpl.setModifiedDate(null);
		}
		else {
			kaleoTimerInstanceTokenImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (kaleoClassName == null) {
			kaleoTimerInstanceTokenImpl.setKaleoClassName(StringPool.BLANK);
		}
		else {
			kaleoTimerInstanceTokenImpl.setKaleoClassName(kaleoClassName);
		}

		kaleoTimerInstanceTokenImpl.setKaleoClassPK(kaleoClassPK);
		kaleoTimerInstanceTokenImpl.setKaleoDefinitionId(kaleoDefinitionId);
		kaleoTimerInstanceTokenImpl.setKaleoInstanceId(kaleoInstanceId);
		kaleoTimerInstanceTokenImpl.setKaleoInstanceTokenId(kaleoInstanceTokenId);
		kaleoTimerInstanceTokenImpl.setKaleoTaskInstanceTokenId(kaleoTaskInstanceTokenId);
		kaleoTimerInstanceTokenImpl.setKaleoTimerId(kaleoTimerId);

		if (kaleoTimerName == null) {
			kaleoTimerInstanceTokenImpl.setKaleoTimerName(StringPool.BLANK);
		}
		else {
			kaleoTimerInstanceTokenImpl.setKaleoTimerName(kaleoTimerName);
		}

		kaleoTimerInstanceTokenImpl.setBlocking(blocking);
		kaleoTimerInstanceTokenImpl.setCompletionUserId(completionUserId);
		kaleoTimerInstanceTokenImpl.setCompleted(completed);

		if (completionDate == Long.MIN_VALUE) {
			kaleoTimerInstanceTokenImpl.setCompletionDate(null);
		}
		else {
			kaleoTimerInstanceTokenImpl.setCompletionDate(new Date(
					completionDate));
		}

		if (workflowContext == null) {
			kaleoTimerInstanceTokenImpl.setWorkflowContext(StringPool.BLANK);
		}
		else {
			kaleoTimerInstanceTokenImpl.setWorkflowContext(workflowContext);
		}

		kaleoTimerInstanceTokenImpl.resetOriginalValues();

		return kaleoTimerInstanceTokenImpl;
	}


	public void readExternal(ObjectInput objectInput) throws IOException {
		kaleoTimerInstanceTokenId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		kaleoClassName = objectInput.readUTF();
		kaleoClassPK = objectInput.readLong();
		kaleoDefinitionId = objectInput.readLong();
		kaleoInstanceId = objectInput.readLong();
		kaleoInstanceTokenId = objectInput.readLong();
		kaleoTaskInstanceTokenId = objectInput.readLong();
		kaleoTimerId = objectInput.readLong();
		kaleoTimerName = objectInput.readUTF();
		blocking = objectInput.readBoolean();
		completionUserId = objectInput.readLong();
		completed = objectInput.readBoolean();
		completionDate = objectInput.readLong();
		workflowContext = objectInput.readUTF();
	}


	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(kaleoTimerInstanceTokenId);
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

		if (kaleoClassName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(kaleoClassName);
		}

		objectOutput.writeLong(kaleoClassPK);
		objectOutput.writeLong(kaleoDefinitionId);
		objectOutput.writeLong(kaleoInstanceId);
		objectOutput.writeLong(kaleoInstanceTokenId);
		objectOutput.writeLong(kaleoTaskInstanceTokenId);
		objectOutput.writeLong(kaleoTimerId);

		if (kaleoTimerName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(kaleoTimerName);
		}

		objectOutput.writeBoolean(blocking);
		objectOutput.writeLong(completionUserId);
		objectOutput.writeBoolean(completed);
		objectOutput.writeLong(completionDate);

		if (workflowContext == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(workflowContext);
		}
	}

	public long kaleoTimerInstanceTokenId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String kaleoClassName;
	public long kaleoClassPK;
	public long kaleoDefinitionId;
	public long kaleoInstanceId;
	public long kaleoInstanceTokenId;
	public long kaleoTaskInstanceTokenId;
	public long kaleoTimerId;
	public String kaleoTimerName;
	public boolean blocking;
	public long completionUserId;
	public boolean completed;
	public long completionDate;
	public String workflowContext;
}