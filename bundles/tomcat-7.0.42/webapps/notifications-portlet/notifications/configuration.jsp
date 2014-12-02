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

<div class="manage-notifications">
	<div class="title">
		<div class="notification-delivery">
			<span><liferay-ui:message key="notification-delivery" /></span>
		</div>

		<div class="receive-notification">
			<span><liferay-ui:message key="receive-a-notification-when-someone" /></span>
		</div>
	</div>

	<%
	Map<String, List<UserNotificationDefinition>> userNotificationDefinitionsMap = UserNotificationManagerUtil.getUserNotificationDefinitions();

	for (Map.Entry<String, List<UserNotificationDefinition>> entry : userNotificationDefinitionsMap.entrySet()) {
		String portletId = entry.getKey();

		Portlet portlet = PortletLocalServiceUtil.getPortletById(portletId);
	%>

		<table class="notification-deliveries table table-condensed">
			<caption><%= portlet.getDisplayName() %></caption>
			<tbody>

			<%
			List<UserNotificationDefinition> userNotificationDefinitions = entry.getValue();

			for (UserNotificationDefinition userNotificationDefinition : userNotificationDefinitions) {
			%>

				<tr>
					<td class="span8">
						<liferay-ui:message key="<%= userNotificationDefinition.getDescription() %>" />
					</td>

					<%
					Map<Integer, UserNotificationDeliveryType> userNotificationDeliveryTypesMap = userNotificationDefinition.getUserNotificationDeliveryTypes();

					for (Map.Entry<Integer, UserNotificationDeliveryType> userNotificationDeliveryTypeEntry : userNotificationDeliveryTypesMap.entrySet()) {
						UserNotificationDeliveryType userNotificationDeliveryType = userNotificationDeliveryTypeEntry.getValue();

						UserNotificationDelivery userNotificationDelivery = UserNotificationDeliveryLocalServiceUtil.getUserNotificationDelivery(themeDisplay.getUserId(), portletId, userNotificationDefinition.getClassNameId(), userNotificationDefinition.getNotificationType(), userNotificationDeliveryType.getType(), userNotificationDeliveryType.isDefault());
					%>

						<td class="span1">
							<aui:input cssClass="notification-delivery" data-userNotificationDeliveryId="<%= String.valueOf(userNotificationDelivery.getUserNotificationDeliveryId()) %>" inlineLabel="true" label="<%= userNotificationDeliveryType.getName() %>" name="<%= String.valueOf(userNotificationDelivery.getUserNotificationDeliveryId()) %>" type="checkbox" value="<%= userNotificationDelivery.isDeliver() %>" />
						</td>

					<%
					}
					%>

				</tr>

			<%
			}
			%>

			</tbody>
		</table>

	<%
	}
	%>

</div>

<aui:script use="aui-base,aui-io-request">
	var userNotifications = A.one('#portlet_<%= PortletKeys.NOTIFICATIONS %>');

	var notificationDelivery = userNotifications.one('.manage-notifications');

	if (notificationDelivery) {
		notificationDelivery.delegate(
			'change',
			function(event) {
				event.preventDefault();

				var currentTarget = event.currentTarget;

				A.io.request(
					'<portlet:actionURL name="updateUserNotificationDelivery" />',
					{
						data: {
							<portlet:namespace />deliver: currentTarget.attr('checked'),
							<portlet:namespace />userNotificationDeliveryId: currentTarget.attr('data-userNotificationDeliveryId')
						}
					}
				);
			},
			'.notification-deliveries .notification-delivery'
		);
	}
</aui:script>