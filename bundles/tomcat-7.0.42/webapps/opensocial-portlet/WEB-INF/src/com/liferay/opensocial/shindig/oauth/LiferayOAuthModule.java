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

package com.liferay.opensocial.shindig.oauth;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

import org.apache.shindig.common.crypto.BlobCrypter;
import org.apache.shindig.gadgets.oauth.OAuthFetcherConfig;
import org.apache.shindig.gadgets.oauth.OAuthModule.OAuthCrypterProvider;
import org.apache.shindig.gadgets.oauth.OAuthModule.OAuthRequestProvider;
import org.apache.shindig.gadgets.oauth.OAuthRequest;
import org.apache.shindig.gadgets.oauth.OAuthStore;

/**
 * @author Dennis Ju
 */
public class LiferayOAuthModule extends AbstractModule {


	protected void configure() {
		bind(BlobCrypter.class).annotatedWith(
			Names.named(OAuthFetcherConfig.OAUTH_STATE_CRYPTER)).toProvider(
				OAuthCrypterProvider.class);
		bind(OAuthRequest.class).toProvider(OAuthRequestProvider.class);
		bind(OAuthStore.class).toProvider(LiferayOAuthStoreProvider.class);
	}

}