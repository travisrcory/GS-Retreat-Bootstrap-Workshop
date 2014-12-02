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

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.marketplace.model.App" %><%@
page import="com.liferay.marketplace.service.AppLocalServiceUtil" %><%@
page import="com.liferay.marketplace.util.MarketplaceConstants" %><%@
page import="com.liferay.marketplace.util.PortletKeys" %><%@
page import="com.liferay.marketplace.util.comparator.PluginComparator" %><%@
page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %><%@
page import="com.liferay.portal.kernel.deploy.DeployManagerUtil" %><%@
page import="com.liferay.portal.kernel.plugin.RequiredPluginPackageException" %><%@
page import="com.liferay.portal.kernel.portlet.LiferayPortletURL" %><%@
page import="com.liferay.portal.kernel.servlet.ServletContextPool" %><%@
page import="com.liferay.portal.kernel.upload.UploadException" %><%@
page import="com.liferay.portal.kernel.util.Constants" %><%@
page import="com.liferay.portal.kernel.util.ListUtil" %><%@
page import="com.liferay.portal.kernel.util.ParamUtil" %><%@
page import="com.liferay.portal.kernel.util.ServerDetector" %><%@
page import="com.liferay.portal.kernel.util.StringPool" %><%@
page import="com.liferay.portal.kernel.util.StringUtil" %><%@
page import="com.liferay.portal.kernel.util.Validator" %><%@
page import="com.liferay.portal.kernel.util.WebKeys" %><%@
page import="com.liferay.portal.model.LayoutTemplate" %><%@
page import="com.liferay.portal.model.Plugin" %><%@
page import="com.liferay.portal.model.PluginSetting" %><%@
page import="com.liferay.portal.model.Portlet" %><%@
page import="com.liferay.portal.model.Theme" %><%@
page import="com.liferay.portal.service.CompanyLocalServiceUtil" %><%@
page import="com.liferay.portal.service.PluginSettingLocalServiceUtil" %><%@
page import="com.liferay.portal.service.PortletLocalServiceUtil" %><%@
page import="com.liferay.portal.util.PortalUtil" %><%@
page import="com.liferay.portal.util.PortletCategoryKeys" %><%@
page import="com.liferay.portlet.PortletURLFactoryUtil" %>

<%@ page import="java.util.ArrayList" %><%@
page import="java.util.Iterator" %><%@
page import="java.util.List" %>

<%@ page import="javax.portlet.PortletRequest" %><%@
page import="javax.portlet.PortletURL" %><%@
page import="javax.portlet.WindowState" %>

<%@ page import="javax.servlet.ServletContext" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<%
long appId = ParamUtil.getLong(request, "appId");

String portletId = portletDisplay.getId();

String iFrameURL = MarketplaceConstants.MARKETPLACE_URL_LOGOUT;

String referer = StringPool.BLANK;

if (portletId.equals(PortletKeys.MY_MARKETPLACE)) {
	referer = MarketplaceConstants.getPathPurchased();
}
else if (portletId.equals(PortletKeys.STORE) && (appId > 0)) {
	referer = MarketplaceConstants.getPathStore() + "/application/" + appId;
}
else {
	referer = MarketplaceConstants.getPathStore();
}
%>