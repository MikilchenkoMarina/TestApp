<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<html>

<head>
    <title>Inspominder</title>
</head>

<body>
<ol class="theme-list">
    <c:forEach var="theme" items="${themeList}">
        <li>
            <div><c:out value="${theme.name}">Test Text</c:out></div>
        </li>
    </c:forEach>
</ol>

</body>

</html>
