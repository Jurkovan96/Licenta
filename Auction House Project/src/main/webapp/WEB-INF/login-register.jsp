<%--
  Created by IntelliJ IDEA.
  User: jurko
  Date: 4/8/2020
  Time: 3:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <style type="text/css">

        body{
            margin: 0;
            padding: 0;
            font-family: sans-serif;
            background: #34495e;
        }
        .box{
            width: 300px;
            padding: 40px;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%,-50%);
            background: #191919;
            text-align: center;
        }
        .box h1{
            color: white;
            text-transform: uppercase;
            font-weight: 500;
        }
        .box input[type = "text"],.box input[type = "password"]{
            border:0;
            background: none;
            display: block;
            margin: 20px auto;
            text-align: center;
            border: 2px solid #3498db;
            padding: 14px 10px;
            width: 200px;
            outline: none;
            color: white;
            border-radius: 24px;
            transition: 0.25s;
        }
        .box input[type = "text"]:focus,.box input[type = "password"]:focus{
            width: 280px;
            border-color: #2ecc71;
        }
        .box input[type = "submit"]{
            border:0;
            background: none;
            display: block;
            margin: 20px auto;
            text-align: center;
            border: 2px solid #2ecc71;
            padding: 14px 40px;
            outline: none;
            color: white;
            border-radius: 24px;
            transition: 0.25s;
            cursor: pointer;
        }
        .box input[type = "submit"]:hover{
            background: #2ecc71;
        }

        .alert alert-danger{display: none;}

        .btn-primary{border:0;
            background: none;
            display: block;
            margin: 20px auto;
            text-align: center;
            border: 2px solid #2ecc71;
            padding: 14px 40px;
            outline: none;
            color: white;
            border-radius: 24px;
            transition: 0.25s;
            cursor: pointer;}

        .btn-primary:hover{
            background: #2ecc71;
        }


    </style>
</head>
<body>

<form class="box" role="form" method="post">
    <h1>Register</h1>
    <input type="text" id="newuser " name="newuser" placeholder="Insert user name">
    <input type="password" id="newpassword" name="newpassword" placeholder="Insert password">
    <input type="text" id="newemail" name="newemail" placeholder="Insert a valid email adress">
    <button class="btn btn-primary">Finish</button>
    <a href="/loginf" class="btn-primary">Cancel</a>
</form>
</body>
</html>
