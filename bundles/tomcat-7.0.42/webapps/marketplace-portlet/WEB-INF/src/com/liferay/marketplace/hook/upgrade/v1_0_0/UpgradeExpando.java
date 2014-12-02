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

package com.liferay.marketplace.hook.upgrade.v1_0_0;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.expando.NoSuchTableException;
import com.liferay.portlet.expando.model.ExpandoColumn;
import com.liferay.portlet.expando.model.ExpandoColumnConstants;
import com.liferay.portlet.expando.model.ExpandoTable;
import com.liferay.portlet.expando.model.ExpandoValue;
import com.liferay.portlet.expando.service.ExpandoColumnLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoTableLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;

import java.util.List;

/**
 * @author Peter Shin
 */
public class UpgradeExpando extends UpgradeProcess {


	protected void doUpgrade() throws Exception {
		for (long companyId : PortalUtil.getCompanyIds()) {
			updateMPExpandoColumns(companyId);
		}
	}

	protected void updateMPExpandoColumns(long companyId) throws Exception {
		ExpandoTable expandoTable = null;

		try {
			expandoTable = ExpandoTableLocalServiceUtil.getTable(
				companyId, User.class.getName(), "MP");
		}
		catch (NoSuchTableException nste) {
			return;
		}

		ExpandoColumn oldExpandoColumn =
			ExpandoColumnLocalServiceUtil.getColumn(
				companyId, User.class.getName(), expandoTable.getName(),
				"client-id");

		if (oldExpandoColumn == null) {
			return;
		}

		ExpandoColumn newExpandoColumn =
			ExpandoColumnLocalServiceUtil.getColumn(
				companyId, User.class.getName(), expandoTable.getName(),
				"clientId");

		if (newExpandoColumn == null) {
			newExpandoColumn = ExpandoColumnLocalServiceUtil.updateColumn(
				oldExpandoColumn.getColumnId(), "clientId",
				ExpandoColumnConstants.STRING);
		}

		List<ExpandoValue> expandoValues =
			ExpandoValueLocalServiceUtil.getColumnValues(
				oldExpandoColumn.getColumnId(), QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);

		for (ExpandoValue expandoValue : expandoValues) {
			ExpandoValueLocalServiceUtil.addValue(
				expandoValue.getCompanyId(), User.class.getName(),
				expandoTable.getName(), newExpandoColumn.getName(),
				expandoValue.getClassPK(), expandoValue.getString());
		}

		ExpandoColumnLocalServiceUtil.deleteColumn(
			oldExpandoColumn.getColumnId());
	}

}