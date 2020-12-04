<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Apartments</title>
    <link rel='stylesheet' href='/webjars/bootstrap/4.5.2/css/bootstrap.min.css'>
</head>
<body>
<style>
    .col-md-4 {
        display: inline-flex;
        justify-content: space-around;
    }
</style>
<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
    <nav class="my-2 my-md-0 mr-md-3">
        <c:if test="${hasWritePermission}">
            <a class="p-2 text-dark" href="/admin/hotel/<c:out value="${hotel.id}"/>/create/apartment">Add apartment</a>
        </c:if>
        <a class="p-2 text-dark" href="/home">Home</a>
        <a class="p-2 text-dark" href="/list/hotel">Hotel list</a>
    </nav>
</div>
<center><h1>Apartments in <c:out value="${hotel.name}"/> hotel</h1></center>

<c:forEach items="${apartments}" var="apartment">
    <div class="col-md-4">
        <div class="card mb-4 shadow-sm">
            <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg"
                 preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: Thumbnail">
                <title>Placeholder</title>
                <rect width="100%" height="100%" fill="#55595c"></rect>
                <text x="50%" y="50%" fill="#eceeef" dy=".3em"><c:out value="${apartment.name}"/></text>
            </svg>
            <div class="card-body">
                <div class="d-flex justify-content-between align-items-center">
                    <div class="btn-group">

                        <c:if test="${hasWritePermission}">
                            <form action="/admin/hotel/<c:out value="${hotel.id}"/>/apartment/<c:out value="${apartment.id}"/>/edit"
                                  method="get">
                                <button type="submit" class="btn btn-sm btn-outline-secondary">Edit</button>
                            </form>
                            <form action="/admin/hotel/<c:out value="${hotel.id}"/>/apartment/<c:out value="${apartment.id}"/>/delete"
                                  method="post">
                                <button type="submit" class="btn btn-sm btn-outline-secondary">Delete</button>
                                <br>
                                <label type="text">Price per day: <c:out value="${apartment.price}"/> </label>
                            </form>

                        </c:if>
                    </div>
                    <small class="text-muted"></small>
                </div>
            </div>
        </div>
    </div>

</c:forEach>

</body>
</html>