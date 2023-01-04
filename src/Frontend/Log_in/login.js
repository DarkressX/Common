const loginForm = document.getElementById("login-form");
const loginButton = document.getElementById("login_button");

loginButton.addEventListener("click", (e) => {
    e.preventDefault();
    const username = loginForm.username.value;
    const password = loginForm.password.value;
    document.getElementById("login-form").submit();

/*
    if (username === "user" && password === "web_dev") {
        alert("You have successfully logged in.");
        location.reload();
    }
   */
})