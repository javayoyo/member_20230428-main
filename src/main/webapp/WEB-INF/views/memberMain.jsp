<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-04-28
  Time: 오후 2:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/main.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">

</head>
<body>
<%@include file="./component/header.jsp"%>
<%@include file="./component/nav.jsp"%>

<div id="section">
    ${sessionScope.loginEmail} 님 환영해요!
    <button>로그아웃</button>
    <button onclick="fun1()">세션값 js에서 확인</button>
</div>

<%@include file="./component/footer.jsp"%>
</body>
<script>
    const fun1 = () => {
        const loginEmail = '${sessionScope.loginEmail}';
        console.log("로그인이메일: ", loginEmail);
    }
</script>
</html>
