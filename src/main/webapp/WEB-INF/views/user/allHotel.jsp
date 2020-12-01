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

        </tr>
        <c:forEach items="${hotels}" var="hotel">
            <td><c:out value="${hotel.id}"/></td>
            <td><a href="/user/hotel/<c:out value="${hotel.id}"/>"><c:out value="${hotel.name}"/></a></td>
            <td><c:out value="${hotel.country}"/></td>
            <td><c:out value="${hotel.description}"/></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
