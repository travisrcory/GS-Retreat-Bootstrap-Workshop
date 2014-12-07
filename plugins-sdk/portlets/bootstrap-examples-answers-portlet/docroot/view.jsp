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

<div class="row-fluid bootstrap-workshop-image">
	<div class="span6 image-container">
		<img src="http://i.imgur.com/xVh3K56.jpg?1" alt="The Weihnachtsmarkt from Frankfurt" />
	</div>
	<div class="span6 image-container">
		<img src="http://i.imgur.com/RfNp6fl.jpg?1" alt="Santa Claus" />
	</div>
</div>

<%
/*
Using Bootstrap 2.3.2 aui taglibs, create an Bootstrap navbar  http://getbootstrap.com/2.3.2/components.html#navbar
Please include a dropdown someone in the navbar
You can make the navitems direct the user anywhere
*/
%>
<aui:nav-bar cssClass="bootstrap-workshop-navbar">
	<aui:nav>
		<aui:nav-item cssClass="bootstrap-workshop-nav-item" href="http://www.noradsanta.org/" label="Santa Tracker" />
		<aui:nav-item cssClass="bootstrap-workshop-nav-item" href="http://en.wikipedia.org/wiki/Santa_Claus" label="Santa's History" />
		<aui:nav-item dropdown="<%= true %>" label="Weihnachtsmarkt">
			<aui:nav-item cssClass="bootstrap-workshop-dropdown-nav-item" href="http://www.dresden.de/de/05/02/veranstaltungen/04-Weihnachten-in-Dresden.php?shortcut=Striezelmarkt" label="Dresden" />
			<aui:nav-item cssClass="bootstrap-workshop-dropdown-nav-item" href="http://www.frankfurt-tourismus.de/cms/tourismussuite/de/messen_frankfurt_veranstaltungen/weihnachtsmarkt_weihnachten_frankfurt.html" label="Frankfurt" />
			<aui:nav-item cssClass="bootstrap-workshop-dropdown-nav-item" href="http://www.heidelberg-marketing.de/events/highlights-in-heidelberg/heidelberger-weihnachtsmarkt.html/" label="Heidelberg" />
		</aui:nav-item>
	</aui:nav>
<aui:nav-bar/>

<%
/*
Use the main.css in this portlet to style the navbar to look like the navbar from this website.
http://bootswatch.com/flatly/#navbar
*/
%>

<%
/*
EXTRA CREDIT

Convert the first example of pictures into taglibs

Using Bootstrap 3 to create the same column and navbar from the first two examples.
Please make a unique layout for the mobile viewport.
See Bootstrap 3 documentation for help
http://getbootstrap.com/

See conversion guide from bootstrap 2 to 3 for more help.
http://www.bootply.com/bootstrap-3-migration-guide
*/
%>

<%--- Taglib Example

<aui:row cssClass='bootstrap-workshop-image'>
	<aui:col cssClass="image-container" span="6">
		<img src="http://i.imgur.com/xVh3K56.jpg?1" alt="The Weihnachtsmarkt from Frankfurt" />
	</aui:col>

	<aui:col cssClass="image-container" span="6">
		<img src="http://i.imgur.com/RfNp6fl.jpg?1" alt="Santa Claus" />
	</aui:col>
</aui:row>

---%>

<%--- Bootstrap 3

<script src="http://cdn.alloyui.com/3.0.0/aui/aui-min.js"></script>
<link href="http://cdn.alloyui.com/3.0.0/aui-css/css/bootstrap.min.css" rel="stylesheet"></link>

<div class="row bootstrap-workshop-image">
	<div class="col-md-6 col-xs-8 col-lg-12 image-container">
		<img src="http://i.imgur.com/xVh3K56.jpg?1" alt="The Weihnachtsmarkt from Frankfurt" class="img-responsive" />
	</div>
	<div class="col-md-6 col-xs-4 col-lg-12 image-container">
		<img src="http://i.imgur.com/RfNp6fl.jpg?1" alt="Santa Claus" class="img-responsive" />
	</div>
</div>

<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="icon-bar"></span>
			</button>
		</div>

		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="bootstrap-workshop-dropdown-nav-item"><a href="http://www.noradsanta.org/">Santa Tracker</a></li>
				<li class="bootstrap-workshop-dropdown-nav-item"><a href="http://en.wikipedia.org/wiki/Santa_Claus">Santa's History</a></li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Dropdown <span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li class="bootstrap-workshop-dropdown-nav-item"><a href="http://www.dresden.de/de/05/02/veranstaltungen/04-Weihnachten-in-Dresden.php?shortcut=Striezelmarkt">Dresden</a></li>
						<li class="bootstrap-workshop-dropdown-nav-item"><a href="http://www.frankfurt-tourismus.de/cms/tourismussuite/de/messen_frankfurt_veranstaltungen/weihnachtsmarkt_weihnachten_frankfurt.html">Frankfurt</a></li>
						<li class="bootstrap-workshop-dropdown-nav-item"><a href="http://www.heidelberg-marketing.de/events/highlights-in-heidelberg/heidelberger-weihnachtsmarkt.html/">Heidelberg</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</nav>

---%>
