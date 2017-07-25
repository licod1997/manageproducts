<%-- 
    Document   : view
    Created on : Mar 10, 2017, 1:06:39 AM
    Author     : Notebook
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product</title>
    </head>
    <body>
        <font color="red">
        Welcome, ${sessionScope.USER}
        </font>
        <h1>Product Page</h1>
        <c:set var="result" value="${requestScope.SEARCH}"/>
        <c:if test="${not empty result}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Unit</th>
                        <th>Update</th>
                        <th>Delete</th>
                        <th>Import</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="entry" items="${result}" varStatus="counter">
                    <form action="RedirectServlet">
                        <tr>
                            <td>
                                ${counter.count}
                            </td>
                            <td>
                                ${entry.productName}
                            </td>
                            <td>
                                <input type="text" name="txtPrice" value="${entry.price}" />
                            </td>
                            <td>
                                ${entry.quantity}
                            </td>
                            <td>
                                <input type="text" name="txtUnit" value="${entry.unit}" />
                            </td>
                            <td>
                                <input type="hidden" name="txtProductID" value="${entry.productID}" />
                                <input type="submit" value="Update" name="btAction" />
                            </td>
                            <td>
                                <input type="submit" value="Delete" name="btAction" />
                            </td>
                            <td>
                                <a href="RedirectServlet?btAction=Import&txtProductID=${entry.productID}">Import</a>
                            </td>
                        </tr>
                    </form>
                </c:forEach>
            </tbody>
        </table>
        <c:set var="update" value="${requestScope.UPDATE}"/>
        <font color="red">${update.price}</font><br/>
        <font color="red">${update.unit}</font><br/>
    </c:if>
    <c:if test="${empty result}">
        <h3>
            <font color="red">No record was found!!!</font>
        </h3>
    </c:if>
    <h1>Product Page</h1>    
    <c:set var="insert" value="${requestScope.INSERT}"/>
    <form action="RedirectServlet">
        ID: <input type="text" name="txtInsertID" value="" /><br/>
        <font color="red">${insert.productID}</font><br/>
        Name: <input type="text" name="txtInsertName" value="" /><br/>
        <font color="red">${insert.productName}</font><br/>
        Unit: <input type="text" name="txtInsertUnit" value="" /><br/>
        <font color="red">${insert.unit}</font><br/>
        <input type="submit" value="Insert" name="btAction" /><br/>
    </form>
</body>
</html>
