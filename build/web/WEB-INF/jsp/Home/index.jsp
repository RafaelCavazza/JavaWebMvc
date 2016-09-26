<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<% 
    String text = "";
    for(int i =0; i< 10; i++)
    {
        text += "<li> Exemplo de Código Gerado Dinamicamente!</li>";
    }
    
    pageContext.setAttribute("text", text);
%>

<t:wrapper>
    <div> 
    <ul>
        ${text}
    </ul>
</div>
</t:wrapper>
    
