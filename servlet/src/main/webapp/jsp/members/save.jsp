<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // request, response는 jsp에서도 쓸 수 있다.

    MemberRepository memberRepository = MemberRepository.getInstance();
    String userName = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));
    System.out.println(userName + ", " + age);

    Member member = new Member();
    member.setUsername(userName);
    member.setAge(age);
    memberRepository.save(member);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <li>id      : <%=member.getId()%></li>
    <li>username: <%=member.getUsername()%></li>
    <li>age     : <%=member.getAge()%></li>
</ul>
<a href="index.html"></a>
</body>
</html>
