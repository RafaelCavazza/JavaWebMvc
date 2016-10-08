<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date, java.text.DateFormat, java.text.SimpleDateFormat"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Exemple Page</title>
    </head>
    <body>
        <%@include file="include.jsp"%>
        <%
            for(int i = 0; i<10 ; i++)
            {
                out.println("<h1>Hello World! " + i + "</h1>");
            }
            
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
        %>
        <%=dateFormat.format(date)%>
        
    </body>
</html>
<%-- Não alterar esse documento  --%>