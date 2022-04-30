<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>post</title>
</head>
<body>
    <c:set var="post" value="${requestScope.post}"/>
    <c:set var="user" value="${sessionScope.user}"/>
    <c:if test="${user.getId().equals(post.getWriterUserId())}" var="testResult">
        <form method="get" action="http://localhost:8081/modifyPostForm.do?postId=${post.getId()}">
            <input type="submit" value="수정"/>
        </form>
        <form method="get" action="http://localhost:8081/removePost.do?postId=${post.getId()}">
            <input type="submit" value="삭제"/>
        </form>
    </c:if>
    <br/>
    <div>
        ${post.getTitle()}
    </div><br/>
    <div>
        ${post.getContent()}
    </div><br/>
</body>
</html>
