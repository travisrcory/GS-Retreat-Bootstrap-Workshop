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

package com.liferay.portal.workflow.kaleo.definition;

import com.liferay.portal.kernel.util.Validator;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Michael C. Han
 */
public class Notification {

	public Notification(
		String name, String description, String executionType, String template,
		String templateLanguage) {

		_name = name;
		_description = description;

		if (Validator.isNotNull(executionType)) {
			_executionType = ExecutionType.parse(executionType);
		}
		else {
			_executionType = ExecutionType.ON_TIMER;
		}

		_template = template;
		_templateLanguage = TemplateLanguage.parse(templateLanguage);
	}

	public void addNotificationType(String notificationType) {
		_notificationTypes.add(NotificationType.parse(notificationType));
	}

	public void addRecipients(Recipient recipient) {
		_recipients.add(recipient);
	}


	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Notification)) {
			return false;
		}

		Notification notification = (Notification)obj;

		if (Validator.equals(_name, notification._name)) {
			return true;
		}

		return true;
	}

	public String getDescription() {
		return _description;
	}

	public ExecutionType getExecutionType() {
		return _executionType;
	}

	public String getName() {
		return _name;
	}

	public Set<NotificationType> getNotificationTypes() {
		return _notificationTypes;
	}

	public Set<Recipient> getRecipients() {
		return _recipients;
	}

	public String getTemplate() {
		return _template;
	}

	public TemplateLanguage getTemplateLanguage() {
		return _templateLanguage;
	}


	public int hashCode() {
		return _name.hashCode();
	}

	private String _description;
	private ExecutionType _executionType;
	private String _name;
	private Set<NotificationType> _notificationTypes =
		new HashSet<NotificationType>();
	private Set<Recipient> _recipients = new HashSet<Recipient>();
	private String _template;
	private TemplateLanguage _templateLanguage;

}