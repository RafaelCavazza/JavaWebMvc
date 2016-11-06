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
<<<<<<< HEAD
                Nome: <c:out value="${artista.getNome()}"/><p>
                Id: <c:out value="${artista.getId()}"/><p>
=======
                <li id="<c:out value="${artista.getId()}"/>" onclick="mostraDetalhes(this.id)">
                    <c:out value="${artista.getNome()}"/>
                </li>
>>>>>>> ad2394e147740f99dcc2e80605a4bbd2c1b95f3f
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
    
