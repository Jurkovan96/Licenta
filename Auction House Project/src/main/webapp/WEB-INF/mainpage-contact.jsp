
<%--
  Created by IntelliJ IDEA.
  User: jurko
  Date: 4/8/2020
  Time: 9:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>colour_orange - contact us</title>
    <meta name="description" content="website description" />
    <meta name="keywords" content="website keywords, website keywords" />
    <meta http-equiv="content-type" content="text/html; charset=windows-1252" />
    <link rel="stylesheet" type="text/css" href="/static/css/style.css" title="style" />
</head>

<body>
<div id="main">
    <div id="header">
        <div id="logo">
            <div id="logo_text">
                <!-- class="logo_colour", allows you to change the colour of the text -->
                <h1><a href="index.html">colour<span class="logo_colour">orange</span></a></h1>
                <h2>Simple. Contemporary. Website Template.</h2>
            </div>
        </div>
        <div id="menubar">
            <ul id="menu">

                <c:set value="${user}" var="user"/>
                <li><a href="/mainpage/${user.id}">Home</a></li>
                <li><a href="/mainpage/${user.id}/products">Art</a></li>
                <li><a href="/mainpage/${user.id}/about">About</a></li>
                <li><a href="/mainpage/${user.id}/contact" >Contact</a></li>
                <li><a href="/mainpage/${user.id}/settings" >Settings</a></li>
                <li><a href="/mainpage/logout" class="bn">Logout</a></li>
            </ul>
        </div>
    </div>
    <div id="content_header"></div>
    <div id="site_content">
        <h2>Bids for ${user.name}</h2>


        <table class="table table-striped">
            <tr>
                <th>Number</th>
                <th>Value</th>
                <th>Actions</th>
            </tr>
<%--            <c:forEach items="${user.bids}" var="bids">--%>
              <tr>
                <td><c:out value="${user.name}" /></td>
                <td><c:out value="${user.bids}" /></td>
                <td><c:out value="${user.id}" /></td>

              </tr>
<%--            </c:forEach>--%>

        </table>

    </div>
   </div>
 </body>
</html>
