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

package com.liferay.calendar.service.persistence;

import com.liferay.calendar.model.CalendarResource;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.ExportImportHelperUtil;
import com.liferay.portal.kernel.lar.ManifestSummary;
import com.liferay.portal.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.util.PortalUtil;

/**
 * @author Eduardo Lundgren
 * @generated
 */
public class CalendarResourceExportActionableDynamicQuery
	extends CalendarResourceActionableDynamicQuery {
	public CalendarResourceExportActionableDynamicQuery(
		PortletDataContext portletDataContext) throws SystemException {
		_portletDataContext = portletDataContext;

		setCompanyId(_portletDataContext.getCompanyId());

		setGroupId(_portletDataContext.getScopeGroupId());
	}


	public long performCount() throws PortalException, SystemException {
		ManifestSummary manifestSummary = _portletDataContext.getManifestSummary();

		StagedModelType stagedModelType = getStagedModelType();

		long modelAdditionCount = super.performCount();

		manifestSummary.addModelAdditionCount(stagedModelType.toString(),
			modelAdditionCount);

		long modelDeletionCount = ExportImportHelperUtil.getModelDeletionCount(_portletDataContext,
				stagedModelType);

		manifestSummary.addModelDeletionCount(stagedModelType.toString(),
			modelDeletionCount);

		return modelAdditionCount;
	}


	protected void addCriteria(DynamicQuery dynamicQuery) {
		_portletDataContext.addDateRangeCriteria(dynamicQuery, "modifiedDate");

		if (getStagedModelType().getReferrerClassNameId() >= 0) {
			Property classNameIdProperty = PropertyFactoryUtil.forName(
					"classNameId");

			dynamicQuery.add(classNameIdProperty.eq(getStagedModelType()
														.getReferrerClassNameId()));
		}
	}

	protected StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				CalendarResource.class.getName()));
	}


	@SuppressWarnings("unused")
	protected void performAction(Object object)
		throws PortalException, SystemException {
		CalendarResource stagedModel = (CalendarResource)object;

		StagedModelDataHandlerUtil.exportStagedModel(_portletDataContext,
			stagedModel);
	}

	private PortletDataContext _portletDataContext;
}