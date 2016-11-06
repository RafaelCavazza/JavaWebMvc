<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div> 
    <ul class="list-group">
        <c:forEach items="${musicas}" var="musica">
            <li class="list-group-item">
                <c:out value="${musica}"/><p>
            </li>
        </c:forEach>
    </ul>
</div>

