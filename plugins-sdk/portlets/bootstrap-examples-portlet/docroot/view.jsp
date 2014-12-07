<%
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
%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<%
/*
Using Bootstrap 2.3.2 create a simple HTML markup for displaying two pictures.
*/
%>

<img src="http://i.imgur.com/xVh3K56.jpg?1" alt="The Weihnachtsmarkt from Frankfurt" />
<img src="http://i.imgur.com/RfNp6fl.jpg?1" alt="Santa Claus" />

<%
/*
Using Bootstrap 2.3.2 aui taglibs, create an Bootstrap navbar  http://getbootstrap.com/2.3.2/components.html#navbar
Please include a dropdown someone in the navbar
You can make the navitems direct the user anywhere
*/
%>

<%
/*
Use the main.css in this portlet to style the navbar to look like the navbar from this website.
http://bootswatch.com/flatly/#navbar
*/
%>

<%
/*
EXTRA CREDIT

Using Bootstrap 3 to create the same column and navbar from the first two examples.
Please make a unique layout for the mobile viewport.
See Bootstrap 3 documentation for help
http://getbootstrap.com/

See conversion guide from bootstrap 2 to 3 for more help.
http://www.bootply.com/bootstrap-3-migration-guide
*/
%>

<%--
<script src="http://cdn.alloyui.com/3.0.0/aui/aui-min.js"></script>
<link href="http://cdn.alloyui.com/3.0.0/aui-css/css/bootstrap.min.css" rel="stylesheet"></link>
---%>