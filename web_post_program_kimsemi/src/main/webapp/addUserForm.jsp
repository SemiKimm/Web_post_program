<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>admin-addUser</title>
</head>
<body>
<fmt:setLocale value="${sessionScope.locale}" />
<fmt:setBundle basename="message" var="message" />
<form id="userInfo" method="post" action="http://localhost:8081/addUser.do">
    <label><fmt:message key="id" bundle="${message}" /></label>
    <input type="text" name="id" placeholder="<fmt:message key="pleaseEnterYourID." bundle="${message}" />"/><br/>
    <label><fmt:message key="password" bundle="${message}" /></label>
    <input type="text" name="password" placeholder="<fmt:message key="pleaseEnterYourPwd." bundle="${message}" />"/><br/>
    <label><fmt:message key="name" bundle="${message}" /></label>
    <input type="text" name="name" placeholder="<fmt:message key="pleaseEnterYourName." bundle="${message}" />"/><br/>
    <label><fmt:message key="profileImg" bundle="${message}" /></label>
    <input type="text" name="fileName" value="${requestScope.fileName}" readonly="readonly"/><br/>
    <input type="submit" value="<fmt:message key="add" bundle="${message}" />"/>
</form>
</body>
</html>
