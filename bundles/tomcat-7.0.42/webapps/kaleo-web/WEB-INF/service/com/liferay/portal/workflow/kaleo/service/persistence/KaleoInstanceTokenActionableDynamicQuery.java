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

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken;
import com.liferay.portal.workflow.kaleo.service.KaleoInstanceTokenLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class KaleoInstanceTokenActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public KaleoInstanceTokenActionableDynamicQuery() throws SystemException {
		setBaseLocalService(KaleoInstanceTokenLocalServiceUtil.getService());
		setClass(KaleoInstanceToken.class);

		setClassLoader(com.liferay.portal.workflow.kaleo.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("kaleoInstanceTokenId");
	}
}