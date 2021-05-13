<%--
  Created by IntelliJ IDEA.
  User: 小张
  Date: 2021/4/7
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        pre{
            display: inline;
            font-family: Consolas, serif;
        }
        div{
            font-family: Consolas, serif;
        }
        form{
            padding: 6px;
            line-height:25px
        }
        #submit{
            position: relative;
            left: 70px;
        }
        input{
            width: 194px;
        }
        input.nom{
            width: auto;
        }
    </style>
    <jsp:include page="/othersF/homework5/header.jsp"/>
    <h2>Login</h2>
    <hr>
<%
    Object message;
    if ( (message=request.getAttribute("message")) != null )
    {
        out.println("<h3>"+message+"</h3>");
    }
%>
    <div id="main">
        <div style="float: left;width: calc(50% - 120px);height: 10%"></div>
        <form method="post" action="${pageContext.request.contextPath}/LoginServlet" >
            <div id="name">
                <pre>Name:     </pre>
                <input name="name" type="text" required placeholder="No more than 30" pattern=".{0,30}"/>
            </div>
            <div id="password">
                <pre>password: </pre>
                <input name="password" type="password" required placeholder="No less than 8 , No more than 30" pattern=".{8,30}"/>
            </div>
            <div id="submit">
                <input type="submit" value="login now!"/>
            </div>
        </form>
    </div>
    <jsp:include page="/othersF/homework5/footer.jsp"/>
