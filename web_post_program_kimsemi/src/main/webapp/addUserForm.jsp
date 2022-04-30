<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>admin-addUser</title>
</head>
<body>
<form id="userInfo" method="post" action="http://localhost:8081/addUser.do">
    <label>아이디</label>
    <input type="text" name="id" placeholder="아이디를 입력하세요."/><br/>
    <label>비밀번호</label>
    <input type="text" name="password" placeholder="비밀번호를 입력하세요."/><br/>
    <label>이름</label>
    <input type="text" name="name" placeholder="이름을 입력하세요."/><br/>
    <label>프로필 사진</label>
    <input type="text" name="fileName" value="${requestScope.fileName}" readonly="readonly"/><br/>
    <input type="submit" value="사용자 등록"/>
</form>
</body>
</html>
