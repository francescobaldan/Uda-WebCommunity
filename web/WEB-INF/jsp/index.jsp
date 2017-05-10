<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Eventi</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.blue-teal.min.css">
    <script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
  </head>

  <body>
        
    <div class="mdl-layout mdl-js-layout mdl-layout--fixed-drawer">
      <header class="mdl-layout__header">
        <div class="mdl-layout-icon"></div>
        <div class="mdl-layout__header-row">
          <span class="mdl-layout__title">Simple Layout</span>
        </div>
        </header>
        <div class="mdl-layout__drawer">
          <span class="mdl-layout-title">Title</span>
          <nav class="mdl-navigation">
            <a class="mdl-navigation__link" href="">
              <span class="mdl-list__item-primary-content">
                <i class="material-icons mdl-list__item-icon">home</i>
              Home</span>
            </a>
            <a class="mdl-navigation__link" href="">
               <span class="mdl-list__item-primary-content">
                  <i class="material-icons mdl-list__item-icon">playlist_add</i>
                Categorie</span>
            </a>
          </nav>
        </div>
        <main class="mdl-layout__content">
          <div class="page-content">
                    
            <div class="spacer mdl-color--primary"></div>
                    
            <div class="mdl-card mdl-shadow--2dp main-container">
              
              <div class="mdl-card__title">
                <h3>Ultimi eventi</h3>
              </div>
              <div class="mdl-menu__item--full-bleed-divider"></div>
              <div class="mdl-card__supporting-text">
                
                <div class="mdl-list">
                  
                   <c:forEach items="${lista}" var="e">
                      <div class="mdl-list__item">
                        <span>${e.titolo}</span><br>
                        <span>${e.luogo}</span><br>
                        <span><fmt:formatDate pattern = "dd-MM-yyyy" value = "${e.data}" /></span><br><br>
                        <a href="/categoria?idC=${e.categoria.idCategoria}">${e.categoria.nome}</a>
                      </div>
                    </c:forEach>
                  
                </div>
                
              </div>
            </div>
                    
          </div>
        </main>
      </div>

    </body>
</html>
