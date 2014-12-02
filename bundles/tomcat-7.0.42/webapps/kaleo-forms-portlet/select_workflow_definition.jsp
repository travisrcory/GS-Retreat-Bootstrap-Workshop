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
String tabs1 = ParamUtil.getString(request, "tabs1", "published");

long ddmStructureId = ParamUtil.getLong(request, "ddmStructureId");
%>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/select_workflow_definition.jsp" />
	<portlet:param name="tabs1" value="<%= tabs1 %>" />
</liferay-portlet:renderURL>

<liferay-ui:search-container
	emptyResultsMessage="no-workflow-definitions-are-defined"
	iteratorURL="<%= iteratorURL %>"
	total= '<%= tabs1.equals("published") ? WorkflowDefinitionManagerUtil.getActiveWorkflowDefinitionCount(company.getCompanyId()) : KaleoDraftDefinitionLocalServiceUtil.getLatestKaleoDraftDefinitionsCount(company.getCompanyId(), 0) %>'
>

	<%
	String taglibOnClick = "Liferay.Util.getOpener()." + renderResponse.getNamespace() + "openKaleoDesigner('', '0', '', Liferay.Util.getWindowName(), true);";
	%>

	<aui:button onClick="<%= taglibOnClick %>" value="add-definition" />

	<div class="separator"><!-- --></div>

	<liferay-portlet:renderURL varImpl="portletURL">
		<portlet:param name="mvcPath" value="/select_workflow_definition.jsp" />
		<portlet:param name="tabs1" value="<%= tabs1 %>" />
	</liferay-portlet:renderURL>

	<liferay-ui:tabs
		names="published,unpublished"
		url="<%= portletURL.toString() %>"
	/>

	<c:choose>
		<c:when test='<%= tabs1.equals("published") %>'>
			<liferay-ui:search-container-results
				results="<%= WorkflowDefinitionManagerUtil.getActiveWorkflowDefinitions(company.getCompanyId(), searchContainer.getStart(), searchContainer.getEnd(), null) %>"
			/>

			<liferay-ui:search-container-row
				className="com.liferay.portal.kernel.workflow.WorkflowDefinition"
				modelVar="workflowDefinition"
			>

				<%
				StringBundler sb = new StringBundler(7);

				sb.append("javascript:Liferay.Util.getOpener().");
				sb.append(portletDisplay.getNamespace());
				sb.append("selectWorkflowDefinition('");
				sb.append(HtmlUtil.escapeJS(workflowDefinition.getName()));
				sb.append("', '");
				sb.append(workflowDefinition.getVersion());
				sb.append("', Liferay.Util.getWindow());");

				String rowHREF = sb.toString();
				%>

				<liferay-ui:search-container-column-text
					href="<%= rowHREF %>"
					name="name"
					value="<%= workflowDefinition.getName() %>"
				/>

				<liferay-ui:search-container-column-text
					href="<%= rowHREF %>"
					name="title"
					value="<%= HtmlUtil.escape(workflowDefinition.getTitle(themeDisplay.getLanguageId())) %>"
				/>

				<liferay-ui:search-container-column-text
					href="<%= rowHREF %>"
					name="version"
					value="<%= String.valueOf(workflowDefinition.getVersion()) %>"
				/>

				<%
				sb = new StringBundler(7);

				sb.append("javascript:Liferay.Util.getOpener().");
				sb.append(renderResponse.getNamespace());
				sb.append("openKaleoDesigner('");
				sb.append(HtmlUtil.escapeJS(workflowDefinition.getName()));
				sb.append("', '");
				sb.append(workflowDefinition.getVersion());
				sb.append("', '', Liferay.Util.getWindowName(), true);");

				String taglibEditURL = sb.toString();
				%>

				<liferay-ui:search-container-column-button
					align="right"
					href="<%= taglibEditURL %>"
					name="edit"
				/>
			</liferay-ui:search-container-row>
		</c:when>
		<c:otherwise>
			<liferay-ui:search-container-results
				results="<%= KaleoDraftDefinitionLocalServiceUtil.getLatestKaleoDraftDefinitions(company.getCompanyId(), 0, searchContainer.getStart(), searchContainer.getEnd(), null) %>"
			/>

			<liferay-ui:search-container-row
				className="com.liferay.portal.workflow.kaleo.designer.model.KaleoDraftDefinition"
				escapedModel="<%= true %>"
				keyProperty="kaleoDraftDefinitionId"
				modelVar="kaleoDraftDefinition"
			>
				<liferay-ui:search-container-column-text
					name="name"
					value="<%= HtmlUtil.escape(kaleoDraftDefinition.getName()) %>"
				/>

				<liferay-ui:search-container-column-text
					name="title"
					value="<%= HtmlUtil.escape(kaleoDraftDefinition.getTitle(themeDisplay.getLanguageId())) %>"
				/>

				<liferay-ui:search-container-column-text
					name="draft-version"
					value="<%= String.valueOf(kaleoDraftDefinition.getDraftVersion()) %>"
				/>

				<%
				StringBundler sb = new StringBundler(7);

				sb.append("javascript:Liferay.Util.getOpener().");
				sb.append(renderResponse.getNamespace());
				sb.append("openKaleoDesigner('");
				sb.append(HtmlUtil.escapeJS(kaleoDraftDefinition.getName()));
				sb.append("', '");
				sb.append(kaleoDraftDefinition.getVersion());
				sb.append("', '', Liferay.Util.getWindowName(), true);");

				String taglibEditURL = sb.toString();
				%>

				<liferay-ui:search-container-column-button
					align="right"
					href="<%= taglibEditURL %>"
					name="edit"
				/>
			</liferay-ui:search-container-row>
		</c:otherwise>
	</c:choose>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>