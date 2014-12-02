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

package com.liferay.opensocial.service.impl;

import com.liferay.opensocial.model.OAuthToken;
import com.liferay.opensocial.service.base.OAuthTokenLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

import java.util.Date;
import java.util.List;

/**
 * @author Dennis Ju
 */
public class OAuthTokenLocalServiceImpl extends OAuthTokenLocalServiceBaseImpl {

	public OAuthToken addOAuthToken(
			long userId, String gadgetKey, String serviceName, long moduleId,
			String accessToken, String tokenName, String tokenSecret,
			String sessionHandle, long expiration)
		throws PortalException, SystemException {

		User user = UserLocalServiceUtil.getUser(userId);
		Date now = new Date();

		long oAuthTokenId = counterLocalService.increment();

		OAuthToken oAuthToken = oAuthTokenPersistence.create(oAuthTokenId);

		oAuthToken.setCompanyId(user.getCompanyId());
		oAuthToken.setUserId(user.getUserId());
		oAuthToken.setUserName(user.getFullName());
		oAuthToken.setCreateDate(now);
		oAuthToken.setModifiedDate(now);
		oAuthToken.setGadgetKey(gadgetKey);
		oAuthToken.setServiceName(serviceName);
		oAuthToken.setModuleId(moduleId);
		oAuthToken.setAccessToken(accessToken);
		oAuthToken.setTokenName(tokenName);
		oAuthToken.setTokenSecret(tokenSecret);
		oAuthToken.setSessionHandle(sessionHandle);
		oAuthToken.setExpiration(expiration);

		oAuthTokenPersistence.update(oAuthToken);

		return oAuthToken;
	}

	public void deleteOAuthToken(
			long userId, String gadgetKey, String serviceName, long moduleId,
			String tokenName)
		throws PortalException, SystemException {

		oAuthTokenPersistence.removeByU_G_S_M_T(
			userId, gadgetKey, serviceName, moduleId, tokenName);
	}

	public void deleteOAuthTokens(String gadgetKey, String serviceName)
		throws SystemException {

		oAuthTokenPersistence.removeByG_S(gadgetKey, serviceName);
	}

	public OAuthToken fetchOAuthToken(
			long userId, String gadgetKey, String serviceName, long moduleId,
			String tokenName)
		throws SystemException {

		return oAuthTokenPersistence.fetchByU_G_S_M_T(
			userId, gadgetKey, serviceName, moduleId, tokenName);
	}

	public OAuthToken getOAuthToken(
			long userId, String gadgetKey, String serviceName, long moduleId,
			String tokenName)
		throws PortalException, SystemException {

		return oAuthTokenPersistence.findByU_G_S_M_T(
			userId, gadgetKey, serviceName, moduleId, tokenName);
	}

	public List<OAuthToken> getOAuthTokens(String gadgetKey, String serviceName)
		throws SystemException {

		return oAuthTokenPersistence.findByG_S(gadgetKey, serviceName);
	}

}