<%@ page import="com.Lab1.Person" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.Lab1.Dog" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Assignemnt1</title>
    </head>
    <body>
        <h3>c:forEach</h3>
        <ul>
            <c:forEach var="i" begin="1" end="10">
                <li>${i}</li>
            </c:forEach>
        </ul>
        <ul>
            <c:forEach var="i" begin="1" end="10" step="2">
                <li>${i}</li>
            </c:forEach>
        </ul>
        <ul>
            <c:forEach var="i" begin="2" end="10" step="2">
                <li>${i}</li>
            </c:forEach>
        </ul>
        <%
            String[] words ={"one","two","three","four","five","six","seven","eight","nine","ten"};
            pageContext.setAttribute("words", words);
        %>
        <ul>
            <c:forEach var="item" items="${pageContext.getAttribute('words')}">
                <li>${item}</li>
            </c:forEach>
        </ul>
        <ul>
            <c:forEach var="item" items="${pageScope.words}" begin="0" end="9" step="2">
                <li>${item}</li>
            </c:forEach>
        </ul>
        <%
            List<Person> personList=new ArrayList<>();
            personList.add(new Person("Tom",new Dog("Tommy")));
            personList.add(new Person("Sam",new Dog("Sammy")));
            request.setAttribute("AllPerson",personList);
        %>
        <ul>
            <c:forEach var="p" items="${requestScope.AllPerson}">
                <li>Pname: ${p.name}</li>
                <li>Dname: ${p.dog.name}</li>
                <br/>
            </c:forEach>
        </ul>
        <%
        String str="one:two:three-four-five";
        %>
        <h3> c:forTokens</h3>
        <ul>
            <c:forTokens var="item" items="one:two:three-four-five" delims=":-">
                <li><c:out value="${item}"/></li>
            </c:forTokens>
        </ul>
    </body>
</html>
