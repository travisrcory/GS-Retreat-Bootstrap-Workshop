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
 * The extended model interface for the KaleoDefinition service. Represents a row in the &quot;KaleoDefinition&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see KaleoDefinitionModel
 * @see com.liferay.portal.workflow.kaleo.model.impl.KaleoDefinitionImpl
 * @see com.liferay.portal.workflow.kaleo.model.impl.KaleoDefinitionModelImpl
 * @generated
 */
public interface KaleoDefinition extends KaleoDefinitionModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.portal.workflow.kaleo.model.impl.KaleoDefinitionImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public com.liferay.portal.workflow.kaleo.model.KaleoNode getKaleoStartNode()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public boolean hasIncompleteKaleoInstances()
		throws com.liferay.portal.kernel.exception.SystemException;
}