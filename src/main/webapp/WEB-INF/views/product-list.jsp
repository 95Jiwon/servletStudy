<%--
  Created by IntelliJ IDEA.
  User: Jiwon
  Date: 26. 10. 27.
  Time: 오후 5:04
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
            border: 1px solid#222;
            width: 200px;
        }
    </style>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>번호</th>
                <th>상품명</th>
                <th>가격</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>번호</td>
                <td>상품명</td>
                <td>가격</td>
            </tr>
            <tr>
                <td>번호</td>
                <td>상품명</td>
                <td>가격</td>
            </tr>
        </tbody>
    </table>

    <script>

        async function getProductList() {
            const response = await fetch("http://localhost:8080/api/products", {
                method: "GET", // GET은 데이터를 가지고 올 때 사용한다.
                headers: {
                    "Content-Type": "application/json",
                }
            });
            // const responseText = await response.text(); //그냥 json 문자열로 받는다.
            // const responseJson = JSON.parse(responseText); //json을 오브젝트 객체로 변환하여 준다.
            const repsonseJson = await response.json(); // 위 parse와 동일하다.
            console.log(response);
            // console.log(responseText);
            console.log(responseJson);
            const tbody = document.querySelector("tbody");
            tbody.innerHTML = responseJson.map((value, index) => (
                "<tr><td>" + (index +1) + "</td><td>" + (product.productName) + "</td><td>" + (product.price) + "</td></tr>"
            )).join("");
        }

        getProductList();
    </script>
</body>
</html>
