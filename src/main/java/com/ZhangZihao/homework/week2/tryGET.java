package com.ZhangZihao.homework.week2;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "test", value = "/ttt")
public class tryGET extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println(
                "<!DOCTYPE HTML>\n" +
                        "<html>\n" +
                        "\n" +
                        "\n" +
                        "<head>\n" +
                        "    <title>\n" +
                        "        who？（LOL）\n" +
                        "    </title>\n" +
                        "\n" +
                        "    <style>\n" +
                        "        p {\n" +
                        "            margin:0px;\n" +
                        "            padding:0px;\n" +
                        "        }\n" +
                        "\n" +
                        "        p span {\n" +
                        "            text-decoration: underline;\n" +
                        "            text-decoration-color: red;\n" +
                        "        }\n" +
                        "\n" +
                        "        body {\n" +
                        "            text-align: center;\n" +
                        "            background-image: url(../pic/无标题.png)\n" +
                        "        }\n" +
                        "\n" +
                        "        .pic {\n" +
                        "            width: 180px;\n" +
                        "            text-align: center;\n" +
                        "            float: right;\n" +
                        "            clear: right;\n" +
                        "            padding: 0px;\n" +
                        "            margin: 0px;\n" +
                        "        }\n" +
                        "\n" +
                        "        #main {\n" +
                        "            text-align: left;\n" +
                        "            display: inline-block;\n" +
                        "            padding: 30px 10px;\n" +
                        "            width: 500px;\n" +
                        "            height: 480px;\n" +
                        "            border-style: double;\n" +
                        "            border-radius: 30px;\n" +
                        "            background: #f9f0cd;\n" +
                        "        }\n" +
                        "\n" +
                        "        #txt0 {\n" +
                        "            color: #ff6a00;\n" +
                        "            font-size: 18px;\n" +
                        "        }\n" +
                        "\n" +
                        "        #txt1 {\n" +
                        "            color: blue;\n" +
                        "            font-size: 23px;\n" +
                        "            text-decoration:none;\n" +
                        "        }\n" +
                        "\n" +
                        "        #txt2 {\n" +
                        "            color: forestgreen;\n" +
                        "            font-size: 15px;\n" +
                        "        }\n" +
                        "    </style>\n" +
                        "\n" +
                        "</head>\n" +
                        "\n" +
                        "<body bgcolor=#fff2ba>\n" +
                        "    <div id=\"main\">\n" +
                        "        <div style=\"float:right;height:100px;width:0px;\"></div><!--上浮内容占位div-->\n" +
                        "        <div class=\"pic\">\n" +
                        "            <img src=\"../pic/eye.jpg\" width=\"180\" alt=\" Something is gone down（LOL）\">\n" +
                        "            <p style=\"margin:0px; padding:0px;\"><a href=\"../pic/eye_big.jpg\">公主殿下</a></p><!--0距以紧贴图片-->\n" +
                        "        </div>\n" +
                        "        <p>\n" +
                        "            <span id=\"txt0\">\n" +
                        "                100words\n" +
                        "            </span>\n" +
                        "            <span id=\"txt1\">\n" +
                        "                100words100words100words100words100words\n" +
                        "                100words100words100words100words100words\n" +
                        "                100words100words100words100words100words\n" +
                        "                100words100words100words100words100words\n" +
                        "                100words100words100words100words100words\n" +
                        "            </span>\n" +
                        "        </p>\n" +
                        "        <hr />\n" +
                        "        <p>\n" +
                        "            <span id=\"txt2\">\n" +
                        "                100words100words100words100words100words\n" +
                        "                100words100words100words100words100words\n" +
                        "                100words100words100words100words100words\n" +
                        "                100words100words100words100words100words\n" +
                        "                100words100words100words100words100words\n" +
                        "                100words100words100words100words100words\n" +
                        "                100words100words100words100words100words\n" +
                        "                100words100words100words100words100words\n" +
                        "                100words100words100words100words\n" +
                        "            </span>\n" +
                        "        </p>\n" +
                        "    </div>\n" +
                        "</body>\n" +
                        "\n" +
                        "\n" +
                        "</html>");
    }

    public void destroy() {
    }
}
