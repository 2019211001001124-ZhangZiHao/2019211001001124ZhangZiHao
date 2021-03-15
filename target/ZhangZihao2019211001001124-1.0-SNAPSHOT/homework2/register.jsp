<%--
  Created by IntelliJ IDEA.
  User: 小张
  Date: 2021/3/15
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        pre{
            display: inline;
            font-family: Consolas;
        }
        div{
            font-family: Consolas;
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
</head>
<body>
    <div id="main">
        <div style="float: left;width: calc(50% - 120px);height: 100%"></div>
        <form method="post">
            <div id="name">
                <pre>Name:     </pre>
                <input type="text" required placeholder="No more than 30" pattern=".{0,30}"/>
            </div>
            <div id="password">
                <pre>password: </pre>
                <input type="password" required placeholder="No less than 8 , No more than 30" pattern=".{8,16}"/>
            </div>
            <div id="email">
                <pre>email:    </pre>
                <input type="text" required placeholder="QQmail/foxmail/Gmail..."/>
            </div>
            <div id="sex">
                Boy:      <input name="sex" class="nom" type="radio" checked/>
                &ensp; 	&ensp; 	&ensp; 	&ensp;
                Girl:     <input name="sex" class="nom" type="radio"/>
            </div>
            <div id="Date">
                <pre>Birthday: </pre>
                <input type="text" required placeholder="yyyy-dd-mm" pattern="\d{4}-((\d)|(1\d)|(2\d)|(3[0-2]))-(\d|(1[0-2]))"/>
            </div>
            <div id="submit">
                <input type="submit" value="register now!"/>
            </div>
        </form>
    </div>

</body>
</html>
