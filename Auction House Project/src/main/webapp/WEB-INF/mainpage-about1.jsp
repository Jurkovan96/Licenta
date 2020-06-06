<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>


    <title>New page with data table</title>

    <link rel="icon" type="image/png" href="/images/icons/favicon.ico"/>
    <!--==  =============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/static/vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/static/fonts/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/static/vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/static/vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/static/vendor/perfect-scrollbar/perfect-scrollbar.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/static/css/util.css">
    <link rel="stylesheet" type="text/css" href="/static/css/main.css">
<%--    <link rel="stylesheet" type="text/css" href="/static/css/style.css" title="style" />--%>

</head>
<body>

<div id="menubar">
    <ul id="menu">
        <c:set value="${user}" var="user"/>
        <li><a href="/mainpage/${user.id}">Home Page</a></li>
        <li><a href="/mainpage/${user.id}/products">Art</a></li>
        <li><a href="/mainpage/${user.id}/about">Auctions</a></li>
        <li><a href="/mainpage/${user.id}/contact" >Your auctions</a></li>
        <li><a href="/mainpage/${user.id}/settings" >Account Settings</a></li>
        <li><a href="/mainpage/${user.id}/orders">Orders</a></li>
        <li><a href="/mainpage/logout">Logout</a></li>
    </ul>
</div>


<%--<div class="limiter">--%>
    <div class="container-table100">
        <div class="wrap-table100">
            <div class="table100 ver1">
                <div class="table100-firstcol">
                    <table>
                        <thead>
                        <tr class="row100 head">
                            <th class="cell100 column1">Bids</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${bids}" var="bid">
                        <tr class="row100 body">
                            <td class="cell100 column1"><c:out value="${bid.bid_id}"/></td>
                        </tr>


                        </c:forEach>
                        </tbody>
                    </table>

                </div>

                <div class="wrap-table100-nextcols js-pscroll">
                    <div class="table100-nextcols">
                        <table>
                            <thead>
                            <tr class="row100 head">
                                <th class="cell100 column2">Position</th>
                                <th class="cell100 column3">Start date</th>
                                <th class="cell100 column4">Last Activity</th>
                                <th class="cell100 column5">Contacts</th>
                                <th class="cell100 column6">Age</th>
<%--                                <th class="cell100 column7">Address</th>--%>
<%--                                <th class="cell100 column8">Card No</th>--%>
                            </tr>
                            </thead>

                            <tbody>
                            <c:forEach items="${bids}" var="bid">
                                <c:set value="${bid.product}" var="product"/>
                            <tr class="row100 body">
                                <td class="cell100 column2"><c:out value="${bid.state}"/></td>
                                <td class="cell100 column3"><c:out value="${bid.start_date}"/></td>
                                <td class="cell100 column4"><c:out value="${product.name}"/></td>
                                <td class="cell100 column5"><c:out value="${product.artist}"/></td>
                                <td class="cell100 column6"><c:out value="${bid.bid_value}"/></td>
<%--                                <td class="cell100 column7">New York City, NY</td>--%>
<%--                                <td class="cell100 column8">424242xxxxxx6262</td>--%>
                            </tr>

                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
<%--</div>--%>


</body>
</html>
