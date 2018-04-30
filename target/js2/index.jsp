<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <c:url value="/style.css" var="styleUrl"/>
        <c:url value="/index.js" var="indexUrl"/>
        <c:url value="/login.js" var="loginUrl"/>
        <c:url value="/profile.js" var="profileUrl"/>
        <link rel="stylesheet" type="text/css" href="${styleUrl}">
        <script src="${indexUrl}"></script>
        <script src="${loginUrl}"></script>
        <script src="${profileUrl}"></script>
        <title>Poet</title>
    </head>
<body>
<div id="login" class="content">
    <h1>Login</h1>
    <form id="login-form" onsubmit="return false;">
        <input type="text" name="email">
        <input type="password" name="password">
        <button id="login-btn">Login</button>
    </form>
</div>
<div id="main-content" class="hidden content">
    <div id="welcome"><p><h1>Welcome <span id="name"></span>! </h1></p></div>
    <p>Your id: <span id="id"></span></p>
    <p>Your email address: <span id="email"></span></p>
    <p>Your secret password: <span id="password"></span></p>
    <div id="titles">
        <p><h3>Poems</h3><br>
        <p><div="title-list"></div></p>
    </div>
</div>

</body>
</html>
