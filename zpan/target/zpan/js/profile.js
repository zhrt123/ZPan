function save() {
    var element = document.getElementsByClassName("tab-pane fade show active").item(0);
    var form = element.getElementsByTagName("form").item(0);
    if (element.id.indexOf("account-general") >= 0) {
        var username = document.getElementsByName("username").item(0).value;
        document.getElementById("user-name-label").innerText = "";
        if (username == null || username.trim().length == 0) {
            document.getElementById("user-name-label").innerText = "用户名不能为空";
            return;
        }
    } else if (element.id.indexOf("account-change-password") >= 0) {
        var password1 = document.getElementsByName("password1").item(0).value;
        var password2 = document.getElementsByName("password2").item(0).value;
        var password3 = document.getElementsByName("password3").item(0).value
        document.getElementById("password1-label").innerText = "";
        document.getElementById("password2-label").innerText = "";
        document.getElementById("password3-label").innerText = "";
        if (password1 == null || password1.length == 0) {
            document.getElementById("password1-label").innerText = "密码不能为空";
            return;
        }
        if (password2 == null || password2.length == 0) {
            document.getElementById("password2-label").innerText = "密码不能为空";
            return;
        }
        if (password3 == null || password3.length == 0) {
            document.getElementById("password3-label").innerText = "密码不能为空";
            return;
        }
        if (password2 != password3) {
            document.getElementById("password3-label").innerText = "两次密码不相同";
            return;
        }
        var password = "${user.password}";
        if (password1 != password) {
            document.getElementById("password1-label").innerText = "密码错误";
            return;
        }
    }
    form.submit();
}

function cancel() {
    window.location.replace("fileManager.action");
}