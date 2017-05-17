<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Aggiungi evento</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.blue-orange.min.css">
    <script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/moment.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/material-picker.min.js" />"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/i18n/jquery-ui-i18n.min.js"></script>
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
                    
            <div class="mdl-card mdl-shadow--2dp main-container" id="this-card-is-slim">
              
              <div class="mdl-card__title">
                <h3>Aggiungi eventi</h3>
              </div>
              <div class="mdl-menu__item--full-bleed-divider"></div>
              <div class="mdl-card__supporting-text">
                
                <form method="get" action="<c:url value="./addEvento"/>">
                  
                  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label add-event">
                    <input class="mdl-textfield__input" type="text" name="titolo" id="titolo">
                    <label class="mdl-textfield__label" for="titolo">Titolo</label>
                  </div>
                  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label add-event">
                    <input class="mdl-textfield__input" type="text" name="luogo" id="luogo">
                    <label class="mdl-textfield__label" for="luogo">Luogo</label>
                  </div>
                  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label add-event" id="datepicker">
                    <input class="mdl-textfield__input" type="text" name="data" id="data">
                    <label class="mdl-textfield__label" for="data">Data</label>
                  </div>
                  <c:if test="${nomeC!=null}">
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label add-event">
                      <input class="mdl-textfield__input" type="text" name="categoria" value="${nomeC}" id="categoria">
                      <label class="mdl-textfield__label" for="categoria">Categoria</label>
                    </div>
                  </c:if>
                  <c:if test="${nomeC==null}">
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label add-event" id="select-category">
                      <input class="mdl-textfield__input" type="text" name="categoria" id="categoria">
                      <label class="mdl-textfield__label" for="categoria">Categoria</label>
                    </div>
                      
                    <ul class="mdl-menu mdl-menu--top-right mdl-js-menu mdl-js-ripple-effect" id="select-category-menu"
                        for="select-category">
                      <li class="mdl-menu__item" id="select-musica">Musica</li>
                      <li class="mdl-menu__item" id="select-teatro">Teatro</li>
                      <li class="mdl-menu__item" id="select-sport">Sport</li>
                      <li class="mdl-menu__item" id="select-cinema">Cinema</li>
                    </ul>
                  </c:if><br>
                  <input type="submit" class="mdl-button mdl-js-button mdl-button--primary" id="add-event" value="Aggiungi" >
                </form>
                
              </div>
            </div>
                    
          </div>
        </main>
      </div>

    </body>
</html>

<script>
  $("#select-musica").click(function() {
    $("#categoria").val("Musica");
    $("#select-category").addClass("is-dirty"); 
  });
  $("#select-teatro").click(function() {
    $("#categoria").val("Teatro");
    $("#select-category").addClass("is-dirty"); 
  });
  $("#select-sport").click(function() {
    $("#categoria").val("Sport");
    $("#select-category").addClass("is-dirty"); 
  });
  $("#select-cinema").click(function() {
    $("#categoria").val("Cinema");
    $("#select-category").addClass("is-dirty"); 
  });
  
  $("#datepicker").click(function() {
    $("#datepicker").addClass("is-dirty"); 
  });
  $("#data:input").datepicker({ dateFormat: 'yy/mm/dd' });
  $.datepicker.setDefaults($.datepicker.regional['it']);
  
</script>