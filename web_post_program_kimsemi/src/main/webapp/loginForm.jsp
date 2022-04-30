<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PostingService - Login</title>
</head>
<body>
<form method="post" action="http://localhost:8081/login.do">
    <label>아이디</label>
    <input type="text" name="userId" placeholder="아이디를 입력하세요."/>
    <label>비밀번호</label>
    <input type="text" name="userPassword" placeholder="비밀번호를 입력하세요."/>
    <input type="submit" value="로그인"/>
</form>
</body>
</html>
