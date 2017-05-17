<%-- 
    Document   : profile
    Created on : 17-mag-2017, 22.03.44
    Author     : matte
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if ((session.getAttribute("loggedUserInfo") == null) || (session.getAttribute("loggedUserInfo") == "")) {
        %>
        <h2>Per poter visualizzare il contenuto di questa pagina devi prima effettuare l'accesso.</h2>
        <h4>Se non possiedi un account puoi registrarti <a href="/Uda-WebCommunity/registrazione">qui</a></h4>
        <%
            } else {
        %>
        <h2 class="popcolor">Informazioni dell'utente</h2>
        <h4>Nickname: ${loggedUserInfo.nickname}</h4>
        <h5>Nome e cognome: ${loggedUserInfo.nome} ${loggedUserInfo.cognome}</h5>
        <a href="/Uda-WebCommunity/logout">Logout</a>
        <%
            }
        %>
    </body>
</html>
