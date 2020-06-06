<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>colour_orange - contact us</title>
    <meta name="description" content="website description" />
    <meta name="keywords" content="website keywords, website keywords" />
    <meta http-equiv="content-type" content="text/html; charset=windows-1252" />
    <link rel="stylesheet" type="text/css" href="/static/css/style.css" title="style" />
<%--    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"--%>
<%--          rel="stylesheet"--%>
<%--          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"--%>
<%--          crossorigin="anonymous">--%>


</head>

<body>
<div id="main">
    <div id="loggedUser">
        <div id="textBox">
            <h4 id="userText">Hello,  <c:out value="${user.name}"  /> !</h4>

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

    <table class="table table-striped">
        <tr>
            <th>Order number</th>
            <th>Order id</th>
            <th>Order total value</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${user.orders}" var="order">
            <tr>
                <td><c:out value="${order.oder_id}" /></td>
                <td><c:out value="${order.number}" /></td>
                <td><c:out value="${order.value}" /></td>
                  <td>
                    <a href="<c:url value="orders/${order.oder_id}/details"/>" class="button">View details</a>
                      <form id="formButtonsBids" role="form" method="post">
                          <a href="<c:url value="/mainpage/${user.id}/orders/${order.oder_id}/delete"/> " class="btn btn-info">Delete</a>

                      </form>
                </td>
            </tr>
        </c:forEach>
    </table>

    <form role="form" method="post" action="/mainpage/${user.id}/orders/add">
        <input type="text" name="ord_num" id="ord_num">
        <button name="opAdd" type="submit">Add new order</button>
    </form>
</div>
</div>
</div>
</body>
</html>