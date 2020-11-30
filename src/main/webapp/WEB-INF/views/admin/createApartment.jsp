<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>add Apartment</title>
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
<br>
<hr>
<div class="container mt-5 mb-5">
    <h1>Add apartment</h1>
    <form  action="/admin/hotel/44/create/apartment" method="post">
        <label>
            <input type="text" name="name" placeholder="Enter apartment name" class="form-control">
        </label><br>
        <label>
            <input type="text" name="rooms" placeholder="Enter apartment " class="form-control">
        </label><br>
        <label>
            <input type="text" name="description" placeholder="Enter apartment description" class="form-control">
        </label><br>
        <button type="submit" class="btn btn-success">Add apartment</button>
    </form>
</div>
</body>
</html>