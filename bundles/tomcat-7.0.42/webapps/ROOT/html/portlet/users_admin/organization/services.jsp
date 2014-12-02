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

<%@ include file="/html/portlet/users_admin/init.jsp" %>

<%
Organization organization = (Organization)request.getAttribute(WebKeys.ORGANIZATION);

long organizationId = (organization != null) ? organization.getOrganizationId() : 0;

List<OrgLabor> orgLabors = Collections.emptyList();

int[] orgLaborsIndexes = null;

String orgLaborsIndexesParam = ParamUtil.getString(request, "orgLaborsIndexes");

if (Validator.isNotNull(orgLaborsIndexesParam)) {
	orgLabors = new ArrayList<OrgLabor>();

	orgLaborsIndexes = StringUtil.split(orgLaborsIndexesParam, 0);

	for (int orgLaborsIndex : orgLaborsIndexes) {
		OrgLabor orgLabor = new OrgLaborImpl();

		orgLabor.setSunOpen(-1);
		orgLabor.setSunClose(-1);
		orgLabor.setMonOpen(-1);
		orgLabor.setMonClose(-1);
		orgLabor.setTueOpen(-1);
		orgLabor.setTueClose(-1);
		orgLabor.setWedOpen(-1);
		orgLabor.setWedClose(-1);
		orgLabor.setThuOpen(-1);
		orgLabor.setThuClose(-1);
		orgLabor.setFriOpen(-1);
		orgLabor.setFriClose(-1);
		orgLabor.setSatOpen(-1);
		orgLabor.setSatClose(-1);

		orgLabors.add(orgLabor);
	}
}
else {
	if (organizationId > 0) {
		orgLabors = OrgLaborServiceUtil.getOrgLabors(organizationId);

		orgLaborsIndexes = new int[orgLabors.size()];

		for (int i = 0; i < orgLabors.size() ; i++) {
			orgLaborsIndexes[i] = i;
		}
	}

	if (orgLabors.isEmpty()) {
		orgLabors = new ArrayList<OrgLabor>();

		OrgLabor orgLabor = new OrgLaborImpl();

		orgLabor.setSunOpen(-1);
		orgLabor.setSunClose(-1);
		orgLabor.setMonOpen(-1);
		orgLabor.setMonClose(-1);
		orgLabor.setTueOpen(-1);
		orgLabor.setTueClose(-1);
		orgLabor.setWedOpen(-1);
		orgLabor.setWedClose(-1);
		orgLabor.setThuOpen(-1);
		orgLabor.setThuClose(-1);
		orgLabor.setFriOpen(-1);
		orgLabor.setFriClose(-1);
		orgLabor.setSatOpen(-1);
		orgLabor.setSatClose(-1);

		orgLabors.add(orgLabor);

		orgLaborsIndexes = new int[] {0};
	}

	if (orgLaborsIndexes == null) {
		orgLaborsIndexes = new int[0];
	}
}

Format timeFormat = FastDateFormatFactoryUtil.getSimpleDateFormat("HH:mm", locale);
%>

<liferay-ui:error-marker key="errorSection" value="services" />

<h3><liferay-ui:message key="services" /></h3>

<liferay-ui:error key="<%= NoSuchListTypeException.class.getName() + Organization.class.getName() + ListTypeConstants.ORGANIZATION_SERVICE %>" message="please-select-a-type" />

