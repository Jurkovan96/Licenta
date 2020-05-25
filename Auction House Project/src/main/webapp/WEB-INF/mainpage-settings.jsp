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
                <li><a href="/mainpage/${user.id}/orders">Orderes</a></li>
                <li><a href="/mainpage/logout" class="bn">Logout</a></li>
            </ul>
        </div>
    </div>
    <div id="content_header"></div>
    <div id="site_content">

        <h2>Edit user data</h2>
            <!-- insert your sidebar items here -->
            <form class="form-horizontal" role="form" method="post">

                    <label class="control-label col-sm-2" for="name">Name:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="name" name="name" value="<c:out value="${user.name}"/>"/>
                    </div>
                    <label class="control-label col-sm-2" for="email">Email:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="email" name="email" value="${user.email}">
                    </div>
                    <label class="control-label col-sm-2" for="password">Password:</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="password" name="password" value="${user.password}">
                    </div>
                    <label class="control-label col-sm-2" for="phone">Phone number:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="phone" name="phone" value="${user.phone_number}">
                    </div><br>




        <div class="form-group" id="adressEdit">

                        <label class="control-label col-sm-2" for="adressCity">City:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="adressCity" name="city" value="${user.adress.city}"/>
                        </div>

                        <label class="control-label col-sm-2" for="adressCountry">Country:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="adressCountry" name="country" value="${user.adress.country}"/>
                        </div>

                        <label class="control-label col-sm-2" for="adressNumber">Number:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="adressNumber" name="number" value="${user.adress.number}"/>
                        </div>

                        <label class="control-label col-sm-2" for="adressStreet">Street:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="adressStreet" name="street" value="${user.adress.street}"/>
                        </div>

            <button class="btn btn-primary">Save</button>

                       <a href="<c:url value="/mainpage/${user.id}"/>" class="btn btn-warning">Cancel</a>
                    </div>
        </form>
                </div>
            </div>



        </div>
</div>
</body>
</html>

