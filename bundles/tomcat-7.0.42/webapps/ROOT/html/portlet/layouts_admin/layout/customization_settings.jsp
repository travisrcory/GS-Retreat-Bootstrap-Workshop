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

boolean curFreeformLayout = false;
boolean prototypeGroup = false;

String velocityTemplateId = null;

String velocityTemplateContent = null;

Group group = null;

if (selLayout != null) {
	group = selLayout.getGroup();

	Theme curTheme = selLayout.getTheme();

	String themeId = curTheme.getThemeId();

	LayoutTypePortlet curLayoutTypePortlet = (LayoutTypePortlet)selLayout.getLayoutType();

	String layoutTemplateId = curLayoutTypePortlet.getLayoutTemplateId();

	if (Validator.isNull(layoutTemplateId)) {
		layoutTemplateId = PropsValues.DEFAULT_LAYOUT_TEMPLATE_ID;
	}

	curFreeformLayout = layoutTemplateId.equals("freeform");

	if (group.isLayoutPrototype() || group.isLayoutSetPrototype()) {
		prototypeGroup = true;
	}

	if (!curFreeformLayout && !prototypeGroup) {
		LayoutTemplate layoutTemplate = LayoutTemplateLocalServiceUtil.getLayoutTemplate(layoutTemplateId, false, themeId);

		if (layoutTemplate != null) {
			themeId = layoutTemplate.getThemeId();

			velocityTemplateId = themeId + LayoutTemplateConstants.CUSTOM_SEPARATOR + curLayoutTypePortlet.getLayoutTemplateId();

			velocityTemplateContent = LayoutTemplateLocalServiceUtil.getContent(curLayoutTypePortlet.getLayoutTemplateId(), false, themeId);
		}
	}
}
%>

<liferay-ui:error-marker key="errorSection" value="customization-settings" />

<aui:model-context bean="<%= selLayout %>" model="<%= Layout.class %>" />

<h3><liferay-ui:message key="customization-settings" /></h3>

<c:choose>
	<c:when test="<%= curFreeformLayout %>">
		<div class="alert alert-block">
			<liferay-ui:message key="it-is-not-possible-to-specify-customization-settings-for-freeform-layouts" />
		</div>
	</c:when>
	<c:when test="<%= prototypeGroup %>">
		<div class="alert alert-block">
			<liferay-ui:message key="it-is-not-possible-to-specify-customization-settings-for-pages-in-site-templates-or-page-templates" />
		</div>
	</c:when>
	<c:otherwise>
		<div class="alert alert-info">
			<liferay-ui:message key="customizable-help" />
		</div>
	</c:otherwise>
</c:choose>

<div class="customization-settings">
	<c:choose>
		<c:when test="<%= themeDisplay.isStateExclusive() %>">
			<aui:button name="manageCustomization" value="show-customizable-sections" />

			<div class="hide layout-customizable-controls" id="<portlet:namespace />layoutCustomizableControls">
				<span title="<liferay-ui:message key="customizable-help" />">
					<aui:input cssClass="layout-customizable-checkbox" helpMessage='<%= group.isLayoutPrototype() ? "modifiable-help" : "customizable-help" %>' id="TypeSettingsProperties--[COLUMN_ID]-customizable--" label='<%= (group.isLayoutSetPrototype() || group.isLayoutPrototype()) ? "modifiable" : "customizable" %>' name="TypeSettingsProperties--[COLUMN_ID]-customizable--" type="checkbox" useNamespace="<%= false %>" />
				</span>
			</div>
		</c:when>
		<c:otherwise>

			<%
			if (Validator.isNotNull(velocityTemplateId) && Validator.isNotNull(velocityTemplateContent)) {
				RuntimePageUtil.processCustomizationSettings(pageContext, new StringTemplateResource(velocityTemplateId, velocityTemplateContent));
			}
			%>

		</c:otherwise>
	</c:choose>
</div>

<c:if test="<%= themeDisplay.isStateExclusive() %>">
	<aui:script use="liferay-layout-customization-settings">
		new Liferay.LayoutCustomizationSettings(
			{
				namespace: '<portlet:namespace />'
			}
		);
	</aui:script>
</c:if>