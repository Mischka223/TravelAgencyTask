<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>HelloWorld page</title>
</head>
<body>
<a href="/admin/hotel/<c:out value="${hotel.id}"/>/create/apartment">add apartment</a>
<br/>
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
            <th width="100">description</th>
            <th width="130">rooms</th>
            <th width="70">Delete</th>
            <th width="90">Edit</th>
        </tr>
        <c:forEach items="${apartments}" var="apartment">
            <td><c:out value="${apartment.id}"/></td>
            <td><c:out value="${apartment.name}"/></td>
            <td><c:out value="${apartment.description}"/></td>
            <td><c:out value="${apartment.rooms}"/></td>
            <td>
                <form action="/admin/hotel/<c:out value="${hotel.id}"/>/apartment/<c:out value="${apartment.id}"/>/delete"
                      method="post">
                    <button type="submit" class="btn-link">Delete</button>
                </form>
            </td>
            <td>
                <form action="/admin/hotel/<c:out value="${hotel.id}"/>/apartment/<c:out value="${apartment.id}"/>/edit"
                      method="post">
                    <button type="submit" class="btn-link">Edit</button>
                </form>
            </td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>