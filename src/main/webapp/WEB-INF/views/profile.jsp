<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <link href="<c:url value="/resources/css/myCustom.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap2.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-3.2.0.js"/>"></script>
<%--        <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>--%>
    <%--    <script src="<c:url value="/resources/js/window-message.js" />"></script>--%>
    <div class="page-header" align="center"><h1><s:message code="inspominder.userProfile"/></h1></div>

</head>

<script>
    $(document).ready(function myFunction() {
        var text
        var userNameText= '<c:out value="${user.userName}"/>'
debugger
        $(".show-mindow").click(function myFunction() {


            /*---------------------------------*/
            var timeout = 5000;
            $('.selectDelay').each(function (k, objSel) {
                if (objSel.selectedIndex != -1) {
                    timeout = objSel.options[objSel.selectedIndex].value;
                    alert('Reminder selected timeout = ' + timeout)
                }
            });

            /*---------------------------------*/


            $('.itemText').each(function (k, obj) {
                setTimeout(function () {
                    text = obj.innerText
                    alert(obj.innerText + 'LA LA LA ')
                 /*   checkForm(obj.innerText)*/
                    console.log(timeout)
                }, timeout);
                timeout += timeout;

            });
        });
    });
    /*---------------------------------*/
    var myAlert
    function checkForm() {
        myAlert = window.open('', 'alert', width=100 ,height=100,top=100,left=100)
        var wC = '<html><head></head><body onBlur="self.focus();">'
        wC += "This is reminder text "+ text + " DEAR" + userNameText
        wC += '<img src="http://www.phytology.ru/images/stories/Floristika3/quadrifoglio.jpg" width="50" height="50" >'
        wC += '</body></html>'
        myAlert.document.open()
        myAlert.document.write(wC)
    }
</script>


<body>
<%--account info panel--%>
<div class="col-md-4">
    <div class="bs-component">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title"><s:message code="inspominder.accountInfo"/></h3>
            </div>
            <div class="panel-body">
                <label><s:message code="inspominder.firstName"/> : </label> ${user.firstName} <br/>
                <label><s:message code="inspominder.lastName"/> : </label> ${user.lastName} <br/>
                <label><s:message code="inspominder.userName"/> : </label> ${user.userName} <br/>
            </div>
        </div>
    </div>

    <%--reminders list panel--%>
    <div class="col-md-4">
        <div class="bs-component">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title"><s:message code="inspominder.Reminders"/></h3>
                </div>
                <div class="panel-body">
                    <a class="btn btn-primary" href="<c:url value="${user.userName}"/>/reminders"> <s:message
                            code="inspominder.openRemindersPage"/></a></br>
                    <div class="scroll">
                        <ol class="custom-counter">
                            <c:forEach var="reminder" items="${reminderList}">
                                <li>
                                    <div class="media-body">
                                        <div class="snippet">
                                            <a class="pull-left"> <img src="<c:url value="${reminder.imageLink}" />"/>
                                            </a>
                                            <p><h4 class="itemText"><c:out value="${reminder.text}"/></h4></p>

                                        </div>
                                    </div>
                                </li>
                            </c:forEach>
                        </ol>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <%--add reminder Form panel--%>
    <div class="col-md-4">
        <div class="bs-component">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title"><s:message code="inspominder.remindersSettings"/></h3>
                </div>
                <div class="panel-body">

                    <springForm:form method="POST" commandName="remindersAppearDelay" cssClass="form-style-7">
                        <ul>
                            <li>
                                <s:message code="inspominder.reminderDelay"/>
                                <ul>
                                    <springForm:select class="selectDelay" path="delay" items="${delayMap}"/>
                                </ul>
                            </li>
                        </ul>
                        <springForm:button class="show-mindow">
                            <s:message code="inspominder.remindersRun"/>
                        </springForm:button>

                    </springForm:form>

                    <%-------------------------------------------------------------------------------------------------------------------------------%>

                </div>
            </div>
        </div>
    </div>

</body>
</html>
