<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>MyApp</title>
    <link href="<c:url value='/CSS/main.css'/>" type="text/css" rel="stylesheet">
</head>

<body>
<div class="frmBox">
    <h1>Login Here</h1>

    <form action="/myApp/home" method="post" target="_blank" id="frm" >
        <label>User Name:</label>
        <input type="text" name="userName" placeholder="User Name">
        <br><br>
        <label>Password :</label>
        <input type="text" name="password" placeholder="Password">
        <br><br><br>
        <input type="submit" value="Sign In" class="log-button">

    </form>
    <button id="addUser" class="log-button">Sign UP</button>

    <div class="messageBar">
        <h3 class="messageText">
            <c:if test="${not empty message}">
                <p>${message}</p>
            </c:if>
        </h3>
    </div>
</div>


<script type="text/javascript" src="<c:url value='/JS/jquery-1.11.2.js'/>"></script>
<script type="text/javascript" src="<c:url value='/JS/login.js'/>"></script>
</body>
</html>
