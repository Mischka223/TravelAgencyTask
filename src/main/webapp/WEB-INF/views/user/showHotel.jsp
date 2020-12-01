<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>HelloWorld page</title>
</head>
<body>
<br/>
<br/>
<p>id: <c:out value="${hotel.id}"/></p>
<br/>
<p>name: <c:out value="${hotel.name}"/></p>
<br/>
<p>country: <c:out value="${hotel.country}"/></p>
<br/>
<p>description: <c:out value="${hotel.description}"/></p>
<br/>


<c:if test="${!empty apartments}">
    <table border="1">
        <tr>
            <th width="80">ID</th>
            <th width="120">Name</th>
            <th width="30">typeOfApartment</th>
            <th width="60">price</th>
            <th width="100">description</th>
        </tr>
        <c:forEach items="${apartments}" var="apartment">
            <td><c:out value="${apartment.id}"/></td>
            <td><c:out value="${apartment.name}"/></td>
            <td><c:out value="${apartment.typeOfApartment}"/></td>
            <td><c:out value="${apartment.price}"/></td>
            <td><c:out value="${apartment.description}"/></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>