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

<%
String filter = ParamUtil.getString(request, "filter");
boolean fullView = ParamUtil.getBoolean(request, "fullView", true);
int start = ParamUtil.getInteger(request, "start", 0);
int end = ParamUtil.getInteger(request, "end", delta);

List<UserNotificationEvent> userNotificationEvents = null;
int userNotificationEventsCount = 0;

if (filter.equals("unread")) {
	userNotificationEvents = UserNotificationEventLocalServiceUtil.getArchivedUserNotificationEvents(themeDisplay.getUserId(), false, start, end);
	userNotificationEventsCount = UserNotificationEventLocalServiceUtil.getArchivedUserNotificationEventsCount(themeDisplay.getUserId(), false);
}
else {
	userNotificationEvents = UserNotificationEventLocalServiceUtil.getUserNotificationEvents(themeDisplay.getUserId(), start, end);
	userNotificationEventsCount = UserNotificationEventLocalServiceUtil.getUserNotificationEventsCount(themeDisplay.getUserId());
}
%>

<c:choose>
	<c:when test="<%= userNotificationEvents.isEmpty() %>">
		<li class="message">
			<c:choose>
				<c:when test='<%= filter.equals("unread") %>'>
					<a><liferay-ui:message key="you-do-not-have-any-unread-notifications" /></a>
				</c:when>
				<c:otherwise>
					<a><liferay-ui:message key="you-do-not-have-any-notifications" /></a>
				</c:otherwise>
			</c:choose>
		</li>
	</c:when>
	<c:when test="<%= (userNotificationEventsCount > delta) && fullView %>">
		<li class="clearfix message top">
			<span class="left-nav <%= start == 0 ? "disabled" : "previous" %>"><a href="javascript:;"><liferay-ui:message key="previous" /></a></span>
			<span><liferay-ui:message arguments="<%= new Object[] {(start + 1), end, userNotificationEventsCount} %>" key="showing-x-x-of-x-results" translateArguments="<%= false %>" /></span>
			<span class="right-nav <%= userNotificationEventsCount <= end ? "disabled" : "next" %>"><a href="javascript:;"><liferay-ui:message key="next" /></a></span>
		</li>
	</c:when>
</c:choose>

<%
for (UserNotificationEvent userNotificationEvent : userNotificationEvents) {
	UserNotificationFeedEntry userNotificationFeedEntry = UserNotificationManagerUtil.interpret(StringPool.BLANK, userNotificationEvent, ServiceContextFactory.getInstance(request));

	if (userNotificationFeedEntry == null) {
		continue;
	}

	JSONObject userNotificationEventJSONObject = JSONFactoryUtil.createJSONObject(userNotificationEvent.getPayload());

	long userId = userNotificationEventJSONObject.getLong("userId");

	String userFullName = HtmlUtil.escape(PortalUtil.getUserName(userId, StringPool.BLANK));

	String userPortaitURL = StringPool.BLANK;

	User curUser = UserLocalServiceUtil.fetchUserById(userId);

	if (curUser != null) {
		userPortaitURL = curUser.getPortraitURL(themeDisplay);
	}

	boolean read = userNotificationEvent.isArchived();
%>

	<li class="user-notification<%= read ? "" : " unread" %>">
		<c:choose>
			<c:when test="<%= read %>">
				<div class="clearfix user-notification-link" data-href="<%= userNotificationFeedEntry.getLink() %>">
			</c:when>
			<c:otherwise>
				<liferay-portlet:actionURL name="markAsRead" var="markAsReadURL"><portlet:param name="userNotificationEventId" value="<%= String.valueOf(userNotificationEvent.getUserNotificationEventId()) %>" /></liferay-portlet:actionURL>

				<div class="clearfix user-notification-link" data-href="<%= userNotificationFeedEntry.getLink() %>" data-markAsReadURL="<%= markAsReadURL %>">
			</c:otherwise>
		</c:choose>

			<div class="sender">
				<span class="user-thumbnail">
					<img alt="<%= userFullName %>" src="<%= userPortaitURL %>" />
				</span>
			</div>

			<div class="content">
				<div class="body">
					<%= userNotificationFeedEntry.getBody() %>
				</div>

				<div class="timestamp">
					<span class="portlet-icon">
						<liferay-portlet:icon-portlet
							portlet="<%= PortletLocalServiceUtil.getPortletById(company.getCompanyId(), userNotificationEvent.getType()) %>"
						/>
					</span>

					<%= simpleDateFormat.format(userNotificationEvent.getTimestamp()) %>
				</div>

				<c:if test='<%= !filter.equals("unread") %>'>
					<div class="read">
						<liferay-ui:message key='<%= read ? "read" : "unread" %>' />
					</div>
				</c:if>
			</div>
		</div>
	</li>

<%
}
%>

