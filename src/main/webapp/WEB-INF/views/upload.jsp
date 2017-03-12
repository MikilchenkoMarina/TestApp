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
    <springForm:form method="post" commandName="uploadFile"  enctype="multipart/form-data">
        <table border="0">
            <tr>
                <td>Pick file #1:</td>
                <td><input type="file" name="fileUpload" size="50" /></td>
            </tr>
          <input type="file" name="fileUpload" size="50" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Upload" /></td>
            </tr>
        </table>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </springForm:form>
</div>

</body>
</html>