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
import com.liferay.portal.model.Group;

import java.util.List;

/**
 * @author Dennis Ju
 */
@JSON
public class SyncContext {

	public String getPluginVersion() {
		return _pluginVersion;
	}

	public int getPortalBuildNumber() {
		return _portalBuildNumber;
	}

	public String getPortalEELicenseDigest() {
		return _portalEELicenseDigest;
	}

	public String getSocialOfficeEELicenseDigest() {
		return _socialOfficeEELicenseDigest;
	}

	public long getUserId() {
		return _userId;
	}

	@JSON
	public List<Group> getUserSitesGroups() {
		return _userSitesGroups;
	}

	public boolean isSocialOfficeInstalled() {
		return _socialOfficeInstalled;
	}

	public void setPluginVersion(String pluginVersion) {
		_pluginVersion = pluginVersion;
	}

	public void setPortalBuildNumber(int portalBuildNumber) {
		_portalBuildNumber = portalBuildNumber;
	}

	public void setPortalEELicenseDigest(String portalEELicenseDigest) {
		_portalEELicenseDigest = portalEELicenseDigest;
	}

	public void setSocialOfficeEELicenseDigest(
		String socialOfficeEELicenseDigest) {

		_socialOfficeEELicenseDigest = socialOfficeEELicenseDigest;
	}

	public void setSocialOfficeInstalled(boolean socialOfficeInstalled) {
		_socialOfficeInstalled = socialOfficeInstalled;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public void setUserSitesGroups(List<Group> userSitesGroups) {
		_userSitesGroups = userSitesGroups;
	}

	private String _pluginVersion;
	private int _portalBuildNumber;
	private String _portalEELicenseDigest;
	private String _socialOfficeEELicenseDigest;
	private boolean _socialOfficeInstalled;
	private long _userId;
	private List<Group> _userSitesGroups;

}