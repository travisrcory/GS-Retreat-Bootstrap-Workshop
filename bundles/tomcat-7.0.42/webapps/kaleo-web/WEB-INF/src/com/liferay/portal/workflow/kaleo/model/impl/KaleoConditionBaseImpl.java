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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.workflow.kaleo.model.KaleoCondition;
import com.liferay.portal.workflow.kaleo.service.KaleoConditionLocalServiceUtil;

/**
 * The extended model base implementation for the KaleoCondition service. Represents a row in the &quot;KaleoCondition&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link KaleoConditionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KaleoConditionImpl
 * @see com.liferay.portal.workflow.kaleo.model.KaleoCondition
 * @generated
 */
public abstract class KaleoConditionBaseImpl extends KaleoConditionModelImpl
	implements KaleoCondition {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a kaleo condition model instance should use the {@link KaleoCondition} interface instead.
	 */

	public void persist() throws SystemException {
		if (this.isNew()) {
			KaleoConditionLocalServiceUtil.addKaleoCondition(this);
		}
		else {
			KaleoConditionLocalServiceUtil.updateKaleoCondition(this);
		}
	}
}