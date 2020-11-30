<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Hotels</title>
</head>
<body>

<c:if test="${!empty apartments}">
    <table border="1">
        <tr>
            <th width="80">ID</th>
            <th width="120">Name</th>
            <th width="100">description</th>
            <th width="130">rooms</th>
        </tr>
        <c:forEach items="${apartments}" var="apartment">
            <td><c:out value="${apartment.id}"/></td>
            <td><c:out value="${apartment.name}"/></td>
            <td><c:out value="${apartment.description}"/></td>
            <td><c:out value="${apartment.rooms}"/></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
