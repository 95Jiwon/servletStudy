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
</head>
<body>
    <input placeholder="모델명" onkeyup="handleCarModelInputOnKeyUp(event)">
    <input placeholder="색상" onkeyup="handleCarColorInputOnKeyUp(event)">
    <input placeholder="가격" onkeyup="handleCarPriceInputOnKeyUp(event)">
    <button onclick="handleRegisterButtonOnClick(event)">등록</button>
<script>
    let car = {
        carModel: "",
        carColor: "",
        carPrice: 0,
    }

    function handleCarModelInputOnKeyUp(e) {
        console.log(e.target.value);
        car ={
            ...car,
                carModel : e.target.value,
        }
    }

    function handleCarColorInputOnKeyUp(e) {
        console.log(e.target.value);
        car ={
            ...car,
            carColor : e.target.value,
        }
    }

    function handleCarPriceInputOnKeyUp(e) {
        console.log(e.target.value);
        car ={
            ...car,
            carPrice : e.target.value,
        }
    }

    async function handleRegisterButtonOnClick(e) {
        console.log(JSON.stringify(car))

        try {
            const response = await fetch("http://192.168.2.8:8080/api/cars", {
                method: "POST",
                body: JSON.stringify(car),
                headers: {
                    "content-type": "application/json",
                }
            });

            if (response.ok) {
                alert("등록이 완료되었습니다!");
                location.href = "http://192.168.2.8:8080/car/list";
            } else {
                alert("등록에 실패했습니다.");
            }
        }   catch (error) {
            console.error("통신 에러:", error);
        }
    }
</script>
</body>
</html>
