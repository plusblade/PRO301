<%-- 
    Document   : login
    Created on : Dec 6, 2021, 1:43:50 PM
    Author     : Sap-lap
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST" action="login">
            Username: <input type="text" name="username"/> <br/>
            Password: <input type="password" name="password"/> <br/>
            <input type="checkbox" name="remember" value="remember"/> Remember Me. <br/>
            <input type="submit" value="Login"/>
        </form>    
    </body>
</html>
