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

package com.liferay.portal.workflow.kaleo.export;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Michael C. Han
 */
public class DefinitionExporterUtil {

	public static String export(long kaleoDefinitionId)
		throws PortalException, SystemException {

		return getDefinitionExporter().export(kaleoDefinitionId);
	}

	public static String export(long companyId, String name, int version)
		throws PortalException, SystemException {

		return getDefinitionExporter().export(companyId, name, version);
	}

	public static DefinitionExporter getDefinitionExporter() {
		return _definitionExporter;
	}

	public void setDefinitionExporter(DefinitionExporter definitionExporter) {
		_definitionExporter = definitionExporter;
	}

	private static DefinitionExporter _definitionExporter;

}