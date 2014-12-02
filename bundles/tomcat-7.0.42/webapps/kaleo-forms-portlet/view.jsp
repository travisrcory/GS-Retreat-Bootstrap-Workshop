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
String tabs1 = ParamUtil.getString(request, "tabs1", "summary");

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("tabs1", tabs1);
%>

<c:choose>
	<c:when test="<%= WorkflowEngineManagerUtil.isDeployed() %>">
		<liferay-ui:tabs
			names="summary,processes"
			url="<%= portletURL.toString() %>"
		/>

		<c:choose>
			<c:when test='<%= tabs1.equals("summary") %>'>
				<liferay-util:include page="/view_summary.jsp" servletContext="<%= application %>" />
			</c:when>
			<c:when test='<%= tabs1.equals("processes") %>'>
				<liferay-util:include page="/view_kaleo_processes.jsp" servletContext="<%= application %>" />
			</c:when>
		</c:choose>
	</c:when>
	<c:otherwise>
		<div class="alert alert-info">
			<liferay-ui:message key="no-workflow-engine-is-deployed" />
		</div>
	</c:otherwise>
</c:choose>