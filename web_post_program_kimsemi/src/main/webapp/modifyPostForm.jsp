<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>modify post</title>
</head>
<body>
    <c:set var="originPost" value="${requestScope.post}"/>
    <form method="post" action="http://localhost:8081/modifyPost.do?postId=${originPost.getId()}">
        <label>제목</label><br/>
        <input type="text" name="title" value="${originPost.getTitle()}"><br/>
        <label>내용</label><br/>
        <textarea name="content">
${originPost.getContent()}
        </textarea>
        <br/>
        <input type="submit" value="게시글 수정"/>
    </form>
</body>
</html>
