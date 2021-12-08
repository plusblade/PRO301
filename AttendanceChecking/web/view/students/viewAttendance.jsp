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
    </head>
    <body>
        <div>
            <table border="1px">
                <tr>
                    <th>Index</th>
                    <th> Date</th>
                    <th>Slot</th>
                    <th>Status</th>
                </tr>
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
            </table>
        </div>
    </body>
</html>
