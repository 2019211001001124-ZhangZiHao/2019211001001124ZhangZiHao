<%@ page import="com.ZhangZihao.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 小张
  Date: 2021/4/9
  Time: 8:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% User user = (User) session.getAttribute("user"); %>

<html>
<head>
    <jsp:include page="/WEB-INF/views/old_ver/header.jsp"/>
        <table frame="box" rules="all">
            <tr>
                <th>ID</th>
                <td><%= user.getID() %></td>
                <%--            <td><%= request.getAttribute("ID") %></td>--%>
            </tr>
            <tr>
                <th>UserName</th>
                <td><%= user.getUserName() %></td>
                <%--            <td><%= request.getAttribute("UserName") %></td>--%>
            </tr>
            <tr>
                <th>Password</th>
                <td><%= user.getPassword() %></td>
                <%--            <td><%= request.getAttribute("Password") %></td>--%>
            </tr>
            <tr>
                <th>Email</th>
                <td><%= user.getEmail() %></td>
                <%--            <td><%= request.getAttribute("Email") %></td>--%>
            </tr>
            <tr>
                <th>Gender</th>
                <td><%= user.getGender() %></td>
                <%--            <td><%= request.getAttribute("Gender") %></td>--%>
            </tr>
            <tr>
                <th>Birthdate</th>
                <td><%= user.getBirthdate() %></td>
                <%--            <td><%= request.getAttribute("Birthdate") %></td>--%>
            </tr>
        </table>
        <a href="${pageContext.request.contextPath}/UpDateUser">Change Now</a>
    <jsp:include page="/WEB-INF/views/old_ver/footer.jsp"/>
