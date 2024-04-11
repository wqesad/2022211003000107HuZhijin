<%--
  Created by IntelliJ IDEA.
  User: 胡志锦
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>Login</h1>
<%
    if(request.getAttribute("message") != null) {
        out.println(request.getAttribute("message"));
    }
%>
<body>
<form method="post" action="${pageContext.request.contextPath}/login"><!--within doPost() in servlet-->
    username <input type="text" name="username"/><br/>
    password <input type="password" name="password"/><br/>

    <input type="submit" value="Login"/>
</form>
</body>
</html>
<%@include file="footer.jsp"%>

