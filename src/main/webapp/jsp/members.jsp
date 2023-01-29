<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  MemberRepository memberRepository = MemberRepository.getInstance(); //싱글톤이기 때문에 getInstance로 받아오기
  List<Member> members = memberRepository.findAll();
%>
<html>
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<a href="/index.html">메인</a>
<table>
  <thead>
  <th>id</th>
  <th>username</th>
  <th>age</th>
  </thead>
  <tbody>
  <%
    for (Member member : members) { // 동적 부분
      out.write("    <tr>");
      out.write("        <td>" + member.getId() + "</td>");
      out.write("        <td>" + member.getUserName() + "</td>");
      out.write("        <td>" + member.getAge() + "</td>");
      out.write("    </tr>");
    }
  %>
  </tbody>
</table>

</body>
</html>