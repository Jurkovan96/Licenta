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
                    <ul id="userSettings">
                        <li><a href="/mainpage/${user.id}/settings">Edit user data</a></li>
                        <li><a href="/mainpage/${user.id}/settings/edit-adress">Edit adress</a></li>
                    </ul>

                </div>
            </a>

        </div>
    </div>
    <div id="header">
        <div id="logo">
            <div id="logo_text">

                <h1><a href="index.html">colour<span class="logo_colour">orange</span></a></h1>
                <h2>Simple. Contemporary. Website Template.</h2>
            </div>
        </div>

        <c:set value="${user.id}" var="user_id"/>
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

        <h2>Edit Adress </h2>

        <c:if test="${not empty error}">
            <div class="alert alert-danger">Error: ${error}</div>
        </c:if>

        <form class="form-horizontal" role="form" method="post" action="/mainpage/${user.id}/settings/edit-adress">
            <c:set value="${adress}" var="add"/>
            <label class="control-label col-sm-2" for="adressCountrt">Country:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="adressCountrt" name="country"
                       value="<c:out value="${add.country}"/>"/>
            </div>
            <label class="control-label col-sm-2" for="adressCity">City:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="adressCity" name="city" value="<c:out value="${add.city}"/>"/>
            </div>

            <label class="control-label col-sm-2" for="addresStreet">Street:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="addresStreet" name="street"
                       value="<c:out value="${add.street}"/>"/>
            </div>

            <label class="control-label col-sm-2" for="adressNumber">Number:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="adressNumber" name="number"
                       value="<c:out value="${add.number}"/>"/>
            </div>
            <br>

            <button class="btn btn-primary">Save</button>
        </form>
    </div>
</div>


</div>
</div>
</body>
</html>

