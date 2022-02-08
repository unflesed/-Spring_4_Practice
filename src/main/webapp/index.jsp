<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<body>
<h2>Hello it's carsBase!</h2>
<sec:authorize access="hasAuthority('ROLE_ADMIN')">
    <h1>For admin only<-</h1>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
    <h2>Hello, <sec:authentication property="name"/>!</h2>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
    <h1>Another header for authenticated user!!!</h1>
    <h3><sec:authentication property="name"/></h3>
    <p><sec:authentication property="details"/></p>
    <p><sec:authentication property="principal"/></p>
</sec:authorize>
</body>
</html>

