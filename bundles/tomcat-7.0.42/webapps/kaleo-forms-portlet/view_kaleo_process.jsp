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
String backURL = ParamUtil.getString(request, "backURL");

KaleoProcess kaleoProcess = (KaleoProcess)request.getAttribute(WebKeys.KALEO_PROCESS);

long kaleoProcessId = BeanParamUtil.getLong(kaleoProcess, request, "kaleoProcessId");
%>

<liferay-ui:header
	backURL="<%= backURL %>"
	title="<%= kaleoProcess.getName(locale) %>"
/>

<%
PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("mvcPath", "/view_kaleo_process.jsp");
portletURL.setParameter("backURL", backURL);
portletURL.setParameter("kaleoProcessId", String.valueOf(kaleoProcessId));

DDLRecordSet ddlRecordSet = kaleoProcess.getDDLRecordSet();

DDMStructure ddmStructure = ddlRecordSet.getDDMStructure();

Map<String, Map<String, String>> fieldsMap = ddmStructure.getFieldsMap();

List<String> headerNames = new ArrayList<String>();

for (Map<String, String> fields : fieldsMap.values()) {
	if (GetterUtil.getBoolean(fields.get(FieldConstants.PRIVATE))) {
		continue;
	}

	String label = fields.get(FieldConstants.LABEL);

	headerNames.add(label);
}

headerNames.add("status");
headerNames.add("modified-date");
headerNames.add("author");

SearchContainer searchContainer = new SearchContainer(renderRequest, portletURL, headerNames, "no-records-were-found");

int total = DDLRecordLocalServiceUtil.getRecordsCount(kaleoProcess.getDDLRecordSetId(), WorkflowConstants.STATUS_ANY);

searchContainer.setTotal(total);

List<DDLRecord> results = DDLRecordLocalServiceUtil.getRecords(kaleoProcess.getDDLRecordSetId(), WorkflowConstants.STATUS_ANY, searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());

searchContainer.setResults(results);

List resultRows = searchContainer.getResultRows();

for (int i = 0; i < results.size(); i++) {
	DDLRecord ddlRecord = results.get(i);

	Fields fieldsModel = ddlRecord.getFields();

	ResultRow row = new ResultRow(ddlRecord, ddlRecord.getRecordId(), i);

	// Columns

	for (Map<String, String> fields : fieldsMap.values()) {
		if (GetterUtil.getBoolean(fields.get(FieldConstants.PRIVATE))) {
			continue;
		}

		String name = fields.get(FieldConstants.NAME);

		String value = null;

		if (fieldsModel.contains(name)) {
			com.liferay.portlet.dynamicdatamapping.storage.Field field = fieldsModel.get(name);

			value = field.getRenderedValue(themeDisplay.getLocale());
		}
		else {
			value = StringPool.BLANK;
		}

		row.addText(HtmlUtil.escape(value));
	}

	row.addText(LanguageUtil.get(pageContext, WorkflowConstants.getStatusLabel(ddlRecord.getStatus())));
	row.addDate(ddlRecord.getModifiedDate());
	row.addText(HtmlUtil.escape(PortalUtil.getUserName(ddlRecord.getUserId(), ddlRecord.getUserName())));

	// Add result row

	resultRows.add(row);
}
%>

<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />