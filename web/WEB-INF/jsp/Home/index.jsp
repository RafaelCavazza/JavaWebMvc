<%@page import="Database.Artista"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:wrapper>
    <div id="processarBtn">    
        <a class="btn btn-primary" onclick="atualizarDados()"> 
            <span class="glyphicon glyphicon-refresh"></span>
            Reprocessar
        </a>
    </div>

    <div class="col-md-6 portfolio-item">
        <div class="panel panel-default">
            <div class="panel-heading"> Artistas </div>
            <div class="panel-body">
                <div class="list-group">
                    <c:forEach items="${artistas}" var="artista">
                        <a href="#" class="list-group-item" id="${artista.getId()}" onclick="mostraDetalhes(this.id)">
                            <c:out value="${artista.getNome()}"/>
                        </a>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>

    <div class="col-md-6 portfolio-item">
        <div class="panel panel-default">
            <div class="panel-heading">Musicas</div>
            <div class="panel-body" id="detalhes">
            </div>
        </div>
    </div>

    <script type="text/javascript">
        function mostraDetalhes(id)
        {
            $("#nomeArtista").html($("#" + id).html());
            $("#detalhes").load("/Home/Detalhes.htm?id=" + id);
        }

        function atualizarDados()
        {
            $.get("/Artistas/BuscaDados.htm", function () {
                location.reload();
            });
        }
    </script>
</t:wrapper>

