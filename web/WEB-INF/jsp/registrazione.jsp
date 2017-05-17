<%-- 
    Document   : registrazione
    Created on : 17-mag-2017, 22.18.24
    Author     : matte
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="/Uda-WebCommunity/doRegistration" method="POST">
            <div>
                <label>Nome</label>
                <input type="text" name="name" placeholder="Nome" required>
            </div>
            <div>
                <label>Cognome</label>
                <input type="text" name="surname" placeholder="Cognome" required>
            </div>
            <div>
                <label>Username</label>
                <input type="text" name="username" placeholder="Username" required>
            </div>
            <div>
                <label>Password</label>
                <input type="password" name="password" placeholder="Password"  id="password" required>
            </div>
            <div>
                <label>Mail</label>
                <input type="email" name="mail" placeholder="Mail" required>
            </div>
            <button type="submit">Registrati</button>
        </form>
    </body>
</html>
