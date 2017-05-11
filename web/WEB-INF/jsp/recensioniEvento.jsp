<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Specifiche evento</title>
    </head>
    <body>
        <h2>${event.titolo}</h2>
        <h4>${event.luogo}</h4>
        <h6>${event.data}</h6>
        <c:forEach items="${listaRec}" var="r">
                      <div class="mdl-list__item">
                        <span>${r.getMembro().getNickname()}</span><br>
                        <span>${r.getCommento()}</span><br>
                        <span>${r.getVoto()}</span><br>
                      </div>
        </c:forEach>
        <h4>${mediaVoto}</h4>
    </body>
</html>
