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

package com.liferay.sync.service.impl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.sync.model.SyncDLObject;
import com.liferay.sync.service.base.SyncDLObjectLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

/**
 * @author Michael Young
 * @author Dennis Ju
 */
public class SyncDLObjectLocalServiceImpl
	extends SyncDLObjectLocalServiceBaseImpl {


	public SyncDLObject addSyncDLObject(
			long companyId, long modifiedTime, long repositoryId,
			long parentFolderId, String name, String extension, String mimeType,
			String description, String changeLog, String extraSettings,
			String version, long size, String checksum, String event,
			Date lockExpirationDate, long lockUserId, String lockUserName,
			String type, long typePK, String typeUuid)
		throws PortalException, SystemException {

		if (!isDefaultRepository(parentFolderId)) {
			return null;
		}

		SyncDLObject syncDLObject = syncDLObjectPersistence.fetchByTypePK(
			typePK);

		if (syncDLObject == null) {
			long syncId = counterLocalService.increment();

			syncDLObject = syncDLObjectPersistence.create(syncId);

			syncDLObject.setCompanyId(companyId);
			syncDLObject.setCreateTime(modifiedTime);
			syncDLObject.setRepositoryId(repositoryId);
			syncDLObject.setType(type);
			syncDLObject.setTypePK(typePK);
			syncDLObject.setTypeUuid(typeUuid);
		}
		else if (syncDLObject.getModifiedTime() > modifiedTime) {
			return null;
		}

		syncDLObject.setModifiedTime(modifiedTime);
		syncDLObject.setParentFolderId(parentFolderId);
		syncDLObject.setName(name);
		syncDLObject.setExtension(extension);
		syncDLObject.setMimeType(mimeType);
		syncDLObject.setDescription(description);
		syncDLObject.setChangeLog(changeLog);
		syncDLObject.setExtraSettings(extraSettings);
		syncDLObject.setVersion(version);
		syncDLObject.setSize(size);
		syncDLObject.setChecksum(checksum);
		syncDLObject.setEvent(event);
		syncDLObject.setLockExpirationDate(lockExpirationDate);
		syncDLObject.setLockUserId(lockUserId);
		syncDLObject.setLockUserName(lockUserName);

		return syncDLObjectPersistence.update(syncDLObject);
	}


	public SyncDLObject fetchSyncDLObject(long typePK) throws SystemException {
		return syncDLObjectPersistence.fetchByTypePK(typePK);
	}


	public long getLatestModifiedTime() throws SystemException {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SyncDLObject.class, SyncDLObject.class.getClassLoader());

		Projection projection = ProjectionFactoryUtil.max("modifiedTime");

		dynamicQuery.setProjection(projection);

		List<Long> modifiedTimes = syncDLObjectPersistence.findWithDynamicQuery(
			dynamicQuery);

		if (modifiedTimes.isEmpty()) {
			return System.currentTimeMillis();
		}

		return modifiedTimes.get(0);
	}

	protected boolean isDefaultRepository(long folderId)
		throws PortalException, SystemException {

		if (folderId == DLFolderConstants.DEFAULT_PARENT_FOLDER_ID) {
			return true;
		}

		Folder folder = dlAppLocalService.getFolder(folderId);

		return folder.isDefaultRepository();
	}

}