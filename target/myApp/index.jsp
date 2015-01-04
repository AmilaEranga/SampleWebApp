<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>MyApp</title>
    <link href="<c:url value='/CSS/main.css'/>" type="text/css" rel="stylesheet">
</head>

<body>
<div id="frmBox">
    <form action="http://localhost:8080/myApp/home" method="GET" target="_blank" id="frm">
        <label>First name:</label>
        <input type="text" name="firstName" placeholder="FirstName">
        <br><br>
        <label>Last name:</label>
        <input type="text" name="lastName" placeholder="LastName">
        <br><br><br>
        <input type="submit" value="Submit">
    </form>
</div>

<script type="text/javascript" src="<c:url value='/JS/main.js'/>"></script>
</body>
</html>
