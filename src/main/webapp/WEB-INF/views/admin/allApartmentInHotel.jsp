<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Apartments in hotel</title>
</head>
<body>

<c:if test="${!empty apartments}">
    <table border="1">
        <tr>
            <th width="80">ID</th>
            <th width="120">Name</th>
            <th width="100">description</th>
            <th width="80">Delete</th>
            <th width="90">Edit</th>
        </tr>
        <c:forEach items="${apartments}" var="apartment">
            <td><c:out value="${apartment.id}"/></td>
            <td><c:out value="${apartment.name}"/></td>
            <td><c:out value="${apartment.description}"/></td>

            <td>
                <form action="/admin/hotel/<c:out value="${apartment.id}"/>/apartment/<c:out value="${apartment.id}"/>/delete"
                      method="post">
                    <button type="submit" class="btn-link">Delete</button>
                </form>
            </td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
