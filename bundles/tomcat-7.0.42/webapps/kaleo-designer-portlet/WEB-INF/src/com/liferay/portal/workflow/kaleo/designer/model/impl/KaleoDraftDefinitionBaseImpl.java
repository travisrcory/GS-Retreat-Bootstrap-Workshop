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

package com.liferay.portal.workflow.kaleo.designer.model.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.workflow.kaleo.designer.model.KaleoDraftDefinition;
import com.liferay.portal.workflow.kaleo.designer.service.KaleoDraftDefinitionLocalServiceUtil;

/**
 * The extended model base implementation for the KaleoDraftDefinition service. Represents a row in the &quot;KaleoDraftDefinition&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link KaleoDraftDefinitionImpl}.
 * </p>
 *
 * @author Eduardo Lundgren
 * @see KaleoDraftDefinitionImpl
 * @see com.liferay.portal.workflow.kaleo.designer.model.KaleoDraftDefinition
 * @generated
 */
public abstract class KaleoDraftDefinitionBaseImpl
	extends KaleoDraftDefinitionModelImpl implements KaleoDraftDefinition {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a kaleo draft definition model instance should use the {@link KaleoDraftDefinition} interface instead.
	 */

	public void persist() throws SystemException {
		if (this.isNew()) {
			KaleoDraftDefinitionLocalServiceUtil.addKaleoDraftDefinition(this);
		}
		else {
			KaleoDraftDefinitionLocalServiceUtil.updateKaleoDraftDefinition(this);
		}
	}
}