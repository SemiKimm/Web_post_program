<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>PostingService - Login</title>
</head>
<body>
<fmt:setLocale value="${sessionScope.locale}" />
<fmt:setBundle basename="message" var="message" />
<a href="http://localhost:8081/locale.do">${sessionScope.locale}</a>
<form method="post" action="http://localhost:8081/login.do">
    <label><fmt:message key="id" bundle="${message}" /></label>
    <input type="text" name="userId" placeholder="<fmt:message key="pleaseEnterYourID." bundle="${message}" />"/>
    <label><fmt:message key="password" bundle="${message}" /></label>
    <input type="text" name="userPassword" placeholder="<fmt:message key="pleaseEnterYourPwd." bundle="${message}" />"/>
    <input type="submit" value="<fmt:message key="login" bundle="${message}" />"/>
</form>
</body>
</html>
