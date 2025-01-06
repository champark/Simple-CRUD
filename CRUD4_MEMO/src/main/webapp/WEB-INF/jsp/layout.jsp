<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title><%= request.getAttribute("title") %></title>
</head>
<body>
<header>
    <%@ include file="header.jsp" %>
</header>
<main>
    <jsp:include page="${contentPage}" />
</main>
<footer>
    <%@ include file="footer.jsp" %>
</footer>
</body>
</html>
