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

<%@ include file="/html/portlet/group_statistics/init.jsp" %>

<%
for (int displayActivityCounterNameIndex : displayActivityCounterNameIndexes) {
	String displayActivityCounterName = PrefsParamUtil.getString(portletPreferences, request, "displayActivityCounterName" + displayActivityCounterNameIndex);

	if (Validator.isNull(displayActivityCounterName)) {
		continue;
	}

	String chartType = PrefsParamUtil.getString(portletPreferences, request, "chartType" + displayActivityCounterNameIndex, "area");
	int chartWidth = PrefsParamUtil.getInteger(portletPreferences, request, "chartWidth" + displayActivityCounterNameIndex, 35);
	String dataRange = PrefsParamUtil.getString(portletPreferences, request, "dataRange" + displayActivityCounterNameIndex, "year");

	List<AssetTag> assetTags = null;

	List<SocialActivityCounter> activityCounters = null;

	String title = LanguageUtil.get(pageContext, "site-statistics") + StringPool.SPACE;

	int dataSize = 0;
	int displayHeight = 80;

	if (chartType.equals("tag-cloud")) {
		if (dataRange.equals("year")) {
			assetTags = AssetTagLocalServiceUtil.getSocialActivityCounterPeriodTags(scopeGroupId, displayActivityCounterName, SocialCounterPeriodUtil.getFirstActivityDayOfYear(), SocialCounterPeriodUtil.getEndPeriod());
		}
		else {
			assetTags = AssetTagLocalServiceUtil.getSocialActivityCounterOffsetTags(scopeGroupId, displayActivityCounterName, -12, 0);
		}

		title = title + LanguageUtil.format(pageContext, "tag-cloud-for-x", new Object[] {LanguageUtil.get(pageContext, "group.statistics.title." + displayActivityCounterName)});

		dataSize = assetTags.size();
	}
	else {
		if (chartType.equals("pie")) {
			if (dataRange.equals("year")) {
				activityCounters = SocialActivityCounterLocalServiceUtil.getPeriodDistributionActivityCounters(scopeGroupId, displayActivityCounterName, SocialCounterPeriodUtil.getFirstActivityDayOfYear(), SocialCounterPeriodUtil.getEndPeriod());
			}
			else {
				activityCounters = SocialActivityCounterLocalServiceUtil.getOffsetDistributionActivityCounters(scopeGroupId, displayActivityCounterName, -12, 0);
			}

			displayHeight = Math.max((activityCounters.size() + 1) * 18, displayHeight);
		}
		else {
			if (dataRange.equals("year")) {
				activityCounters = SocialActivityCounterLocalServiceUtil.getPeriodActivityCounters(scopeGroupId, displayActivityCounterName, SocialCounterPeriodUtil.getFirstActivityDayOfYear(), SocialCounterPeriodUtil.getEndPeriod());
			}
			else {
				activityCounters = SocialActivityCounterLocalServiceUtil.getOffsetActivityCounters(scopeGroupId, displayActivityCounterName, -12, 0);
			}
		}

		dataSize = activityCounters.size();

		title = title + LanguageUtil.get(pageContext, "group.statistics.title." + displayActivityCounterName);
	}

	if (dataSize == 0) {
		displayHeight = 40;
	}
%>

	<div class="group-statistics-container">
		<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" id='<%= "groupStatisticsPanel" + displayActivityCounterNameIndex %>' persistState="<%= true %>" title="<%= title %>">
			<div class="group-statistics-body chart-<%= HtmlUtil.escapeAttribute(chartType) %>" style="min-height: <%= displayHeight %>px;">
				<c:choose>
					<c:when test="<%= dataSize > 0 %>">
						<c:choose>
							<c:when test='<%= chartType.equals("pie") %>'>
								<%@ include file="/html/portlet/group_statistics/chart/pie.jspf" %>
							</c:when>
							<c:when test='<%= chartType.equals("tag-cloud") %>'>
								<%@ include file="/html/portlet/group_statistics/chart/tag_cloud.jspf" %>
							</c:when>
							<c:otherwise>
								<%@ include file="/html/portlet/group_statistics/chart/other.jspf" %>
							</c:otherwise>
						</c:choose>
					</c:when>
					<c:otherwise>
						<div class="alert alert-info portlet-configuration">
							<liferay-ui:message key="there-is-not-enough-data-to-display-for-this-counter" />
						</div>
					</c:otherwise>
				</c:choose>
			</div>
		</liferay-ui:panel>
	</div>

<%
}
%>

<c:if test="<%= Validator.isNull(displayActivityCounterNameIndexesParam) %>">
	<div class="alert alert-info portlet-configuration">
		<a href="<%= portletDisplay.getURLConfiguration() %>" onClick="<%= portletDisplay.getURLConfigurationJS() %>">
			<liferay-ui:message key="please-configure-this-portlet-and-select-at-least-one-activity-counter" />
		</a>
	</div>
</c:if>