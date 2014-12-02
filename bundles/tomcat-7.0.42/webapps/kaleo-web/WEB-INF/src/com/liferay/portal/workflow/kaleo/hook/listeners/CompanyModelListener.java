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

package com.liferay.portal.workflow.kaleo.hook.listeners;

import com.liferay.portal.ModelListenerException;
import com.liferay.portal.model.BaseModelListener;
import com.liferay.portal.model.Company;
import com.liferay.portal.workflow.kaleo.manager.PortalKaleoManager;
import com.liferay.portal.workflow.kaleo.manager.PortalKaleoManagerUtil;

/**
 * @author Michael C. Han
 */
public class CompanyModelListener extends BaseModelListener<Company> {


	public void onAfterRemove(Company company) throws ModelListenerException {
		try {
			PortalKaleoManager portalKaleoManager =
				PortalKaleoManagerUtil.getPortalKaleoManager();

			portalKaleoManager.deleteKaleoData(company);
		}
		catch (Exception e) {
			throw new ModelListenerException(e);
		}
	}

}