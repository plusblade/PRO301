<%-- 
    Document   : viewClass
    Created on : Dec 7, 2021, 10:35:49 AM
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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="../homepage">FAP</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="../homepage">Home <span class="sr-only"></span></a>
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
                <form class="form-inline my-2 my-md-0" action="../logout">                 
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Logout</button>
                </form>
            </div>
        </nav>
        <h1>Total number of students:${requestScope.students.size()} </h1>
        <c:set var="index" value="0" scope="page" />
        <form method="POST" action="attendance">
            <h3>Date:${requestScope.date}
                <input type="hidden" value=${requestScope.date} name="date" />
            </h3>
            <h3>slot ${requestScope.slotID}
                <input type="hidden" value=${requestScope.slotID} name="slotID" />
            </h3>
            <div class="container">
                    <table border="1px" class="table table-striped table-hover">
                        <thead class="thead-dark">
                            <tr>
                                <th>Index</th>
                                <th> ID</th>
                                <th>Name</th>
                                <th>Present</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:if test = "${requestScope.attendances.size()==0}">
                            <input type="hidden" value=false name="exists" />
                            <c:forEach items="${requestScope.students}" var="s" >
                                <c:set var="index" value="${index + 1}" scope="page"/>
                                <tr>
                                    <td><c:out value = "${index}"/>
                                        <input type="hidden" value="${s.id}" name="id" />
                                    </td>
                                    <td>${s.id}</td>
                                    <td>${s.name}</td>
                                    <td><input type="checkbox" name="present${s.id}" value="present"  /></td>
                                </tr>  
                            </c:forEach>
                        </c:if>
                        <c:if test = "${requestScope.attendances.size()!=0}">
                            <input type="hidden" value=true name="exists" />
                            <c:forEach items="${requestScope.attendances}" var="a" >
                                <c:set var="index" value="${index + 1}" scope="page"/>
                                <tr>
                                    <td><c:out value = "${index}"/>
                                        <input type="hidden" value="${a.id}" name="id" />
                                    </td>
                                    <td>${a.student.id}</td>
                                    <td>${a.student.name}</td>
                                    <td><input type="checkbox" class="form-check-input " name="present${a.id}" value="present" <c:if test = "${a.present}">checked="checked"</c:if></td>
                                    </tr>  
                            </c:forEach>
                        </c:if>
                        </tbody>
                    </table>
                </div>
                <div class="d-flex flex-row-reverse bd-highlight">
                    <div class="p-2 bd-highlight">
                        <input type="submit" value="Save" class="btn btn-success btn-md float-right" />
                    </div>
                </div>
        </form>
    </body>
</html>
