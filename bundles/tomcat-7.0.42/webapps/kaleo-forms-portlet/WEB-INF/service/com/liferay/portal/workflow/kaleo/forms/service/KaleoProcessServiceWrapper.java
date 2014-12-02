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
 * Provides a wrapper for {@link KaleoProcessService}.
 *
 * @author Marcellus Tavares
 * @see KaleoProcessService
 * @generated
 */
public class KaleoProcessServiceWrapper implements KaleoProcessService,
	ServiceWrapper<KaleoProcessService> {
	public KaleoProcessServiceWrapper(KaleoProcessService kaleoProcessService) {
		_kaleoProcessService = kaleoProcessService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/

	public java.lang.String getBeanIdentifier() {
		return _kaleoProcessService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/

	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_kaleoProcessService.setBeanIdentifier(beanIdentifier);
	}


	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _kaleoProcessService.invokeMethod(name, parameterTypes, arguments);
	}


	public com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess addKaleoProcess(
		long groupId, long ddlRecordSetId, long ddmTemplateId,
		long[] kaleoProcessLinkIds,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _kaleoProcessService.addKaleoProcess(groupId, ddlRecordSetId,
			ddmTemplateId, kaleoProcessLinkIds, serviceContext);
	}


	public com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess deleteKaleoProcess(
		long kaleoProcessId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _kaleoProcessService.deleteKaleoProcess(kaleoProcessId);
	}


	public void deleteKaleoProcessData(long kaleoProcessId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_kaleoProcessService.deleteKaleoProcessData(kaleoProcessId);
	}


	public com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess getKaleoProcess(
		long kaleoProcessId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _kaleoProcessService.getKaleoProcess(kaleoProcessId);
	}


	public java.util.List<com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess> getKaleoProcesses(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kaleoProcessService.getKaleoProcesses(groupId, start, end,
			orderByComparator);
	}


	public int getKaleoProcessesCount(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kaleoProcessService.getKaleoProcessesCount(groupId);
	}


	public com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess updateKaleoProcess(
		long kaleoProcessId, long ddmTemplateId, long[] kaleoProcessLinkIds,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _kaleoProcessService.updateKaleoProcess(kaleoProcessId,
			ddmTemplateId, kaleoProcessLinkIds, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public KaleoProcessService getWrappedKaleoProcessService() {
		return _kaleoProcessService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedKaleoProcessService(
		KaleoProcessService kaleoProcessService) {
		_kaleoProcessService = kaleoProcessService;
	}


	public KaleoProcessService getWrappedService() {
		return _kaleoProcessService;
	}


	public void setWrappedService(KaleoProcessService kaleoProcessService) {
		_kaleoProcessService = kaleoProcessService;
	}

	private KaleoProcessService _kaleoProcessService;
}