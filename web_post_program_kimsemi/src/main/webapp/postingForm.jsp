<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>postingForm</title>
</head>
<body>
<form method="post" action="http://localhost:8081/posting.do">
    <label>제목</label><br/>
    <input type="text" name="title" placeholder="제목을 입력하세요"/><br/>
    <label>게시글 상세 내용</label><br/>
    <textarea name="content" cols="50" rows="10" placeholder="게시글 내용을 입력하세요."></textarea><br/>
    <input type="submit" value="게시글 등록"/>
</form>
</body>
</html>
