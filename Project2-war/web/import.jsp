<%-- 
    Document   : mport
    Created on : Mar 10, 2017, 9:40:34 AM
    Author     : Notebook
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Import</title>
    </head>
    <body>
        <font color="red">
        Welcome, ${sessionScope.USER}
        </font>
        <h1>Import Page</h1>
        <h3>
            <font color="red">
            Product name: ${sessionScope.IMPORT.productName}
            </font>
        </h3>
        <c:set var="save" value="${requestScope.SAVE}"/>
        <form action="RedirectServlet">
            Price: <input type="text" name="txtPrice" value="" /><br/>
            <font color="red">${save.price}</font><br/>
            Quantity: <input type="text" name="txtQuantity" value="" /><br/>
            <font color="red">${save.quantity}</font><br/>
            <input type="submit" value="Save" name="btAction"/>
            <input type="submit" value="Cancel" name="btAction"/>
        </form>
    </body>
</html>
