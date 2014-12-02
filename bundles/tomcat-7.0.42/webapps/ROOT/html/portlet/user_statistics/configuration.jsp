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

<%@ include file="/html/portlet/user_statistics/init.jsp" %>

<%
String tabs2 = ParamUtil.getString(request, "tabs2");

String redirect = ParamUtil.getString(request, "redirect");
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationActionURL" />
<liferay-portlet:renderURL portletConfiguration="true" varImpl="configurationRenderURL" />

<aui:form action="<%= configurationActionURL %>" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input name="tabs2" type="hidden" value="<%= tabs2 %>" />
	<aui:input name="redirect" type="hidden" value="<%= configurationRenderURL.toString() %>" />

	<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" id="userStatisticsRankingsPanel" persistState="<%= true %>" title="ranking">
		<aui:input label="rank-by-contribution" name="preferences--rankByContribution--" type="checkbox" value="<%= rankByContribution %>" />

		<aui:input label="rank-by-participation" name="preferences--rankByParticipation--" type="checkbox" value="<%= rankByParticipation %>" />
	</liferay-ui:panel>

	<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" id="userStatisticsSettingsPanel" persistState="<%= true %>" title="settings">
		<aui:input label="show-header-text" name="preferences--showHeaderText--" type="checkbox" value="<%= showHeaderText %>" />

		<aui:input label="show-totals" name="preferences--showTotals--" type="checkbox" value="<%= showTotals %>" />
	</liferay-ui:panel>

	<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" id="userStatisticsDisplayActivityCounterNamesPanel" persistState="<%= true %>" title="counters">
		<div id="<portlet:namespace />displayActivityCounterNames">
			<aui:input label="display-additional-activity-counters" name="preferences--displayAdditionalActivityCounters--" type="checkbox" value="<%= displayAdditionalActivityCounters %>" />

			<aui:fieldset label="">

				<%
				for (int displayActivityCounterNameIndex : displayActivityCounterNameIndexes) {
					request.setAttribute("configuration.jsp-index", String.valueOf(displayActivityCounterNameIndex));
				%>

					<div class="lfr-form-row">
						<div class="row-fields">
							<liferay-util:include page="/html/portlet/user_statistics/add_activity_counter.jsp" />
						</div>
					</div>

				<%
				}
				%>

			</aui:fieldset>
		</div>

		<aui:script use="liferay-auto-fields">
			var autoFields = new Liferay.AutoFields(
				{
					contentBox: '#<portlet:namespace />displayActivityCounterNames > fieldset',
					fieldIndexes: '<portlet:namespace />preferences--displayActivityCounterNameIndexes--',
					namespace: '<portlet:namespace />',
					url: '<portlet:renderURL windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>"><portlet:param name="struts_action" value="/portlet_configuration/add_user_statistics_activity_counter" /></portlet:renderURL>'
				}
			).render();
		</aui:script>
	</liferay-ui:panel>

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>