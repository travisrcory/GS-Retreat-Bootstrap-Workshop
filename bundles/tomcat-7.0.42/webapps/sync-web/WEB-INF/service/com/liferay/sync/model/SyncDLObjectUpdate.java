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

package com.liferay.sync.model;

import com.liferay.portal.kernel.json.JSON;

import java.util.List;

/**
 * @author Michael Young
 */
@JSON
public class SyncDLObjectUpdate {

	public SyncDLObjectUpdate(
		List<SyncDLObject> syncDLObjects, long lastAccessTime) {

		_syncDLObjects = syncDLObjects;
		_lastAccessTime = lastAccessTime;
	}

	public long getLastAccessTime() {
		return _lastAccessTime;
	}

	@JSON
	public List<SyncDLObject> getSyncDLObjects() {
		return _syncDLObjects;
	}

	private long _lastAccessTime;
	private List<SyncDLObject> _syncDLObjects;

}