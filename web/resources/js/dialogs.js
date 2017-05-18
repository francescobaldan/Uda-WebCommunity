var loginDialog = document.querySelector("#login-dialog");
var loginButton = document.querySelector("#login-dialog-caller");

var signupDialog = document.querySelector("#signup-dialog");
var signupButton = document.querySelector("#signup-dialog-caller");

var closeLogin = document.querySelector("#close-login");
var closeSignup = document.querySelector("#close-signup");

if (loginButton) {
  loginButton.addEventListener("click", function () {
    $(loginDialog).css("display", "block");
  });
}

if (signupButton) {
  signupButton.addEventListener("click", function () {
    $(signupDialog).css("display", "block");
  });
}

if (closeLogin) {
  closeLogin.addEventListener("click", function () {
    $(loginDialog).css("display", "none");
  });
}

if (closeSignup) {
  closeSignup.addEventListener("click", function () {
    $(signupDialog).css("display", "none");
  });
}