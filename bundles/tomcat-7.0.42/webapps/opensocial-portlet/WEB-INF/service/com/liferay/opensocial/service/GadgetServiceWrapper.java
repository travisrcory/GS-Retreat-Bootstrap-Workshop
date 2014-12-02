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

package com.liferay.opensocial.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GadgetService}.
 *
 * @author Brian Wing Shun Chan
 * @see GadgetService
 * @generated
 */
public class GadgetServiceWrapper implements GadgetService,
	ServiceWrapper<GadgetService> {
	public GadgetServiceWrapper(GadgetService gadgetService) {
		_gadgetService = gadgetService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/

	public java.lang.String getBeanIdentifier() {
		return _gadgetService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/

	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_gadgetService.setBeanIdentifier(beanIdentifier);
	}


	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _gadgetService.invokeMethod(name, parameterTypes, arguments);
	}


	public com.liferay.opensocial.model.Gadget addGadget(long companyId,
		java.lang.String url, java.lang.String portletCategoryNames,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _gadgetService.addGadget(companyId, url, portletCategoryNames,
			serviceContext);
	}


	public void deleteGadget(long gadgetId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_gadgetService.deleteGadget(gadgetId, serviceContext);
	}


	public void updateGadget(long gadgetId,
		java.lang.String portletCategoryNames,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_gadgetService.updateGadget(gadgetId, portletCategoryNames,
			serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public GadgetService getWrappedGadgetService() {
		return _gadgetService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedGadgetService(GadgetService gadgetService) {
		_gadgetService = gadgetService;
	}


	public GadgetService getWrappedService() {
		return _gadgetService;
	}


	public void setWrappedService(GadgetService gadgetService) {
		_gadgetService = gadgetService;
	}

	private GadgetService _gadgetService;
}