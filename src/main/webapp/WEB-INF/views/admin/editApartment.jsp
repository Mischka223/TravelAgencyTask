<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit apartment</title>
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
    <h1>Edit Apartment</h1>

    <form action="/admin/hotel/<c:out value="${hotel.id}"/>/apartment/<c:out value="${apartment.id}"/>/edit"
          method="post">
        <label>
            <input type="text" name="name" value="<c:out value="${apartment.name}"/>" placeholder="Enter Hotel name"
                   class="form-control">
        </label><br>
        <select name="typeOfApartment">
            <option>type of apartment</option>
            <option>cheap apartment</option>
            <option>normal apartment</option>
            <option>lux apartment</option>
        </select>
        <input type="text" name="price" value="<c:out value="${apartment.price}"/>" placeholder="Enter apartment price"
               class="form-control"><br>

        <button type="submit" class="btn btn-success">Edit apartment</button>
    </form>
</div>
</body>
</body>
</html>
