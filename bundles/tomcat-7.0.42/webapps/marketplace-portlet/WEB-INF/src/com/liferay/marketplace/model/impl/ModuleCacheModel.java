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

package com.liferay.marketplace.model.impl;

import com.liferay.marketplace.model.Module;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Module in entity cache.
 *
 * @author Ryan Park
 * @see Module
 * @generated
 */
public class ModuleCacheModel implements CacheModel<Module>, Externalizable {

	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", moduleId=");
		sb.append(moduleId);
		sb.append(", appId=");
		sb.append(appId);
		sb.append(", contextName=");
		sb.append(contextName);
		sb.append("}");

		return sb.toString();
	}


	public Module toEntityModel() {
		ModuleImpl moduleImpl = new ModuleImpl();

		if (uuid == null) {
			moduleImpl.setUuid(StringPool.BLANK);
		}
		else {
			moduleImpl.setUuid(uuid);
		}

		moduleImpl.setModuleId(moduleId);
		moduleImpl.setAppId(appId);

		if (contextName == null) {
			moduleImpl.setContextName(StringPool.BLANK);
		}
		else {
			moduleImpl.setContextName(contextName);
		}

		moduleImpl.resetOriginalValues();

		return moduleImpl;
	}


	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		moduleId = objectInput.readLong();
		appId = objectInput.readLong();
		contextName = objectInput.readUTF();
	}


	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(moduleId);
		objectOutput.writeLong(appId);

		if (contextName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contextName);
		}
	}

	public String uuid;
	public long moduleId;
	public long appId;
	public String contextName;
}