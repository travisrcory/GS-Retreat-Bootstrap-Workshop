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

package com.liferay.portal.workflow.kaleo.forms.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess;
import com.liferay.portal.workflow.kaleo.forms.service.KaleoProcessLocalServiceUtil;

/**
 * @author Marcellus Tavares
 * @generated
 */
public abstract class KaleoProcessActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public KaleoProcessActionableDynamicQuery() throws SystemException {
		setBaseLocalService(KaleoProcessLocalServiceUtil.getService());
		setClass(KaleoProcess.class);

		setClassLoader(com.liferay.portal.workflow.kaleo.forms.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("kaleoProcessId");
	}
}