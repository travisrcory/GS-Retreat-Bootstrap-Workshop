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

package com.liferay.marketplace.model.impl;

import com.liferay.marketplace.model.App;
import com.liferay.marketplace.service.AppLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the App service. Represents a row in the &quot;Marketplace_App&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AppImpl}.
 * </p>
 *
 * @author Ryan Park
 * @see AppImpl
 * @see com.liferay.marketplace.model.App
 * @generated
 */
public abstract class AppBaseImpl extends AppModelImpl implements App {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a app model instance should use the {@link App} interface instead.
	 */

	public void persist() throws SystemException {
		if (this.isNew()) {
			AppLocalServiceUtil.addApp(this);
		}
		else {
			AppLocalServiceUtil.updateApp(this);
		}
	}
}