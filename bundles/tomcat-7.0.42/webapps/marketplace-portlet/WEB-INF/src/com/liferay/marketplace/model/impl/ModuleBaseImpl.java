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

import com.liferay.marketplace.model.Module;
import com.liferay.marketplace.service.ModuleLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the Module service. Represents a row in the &quot;Marketplace_Module&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ModuleImpl}.
 * </p>
 *
 * @author Ryan Park
 * @see ModuleImpl
 * @see com.liferay.marketplace.model.Module
 * @generated
 */
public abstract class ModuleBaseImpl extends ModuleModelImpl implements Module {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a module model instance should use the {@link Module} interface instead.
	 */

	public void persist() throws SystemException {
		if (this.isNew()) {
			ModuleLocalServiceUtil.addModule(this);
		}
		else {
			ModuleLocalServiceUtil.updateModule(this);
		}
	}
}