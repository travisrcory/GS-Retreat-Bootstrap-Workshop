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

<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ContentTypes" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.LocaleUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>

<%@ page import="java.util.Locale" %>

<%
String attachmentURLPrefix = ParamUtil.getString(request, "attachmentURLPrefix");

String contentsLanguageId = ParamUtil.getString(request, "contentsLanguageId");

Locale contentsLocale = LocaleUtil.fromLanguageId(contentsLanguageId);

contentsLanguageId = LocaleUtil.toLanguageId(contentsLocale);

String cssClasses = ParamUtil.getString(request, "cssClasses");
String cssPath = ParamUtil.getString(request, "cssPath");

String languageId = ParamUtil.getString(request, "languageId");

Locale locale = LocaleUtil.fromLanguageId(languageId);

languageId = LocaleUtil.toLanguageId(locale);

String name = ParamUtil.getString(request, "name");
boolean resizable = ParamUtil.getBoolean(request, "resizable");
long wikiPageResourcePrimKey = ParamUtil.getLong(request, "wikiPageResourcePrimKey");

response.setContentType(ContentTypes.TEXT_JAVASCRIPT);
%>

;(function() {
	var ckEditor = CKEDITOR.instances['<%= HtmlUtil.escapeJS(name) %>'];

	var config = ckEditor.config;

	config.attachmentURLPrefix = '<%= HtmlUtil.escapeJS(attachmentURLPrefix) %>';

	config.bodyClass = 'html-editor <%= HtmlUtil.escapeJS(cssClasses) %>';

	config.contentsCss = ['<%= HtmlUtil.escapeJS(cssPath) %>/aui.css', '<%= HtmlUtil.escapeJS(cssPath) %>/main.css'];

	<%
	String contentsLanguageDir = LanguageUtil.get(contentsLocale, "lang.dir");
	%>

CKEDITOR.config.contentsLangDirection = '<%= HtmlUtil.escapeJS(contentsLanguageDir) %>';

	config.contentsLanguage = '<%= contentsLanguageId.replace("iw_", "he_") %>';

	config.decodeLinks = true;

	config.disableObjectResizing = true;

	config.extraPlugins = 'creole,wikilink';

	config.format_tags = 'p;h1;h2;h3;h4;h5;h6;pre';

	config.height = 265;

	config.language = '<%= languageId.replace("iw_", "he_") %>';

	config.removePlugins = [
		'elementspath',
		'save',
		'font',
		'bidi',
		'colordialog',
		'colorbutton',
		'div',
		'flash',
		'font',
		'forms',
		'justify',
		'keystrokes',
		'link',
		'maximize',
		'newpage',
		'pagebreak',
		'preview',
		'print',
		'save',
		'smiley',
		'showblocks',
		'stylescombo',
		'templates',
		'video'
	].join();

	<c:if test="<%= resizable %>">
		config.resize_dir = 'vertical';
	</c:if>

	config.resize_enabled = <%= resizable %>;

	config.toolbar_creole = [
		['Cut','Copy','Paste','PasteText','PasteFromWord'],
		['Undo','Redo'],
		['Bold', 'Italic', '-', 'NumberedList', 'BulletedList', '-', 'Outdent', 'Indent'],
		['Format'],

		<%
		String linkButtonBar = "['Link', 'Unlink']";

		if (wikiPageResourcePrimKey > 0) {
			linkButtonBar = "['Link', 'Unlink', 'Image']";
		}
		%>

		<%= linkButtonBar %>,

		['Table', '-', 'HorizontalRule', 'SpecialChar' ],
		['Find','Replace','-','SelectAll','RemoveFormat'],
		['Source']
	];

	config.toolbar_phone = [
		['Bold', 'Italic', 'Underline'],
		['NumberedList', 'BulletedList'],
		['Image', 'Link', 'Unlink']
	];

	config.toolbar_tablet = [
		['Bold', 'Italic', 'Underline', 'Strike'],
		['NumberedList', 'BulletedList'],
		['Image', 'Link', 'Unlink'],
		['JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock'],
		['Styles', 'FontSize']
	];

	ckEditor.on(
		'dialogDefinition',
		function(event) {
			var dialogName = event.data.name;

			var dialogDefinition = event.data.definition;

			var infoTab;

			if (dialogName === 'cellProperties') {
				infoTab = dialogDefinition.getContents('info');

				infoTab.remove('bgColor');
				infoTab.remove('bgColorChoose');
				infoTab.remove('borderColor');
				infoTab.remove('borderColorChoose');
				infoTab.remove('colSpan');
				infoTab.remove('hAlign');
				infoTab.remove('height');
				infoTab.remove('htmlHeightType');
				infoTab.remove('rowSpan');
				infoTab.remove('vAlign');
				infoTab.remove('width');
				infoTab.remove('widthType');
				infoTab.remove('wordWrap');

				dialogDefinition.minHeight = 40;
				dialogDefinition.minWidth = 210;
			}
			else if (dialogName === 'table' || dialogName === 'tableProperties') {
				infoTab = dialogDefinition.getContents('info');

				infoTab.remove('cmbAlign');
				infoTab.remove('cmbWidthType');
				infoTab.remove('cmbWidthType');
				infoTab.remove('htmlHeightType');
				infoTab.remove('txtBorder');
				infoTab.remove('txtCellPad');
				infoTab.remove('txtCellSpace');
				infoTab.remove('txtHeight');
				infoTab.remove('txtSummary');
				infoTab.remove('txtWidth');

				dialogDefinition.minHeight = 180;
				dialogDefinition.minWidth = 210;
			}
		}
	);
})();
