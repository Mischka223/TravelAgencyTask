<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Edit apartment</title>
</head>

<body>
<style>
    select {
        text-align: center;
        align-content: center;
        padding: 6px;
        margin-left: 580px;
        border: 10px solid gray;
    }

    h1 {
        color: gray;
        text-align: center;
    }

    hr {
        margin: 40px;
    }

    li {
        display: inline;
        padding: 10px;
        float: right;

    }

    input {
        text-align: center;
        align-content: center;
        padding: 6px;
        margin-left: 580px;
        border: 10px solid gray;
    }

    button {
        border: 5px solid gray;
        margin-left: 580px;
    }

    button:hover {
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
    <h1>Edit Apartment</h1>

    <form action="/admin/hotel/<c:out value="${hotel.id}"/>/apartment/<c:out value="${apartment.id}"/>/edit"
          method="post">
        <input type="text" name="<c:out value="${apartment.name}"/>" placeholder="Enter Hotel name"
               class="form-control"><br>
        <input type="text" name="<c:out value="${apartment.description}"/>" placeholder="Enter apartment rooms"
               class="form-control"><br>
        <input type="text" name="<c:out value="${apartment.rooms}"/>" placeholder="Enter hotel description"
               class="form-control"><br>
        <button type="submit" class="btn btn-success">Update hotel</button>
    </form>
</div>

</body>
</body>
</html>
