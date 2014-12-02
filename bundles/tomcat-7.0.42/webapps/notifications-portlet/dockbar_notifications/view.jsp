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

<c:if test="<%= PortletPropsValues.NOTIFICATIONS_DOCKBAR_DISPLAY_ENABLED %>">

	<%
	int newUserNotificationsCount = UserNotificationEventLocalServiceUtil.getDeliveredUserNotificationEventsCount(themeDisplay.getUserId(), false);
	int unreadUserNotificationsCount = UserNotificationEventLocalServiceUtil.getArchivedUserNotificationEventsCount(themeDisplay.getUserId(), false);
	%>

	<li class="dockbar-user-notifications dropdown toggle-controls" id="<portlet:namespace />userNotifications">
		<a class="dropdown-toggle user-notification-link" href="javascript:;">
			<span class='user-notifications-count <%= (newUserNotificationsCount > 0) ? "alert" : StringPool.BLANK %>' id="<portlet:namespace />userNotificationsCount"><%= unreadUserNotificationsCount %></span>
		</a>

		<ul class="dropdown-menu pull-right user-notifications-list"></ul>

		<aui:script use="aui-base,aui-io-plugin-deprecated,liferay-poller">
			var userNotifications = A.one('#<portlet:namespace />userNotifications');

			var userNotificationsCount = userNotifications.one('#<portlet:namespace />userNotificationsCount');

			var onPollerUpdate = function(response, chunkId) {
				var newUserNotificationsCount = Number(response.newUserNotificationsCount);
				var unreadUserNotificationsCount = Number(response.unreadUserNotificationsCount);

				userNotificationsCount.toggleClass('alert', (newUserNotificationsCount > 0));

				userNotificationsCount.setHTML(unreadUserNotificationsCount);
			};

			A.on(
				'domready',
				function() {
					Liferay.Poller.addListener('<%= PortletKeys.DOCKBAR_NOTIFICATIONS %>', onPollerUpdate, this);
				}
			);

			var userNotificationsList = userNotifications.one('.dropdown-menu');

			if (!userNotificationsList.io) {
				userNotificationsList.plug(
					A.Plugin.IO,
					{
						autoLoad: false
					}
				);
			}

			userNotifications.on(
				'click',
				function(event) {
					var currentTarget = event.currentTarget;

					var target = event.target;

					var handle = Liferay.Data['<portlet:namespace />userNotificationsHandle'];

					if (!target.hasClass('user-notification') && !target.ancestor('.user-notification')) {
						currentTarget.toggleClass('open');

						var menuOpen = currentTarget.hasClass('open');

						if (menuOpen && !handle) {
							handle = currentTarget.on(
								'clickoutside',
								function(event) {
									Liferay.Data['<portlet:namespace />userNotificationsHandle'] = null;

									handle.detach();

									currentTarget.removeClass('open');
								}
							);
						}
						else if (handle) {
							handle.detach();

							handle = null;
						}

						Liferay.Data['<portlet:namespace />userNotificationsHandle'] = handle;

						if (menuOpen) {
							<portlet:renderURL var="unreadURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
								<portlet:param name="mvcPath" value="/notifications/view_entries.jsp" />
								<portlet:param name="filter" value="unread" />
								<portlet:param name="fullView" value="false" />
							</portlet:renderURL>

							userNotificationsList.io.set('uri', '<%= unreadURL %>');

							userNotificationsList.io.start();

							A.io.request('<liferay-portlet:actionURL name="setDelivered" />');

							userNotificationsCount.removeClass('alert');
						}

					}
				}
			);

			userNotificationsList.delegate(
				'click',
				function(event) {
					Liferay.Notifications.viewNotification(event);
				},
				'.user-notification .user-notification-link'
			);
		</aui:script>
	</li>
</c:if>