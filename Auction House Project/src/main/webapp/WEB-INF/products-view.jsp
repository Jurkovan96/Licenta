<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

    <div id="site_content">


        <table class="table table-striped">
            <tr>
                <th>Product</th>
                <th>Value</th>
                <th>Date</th>
                <th>Image</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${user.bids}" var="bidd">
                <tr>
                <c:forEach items="${bidd.bidProductList}" var="productss">
                    <td><c:out value="${bidd.user_id}" /></td>
                    <td><c:out value="${bidd.bid_id}" /></td>
                    <td><c:out value="${productss.product.name}" /></td>
                    <td>

                        <form id="formButtonsBids" role="form" method="post">
                            <a href="<c:url value="/mainpage/${user.id}/about/${bidd.bid_id}/delete"/> " class="btn btn-info">Delete</a>

                        </form>
                    </td>
                    </td>
                    </tr>
                </c:forEach>

            </c:forEach>
        </table>




    </div>
</div>

</div>
</body>
</html>
