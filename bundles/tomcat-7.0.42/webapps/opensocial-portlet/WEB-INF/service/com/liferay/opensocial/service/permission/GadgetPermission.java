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

package com.liferay.opensocial.service.permission;

import com.liferay.opensocial.model.Gadget;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

/**
 * @author Michael Young
 */
public class GadgetPermission {

	public static final String RESOURCE_NAME = "com.liferay.opensocial";

	public static void check(
			PermissionChecker permissionChecker, long groupId, long gadgetId,
			String actionId)
		throws PortalException {

		if (!contains(permissionChecker, groupId, gadgetId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(
			PermissionChecker permissionChecker, long groupId, String actionId)
		throws PortalException {

		if (!contains(permissionChecker, groupId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(
		PermissionChecker permissionChecker, long groupId, long gadgetId,
		String actionId) {

		return permissionChecker.hasPermission(
			groupId, Gadget.class.getName(), gadgetId, actionId);
	}

	public static boolean contains(
		PermissionChecker permissionChecker, long groupId, String actionId) {

		return permissionChecker.hasPermission(
			groupId, RESOURCE_NAME, groupId, actionId);
	}

}