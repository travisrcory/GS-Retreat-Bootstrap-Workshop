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
String redirect = ParamUtil.getString(request, "redirect");
String backURL = ParamUtil.getString(request, "backURL");

KaleoProcess kaleoProcess = (KaleoProcess)request.getAttribute(WebKeys.KALEO_PROCESS);

long kaleoProcessId = BeanParamUtil.getLong(kaleoProcess, request, "kaleoProcessId");

long groupId = BeanParamUtil.getLong(kaleoProcess, request, "groupId", scopeGroupId);
%>

<liferay-ui:header
	backURL="<%= backURL %>"
	title='<%= LanguageUtil.format(locale, "new-x", kaleoProcess.getName(locale)) %>'
/>

<portlet:actionURL name="startWorkflowInstance" var="startWorkflowInstanceURL">
	<portlet:param name="redirect" value="<%= redirect %>" />
</portlet:actionURL>

<aui:form action="<%= startWorkflowInstanceURL %>" cssClass="lfr-dynamic-form" enctype="multipart/form-data" method="post" name="fm1">
	<aui:input name="kaleoProcessId" type="hidden" value="<%= String.valueOf(kaleoProcessId) %>" />
	<aui:input name="groupId" type="hidden" value="<%= groupId %>" />
	<aui:input name="ddlRecordSetId" type="hidden" value="<%= String.valueOf(kaleoProcess.getDDLRecordSetId()) %>" />
	<aui:input name="ddmTemplateId" type="hidden" value="<%= String.valueOf(kaleoProcess.getDDMTemplateId()) %>" />
	<aui:input name="workflowAction" type="hidden" value="<%= WorkflowConstants.ACTION_PUBLISH %>" />

	<aui:fieldset>

		<%
		DDMTemplate ddmTemplate = kaleoProcess.getDDMTemplate();
		%>

		<liferay-ddm:html
			classNameId="<%= PortalUtil.getClassNameId(DDMTemplate.class) %>"
			classPK="<%= ddmTemplate.getTemplateId() %>"
			requestedLocale="<%= locale %>"
		/>

		<aui:button-row>
			<aui:button name="saveButton" type="submit" value="save" />

			<aui:button href="<%= redirect %>" name="cancelButton" type="cancel" />
		</aui:button-row>
	</aui:fieldset>
</aui:form>