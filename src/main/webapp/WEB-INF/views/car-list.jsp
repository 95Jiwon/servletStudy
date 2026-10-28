<%--
  Created by IntelliJ IDEA.
  User: Jiwon
  Date: 26. 10. 28.
  Time: 오전 9:26
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
            width: 200px;
        }
    </style>
</head>
<body>
<button onclick="location.href='http://localhost:8080/car/register'">등록</button>
    <table>
        <thead>
            <tr>
                <th>번호</th>
                <th>모델명</th>
                <th>색상</th>
                <th>가격(단위 : 만)</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>1</td>
                <td>SM7</td>
                <td>블랙</td>
                <td>1,000</td>
            </tr>
            <tr>
                <td>2</td>
                <td>그랜져</td>
                <td>화이트</td>
                <td>8,000</td>
            </tr>
        </tbody>
    </table>

    <script>
        async function getCarList() {
            try {
            const response = await fetch("http://192.168.2.8:8080/api/cars", {
                method: 'GET',
                headers: {
                    "Content-Type": "application/json",
                }
            });

            if (!response.ok) {
                throw new Error(`서버 응답 에러: ${response.status}`);
            }

            const responseJson = await response.json();
            console.log(responseJson);

            const tbody = document.querySelector("tbody");

            tbody.innerHTML = responseJson.map((car, index) =>
            // {
            //     return '<tr>' +
            //         '<td>' + (index + 1) + '</td>' +
            //         '<td>' + car.carModel + '</td>' +
            //         '<td>' + car.carColor + '</td>' +
            //         '<td>' + car.carPrice + '</td>' +
            //         '</tr>';
            // }).join(""); //이 방법도 존재

            `
                <tr>
                    <td>\${index + 1}</td>
                    <td>\${car.carModel}</td>
                    <td>\${car.carColor}</td>
                    <td>\${car.carPrice}</td>
                </tr>
            `).join("");

        } catch (error) {
            console.error("데이터를 불러오는 중 문제가 발생했습니다:", error);
        }
    }
        getCarList();
    </script>
</body>
</html>
