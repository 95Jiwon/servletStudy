<%@ page import="com.korai.servletstudy02.model.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Jiwon
  Date: 26. 10. 26.
  Time: 오후 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <style>
            table{
                border: 1px solid #222;
                border-collapse: collapse;
            }

            th, td {
                border: 1px solid #222;
                width: 300px;
                height: 40px;
            }
        </style>
    </head>
    <body>
        <button onclick="location.href='http://localhost:8080/user/register'">등록</button>
        <div>
            <table>
                <thread>
                    <%
                        List<User> userList = (List<User>) request.getAttribute("userList");
                    %>
                    <tr>
                        <th>번호</th>
                        <th>사용자이름</th>
                        <th>비밀번호</th>
                        <th>성명</th>
                    </tr>
                </thread>
                <tbody>
                    <%
                        for(User user: userList) {
                    %>
                    <tr>
                        <td><%=user.getId()%></td>
                        <td><%=user.getUsername()%>></td>
                        <td><%=user.getPassword()%></td>
                        <td><%=user.getName()%></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
    </body>
</html>
