<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>add Apartment</title>
    <link rel='stylesheet' href='/webjars/bootstrap/4.5.2/css/bootstrap.min.css'>
</head>
<body>
<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
    <nav class="my-2 my-md-0 mr-md-3">
        <a class="p-2 text-dark" href="/home">Home</a>
        <a class="p-2 text-dark" href="/list/hotel">Hotel list</a>
    </nav>
</div>
<div class="container mt-5 mb-5">
    <h1>Add apartment</h1>
    <form action="/admin/hotel/<c:out value="${hotel.id}"/>/create/apartment" method="post">
        <input type="text" name="name" placeholder="Enter apartment number" class="form-control">
        <br>
        <select name="typeOfApartment">
            <option disabled selected>type of apartment</option>
            <option>cheap apartment</option>
            <option>normal apartment</option>
            <option>lux apartment</option>
        </select>
        <br>
        <br>
        <input type="text" name="price" placeholder="Enter apartment price " class="form-control">
        <br>
        <button type="submit" class="btn btn-success">Add apartment</button>
    </form>
</div>
</body>
</html>