<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>관리자 모드 - 사용자 목록</title>
</head>
<body>
<fmt:setLocale value="${sessionScope.locale}" />
<fmt:setBundle basename="message" var="message" />
<a href="http://localhost:8081/locale.do">${sessionScope.locale}</a>
<div><fmt:message key="userList" bundle="${message}" /></div>
<form method="get" action="http://localhost:8081/profileUploadForm.do">
    <input type="submit" value="<fmt:message key="addUser" bundle="${message}" />">
</form>
<form method="get" action="http://localhost:8081/logout.do">
    <input type="submit" value="<fmt:message key="logout" bundle="${message}" />"/>
</form>

<table style="text-align:center;border-collapse:collapse;border-top:1px solid black;border-bottom:1px solid black">
    <thead>
    <tr style="white-space:nowrap;border-bottom:1px solid black">
        <th><fmt:message key="userId" bundle="${message}" /></th>
        <th><fmt:message key="userPassword" bundle="${message}" /></th>
        <th><fmt:message key="userName" bundle="${message}" /></th>
        <th><fmt:message key="userProfileFileName" bundle="${message}" /></th>
        <th><fmt:message key="modifyUserInfo" bundle="${message}" /></th>
        <th><fmt:message key="removeUser" bundle="${message}" /></th>
    </tr>
    </thead>
    <tbody>
    <c:set var="userList" value="${sessionScope.userList}"/>
    <c:forEach var="user" items="${userList}">
        <tr style="white-space:nowrap;border-top:1px solid #EFEFEF">
            <td style="border: solid darkgrey 1px">${user.getId()}</td>
            <td style="border: solid darkgrey 1px">${user.getPassword()}</td>
            <td style="border: solid darkgrey 1px">${user.getName()}</td>
            <td style="border: solid darkgrey 1px">${user.getProfileFileName()}</td>
            <td style="border: solid darkgrey 1px">
                <a href="http://localhost:8081/modifyUserForm.do?uid=${user.getId()}">
                    <button><fmt:message key="modify" bundle="${message}" /></button>
                </a>
            </td>
            <td style="border: solid darkgrey 1px">
                <a href="http://localhost:8081/removeUser.do?uid=${user.getId()}">
                    <button><fmt:message key="remove" bundle="${message}" /></button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<footer>
    <label><fmt:message key="visitorCount" bundle="${message}" /> : </label>
    ${applicationScope.counter}
    <label><fmt:message key="loginUserCount" bundle="${message}" /> : </label>
    ${sessionScope.loginUserCounter}
</footer>
</body>
</html>
