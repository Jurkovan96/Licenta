<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <div id="content_header"></div>
    <div id="site_content">
        <c:set value="${product}" var="prod"/>
        <c:set value="${bids}" var="bid"/>
        <c:set value="${max_value}" var="maxV"/>


        <div class="Products">
            <img class="imagesForProducts" src="<c:out value="${product.url}"/>">
            <div class="details">
                <h2><c:out value="${product.name}"/></h2>
                <h5>Dimensions:<c:out value="${product.width}"/>x<c:out value="${product.lenght}"/></h5>

            </div>

        </div>


        <form id="detailsForm" role="form" method="post">

            <h4><c:out value="${product.description.desc}"/></h4>
            <h4>Made by: <c:out value="${product.artist}"/></h4>
            <h5>Tehnique used: <c:out value="${product.tehn}"/></h5>

            <br>
            <c:if test="${not empty maxV}">
                <label for="prod_value" id="prod_value"> Current max value per product is ${maxV}</label></c:if>
            <c:if test="${product.value > 0}">
                <br>
            <label for="prod_value" id="prod_value">The bid value must be greater
                than ${product.value}</label>
                </c:if>
            <br>
            <input type="text" id="bidVal" name="bidVal" placeholder="Bid value">
            <button>Add a bid</button>

        </form>
    </div>
</div>
</body>
</html>