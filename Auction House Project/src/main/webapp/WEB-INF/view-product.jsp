<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <c:set value="${product}" var="prod"/>
        <c:set value="${bids}" var="bid"/>
<form role="form" method="post">


<div>
    <label id="prod_name" > ${prod.name}</label>
    <label id="description" >${prod.artist}</label>
</div>
    <label for="prod_value" id="prod_value" >The bid value must be greater that ${prod.value}</label>
    <input type="text" id="bidVal" name="bidVal" placeholder="Bid value">
<button> Make a bid </button>

    </form>
</div>
</div>
</body>
</html>