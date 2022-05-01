<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>postList</title>
</head>
<body>
<form method="get" action="http://localhost:8081/logout.do">
    <input type="submit" value="로그아웃"/>
</form>
<form method="get" action="http://localhost:8081/postingForm.do">
    <input type="submit" value="게시글 작성">
</form>
<table style="text-align:center;border-collapse:collapse;border-top:1px solid black;border-bottom:1px solid black">
    <thead>
    <tr style="white-space:nowrap;border-bottom:1px solid black">
        <th>게시물 아이디</th>
        <th>제목</th>
        <th>작성자 아이디</th>
        <th>작성 시각</th>
        <th>조회수</th>
    </tr>
    </thead>
    <tbody>
    <c:set var="postList" value="${sessionScope.postList}"/>
    <c:forEach var="post" items="${postList}">
        <tr style="white-space:nowrap;border-top:1px solid #EFEFEF">
            <td style="border: solid darkgrey 1px">${post.getId()}</td>
            <td style="border: solid darkgrey 1px">
                <a href="http://localhost:8081/post.do?postId=${post.getId()}">
                        ${post.getTitle()}
                </a>
            </td>
            <td style="border: solid darkgrey 1px">${post.getWriterUserId()}</td>
            <td style="border: solid darkgrey 1px">${post.getWriteTime()}</td>
            <td style="border: solid darkgrey 1px">${post.getViewCount()}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<footer>
    <label>방문자 수 : </label>
    ${applicationScope.counter}
    <label>로그인 사용자 수 : </label>
    ${sessionScope.loginUserCounter}
</footer>
</body>
</html>
