<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div> 
    <ul>
        <c:forEach items="${musicas}" var="musica">
            Musica: <c:out value="${musica}"/><p>
        </c:forEach>
    </ul>
</div>
    
