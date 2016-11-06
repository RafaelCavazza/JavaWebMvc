<%@page import="Database.Artista"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:wrapper>
    <div> 
        <ul>
            <c:forEach items="${artistas}" var="artista">
                Nome: <c:out value="${artista.getNome()}"/><p>
                Id: <c:out value="${artista.getId()}"/><p>
            </c:forEach>
        </ul>
    </div>
</t:wrapper>
    
