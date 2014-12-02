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

<%@ include file="/html/portlet/dynamic_data_mapping/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

DDMTemplate template = (DDMTemplate)row.getObject();
%>

<liferay-ui:icon-menu showExpanded="<%= false %>" showWhenSingleIcon="<%= false %>">
	<c:if test="<%= DDMTemplatePermission.contains(permissionChecker, template, refererPortletName, ActionKeys.UPDATE) %>">
		<portlet:renderURL var="editURL">
			<portlet:param name="struts_action" value="/dynamic_data_mapping/edit_template" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="groupId" value="<%= String.valueOf(template.getGroupId()) %>" />
			<portlet:param name="templateId" value="<%= String.valueOf(template.getTemplateId()) %>" />
			<portlet:param name="type" value="<%= template.getType() %>" />
			<portlet:param name="structureAvailableFields" value='<%= renderResponse.getNamespace() + "getAvailableFields" %>' />
		</portlet:renderURL>

		<liferay-ui:icon
			image="edit"
			url="<%= editURL %>"
		/>
	</c:if>

	<c:if test="<%= DDMTemplatePermission.contains(permissionChecker, template, refererPortletName, ActionKeys.PERMISSIONS) %>">
		<liferay-security:permissionsURL
			modelResource="<%= DDMTemplate.class.getName() %>"
			modelResourceDescription="<%= template.getName(locale) %>"
			resourcePrimKey="<%= String.valueOf(template.getTemplateId()) %>"
			var="permissionsURL"
		/>

		<liferay-ui:icon
			image="permissions"
			url="<%= permissionsURL %>"
		/>
	</c:if>

	<c:if test="<%= DDMPermission.contains(permissionChecker, scopeGroupId, ddmDisplay.getResourceName(template.getClassNameId()), ddmDisplay.getAddTemplateActionId()) %>">
		<portlet:renderURL var="copyURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
			<portlet:param name="closeRedirect" value="<%= HttpUtil.encodeURL(currentURL) %>" />
			<portlet:param name="struts_action" value="/dynamic_data_mapping/copy_template" />
			<portlet:param name="templateId" value="<%= String.valueOf(template.getTemplateId()) %>" />
		</portlet:renderURL>

		<%
		StringBundler sb = new StringBundler(6);

		sb.append("javascript:");
		sb.append(renderResponse.getNamespace());
		sb.append("copyTemplate");
		sb.append("('");
		sb.append(copyURL);
		sb.append("');");
		%>

		<liferay-ui:icon
			image="copy"
			url="<%= sb.toString() %>"
		/>
	</c:if>

	<c:if test="<%= DDMTemplatePermission.contains(permissionChecker, template, refererPortletName, ActionKeys.DELETE) %>">
		<portlet:actionURL var="deleteURL">
			<portlet:param name="struts_action" value="/dynamic_data_mapping/edit_template" />
			<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.DELETE %>" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="templateId" value="<%= String.valueOf(template.getTemplateId()) %>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%= deleteURL %>" />
	</c:if>
</liferay-ui:icon-menu>