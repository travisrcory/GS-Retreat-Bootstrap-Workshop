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

package com.liferay.portal.workflow.kaleo.forms.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.workflow.kaleo.forms.service.ClpSerializer;
import com.liferay.portal.workflow.kaleo.forms.service.KaleoProcessLinkLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Marcellus Tavares
 */
public class KaleoProcessLinkClp extends BaseModelImpl<KaleoProcessLink>
	implements KaleoProcessLink {
	public KaleoProcessLinkClp() {
	}


	public Class<?> getModelClass() {
		return KaleoProcessLink.class;
	}


	public String getModelClassName() {
		return KaleoProcessLink.class.getName();
	}


	public long getPrimaryKey() {
		return _kaleoProcessLinkId;
	}


	public void setPrimaryKey(long primaryKey) {
		setKaleoProcessLinkId(primaryKey);
	}


	public Serializable getPrimaryKeyObj() {
		return _kaleoProcessLinkId;
	}


	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}


	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("kaleoProcessLinkId", getKaleoProcessLinkId());
		attributes.put("kaleoProcessId", getKaleoProcessId());
		attributes.put("workflowTaskName", getWorkflowTaskName());
		attributes.put("DDMTemplateId", getDDMTemplateId());

		return attributes;
	}


	public void setModelAttributes(Map<String, Object> attributes) {
		Long kaleoProcessLinkId = (Long)attributes.get("kaleoProcessLinkId");

		if (kaleoProcessLinkId != null) {
			setKaleoProcessLinkId(kaleoProcessLinkId);
		}

		Long kaleoProcessId = (Long)attributes.get("kaleoProcessId");

		if (kaleoProcessId != null) {
			setKaleoProcessId(kaleoProcessId);
		}

		String workflowTaskName = (String)attributes.get("workflowTaskName");

		if (workflowTaskName != null) {
			setWorkflowTaskName(workflowTaskName);
		}

		Long DDMTemplateId = (Long)attributes.get("DDMTemplateId");

		if (DDMTemplateId != null) {
			setDDMTemplateId(DDMTemplateId);
		}
	}


	public long getKaleoProcessLinkId() {
		return _kaleoProcessLinkId;
	}


	public void setKaleoProcessLinkId(long kaleoProcessLinkId) {
		_kaleoProcessLinkId = kaleoProcessLinkId;

		if (_kaleoProcessLinkRemoteModel != null) {
			try {
				Class<?> clazz = _kaleoProcessLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setKaleoProcessLinkId",
						long.class);

				method.invoke(_kaleoProcessLinkRemoteModel, kaleoProcessLinkId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}


	public long getKaleoProcessId() {
		return _kaleoProcessId;
	}


	public void setKaleoProcessId(long kaleoProcessId) {
		_kaleoProcessId = kaleoProcessId;

		if (_kaleoProcessLinkRemoteModel != null) {
			try {
				Class<?> clazz = _kaleoProcessLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setKaleoProcessId", long.class);

				method.invoke(_kaleoProcessLinkRemoteModel, kaleoProcessId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}


	public String getWorkflowTaskName() {
		return _workflowTaskName;
	}


	public void setWorkflowTaskName(String workflowTaskName) {
		_workflowTaskName = workflowTaskName;

		if (_kaleoProcessLinkRemoteModel != null) {
			try {
				Class<?> clazz = _kaleoProcessLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setWorkflowTaskName",
						String.class);

				method.invoke(_kaleoProcessLinkRemoteModel, workflowTaskName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}


	public long getDDMTemplateId() {
		return _DDMTemplateId;
	}


	public void setDDMTemplateId(long DDMTemplateId) {
		_DDMTemplateId = DDMTemplateId;

		if (_kaleoProcessLinkRemoteModel != null) {
			try {
				Class<?> clazz = _kaleoProcessLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setDDMTemplateId", long.class);

				method.invoke(_kaleoProcessLinkRemoteModel, DDMTemplateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}


	public com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess getKaleoProcess() {
		try {
			String methodName = "getKaleoProcess";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess returnObj =
				(com.liferay.portal.workflow.kaleo.forms.model.KaleoProcess)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getKaleoProcessLinkRemoteModel() {
		return _kaleoProcessLinkRemoteModel;
	}

	public void setKaleoProcessLinkRemoteModel(
		BaseModel<?> kaleoProcessLinkRemoteModel) {
		_kaleoProcessLinkRemoteModel = kaleoProcessLinkRemoteModel;
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

		Class<?> remoteModelClass = _kaleoProcessLinkRemoteModel.getClass();

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

		Object returnValue = method.invoke(_kaleoProcessLinkRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}


	public void persist() throws SystemException {
		if (this.isNew()) {
			KaleoProcessLinkLocalServiceUtil.addKaleoProcessLink(this);
		}
		else {
			KaleoProcessLinkLocalServiceUtil.updateKaleoProcessLink(this);
		}
	}


	public KaleoProcessLink toEscapedModel() {
		return (KaleoProcessLink)ProxyUtil.newProxyInstance(KaleoProcessLink.class.getClassLoader(),
			new Class[] { KaleoProcessLink.class },
			new AutoEscapeBeanHandler(this));
	}


	public Object clone() {
		KaleoProcessLinkClp clone = new KaleoProcessLinkClp();

		clone.setKaleoProcessLinkId(getKaleoProcessLinkId());
		clone.setKaleoProcessId(getKaleoProcessId());
		clone.setWorkflowTaskName(getWorkflowTaskName());
		clone.setDDMTemplateId(getDDMTemplateId());

		return clone;
	}


	public int compareTo(KaleoProcessLink kaleoProcessLink) {
		long primaryKey = kaleoProcessLink.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}


	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof KaleoProcessLinkClp)) {
			return false;
		}

		KaleoProcessLinkClp kaleoProcessLink = (KaleoProcessLinkClp)obj;

		long primaryKey = kaleoProcessLink.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{kaleoProcessLinkId=");
		sb.append(getKaleoProcessLinkId());
		sb.append(", kaleoProcessId=");
		sb.append(getKaleoProcessId());
		sb.append(", workflowTaskName=");
		sb.append(getWorkflowTaskName());
		sb.append(", DDMTemplateId=");
		sb.append(getDDMTemplateId());
		sb.append("}");

		return sb.toString();
	}


	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append(
			"com.liferay.portal.workflow.kaleo.forms.model.KaleoProcessLink");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>kaleoProcessLinkId</column-name><column-value><![CDATA[");
		sb.append(getKaleoProcessLinkId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kaleoProcessId</column-name><column-value><![CDATA[");
		sb.append(getKaleoProcessId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>workflowTaskName</column-name><column-value><![CDATA[");
		sb.append(getWorkflowTaskName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>DDMTemplateId</column-name><column-value><![CDATA[");
		sb.append(getDDMTemplateId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _kaleoProcessLinkId;
	private long _kaleoProcessId;
	private String _workflowTaskName;
	private long _DDMTemplateId;
	private BaseModel<?> _kaleoProcessLinkRemoteModel;
}