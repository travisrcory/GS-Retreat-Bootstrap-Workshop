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

import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Michael C. Han
 * @author Marcellus Tavares
 */
public abstract class Node implements ActionAware, NotificationAware {

	public Node(NodeType nodeType, String name, String description) {
		_nodeType = nodeType;
		_name = name;
		_description = description;
	}

	public void addIncomingTransition(Transition transition) {
		_incomingTransitions.add(transition);
	}

	public void addOutgoingTransition(Transition transition) {
		_outgoingTransitions.put(transition.getName(), transition);
	}


	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Node)) {
			return false;
		}

		Node node = (Node)obj;

		if (!Validator.equals(_name, node._name)) {
			return false;
		}

		return true;
	}


	public Set<Action> getActions() {
		if (_actions == null) {
			return Collections.emptySet();
		}

		return _actions;
	}

	public String getDescription() {
		return _description;
	}

	public Set<Transition> getIncomingTransitions() {
		return _incomingTransitions;
	}

	public int getIncomingTransitionsCount() {
		return _incomingTransitions.size();
	}

	public String getMetadata() {
		return _metadata;
	}

	public String getName() {
		return _name;
	}

	public NodeType getNodeType() {
		return _nodeType;
	}


	public Set<Notification> getNotifications() {
		if (_notifications == null) {
			return Collections.emptySet();
		}

		return _notifications;
	}

	public Map<String, Transition> getOutgoingTransitions() {
		return _outgoingTransitions;
	}

	public int getOutgoingTransitionsCount() {
		return _outgoingTransitions.size();
	}

	public List<Transition> getOutgoingTransitionsList() {
		return ListUtil.fromCollection(_outgoingTransitions.values());
	}

	public Set<Timer> getTimers() {
		if (_timers == null) {
			return Collections.emptySet();
		}

		return _timers;
	}


	public int hashCode() {
		return _name.hashCode();
	}


	public void setActions(Set<Action> actions) {
		_actions = actions;
	}

	public void setMetadata(String metadata) {
		_metadata = metadata;
	}


	public void setNotifications(Set<Notification> notifications) {
		_notifications = notifications;
	}

	public void setTimers(Set<Timer> timers) {
		_timers = timers;
	}

	private Set<Action> _actions;
	private String _description;
	private Set<Transition> _incomingTransitions = new HashSet<Transition>();
	private String _metadata;
	private String _name;
	private NodeType _nodeType;
	private Set<Notification> _notifications;
	private Map<String, Transition> _outgoingTransitions =
		new HashMap<String, Transition>();
	private Set<Timer> _timers;

}