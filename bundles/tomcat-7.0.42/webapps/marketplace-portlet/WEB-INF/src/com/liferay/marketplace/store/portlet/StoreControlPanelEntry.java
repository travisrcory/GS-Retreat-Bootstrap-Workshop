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

package com.liferay.marketplace.store.portlet;

import com.liferay.marketplace.util.PortletPropsValues;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portlet.BaseControlPanelEntry;

/**
 * @author Ryan Park
 */
public class StoreControlPanelEntry extends BaseControlPanelEntry {


	public boolean hasAccessPermission(
			PermissionChecker permissionChecker, Group group, Portlet portlet)
		throws Exception {

		if (!PortletPropsValues.MARKETPLACE_STORE_ENABLED) {
			return false;
		}

		return permissionChecker.isOmniadmin();
	}

}