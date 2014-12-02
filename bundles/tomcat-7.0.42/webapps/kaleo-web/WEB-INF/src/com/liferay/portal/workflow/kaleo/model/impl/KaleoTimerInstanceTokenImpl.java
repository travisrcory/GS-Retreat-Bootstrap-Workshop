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
import com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken;
import com.liferay.portal.workflow.kaleo.model.KaleoTaskInstanceToken;
import com.liferay.portal.workflow.kaleo.model.KaleoTimer;
import com.liferay.portal.workflow.kaleo.service.KaleoInstanceTokenLocalServiceUtil;
import com.liferay.portal.workflow.kaleo.service.KaleoTaskInstanceTokenLocalServiceUtil;
import com.liferay.portal.workflow.kaleo.service.KaleoTimerLocalServiceUtil;

/**
 * @author Marcellus Tavares
 */
public class KaleoTimerInstanceTokenImpl
	extends KaleoTimerInstanceTokenBaseImpl {

	public KaleoTimerInstanceTokenImpl() {
	}


	public KaleoInstanceToken getKaleoInstanceToken()
		throws PortalException, SystemException {

		return KaleoInstanceTokenLocalServiceUtil.getKaleoInstanceToken(
			getKaleoInstanceTokenId());
	}


	public KaleoTaskInstanceToken getKaleoTaskInstanceToken()
		throws SystemException {

		return KaleoTaskInstanceTokenLocalServiceUtil.
			fetchKaleoTaskInstanceToken(getKaleoTaskInstanceTokenId());
	}


	public KaleoTimer getKaleoTimer() throws PortalException, SystemException {
		return KaleoTimerLocalServiceUtil.getKaleoTimer(getKaleoTimerId());
	}

}