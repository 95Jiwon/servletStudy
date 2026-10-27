<%--
  Created by IntelliJ IDEA.
  User: Jiwon
  Date: 26. 10. 27.
  Time: 오후 3:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <input placeholder="productName" onkeyup="handleProductNameInputOnKeyUp(event)">
    <input placeholder="가격" onkeyup="handlePriceInputOnKeyUp(event)">
    <button onclick="handleRegisterButtonOnClick(event)">등록</button>
    <script>
        let product = {
            productName: "",
            price: 0,
        }

        function handleProductNameInputOnKeyUp(e){
            console.log(e.target.value);
            product ={
                ...product,
                productName: e.target.value,
            }
        }

        function handlePriceInputOnKeyUp(e){
            console.log(e.target.value);
            product ={
                ...product,
                price: e.target.value,
            }
        }

        function handleRegisterButtonOnClick(e) {
            console.log(JSON.stringify(product));

            fetch("http://localhost:8080/api/products", {
                method: "POST",                                     //POST요청은 creat
                body: JSON.stringify(product),
                headers: {
                    "Content-Type": "application/json",
                }
            });
        }
    </script>
</body>
</html>
