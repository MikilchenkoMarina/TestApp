<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inspominder</title>
</head>

<head>
    <title>Inspominder</title>
    <style>
        H1 {
            color: #000080;
            font-size: 200%;
            font-family: Arial, Verdana, sans-serif;
        }
        H2 {
            color: #00004d;
            font-size: 100%;
            font-family: Arial, Verdana, sans-serif;
        }

        body {
            background-color: powderblue;
        }

    </style>
    <%--<link rel="stylesheet" type="text/css" href="<c:url value="/resources/myCustom.css" />">--%>
</head>

<body>
<h1>User Profile</h1>
<h2>First Name ${user.firstName} !!!</h2>
<br/>
<h2>Last Name ${user.lastName} !!!</h2>
<br/>
<h2>username ${user.userName} !!!</h2>
<br/>
<h2>passwotd : ${user.password}</h2>
<br/>
</body>

</html>
