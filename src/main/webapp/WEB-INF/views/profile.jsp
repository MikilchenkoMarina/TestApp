<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inspominder</title>
</head>

<body>
<h1><s:message code="inspominder.userProfile"/> </h1>

<link href="<c:url value="/resources/css/myCustom.css" />" rel="stylesheet">

<a href="?mylocale=en">English </a> | <a href="?mylocale=de">German </a> </br>

<h2><s:message code="inspominder.firstName"/> : ${user.firstName} </h2> <br/>
<h2><s:message code="inspominder.lastName"/>: ${user.lastName} </h2> <br/>
<h2><s:message code="inspominder.userName"/>: ${user.userName} </h2> <br/>
<h2><s:message code="inspominder.password"/>: ${user.password}</h2> <br/>
</body>

</html>
