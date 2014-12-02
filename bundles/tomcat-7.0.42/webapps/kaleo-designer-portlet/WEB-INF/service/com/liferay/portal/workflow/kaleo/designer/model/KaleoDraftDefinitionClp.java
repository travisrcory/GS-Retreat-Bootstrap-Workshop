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

package com.liferay.portal.workflow.kaleo.designer.model;

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.workflow.kaleo.designer.service.ClpSerializer;
import com.liferay.portal.workflow.kaleo.designer.service.KaleoDraftDefinitionLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Eduardo Lundgren
 */
public class KaleoDraftDefinitionClp extends BaseModelImpl<KaleoDraftDefinition>
	implements KaleoDraftDefinition {
	public KaleoDraftDefinitionClp() {
	}


	public Class<?> getModelClass() {
		return KaleoDraftDefinition.class;
	}


	public String getModelClassName() {
		return KaleoDraftDefinition.class.getName();
	}


	public long getPrimaryKey() {
		return _kaleoDraftDefinitionId;
	}


	public void setPrimaryKey(long primaryKey) {
		setKaleoDraftDefinitionId(primaryKey);
	}


	public Serializable getPrimaryKeyObj() {
		return _kaleoDraftDefinitionId;
	}


	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}


	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("kaleoDraftDefinitionId", getKaleoDraftDefinitionId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("title", getTitle());
		attributes.put("content", getContent());
		attributes.put("version", getVersion());
		attributes.put("draftVersion", getDraftVersion());

		return attributes;
	}


	public void setModelAttributes(Map<String, Object> attributes) {
		Long kaleoDraftDefinitionId = (Long)attributes.get(
				"kaleoDraftDefinitionId");

		if (kaleoDraftDefinitionId != null) {
			setKaleoDraftDefinitionId(kaleoDraftDefinitionId);
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

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		Integer version = (Integer)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		Integer draftVersion = (Integer)attributes.get("draftVersion");

		if (draftVersion != null) {
			setDraftVersion(draftVersion);
		}
	}


	public long getKaleoDraftDefinitionId() {
		return _kaleoDraftDefinitionId;
	}


	public void setKaleoDraftDefinitionId(long kaleoDraftDefinitionId) {
		_kaleoDraftDefinitionId = kaleoDraftDefinitionId;

		if (_kaleoDraftDefinitionRemoteModel != null) {
			try {
				Class<?> clazz = _kaleoDraftDefinitionRemoteModel.getClass();

				Method method = clazz.getMethod("setKaleoDraftDefinitionId",
						long.class);

				method.invoke(_kaleoDraftDefinitionRemoteModel,
					kaleoDraftDefinitionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}


	public long getGroupId() {
		return _groupId;
	}


	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_kaleoDraftDefinitionRemoteModel != null) {
			try {
				Class<?> clazz = _kaleoDraftDefinitionRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_kaleoDraftDefinitionRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}


	public long getCompanyId() {
		return _companyId;
	}


	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_kaleoDraftDefinitionRemoteModel != null) {
			try {
				Class<?> clazz = _kaleoDraftDefinitionRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_kaleoDraftDefinitionRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}


	public long getUserId() {
		return _userId;
	}


	public void setUserId(long userId) {
		_userId = userId;

		if (_kaleoDraftDefinitionRemoteModel != null) {
			try {
				Class<?> clazz = _kaleoDraftDefinitionRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_kaleoDraftDefinitionRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}


	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}


	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}


	public String getUserName() {
		return _userName;
	}


	public void setUserName(String userName) {
		_userName = userName;

		if (_kaleoDraftDefinitionRemoteModel != null) {
			try {
				Class<?> clazz = _kaleoDraftDefinitionRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_kaleoDraftDefinitionRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}


	public Date getCreateDate() {
		return _createDate;
	}


	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_kaleoDraftDefinitionRemoteModel != null) {
			try {
				Class<?> clazz = _kaleoDraftDefinitionRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_kaleoDraftDefinitionRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}


	public Date getModifiedDate() {
		return _modifiedDate;
	}


	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_kaleoDraftDefinitionRemoteModel != null) {
			try {
				Class<?> clazz = _kaleoDraftDefinitionRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_kaleoDraftDefinitionRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}


	public String getName() {
		return _name;
	}


	public void setName(String name) {
		_name = name;

		if (_kaleoDraftDefinitionRemoteModel != null) {
			try {
				Class<?> clazz = _kaleoDraftDefinitionRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_kaleoDraftDefinitionRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}


	public String getTitle() {
		return _title;
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


	public String getTitleCurrentValue() {
		Locale locale = getLocale(_titleCurrentLanguageId);

		return getTitle(locale);
	}


	public Map<Locale, String> getTitleMap() {
		return LocalizationUtil.getLocalizationMap(getTitle());
	}


	public void setTitle(String title) {
		_title = title;

		if (_kaleoDraftDefinitionRemoteModel != null) {
			try {
				Class<?> clazz = _kaleoDraftDefinitionRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_kaleoDraftDefinitionRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}


	public void setTitle(String title, Locale locale) {
		setTitle(title, locale, LocaleUtil.getDefault());
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
		setTitleMap(titleMap, LocaleUtil.getDefault());
	}


	public void setTitleMap(Map<Locale, String> titleMap, Locale defaultLocale) {
		if (titleMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setTitle(LocalizationUtil.updateLocalization(titleMap, getTitle(),
					"Title", LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}


	public String getContent() {
		return _content;
	}


	public void setContent(String content) {
		_content = content;

		if (_kaleoDraftDefinitionRemoteModel != null) {
			try {
				Class<?> clazz = _kaleoDraftDefinitionRemoteModel.getClass();

				Method method = clazz.getMethod("setContent", String.class);

				method.invoke(_kaleoDraftDefinitionRemoteModel, content);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}


	public int getVersion() {
		return _version;
	}


	public void setVersion(int version) {
		_version = version;

		if (_kaleoDraftDefinitionRemoteModel != null) {
			try {
				Class<?> clazz = _kaleoDraftDefinitionRemoteModel.getClass();

				Method method = clazz.getMethod("setVersion", int.class);

				method.invoke(_kaleoDraftDefinitionRemoteModel, version);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}


	public int getDraftVersion() {
		return _draftVersion;
	}


	public void setDraftVersion(int draftVersion) {
		_draftVersion = draftVersion;

		if (_kaleoDraftDefinitionRemoteModel != null) {
			try {
				Class<?> clazz = _kaleoDraftDefinitionRemoteModel.getClass();

				Method method = clazz.getMethod("setDraftVersion", int.class);

				method.invoke(_kaleoDraftDefinitionRemoteModel, draftVersion);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getKaleoDraftDefinitionRemoteModel() {
		return _kaleoDraftDefinitionRemoteModel;
	}

	public void setKaleoDraftDefinitionRemoteModel(
		BaseModel<?> kaleoDraftDefinitionRemoteModel) {
		_kaleoDraftDefinitionRemoteModel = kaleoDraftDefinitionRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _kaleoDraftDefinitionRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_kaleoDraftDefinitionRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}


	public void persist() throws SystemException {
		if (this.isNew()) {
			KaleoDraftDefinitionLocalServiceUtil.addKaleoDraftDefinition(this);
		}
		else {
			KaleoDraftDefinitionLocalServiceUtil.updateKaleoDraftDefinition(this);
		}
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


	public KaleoDraftDefinition toEscapedModel() {
		return (KaleoDraftDefinition)ProxyUtil.newProxyInstance(KaleoDraftDefinition.class.getClassLoader(),
			new Class[] { KaleoDraftDefinition.class },
			new AutoEscapeBeanHandler(this));
	}


	public Object clone() {
		KaleoDraftDefinitionClp clone = new KaleoDraftDefinitionClp();

		clone.setKaleoDraftDefinitionId(getKaleoDraftDefinitionId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setName(getName());
		clone.setTitle(getTitle());
		clone.setContent(getContent());
		clone.setVersion(getVersion());
		clone.setDraftVersion(getDraftVersion());

		return clone;
	}


	public int compareTo(KaleoDraftDefinition kaleoDraftDefinition) {
		int value = 0;

		if (getDraftVersion() < kaleoDraftDefinition.getDraftVersion()) {
			value = -1;
		}
		else if (getDraftVersion() > kaleoDraftDefinition.getDraftVersion()) {
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

		if (!(obj instanceof KaleoDraftDefinitionClp)) {
			return false;
		}

		KaleoDraftDefinitionClp kaleoDraftDefinition = (KaleoDraftDefinitionClp)obj;

		long primaryKey = kaleoDraftDefinition.getPrimaryKey();

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


	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{kaleoDraftDefinitionId=");
		sb.append(getKaleoDraftDefinitionId());
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
		sb.append(", content=");
		sb.append(getContent());
		sb.append(", version=");
		sb.append(getVersion());
		sb.append(", draftVersion=");
		sb.append(getDraftVersion());
		sb.append("}");

		return sb.toString();
	}


	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append(
			"com.liferay.portal.workflow.kaleo.designer.model.KaleoDraftDefinition");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>kaleoDraftDefinitionId</column-name><column-value><![CDATA[");
		sb.append(getKaleoDraftDefinitionId());
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
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>version</column-name><column-value><![CDATA[");
		sb.append(getVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>draftVersion</column-name><column-value><![CDATA[");
		sb.append(getDraftVersion());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _kaleoDraftDefinitionId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _title;
	private String _titleCurrentLanguageId;
	private String _content;
	private int _version;
	private int _draftVersion;
	private BaseModel<?> _kaleoDraftDefinitionRemoteModel;
}