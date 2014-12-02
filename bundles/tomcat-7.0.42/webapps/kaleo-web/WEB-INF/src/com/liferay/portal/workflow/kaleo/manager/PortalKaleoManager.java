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

package com.liferay.portal.workflow.kaleo.manager;

import com.liferay.portal.model.Company;

/**
 * @author Michael C. Han
 */
public interface PortalKaleoManager {

	public void deleteKaleoData(Company company) throws Exception;

	public void deployDefaultDefinitionLink(String assetClassName)
		throws Exception;

	public void deployDefaultDefinitionLinks() throws Exception;

	public void deployDefaultDefinitionLinks(Company company) throws Exception;

	public void deployDefaultDefinitions() throws Exception;

	public void deployDefaultDefinitions(Company company) throws Exception;

	public void deployDefaultRoles() throws Exception;

	public void deployDefaultRoles(Company company) throws Exception;

	public void deployKaleoDefaults() throws Exception;

	public void deployKaleoDefaults(Company company) throws Exception;

}