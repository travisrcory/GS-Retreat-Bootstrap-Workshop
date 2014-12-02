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

package com.liferay.sync.service.persistence;

/**
 * @author Brian Wing Shun Chan
 */
public interface SyncDLObjectFinder {
	public java.util.List<com.liferay.sync.model.SyncDLObject> filterFindByC_M_R(
		long companyId, long modifiedTime, long repositoryId)
		throws com.liferay.portal.kernel.exception.SystemException;
}