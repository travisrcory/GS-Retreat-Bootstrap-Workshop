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

package com.liferay.notifications.dockbarnotifications.poller;

import com.liferay.portal.kernel.poller.BasePollerProcessor;
import com.liferay.portal.kernel.poller.PollerRequest;
import com.liferay.portal.kernel.poller.PollerResponse;
import com.liferay.portal.service.UserNotificationEventLocalServiceUtil;

/**
 * @author Jonathan Lee
 */
public class DockbarNotificationsPollerProcessor extends BasePollerProcessor {


	protected void doReceive(
			PollerRequest pollerRequest, PollerResponse pollerResponse)
		throws Exception {

		setUserNotificationsCount(pollerRequest, pollerResponse);
	}


	protected void doSend(PollerRequest pollerRequest) throws Exception {
	}

	protected void setUserNotificationsCount(
			PollerRequest pollerRequest, PollerResponse pollerResponse)
		throws Exception {

		int newUserNotificationsCount =
			UserNotificationEventLocalServiceUtil.
				getDeliveredUserNotificationEventsCount(
					pollerRequest.getUserId(), false);

		pollerResponse.setParameter(
			"newUserNotificationsCount",
			String.valueOf(newUserNotificationsCount));

		int unreadUserNotificationsCount =
			UserNotificationEventLocalServiceUtil.
				getArchivedUserNotificationEventsCount(
					pollerRequest.getUserId(), false);

		pollerResponse.setParameter(
			"unreadUserNotificationsCount",
			String.valueOf(unreadUserNotificationsCount));
	}

}