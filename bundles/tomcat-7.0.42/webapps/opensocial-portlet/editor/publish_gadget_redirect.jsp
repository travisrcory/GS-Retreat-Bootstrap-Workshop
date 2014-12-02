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
long gadgetId = ParamUtil.getLong(request, "gadgetId");

boolean unpublishPermission = ParamUtil.getBoolean(request, "unpublishPermission");
%>

<aui:script use="aui-base">
	Liferay.Util.getOpener().Liferay.fire(
		'publishGadgetSuccess',
		{
			gadgetId: <%= gadgetId %>,
			unpublishPermission: <%= unpublishPermission %>
		}
	);
</aui:script>