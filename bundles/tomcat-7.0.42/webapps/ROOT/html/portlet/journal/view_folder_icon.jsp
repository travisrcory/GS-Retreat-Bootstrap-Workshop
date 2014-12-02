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

<%@ include file="/html/portlet/journal/init.jsp" %>

<%
JournalFolder folder = (JournalFolder)request.getAttribute("view_entries.jsp-folder");

String folderImage = (String)request.getAttribute("view_entries.jsp-folderImage");

PortletURL tempRowURL = (PortletURL)request.getAttribute("view_entries.jsp-tempRowURL");
%>

<liferay-ui:app-view-entry
	actionJsp="/html/portlet/journal/folder_action.jsp"
	description="<%= folder.getDescription() %>"
	displayStyle="icon"
	folder="<%= true %>"
	rowCheckerId="<%= String.valueOf(folder.getFolderId()) %>"
	rowCheckerName="<%= JournalFolder.class.getSimpleName() %>"
	showCheckbox="<%= JournalFolderPermission.contains(permissionChecker, folder, ActionKeys.DELETE) || JournalFolderPermission.contains(permissionChecker, folder, ActionKeys.UPDATE) %>"
	thumbnailSrc='<%= themeDisplay.getPathThemeImages() + "/file_system/large/" + folderImage + ".png" %>'
	thumbnailStyle="max-height: 128px; max-width: 128px;"
	title="<%= HtmlUtil.escape(folder.getName()) %>"
	url="<%= tempRowURL.toString() %>"
/>