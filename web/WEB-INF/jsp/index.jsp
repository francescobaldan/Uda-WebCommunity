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
    <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.blue-red.min.css">
    <script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="<c:url value="/resources/js/dialogs.js" />"></script>
  </head>

  <body>
        
    <div class="mdl-layout mdl-js-layout mdl-layout--fixed-drawer">
      
      <div id="login-dialog">
        <div id="login-real-dialog" class="mdl-dialog">
          <h4 class="mdl-dialog__title">Login<i class="material-icons" id="close-login">close</i></h4>
          <form action="/Uda-WebCommunity/checkLogin" method="POST">
            <div class="mdl-dialog__content">
              <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label login-field-container">
                <input class="mdl-textfield__input login-field" type="text" id="login-user-field" name="username">
                <label class="mdl-textfield__label login-field-label" id="user-label" for="login-user-field">Nome utente</label>
              </div>
              <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label login-field-container">
                <input class="mdl-textfield__input login-field" type="password" id="login-pass-field" name="password">
                <label class="mdl-textfield__label login-field-label" id="pass-label" for="login-pass-field">Password</label>
              </div>
            </div>
            <div class="mdl-dialog__actions">
              <input type="submit" value="Login" class="mdl-button mdl-js-button mdl-js-ripple-effect" />
            </div>
          </form>
        </div>
      </div>
      
      <div id="signup-dialog">
        <div id="signup-real-dialog" class="mdl-dialog">
          <h4 class="mdl-dialog__title">Iscrizione<i class="material-icons" id="close-signup">close</i></h4>
          <form action="/Uda-WebCommunity/doRegistration" method="POST">
            <div class="mdl-dialog__content">
              <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label signup-field-container">
                <input class="mdl-textfield__input login-field" type="text" name="name" id="signup-name-field">
                <label class="mdl-textfield__label login-field-label" id="user-label" for="signup-name-field">Nome</label>
              </div>
              <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label signup-field-container">
                <input class="mdl-textfield__input login-field" type="text" name="surname" id="signup-surname-field">
                <label class="mdl-textfield__label login-field-label" id="user-label" for="signup-surname-field">Cognome</label>
              </div>
              <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label signup-field-container">
                <input class="mdl-textfield__input login-field" type="text" name="username" id="signup-username-field">
                <label class="mdl-textfield__label login-field-label" id="user-label" for="signup-username-field">Nome utente</label>
              </div>
              <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label login-field-container">
                <input class="mdl-textfield__input login-field" type="password" name="password" id="signup-pass-field">
                <label class="mdl-textfield__label login-field-label" id="pass-label" for="signup-pass-field">Password</label>
              </div>
              <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label login-field-container">
                <input class="mdl-textfield__input login-field" type="mail" name="mail" id="signup-mail-field">
                <label class="mdl-textfield__label login-field-label" id="mail-label" for="signup-mail-field">Email</label>
              </div>
            </div>
            <div class="mdl-dialog__actions">
              <input type="submit" value="Iscriviti" class="mdl-button mdl-js-button mdl-js-ripple-effect" />
            </div>
          </form>
        </div>
      </div>
      
      <header class="mdl-layout__header">
        <div class="mdl-layout-icon"></div>
        <div class="mdl-layout__header-row">
          <span class="mdl-layout__title">WebCommunity</span>
          <div class="mdl-layout-spacer"></div>
          <%
            if ((session.getAttribute("loggedUserInfo") == null) || (session.getAttribute("loggedUserInfo") == "")) {
          %>
            <button class="mdl-button mdl-js-button mdl-js-ripple-effect" id="signup-dialog-caller">
              Iscriviti
            </button>
            <button class="mdl-button mdl-js-button mdl-js-ripple-effect" id="login-dialog-caller">
              Login
            </button>
          <%
          } else {
          %>
            <span>Benvenuto ${loggedUserInfo.nickname} (<a href="/Uda-WebCommunity/logout">Logout</a>)</span>
          <%
            }
          %>
        </div>
      </header>
        <div class="mdl-layout__drawer">
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
            <a class="mdl-navigation__link" href="<c:url value="/profile" />">
               <span class="mdl-list__item-primary-content">
                  <i class="material-icons mdl-list__item-icon">person</i>
                Profilo</span>
            </a>
          </nav>
        </div>
        <main class="mdl-layout__content">
          <div class="page-content">
                    
            <div class="spacer mdl-shadow--2dp"></div>
            
            <%
              if ((session.getAttribute("loggedUserInfo") == null) || (session.getAttribute("loggedUserInfo") == "")) {
            %>

            <div class="add-event-container">
              
            </div>

            <%
              } else {
            %>
            
            <div class="add-event-container">
              <a class="mdl-navigation__link" id="add-event-link" href="<c:url value="/forwardAddEvento" />">
                <button class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored" id="add-event-fab">
                  <i class="material-icons">add</i>
                </button>
                <div class="mdl-tooltip mdl-tooltip--bottom" for="add-event-fab">Aggiungi evento</div>
              </a>
            </div>
            
            <%
              }
            %>
                    
            <div class="mdl-card mdl-shadow--2dp main-container">
              
              <div class="mdl-card__title">
                <h3>Ultimi eventi</h3>
              </div>
              <div class="mdl-menu__item--full-bleed-divider"></div>
              <div class="mdl-card__supporting-text">
                
                <ul class="mdl-list">
                  
                  
                  
                  <c:forEach items="${lista}" var="e">
                    <li class="mdl-list__item mdl-list__item--three-line">
                      <span class="mdl-list__item-primary-content">
                        <c:if test="${e.getCategoria().getIdCategoria() == 1}">
                          <i class="material-icons mdl-list__item-avatar evento-musica" id="${e.idEvento}">
                            music_note
                          </i>
                        </c:if>
                        <c:if test="${e.getCategoria().getIdCategoria() == 2}">
                          <i class="material-icons mdl-list__item-avatar evento-teatro" id="${e.idEvento}">
                            directions_bike
                          </i>
                        </c:if>
                        <c:if test="${e.getCategoria().getIdCategoria() == 3}">
                          <i class="material-icons mdl-list__item-avatar evento-sport" id="${e.idEvento}">
                            movie
                          </i>
                        </c:if>
                        <c:if test="${e.getCategoria().getIdCategoria() == 4}">
                          <i class="material-icons mdl-list__item-avatar evento-cinema" id="${e.idEvento}">
                            local_library
                          </i>
                        </c:if>
                        <div class="mdl-tooltip mdl-tooltip--left" for="${e.idEvento}">${e.categoria.nome}</div>
                        <span>${e.titolo}</span>
                        <span class="mdl-list__item-text-body">
                          ${e.luogo}<br>
                          <fmt:formatDate pattern = "dd-MM-yyyy" value = "${e.data}" />
                          <%
                              if ((session.getAttribute("loggedUserInfo") != null) || (session.getAttribute("loggedUserInfo") != "")) {
                          %>
                          
                          <%
                              } else {
                          %>
                          
                          <a href="<c:url value="/deleteEvento?idE=${e.idEvento}&idC=${e.getCategoria().getIdCategoria()}&control=0" />">Elimina</a><br>
                          
                          <%
                              }
                          %>
                          </span>
                      </span>
                      <span class="mdl-list__item-secondary-content">
                        <div class="mdl-list__item-secondary-action">
                          <a href="<c:url value="/evento?idE=${e.idEvento}" />">
                            <i class="material-icons">arrow_forward</i>
                          </a>
                        </div>
                      </span>
                    </li>
                  </c:forEach>
                    
                </ul>
                
              </div>
            </div>
                    
          </div>
        </main>
      </div>
                
      <script src="<c:url value="/resources/js/dialogs.js" />"></script>
      
    </body>
</html>
