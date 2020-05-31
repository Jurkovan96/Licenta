<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jurko
  Date: 4/10/2020
  Time: 8:07 PM
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
                <li><a href="/mainpage/${user.id}">Home Page</a></li>
                <li><a href="/mainpage/${user.id}/products">Art</a></li>
                <li><a href="/mainpage/${user.id}/about">Auctions</a></li>
                <li><a href="/mainpage/${user.id}/contact" >Your auctions</a></li>
                <li><a href="/mainpage/${user.id}/settings" >Account Settings</a></li>
                <li><a href="/mainpage/${user.id}/orders">Orders</a></li>
                <li><a href="/mainpage/logout" class="bn">Logout</a></li>
            </ul>
        </div>

    </div>
    <div id="content_header"></div>
    <div id="site_content">
        <table class="table table-striped">
            <tr>
                <th>Bid</th>
                <th>Value</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Status</th>
                <th>Product</th>
                <th>Actions</th>
            </tr>
                    <c:forEach items="${bids}" var="bidd">
                        <c:set value="${bidd.product}" var="product"/>
                <tr>

                    <td><c:out value="${bidd.bid_id}" /></td>
                    <td><c:out value="${bidd.bid_value}" /></td>
                    <td><c:out value="${bidd.start_date}" /></td>
                    <td><c:out value="${bidd.end_date}" /></td>
                    <td><c:out value="${bidd.state}" /></td>
                    <td><c:out value="${product.name}" /></td>
                    <td>

                        <form id="formButtonsBids" role="form" method="post">
                            <a href="<c:url value="/mainpage/${user.id}/about/${bidd.bid_id}/delete"/> "
                               class="btn btn-info">Delete</a>
                            <a href="<c:url value="/mainpage/${user.id}/about/${bidd.bid_id}/update"/> "
                               class="btn btn-info">Update</a>

                        </form>
                    </td>
                    </td>
                </tr>
                    </c:forEach>


        </table>

    </div>
</div>
</body>
</html>
