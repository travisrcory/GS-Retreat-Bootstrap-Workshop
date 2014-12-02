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
String randomId = PwdGenerator.getPassword(PwdGenerator.KEY3, 4);

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

WorkflowInstance workflowInstance = null;

if (row != null) {
	workflowInstance = (WorkflowInstance)row.getObject();
}
else {
	workflowInstance = (WorkflowInstance)request.getAttribute(WebKeys.WORKFLOW_INSTANCE);
}
%>

<liferay-ui:icon-menu showExpanded="<%= row == null %>" showWhenSingleIcon="<%= true %>">
	<c:if test="<%= !workflowInstance.isComplete() %>">
		<portlet:renderURL var="redirectURL">
			<portlet:param name="tabs2" value="my-pending-requests" />
		</portlet:renderURL>

		<portlet:actionURL name="deleteWorkflowInstance" var="deleteURL">
			<portlet:param name="redirect" value="<%= redirectURL %>" />
			<portlet:param name="workflowInstanceId" value="<%= StringUtil.valueOf(workflowInstance.getWorkflowInstanceId()) %>" />
		</portlet:actionURL>

		<liferay-ui:icon
			image="undo"
			message="withdraw-submission"
			url="<%= deleteURL %>"
		/>
	</c:if>
</liferay-ui:icon-menu>