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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Michael C. Han
 */
public class Definition {

	public Definition(
		String name, String description, String content, int version) {

		_name = name;
		_description = description;
		_content = content;
		_version = version;
	}

	public void addNode(Node node) {
		if (_nodesMap.containsKey(node.getName())) {
			throw new IllegalArgumentException(
				"Duplicate node " + node.getName());
		}

		_nodesMap.put(node.getName(), node);

		if (node instanceof State) {
			State state = (State)node;

			if (state.isInitial()) {
				_initialState = state;
			}
		}
		else if (node instanceof Fork) {
			_forks.add((Fork)node);
		}
		else if (node instanceof Join) {
			_joins.add((Join)node);
		}
	}

	public String getContent() {
		return _content;
	}

	public String getDescription() {
		return _description;
	}

	public List<Fork> getForks() {
		return Collections.unmodifiableList(_forks);
	}

	public int getForksCount() {
		return _forks.size();
	}

	public State getInitialState() {
		return _initialState;
	}

	public List<Join> getJoins() {
		return Collections.unmodifiableList(_joins);
	}

	public int getJoinsCount() {
		return _joins.size();
	}

	public String getName() {
		return _name;
	}

	public Node getNode(String name) {
		return _nodesMap.get(name);
	}

	public Collection<Node> getNodes() {
		return Collections.unmodifiableCollection(_nodesMap.values());
	}

	public List<State> getTerminalStates() {
		if (_terminalStates == null) {
			_terminalStates = new ArrayList<State>();

			for (Node node : _nodesMap.values()) {
				if (node instanceof State) {
					State state = (State)node;

					if (state.isTerminal()) {
						_terminalStates.add(state);
					}
				}
			}
		}

		return Collections.unmodifiableList(_terminalStates);
	}

	public int getVersion() {
		return _version;
	}

	public boolean hasNode(String name) {
		return _nodesMap.containsKey(name);
	}

	private String _content;
	private String _description;
	private List<Fork> _forks = new ArrayList<Fork>();
	private State _initialState;
	private List<Join> _joins = new ArrayList<Join>();
	private String _name;
	private Map<String, Node> _nodesMap = new HashMap<String, Node>();
	private List<State> _terminalStates;
	private int _version;

}