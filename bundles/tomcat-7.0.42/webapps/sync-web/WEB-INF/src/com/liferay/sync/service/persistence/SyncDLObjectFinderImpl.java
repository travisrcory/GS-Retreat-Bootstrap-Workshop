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

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.model.DLSyncConstants;
import com.liferay.sync.model.SyncDLObject;
import com.liferay.sync.model.impl.SyncDLObjectImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

import java.util.List;

/**
 * @author Michael Young
 */
public class SyncDLObjectFinderImpl
	extends BasePersistenceImpl<SyncDLObject> implements SyncDLObjectFinder {

	public static final String FIND_BY_C_M_R_E =
		SyncDLObjectFinder.class.getName() + ".findByC_M_R_E";

	public static final String FIND_BY_C_M_R_T =
		SyncDLObjectFinder.class.getName() + ".findByC_M_R_T";


	public List<SyncDLObject> filterFindByC_M_R(
			long companyId, long modifiedTime, long repositoryId)
		throws SystemException {

		Session session = null;

		try {
			session = openSession();

			StringBundler sb = new StringBundler(5);

			String sql = CustomSQLUtil.get(FIND_BY_C_M_R_E);

			sb.append(sql);
			sb.append(" UNION ALL ");

			sql = CustomSQLUtil.get(FIND_BY_C_M_R_T);

			sql = InlineSQLHelperUtil.replacePermissionCheck(
				sql, DLFileEntry.class.getName(), "SyncDLObject.typePK", null,
				"SyncDLObject.repositoryId", new long[] {repositoryId},
				null);

			sb.append(sql);
			sb.append(" UNION ALL ");

			sql = CustomSQLUtil.get(FIND_BY_C_M_R_T);

			sql = InlineSQLHelperUtil.replacePermissionCheck(
				sql, DLFolder.class.getName(), "SyncDLObject.typePK", null,
				"SyncDLObject.repositoryId", new long[] {repositoryId},
				null);

			sb.append(sql);

			sql = sb.toString();

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("SyncDLObject", SyncDLObjectImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);
			qPos.add(modifiedTime);
			qPos.add(repositoryId);
			qPos.add(DLSyncConstants.EVENT_DELETE);
			qPos.add(companyId);
			qPos.add(modifiedTime);
			qPos.add(repositoryId);
			qPos.add(DLSyncConstants.TYPE_FILE);
			qPos.add(companyId);
			qPos.add(modifiedTime);
			qPos.add(repositoryId);
			qPos.add(DLSyncConstants.TYPE_FOLDER);

			return q.list();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

}