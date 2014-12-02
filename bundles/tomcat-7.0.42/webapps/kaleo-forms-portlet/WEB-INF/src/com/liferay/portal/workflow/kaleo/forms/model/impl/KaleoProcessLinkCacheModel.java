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
import com.liferay.portal.workflow.kaleo.forms.model.KaleoProcessLink;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing KaleoProcessLink in entity cache.
 *
 * @author Marcellus Tavares
 * @see KaleoProcessLink
 * @generated
 */
public class KaleoProcessLinkCacheModel implements CacheModel<KaleoProcessLink>,
	Externalizable {

	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{kaleoProcessLinkId=");
		sb.append(kaleoProcessLinkId);
		sb.append(", kaleoProcessId=");
		sb.append(kaleoProcessId);
		sb.append(", workflowTaskName=");
		sb.append(workflowTaskName);
		sb.append(", DDMTemplateId=");
		sb.append(DDMTemplateId);
		sb.append("}");

		return sb.toString();
	}


	public KaleoProcessLink toEntityModel() {
		KaleoProcessLinkImpl kaleoProcessLinkImpl = new KaleoProcessLinkImpl();

		kaleoProcessLinkImpl.setKaleoProcessLinkId(kaleoProcessLinkId);
		kaleoProcessLinkImpl.setKaleoProcessId(kaleoProcessId);

		if (workflowTaskName == null) {
			kaleoProcessLinkImpl.setWorkflowTaskName(StringPool.BLANK);
		}
		else {
			kaleoProcessLinkImpl.setWorkflowTaskName(workflowTaskName);
		}

		kaleoProcessLinkImpl.setDDMTemplateId(DDMTemplateId);

		kaleoProcessLinkImpl.resetOriginalValues();

		return kaleoProcessLinkImpl;
	}


	public void readExternal(ObjectInput objectInput) throws IOException {
		kaleoProcessLinkId = objectInput.readLong();
		kaleoProcessId = objectInput.readLong();
		workflowTaskName = objectInput.readUTF();
		DDMTemplateId = objectInput.readLong();
	}


	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(kaleoProcessLinkId);
		objectOutput.writeLong(kaleoProcessId);

		if (workflowTaskName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(workflowTaskName);
		}

		objectOutput.writeLong(DDMTemplateId);
	}

	public long kaleoProcessLinkId;
	public long kaleoProcessId;
	public String workflowTaskName;
	public long DDMTemplateId;
}