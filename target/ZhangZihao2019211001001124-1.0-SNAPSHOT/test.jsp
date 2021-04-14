<%--
  Created by IntelliJ IDEA.
  User: 小张
  Date: 2021/3/30
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isErrorPage="true" %>
<%@ page import="test" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table frame="box" rules="all">
    <th>ID</th>
    <th>UserName</th>
    <th>Password</th>
    <th>Email</th>
    <th>Gender</th>
    <th>Birthdate</th>
    <tr>
        <td>
            tableS.getID()
        </td>
        <td>
            tableS.getUserName()
        </td>
        <td>
            tableS.getPassword()
        </td>
        <td>
            tableS.getEmail()
        </td>
        <td>
            tableS.getGender()
        </td>
        <td>
            tableS.getBirthdate()
        </td>
    </tr>
</table>
</body>
</html>