<c:if test="<%= !userNotificationEvents.isEmpty() && fullView %>">
	<li class="clearfix message">
		<span class="left-nav <%= start == 0 ? "disabled" : "previous" %>"><a href="javascript:;"><liferay-ui:message key="previous" /></a></span>
		<span><liferay-ui:message arguments="<%= new Object[] {(start + 1), end, userNotificationEventsCount} %>" key="showing-x-x-of-x-results" translateArguments="<%= false %>" /></span>
		<span class="right-nav <%= userNotificationEventsCount <= end ? "disabled" : "next" %>"><a href="javascript:;"><liferay-ui:message key="next" /></a></span>
	</li>
</c:if>

<c:if test="<%= !fullView %>">

	<%
	long notificationsPlid = themeDisplay.getPlid();

	if (layout.isTypeControlPanel()) {
		notificationsPlid = LayoutLocalServiceUtil.getDefaultPlid(user.getGroupId(), true);

		if (notificationsPlid == LayoutConstants.DEFAULT_PLID) {
			Group guestGroup = GroupLocalServiceUtil.getGroup(user.getCompanyId(), GroupConstants.GUEST);

			notificationsPlid = LayoutLocalServiceUtil.getDefaultPlid(guestGroup.getGroupId(), false);
		}
	}
	%>

	<li class="bottom message">
		<liferay-portlet:renderURL plid="<%= notificationsPlid %>" portletName="<%= PortletKeys.NOTIFICATIONS %>" var="viewAllNotifications" windowState="<%= LiferayWindowState.MAXIMIZED.toString() %>">
			<portlet:param name="mvcPath" value="/notifications/view.jsp" />
		</liferay-portlet:renderURL>

		<a href="<%= viewAllNotifications %>"><liferay-ui:message key="view-all-notifications" /></a>
	</li>
</c:if>

<aui:script use="aui-base,aui-io-plugin-deprecated">
	<c:if test='<%= filter.equals("unread") %>'>
		var unreadCount = A.one('#portlet_<%= PortletKeys.NOTIFICATIONS %> .user-notifications-sidebar .unread .count');

		if (unreadCount) {
			unreadCount.setHTML('<%= userNotificationEventsCount %>');
		}
	</c:if>

	var userNotificationsList = A.one('#portlet_<%= PortletKeys.NOTIFICATIONS %> .user-notifications-list-container .user-notifications-list');

	if (userNotificationsList) {
		userNotificationsList.delegate(
			'click',
			function(event) {
				event.preventDefault();

				if (userNotificationsList) {
					if (!userNotificationsList.io) {
						userNotificationsList.plug(
							A.Plugin.IO,
							{
							autoLoad: false
							}
						);
					}

					<portlet:renderURL var="nextURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
						<portlet:param name="mvcPath" value="/notifications/view_entries.jsp" />
						<portlet:param name="filter" value="<%= filter %>" />
						<portlet:param name="fullView" value="<%= String.valueOf(fullView) %>" />
						<portlet:param name="start" value="<%= String.valueOf(start + delta) %>" />
						<portlet:param name="end" value="<%= String.valueOf(end + delta) %>" />
					</portlet:renderURL>

					userNotificationsList.io.set('uri', '<%= nextURL %>');
					userNotificationsList.io.start();
				}
			},
			'.message .next a'
		);

		userNotificationsList.delegate(
			'click',
			function(event) {
				event.preventDefault();

				if (userNotificationsList) {
					if (!userNotificationsList.io) {
						userNotificationsList.plug(
							A.Plugin.IO,
							{
							autoLoad: false
							}
						);
					}

					<portlet:renderURL var="previousURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
						<portlet:param name="mvcPath" value="/notifications/view_entries.jsp" />
						<portlet:param name="filter" value="<%= filter %>" />
						<portlet:param name="fullView" value="<%= String.valueOf(fullView) %>" />
						<portlet:param name="start" value="<%= String.valueOf(start - delta) %>" />
						<portlet:param name="end" value="<%= String.valueOf(end - delta) %>" />
					</portlet:renderURL>

					userNotificationsList.io.set('uri', '<%= previousURL %>');
					userNotificationsList.io.start();
				}
			},
			'.message .previous a'
		);
	}
</aui:script>