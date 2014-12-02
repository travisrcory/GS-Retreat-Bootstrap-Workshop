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

package com.liferay.portal.workflow.kaleo.forms.workflow;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.WorkflowDefinitionLink;
import com.liferay.portal.security.permission.ResourceActionsUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.WorkflowDefinitionLinkLocalServiceUtil;
import com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess;
import com.liferay.portal.workflow.kaleo.forms.service.KaleoProcessLocalServiceUtil;
import com.liferay.portlet.dynamicdatalists.model.DDLRecord;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordVersion;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordLocalServiceUtil;

import java.io.Serializable;

import java.util.Locale;
import java.util.Map;

/**
 * @author Marcellus Tavares
 */
public class KaleoProcessWorkflowHandler extends BaseWorkflowHandler {

	public static final String CLASS_NAME = KaleoProcess.class.getName();


	public String getClassName() {
		return CLASS_NAME;
	}


	public String getType(Locale locale) {
		return ResourceActionsUtil.getModelResource(locale, CLASS_NAME);
	}


	public WorkflowDefinitionLink getWorkflowDefinitionLink(
			long companyId, long groupId, long classPK)
		throws PortalException, SystemException {

		DDLRecord ddlRecord = DDLRecordLocalServiceUtil.getRecord(classPK);

		KaleoProcess kaleoProcess =
			KaleoProcessLocalServiceUtil.getDDLRecordSetKaleoProcess(
				ddlRecord.getRecordSetId());

		return WorkflowDefinitionLinkLocalServiceUtil.
			fetchWorkflowDefinitionLink(
				companyId, groupId, getClassName(),
				kaleoProcess.getKaleoProcessId(), 0);
	}


	public boolean isAssetTypeSearchable() {
		return false;
	}


	public boolean isVisible() {
		return false;
	}


	public DDLRecord updateStatus(
			int status, Map<String, Serializable> workflowContext)
		throws PortalException, SystemException {

		long userId = GetterUtil.getLong(
			(String)workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));

		long ddlRecordId = GetterUtil.getLong(
			(String)workflowContext.get(
				WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

		DDLRecord record = DDLRecordLocalServiceUtil.getRecord(ddlRecordId);

		DDLRecordVersion recordVersion = record.getRecordVersion();

		ServiceContext serviceContext = (ServiceContext)workflowContext.get(
			"serviceContext");

		return DDLRecordLocalServiceUtil.updateStatus(
			userId, recordVersion.getRecordVersionId(), status, serviceContext);
	}

}