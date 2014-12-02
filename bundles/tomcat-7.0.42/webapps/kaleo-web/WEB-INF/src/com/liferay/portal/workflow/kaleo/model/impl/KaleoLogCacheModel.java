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
import com.liferay.portal.workflow.kaleo.model.KaleoLog;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing KaleoLog in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see KaleoLog
 * @generated
 */
public class KaleoLogCacheModel implements CacheModel<KaleoLog>, Externalizable {

	public String toString() {
		StringBundler sb = new StringBundler(61);

		sb.append("{kaleoLogId=");
		sb.append(kaleoLogId);
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
		sb.append(", kaleoNodeName=");
		sb.append(kaleoNodeName);
		sb.append(", terminalKaleoNode=");
		sb.append(terminalKaleoNode);
		sb.append(", kaleoActionId=");
		sb.append(kaleoActionId);
		sb.append(", kaleoActionName=");
		sb.append(kaleoActionName);
		sb.append(", kaleoActionDescription=");
		sb.append(kaleoActionDescription);
		sb.append(", previousKaleoNodeId=");
		sb.append(previousKaleoNodeId);
		sb.append(", previousKaleoNodeName=");
		sb.append(previousKaleoNodeName);
		sb.append(", previousAssigneeClassName=");
		sb.append(previousAssigneeClassName);
		sb.append(", previousAssigneeClassPK=");
		sb.append(previousAssigneeClassPK);
		sb.append(", currentAssigneeClassName=");
		sb.append(currentAssigneeClassName);
		sb.append(", currentAssigneeClassPK=");
		sb.append(currentAssigneeClassPK);
		sb.append(", type=");
		sb.append(type);
		sb.append(", comment=");
		sb.append(comment);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", duration=");
		sb.append(duration);
		sb.append(", workflowContext=");
		sb.append(workflowContext);
		sb.append("}");

