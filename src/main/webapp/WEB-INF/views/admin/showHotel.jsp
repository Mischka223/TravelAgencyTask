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
<c:out value="${hotel.id}"/>
<c:out value="${hotel.name}"/>
<c:out value="${hotel.country}"/>
<c:out value="${hotel.description}"/>
</body>
</html>