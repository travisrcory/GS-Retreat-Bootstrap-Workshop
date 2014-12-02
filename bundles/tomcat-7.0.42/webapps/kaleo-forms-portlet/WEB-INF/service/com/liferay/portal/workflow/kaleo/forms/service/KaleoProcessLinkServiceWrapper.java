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

package com.liferay.portal.workflow.kaleo.forms.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link KaleoProcessLinkService}.
 *
 * @author Marcellus Tavares
 * @see KaleoProcessLinkService
 * @generated
 */
public class KaleoProcessLinkServiceWrapper implements KaleoProcessLinkService,
	ServiceWrapper<KaleoProcessLinkService> {
	public KaleoProcessLinkServiceWrapper(
		KaleoProcessLinkService kaleoProcessLinkService) {
		_kaleoProcessLinkService = kaleoProcessLinkService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/

	public java.lang.String getBeanIdentifier() {
		return _kaleoProcessLinkService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/

	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_kaleoProcessLinkService.setBeanIdentifier(beanIdentifier);
	}


	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _kaleoProcessLinkService.invokeMethod(name, parameterTypes,
			arguments);
	}


	public com.liferay.portal.workflow.kaleo.forms.model.KaleoProcessLink fetchKaleoProcessLink(
		long kaleoProcessId, java.lang.String workflowTaskName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kaleoProcessLinkService.fetchKaleoProcessLink(kaleoProcessId,
			workflowTaskName);
	}


	public com.liferay.portal.workflow.kaleo.forms.model.KaleoProcessLink updateKaleoProcessLink(
		long kaleoProcessLinkId, long kaleoProcessId,
		java.lang.String workflowTaskName, long ddmTemplateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _kaleoProcessLinkService.updateKaleoProcessLink(kaleoProcessLinkId,
			kaleoProcessId, workflowTaskName, ddmTemplateId);
	}


	public com.liferay.portal.workflow.kaleo.forms.model.KaleoProcessLink updateKaleoProcessLink(
		long kaleoProcessId, java.lang.String workflowTaskName,
		long ddmTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kaleoProcessLinkService.updateKaleoProcessLink(kaleoProcessId,
			workflowTaskName, ddmTemplateId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public KaleoProcessLinkService getWrappedKaleoProcessLinkService() {
		return _kaleoProcessLinkService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedKaleoProcessLinkService(
		KaleoProcessLinkService kaleoProcessLinkService) {
		_kaleoProcessLinkService = kaleoProcessLinkService;
	}


	public KaleoProcessLinkService getWrappedService() {
		return _kaleoProcessLinkService;
	}


	public void setWrappedService(
		KaleoProcessLinkService kaleoProcessLinkService) {
		_kaleoProcessLinkService = kaleoProcessLinkService;
	}

	private KaleoProcessLinkService _kaleoProcessLinkService;
}