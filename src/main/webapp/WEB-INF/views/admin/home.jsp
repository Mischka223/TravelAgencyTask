<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home</title>
    <link rel='stylesheet' href='/webjars/bootstrap/4.5.2/css/bootstrap.min.css'>
</head>
<body>
<style>
    .btn {
        margin-left: 1100px;
    }
</style>

<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
    <nav class="my-2 my-md-0 mr-md-3">
        <a class="p-2 text-dark" href="/list/hotel">Hotel list</a>
        <form class="btn" action="/login/logout" method="post">
            <button type="submit">Logout</button>
        </form>
    </nav>
</div>
<br>
<div class="container mt-5 mb-5">
    <h1>Select country</h1>

    <form action="/list/hotel" method="get">
        <select name="country">
            <option disabled selected>Countries</option>
            <c:forEach var="country" items="${countries}">
                <option value="<c:out value="${country}"/>"><c:out value="${country}"/></option>
            </c:forEach>
        </select>
        </br>
        <button type="submit" class="btn-link">Select</button>
    </form>

</div>
</body>
</body>
</html>
