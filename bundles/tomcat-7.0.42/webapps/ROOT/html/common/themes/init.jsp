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

<%@ include file="/html/common/init.jsp" %>

<%@ page import="com.liferay.portal.kernel.monitoring.RequestStatus" %><%@
page import="com.liferay.portal.kernel.monitoring.statistics.DataSample" %><%@
page import="com.liferay.portal.kernel.monitoring.statistics.DataSampleThreadLocal" %><%@
page import="com.liferay.portal.monitoring.statistics.portal.PortalRequestDataSample" %><%@
page import="com.liferay.portal.security.ldap.LDAPSettingsUtil" %><%@
page import="com.liferay.taglib.aui.ScriptTag" %>

<%@ page import="org.apache.struts.taglib.tiles.ComponentConstants" %><%@
page import="org.apache.struts.tiles.ComponentContext" %>