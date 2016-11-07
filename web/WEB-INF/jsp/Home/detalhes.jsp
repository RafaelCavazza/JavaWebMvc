<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div> 
    <ul class="list-group">
        <c:forEach items="${musicas}" var="musica">
            <li class="list-group-item" id="${musica.getId()}" onclick="mostraLetra(this.id)">
                <c:out value="${musica.getNomeMusica()}"/><p>
            </li>
        </c:forEach>
    </ul>
</div>

<script>
    function mostraLetra(id)
    {
        loading();
        $(".modal-body").load("/Home/Letra.htm?id=" + id);
        $(".modal-title").html( "Letra Musica: " +  $("#"+id).html());
        $("#myModal").modal("show");
    }
    
    function loading()
    {
        var url ="https://upload.wikimedia.org/wikipedia/commons/b/b1/Loading_icon.gif";
        $(".modal-body").html("<img src='"+url+"' alt='Smiley face' height='150' width='200'>");
    }
</script>


<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title"></h4>
      </div>
      <div class="modal-body">          
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
      </div>
    </div>
  </div>
</div>
