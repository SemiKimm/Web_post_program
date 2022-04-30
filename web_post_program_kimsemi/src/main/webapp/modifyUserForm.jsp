<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>admin-modifyUser</title>
</head>
<body>
<c:set var="user" value="${sessionScope.modifyUser}"/>
<form method="post" action="http://localhost:8081/modifyUser.do">
    <label>아이디</label>
    <input type="text" name="id" value="${user.getId()}" readonly="readonly"/><br/>
    <label>비밀번호</label>
    <input type="text" name="password" value="${user.getPassword()}" /><br/>
    <label>이름</label>
    <input type="text" name="name" value="${user.getName()}"/><br/>
    <label>프로필 사진명</label>
    <input type="text" name="profileFileName" value="${user.getProfileFileName()}"/><br/>
    <input type="submit" value="사용자 정보 수정 등록"/>
</form>

</body>
</html>
