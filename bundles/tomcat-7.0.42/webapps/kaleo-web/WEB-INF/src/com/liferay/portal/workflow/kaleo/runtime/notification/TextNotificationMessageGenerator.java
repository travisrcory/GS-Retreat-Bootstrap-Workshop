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

package com.liferay.portal.workflow.kaleo.runtime.notification;

import com.liferay.portal.workflow.kaleo.runtime.ExecutionContext;

/**
 * @author Michael C. Han
 */
public class TextNotificationMessageGenerator
	implements NotificationMessageGenerator {


	public String generateMessage(
		String kaleoClassName, long kaleoClassPK, String notificationName,
		String notificationTemplateLanguage, String notificationTemplate,
		ExecutionContext executionContext) {

		return notificationTemplate;
	}

}