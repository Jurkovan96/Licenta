<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>colour_orange - contact us</title>
    <meta name="description" content="website description"/>
    <meta name="keywords" content="website keywords, website keywords"/>
    <meta http-equiv="content-type" content="text/html; charset=windows-1252"/>
    <link rel="stylesheet" type="text/css" href="/static/css/style.css" title="style"/>



</head>

<body>
<div id="main">
    <div id="header">
        <div id="logo">
            <div id="logo_text">

               <img id="logoImg" src="/static/images/VLogo.png">

            </div>
        </div>
        <div id="menubar">
            <ul id="menu">
                <c:set value="${user}" var="user"/>
                <li><a href="/mainpage/${user.id}">Home</a></li>
                <li><a href="/mainpage/${user.id}/products">Art</a></li>
                <li><a href="/mainpage/${user.id}/about">About</a></li>
                <li><a href="/mainpage/${user.id}/contact">Contact</a></li>
                <li><a href="/mainpage/${user.id}/settings">Settings</a></li>
                <li><a href="/mainpage/${user.id}/orders">Orderes</a></li>
                <li><a href="/mainpage/logout" class="bn">Logout</a></li>
            </ul>
        </div>
    </div>


    <div id="content_header"></div>
    <div id="site_content">


        <c:forEach items="${products}" var="product" varStatus="rowCounter">


        <div class="Products">
            <a href="<c:url value="products/${product.id}&${product.name}/view"/>"><img class="imagesForProducts" src="<c:out value="${product.url}"/>"></a>
            <div class="details">
                <h2><c:out value="${product.name}"/></h2>
                <h5>Dimensions:<c:out value="${product.width}"/>x<c:out value="${product.lenght}"/></h5>
            </div>

    </div>


    </c:forEach>


</body>
</html>
