
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h2>Welcome,
    <jsp:useBean id="user" scope="request" class="com.Lab2.Login"/>
    <jsp:getProperty name="user" property="userName"/>
</h2>
</body>
</html>
