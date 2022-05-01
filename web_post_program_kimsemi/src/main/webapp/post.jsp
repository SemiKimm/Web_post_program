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
    <a href="http://localhost:8081/modifyPostForm.do?postId=${post.getId()}">
        <button>수정</button>
    </a>
    <br/>
    <a href="http://localhost:8081/removePost.do?postId=${post.getId()}">
        <button>삭제</button>
    </a>
</c:if>
<fieldset>
    <legend>작성자 id</legend>
    <div>
        <a href="http://localhost:8081/writerInfo.do?writerUserId=${post.getWriterUserId()}">
            ${post.getWriterUserId()}
        </a>
    </div>
</fieldset>
<br/>
<label>제목</label>
<div>
    ${post.getTitle()}
</div>
<br/>
<label>게시글 내용</label><br/>
<div>
    ${post.getContent()}
</div>
<br/>
</body>
</html>
