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

<%@ include file="/html/portlet/journal/init.jsp" %>

<%
String defaultLanguageId = (String)request.getAttribute("edit_article.jsp-defaultLanguageId");

JournalArticle article = (JournalArticle)request.getAttribute(WebKeys.JOURNAL_ARTICLE);

String type = BeanParamUtil.getString(article, request, "type");

if (Validator.isNull(type)) {
	type = "general";
}

String toLanguageId = (String)request.getAttribute("edit_article.jsp-toLanguageId");
%>

<liferay-ui:error-marker key="errorSection" value="categorization" />

<aui:model-context bean="<%= article %>" model="<%= JournalArticle.class %>" />

<h3><liferay-ui:message key="categorization" /></h3>

<c:if test="<%= Validator.isNull(toLanguageId) %>">
	<liferay-ui:asset-categories-error />

	<liferay-ui:asset-tags-error />
</c:if>

<liferay-ui:error exception="<%= ArticleTypeException.class %>" message="please-select-a-type" />

<aui:fieldset>
	<aui:select name="type" showEmptyOption="<%= true %>">

		<%
		for (int i = 0; i < JournalArticleConstants.TYPES.length; i++) {
		%>

			<aui:option label="<%= JournalArticleConstants.TYPES[i] %>" selected="<%= type.equals(JournalArticleConstants.TYPES[i]) %>" />

		<%
		}
		%>

	</aui:select>

	<%
	long classPK = 0;

	if (article != null) {
		classPK = article.getResourcePrimKey();

		if (!article.isApproved() && (article.getVersion() != JournalArticleConstants.VERSION_DEFAULT)) {
			try {
				AssetEntryLocalServiceUtil.getEntry(JournalArticle.class.getName(), article.getPrimaryKey());

				classPK = article.getPrimaryKey();
			}
			catch (NoSuchEntryException nsee) {
			}
		}
	}
	%>

	<aui:input classPK="<%= classPK %>" name="categories" type="assetCategories" />

	<aui:input classPK="<%= classPK %>" name="tags" type="assetTags" />
</aui:fieldset>

<aui:script>
	function <portlet:namespace />getSuggestionsContent() {
		return document.<portlet:namespace />fm1.<portlet:namespace />title_<%= defaultLanguageId %>.value;
	}
</aui:script>