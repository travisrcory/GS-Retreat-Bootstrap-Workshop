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
 * The extended model interface for the KaleoInstanceToken service. Represents a row in the &quot;KaleoInstanceToken&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see KaleoInstanceTokenModel
 * @see com.liferay.portal.workflow.kaleo.model.impl.KaleoInstanceTokenImpl
 * @see com.liferay.portal.workflow.kaleo.model.impl.KaleoInstanceTokenModelImpl
 * @generated
 */
public interface KaleoInstanceToken extends KaleoInstanceTokenModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.portal.workflow.kaleo.model.impl.KaleoInstanceTokenImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public java.util.List<com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken> getChildrenKaleoInstanceTokens()
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.workflow.kaleo.model.KaleoNode getCurrentKaleoNode()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken> getIncompleteChildrenKaleoInstanceTokens()
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.workflow.kaleo.model.KaleoInstance getKaleoInstance()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken getParentKaleoInstanceToken()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public boolean hasIncompleteChildrenKaleoInstanceToken()
		throws com.liferay.portal.kernel.exception.SystemException;

	public void setCurrentKaleoNode(
		com.liferay.portal.workflow.kaleo.model.KaleoNode kaleoNode)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}