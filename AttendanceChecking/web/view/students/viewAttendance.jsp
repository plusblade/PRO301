<%-- 
    Document   : viewAttendance
    Created on : Dec 8, 2021, 10:19:55 PM
    Author     : pluso
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container">
            <table border="1px" class="table table-striped table-hover">
                <thead class="thead-dark">
                    <tr>
                        <th>Index</th>
                        <th> Date</th>
                        <th>Slot</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                <input type="hidden" value=false name="exists" />
                <c:forEach items="${requestScope.attendances}" var="a" >
                    <c:set var="index" value="${index + 1}" scope="page"/>
                    <tr>
                        <td><c:out value = "${index}"/></td>                           
                        <td>${a.date}</td>
                        <td>${a.slotID}</td>
                        <td>
                            <c:if test="${a.present}">Present</c:if>
                            <c:if test="${!a.present}">Absent</c:if>
                            </td>
                        </tr>  
                </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
