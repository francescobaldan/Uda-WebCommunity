
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${categoria.nome}</title>
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
            <a class="mdl-navigation__link" href="<c:url value="/" />">
              <span class="mdl-list__item-primary-content">
                <i class="material-icons mdl-list__item-icon">home</i>
              Home</span>
            </a>
            <a class="mdl-navigation__link" href="<c:url value="/categorie" />">
               <span class="mdl-list__item-primary-content">
                  <i class="material-icons mdl-list__item-icon">format_align_justify</i>
                Categorie</span>
            </a>
            <a class="mdl-navigation__link active" href="<c:url value="/profile" />">
               <span class="mdl-list__item-primary-content">
                  <i class="material-icons mdl-list__item-icon">person</i>
                Profilo</span>
            </a>
          </nav>
        </div>
        <main class="mdl-layout__content">
          <div class="page-content">
                    
            <div class="spacer mdl-shadow--2dp"></div>
                    
            <div class="mdl-card mdl-shadow--2dp main-container">
              
              <%
                if ((session.getAttribute("loggedUserInfo") == null) || (session.getAttribute("loggedUserInfo") == "")) {
              %>
              
              <div class="mdl-card__title">
                <h3>Errore</h3>
              </div>
              <div class="mdl-card__supporting-text" id="subtitle">
                <span>Per poter visualizzare questa pagina devi essere loggato</span></span>
              </div>
              
              <%
              } else {
              %>
              
              <div class="mdl-card__title">
                <h3>Profilo utente</h3>
              </div>
              <div class="mdl-card__supporting-text" id="subtitle">
                <span>Nickname:<b> ${loggedUserInfo.nickname}</b></span><br>
                <span>Nome e cognome:<b> ${loggedUserInfo.nome} ${loggedUserInfo.cognome}</b></span>
              </div>
              
              <%
              }
              %>
              
            </div>
                    
          </div>
        </main>
      </div>

    </body>
</html>
