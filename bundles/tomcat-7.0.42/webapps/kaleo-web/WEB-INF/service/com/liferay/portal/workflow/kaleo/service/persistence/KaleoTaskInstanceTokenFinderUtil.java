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

package com.liferay.portal.workflow.kaleo.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Brian Wing Shun Chan
 */
public class KaleoTaskInstanceTokenFinderUtil {
	public static int countKaleoTaskInstanceTokens(
		com.liferay.portal.workflow.kaleo.service.persistence.KaleoTaskInstanceTokenQuery kaleoTaskInstanceTokenQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countKaleoTaskInstanceTokens(kaleoTaskInstanceTokenQuery);
	}

	public static java.util.List<com.liferay.portal.workflow.kaleo.model.KaleoTaskInstanceToken> findKaleoTaskInstanceTokens(
		com.liferay.portal.workflow.kaleo.service.persistence.KaleoTaskInstanceTokenQuery kaleoTaskInstanceTokenQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findKaleoTaskInstanceTokens(kaleoTaskInstanceTokenQuery);
	}

	public static KaleoTaskInstanceTokenFinder getFinder() {
		if (_finder == null) {
			_finder = (KaleoTaskInstanceTokenFinder)PortletBeanLocatorUtil.locate(com.liferay.portal.workflow.kaleo.service.ClpSerializer.getServletContextName(),
					KaleoTaskInstanceTokenFinder.class.getName());

			ReferenceRegistry.registerReference(KaleoTaskInstanceTokenFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(KaleoTaskInstanceTokenFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(KaleoTaskInstanceTokenFinderUtil.class,
			"_finder");
	}

	private static KaleoTaskInstanceTokenFinder _finder;
}