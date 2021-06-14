<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>validate</title>
</head>
<body>

    <c:choose>
        <c:when test="${param.username=='ZZHadmin' && param.password=='ZZHadmin'}">
            <c:url var="admin" value="welcome.jsp">
                <c:param name="username" value="ZZHadmin"/>
            </c:url>
            <c:redirect url="${admin}"/>
        </c:when>

        <c:otherwise>
            <c:url var="wor" value="login.jsp"/>
            <c:set var="massage" value="worng password or username" scope="request"/>
            <c:import url="login.jsp"/>
        </c:otherwise>
    </c:choose>
</body>
</html>
