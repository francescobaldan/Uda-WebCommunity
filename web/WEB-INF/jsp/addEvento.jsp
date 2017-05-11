<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aggiungi evento</title>
    </head>
    <body>
        <form method="get" action="<c:url value="./addEvento"/>">
            <input type="text" name="titolo" id="titolo">
            <label for="titolo">Titolo</label>
            <input type="text" name="luogo" id="luogo">
            <label for="titolo">Luogo</label>
            <input type="text" name="data" id="data">
            <label for="titolo">Data yyyy/mm/dd</label>
            <input type="text" name="categoria" id="categoria">
            <label for="titolo">Categoria</label>
            <input type="submit" name="cazzo" >
        </form>
    </body>
</html>