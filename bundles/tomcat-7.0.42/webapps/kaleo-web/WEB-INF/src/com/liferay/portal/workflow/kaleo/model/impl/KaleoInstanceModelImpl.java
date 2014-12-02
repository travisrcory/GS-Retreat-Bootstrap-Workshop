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

package com.liferay.portal.workflow.kaleo.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.workflow.kaleo.model.KaleoInstance;
import com.liferay.portal.workflow.kaleo.model.KaleoInstanceModel;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the KaleoInstance service. Represents a row in the &quot;KaleoInstance&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portal.workflow.kaleo.model.KaleoInstanceModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link KaleoInstanceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KaleoInstanceImpl
 * @see com.liferay.portal.workflow.kaleo.model.KaleoInstance
 * @see com.liferay.portal.workflow.kaleo.model.KaleoInstanceModel
 * @generated
 */
public class KaleoInstanceModelImpl extends BaseModelImpl<KaleoInstance>
	implements KaleoInstanceModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a kaleo instance model instance should use the {@link com.liferay.portal.workflow.kaleo.model.KaleoInstance} interface instead.
	 */
	public static final String TABLE_NAME = "KaleoInstance";
	public static final Object[][] TABLE_COLUMNS = {
			{ "kaleoInstanceId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "kaleoDefinitionId", Types.BIGINT },
			{ "kaleoDefinitionName", Types.VARCHAR },
			{ "kaleoDefinitionVersion", Types.INTEGER },
			{ "rootKaleoInstanceTokenId", Types.BIGINT },
			{ "className", Types.VARCHAR },
			{ "classPK", Types.BIGINT },
			{ "completed", Types.BOOLEAN },
			{ "completionDate", Types.TIMESTAMP },
			{ "workflowContext", Types.CLOB }
		};
	public static final String TABLE_SQL_CREATE = "create table KaleoInstance (kaleoInstanceId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(200) null,createDate DATE null,modifiedDate DATE null,kaleoDefinitionId LONG,kaleoDefinitionName VARCHAR(200) null,kaleoDefinitionVersion INTEGER,rootKaleoInstanceTokenId LONG,className VARCHAR(200) null,classPK LONG,completed BOOLEAN,completionDate DATE null,workflowContext TEXT null)";
	public static final String TABLE_SQL_DROP = "drop table KaleoInstance";
	public static final String ORDER_BY_JPQL = " ORDER BY kaleoInstance.kaleoInstanceId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY KaleoInstance.kaleoInstanceId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.portal.workflow.kaleo.model.KaleoInstance"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.portal.workflow.kaleo.model.KaleoInstance"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.portal.workflow.kaleo.model.KaleoInstance"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long COMPLETED_COLUMN_BITMASK = 2L;
	public static long COMPLETIONDATE_COLUMN_BITMASK = 4L;
	public static long KALEODEFINITIONID_COLUMN_BITMASK = 8L;
	public static long KALEODEFINITIONNAME_COLUMN_BITMASK = 16L;
	public static long KALEODEFINITIONVERSION_COLUMN_BITMASK = 32L;
	public static long KALEOINSTANCEID_COLUMN_BITMASK = 64L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.portal.workflow.kaleo.model.KaleoInstance"));

	public KaleoInstanceModelImpl() {
	}


	public long getPrimaryKey() {
		return _kaleoInstanceId;
	}


	public void setPrimaryKey(long primaryKey) {
		setKaleoInstanceId(primaryKey);
	}


	public Serializable getPrimaryKeyObj() {
		return _kaleoInstanceId;
	}


	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}


	public Class<?> getModelClass() {
		return KaleoInstance.class;
	}


	public String getModelClassName() {
		return KaleoInstance.class.getName();
	}


	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("kaleoInstanceId", getKaleoInstanceId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("kaleoDefinitionId", getKaleoDefinitionId());
		attributes.put("kaleoDefinitionName", getKaleoDefinitionName());
		attributes.put("kaleoDefinitionVersion", getKaleoDefinitionVersion());
		attributes.put("rootKaleoInstanceTokenId", getRootKaleoInstanceTokenId());
		attributes.put("className", getClassName());
		attributes.put("classPK", getClassPK());
		attributes.put("completed", getCompleted());
		attributes.put("completionDate", getCompletionDate());
		attributes.put("workflowContext", getWorkflowContext());

		return attributes;
	}


	public void setModelAttributes(Map<String, Object> attributes) {
		Long kaleoInstanceId = (Long)attributes.get("kaleoInstanceId");

		if (kaleoInstanceId != null) {
			setKaleoInstanceId(kaleoInstanceId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long kaleoDefinitionId = (Long)attributes.get("kaleoDefinitionId");

		if (kaleoDefinitionId != null) {
			setKaleoDefinitionId(kaleoDefinitionId);
		}

		String kaleoDefinitionName = (String)attributes.get(
				"kaleoDefinitionName");

		if (kaleoDefinitionName != null) {
			setKaleoDefinitionName(kaleoDefinitionName);
		}

		Integer kaleoDefinitionVersion = (Integer)attributes.get(
				"kaleoDefinitionVersion");

		if (kaleoDefinitionVersion != null) {
			setKaleoDefinitionVersion(kaleoDefinitionVersion);
		}

		Long rootKaleoInstanceTokenId = (Long)attributes.get(
				"rootKaleoInstanceTokenId");

		if (rootKaleoInstanceTokenId != null) {
			setRootKaleoInstanceTokenId(rootKaleoInstanceTokenId);
		}

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		Boolean completed = (Boolean)attributes.get("completed");

		if (completed != null) {
			setCompleted(completed);
		}

		Date completionDate = (Date)attributes.get("completionDate");

		if (completionDate != null) {
			setCompletionDate(completionDate);
		}

		String workflowContext = (String)attributes.get("workflowContext");

		if (workflowContext != null) {
			setWorkflowContext(workflowContext);
		}
	}


	public long getKaleoInstanceId() {
		return _kaleoInstanceId;
	}


	public void setKaleoInstanceId(long kaleoInstanceId) {
		_columnBitmask = -1L;

		_kaleoInstanceId = kaleoInstanceId;
	}


	public long getGroupId() {
		return _groupId;
	}


	public void setGroupId(long groupId) {
		_groupId = groupId;
	}


	public long getCompanyId() {
		return _companyId;
	}


	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}


	public long getUserId() {
		return _userId;
	}


	public void setUserId(long userId) {
		_userId = userId;
	}


	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}


	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}


	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}


	public void setUserName(String userName) {
		_userName = userName;
	}


	public Date getCreateDate() {
		return _createDate;
	}


	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}


	public Date getModifiedDate() {
		return _modifiedDate;
	}


	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}


	public long getKaleoDefinitionId() {
		return _kaleoDefinitionId;
	}


	public void setKaleoDefinitionId(long kaleoDefinitionId) {
		_columnBitmask |= KALEODEFINITIONID_COLUMN_BITMASK;

		if (!_setOriginalKaleoDefinitionId) {
			_setOriginalKaleoDefinitionId = true;

			_originalKaleoDefinitionId = _kaleoDefinitionId;
		}

		_kaleoDefinitionId = kaleoDefinitionId;
	}

	public long getOriginalKaleoDefinitionId() {
		return _originalKaleoDefinitionId;
	}


	public String getKaleoDefinitionName() {
		if (_kaleoDefinitionName == null) {
			return StringPool.BLANK;
		}
		else {
			return _kaleoDefinitionName;
		}
	}


	public void setKaleoDefinitionName(String kaleoDefinitionName) {
		_columnBitmask |= KALEODEFINITIONNAME_COLUMN_BITMASK;

		if (_originalKaleoDefinitionName == null) {
			_originalKaleoDefinitionName = _kaleoDefinitionName;
		}

		_kaleoDefinitionName = kaleoDefinitionName;
	}

	public String getOriginalKaleoDefinitionName() {
		return GetterUtil.getString(_originalKaleoDefinitionName);
	}


	public int getKaleoDefinitionVersion() {
		return _kaleoDefinitionVersion;
	}


	public void setKaleoDefinitionVersion(int kaleoDefinitionVersion) {
		_columnBitmask |= KALEODEFINITIONVERSION_COLUMN_BITMASK;

		if (!_setOriginalKaleoDefinitionVersion) {
			_setOriginalKaleoDefinitionVersion = true;

			_originalKaleoDefinitionVersion = _kaleoDefinitionVersion;
		}

		_kaleoDefinitionVersion = kaleoDefinitionVersion;
	}

	public int getOriginalKaleoDefinitionVersion() {
		return _originalKaleoDefinitionVersion;
	}


	public long getRootKaleoInstanceTokenId() {
		return _rootKaleoInstanceTokenId;
	}


	public void setRootKaleoInstanceTokenId(long rootKaleoInstanceTokenId) {
		_rootKaleoInstanceTokenId = rootKaleoInstanceTokenId;
	}


	public String getClassName() {
		if (_className == null) {
			return StringPool.BLANK;
		}
		else {
			return _className;
		}
	}


	public void setClassName(String className) {
		_className = className;
	}


	public long getClassPK() {
		return _classPK;
	}


	public void setClassPK(long classPK) {
		_classPK = classPK;
	}


	public boolean getCompleted() {
		return _completed;
	}


	public boolean isCompleted() {
		return _completed;
	}


	public void setCompleted(boolean completed) {
		_columnBitmask |= COMPLETED_COLUMN_BITMASK;

		if (!_setOriginalCompleted) {
			_setOriginalCompleted = true;

			_originalCompleted = _completed;
		}

		_completed = completed;
	}

	public boolean getOriginalCompleted() {
		return _originalCompleted;
	}


	public Date getCompletionDate() {
		return _completionDate;
	}


	public void setCompletionDate(Date completionDate) {
		_columnBitmask |= COMPLETIONDATE_COLUMN_BITMASK;

		if (_originalCompletionDate == null) {
			_originalCompletionDate = _completionDate;
		}

		_completionDate = completionDate;
	}

	public Date getOriginalCompletionDate() {
		return _originalCompletionDate;
	}


	public String getWorkflowContext() {
		if (_workflowContext == null) {
			return StringPool.BLANK;
		}
		else {
			return _workflowContext;
		}
	}


	public void setWorkflowContext(String workflowContext) {
		_workflowContext = workflowContext;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}


	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			KaleoInstance.class.getName(), getPrimaryKey());
	}


	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}


	public KaleoInstance toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (KaleoInstance)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}


	public Object clone() {
		KaleoInstanceImpl kaleoInstanceImpl = new KaleoInstanceImpl();

		kaleoInstanceImpl.setKaleoInstanceId(getKaleoInstanceId());
		kaleoInstanceImpl.setGroupId(getGroupId());
		kaleoInstanceImpl.setCompanyId(getCompanyId());
		kaleoInstanceImpl.setUserId(getUserId());
		kaleoInstanceImpl.setUserName(getUserName());
		kaleoInstanceImpl.setCreateDate(getCreateDate());
		kaleoInstanceImpl.setModifiedDate(getModifiedDate());
		kaleoInstanceImpl.setKaleoDefinitionId(getKaleoDefinitionId());
		kaleoInstanceImpl.setKaleoDefinitionName(getKaleoDefinitionName());
		kaleoInstanceImpl.setKaleoDefinitionVersion(getKaleoDefinitionVersion());
		kaleoInstanceImpl.setRootKaleoInstanceTokenId(getRootKaleoInstanceTokenId());
		kaleoInstanceImpl.setClassName(getClassName());
		kaleoInstanceImpl.setClassPK(getClassPK());
		kaleoInstanceImpl.setCompleted(getCompleted());
		kaleoInstanceImpl.setCompletionDate(getCompletionDate());
		kaleoInstanceImpl.setWorkflowContext(getWorkflowContext());

		kaleoInstanceImpl.resetOriginalValues();

		return kaleoInstanceImpl;
	}


	public int compareTo(KaleoInstance kaleoInstance) {
		int value = 0;

		if (getKaleoInstanceId() < kaleoInstance.getKaleoInstanceId()) {
			value = -1;
		}
		else if (getKaleoInstanceId() > kaleoInstance.getKaleoInstanceId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}


	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof KaleoInstance)) {
			return false;
		}

		KaleoInstance kaleoInstance = (KaleoInstance)obj;

		long primaryKey = kaleoInstance.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}


	public int hashCode() {
		return (int)getPrimaryKey();
	}


	public void resetOriginalValues() {
		KaleoInstanceModelImpl kaleoInstanceModelImpl = this;

		kaleoInstanceModelImpl._originalCompanyId = kaleoInstanceModelImpl._companyId;

		kaleoInstanceModelImpl._setOriginalCompanyId = false;

		kaleoInstanceModelImpl._originalKaleoDefinitionId = kaleoInstanceModelImpl._kaleoDefinitionId;

		kaleoInstanceModelImpl._setOriginalKaleoDefinitionId = false;

		kaleoInstanceModelImpl._originalKaleoDefinitionName = kaleoInstanceModelImpl._kaleoDefinitionName;

		kaleoInstanceModelImpl._originalKaleoDefinitionVersion = kaleoInstanceModelImpl._kaleoDefinitionVersion;

		kaleoInstanceModelImpl._setOriginalKaleoDefinitionVersion = false;

		kaleoInstanceModelImpl._originalCompleted = kaleoInstanceModelImpl._completed;

		kaleoInstanceModelImpl._setOriginalCompleted = false;

		kaleoInstanceModelImpl._originalCompletionDate = kaleoInstanceModelImpl._completionDate;

		kaleoInstanceModelImpl._columnBitmask = 0;
	}


	public CacheModel<KaleoInstance> toCacheModel() {
		KaleoInstanceCacheModel kaleoInstanceCacheModel = new KaleoInstanceCacheModel();

		kaleoInstanceCacheModel.kaleoInstanceId = getKaleoInstanceId();

		kaleoInstanceCacheModel.groupId = getGroupId();

		kaleoInstanceCacheModel.companyId = getCompanyId();

		kaleoInstanceCacheModel.userId = getUserId();

		kaleoInstanceCacheModel.userName = getUserName();

		String userName = kaleoInstanceCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			kaleoInstanceCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			kaleoInstanceCacheModel.createDate = createDate.getTime();
		}
		else {
			kaleoInstanceCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			kaleoInstanceCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			kaleoInstanceCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		kaleoInstanceCacheModel.kaleoDefinitionId = getKaleoDefinitionId();

		kaleoInstanceCacheModel.kaleoDefinitionName = getKaleoDefinitionName();

		String kaleoDefinitionName = kaleoInstanceCacheModel.kaleoDefinitionName;

		if ((kaleoDefinitionName != null) &&
				(kaleoDefinitionName.length() == 0)) {
			kaleoInstanceCacheModel.kaleoDefinitionName = null;
		}

		kaleoInstanceCacheModel.kaleoDefinitionVersion = getKaleoDefinitionVersion();

		kaleoInstanceCacheModel.rootKaleoInstanceTokenId = getRootKaleoInstanceTokenId();

		kaleoInstanceCacheModel.className = getClassName();

		String className = kaleoInstanceCacheModel.className;

		if ((className != null) && (className.length() == 0)) {
			kaleoInstanceCacheModel.className = null;
		}

		kaleoInstanceCacheModel.classPK = getClassPK();

		kaleoInstanceCacheModel.completed = getCompleted();

		Date completionDate = getCompletionDate();

		if (completionDate != null) {
			kaleoInstanceCacheModel.completionDate = completionDate.getTime();
		}
		else {
			kaleoInstanceCacheModel.completionDate = Long.MIN_VALUE;
		}

		kaleoInstanceCacheModel.workflowContext = getWorkflowContext();

		String workflowContext = kaleoInstanceCacheModel.workflowContext;

		if ((workflowContext != null) && (workflowContext.length() == 0)) {
			kaleoInstanceCacheModel.workflowContext = null;
		}

		return kaleoInstanceCacheModel;
	}


	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{kaleoInstanceId=");
		sb.append(getKaleoInstanceId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", kaleoDefinitionId=");
		sb.append(getKaleoDefinitionId());
		sb.append(", kaleoDefinitionName=");
		sb.append(getKaleoDefinitionName());
		sb.append(", kaleoDefinitionVersion=");
		sb.append(getKaleoDefinitionVersion());
		sb.append(", rootKaleoInstanceTokenId=");
		sb.append(getRootKaleoInstanceTokenId());
		sb.append(", className=");
		sb.append(getClassName());
		sb.append(", classPK=");
		sb.append(getClassPK());
		sb.append(", completed=");
		sb.append(getCompleted());
		sb.append(", completionDate=");
		sb.append(getCompletionDate());
		sb.append(", workflowContext=");
		sb.append(getWorkflowContext());
		sb.append("}");

		return sb.toString();
	}


	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portal.workflow.kaleo.model.KaleoInstance");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>kaleoInstanceId</column-name><column-value><![CDATA[");
		sb.append(getKaleoInstanceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kaleoDefinitionId</column-name><column-value><![CDATA[");
		sb.append(getKaleoDefinitionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kaleoDefinitionName</column-name><column-value><![CDATA[");
		sb.append(getKaleoDefinitionName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kaleoDefinitionVersion</column-name><column-value><![CDATA[");
		sb.append(getKaleoDefinitionVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootKaleoInstanceTokenId</column-name><column-value><![CDATA[");
		sb.append(getRootKaleoInstanceTokenId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>className</column-name><column-value><![CDATA[");
		sb.append(getClassName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classPK</column-name><column-value><![CDATA[");
		sb.append(getClassPK());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>completed</column-name><column-value><![CDATA[");
		sb.append(getCompleted());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>completionDate</column-name><column-value><![CDATA[");
		sb.append(getCompletionDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>workflowContext</column-name><column-value><![CDATA[");
		sb.append(getWorkflowContext());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = KaleoInstance.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			KaleoInstance.class
		};
	private long _kaleoInstanceId;
	private long _groupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _kaleoDefinitionId;
	private long _originalKaleoDefinitionId;
	private boolean _setOriginalKaleoDefinitionId;
	private String _kaleoDefinitionName;
	private String _originalKaleoDefinitionName;
	private int _kaleoDefinitionVersion;
	private int _originalKaleoDefinitionVersion;
	private boolean _setOriginalKaleoDefinitionVersion;
	private long _rootKaleoInstanceTokenId;
	private String _className;
	private long _classPK;
	private boolean _completed;
	private boolean _originalCompleted;
	private boolean _setOriginalCompleted;
	private Date _completionDate;
	private Date _originalCompletionDate;
	private String _workflowContext;
	private long _columnBitmask;
	private KaleoInstance _escapedModel;
}