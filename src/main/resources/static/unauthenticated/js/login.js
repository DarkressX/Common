function setCookie(name, value, days) {
        var expires = "";
        if (days) {
          var date = new Date();
          date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
          expires = "; expires=" + date.toUTCString();
        }
        document.cookie = name + "=" + (value || "")  + expires + "; path=/";
      }

function sendCredentials() {
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;

    var data = new FormData();
    data.append("username", username);
    data.append("password", password);

    fetch("/login", {
      method: "POST",
      body: data
    })
    .then(response => response.json())
    .then(result => {
      console.log(result);
      setCookie("access_token", result.access_token, 7);
      setCookie("refresh_token", result.refresh_token, 7);
    });
  }