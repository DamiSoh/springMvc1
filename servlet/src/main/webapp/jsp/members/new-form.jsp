<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- [절대경로사용] webapp이 루트경로라 /jsp/... 순서대로 해주면 된다.-->
<form action="/jsp/members/save.jsp" method="post">
    username: <input type="text" name="username" />
    age     : <input type="text" name="age" />
    <button type="submit">전송</button>
</form>

</body>
</html>
