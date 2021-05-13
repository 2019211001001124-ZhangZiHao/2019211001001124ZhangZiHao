<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
<jsp:include page="/WEB-INF/views/old_ver/header.jsp"/>

        <br/>

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
        </ul>

<jsp:include page="/WEB-INF/views/old_ver/footer.jspoter.jsp"/>