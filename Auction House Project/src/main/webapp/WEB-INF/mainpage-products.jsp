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
<%--    <script type="text/javascript" src="/static/js/productsFunctions.js"/>--%>




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

        <form action="/login-register" >
            <input type="text" placeholder="Search"><input>
            <input type="submit" value="search"/>
        </form>
            <div>
                <th>Name</th>
                <th>Phone</th>
                <th>Actions</th>
            </tr>
                <c:forEach items="${products}" var="product" varStatus="rowCounter">
                 <c:if test="${product.year}">
                <div class="productRow" style="height:300px">
                    </c:if>

                    <div class="Product1" style="float:left;width: 49%;height: 300px">
                        <h2> <c:out value="${product.name}"/></h2>
                            <div class="details">
                                <c:out value="${product.artist}"/>
                                <img class="imagesForProducts" src="<c:out value="${product.url}"/>" />
                            </div>
                        <a href="<c:url value="products/${product.id}&${product.name}/view"/>" class="button">View product</a>
                    </div>
                    <div id="space_between_products" style="float:left;width:2%;height: 300px"></div>
                    <div class="Product2" style="float:left;height: 300px;width:49%">
                        <h2> <c:out value="${product.name}"/></h2>
                        <div class="details">
                            <c:out value="${product.artist}"/>
                            <img class="imagesForProducts" src="<c:out value="${product.url}"/>" />
                        </div>
                        <a href="<c:url value="products/${product.id}&${product.name}/view"/>" class="button">View product</a>

                    </div>
                    ${rowCounter.count}

                    <br style="height: 30px"/>
                    <c:if test="${rowCounter.count % 2 == 0}">
                    </c:if>
                    </div>


            </c:forEach>
            </div>

        <div class="sidebar">

<%--            <button class="btn1">Slide up</button>--%>
<%--            <button class="btn2">Slide down</button>--%>
<%--            <h3>Sort products</h3>--%>
<%--            <form class="formCheck">--%>
<%--                <input type="checkbox"> Year</input>--%>
<%--                <input type="checkbox" >Artist</input>--%>
<%--                <input type="checkbox">Tehnique</input>--%>
<%--            </form>--%>
        <div class="filters">
            <p>Filter products by</p>

           <form role="form" method="post">
               <label>Years</label>
               <input type="text" placeholder="Enter year">2017</input>
               <label>Artists</label>
               <input type="text" placeholder="Enter year">V.Vasiliu</input>
               <label>Tehnique</label>
               <input type="text" placeholder="Enter year">OilCanvas</input>
               <button type="submit" >Apply terms</button>
           </form>



            <ul>
                <li><a href="#">link 1</a></li>
                <li><a href="#">link 2</a></li>
                <li><a href="#">link 3</a></li>
                <li><a href="#">link 4</a></li>
            </ul>




    </div>

</body>
</html>
