<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recensioni</title>
    </head>
    <body>
        <c:forEach items="${listaRec}" var="r">
                      <div class="mdl-list__item">
                        <span>${r.membri.nickname}</span><br>
                        <span>${r.commento}</span><br>
                        <span>${r.voto}</span><br>
                      </div>
        </c:forEach>
    </body>
</html>
