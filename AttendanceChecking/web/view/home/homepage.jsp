<%-- 
    Document   : class
    Created on : Dec 3, 2021, 6:30:38 PM
    Author     : pluso
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.ClassTime"%>
<%@page import="model.ClassGroup"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <% 
            ArrayList<ClassGroup>cgs=(ArrayList<ClassGroup>)request.getAttribute("classes");
            ArrayList<ClassTime>cts=(ArrayList<ClassTime>)request.getAttribute("times");
        %>
    </head>
    <body>
        <h1>Attendance Checking</h1>
        <div>
            <form action="homepage" method="Post">
                Choose class: 
                <select name="class">
                    <% for(ClassGroup cg: cgs){%>
                    <option value=<%=cg.getId()%>><%=cg.getName()%></option>
                    <%}%>
                </select>
                <br/>
                Date:
                <input type="date" name="date"/><br/>
                Time: 
                <select name="slotID">
                    <% for(ClassTime ct: cts){%>
                    <option value=<%=ct.getSlotID()%>>Slot <%=ct.getSlotID()%>-<%=ct.getTime()%></option>
                    <%}%>
                </select>
                <br/>
                <input type="submit" value="Check">
            </form>
        </div>
    </body>
</html>
