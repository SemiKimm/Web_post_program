<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>postList</title>
</head>
<body>
<fmt:setLocale value="${sessionScope.locale}" />
<fmt:setBundle basename="message" var="message" />
<a href="http://localhost:8081/locale.do">${sessionScope.locale}</a>
<form method="get" action="http://localhost:8081/logout.do">
    <input type="submit" value="<fmt:message key="logout" bundle="${message}" />"/>
</form>
<form method="get" action="http://localhost:8081/postingForm.do">
    <input type="submit" value="<fmt:message key="posting" bundle="${message}" />">
</form>
<table style="text-align:center;border-collapse:collapse;border-top:1px solid black;border-bottom:1px solid black">
    <thead>
    <tr style="white-space:nowrap;border-bottom:1px solid black">
        <th><fmt:message key="postId" bundle="${message}" /></th>
        <th><fmt:message key="postTitle" bundle="${message}" /></th>
        <th><fmt:message key="writerId" bundle="${message}" /></th>
        <th><fmt:message key="writeTime" bundle="${message}" /></th>
        <th><fmt:message key="view" bundle="${message}" /></th>
    </tr>
    </thead>
    <tbody>
    <c:set var="postList" value="${sessionScope.postList}"/>
    <c:forEach var="post" items="${postList}">
        <tr style="white-space:nowrap;border-top:1px solid #EFEFEF">
            <td style="border: solid darkgrey 1px">${post.getId()}</td>
            <td style="border: solid darkgrey 1px">
                <a href="http://localhost:8081/post.do?postId=${post.getId()}">
                        ${post.getTitle()}
                </a>
            </td>
            <td style="border: solid darkgrey 1px">${post.getWriterUserId()}</td>
            <td style="border: solid darkgrey 1px">${post.getWriteTime()}</td>
            <td style="border: solid darkgrey 1px">${post.getViewCount()}</td>
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
