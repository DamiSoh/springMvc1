<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
    <!-- 원래 이렇게 해서 불러와야하는게 맞는데 너무 귀찮다. -->
    <li>id      : <%= ((Member)request.getAttribute("member")).getId()%></li>
    <li>username: <%= ((Member)request.getAttribute("member")).getUsername()%></li>
    <li>age     : <%= ((Member)request.getAttribute("member")).getAge()%></li>
    <p> 한번 더 출력 </p>
    <!-- $ { attributekey값.메소드 } 이렇게 축약해서 도와준다 -->
    <li>id      : ${member.getId()}</li>
    <li>username: ${member.getUsername()}</li>
    <li>age     : ${member.getAge()}</li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
