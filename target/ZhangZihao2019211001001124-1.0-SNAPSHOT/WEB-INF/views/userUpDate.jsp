<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%
    User user = (User) session.getAttribute("user");
    assert user!=null;
%>
<div id="update" style="align-content: center">
    <div style="float: left;width: calc(50% - 120px);height: 160px"></div>
    <form method="post" action="${pageContext.request.contextPath}/UpDateUser" >
        <input name="id" type="hidden" value="<%=user.getID()%>" />
        <div id="name">
            <pre>Name:     </pre>
            <input name="name" type="text" required placeholder="No more than 30s" pattern=".{0,30}" value="<%=user.getUserName()%>" />
        </div>
        <div id="password">
            <pre>password: </pre>
            <input name="password" type="text" required placeholder="No less than 8 , No more than 30" pattern=".{8,16}" value="<%=user.getPassword()%>" />
        </div>
        <div id="email">
            <pre>email:    </pre>
            <input name="email" type="text" required placeholder="QQmail/foxmail/Gmail..." pattern=".{1,}@.{1,}" value="<%=user.getEmail()%>" />
        </div>
        <div id="sex">
            Boy:      <input name="sex" class="nom" type="radio" value="boy" checked/>
            &ensp; 	&ensp; 	&ensp; 	&ensp;
            Girl:     <input name="sex" class="nom" type="radio" value="girl"/>
        </div>
        <div id="Date">
            <pre>Birthday: </pre>
            <input name="birthday" type="text" required placeholder="yyyy-dd-mm" pattern="\d{4}-((0[1-9])|(1[0-2]))-((0[1-9])|(1\d)|(2\d)|(3[0-1]))" value="<%=user.getBirthdate()%>" />
        </div>
        <div id="submit">
            <input type="submit" value="save now!"/>
        </div>
    </form>
</div>
<%@include file="footer.jsp"%>