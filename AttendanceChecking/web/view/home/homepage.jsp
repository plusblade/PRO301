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
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="homepage">FAP</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="homepage">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Function</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Function
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="#">Action</a>
                            <a class="dropdown-item" href="#">Another action</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">Something else here</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#">Disabled</a>
                    </li>
                </ul>
                <form class="form-inline my-2 my-md-0" action="logout">                 
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Logout</button>
                </form>
            </div>
        </nav>
        <h1>Attendance Checking</h1>
        <div class=" col-6 col-md-4 col-md-offset-4  align-self-center">
            <div class="form-group">
                <form action="homepage" method="Post">
                    <div class="form-group">
                        Choose class: 
                        <select name="class" class="form-select">
                            <% for (ClassGroup cg : cgs) {%>
                            <option value=<%=cg.getId()%>><%=cg.getName()%></option>
                            <%}%>
                        </select>
                    </div>
                    <div class="form-group" >
                        Date:
                        <input type="date" name="date" class="input-group date" required /><br/>
                    </div>
                    <div class="form-group">
                        Time: 
                        <select name="slotID" class="form-select" >
                            <% for (ClassTime ct : cts) {%>
                            <option value=<%=ct.getSlotID()%>>Slot <%=ct.getSlotID()%>-<%=ct.getTime()%></option>
                            <%}%>
                        </select>
                    </div>
                    <input type="submit" value="Check">
                </form>
            </div>
        </div>
    </body>
</html>
