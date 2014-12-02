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

<%@ include file="/init.jsp" %>

<div class="clearfix notifications-container">
	<aui:row>
		<aui:col cssClass="nav-bar user-notifications-sidebar" width="<%= 25 %>">
			<div class="nav">
				<a class="clearfix selected unread" href="javascript:;">
					<span class="title"><liferay-ui:message key="unread" /></span>

					<%
					int unreadUserNotificationsCount = UserNotificationEventLocalServiceUtil.getArchivedUserNotificationEventsCount(themeDisplay.getUserId(), false);
					%>

					<span class="count"><%= unreadUserNotificationsCount %></span>
				</a>
			</div>

			<div class="nav">
				<a class="all-notifications clearfix" href="javascript:;">
					<span class="title"><liferay-ui:message key="all-notifications" /></span>
				</a>
			</div>

			<div class="nav">
				<a class="manage clearfix" href="javascript:;">
					<span class="title"><liferay-ui:message key="notification-delivery" /></span>
				</a>
			</div>
		</aui:col>

		<aui:col cssClass="user-notifications-list-container" width="<%= 75 %>">
			<ul class="unstyled user-notifications-list">
				<div class="loading-mask"></div>
			</ul>
		</aui:col>
	</aui:row>
</div>

<aui:script use="aui-base,aui-io-plugin-deprecated">
	var userNotifications = A.one('#portlet_<%= PortletKeys.NOTIFICATIONS %>');

	var userNotificationsList = userNotifications.one('.user-notifications-list-container .user-notifications-list');

	var renderUserNotificationsList = function(uri) {
		if (userNotificationsList) {
			if (!userNotificationsList.io) {
				userNotificationsList.plug(
					A.Plugin.IO,
					{
					autoLoad: false
					}
				);
			}

			userNotificationsList.io.set('uri', uri);
			userNotificationsList.io.start();
		}
	};

	<portlet:renderURL var="unreadURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
		<portlet:param name="mvcPath" value="/notifications/view_entries.jsp" />
		<portlet:param name="filter" value="unread" />
	</portlet:renderURL>

	renderUserNotificationsList('<%= unreadURL %>');

	var userNotificationsSidebar = userNotifications.one('.user-notifications-sidebar');

	var unreadNav = userNotificationsSidebar.one('.unread');

	if (unreadNav) {
		unreadNav.on(
			'click',
			function(event) {
				renderUserNotificationsList('<%= unreadURL %>');

				A.io.request('<liferay-portlet:actionURL name="setDelivered" />');

				userNotificationsSidebar.all('.nav a').removeClass('selected');

				unreadNav.addClass('selected');
			}
		);
	}

	var allNotificationsNav = userNotificationsSidebar.one('.all-notifications');

	if (allNotificationsNav) {
		allNotificationsNav.on(
			'click',
			function(event) {
				<portlet:renderURL var="allNotificationsURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
					<portlet:param name="mvcPath" value="/notifications/view_entries.jsp" />
				</portlet:renderURL>

				renderUserNotificationsList('<%= allNotificationsURL %>');

				A.io.request('<liferay-portlet:actionURL name="setDelivered" />');

				userNotificationsSidebar.all('.nav a').removeClass('selected');

				allNotificationsNav.addClass('selected');
			}
		);
	}

	var manageNav = userNotificationsSidebar.one('.manage');

	if (manageNav) {
		manageNav.on(
			'click',
			function(event) {
				<portlet:renderURL var="configurationURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
					<portlet:param name="mvcPath" value="/notifications/configuration.jsp" />
				</portlet:renderURL>

				renderUserNotificationsList('<%= configurationURL %>');

				userNotificationsSidebar.all('.nav a').removeClass('selected');

				manageNav.addClass('selected');
			}
		);
	}

	userNotificationsList.delegate(
		'click',
		function(event) {
			Liferay.Notifications.viewNotification(event);
		},
		'.user-notification .user-notification-link'
	);
</aui:script>