<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>colour_orange - contact us</title>
    <meta name="description" content="website description" />
    <meta name="keywords" content="website keywords, website keywords" />
    <meta http-equiv="content-type" content="text/html; charset=windows-1252" />
    <link rel="stylesheet" type="text/css" href="/static/css/style.css" title="style" />
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <script type="text/javascript" src="/static/js/custom.js"></script>

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

</div>
<div id="content_header"></div>
<div id="site_content">


<%--    <form action="${}" method="get">--%>
<%--    <input id="txtSrc" type="text" name="keyword">--%>
<%--        <button type="submit" >Go</button>--%>
<%--    </form>--%>
<%--    <select name="productss id="selectProd">--%>
<%--    <c:forEach items="${products}" var="product1">--%>
<%--    <option value="${product1.name}">${product1.name}</option>--%>
<%--    </c:forEach>--%>
<%--        </select>--%>

    <table class="table table-striped">
        <tr>
            <th>Name</th>
            <th>Image</th>
            <th>Artist</th>
            <th>Year</th>
            <th>Tehnique</th>
            <th>Starting bid value</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${products}" var="product">
            <tr>
                <td><c:out value="${product.name}" /></td>
                <td><img src="<c:out value="${product.url}" />" width="200" height="150"></td>
                <td><c:out value="${product.artist}" /></td>
                <td><c:out value="${product.year}" /></td>
                <td><c:out value="${product.value}" /></td>
                <td><c:out value="${product.tehn}" /></td>
                <td>
                    <<a href="<c:url value="products/${product.id}&${product.name}/view"/>" class="button">View product</a>
                    <a href="<c:url value="/mainpage/${user.id}/about"/> " class="btn btn-info">Add bid</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    </div>
</div>
</body>
</html>
