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

package com.liferay.portal.workflow.kaleo.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the KaleoInstance service. Represents a row in the &quot;KaleoInstance&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see KaleoInstanceModel
 * @see com.liferay.portal.workflow.kaleo.model.impl.KaleoInstanceImpl
 * @see com.liferay.portal.workflow.kaleo.model.impl.KaleoInstanceModelImpl
 * @generated
 */
public interface KaleoInstance extends KaleoInstanceModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.portal.workflow.kaleo.model.impl.KaleoInstanceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public com.liferay.portal.workflow.kaleo.model.KaleoDefinition getKaleoDefinition()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken getRootKaleoInstanceToken(
		java.util.Map<java.lang.String, java.io.Serializable> workflowContext,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken getRootKaleoInstanceToken(
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}