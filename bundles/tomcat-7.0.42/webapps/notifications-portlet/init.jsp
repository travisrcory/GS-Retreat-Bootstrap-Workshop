<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the applicable 
 * Liferay software end user license agreement ("License Agreement")
 * found on www.liferay.com/legal/eulas. You may also contact Liferay, Inc.
 * for a copy of the License Agreement. You may not use this file except in
 * compliance with the License Agreement. 
 * See the License Agreement for the specific language governing
 * permissions and limitations under the License Agreement, including 
 * but not limited to distribution rights of the Software.
 *
 */
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="com.liferay.notifications.util.PortletKeys" %><%@
page import="com.liferay.notifications.util.PortletPropsValues" %><%@
page import="com.liferay.portal.kernel.json.JSONFactoryUtil" %><%@
page import="com.liferay.portal.kernel.json.JSONObject" %><%@
page import="com.liferay.portal.kernel.notifications.UserNotificationDefinition" %><%@
page import="com.liferay.portal.kernel.notifications.UserNotificationDeliveryType" %><%@
page import="com.liferay.portal.kernel.notifications.UserNotificationFeedEntry" %><%@
page import="com.liferay.portal.kernel.notifications.UserNotificationManagerUtil" %><%@
page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %><%@
page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil" %><%@
page import="com.liferay.portal.kernel.util.HtmlUtil" %><%@
page import="com.liferay.portal.kernel.util.ParamUtil" %><%@
page import="com.liferay.portal.kernel.util.StringPool" %><%@
page import="com.liferay.portal.model.Group" %><%@
page import="com.liferay.portal.model.GroupConstants" %><%@
page import="com.liferay.portal.model.LayoutConstants" %><%@
page import="com.liferay.portal.model.Portlet" %><%@
page import="com.liferay.portal.model.User" %><%@
page import="com.liferay.portal.model.UserNotificationDelivery" %><%@
page import="com.liferay.portal.model.UserNotificationEvent" %><%@
page import="com.liferay.portal.service.GroupLocalServiceUtil" %><%@
page import="com.liferay.portal.service.LayoutLocalServiceUtil" %><%@
page import="com.liferay.portal.service.PortletLocalServiceUtil" %><%@
page import="com.liferay.portal.service.ServiceContextFactory" %><%@
page import="com.liferay.portal.service.UserLocalServiceUtil" %><%@
page import="com.liferay.portal.service.UserNotificationDeliveryLocalServiceUtil" %><%@
page import="com.liferay.portal.service.UserNotificationEventLocalServiceUtil" %><%@
page import="com.liferay.portal.util.PortalUtil" %>

<%@ page import="java.text.Format" %>

<%@ page import="java.util.List" %><%@
page import="java.util.Map" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<%
int delta = 10;

Format simpleDateFormat = FastDateFormatFactoryUtil.getSimpleDateFormat("EEEE, MMMMM dd, yyyy 'at' h:mm a", themeDisplay.getLocale(), themeDisplay.getTimeZone());
%>