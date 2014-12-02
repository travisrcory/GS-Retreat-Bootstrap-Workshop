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

package com.liferay.portal.workflow.kaleo.forms.ddm;

import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.workflow.kaleo.forms.service.permission.KaleoFormsPermission;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordSet;
import com.liferay.portlet.dynamicdatamapping.model.DDMTemplateConstants;
import com.liferay.portlet.dynamicdatamapping.storage.StorageType;
import com.liferay.portlet.dynamicdatamapping.util.BaseDDMDisplay;

/**
 * @author Marcellus Tavares
 */
public class KaleoFormsDDMDisplay extends BaseDDMDisplay {


	public String getPortletId() {
		return "1_WAR_kaleoformsportlet";
	}


	public String getResourceName() {
		return KaleoFormsPermission.RESOURCE_NAME;
	}


	public String getStorageType() {
		return StorageType.XML.toString();
	}


	public String getStructureType() {
		return DDLRecordSet.class.getName();
	}


	public String getTemplateMode() {
		return DDMTemplateConstants.TEMPLATE_MODE_CREATE;
	}


	public String getTemplateType() {
		return DDMTemplateConstants.TEMPLATE_TYPE_FORM;
	}


	public String getViewTemplatesBackURL(
			LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse, long classPK)
		throws Exception {

		return StringPool.BLANK;
	}

}