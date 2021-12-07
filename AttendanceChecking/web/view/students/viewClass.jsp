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
    </head>
    <body>
        <h1>Total number of students:${requestScope.students.size()} </h1>
        <c:set var="index" value="0" scope="page" />
        <form method="POST" action="attendance">
            <h3>Date:${requestScope.date}
                <input type="hidden" value=${requestScope.date} name="date" />
            </h3>
            <h3>slot ${requestScope.slotID}
                <input type="hidden" value=${requestScope.slotID} name="slotID" />
            </h3>
            <table border="1px">
                <tr>
                    <th>Index</th>
                    <th> ID</th>
                    <th>Name</th>
                    <th>Present</th>
                </tr>
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
                            <td><input type="checkbox" name="present${a.id}" value="present" <c:if test = "${a.present}">checked="checked"</c:if></td>
                            </tr>  
                    </c:forEach>
                </c:if>        
            </table>
            <input type="submit" value="Save"/>
        </form>
    </body>
</html>
