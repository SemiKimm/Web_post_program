<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>admin-profileUpload</title>
</head>
<body>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="message" var="message"/>
<form id="profile" method="post" action="/profileUpload.do" enctype="multipart/form-data">
    <label><fmt:message key="profileImg" bundle="${message}" /></label>
    <input type="file" name="file"/>
    <input type="submit" value="<fmt:message key="upload" bundle="${message}" />">
</form>
</body>
</html>
