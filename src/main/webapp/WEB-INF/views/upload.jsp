<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@page session="true" %>
<html>
<head>
    <link href="<c:url value="/resources/css/myCustom.css" />" rel="stylesheet">
    <h1><s:message code="inspominder.login"/></h1>
</head>


<body>
<div align="center">
    <h1>Spring MVC - Hibernate File Upload to Database Demo</h1>

    <a href="<c:url value="/" />">
        <img src="<c:url value="/https://s3.eu-central-1.amazonaws.com/inspominderbucket/1489410427596_idea-512.png"/>" border="0"/>
    </a>
    <springForm:form method="post" action="upload" enctype="multipart/form-data">
        Upload file :
        <input type="file" name="user-file"/>

        <input type="submit" value="Upload"/>


        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </springForm:form>
</div>

</body>
</html>