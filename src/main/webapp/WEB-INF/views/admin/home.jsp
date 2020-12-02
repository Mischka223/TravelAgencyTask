<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Home</title>
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

<br>
<hr>
<div class="container mt-5 mb-5">
    <h1>Select country</h1>

    <form action="/list/hotel" method="get">
        <select name="country">
            <option>Countries</option>
            <c:forEach var="country" items="${countries}">
            <option value="<c:out value="${country}"/>"><c:out value="${country}"/></option>
            </c:forEach>
        </select>
        <button type="submit"   class="btn-link">Edit</button>
    </form>

</div>

</body>
</body>
</html>
