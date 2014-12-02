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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.workflow.kaleo.forms.model.KaleoProcessLink;
import com.liferay.portal.workflow.kaleo.forms.service.KaleoProcessLinkLocalServiceUtil;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordSet;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.model.DDMTemplate;
import com.liferay.portlet.dynamicdatamapping.service.DDMTemplateLocalServiceUtil;

import java.util.List;
import java.util.Locale;

/**
 * @author Marcellus Tavares
 */
public class KaleoProcessImpl extends KaleoProcessBaseImpl {

	public DDLRecordSet getDDLRecordSet()
		throws PortalException, SystemException {

		return DDLRecordSetLocalServiceUtil.getRecordSet(getDDLRecordSetId());
	}

	public DDMTemplate getDDMTemplate()
		throws PortalException, SystemException {

		return DDMTemplateLocalServiceUtil.getTemplate(getDDMTemplateId());
	}

	public String getDescription(Locale locale)
		throws PortalException, SystemException {

		DDLRecordSet ddlRecordSet = getDDLRecordSet();

		return ddlRecordSet.getDescription(locale);
	}

	public List<KaleoProcessLink> getKaleoProcessLinks()
		throws SystemException {

		return KaleoProcessLinkLocalServiceUtil.getKaleoProcessLinks(
			getKaleoProcessId());
	}

	public String getName(Locale locale)
		throws PortalException, SystemException {

		DDLRecordSet ddlRecordSet = getDDLRecordSet();

		return ddlRecordSet.getName(locale);
	}

}