<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Inspominder</title>
    <link href="<c:url value="/resources/css/form.css" />" rel="stylesheet">
</head>
<body>
<link href="<c:url value="/resources/css/form.css" />" rel="stylesheet">
<h1><s:message code="inspominder.register"/></h1>



<springForm:form method="POST" commandName="user">
<div class="form-style-2">
    <a href="?mylocale=en">English </a> | <a href="?mylocale=de">German </a>

    <div class="form-style-2-heading">Provide your information</div>

    <springForm:label path="firstName"> <span> <s:message code="inspominder.firstName"/> <span class="required">*</span></span> </springForm:label>
    <springForm:errors path="firstName" cssClass="error"/> </br>
    <springForm:input path="firstName" class="input-field" cssErrorClass="error"/>


    <springForm:label path="lastName" > <span> <s:message code="inspominder.lastName"/> <span class="required">*</span></span></springForm:label>
    <springForm:input path="lastName" class="input-field" cssErrorClass="error"/>
    <springForm:errors path="lastName" cssClass="error"/> </br>

    <springForm:label path="userName"><span> <s:message code="inspominder.userName"/> <span class="required">*</span></span> </springForm:label>
    <springForm:input path="userName" class="input-field" cssErrorClass="error" />
    <springForm:errors path="userName" cssClass="error"/> </br>

    <springForm:label path="password">  <span> <s:message code="inspominder.password"/> <span class="required">*</span></span>    </springForm:label>
    <springForm:input path="password" class="input-field" cssErrorClass="error"/>
    <springForm:errors path="password" cssClass="error"/> </br>

    <springForm:button>
        <label><span>&nbsp;</span> <s:message code="inspominder.register"/></label>
    </springForm:button>

    </springForm:form>
</div>
</body>
</html>
