<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/static/css/login.css" title="style" />
    <title>Reset Password</title>
</head>
<body>
<form class="box" role="form" method="post">
    <h1>Reset Password</h1>

    <input type="text" id="email" name="email" placeholder="Enter your emial adress">
    <button class="btn btn-primary">Send email</button>
    <a href="/loginf" class="btn-primary">Cancel</a>

    <c:if test="${not empty error}">
        <div class="alert alert-danger">
            <h4>Error: ${error}</h4></div>
     </c:if>

</form>
</body>
</html>
