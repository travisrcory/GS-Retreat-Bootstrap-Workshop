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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.portal.workflow.kaleo.designer.service.http.KaleoDraftDefinitionServiceSoap}.
 *
 * @author Eduardo Lundgren
 * @see com.liferay.portal.workflow.kaleo.designer.service.http.KaleoDraftDefinitionServiceSoap
 * @generated
 */
public class KaleoDraftDefinitionSoap implements Serializable {
	public static KaleoDraftDefinitionSoap toSoapModel(
		KaleoDraftDefinition model) {
		KaleoDraftDefinitionSoap soapModel = new KaleoDraftDefinitionSoap();

		soapModel.setKaleoDraftDefinitionId(model.getKaleoDraftDefinitionId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setTitle(model.getTitle());
		soapModel.setContent(model.getContent());
		soapModel.setVersion(model.getVersion());
		soapModel.setDraftVersion(model.getDraftVersion());

		return soapModel;
	}

	public static KaleoDraftDefinitionSoap[] toSoapModels(
		KaleoDraftDefinition[] models) {
		KaleoDraftDefinitionSoap[] soapModels = new KaleoDraftDefinitionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static KaleoDraftDefinitionSoap[][] toSoapModels(
		KaleoDraftDefinition[][] models) {
		KaleoDraftDefinitionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new KaleoDraftDefinitionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new KaleoDraftDefinitionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static KaleoDraftDefinitionSoap[] toSoapModels(
		List<KaleoDraftDefinition> models) {
		List<KaleoDraftDefinitionSoap> soapModels = new ArrayList<KaleoDraftDefinitionSoap>(models.size());

		for (KaleoDraftDefinition model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new KaleoDraftDefinitionSoap[soapModels.size()]);
	}

	public KaleoDraftDefinitionSoap() {
	}

	public long getPrimaryKey() {
		return _kaleoDraftDefinitionId;
	}

	public void setPrimaryKey(long pk) {
		setKaleoDraftDefinitionId(pk);
	}

	public long getKaleoDraftDefinitionId() {
		return _kaleoDraftDefinitionId;
	}

	public void setKaleoDraftDefinitionId(long kaleoDraftDefinitionId) {
		_kaleoDraftDefinitionId = kaleoDraftDefinitionId;
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

	public String getUserName() {
		return _userName;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public int getVersion() {
		return _version;
	}

	public void setVersion(int version) {
		_version = version;
	}

	public int getDraftVersion() {
		return _draftVersion;
	}

	public void setDraftVersion(int draftVersion) {
		_draftVersion = draftVersion;
	}

	private long _kaleoDraftDefinitionId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _title;
	private String _content;
	private int _version;
	private int _draftVersion;
}