<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <li><a href="/mainpage/${user.id}/orders">Orderes</a></li>
                <li><a href="/mainpage/logout" class="bn">Logout</a></li>
            </ul>
        </div>
    </div>

</div>
<div id="content_header"></div>
<div id="site_content">
    <table class="table table-striped">
        <tr>
            <th>Order id</th>
            <th>Order number</th>
            <th>Total value</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${user.orders}" var="orders">

            <tr>

                <td><c:out value="${orders.oder_id}" /></td>
                <td><c:out value="${orders.number}" /></td>
                <td><c:out value="${orders.value}" /></td>
                <td>
                    <a href="<c:url value="orders/${orders.oder_id}/details"/>" class="btn btn-warning">View</a>

                </td>
                </td>
            </tr>
        </c:forEach>


    </table>

</div>
</div>
</body>
</html>
