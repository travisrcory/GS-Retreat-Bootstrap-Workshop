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

package com.liferay.opensocial.shindig.config;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import com.liferay.opensocial.shindig.util.ShindigUtil;
import com.liferay.portal.kernel.util.Validator;

import org.apache.shindig.config.ContainerConfigException;
import org.apache.shindig.config.JsonContainerConfig;
import org.apache.shindig.expressions.Expressions;

/**
 * @author Michael Young
 */
@Singleton
public class LiferayJsonContainerConfig extends JsonContainerConfig {

	@Inject
	public LiferayJsonContainerConfig(
			@Named("shindig.containers.default") String containers,
			Expressions expressions)
		throws ContainerConfigException {

		super(containers, null, null, expressions);
	}


	public String getString(String container, String property) {
		String value = super.getString(container, property);

		if (Validator.isNotNull(value)) {
			value = ShindigUtil.transformURL(value);
		}

		return value;
	}

}