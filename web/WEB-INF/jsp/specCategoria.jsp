<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!--https://www.tutorialspoint.com/jsp/jstl_format_formatdate_tag.htm-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--<!DOCTYPE html>
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
        <div>
            <form method="get" action="<c:url value="./filtroEventi"/>">
                <input type="hidden" name="idCat" value="${idCat}">
                <input type="text" name="luogo" id="luogo">
                <label for="luogo">Specifica luogo</label>
                <input type="submit">
            </form>
        </div>
    </body>
</html> -->

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${categoria.nome}</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.blue-amber.min.css">
    <script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
  </head>

  <body>
        
    <div class="mdl-layout mdl-js-layout mdl-layout--fixed-drawer">
      <header class="mdl-layout__header">
        <div class="mdl-layout-icon"></div>
        <div class="mdl-layout__header-row">
          <span class="mdl-layout__title">Simple Layout</span>
          <div class="mdl-layout-spacer"></div>
          <jsp:include page="login.jsp" />
        </div>
      </header>
        <div class="mdl-layout__drawer">
          <span class="mdl-layout-title">Title</span>
          <nav class="mdl-navigation">
            <a class="mdl-navigation__link active" href="<c:url value="/" />">
              <span class="mdl-list__item-primary-content">
                <i class="material-icons mdl-list__item-icon">home</i>
              Home</span>
            </a>
            <a class="mdl-navigation__link" href="<c:url value="/categorie" />">
               <span class="mdl-list__item-primary-content">
                  <i class="material-icons mdl-list__item-icon">format_align_justify</i>
                Categorie</span>
            </a>
               <a class="mdl-navigation__link" href="<c:url value="/artisti" />">
               <span class="mdl-list__item-primary-content">
                  <i class="material-icons mdl-list__item-icon">people</i>
                Artisti</span>
            </a>
          </nav>
        </div>
        <main class="mdl-layout__content">
          <div class="page-content">
                    
            <div class="spacer mdl-color--primary mdl-shadow--2dp"></div>
                    
            <div class="mdl-card mdl-shadow--2dp main-container">
              
              <div class="mdl-card__title">
                <h3>${categoria.nome}</h3>
                <div class="vai-a-capo">
                  <span>${categoria.descrizione}</span>
                </div>
              </div>
              <div class="mdl-menu__item--full-bleed-divider"></div>
              <div class="mdl-card__supporting-text">
                
                <ul class="mdl-list">
                  
                  <c:forEach items="${eventiCategoria}" var="e">
                    
                    <li class="mdl-list__item mdl-list__item--three-line">
                      <span class="mdl-list__item-primary-content">
                        <span class="mdl-list__item-icon">${e.idEvento}</span>
                        <span>${e.titolo}</span>
                        <span class="mdl-list__item-text-body">${e.luogo}
                          <fmt:formatDate pattern = "dd-MM-yyyy" value = "${e.data}" /></span>
                      </span>
                    </li>
                    
                  </c:forEach>
                  
                </ul>
                
              </div>
            </div>
                    
          </div>
        </main>
      </div>

    </body>
</html>
