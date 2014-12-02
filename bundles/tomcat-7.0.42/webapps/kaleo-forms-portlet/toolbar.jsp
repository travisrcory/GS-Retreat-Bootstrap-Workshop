<%--
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
--%>

<%@ include file="/init.jsp" %>

<%
String toolbarItem = ParamUtil.getString(request, "toolbarItem", "view-all");
%>

<aui:nav-bar>
	<aui:nav>
		<portlet:renderURL var="viewProcessURL">
			<portlet:param name="tabs1" value="processes" />
		</portlet:renderURL>

		<aui:nav-item href="<%= viewProcessURL %>" label="view-all" selected='<%= toolbarItem.equals("view-all") %>' />

		<c:if test="<%= KaleoFormsPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_PROCESS) %>">
			<portlet:renderURL var="addProcessURL">
				<portlet:param name="mvcPath" value="/edit_kaleo_process.jsp" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="backURL" value="<%= currentURL %>" />
			</portlet:renderURL>

			<aui:nav-item href="<%= addProcessURL %>" iconClass="icon-plus" label="add" selected='<%= toolbarItem.equals("add") %>' />
		</c:if>
	</aui:nav>
</aui:nav-bar>