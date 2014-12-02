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

package com.liferay.portal.workflow.kaleo.forms.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.workflow.kaleo.forms.model.KaleoProcessLink;
import com.liferay.portal.workflow.kaleo.forms.service.base.KaleoProcessLinkServiceBaseImpl;

/**
 * @author Marcellus Tavares
 */
public class KaleoProcessLinkServiceImpl
	extends KaleoProcessLinkServiceBaseImpl {

	public KaleoProcessLink fetchKaleoProcessLink(
			long kaleoProcessId, String workflowTaskName)
		throws SystemException {

		return kaleoProcessLinkLocalService.fetchKaleoProcessLink(
			kaleoProcessId, workflowTaskName);
	}

	public KaleoProcessLink updateKaleoProcessLink(
			long kaleoProcessLinkId, long kaleoProcessId,
			String workflowTaskName, long ddmTemplateId)
		throws PortalException, SystemException {

		return kaleoProcessLinkLocalService.updateKaleoProcessLink(
			kaleoProcessLinkId, kaleoProcessId, workflowTaskName,
			ddmTemplateId);
	}

	public KaleoProcessLink updateKaleoProcessLink(
			long kaleoProcessId, String workflowTaskName, long ddmTemplateId)
		throws SystemException {

		return kaleoProcessLinkLocalService.updateKaleoProcessLink(
			kaleoProcessId, workflowTaskName, ddmTemplateId);
	}

}