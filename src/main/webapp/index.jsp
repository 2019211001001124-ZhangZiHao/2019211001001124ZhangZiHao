<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
<jsp:include page="/homework5/header.jsp"/>

        <br/>
        <h1>Welcome!</h1>
        <form method="get" action="${pageContext.request.contextPath}/SearchServlet" target="_top">
            <input name="search" type="text"/>
            <select name="way">
                <option value="Baidu">Baidu</option>
                <option value="Sogou">Sogou</option>
                <option value="Bing">Bing</option>
            </select>
            <input type="submit"/>
        </form>
        <ul>
            <li>
                <a href="LoginServlet">To test(U-_-U)</a>
            </li>

            <li>
                <a href="homework3/ServletLifeCycle">To LifeCycle(U-_-U)</a>
            </li>

            <li>
                <a href="config">To Config(U-_-U)</a>
            </li>

            <li>
                <a href="./homework5/MyJsp.jsp">To MyJsp(U-_-U)</a>
            </li>

            <li>
                <a href="./homework5/login.jsp">To login(U-_-U)</a>
            </li>
        </ul>

<jsp:include page="/homework5/footer.jsp"/>