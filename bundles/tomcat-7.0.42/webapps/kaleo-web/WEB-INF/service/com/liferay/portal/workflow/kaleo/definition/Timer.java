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

import java.util.Collections;
import java.util.Set;

/**
 * @author Marcellus Tavares
 */
public class Timer implements ActionAware, NotificationAware {

	public Timer(String name, String description, boolean blocking) {
		_name = name;
		_blocking = blocking;
		_description = description;
	}


	public Set<Action> getActions() {
		if (_actions == null) {
			return Collections.emptySet();
		}

		return _actions;
	}

	public DelayDuration getDelayDuration() {
		return _delayDuration;
	}

	public String getDescription() {
		return _description;
	}

	public String getName() {
		return _name;
	}


	public Set<Notification> getNotifications() {
		if (_notifications == null) {
			return Collections.emptySet();
		}

		return _notifications;
	}

	public Set<Assignment> getReassignments() {
		if (_reassignments == null) {
			return Collections.emptySet();
		}

		return _reassignments;
	}

	public DelayDuration getRecurrence() {
		return _recurrence;
	}

	public boolean isBlocking() {
		return _blocking;
	}


	public void setActions(Set<Action> actions) {
		_actions = actions;
	}

	public void setDelayDuration(DelayDuration delayDuration) {
		_delayDuration = delayDuration;
	}


	public void setNotifications(Set<Notification> notifications) {
		_notifications = notifications;
	}

	public void setReassignments(Set<Assignment> reassignments) {
		_reassignments = reassignments;
	}

	public void setRecurrence(DelayDuration recurrence) {
		_recurrence = recurrence;
	}

	private Set<Action> _actions;
	private boolean _blocking;
	private DelayDuration _delayDuration;
	private String _description;
	private String _name;
	private Set<Notification> _notifications;
	private Set<Assignment> _reassignments;
	private DelayDuration _recurrence;

}