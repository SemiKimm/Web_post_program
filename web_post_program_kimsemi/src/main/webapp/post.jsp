<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>post</title>
</head>
<body>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="message" var="message"/>
<c:set var="post" value="${requestScope.post}"/>
<c:set var="user" value="${sessionScope.user}"/>
<c:if test="${user.getId().equals(post.getWriterUserId())}" var="testResult">
    <a href="http://localhost:8081/modifyPostForm.do?postId=${post.getId()}">
        <button><fmt:message key="modify" bundle="${message}"/></button>
    </a>
    <br/>
    <a href="http://localhost:8081/removePost.do?postId=${post.getId()}">
        <button><fmt:message key="remove" bundle="${message}"/></button>
    </a>
</c:if>
<fieldset>
    <legend><fmt:message key="writerId" bundle="${message}"/></legend>
    <div>
        <a href="http://localhost:8081/writerInfo.do?writerUserId=${post.getWriterUserId()}">
            ${post.getWriterUserId()}
        </a>
    </div>
</fieldset>
<br/>
<label><fmt:message key="title" bundle="${message}"/></label>
<div>
    ${post.getTitle()}
</div>
<br/>
<label><fmt:message key="content" bundle="${message}"/></label><br/>
<div>
    ${post.getContent()}
</div>
<br/>
</body>
</html>
