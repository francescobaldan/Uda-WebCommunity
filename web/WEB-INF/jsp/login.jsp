<%-- 
    Document   : login
    Created on : 10-mag-2017, 9.03.01
    Author     : FSEVERI\baldan3240
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<form action="/Uda-WebCommunity/checkLogin" method="POST">
  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label login-field-container">
    <input class="mdl-textfield__input login-field" type="text" id="login-user-field" name="username" required>
    <label class="mdl-textfield__label login-field-label" id="user-label" for="login-user-field">Nome utente</label>
  </div>
  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label login-field-container">
    <input class="mdl-textfield__input login-field" type="password" id="login-pass-field" name="password" required>
    <label class="mdl-textfield__label login-field-label" id="pass-label" for="login-pass-field">Password</label>
  </div>
  <input type="submit" value="Login" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect login-submit" />
</form>
