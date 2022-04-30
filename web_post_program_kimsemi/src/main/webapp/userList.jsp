<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>관리자 모드 - 사용자 목록</title>
</head>
<body>
    <div>userList</div>
    <form method="get" action="http://localhost:8081/profileUploadForm.do">
        <input type="submit" value="사용자 추가">
    </form>
    <c:set var="userList" value="${sessionScope.userList}"/>
    <c:forEach var="user" items="${userList}">
        ${user.getName()}
    </c:forEach>
</body>
</html>
