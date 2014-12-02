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

package com.liferay.opensocial.service.persistence;

import com.liferay.opensocial.model.OAuthConsumer;
import com.liferay.opensocial.service.OAuthConsumerLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class OAuthConsumerActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public OAuthConsumerActionableDynamicQuery() throws SystemException {
		setBaseLocalService(OAuthConsumerLocalServiceUtil.getService());
		setClass(OAuthConsumer.class);

		setClassLoader(com.liferay.opensocial.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("oAuthConsumerId");
	}
}