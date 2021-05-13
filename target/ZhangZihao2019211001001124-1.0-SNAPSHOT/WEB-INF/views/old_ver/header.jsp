<%@ page import="com.ZhangZihao.model.User" %>
<title>My Online APP</title>
</head>
<body style="margin:0px;padding:0px;font-family:helvetica;">
<table width="100%" cellpadding="0" cellspacing="0">
    <tr>
        <td height="78" style="background-color:#788dad;
                            border-width:2px;
                            border-style:solid;
                            border-color:black;
                            padding:0px;
                            margin:0px;" valign="bottom">

            <img src="${pageContext.request.contextPath}/homework5/logo.jpg" align="left">
        </td>
    </tr>
    <tr>
        <td height="15" style="color:white;
                            background-color:#444444;
                            border-width:2px;
                            border-style:solid;
                            border-top-width:0px;
                            border-color:black;" align="center">
            <a style="color:white;" href="${pageContext.request.contextPath}/Home">Home</a>
<%--            <a style="color:white;" href="${pageContext.request.contextPath}">Home</a>--%>
            - <a style="color:white;" href="${pageContext.request.contextPath}/LoginServlet">Login</a>
            - <a style="color:white;" href="${pageContext.request.contextPath}/#">Product</a>
            - <a style="color:white;" href="${pageContext.request.contextPath}/#">FAQ</a>
            - <a style="color:white;" href="${pageContext.request.contextPath}/config">About</a>

        </td>
    </tr>
    <tr height="25"><td align="right"><font size="18" color="blue">
        Welcome,
    <%
        User user;
        if( (user=(User) session.getAttribute("user"))!=null)
        {
            out.println(
                    "<span style=\"color: red; \">"+
                    user.getUserName()+
                    "</span>"
            );
        }
        else {
            out.println(
                    "<span style=\"color: red; \">"+
                            "Guest"+
                            "</span>"
            );
        }
    %>
    </font></td> </tr>
    <tr height="20"><td align="right">
        <%
            if(session.getAttribute("user")!=null)
            {
        %>
            <br/><a href="${pageContext.request.contextPath}/LogOut">Logout</a>
        <%
            }
        %>
        <br><a href="#">My Cart</a><br/>
        <a href="${pageContext.request.contextPath}/register">Register Here</a>
    </td></tr>
</table>
<br/>