		return sb.toString();
	}


	public KaleoLog toEntityModel() {
		KaleoLogImpl kaleoLogImpl = new KaleoLogImpl();

		kaleoLogImpl.setKaleoLogId(kaleoLogId);
		kaleoLogImpl.setGroupId(groupId);
		kaleoLogImpl.setCompanyId(companyId);
		kaleoLogImpl.setUserId(userId);

		if (userName == null) {
			kaleoLogImpl.setUserName(StringPool.BLANK);
		}
		else {
			kaleoLogImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			kaleoLogImpl.setCreateDate(null);
		}
		else {
			kaleoLogImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			kaleoLogImpl.setModifiedDate(null);
		}
		else {
			kaleoLogImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (kaleoClassName == null) {
			kaleoLogImpl.setKaleoClassName(StringPool.BLANK);
		}
		else {
			kaleoLogImpl.setKaleoClassName(kaleoClassName);
		}

		kaleoLogImpl.setKaleoClassPK(kaleoClassPK);
		kaleoLogImpl.setKaleoDefinitionId(kaleoDefinitionId);
		kaleoLogImpl.setKaleoInstanceId(kaleoInstanceId);
		kaleoLogImpl.setKaleoInstanceTokenId(kaleoInstanceTokenId);
		kaleoLogImpl.setKaleoTaskInstanceTokenId(kaleoTaskInstanceTokenId);

		if (kaleoNodeName == null) {
			kaleoLogImpl.setKaleoNodeName(StringPool.BLANK);
		}
		else {
			kaleoLogImpl.setKaleoNodeName(kaleoNodeName);
		}

		kaleoLogImpl.setTerminalKaleoNode(terminalKaleoNode);
		kaleoLogImpl.setKaleoActionId(kaleoActionId);

		if (kaleoActionName == null) {
			kaleoLogImpl.setKaleoActionName(StringPool.BLANK);
		}
		else {
			kaleoLogImpl.setKaleoActionName(kaleoActionName);
		}

		if (kaleoActionDescription == null) {
			kaleoLogImpl.setKaleoActionDescription(StringPool.BLANK);
		}
		else {
			kaleoLogImpl.setKaleoActionDescription(kaleoActionDescription);
		}

		kaleoLogImpl.setPreviousKaleoNodeId(previousKaleoNodeId);

		if (previousKaleoNodeName == null) {
			kaleoLogImpl.setPreviousKaleoNodeName(StringPool.BLANK);
		}
		else {
			kaleoLogImpl.setPreviousKaleoNodeName(previousKaleoNodeName);
		}

		if (previousAssigneeClassName == null) {
			kaleoLogImpl.setPreviousAssigneeClassName(StringPool.BLANK);
		}
		else {
			kaleoLogImpl.setPreviousAssigneeClassName(previousAssigneeClassName);
		}

		kaleoLogImpl.setPreviousAssigneeClassPK(previousAssigneeClassPK);

		if (currentAssigneeClassName == null) {
			kaleoLogImpl.setCurrentAssigneeClassName(StringPool.BLANK);
		}
		else {
			kaleoLogImpl.setCurrentAssigneeClassName(currentAssigneeClassName);
		}

		kaleoLogImpl.setCurrentAssigneeClassPK(currentAssigneeClassPK);

		if (type == null) {
			kaleoLogImpl.setType(StringPool.BLANK);
		}
		else {
			kaleoLogImpl.setType(type);
		}

		if (comment == null) {
			kaleoLogImpl.setComment(StringPool.BLANK);
		}
		else {
			kaleoLogImpl.setComment(comment);
		}

		if (startDate == Long.MIN_VALUE) {
			kaleoLogImpl.setStartDate(null);
		}
		else {
			kaleoLogImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			kaleoLogImpl.setEndDate(null);
		}
		else {
			kaleoLogImpl.setEndDate(new Date(endDate));
		}

		kaleoLogImpl.setDuration(duration);

		if (workflowContext == null) {
			kaleoLogImpl.setWorkflowContext(StringPool.BLANK);
		}
		else {
			kaleoLogImpl.setWorkflowContext(workflowContext);
		}

		kaleoLogImpl.resetOriginalValues();

		return kaleoLogImpl;
	}


	public void readExternal(ObjectInput objectInput) throws IOException {
		kaleoLogId = objectInput.readLong();
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
		kaleoNodeName = objectInput.readUTF();
		terminalKaleoNode = objectInput.readBoolean();
		kaleoActionId = objectInput.readLong();
		kaleoActionName = objectInput.readUTF();
		kaleoActionDescription = objectInput.readUTF();
		previousKaleoNodeId = objectInput.readLong();
		previousKaleoNodeName = objectInput.readUTF();
		previousAssigneeClassName = objectInput.readUTF();
		previousAssigneeClassPK = objectInput.readLong();
		currentAssigneeClassName = objectInput.readUTF();
		currentAssigneeClassPK = objectInput.readLong();
		type = objectInput.readUTF();
		comment = objectInput.readUTF();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
		duration = objectInput.readLong();
		workflowContext = objectInput.readUTF();
	}


	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(kaleoLogId);
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

		if (kaleoNodeName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(kaleoNodeName);
		}

		objectOutput.writeBoolean(terminalKaleoNode);
		objectOutput.writeLong(kaleoActionId);

		if (kaleoActionName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(kaleoActionName);
		}

		if (kaleoActionDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(kaleoActionDescription);
		}

		objectOutput.writeLong(previousKaleoNodeId);

		if (previousKaleoNodeName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(previousKaleoNodeName);
		}

		if (previousAssigneeClassName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(previousAssigneeClassName);
		}

		objectOutput.writeLong(previousAssigneeClassPK);

		if (currentAssigneeClassName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currentAssigneeClassName);
		}

		objectOutput.writeLong(currentAssigneeClassPK);

		if (type == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (comment == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comment);
		}

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);
		objectOutput.writeLong(duration);

		if (workflowContext == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(workflowContext);
		}
	}

	public long kaleoLogId;
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
	public String kaleoNodeName;
	public boolean terminalKaleoNode;
	public long kaleoActionId;
	public String kaleoActionName;
	public String kaleoActionDescription;
	public long previousKaleoNodeId;
	public String previousKaleoNodeName;
	public String previousAssigneeClassName;
	public long previousAssigneeClassPK;
	public String currentAssigneeClassName;
	public long currentAssigneeClassPK;
	public String type;
	public String comment;
	public long startDate;
	public long endDate;
	public long duration;
	public String workflowContext;
}