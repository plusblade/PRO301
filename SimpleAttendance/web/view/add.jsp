<%-- 
    Document   : report
    Created on : Dec 7, 2021, 2:18:38 PM
    Author     : pluso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table, th, td {
                border:1px solid black;
            }
        </style>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="add" method="Post">
        <table >
            <tr>
                <th>Student</th>
                <th>Date</th>
                <th>present</th>
            </tr>
            <c:forEach items="${requestScope.students}" var="s">
                <tr>
                    <td>
                        ${s.name}
                        <input type="hidden" value=${s.id}/>
                    </td>
                    <td>
                        <input type="date" name="${s.id}"
                    <td>
                        <input type="checkbox" value="at.aid" name="checkbox"/>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <br/>
        <input type="submit" value="Save" />
        </form>
    </body>
</html>
