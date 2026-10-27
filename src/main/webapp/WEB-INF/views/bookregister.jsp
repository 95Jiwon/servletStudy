<%--
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
</head>
<body>
    <form method ="POST" onsubmit="handleOnChange(event)">
        <div>
            <input type="text" name="bookname" placeholder="책 이름" onkeyup="handleOnChange(event)">
        </div>
        <div>
            <input type="text" name="price" placeholder="가격" onkeyup="handleOnChange(event)">
        </div>
        <button type="submit">등록</button>
    </form>
    <script>
        let book ={
            id: "",
            bookname: "",
            price: "",
        };

        function handleOnChange(event){
            const name = event.target.name;
            const value = event.target.value;
            book = {
                ...book,
                [name]: value,
            };
            console.log(book);
        }

        async function BookRegister(data){
            const jsonData = JSON.stringify(book);
            const response = await fetch("http://localhost:8000/api/books", {
                method: "post",
                headers: {
                    "Content-Type": "application/json",
                },
                body: jsonData,
            });
            console.log(response);

            const responseBody = await response.json();
            console.log(responseBody);
            alert(responseBody.message);

            if(response.status !== 200){
                return;
            }else {
                console.log(responseBody);
            }
            location.replace("book/list");
        }

        function handleOnSubmit(event){
            event.preventDefault();
            registerApi(book);
        }
    </script>
</body>
</html>
