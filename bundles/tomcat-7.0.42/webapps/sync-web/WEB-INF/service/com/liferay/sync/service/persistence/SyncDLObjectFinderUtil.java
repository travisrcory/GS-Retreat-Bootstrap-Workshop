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

package com.liferay.sync.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Brian Wing Shun Chan
 */
public class SyncDLObjectFinderUtil {
	public static java.util.List<com.liferay.sync.model.SyncDLObject> filterFindByC_M_R(
		long companyId, long modifiedTime, long repositoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .filterFindByC_M_R(companyId, modifiedTime, repositoryId);
	}

	public static SyncDLObjectFinder getFinder() {
		if (_finder == null) {
			_finder = (SyncDLObjectFinder)PortletBeanLocatorUtil.locate(com.liferay.sync.service.ClpSerializer.getServletContextName(),
					SyncDLObjectFinder.class.getName());

			ReferenceRegistry.registerReference(SyncDLObjectFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(SyncDLObjectFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(SyncDLObjectFinderUtil.class,
			"_finder");
	}

	private static SyncDLObjectFinder _finder;
}