<aui:fieldset>

	<%
	Calendar cal = CalendarFactoryUtil.getCalendar();
	String[] days = CalendarUtil.getDays(locale);
	String[] paramPrefixes = {"sun", "mon", "tue", "wed", "thu", "fri", "sat"};

	for (int i = 0; i < orgLaborsIndexes.length; i++) {
		int orgLaborsIndex = orgLaborsIndexes[i];

		OrgLabor orgLabor = orgLabors.get(i);

		int[] openArray = new int[paramPrefixes.length];

		for (int j = 0; j < paramPrefixes.length; j++) {
			openArray[j] = ParamUtil.getInteger(request, paramPrefixes[j] + "Open" + orgLaborsIndex, BeanPropertiesUtil.getInteger(orgLabor, paramPrefixes[j] + "Open", -1));
		}

		int[] closeArray = new int[paramPrefixes.length];

		for (int j = 0; j < paramPrefixes.length; j++) {
			closeArray[j] = ParamUtil.getInteger(request, paramPrefixes[j] + "Close" + orgLaborsIndex, BeanPropertiesUtil.getInteger(orgLabor, paramPrefixes[j] + "Close", -1));
		}
	%>

		<aui:model-context bean="<%= orgLabor %>" model="<%= OrgLabor.class %>" />

		<div class="lfr-form-row">
			<div class="row-fields">
				<aui:input name='<%= "orgLaborId" + orgLaborsIndex %>' type="hidden" />

				<aui:select label="type" listType="<%= ListTypeConstants.ORGANIZATION_SERVICE %>" name='<%= "orgLaborTypeId" + orgLaborsIndex %>' />

				<%
				for (int j = 0; j < days.length; j++) {
					int close = closeArray[j];
					String day = days[j];
					int open = openArray[j];
					String paramPrefix = paramPrefixes[j];
				%>

					<div class="org-labor-entry">
						<h5 class="org-labor-entry-title"><%= day %></h5>

						<aui:select label="Open" name='<%= paramPrefix + "Open" + orgLaborsIndex %>'>
							<aui:option value="-1" />

							<%
							cal.set(Calendar.HOUR_OF_DAY, 0);
							cal.set(Calendar.MINUTE, 0);
							cal.set(Calendar.SECOND, 0);
							cal.set(Calendar.MILLISECOND, 0);

							int today = cal.get(Calendar.DATE);

							while (cal.get(Calendar.DATE) == today) {
								String timeOfDayDisplay = timeFormat.format(cal.getTime());
								int timeOfDayValue = GetterUtil.getInteger(StringUtil.replace(timeOfDayDisplay, StringPool.COLON, StringPool.BLANK));

								cal.add(Calendar.MINUTE, 30);
							%>

								<aui:option label="<%= timeOfDayDisplay %>" selected="<%= (open == timeOfDayValue) %>" value="<%= timeOfDayValue %>" />

							<%
							}
							%>

						</aui:select>

						<aui:select label="close" name='<%= paramPrefix + "Close" + orgLaborsIndex %>'>
							<aui:option value="-1" />

							<%
							cal.set(Calendar.HOUR_OF_DAY, 0);
							cal.set(Calendar.MINUTE, 0);
							cal.set(Calendar.SECOND, 0);
							cal.set(Calendar.MILLISECOND, 0);

							int today = cal.get(Calendar.DATE);

							while (cal.get(Calendar.DATE) == today) {
								String timeOfDayDisplay = timeFormat.format(cal.getTime());
								int timeOfDayValue = GetterUtil.getInteger(StringUtil.replace(timeOfDayDisplay, StringPool.COLON, StringPool.BLANK));

								cal.add(Calendar.MINUTE, 30);
							%>

								<aui:option label="<%= timeOfDayDisplay %>" selected="<%= (close == timeOfDayValue) %>" value="<%= timeOfDayValue %>" />

							<%
							}
							%>

						</aui:select>
					</div>

				<%
				}
				%>

			</div>
		</div>

	<%
	}
	%>

	<aui:input name="orgLaborsIndexes" type="hidden" value="<%= StringUtil.merge(orgLaborsIndexes) %>" />
</aui:fieldset>

<aui:script use="liferay-auto-fields">
	Liferay.once(
		'formNavigator:reveal<portlet:namespace />services',
		function() {
			new Liferay.AutoFields(
				{
					contentBox: '#<portlet:namespace />services > fieldset',
					fieldIndexes: '<portlet:namespace />orgLaborsIndexes',
					namespace: '<portlet:namespace />'
				}
			).render();
		}
	);
</aui:script>