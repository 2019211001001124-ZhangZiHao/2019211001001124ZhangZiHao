<%@ page import="java.util.Objects" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 5/15/2021
  Time: 11:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>validate</title>
    </head>
    <body>
        <jsp:useBean id="user" scope="request" class="com.Lab2.Login"/>
        <jsp:setProperty name="user" property="userName" value="${param.username}"/>
        <jsp:setProperty name="user" property="password" value="${param.password}"/>


<%
            if(Objects.equals(user.getUserName(), "admin") && Objects.equals(user.getPassword(), "admin"))
            {
%>
            <jsp:forward page="welcome.jsp"/>
<%
            } else{
                out.println(" username or  password Error");

%>
        <jsp:include page="login.jsp"/>

<%
            }
%>
    </body>
</html>