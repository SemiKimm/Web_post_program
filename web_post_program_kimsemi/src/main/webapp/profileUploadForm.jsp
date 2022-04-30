<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>admin-profileUpload</title>
</head>
<body>
    <form id="profile" method="post" action="/profile.do" enctype="multipart/form-data">
        <label>프로필 사진</label>
        <input type="file" name="file"/>
        <input type="submit" value="업로드">
    </form>
</body>
</html>
