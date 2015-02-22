<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Register Form</title>
    <link href="<c:url value='/CSS/main.css'/>" type="text/css" rel="stylesheet">
</head>
<body>
<div class="frmBox">
    <form id="signInForm" class="form" method="post" action="/myApp/addUser" onsubmit="return validateForm()">
        <label>Name :</label>
        <input type="text" name="name" id="name">
        <br><br>
        <label>Email :</label>
        <input type="text" name="email" id="email">
        <br><br>
        <label>Password :</label>
        <input type="password" name="password" id="password">
        <br><br>
        <label>Confirm Password :</label>
        <input type="password" name="cPassword" id="cPassword">
        <br><br>
        <input type="submit" value="Register">
    </form>
    <div class="messageBar">
        <h3 class="messageText">
            <c:if test="${not empty message}">
                <p>${message}</p>
            </c:if>
        </h3>
    </div>
</div>

<script type="text/javascript" src="<c:url value='/JS/jquery-1.11.2.js'/>"></script>
<script type="text/javascript" src="<c:url value='/JS/signIn.js'/>"></script>
</body>
</html>
