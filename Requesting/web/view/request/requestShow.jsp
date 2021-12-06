<%-- 
    Document   : requestShow
    Created on : Dec 6, 2021, 2:34:48 PM
    Author     : pluso
--%>

<%@page import="model.Request"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <% ArrayList<Request> requests = (ArrayList<Request>) request.getAttribute("requests");%>
    </head>
    <body>
        <h1>Request list</h1>
        <table >
            <tr>
                <th>id</th>
                <th>tittle</th>
            </tr>
            <% for (Request req : requests) {%>
            <tr>
                <td><%=req.getId()%></td>
                <td><%=req.getTittle()%></td>
            </tr>
            <%}%>

        </table>
    </body>
</html>
