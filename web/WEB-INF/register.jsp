<%-- 
    Document   : register
    Created on : Oct 23, 2020, 8:22:29 PM
    Author     : 818736
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action="ShoppingList" method="get">
            Username: <input type="text" name="username" value="${username}">
            <input type="hidden" name="action" value="register" >
            <input type="submit" value="Register" >
        </form>
    </body>
</html>
