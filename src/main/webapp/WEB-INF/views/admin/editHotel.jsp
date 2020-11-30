<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Edit hotel</title>
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
<div>
    <ul>
        <a href="/admin/home"> Home </a>
    </ul>
</div>
<br>
<hr>
<div class="container mt-5 mb-5">
    <h1>Edit Hotel</h1>
    <jsp:useBean id="obj" class="ua.travelAgency.model.Country" scope="page"/>
    <form action="/admin/edit/hotel/<c:out value="${hotel.id}"/>" method="post">
        <input type="text" name="name" placeholder="Enter Hotel name" class="form-control"><br>
        <p><select name="country">
            <option>Countries</option>
            <c:forEach var="country" items="${countries}">
                <option><c:out value="${country.name}"/>Countries</option>
            </c:forEach>
        </select></p>

        <input type="text" name="description" placeholder="Enter hotel description" class="form-control"><br>
        <button type="submit" class="btn btn-success">Update hotel</button>
    </form>
</div>

</body>
</body>
</html>
