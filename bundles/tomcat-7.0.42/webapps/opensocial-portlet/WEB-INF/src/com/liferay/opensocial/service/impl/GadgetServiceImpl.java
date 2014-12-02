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

package com.liferay.opensocial.service.impl;

import com.liferay.opensocial.model.Gadget;
import com.liferay.opensocial.service.base.GadgetServiceBaseImpl;
import com.liferay.opensocial.service.permission.GadgetPermission;
import com.liferay.opensocial.util.ActionKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

/**
 * @author Brian Wing Shun Chan
 * @author Dennis Ju
 */
public class GadgetServiceImpl extends GadgetServiceBaseImpl {

	public Gadget addGadget(
			long companyId, String url, String portletCategoryNames,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		GadgetPermission.check(
			getPermissionChecker(), serviceContext.getScopeGroupId(),
			ActionKeys.PUBLISH_GADGET);

		return gadgetLocalService.addGadget(
			companyId, url, portletCategoryNames, serviceContext);
	}

	public void deleteGadget(long gadgetId, ServiceContext serviceContext)
		throws PortalException, SystemException {

		GadgetPermission.check(
			getPermissionChecker(), serviceContext.getScopeGroupId(), gadgetId,
			ActionKeys.DELETE);

		gadgetLocalService.deleteGadget(gadgetId);
	}

	public void updateGadget(
			long gadgetId, String portletCategoryNames,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		GadgetPermission.check(
			getPermissionChecker(), serviceContext.getScopeGroupId(), gadgetId,
			ActionKeys.UPDATE);

		gadgetLocalService.updateGadget(gadgetId, portletCategoryNames);
	}

}