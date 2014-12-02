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

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.workflow.kaleo.model.KaleoDefinition;
import com.liferay.portal.workflow.kaleo.model.KaleoDefinitionModel;
import com.liferay.portal.workflow.kaleo.model.KaleoDefinitionSoap;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * The base model implementation for the KaleoDefinition service. Represents a row in the &quot;KaleoDefinition&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portal.workflow.kaleo.model.KaleoDefinitionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link KaleoDefinitionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KaleoDefinitionImpl
 * @see com.liferay.portal.workflow.kaleo.model.KaleoDefinition
 * @see com.liferay.portal.workflow.kaleo.model.KaleoDefinitionModel
 * @generated
 */
@JSON(strict = true)
public class KaleoDefinitionModelImpl extends BaseModelImpl<KaleoDefinition>
	implements KaleoDefinitionModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a kaleo definition model instance should use the {@link com.liferay.portal.workflow.kaleo.model.KaleoDefinition} interface instead.
	 */
	public static final String TABLE_NAME = "KaleoDefinition";
	public static final Object[][] TABLE_COLUMNS = {
			{ "kaleoDefinitionId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "name", Types.VARCHAR },
			{ "title", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "content", Types.CLOB },
			{ "version", Types.INTEGER },
			{ "active_", Types.BOOLEAN },
			{ "startKaleoNodeId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table KaleoDefinition (kaleoDefinitionId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(200) null,createDate DATE null,modifiedDate DATE null,name VARCHAR(200) null,title STRING null,description STRING null,content TEXT null,version INTEGER,active_ BOOLEAN,startKaleoNodeId LONG)";
	public static final String TABLE_SQL_DROP = "drop table KaleoDefinition";
	public static final String ORDER_BY_JPQL = " ORDER BY kaleoDefinition.version DESC";
	public static final String ORDER_BY_SQL = " ORDER BY KaleoDefinition.version DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.portal.workflow.kaleo.model.KaleoDefinition"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.portal.workflow.kaleo.model.KaleoDefinition"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.portal.workflow.kaleo.model.KaleoDefinition"),
			true);
	public static long ACTIVE_COLUMN_BITMASK = 1L;
	public static long COMPANYID_COLUMN_BITMASK = 2L;
	public static long NAME_COLUMN_BITMASK = 4L;
	public static long VERSION_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static KaleoDefinition toModel(KaleoDefinitionSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		KaleoDefinition model = new KaleoDefinitionImpl();

		model.setKaleoDefinitionId(soapModel.getKaleoDefinitionId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setName(soapModel.getName());
		model.setTitle(soapModel.getTitle());
		model.setDescription(soapModel.getDescription());
		model.setContent(soapModel.getContent());
		model.setVersion(soapModel.getVersion());
		model.setActive(soapModel.getActive());
		model.setStartKaleoNodeId(soapModel.getStartKaleoNodeId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<KaleoDefinition> toModels(
		KaleoDefinitionSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<KaleoDefinition> models = new ArrayList<KaleoDefinition>(soapModels.length);

		for (KaleoDefinitionSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.portal.workflow.kaleo.model.KaleoDefinition"));

	public KaleoDefinitionModelImpl() {
	}


	public long getPrimaryKey() {
		return _kaleoDefinitionId;
	}


	public void setPrimaryKey(long primaryKey) {
		setKaleoDefinitionId(primaryKey);
	}


	public Serializable getPrimaryKeyObj() {
		return _kaleoDefinitionId;
	}


	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}


	public Class<?> getModelClass() {
		return KaleoDefinition.class;
	}


	public String getModelClassName() {
		return KaleoDefinition.class.getName();
	}


	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("kaleoDefinitionId", getKaleoDefinitionId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("content", getContent());
		attributes.put("version", getVersion());
		attributes.put("active", getActive());
		attributes.put("startKaleoNodeId", getStartKaleoNodeId());

		return attributes;
	}


	public void setModelAttributes(Map<String, Object> attributes) {
		Long kaleoDefinitionId = (Long)attributes.get("kaleoDefinitionId");

		if (kaleoDefinitionId != null) {
			setKaleoDefinitionId(kaleoDefinitionId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		Integer version = (Integer)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		Long startKaleoNodeId = (Long)attributes.get("startKaleoNodeId");

		if (startKaleoNodeId != null) {
			setStartKaleoNodeId(startKaleoNodeId);
		}
	}

	@JSON

	public long getKaleoDefinitionId() {
		return _kaleoDefinitionId;
	}


	public void setKaleoDefinitionId(long kaleoDefinitionId) {
		_kaleoDefinitionId = kaleoDefinitionId;
	}

	@JSON

	public long getGroupId() {
		return _groupId;
	}


	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@JSON

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

	@JSON

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

	@JSON

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

	@JSON

	public Date getCreateDate() {
		return _createDate;
	}


	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON

	public Date getModifiedDate() {
		return _modifiedDate;
	}


	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON

	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}


	public void setName(String name) {
		_columnBitmask |= NAME_COLUMN_BITMASK;

		if (_originalName == null) {
			_originalName = _name;
		}

		_name = name;
	}

	public String getOriginalName() {
		return GetterUtil.getString(_originalName);
	}

	@JSON

	public String getTitle() {
		if (_title == null) {
			return StringPool.BLANK;
		}
		else {
			return _title;
		}
	}


	public String getTitle(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getTitle(languageId);
	}


	public String getTitle(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getTitle(languageId, useDefault);
	}


	public String getTitle(String languageId) {
		return LocalizationUtil.getLocalization(getTitle(), languageId);
	}


	public String getTitle(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getTitle(), languageId,
			useDefault);
	}


	public String getTitleCurrentLanguageId() {
		return _titleCurrentLanguageId;
	}

	@JSON

	public String getTitleCurrentValue() {
		Locale locale = getLocale(_titleCurrentLanguageId);

		return getTitle(locale);
	}


	public Map<Locale, String> getTitleMap() {
		return LocalizationUtil.getLocalizationMap(getTitle());
	}


	public void setTitle(String title) {
		_title = title;
	}


	public void setTitle(String title, Locale locale) {
		setTitle(title, locale, LocaleUtil.getSiteDefault());
	}


	public void setTitle(String title, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(title)) {
			setTitle(LocalizationUtil.updateLocalization(getTitle(), "Title",
					title, languageId, defaultLanguageId));
		}
		else {
			setTitle(LocalizationUtil.removeLocalization(getTitle(), "Title",
					languageId));
		}
	}


	public void setTitleCurrentLanguageId(String languageId) {
		_titleCurrentLanguageId = languageId;
	}


	public void setTitleMap(Map<Locale, String> titleMap) {
		setTitleMap(titleMap, LocaleUtil.getSiteDefault());
	}


	public void setTitleMap(Map<Locale, String> titleMap, Locale defaultLocale) {
		if (titleMap == null) {
			return;
		}

		setTitle(LocalizationUtil.updateLocalization(titleMap, getTitle(),
				"Title", LocaleUtil.toLanguageId(defaultLocale)));
	}

	@JSON

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

	@JSON

	public String getContent() {
		if (_content == null) {
			return StringPool.BLANK;
		}
		else {
			return _content;
		}
	}


	public void setContent(String content) {
		_content = content;
	}

	@JSON

	public int getVersion() {
		return _version;
	}


	public void setVersion(int version) {
		_columnBitmask = -1L;

		if (!_setOriginalVersion) {
			_setOriginalVersion = true;

			_originalVersion = _version;
		}

		_version = version;
	}

	public int getOriginalVersion() {
		return _originalVersion;
	}

	@JSON

	public boolean getActive() {
		return _active;
	}


	public boolean isActive() {
		return _active;
	}


	public void setActive(boolean active) {
		_columnBitmask |= ACTIVE_COLUMN_BITMASK;

		if (!_setOriginalActive) {
			_setOriginalActive = true;

			_originalActive = _active;
		}

		_active = active;
	}

	public boolean getOriginalActive() {
		return _originalActive;
	}

	@JSON

	public long getStartKaleoNodeId() {
		return _startKaleoNodeId;
	}


	public void setStartKaleoNodeId(long startKaleoNodeId) {
		_startKaleoNodeId = startKaleoNodeId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}


	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			KaleoDefinition.class.getName(), getPrimaryKey());
	}


	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}


	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> titleMap = getTitleMap();

		for (Map.Entry<Locale, String> entry : titleMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		return availableLanguageIds.toArray(new String[availableLanguageIds.size()]);
	}


	public String getDefaultLanguageId() {
		String xml = getTitle();

		if (xml == null) {
			return StringPool.BLANK;
		}

		return LocalizationUtil.getDefaultLanguageId(xml);
	}


	public void prepareLocalizedFieldsForImport() throws LocaleException {
		prepareLocalizedFieldsForImport(null);
	}


	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {
		Locale defaultLocale = LocaleUtil.getDefault();

		String modelDefaultLanguageId = getDefaultLanguageId();

		String title = getTitle(defaultLocale);

		if (Validator.isNull(title)) {
			setTitle(getTitle(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setTitle(getTitle(defaultLocale), defaultLocale, defaultLocale);
		}
	}


	public KaleoDefinition toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (KaleoDefinition)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}


	public Object clone() {
		KaleoDefinitionImpl kaleoDefinitionImpl = new KaleoDefinitionImpl();

		kaleoDefinitionImpl.setKaleoDefinitionId(getKaleoDefinitionId());
		kaleoDefinitionImpl.setGroupId(getGroupId());
		kaleoDefinitionImpl.setCompanyId(getCompanyId());
		kaleoDefinitionImpl.setUserId(getUserId());
		kaleoDefinitionImpl.setUserName(getUserName());
		kaleoDefinitionImpl.setCreateDate(getCreateDate());
		kaleoDefinitionImpl.setModifiedDate(getModifiedDate());
		kaleoDefinitionImpl.setName(getName());
		kaleoDefinitionImpl.setTitle(getTitle());
		kaleoDefinitionImpl.setDescription(getDescription());
		kaleoDefinitionImpl.setContent(getContent());
		kaleoDefinitionImpl.setVersion(getVersion());
		kaleoDefinitionImpl.setActive(getActive());
		kaleoDefinitionImpl.setStartKaleoNodeId(getStartKaleoNodeId());

		kaleoDefinitionImpl.resetOriginalValues();

		return kaleoDefinitionImpl;
	}


	public int compareTo(KaleoDefinition kaleoDefinition) {
		int value = 0;

		if (getVersion() < kaleoDefinition.getVersion()) {
			value = -1;
		}
		else if (getVersion() > kaleoDefinition.getVersion()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}


	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof KaleoDefinition)) {
			return false;
		}

		KaleoDefinition kaleoDefinition = (KaleoDefinition)obj;

		long primaryKey = kaleoDefinition.getPrimaryKey();

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
		KaleoDefinitionModelImpl kaleoDefinitionModelImpl = this;

		kaleoDefinitionModelImpl._originalCompanyId = kaleoDefinitionModelImpl._companyId;

		kaleoDefinitionModelImpl._setOriginalCompanyId = false;

		kaleoDefinitionModelImpl._originalName = kaleoDefinitionModelImpl._name;

		kaleoDefinitionModelImpl._originalVersion = kaleoDefinitionModelImpl._version;

		kaleoDefinitionModelImpl._setOriginalVersion = false;

		kaleoDefinitionModelImpl._originalActive = kaleoDefinitionModelImpl._active;

		kaleoDefinitionModelImpl._setOriginalActive = false;

		kaleoDefinitionModelImpl._columnBitmask = 0;
	}


	public CacheModel<KaleoDefinition> toCacheModel() {
		KaleoDefinitionCacheModel kaleoDefinitionCacheModel = new KaleoDefinitionCacheModel();

		kaleoDefinitionCacheModel.kaleoDefinitionId = getKaleoDefinitionId();

		kaleoDefinitionCacheModel.groupId = getGroupId();

		kaleoDefinitionCacheModel.companyId = getCompanyId();

		kaleoDefinitionCacheModel.userId = getUserId();

		kaleoDefinitionCacheModel.userName = getUserName();

		String userName = kaleoDefinitionCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			kaleoDefinitionCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			kaleoDefinitionCacheModel.createDate = createDate.getTime();
		}
		else {
			kaleoDefinitionCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			kaleoDefinitionCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			kaleoDefinitionCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		kaleoDefinitionCacheModel.name = getName();

		String name = kaleoDefinitionCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			kaleoDefinitionCacheModel.name = null;
		}

		kaleoDefinitionCacheModel.title = getTitle();

		String title = kaleoDefinitionCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			kaleoDefinitionCacheModel.title = null;
		}

		kaleoDefinitionCacheModel.description = getDescription();

		String description = kaleoDefinitionCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			kaleoDefinitionCacheModel.description = null;
		}

		kaleoDefinitionCacheModel.content = getContent();

		String content = kaleoDefinitionCacheModel.content;

		if ((content != null) && (content.length() == 0)) {
			kaleoDefinitionCacheModel.content = null;
		}

		kaleoDefinitionCacheModel.version = getVersion();

		kaleoDefinitionCacheModel.active = getActive();

		kaleoDefinitionCacheModel.startKaleoNodeId = getStartKaleoNodeId();

		return kaleoDefinitionCacheModel;
	}


	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{kaleoDefinitionId=");
		sb.append(getKaleoDefinitionId());
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
		sb.append(", name=");
		sb.append(getName());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", content=");
		sb.append(getContent());
		sb.append(", version=");
		sb.append(getVersion());
		sb.append(", active=");
		sb.append(getActive());
		sb.append(", startKaleoNodeId=");
		sb.append(getStartKaleoNodeId());
		sb.append("}");

		return sb.toString();
	}


	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portal.workflow.kaleo.model.KaleoDefinition");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>kaleoDefinitionId</column-name><column-value><![CDATA[");
		sb.append(getKaleoDefinitionId());
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
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>version</column-name><column-value><![CDATA[");
		sb.append(getVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startKaleoNodeId</column-name><column-value><![CDATA[");
		sb.append(getStartKaleoNodeId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = KaleoDefinition.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			KaleoDefinition.class
		};
	private long _kaleoDefinitionId;
	private long _groupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _originalName;
	private String _title;
	private String _titleCurrentLanguageId;
	private String _description;
	private String _content;
	private int _version;
	private int _originalVersion;
	private boolean _setOriginalVersion;
	private boolean _active;
	private boolean _originalActive;
	private boolean _setOriginalActive;
	private long _startKaleoNodeId;
	private long _columnBitmask;
	private KaleoDefinition _escapedModel;
}