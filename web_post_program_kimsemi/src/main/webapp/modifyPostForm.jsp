<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>modify post</title>
</head>
<body>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="message" var="message"/>
<c:set var="originPost" value="${requestScope.post}"/>
<form method="post" action="http://localhost:8081/modifyPost.do?postId=${originPost.getId()}">
    <label><fmt:message key="title" bundle="${message}" /></label><br/>
    <input type="text" name="title" value="${originPost.getTitle()}"><br/>
    <label><fmt:message key="content" bundle="${message}" /></label><br/>
    <textarea name="content">
        ${originPost.getContent()}
    </textarea>
    <br/>
    <input type="submit" value="<fmt:message key="modify" bundle="${message}" />"/>
</form>
</body>
</html>
