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
            ArrayList<ClassGroup> cgs = (ArrayList<ClassGroup>) request.getAttribute("classes");
            ArrayList<ClassTime> cts = (ArrayList<ClassTime>) request.getAttribute("times");
        %>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </head>
    <body>
        <h1>Attendance Checking</h1>
        <div>
            <form action="homepage" method="Post">
                Choose class: 
                <select name="class" class="form-select">
                    <% for (ClassGroup cg : cgs) {%>
                    <option value=<%=cg.getId()%>><%=cg.getName()%></option>
                    <%}%>
                </select>
                <br/>
                Date:
                <input type="date" name="date" required/><br/>
                Time: 
                <select name="slotID" class="form-select" >
                    <% for (ClassTime ct : cts) {%>
                    <option value=<%=ct.getSlotID()%>>Slot <%=ct.getSlotID()%>-<%=ct.getTime()%></option>
                    <%}%>
                </select>
                <br/>
                <input type="submit" value="Check">
            </form>
        </div>
    </body>
</html>
