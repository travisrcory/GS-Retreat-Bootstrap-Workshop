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

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

import com.liferay.opensocial.model.OAuthConsumer;
import com.liferay.opensocial.model.OAuthConsumerConstants;
import com.liferay.opensocial.model.impl.OAuthConsumerImpl;
import com.liferay.opensocial.util.PortletPropsValues;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;

import org.apache.shindig.gadgets.oauth.OAuthStore;

/**
 * @author Dennis Ju
 */
@Singleton
public class LiferayOAuthStoreProvider implements Provider<OAuthStore> {

	@Inject
	public LiferayOAuthStoreProvider() {
		OAuthConsumer oAuthConsumer = _getOAuthConsumer(
			PortletPropsValues.SHINDIG_OAUTH_KEY_FILE_NAME,
			PortletPropsValues.SHINDIG_OAUTH_KEY_NAME);

		_oAuthStore = new LiferayOAuthStore(oAuthConsumer);
	}

	public OAuthStore get() {
		return _oAuthStore;
	}

	private String _convertFromOpenSsl(String key) {
		key = key.replaceAll(_OPEN_SSL_A_Z, StringPool.BLANK);
		key = key.replace(StringPool.NEW_LINE, StringPool.BLANK);

		return key;
	}

	private OAuthConsumer _getOAuthConsumer(
		String keyFileName, String keyName) {

		OAuthConsumer oAuthConsumer = new OAuthConsumerImpl();

		oAuthConsumer.setConsumerKey(_DEFAULT_CONSUMER_KEY);
		oAuthConsumer.setServiceName(_DEFAULT_SERVICE_NAME);

		String consumerSecret = null;

		String path = PropsUtil.get(PropsKeys.LIFERAY_HOME).concat(_KEY_DIR);

		path = path.replaceAll(StringPool.QUOTE, StringPool.BLANK);

		keyFileName = path.concat(keyFileName);

		try {
			consumerSecret = FileUtil.read(keyFileName);
		}
		catch (Exception e) {
		}
		finally {
			if (consumerSecret == null) {
				if (!FileUtil.exists(path)) {
					FileUtil.mkdirs(path);
				}

				if (_log.isWarnEnabled()) {
					_log.warn("Unable to load OAuth key from " + keyFileName);
				}

				return null;
			}
		}

		consumerSecret = _convertFromOpenSsl(consumerSecret);

		oAuthConsumer.setConsumerSecret(consumerSecret);
		oAuthConsumer.setKeyType(OAuthConsumerConstants.KEY_TYPE_RSA_PRIVATE);
		oAuthConsumer.setKeyName(keyName);

		return oAuthConsumer;
	}

	private static final String _DEFAULT_CONSUMER_KEY = "DEFAULT_CONSUMER_KEY";

	private static final String _DEFAULT_SERVICE_NAME = "LIFERAY";

	private static final String _KEY_DIR = "/data/opensocial/";

	private static final String _OPEN_SSL_A_Z = "-----[A-Z ]*-----";

	private static Log _log = LogFactoryUtil.getLog(
		LiferayOAuthStoreProvider.class);

	private final OAuthStore _oAuthStore;

}