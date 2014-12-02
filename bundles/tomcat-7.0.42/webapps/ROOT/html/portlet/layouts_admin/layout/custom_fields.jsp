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

<%@ include file="/html/portlet/layouts_admin/init.jsp" %>

<%
Layout selLayout = (Layout)request.getAttribute("edit_pages.jsp-selLayout");
%>

<liferay-ui:error-marker key="errorSection" value="custom-fields" />

<aui:model-context bean="<%= selLayout %>" model="<%= Layout.class %>" />

<h3><liferay-ui:message key="custom-fields" /></h3>

<aui:fieldset>
	<liferay-ui:custom-attribute-list
		className="<%= Layout.class.getName() %>"
		classPK="<%= (selLayout != null) ? selLayout.getPlid() : 0 %>"
		editable="<%= true %>"
		label="<%= true %>"
	/>
</aui:fieldset>