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
              <a class="mdl-navigation__link" id="add-event-link" href="<c:url value="/forwardAddEvento" />">
                <button class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored" id="add-event-fab">
                  <i class="material-icons">add</i>
                </button>
                <div class="mdl-tooltip mdl-tooltip--bottom" for="add-event-fab">Aggiungi evento</div>
              </a>
            </div>
                    
            <div class="mdl-card mdl-shadow--2dp main-container">
              
              <div class="mdl-card__title">
                <h3>Ultimi eventi</h3>
              </div>
              <div class="mdl-menu__item--full-bleed-divider"></div>
              <div class="mdl-card__supporting-text">
                
                <form action="#">
                  <input class="mdl-datepicker__input" type="text" id="date-input" value="" />
                </form>
                
              </div>
            </div>
                    
          </div>
        </main>
      </div>

    </body>
</html>

<style>
  .mdl-calendar,.mdl-calendar__booking{position:relative;box-shadow:0 2px 2px 0 rgba(0,0,0,.14),0 3px 1px -2px rgba(0,0,0,.2),0 1px 5px 0 rgba(0,0,0,.12);box-sizing:border-box}.mdl-calendar{display:none;flex-direction:column;background-color:#fff;overflow:hidden}.mdl-calendar.is-visible{display:flex}.mdl-calendar__body,.mdl-calendar__bookings,.mdl-calendar__footer,.mdl-calendar__header{padding:18px}.mdl-calendar__button{cursor:pointer;color:#616161;font-size:1em;line-height:1;padding:0;margin:0;background:0 0;border:none}.mdl-calendar__header{color:#fff;background-color:#2196F3}.mdl-calendar__body .mdl-calendar__body-month,.mdl-calendar__header-year{display:flex;margin:0}.mdl-calendar__header-year{color:#BBDEFB}.mdl-calendar__body .mdl-calendar__body-month-title,.mdl-calendar__header .mdl-calendar__year{flex:1;text-align:center;padding:0;margin:0}.mdl-calendar__header .mdl-calendar__button{color:#E0E0E0}.mdl-calendar__header-fulldate{font-size:2em;padding:0;margin:20px 0 0}.mdl-calendar__content{position:relative;box-sizing:border-box}.mdl-calendar__booking{display:none;overflow-y:scroll;width:100%;height:400px;background-color:#fff}.mdl-calendar__booking.is-visible{display:block}.mdl-calendar__booking-header{padding:1.5em}.mdl-calendar__booking-header-title{display:inline-block;margin:0;padding:0;font-size:1.3em}.mdl-calendar__booking-grid{position:absolute;left:18px;right:18px}.booking-grid__item{display:block;cursor:pointer;height:29px;border-top:1px solid #E0E0E0}.booking-grid__item.booking-grid__item--hour{border-color:#64B5F6}.booking-grid__item-hour{float:left;color:#9E9E9E;line-height:29px;width:50px}.booking-grid__item-selectable{margin:0 22px 0 54px;height:29px}.booking-grid__item-selectable:hover{background-color:#F5F5F5}.mdl-calendar__booking-events{position:relative}.mdl-calendar__booking-event{position:absolute;left:54px;right:22px;padding:.4em;color:#1976D2;background-color:#BBDEFB;border:1px solid #64B5F6;box-sizing:border-box}.mdl-calendar__booking-event.event--travel{color:#7B1FA2;background-color:#E1BEE7;border-color:#BA68C8}.mdl-calendar__body .mdl-calendar__body-month{font-weight:500}.mdl-calendar__body-month,.mdl-calendar__week-labels{margin-bottom:6px}.mdl-calendar__week{display:flex;justify-content:space-between}.mdl-calendar__week-item{flex:1;display:block;font-weight:500;text-align:center;width:42px;height:42px;line-height:42px;padding:0;margin:2px 1px;border-radius:50%;background:0 0;border:none;box-sizing:border-box}.mdl-calendar__week-item,.mdl-calendar__week-item:focus,.mdl-calendar__week-item:hover{outline:0}.mdl-calendar__week-item.is-selected,.mdl-calendar__week-item:hover:not(.is-disabled):not(.mdl-calendar__week-label){cursor:pointer;color:#fff;background-color:#2196F3}.mdl-calendar__week-item.is-disabled,.mdl-calendar__week-item.mdl-calendar__week-label{color:#BDBDBD}.mdl-calendar__week-item.mdl-calendar__week-label{font-weight:400}.mdl-calendar__week-item.mdl-calendar__day-today{color:#2196F3;background-color:#EEE}.mdl-calendar__footer{text-align:right}.mdl-calendar__month--next,.mdl-calendar__month--prev,.mdl-calendar__year--next,.mdl-calendar__year--prev{display:none}.mdl-calendar__month--next.is-visible,.mdl-calendar__month--prev.is-visible,.mdl-calendar__year--next.is-visible,.mdl-calendar__year--prev.is-visible{display:flex}.mdl-datepicker-wrapper.is-visible{background-color:rgba(0,0,0,.25);display:flex}.mdl-datepicker-wrapper{display:none;flex-direction:column;justify-content:center;align-items:center;position:fixed;top:0;left:0;width:100%;height:100%;z-index:80;background-color:transparent}
</style>