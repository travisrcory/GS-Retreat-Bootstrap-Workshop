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

package com.liferay.portal.workflow.kaleo.service.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.workflow.kaleo.model.KaleoDefinition;
import com.liferay.portal.workflow.kaleo.service.base.KaleoDefinitionServiceBaseImpl;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class KaleoDefinitionServiceImpl extends KaleoDefinitionServiceBaseImpl {


	public List<KaleoDefinition> getKaleoDefinitions(int start, int end)
		throws SystemException {

		return kaleoDefinitionPersistence.findAll(start, end);
	}


	public List<KaleoDefinition> getKaleoDefinitions(
			long companyId, int start, int end)
		throws SystemException {

		return kaleoDefinitionPersistence.findByCompanyId(
			companyId, start, end);
	}

}