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

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the OAuthConsumer service. Represents a row in the &quot;OpenSocial_OAuthConsumer&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see OAuthConsumerModel
 * @see com.liferay.opensocial.model.impl.OAuthConsumerImpl
 * @see com.liferay.opensocial.model.impl.OAuthConsumerModelImpl
 * @generated
 */
public interface OAuthConsumer extends OAuthConsumerModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.opensocial.model.impl.OAuthConsumerImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public java.lang.String getKeyName();

	public void setKeyName(java.lang.String keyName);
}