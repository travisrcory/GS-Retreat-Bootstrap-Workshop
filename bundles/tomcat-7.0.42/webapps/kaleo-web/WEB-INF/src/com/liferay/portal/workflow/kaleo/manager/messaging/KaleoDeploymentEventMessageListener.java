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

package com.liferay.portal.workflow.kaleo.manager.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.workflow.kaleo.manager.PortalKaleoManager;

/**
 * @author Michael C. Han
 */
public class KaleoDeploymentEventMessageListener extends BaseMessageListener {

	public void setPortalKaleoManager(PortalKaleoManager portalKaleoManager) {
		_portalKaleoManager = portalKaleoManager;
	}

	public void setServletContextName(String servletContextName) {
		_servletContextName = servletContextName;
	}


	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");

		if (!command.equals("deploy")) {
			return;
		}

		String servletContextName = (String)message.get("servletContextName");

		if (!_servletContextName.equals(servletContextName)) {
			return;
		}

		_portalKaleoManager.deployKaleoDefaults();
	}

	private PortalKaleoManager _portalKaleoManager;
	private String _servletContextName;

}