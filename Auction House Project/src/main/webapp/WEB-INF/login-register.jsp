<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/static/css/login.css" title="style" />
    <title>Register</title>

</head>
<body>

<form class="box" role="form" method="post">
    <h1>Register</h1>
    <c:if test="${not empty error}">
        <div class="alert alert-danger">Error: ${error}</div>
    </c:if>
    <input type="text" id="newuser " name="newuser" placeholder="Insert user name">
    <input type="password" id="newpassword" name="newpassword" placeholder="Insert password">
    <input type="text" id="newemail" name="newemail" placeholder="Insert a valid email adress">
    <button class="btn btn-primary">Finish</button>
    <a href="/loginf" class="btn-primary">Cancel</a>

</form>
</body>
</html>
