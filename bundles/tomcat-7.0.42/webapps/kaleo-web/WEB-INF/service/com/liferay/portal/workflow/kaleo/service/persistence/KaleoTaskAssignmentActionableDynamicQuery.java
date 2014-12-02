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

package com.liferay.portal.workflow.kaleo.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.workflow.kaleo.model.KaleoTaskAssignment;
import com.liferay.portal.workflow.kaleo.service.KaleoTaskAssignmentLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class KaleoTaskAssignmentActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public KaleoTaskAssignmentActionableDynamicQuery()
		throws SystemException {
		setBaseLocalService(KaleoTaskAssignmentLocalServiceUtil.getService());
		setClass(KaleoTaskAssignment.class);

		setClassLoader(com.liferay.portal.workflow.kaleo.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("kaleoTaskAssignmentId");
	}
}