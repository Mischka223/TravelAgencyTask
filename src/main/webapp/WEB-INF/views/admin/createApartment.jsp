<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>create Apartment</title>
</head>
<body>
<style>
    select{
        text-align: center;
        align-content: center;
        padding: 6px;
        margin-left: 580px;
        border: 10px solid gray;
    }
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
    <form  action="/admin/hotel/<c:out value="${hotel.id}"/>/create/apartment" method="post">
        <label>
            <input type="text" name="name" placeholder="Enter apartment name" class="form-control">
        </label><br>
        <select name="typeOfApartment">
            <option>type of apartment</option>
                <option>cheap apartment</option>
                <option>normal apartment</option>
                <option>lux apartment</option>
        </select>
        <label>
            <input type="text" name="description" placeholder="Enter apartment description " class="form-control">
        </label><br>
        <label>
            <input type="text" name="price" placeholder="Enter apartment price " class="form-control">
        </label><br>
        <button type="submit" class="btn btn-success">Add apartment</button>
    </form>
</div>
</body>
</html>