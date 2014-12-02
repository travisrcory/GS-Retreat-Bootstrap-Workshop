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

package com.liferay.marketplace.service.persistence;

import com.liferay.marketplace.model.App;
import com.liferay.marketplace.service.AppLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Ryan Park
 * @generated
 */
public abstract class AppActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public AppActionableDynamicQuery() throws SystemException {
		setBaseLocalService(AppLocalServiceUtil.getService());
		setClass(App.class);

		setClassLoader(com.liferay.marketplace.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("appId");
	}
}