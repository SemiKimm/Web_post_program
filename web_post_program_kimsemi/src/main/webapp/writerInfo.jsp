<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>writerInfo</title>
</head>
<body>
    <c:set var="writer" value="${requestScope.writerInfo}"/>
    <label>작성자 이름</label>
    <div>${writer.getName()}</div>
    <label>작성자 프로필 사진</label>
    <div>
        <img width="50px" height="50px" src="/profile/${writer.getProfileFileName()}"/>
    </div>
</body>
</html>
