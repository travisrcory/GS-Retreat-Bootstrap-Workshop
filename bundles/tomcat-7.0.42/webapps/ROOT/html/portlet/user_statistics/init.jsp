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

<%@ include file="/html/portlet/init.jsp" %>

<%@ page import="com.liferay.portlet.social.model.SocialActivityCounter" %><%@
page import="com.liferay.portlet.social.model.SocialActivityCounterConstants" %><%@
page import="com.liferay.portlet.social.model.impl.SocialActivityCounterImpl" %><%@
page import="com.liferay.portlet.social.service.SocialActivityCounterLocalServiceUtil" %><%@
page import="com.liferay.portlet.social.util.SocialConfigurationUtil" %><%@
page import="com.liferay.portlet.social.util.comparator.SocialActivityCounterNameComparator" %>

<%
boolean displayAdditionalActivityCounters = GetterUtil.getBoolean(PrefsParamUtil.getString(portletPreferences, request, "displayAdditionalActivityCounters"), true);

int[] displayActivityCounterNameIndexes = null;

String displayActivityCounterNameIndexesParam = PrefsParamUtil.getString(portletPreferences, request, "displayActivityCounterNameIndexes");

if (Validator.isNotNull(displayActivityCounterNameIndexesParam)) {
	displayActivityCounterNameIndexes = StringUtil.split(displayActivityCounterNameIndexesParam, 0);
}
else {
	displayActivityCounterNameIndexes = new int[] {0};
}

boolean rankByContribution = GetterUtil.getBoolean(PrefsParamUtil.getString(portletPreferences, request, "rankByContribution"), true);
boolean rankByParticipation = GetterUtil.getBoolean(PrefsParamUtil.getString(portletPreferences, request, "rankByParticipation"), true);
boolean showHeaderText = GetterUtil.getBoolean(PrefsParamUtil.getString(portletPreferences, request, "showHeaderText"), true);
boolean showTotals = GetterUtil.getBoolean(PrefsParamUtil.getString(portletPreferences, request, "showTotals"), true);
%>

<%@ include file="/html/portlet/user_statistics/init-ext.jsp" %>