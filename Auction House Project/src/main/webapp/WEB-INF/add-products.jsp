<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View your Products</title>
    <meta name="description" content="website description"/>
    <meta name="keywords" content="website keywords, website keywords"/>
    <meta http-equiv="content-type" content="text/html; charset=windows-1252"/>
    <link rel="stylesheet" type="text/css" href="/static/css/style.css" title="style"/>


</head>

<body>
<div id="main">
    <div id="loggedUser">
        <div id="textBox">
            <h4 id="userText">Hello, <c:out value="${user.name}"/> !</h4>

            <a href="#">

                <div id="imgDiv">
                    <img id="imgSettings" src="/static/images/settingscolor.png" alt="Not found!" width="25px">
                    <p id="userSettings"><a href="/mainpage/${user.id}">Carte pagina principala</a></p>
                </div>
            </a>

        </div>
    </div>
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
                <li><a href="/mainpage/${user.id}/contact">Your auctions</a></li>
                <li><a href="/mainpage/${user.id}/settings">Account Settings</a></li>
                <li><a href="/mainpage/${user.id}/orders">Orders</a></li>
                <li><a href="/mainpage/logout" class="bn">Logout</a></li>
            </ul>
        </div>
    </div>

</div>
<div id="content_header"></div>
<div id="site_content">


    <c:forEach items="${owneProducts}" var="owP">
        <h4><c:out value="${owP.artist}"/></h4>
        <h4><c:out value="${owP.tehn}"/></h4>
        <h4><c:out value="${owP.name}"/></h4>
        <h4><c:out value="${owP.pay_value}"/></h4>
        <h4><c:out value="${owP.width}"/></h4>
        <h4><c:out value="${owP.lenght}"/></h4>
        <h4><c:out value="${owP.artist}"/></h4>
        <h4><c:out value="${owP.artist}"/></h4>

    </c:forEach>

    <c:forEach items="${ownedBids}" var="owB">
        <h4><c:out value="${owB.bid_value}"/></h4>
        <h4></h4>


    </c:forEach>

</div>

</body>
</html>