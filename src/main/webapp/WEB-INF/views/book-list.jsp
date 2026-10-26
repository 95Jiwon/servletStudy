<%@ page import="com.korai.servletstudy02.model.Book" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Jiwon
  Date: 26. 10. 26.
  Time: 오후 4:50
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
<button onclick="location.href='http://localhost:8080/book/bookregister'">등록</button>
<div>
    <table>
        <thread>
            <%
                List<Book> bookList = (List<Book>) request.getAttribute("bookList");
            %>
            <tr>
                <th>번호</th>
                <th>책 이름</th>
                <th>가격</th>
            </tr>
        </thread>
        <tbody>
        <%
            for(Book book: bookList) {
        %>
        <tr>
            <td><%=book.getId()%></td>
            <td><%=book.getBookName()%>></td>
            <td><%=book.getPrice()%></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
