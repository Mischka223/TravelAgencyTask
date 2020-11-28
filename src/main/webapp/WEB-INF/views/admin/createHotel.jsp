<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 28.11.2020
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<style>
    h1{
        color: gray;
        text-align: center;
    }
    hr{
        margin: 40px;
    }
    li{
        display: inline;
        padding: 10px;
        float: right;

    }

    input{
        text-align: center;
        align-content: center;
        padding: 6px;
        margin-left: 580px;
        border : 10px solid gray;
    }
    button{
        border: 5px solid gray;
        margin-left: 580px ;
    }
    button:hover{
        border: 5px solid firebrick;
    }
</style>
<div>
    <ul>
        <a href="/home"> Home </a>
    </ul>
</div>
<br>
<hr>
<div class="container mt-5 mb-5">
    <h1>Add Hotel</h1>
    <form  action="/admin/create/hotel/" method="post">
        <input type="text" name="name" placeholder="Enter Hotel name" class="form-control"><br>
        <input type="text" name="country" placeholder="Enter hotel country" class="form-control"><br>
        <input type="text" name="description" placeholder="Enter hotel description" class="form-control"><br>
        <button type="submit" class="btn btn-success">Add hotel</button>
    </form>
</div>
</body>
</html>
