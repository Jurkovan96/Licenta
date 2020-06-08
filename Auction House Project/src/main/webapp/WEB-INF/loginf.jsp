<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/static/css/login.css" title="style" />
    <title>Login</title>
</head>
<body>
<form class="box" role="form" method="post">

    <h1>Login</h1>
    <c:if test="${not empty error}">
        <div class="alert alert-danger">Error: ${error}</div>
    </c:if>
    <input type="text" id="user" name="user" placeholder="User">
    <input type="password" id="password" name="password" placeholder="Password">
    <button class="btn btn-primary" >Login</button>
    <a href="/login-register" class="btn-primary">Register</a>
<%--    <button class="btn-primary"><a href="/login-register">Register</a></button>--%>
    <a href="/password-reset" class="btn-primary">Forgot password?</a>
</form>
</body>
</html>
