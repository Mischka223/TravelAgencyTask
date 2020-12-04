<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit hotel</title>
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
    <h1>Edit Hotel</h1>
    <jsp:useBean id="obj" class="com.softserve.travelAgency.model.Country" scope="page"/>
    <form action="/admin/edit/hotel/<c:out value="${hotel.id}"/>" method="post">
        <input type="text" name="name" placeholder="Enter Hotel name" value="<c:out value="${hotel.name}"/> " class="form-control"><br>
        <select name="country">
            <option>Countries</option>
            <c:forEach var="country" items="${countries}">
                <option><c:out value="${country.name}"/></option>
            </c:forEach>
        </select>
        <br>
        <br>
        <input type="text" name="description" placeholder="Enter hotel description" value="<c:out value="${hotel.description}"/>" class="form-control"><br>
        <button type="submit" class="btn btn-success">Edit hotel</button>
    </form>
</div>

</body>
</body>
</html>
