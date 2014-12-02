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
PortletURL portletURL = renderResponse.createRenderURL();
%>

<liferay-ui:search-container
	emptyResultsMessage="there-are-no-gadgets"
	headerNames="name"
	iteratorURL="<%= portletURL %>"
	total="<%= GadgetLocalServiceUtil.getGadgetsCount(company.getCompanyId()) %>"
>
	<liferay-ui:search-container-results
		results="<%= GadgetLocalServiceUtil.getGadgets(company.getCompanyId(), searchContainer.getStart(), searchContainer.getEnd()) %>"
	/>

	<liferay-ui:search-container-row
		className="com.liferay.opensocial.model.Gadget"
		keyProperty="gadgetId"
		modelVar="gadget"
	>
		<liferay-ui:search-container-column-text
			name="gadget"
			property="name"
		/>

		<%
		String gadgetURL = gadget.getUrl();
		%>

		<liferay-ui:search-container-column-text
			href="<%= gadgetURL %>"
			name="url"
			value="<%= gadgetURL %>"
		/>

		<liferay-ui:search-container-column-jsp
			align="right"
			path="/admin/gadget_action.jsp"
			valign="top"
		/>
	</liferay-ui:search-container-row>

	<div>
		<c:if test="<%= GadgetPermission.contains(permissionChecker, themeDisplay.getScopeGroupId(), ActionKeys.PUBLISH_GADGET) %>">
			<span>
				<input onClick="location.href = '<portlet:renderURL><portlet:param name="mvcPath" value="/admin/edit_gadget.jsp" /><portlet:param name="redirect" value="<%= currentURL %>" /></portlet:renderURL>';" type="button" value="<liferay-ui:message key="publish-gadget" />" />
			</span>
		</c:if>

		<span>
			<input onClick="location.href = '<portlet:actionURL name="refreshGadgets"><portlet:param name="redirect" value="<%= currentURL %>" /></portlet:actionURL>';" type="button" value="<liferay-ui:message key="refresh-gadgets" />" />
		</span>
	</div>

	<br />

	<liferay-ui:search-iterator />
</liferay-ui:search-container>