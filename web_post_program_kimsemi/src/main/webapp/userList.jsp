<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>관리자 모드 - 사용자 목록</title>
</head>
<body>
    <div>userList</div>
    <form method="get" action="http://localhost:8081/profileUploadForm.do">
        <input type="submit" value="사용자 추가">
    </form>
    <form method="get" action="http://localhost:8081/logout.do">
        <input type="submit" value="로그아웃"/>
    </form>

    <table style="text-align:center;border-collapse:collapse;border-top:1px solid black;border-bottom:1px solid black">
        <thead>
            <tr style="white-space:nowrap;border-bottom:1px solid black">
                <th>사용자 아이디</th>
                <th>사용자 비밀번호</th>
                <th>사용자 이름</th>
                <th>사용자 프로필 사진 파일명</th>
                <th>사용자 정보 수정</th>
                <th>사용자 삭제</th>
            </tr>
        </thead>
        <tbody>
    <c:set var="userList" value="${sessionScope.userList}"/>
    <c:forEach var="user" items="${userList}">
        <tr style="white-space:nowrap;border-top:1px solid #EFEFEF">
            <td style="border: solid darkgrey 1px">${user.getId()}</td>
            <td style="border: solid darkgrey 1px">${user.getPassword()}</td>
            <td style="border: solid darkgrey 1px">${user.getName()}</td>
            <td style="border: solid darkgrey 1px">${user.getProfileFileName()}</td>
            <td style="border: solid darkgrey 1px">
                <a href="http://localhost:8081/modifyUserForm.do?uid=${user.getId()}">
                    <button>수정</button>
                </a>
            </td>
            <td style="border: solid darkgrey 1px">
                <a href="http://localhost:8081/removeUser.do?uid=${user.getId()}">
                    <button>삭제</button>
                </a>
            </td>
        </tr>
    </c:forEach>
        </tbody>
    </table>
</body>
</html>
