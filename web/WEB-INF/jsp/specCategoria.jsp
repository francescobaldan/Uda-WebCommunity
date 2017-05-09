<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!--https://www.tutorialspoint.com/jsp/jstl_format_formatdate_tag.htm-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categoria</title>
    </head>
    <body>
        <span>${categoria.nome}</span><br>
        <span>${categoria.descrizione}</span><br>
        <ul>
            <c:forEach items="${eventiCategoria}" var="e">
                <li>
                    <span>${e.idEvento}</span><br>
                    <span>${e.titolo}</span><br>
                    <span>${e.luogo}</span><br>
                    <span><fmt:formatDate pattern = "dd-MM-yyyy" value = "${e.data}" /></span><br>
                </li>
            </c:forEach>
        </ul>
    </body>
</html>
