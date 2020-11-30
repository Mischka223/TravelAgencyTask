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
</body>
</html>