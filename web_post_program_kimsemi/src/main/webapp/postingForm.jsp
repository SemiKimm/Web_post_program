<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>postingForm</title>
</head>
<body>
<fmt:setLocale value="${sessionScope.locale}" />
<fmt:setBundle basename="message" var="message" />
<form method="post" action="http://localhost:8081/posting.do">
    <label><fmt:message key="title" bundle="${message}"/></label><br/>
    <input type="text" name="title" placeholder="<fmt:message key="pleaseEnterTitle." bundle="${message}" />"/><br/>
    <label><fmt:message key="content" bundle="${message}"/></label><br/>
    <textarea name="content" cols="50" rows="10" placeholder="<fmt:message key="pleaseEnterContent." bundle="${message}" />"></textarea><br/>
    <input type="submit" value="<fmt:message key="submit" bundle="${message}"/>"/>
</form>
</body>
</html>
