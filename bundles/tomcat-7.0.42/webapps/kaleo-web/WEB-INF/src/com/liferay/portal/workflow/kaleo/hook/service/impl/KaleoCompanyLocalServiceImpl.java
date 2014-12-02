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

package com.liferay.portal.workflow.kaleo.hook.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Company;
import com.liferay.portal.service.CompanyLocalService;
import com.liferay.portal.service.CompanyLocalServiceWrapper;
import com.liferay.portal.workflow.kaleo.manager.PortalKaleoManager;
import com.liferay.portal.workflow.kaleo.manager.PortalKaleoManagerUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class KaleoCompanyLocalServiceImpl extends CompanyLocalServiceWrapper {

	public KaleoCompanyLocalServiceImpl(
		CompanyLocalService companyLocalService) {

		super(companyLocalService);
	}


	public Company checkCompany(String webId, String mx, String shardName)
		throws PortalException, SystemException {

		Company company = super.checkCompany(webId, mx, shardName);

		try {
			PortalKaleoManager portalKaleoManager =
				PortalKaleoManagerUtil.getPortalKaleoManager();

			portalKaleoManager.deployKaleoDefaults(company);
		}
		catch (PortalException pe) {
			throw pe;
		}
		catch (SystemException se) {
			throw se;
		}
		catch (Exception e) {
			throw new SystemException(e);
		}

		return company;
	}

}