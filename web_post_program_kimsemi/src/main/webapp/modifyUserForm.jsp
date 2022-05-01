<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>admin-modifyUser</title>
</head>
<body>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="message" var="message"/>
<c:set var="user" value="${sessionScope.modifyUser}"/>
<form method="post" action="http://localhost:8081/modifyUser.do">
    <label><fmt:message key="id" bundle="${message}" /></label>
    <input type="text" name="id" value="${user.getId()}" readonly="readonly"/><br/>
    <label><fmt:message key="password" bundle="${message}" /></label>
    <input type="text" name="password" value="${user.getPassword()}" /><br/>
    <label><fmt:message key="name" bundle="${message}" /></label>
    <input type="text" name="name" value="${user.getName()}"/><br/>
    <label><fmt:message key="profileImg" bundle="${message}" /></label>
    <input type="text" name="profileFileName" value="${user.getProfileFileName()}"/><br/>
    <input type="submit" value="<fmt:message key="modify" bundle="${message}" />"/>
</form>

</body>
</html>
