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

package com.liferay.portal.workflow.kaleo.model.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.workflow.kaleo.model.KaleoTransition;
import com.liferay.portal.workflow.kaleo.service.KaleoTransitionLocalServiceUtil;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class KaleoNodeImpl extends KaleoNodeBaseImpl {

	public KaleoNodeImpl() {
	}


	public KaleoTransition getDefaultKaleoTransition()
		throws PortalException, SystemException {

		return KaleoTransitionLocalServiceUtil.getDefaultKaleoTransition(
			getKaleoNodeId());
	}


	public KaleoTransition getKaleoTransition(String name)
		throws PortalException, SystemException {

		return KaleoTransitionLocalServiceUtil.getKaleoTransition(
			getKaleoNodeId(), name);
	}


	public List<KaleoTransition> getKaleoTransitions() throws SystemException {
		return KaleoTransitionLocalServiceUtil.getKaleoTransitions(
			getKaleoNodeId());
	}


	public boolean hasKaleoTransition() throws SystemException {
		int count = KaleoTransitionLocalServiceUtil.getKaleoTransitionsCount(
			getKaleoNodeId());

		if (count > 0) {
			return true;
		}
		else {
			return false;
		}
	}

}