<%-- 
    Document   : shoppingList
    Created on : Oct 23, 2020, 8:22:49 PM
    Author     : 818736
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>        

        Hello, ${username} <a href="ShoppingList?action=logout">Logout</a>
        <h2>List</h2>
        <form method="post" action="ShoppingList">
            Add item: <input type="text" name="listItem" value="${item}">
            <input name="action" value="add" type="hidden">
            <input type="submit" value="Add">
        </form>
        
             <form method="post" action="ShoppingList">
                 <ul>
                     <input type="hidden" name="counter" value="0">
                     <c:forEach items="${shoplist}" var="item">
                         <li><input type="radio" name="listItems" value="${item}">${item}</input></li>
                     </c:forEach>
                     
                 </ul>
            <input name="action" value="delete" type="hidden">
            <input type="submit" value="Delete">
        </form>
    </body>
</html>
