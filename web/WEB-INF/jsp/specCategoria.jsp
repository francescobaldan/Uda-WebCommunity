<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!--https://www.tutorialspoint.com/jsp/jstl_format_formatdate_tag.htm-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${categoria.nome}</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.blue-orange.min.css">
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
            
            <div class="add-event-container">
              <a class="mdl-navigation__link" id="add-event-link" href="<c:url value="/forwardAddEventoCat?nomeC=${categoria.nome}" />">
                <button class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored" id="add-event-fab">
                  <i class="material-icons">add</i>
                </button>
                <div class="mdl-tooltip mdl-tooltip--bottom" for="add-event-fab">Aggiungi evento</div>
              </a>
            </div>
                    
            <div class="mdl-card mdl-shadow--2dp main-container">
              
              <div class="mdl-card__title">
                <h3>${categoria.nome}</h3>
              </div>
              <div class="mdl-card__supporting-text" id="subtitle">
                <span>${categoria.descrizione}</span>
              </div>
              <div class="mdl-menu__item--full-bleed-divider"></div>
              <div class="mdl-card__supporting-text">
                
                <ul class="mdl-list">
                  
                  <c:forEach items="${eventiCategoria}" var="e">
                    
                    <li class="mdl-list__item mdl-list__item--three-line">
                      <span class="mdl-list__item-primary-content">
                        <i class="material-icons mdl-list__item-avatar mdl-color--primary">
                          <c:if test="${e.getCategoria().getIdCategoria() == 1}">
                            music_note
                          </c:if>
                          <c:if test="${e.getCategoria().getIdCategoria() == 2}">
                            local_library
                          </c:if>
                          <c:if test="${e.getCategoria().getIdCategoria() == 3}">
                            directions_bike
                          </c:if>
                          <c:if test="${e.getCategoria().getIdCategoria() == 4}">
                            movie
                          </c:if>
                        </i>
                        <span>${e.titolo}</span>
                        <span class="mdl-list__item-text-body">
                          ${e.luogo}<br>
                          <fmt:formatDate pattern = "dd-MM-yyyy" value = "${e.data}" />
                          <a href="<c:url value="/deleteEvento?idE=${e.idEvento}&idC=${idCat}" />">Elimina</a>
                        </span>
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
