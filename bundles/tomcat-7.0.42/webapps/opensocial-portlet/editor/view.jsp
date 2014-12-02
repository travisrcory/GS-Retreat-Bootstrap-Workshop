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
long repositoryId = themeDisplay.getScopeGroupId();

Folder rootFolder = ShindigUtil.getGadgetEditorRootFolder(repositoryId);
%>

<div id="<portlet:namespace />editor"></div>

<portlet:renderURL var="editorGadgetURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
	<portlet:param name="mvcPath" value="/admin/edit_gadget.jsp" />
	<portlet:param name="editorGadgetURL" value="editorGadgetURLPlaceholder" />
</portlet:renderURL>

<aui:script use="opensocial-editor">
	new Liferay.OpenSocial.Editor(
		{
			baseRenderURL: '<%= PortletURLFactoryUtil.create(request, portletDisplay.getId(), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE) %>',
			editorGadgetURL: '<%= editorGadgetURL %>',
			gadgetPortletId: '<%= portletDisplay.getId() %>',
			gadgetServerBase: '<%= PortalUtil.getPathContext(renderRequest) %>/gadgets/',
			namespace: '<portlet:namespace />',
			publishGadgetPermission: <%= GadgetPermission.contains(themeDisplay.getPermissionChecker(), themeDisplay.getScopeGroupId(), ActionKeys.PUBLISH_GADGET) %>,
			repositoryId: '<%= repositoryId %>',
			resourceURL: '<portlet:resourceURL />',
			rootFolderId: '<%= rootFolder.getFolderId() %>'
		}
	).render('#<portlet:namespace />editor');
</aui:script>