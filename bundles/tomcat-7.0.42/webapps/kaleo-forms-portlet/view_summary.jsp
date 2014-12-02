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

<aui:layout>
	<aui:column columnWidth="<%= 25 %>" first="<%= true %>">
		<%@ include file="/navigation.jspf" %>
	</aui:column>
	<aui:column columnWidth="<%= 75 %>" last="<%= true %>">
		<%@ include file="/content.jspf" %>
	</aui:column>
</aui:layout>