
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>colour_orange</title>

<meta name="description" content="website description" />
<meta name="keywords" content="website keywords, website keywords" />
<meta http-equiv="content-type" content="text/html; charset=windows-1252" />
<link rel="stylesheet" type="text/css" href="/static/css/style.css" title="style" />
</head>

<body>

<div id="main">
    <div id="header">
        <div id="logo">
            <div id="logo_text">


                <h1><a href="/mainpage/${user.id}">Viorel<span class="logo_colour">Vasiliu</span></a></h1>
                <h2>În viață e bine să lași urme...</h2>
            </div>
        </div>

        <div id="menubar">

            <c:set value="${user}" var="user"/>
            <ul id="menu">
                <!-- put class="selected" in the li tag for the selected page - to highlight which page you're on -->
                <li><a href="/mainpage/${user.id}">Home Page</a></li>
                <li><a href="/mainpage/${user.id}/products">Art</a></li>
                <li><a href="/mainpage/${user.id}/about">Auctions</a></li>
                <li><a href="/mainpage/${user.id}/contact" >Your auctions</a></li>
                <li><a href="/mainpage/${user.id}/settings" >Account Settings</a></li>
                <li><a href="/mainpage/${user.id}/orders">Orders</a></li>
                <li><a href="/mainpage/logout" >Logout</a></li>
            </ul>
        </div>
    </div>
    <div id="site_content">
        <div class="sidebar">
            <!-- insert your sidebar items here -->
            <h3>Latest News</h3>
            <h4>New Website Launched</h4>
            <h5>January 1st, 2010</h5>
            <p>2010 sees the redesign of our website. Take a look around and let us know what you think.<br /><a href="#">Read more</a></p>
            <p></p>
            <h4>New Website Launched</h4>
            <h5>January 1st, 2010</h5>
            <p>2010 sees the redesign of our website. Take a look around and let us know what you think.<br /><a href="#">Read more</a></p>

            <h3>Contact Links</h3>
            <ul>
                <li><a href="https://www.facebook.com/viorel.vasiliu.50">Viorel Vasiliu</a></li>
                <li><a href="https://www.facebook.com/ray.jurcovan">Rares Vasiliu</a></li>


            </ul>
            <h3>Search</h3>
<%--            Cautare pe site--%>
            <form method="post" action="/search" id="search_form">
                <p>
                    <input class="search" type="text" name="search_field" placeholder="Search..." />
                    <input name="search" type="image" style="border: 0; margin: 0 0 -9px 5px;" src="/static/images/search.png" alt="Search" title="Search" />
                </p>
            </form>
        </div>
        <div id="content">
            <!-- insert the page content here -->
            <h1>Welcome to my art page!</h1>
            <p>This standards compliant, simple, fixed width website template is released as an 'open source' design (under a <a href="http://creativecommons.org/licenses/by/3.0">Creative Commons Attribution 3.0 Licence</a>), which means that you are free to download and use it for anything you want (including modifying and amending it). All I ask is that you leave the 'design from HTML5webtemplates.co.uk' link in the footer of the template, but other than that...</p>
            <p>This template is written entirely in <strong>HTML5</strong> and <strong>CSS</strong>, and can be validated using the links in the footer.</p>
            <p>You can view more free HTML5 web templates <a href="http://www.html5webtemplates.co.uk">here</a>.</p>
            <p>This template is a fully functional 5 page website, with an <a href="examples.html">examples</a> page that gives examples of all the styles available with this design.</p>
            <h2>Browser Compatibility</h2>


        </div>
    </div>
    <div id="content_footer"></div>

    <div id="footer"> Viorel Vasiliu Original <br>
    </div>
    </div>
</div>
<%--<script type="text/javascript">--%>

<%--    var menu=document.getElementsByClassName("menu");--%>

<%--    menu.addEventListener("click", function(){--%>
<%--        menu.style.color="red"--%>
<%--    })--%>

<%--</script>--%>
</body>
</html>