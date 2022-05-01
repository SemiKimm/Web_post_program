<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>writerInfo</title>
</head>
<body>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="message" var="message"/>
<c:set var="writer" value="${requestScope.writerInfo}"/>
<label><fmt:message key="name" bundle="${message}" /></label>
<div>${writer.getName()}</div>
<label><fmt:message key="profileImg" bundle="${message}" /></label>
<div>
    <img width="50px" height="50px" src="/profile/${writer.getProfileFileName()}"/>
</div>
</body>
</html>
