<%@page import="Database.Artista"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:wrapper>
    <div>    
        <a onclick="atualizarDados()"> Reprocessar </a>
    </div>
    
    <div class="col-md-6" style="border-style: solid;"> 
        <h2> Artistas </h2>
        <ul>
            <c:forEach items="${artistas}" var="artista">
                <li id="<c:out value="${artista.getId()}"/>" onclick="mostraDetalhes(this.id)">
                    <c:out value="${artista.getNome()}"/>
                </li>
            </c:forEach>
        </ul>
    </div>
    
    <div class="col-md-6" style="border-style: solid;"> 
        <div>
            <h2 id="nomeArtista"> Musicas </h2>
        </div>
        <div id="detalhes">
            
        </div>
    </div>
</t:wrapper>
    
