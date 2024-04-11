<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="header.jsp"%>


<%--<h1> <%= "Welcome to my home page." %> </h1>--%>
<h2> <%= "Welcome to my Online shop Home page." %> </h2><br/>
<form method="get" action="${pageContext.request.contextPath}/search">
    <input type="text" name="txt" size="30"/>
    <select name="search">
        <option value="baidu">Baidu</option>
        <option value="bing">Bing</option>
        <option value="google">Google</option>
    </select>
    <input type="submit" value="Search"/>
</form>
<br/>
<a href="hello-servlet">Hello Servlet-week1</a>
<br/>
<a href="hello">Student info Servlet-weeek2</a>
<br/>
<a href="Life">Life Cycle Servlet-weeek3</a>
<br/>
<a href="register.jsp">Register Servlet-weeek3</a>
<br/>
<a href="config">Config Servlet-weeek4</a>
<br/>
<a href="register.jsp">Register JDBC Servlet-weeek4</a>
<br/>
<a href="index.jsp">Include-weeek5</a>
<br/>
<a href="login.jsp">Login-weeek5</a>
</body>
</html>

<%@include file="footer.jsp"%>