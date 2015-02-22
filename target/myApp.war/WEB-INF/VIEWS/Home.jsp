<%--
  Created by IntelliJ IDEA.
  User: amila
  Date: 1/3/15
  Time: 11:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>

<html>
<head>
    <title>Hii</title>
</head>
<body>

<c:if test="${not empty firstName}">
    Hi ${firstName},
    <br>
    login successful.
</c:if>

<c:if test="${not empty error}">
    ${error},
</c:if>

</body>
</html>
