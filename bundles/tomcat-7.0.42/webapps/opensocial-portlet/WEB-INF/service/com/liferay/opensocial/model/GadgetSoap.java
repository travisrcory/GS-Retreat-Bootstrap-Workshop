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

package com.liferay.opensocial.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.opensocial.service.http.GadgetServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.opensocial.service.http.GadgetServiceSoap
 * @generated
 */
public class GadgetSoap implements Serializable {
	public static GadgetSoap toSoapModel(Gadget model) {
		GadgetSoap soapModel = new GadgetSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setGadgetId(model.getGadgetId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setUrl(model.getUrl());
		soapModel.setPortletCategoryNames(model.getPortletCategoryNames());

		return soapModel;
	}

	public static GadgetSoap[] toSoapModels(Gadget[] models) {
		GadgetSoap[] soapModels = new GadgetSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GadgetSoap[][] toSoapModels(Gadget[][] models) {
		GadgetSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GadgetSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GadgetSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GadgetSoap[] toSoapModels(List<Gadget> models) {
		List<GadgetSoap> soapModels = new ArrayList<GadgetSoap>(models.size());

		for (Gadget model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GadgetSoap[soapModels.size()]);
	}

	public GadgetSoap() {
	}

	public long getPrimaryKey() {
		return _gadgetId;
	}

	public void setPrimaryKey(long pk) {
		setGadgetId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getGadgetId() {
		return _gadgetId;
	}

	public void setGadgetId(long gadgetId) {
		_gadgetId = gadgetId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
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

	public String getUrl() {
		return _url;
	}

	public void setUrl(String url) {
		_url = url;
	}

	public String getPortletCategoryNames() {
		return _portletCategoryNames;
	}

	public void setPortletCategoryNames(String portletCategoryNames) {
		_portletCategoryNames = portletCategoryNames;
	}

	private String _uuid;
	private long _gadgetId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _url;
	private String _portletCategoryNames;
}