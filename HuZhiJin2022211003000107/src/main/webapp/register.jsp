<%--
  Created by IntelliJ IDEA.
  User: 14307
  Date: 2024/3/19
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>


<head>
    <style>

    </style>
    <title>Title</title>
</head>
<body>
<h3>New User Registration</h3>
<form method="post" action="${pageContext.request.contextPath}/register">

    <label for="name"></label>
    <input type="text" id="name" name="name" placeholder="Username" required><br>

    <label for="password"></label>
    <input type="password" id="password" name="password" placeholder="Password" required><br>

    <label for="email"></label>
    <input type="email" id="email" name="email" placeholder="Email" required><br>

    <label>Gender:</label>
    <input type="radio" name="sex" value="Male" id="male">
    <label for="male">Male</label>
    <input type="radio" name="sex" value="Female" id="female">
    <label for="female">Female</label><br>

    <label for="birthday"></label>
    <input type="text" id="birthday" name="birthday" placeholder="YYYY-MM-DD" required><br>

    <input type="submit" value="Register">

</form>
</body>
</html>
