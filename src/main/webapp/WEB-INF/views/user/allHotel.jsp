<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Hotels</title>
</head>
<body>


<c:if test="${!empty hotels}">
    <table border="1">
        <tr>
            <th width="80">ID</th>
            <th width="120">Name</th>
            <th width="100">Country</th>
            <th width="130">description</th>
            <c:if test="${hasWritePermission}">
                <th width="100">Delete</th>
                <th width="100">Edit</th>
            </c:if>
        </tr>
        <c:forEach items="${hotels}" var="hotel">
            <td><c:out value="${hotel.id}"/></td>
            <td><a href="/hotel/<c:out value="${hotel.id}"/>"><c:out value="${hotel.name}"/></a></td>
            <td><c:out value="${hotel.country}"/></td>
            <td><c:out value="${hotel.description}"/></td>
            <c:if test="${hasWritePermission}">
                <td>
                    <form action="/admin/delete/hotel/<c:out value="${hotel.id}"/>" method="post">
                        <button type="submit" class="btn-link">Delete</button>
                    </form>
                </td>
                <td>
                    <form action="/admin/edit/hotel/<c:out value="${hotel.id}"/>" method="get">
                        <button type="submit" name="your_name" value="your_value" class="btn-link">Edit</button>
                    </form>
                </td>
            </c:if>
            </tr>
        </c:forEach>
    </table>
</c:if>
<c:if test="${hasWritePermission}">
    <a href="/admin/create/hotel">add hotel</a>
</c:if>
</body>
</html>
