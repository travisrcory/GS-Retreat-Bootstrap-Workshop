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

package com.liferay.portal.workflow.kaleo.forms.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the KaleoProcess service. Represents a row in the &quot;KaleoProcess&quot; database table, with each column mapped to a property of this class.
 *
 * @author Marcellus Tavares
 * @see KaleoProcessModel
 * @see com.liferay.portal.workflow.kaleo.forms.model.impl.KaleoProcessImpl
 * @see com.liferay.portal.workflow.kaleo.forms.model.impl.KaleoProcessModelImpl
 * @generated
 */
public interface KaleoProcess extends KaleoProcessModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.portal.workflow.kaleo.forms.model.impl.KaleoProcessImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public com.liferay.portlet.dynamicdatalists.model.DDLRecordSet getDDLRecordSet()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portlet.dynamicdatamapping.model.DDMTemplate getDDMTemplate()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.lang.String getDescription(java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.liferay.portal.workflow.kaleo.forms.model.KaleoProcessLink> getKaleoProcessLinks()
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.lang.String getName(java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}