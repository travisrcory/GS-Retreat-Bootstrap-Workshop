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
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.workflow.kaleo.model.KaleoInstance;
import com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken;
import com.liferay.portal.workflow.kaleo.model.KaleoNode;
import com.liferay.portal.workflow.kaleo.service.KaleoInstanceLocalServiceUtil;
import com.liferay.portal.workflow.kaleo.service.KaleoInstanceTokenLocalServiceUtil;
import com.liferay.portal.workflow.kaleo.service.KaleoNodeLocalServiceUtil;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class KaleoInstanceTokenImpl extends KaleoInstanceTokenBaseImpl {

	public static final long DEFAULT_PARENT_KALEO_INSTANCE_TOKEN_ID = 0;

	public KaleoInstanceTokenImpl() {
	}


	public List<KaleoInstanceToken> getChildrenKaleoInstanceTokens()
		throws SystemException {

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setCompanyId(getCompanyId());

		return KaleoInstanceTokenLocalServiceUtil.getKaleoInstanceTokens(
			getKaleoInstanceTokenId(), serviceContext);
	}


	public KaleoNode getCurrentKaleoNode()
		throws PortalException, SystemException {

		return KaleoNodeLocalServiceUtil.getKaleoNode(getCurrentKaleoNodeId());
	}


	public List<KaleoInstanceToken> getIncompleteChildrenKaleoInstanceTokens()
		throws SystemException {

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setCompanyId(getCompanyId());

		return KaleoInstanceTokenLocalServiceUtil.getKaleoInstanceTokens(
			getKaleoInstanceTokenId(), null, serviceContext);
	}


	public KaleoInstance getKaleoInstance()
		throws PortalException, SystemException {

		return KaleoInstanceLocalServiceUtil.getKaleoInstance(
			getKaleoInstanceId());
	}


	public KaleoInstanceToken getParentKaleoInstanceToken()
		throws PortalException, SystemException {

		return KaleoInstanceTokenLocalServiceUtil.getKaleoInstanceToken(
			getParentKaleoInstanceTokenId());
	}


	public boolean hasIncompleteChildrenKaleoInstanceToken()
		throws SystemException {

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setCompanyId(getCompanyId());

		int count =
			KaleoInstanceTokenLocalServiceUtil.getKaleoInstanceTokensCount(
				getKaleoInstanceTokenId(), null, serviceContext);

		if (count > 0) {
			return true;
		}
		else {
			return false;
		}
	}


	public void setCurrentKaleoNode(KaleoNode kaleoNode)
		throws PortalException, SystemException {

		setCurrentKaleoNodeId(kaleoNode.getKaleoNodeId());

		KaleoInstanceTokenLocalServiceUtil.updateKaleoInstanceToken(
			getKaleoInstanceTokenId(), kaleoNode.getKaleoNodeId());
	}

}