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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for KaleoProcess. This utility wraps
 * {@link com.liferay.portal.workflow.kaleo.forms.service.impl.KaleoProcessServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Marcellus Tavares
 * @see KaleoProcessService
 * @see com.liferay.portal.workflow.kaleo.forms.service.base.KaleoProcessServiceBaseImpl
 * @see com.liferay.portal.workflow.kaleo.forms.service.impl.KaleoProcessServiceImpl
 * @generated
 */
public class KaleoProcessServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.portal.workflow.kaleo.forms.service.impl.KaleoProcessServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess addKaleoProcess(
		long groupId, long ddlRecordSetId, long ddmTemplateId,
		long[] kaleoProcessLinkIds,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addKaleoProcess(groupId, ddlRecordSetId, ddmTemplateId,
			kaleoProcessLinkIds, serviceContext);
	}

	public static com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess deleteKaleoProcess(
		long kaleoProcessId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteKaleoProcess(kaleoProcessId);
	}

	public static void deleteKaleoProcessData(long kaleoProcessId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteKaleoProcessData(kaleoProcessId);
	}

	public static com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess getKaleoProcess(
		long kaleoProcessId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getKaleoProcess(kaleoProcessId);
	}

	public static java.util.List<com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess> getKaleoProcesses(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getKaleoProcesses(groupId, start, end, orderByComparator);
	}

	public static int getKaleoProcessesCount(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getKaleoProcessesCount(groupId);
	}

	public static com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess updateKaleoProcess(
		long kaleoProcessId, long ddmTemplateId, long[] kaleoProcessLinkIds,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateKaleoProcess(kaleoProcessId, ddmTemplateId,
			kaleoProcessLinkIds, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static KaleoProcessService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					KaleoProcessService.class.getName());

			if (invokableService instanceof KaleoProcessService) {
				_service = (KaleoProcessService)invokableService;
			}
			else {
				_service = new KaleoProcessServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(KaleoProcessServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(KaleoProcessService service) {
	}

	private static KaleoProcessService _service;
}