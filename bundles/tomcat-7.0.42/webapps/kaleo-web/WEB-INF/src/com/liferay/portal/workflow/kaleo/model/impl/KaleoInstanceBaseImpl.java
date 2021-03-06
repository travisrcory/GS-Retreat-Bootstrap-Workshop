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
import com.liferay.portal.workflow.kaleo.model.KaleoInstance;
import com.liferay.portal.workflow.kaleo.service.KaleoInstanceLocalServiceUtil;

/**
 * The extended model base implementation for the KaleoInstance service. Represents a row in the &quot;KaleoInstance&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link KaleoInstanceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KaleoInstanceImpl
 * @see com.liferay.portal.workflow.kaleo.model.KaleoInstance
 * @generated
 */
public abstract class KaleoInstanceBaseImpl extends KaleoInstanceModelImpl
	implements KaleoInstance {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a kaleo instance model instance should use the {@link KaleoInstance} interface instead.
	 */

	public void persist() throws SystemException {
		if (this.isNew()) {
			KaleoInstanceLocalServiceUtil.addKaleoInstance(this);
		}
		else {
			KaleoInstanceLocalServiceUtil.updateKaleoInstance(this);
		}
	}
}