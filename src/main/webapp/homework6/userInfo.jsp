<%--
  Created by IntelliJ IDEA.
  User: 小张
  Date: 2021/4/9
  Time: 8:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/homework5/header.jsp"/>
    <table frame="box" rules="all">
        <tr>
            <th>ID</th>
            <td><%= request.getAttribute("ID") %></td>
        </tr>
        <tr>
            <th>UserName</th>
            <td><%= request.getAttribute("UserName") %></td>
        </tr>
        <tr>
            <th>Password</th>
            <td><%= request.getAttribute("Password") %></td>
        </tr>
        <tr>
            <th>Email</th>
            <td><%= request.getAttribute("Email") %></td>
        </tr>
        <tr>
            <th>Gender</th>
            <td><%= request.getAttribute("Gender") %></td>
        </tr>
        <tr>
            <th>Birthdate</th>
            <td><%= request.getAttribute("Birthdate") %></td>
        </tr>
    </table>
    <jsp:include page="/homework5/footer.jsp"/>
