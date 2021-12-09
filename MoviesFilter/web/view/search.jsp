<%-- 
    Document   : search
    Created on : Dec 9, 2021, 1:30:46 PM
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
        <form action="search" method="Post">
            <div>
                <h3>Actor</h3>
                <c:forEach items="${requestScope.actors}" var="a">
                    <input type="hidden" name="aid" value="${a.aid}"/>
                    ${a.name}
                    <input type="checkbox" name="actor${a.aid}" value="check"/>
                </c:forEach>
            </div>
            <div>
                <h3>Category</h3>
                <c:forEach items="${requestScope.categories}" var="c">
                    <input type="hidden" name="cid" value="${c.cid}"/>
                    ${c.name}
                    <input type="checkbox" name="category${c.cid}" value="check"/>
                </c:forEach>
            </div>
            <div>
                <input type="submit" value="Search"/>
            </div>
        </form>
        <c:if test="${requestScope.movies.size()>0}">
            <table border="1px">
                <tr>
                    <td>Name</td>
                </tr>
                <c:forEach items="${requestScope.movies}" var="m">
                    <tr>
                        <td>${m.tittle}</td>
                    </tr>
                </c:forEach>
            </table>
            <a href="search">
                <button>Clear result</button>
            </a>
        </c:if>

    </body>
</html>
