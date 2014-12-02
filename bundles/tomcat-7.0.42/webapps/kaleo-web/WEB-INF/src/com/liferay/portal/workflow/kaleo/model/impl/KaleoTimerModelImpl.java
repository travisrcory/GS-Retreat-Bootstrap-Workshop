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
import com.liferay.portal.workflow.kaleo.model.KaleoTimer;
import com.liferay.portal.workflow.kaleo.model.KaleoTimerModel;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the KaleoTimer service. Represents a row in the &quot;KaleoTimer&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portal.workflow.kaleo.model.KaleoTimerModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link KaleoTimerImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KaleoTimerImpl
 * @see com.liferay.portal.workflow.kaleo.model.KaleoTimer
 * @see com.liferay.portal.workflow.kaleo.model.KaleoTimerModel
 * @generated
 */
public class KaleoTimerModelImpl extends BaseModelImpl<KaleoTimer>
	implements KaleoTimerModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a kaleo timer model instance should use the {@link com.liferay.portal.workflow.kaleo.model.KaleoTimer} interface instead.
	 */
	public static final String TABLE_NAME = "KaleoTimer";
	public static final Object[][] TABLE_COLUMNS = {
			{ "kaleoTimerId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "kaleoClassName", Types.VARCHAR },
			{ "kaleoClassPK", Types.BIGINT },
			{ "kaleoDefinitionId", Types.BIGINT },
			{ "name", Types.VARCHAR },
			{ "blocking", Types.BOOLEAN },
			{ "description", Types.VARCHAR },
			{ "duration", Types.DOUBLE },
			{ "scale", Types.VARCHAR },
			{ "recurrenceDuration", Types.DOUBLE },
			{ "recurrenceScale", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table KaleoTimer (kaleoTimerId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(200) null,createDate DATE null,modifiedDate DATE null,kaleoClassName VARCHAR(200) null,kaleoClassPK LONG,kaleoDefinitionId LONG,name VARCHAR(75) null,blocking BOOLEAN,description STRING null,duration DOUBLE,scale VARCHAR(75) null,recurrenceDuration DOUBLE,recurrenceScale VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table KaleoTimer";
	public static final String ORDER_BY_JPQL = " ORDER BY kaleoTimer.kaleoTimerId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY KaleoTimer.kaleoTimerId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.portal.workflow.kaleo.model.KaleoTimer"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.portal.workflow.kaleo.model.KaleoTimer"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.portal.workflow.kaleo.model.KaleoTimer"),
			true);
	public static long BLOCKING_COLUMN_BITMASK = 1L;
	public static long KALEOCLASSNAME_COLUMN_BITMASK = 2L;
	public static long KALEOCLASSPK_COLUMN_BITMASK = 4L;
	public static long KALEOTIMERID_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.portal.workflow.kaleo.model.KaleoTimer"));

	public KaleoTimerModelImpl() {
	}


	public long getPrimaryKey() {
		return _kaleoTimerId;
	}


	public void setPrimaryKey(long primaryKey) {
		setKaleoTimerId(primaryKey);
	}


	public Serializable getPrimaryKeyObj() {
		return _kaleoTimerId;
	}


	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}


	public Class<?> getModelClass() {
		return KaleoTimer.class;
	}


	public String getModelClassName() {
		return KaleoTimer.class.getName();
	}


	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("kaleoTimerId", getKaleoTimerId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("kaleoClassName", getKaleoClassName());
		attributes.put("kaleoClassPK", getKaleoClassPK());
		attributes.put("kaleoDefinitionId", getKaleoDefinitionId());
		attributes.put("name", getName());
		attributes.put("blocking", getBlocking());
		attributes.put("description", getDescription());
		attributes.put("duration", getDuration());
		attributes.put("scale", getScale());
		attributes.put("recurrenceDuration", getRecurrenceDuration());
		attributes.put("recurrenceScale", getRecurrenceScale());

		return attributes;
	}


	public void setModelAttributes(Map<String, Object> attributes) {
		Long kaleoTimerId = (Long)attributes.get("kaleoTimerId");

		if (kaleoTimerId != null) {
			setKaleoTimerId(kaleoTimerId);
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

		String kaleoClassName = (String)attributes.get("kaleoClassName");

		if (kaleoClassName != null) {
			setKaleoClassName(kaleoClassName);
		}

		Long kaleoClassPK = (Long)attributes.get("kaleoClassPK");

		if (kaleoClassPK != null) {
			setKaleoClassPK(kaleoClassPK);
		}

		Long kaleoDefinitionId = (Long)attributes.get("kaleoDefinitionId");

		if (kaleoDefinitionId != null) {
			setKaleoDefinitionId(kaleoDefinitionId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Boolean blocking = (Boolean)attributes.get("blocking");

		if (blocking != null) {
			setBlocking(blocking);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Double duration = (Double)attributes.get("duration");

		if (duration != null) {
			setDuration(duration);
		}

		String scale = (String)attributes.get("scale");

		if (scale != null) {
			setScale(scale);
		}

		Double recurrenceDuration = (Double)attributes.get("recurrenceDuration");

		if (recurrenceDuration != null) {
			setRecurrenceDuration(recurrenceDuration);
		}

		String recurrenceScale = (String)attributes.get("recurrenceScale");

		if (recurrenceScale != null) {
			setRecurrenceScale(recurrenceScale);
		}
	}


	public long getKaleoTimerId() {
		return _kaleoTimerId;
	}


	public void setKaleoTimerId(long kaleoTimerId) {
		_columnBitmask = -1L;

		_kaleoTimerId = kaleoTimerId;
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
		_companyId = companyId;
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


	public String getKaleoClassName() {
		if (_kaleoClassName == null) {
			return StringPool.BLANK;
		}
		else {
			return _kaleoClassName;
		}
	}


	public void setKaleoClassName(String kaleoClassName) {
		_columnBitmask |= KALEOCLASSNAME_COLUMN_BITMASK;

		if (_originalKaleoClassName == null) {
			_originalKaleoClassName = _kaleoClassName;
		}

		_kaleoClassName = kaleoClassName;
	}

	public String getOriginalKaleoClassName() {
		return GetterUtil.getString(_originalKaleoClassName);
	}


	public long getKaleoClassPK() {
		return _kaleoClassPK;
	}


	public void setKaleoClassPK(long kaleoClassPK) {
		_columnBitmask |= KALEOCLASSPK_COLUMN_BITMASK;

		if (!_setOriginalKaleoClassPK) {
			_setOriginalKaleoClassPK = true;

			_originalKaleoClassPK = _kaleoClassPK;
		}

		_kaleoClassPK = kaleoClassPK;
	}

	public long getOriginalKaleoClassPK() {
		return _originalKaleoClassPK;
	}


	public long getKaleoDefinitionId() {
		return _kaleoDefinitionId;
	}


	public void setKaleoDefinitionId(long kaleoDefinitionId) {
		_kaleoDefinitionId = kaleoDefinitionId;
	}


	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}


	public void setName(String name) {
		_name = name;
	}


	public boolean getBlocking() {
		return _blocking;
	}


	public boolean isBlocking() {
		return _blocking;
	}


	public void setBlocking(boolean blocking) {
		_columnBitmask |= BLOCKING_COLUMN_BITMASK;

		if (!_setOriginalBlocking) {
			_setOriginalBlocking = true;

			_originalBlocking = _blocking;
		}

		_blocking = blocking;
	}

	public boolean getOriginalBlocking() {
		return _originalBlocking;
	}


	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}


	public void setDescription(String description) {
		_description = description;
	}


	public double getDuration() {
		return _duration;
	}


	public void setDuration(double duration) {
		_duration = duration;
	}


	public String getScale() {
		if (_scale == null) {
			return StringPool.BLANK;
		}
		else {
			return _scale;
		}
	}


	public void setScale(String scale) {
		_scale = scale;
	}


	public double getRecurrenceDuration() {
		return _recurrenceDuration;
	}


	public void setRecurrenceDuration(double recurrenceDuration) {
		_recurrenceDuration = recurrenceDuration;
	}


	public String getRecurrenceScale() {
		if (_recurrenceScale == null) {
			return StringPool.BLANK;
		}
		else {
			return _recurrenceScale;
		}
	}


	public void setRecurrenceScale(String recurrenceScale) {
		_recurrenceScale = recurrenceScale;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}


	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			KaleoTimer.class.getName(), getPrimaryKey());
	}


	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}


	public KaleoTimer toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (KaleoTimer)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}


	public Object clone() {
		KaleoTimerImpl kaleoTimerImpl = new KaleoTimerImpl();

		kaleoTimerImpl.setKaleoTimerId(getKaleoTimerId());
		kaleoTimerImpl.setGroupId(getGroupId());
		kaleoTimerImpl.setCompanyId(getCompanyId());
		kaleoTimerImpl.setUserId(getUserId());
		kaleoTimerImpl.setUserName(getUserName());
		kaleoTimerImpl.setCreateDate(getCreateDate());
		kaleoTimerImpl.setModifiedDate(getModifiedDate());
		kaleoTimerImpl.setKaleoClassName(getKaleoClassName());
		kaleoTimerImpl.setKaleoClassPK(getKaleoClassPK());
		kaleoTimerImpl.setKaleoDefinitionId(getKaleoDefinitionId());
		kaleoTimerImpl.setName(getName());
		kaleoTimerImpl.setBlocking(getBlocking());
		kaleoTimerImpl.setDescription(getDescription());
		kaleoTimerImpl.setDuration(getDuration());
		kaleoTimerImpl.setScale(getScale());
		kaleoTimerImpl.setRecurrenceDuration(getRecurrenceDuration());
		kaleoTimerImpl.setRecurrenceScale(getRecurrenceScale());

		kaleoTimerImpl.resetOriginalValues();

		return kaleoTimerImpl;
	}


	public int compareTo(KaleoTimer kaleoTimer) {
		int value = 0;

		if (getKaleoTimerId() < kaleoTimer.getKaleoTimerId()) {
			value = -1;
		}
		else if (getKaleoTimerId() > kaleoTimer.getKaleoTimerId()) {
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

		if (!(obj instanceof KaleoTimer)) {
			return false;
		}

		KaleoTimer kaleoTimer = (KaleoTimer)obj;

		long primaryKey = kaleoTimer.getPrimaryKey();

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
		KaleoTimerModelImpl kaleoTimerModelImpl = this;

		kaleoTimerModelImpl._originalKaleoClassName = kaleoTimerModelImpl._kaleoClassName;

		kaleoTimerModelImpl._originalKaleoClassPK = kaleoTimerModelImpl._kaleoClassPK;

		kaleoTimerModelImpl._setOriginalKaleoClassPK = false;

		kaleoTimerModelImpl._originalBlocking = kaleoTimerModelImpl._blocking;

		kaleoTimerModelImpl._setOriginalBlocking = false;

		kaleoTimerModelImpl._columnBitmask = 0;
	}


	public CacheModel<KaleoTimer> toCacheModel() {
		KaleoTimerCacheModel kaleoTimerCacheModel = new KaleoTimerCacheModel();

		kaleoTimerCacheModel.kaleoTimerId = getKaleoTimerId();

		kaleoTimerCacheModel.groupId = getGroupId();

		kaleoTimerCacheModel.companyId = getCompanyId();

		kaleoTimerCacheModel.userId = getUserId();

		kaleoTimerCacheModel.userName = getUserName();

		String userName = kaleoTimerCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			kaleoTimerCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			kaleoTimerCacheModel.createDate = createDate.getTime();
		}
		else {
			kaleoTimerCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			kaleoTimerCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			kaleoTimerCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		kaleoTimerCacheModel.kaleoClassName = getKaleoClassName();

		String kaleoClassName = kaleoTimerCacheModel.kaleoClassName;

		if ((kaleoClassName != null) && (kaleoClassName.length() == 0)) {
			kaleoTimerCacheModel.kaleoClassName = null;
		}

		kaleoTimerCacheModel.kaleoClassPK = getKaleoClassPK();

		kaleoTimerCacheModel.kaleoDefinitionId = getKaleoDefinitionId();

		kaleoTimerCacheModel.name = getName();

		String name = kaleoTimerCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			kaleoTimerCacheModel.name = null;
		}

		kaleoTimerCacheModel.blocking = getBlocking();

		kaleoTimerCacheModel.description = getDescription();

		String description = kaleoTimerCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			kaleoTimerCacheModel.description = null;
		}

		kaleoTimerCacheModel.duration = getDuration();

		kaleoTimerCacheModel.scale = getScale();

		String scale = kaleoTimerCacheModel.scale;

		if ((scale != null) && (scale.length() == 0)) {
			kaleoTimerCacheModel.scale = null;
		}

		kaleoTimerCacheModel.recurrenceDuration = getRecurrenceDuration();

		kaleoTimerCacheModel.recurrenceScale = getRecurrenceScale();

		String recurrenceScale = kaleoTimerCacheModel.recurrenceScale;

		if ((recurrenceScale != null) && (recurrenceScale.length() == 0)) {
			kaleoTimerCacheModel.recurrenceScale = null;
		}

		return kaleoTimerCacheModel;
	}


	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{kaleoTimerId=");
		sb.append(getKaleoTimerId());
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
		sb.append(", kaleoClassName=");
		sb.append(getKaleoClassName());
		sb.append(", kaleoClassPK=");
		sb.append(getKaleoClassPK());
		sb.append(", kaleoDefinitionId=");
		sb.append(getKaleoDefinitionId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", blocking=");
		sb.append(getBlocking());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", duration=");
		sb.append(getDuration());
		sb.append(", scale=");
		sb.append(getScale());
		sb.append(", recurrenceDuration=");
		sb.append(getRecurrenceDuration());
		sb.append(", recurrenceScale=");
		sb.append(getRecurrenceScale());
		sb.append("}");

		return sb.toString();
	}


	public String toXmlString() {
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portal.workflow.kaleo.model.KaleoTimer");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>kaleoTimerId</column-name><column-value><![CDATA[");
		sb.append(getKaleoTimerId());
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
			"<column><column-name>kaleoClassName</column-name><column-value><![CDATA[");
		sb.append(getKaleoClassName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kaleoClassPK</column-name><column-value><![CDATA[");
		sb.append(getKaleoClassPK());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kaleoDefinitionId</column-name><column-value><![CDATA[");
		sb.append(getKaleoDefinitionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>blocking</column-name><column-value><![CDATA[");
		sb.append(getBlocking());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>duration</column-name><column-value><![CDATA[");
		sb.append(getDuration());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scale</column-name><column-value><![CDATA[");
		sb.append(getScale());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>recurrenceDuration</column-name><column-value><![CDATA[");
		sb.append(getRecurrenceDuration());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>recurrenceScale</column-name><column-value><![CDATA[");
		sb.append(getRecurrenceScale());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = KaleoTimer.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			KaleoTimer.class
		};
	private long _kaleoTimerId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _kaleoClassName;
	private String _originalKaleoClassName;
	private long _kaleoClassPK;
	private long _originalKaleoClassPK;
	private boolean _setOriginalKaleoClassPK;
	private long _kaleoDefinitionId;
	private String _name;
	private boolean _blocking;
	private boolean _originalBlocking;
	private boolean _setOriginalBlocking;
	private String _description;
	private double _duration;
	private String _scale;
	private double _recurrenceDuration;
	private String _recurrenceScale;
	private long _columnBitmask;
	private KaleoTimer _escapedModel;
}