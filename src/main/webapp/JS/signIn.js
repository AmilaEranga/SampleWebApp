function validateForm() {
    var pw1 = $("#password").val();
    var pw2 = $("#cPassword").val();

    if (pw1 != pw2) {
        $(".messageText").text("password and confirm password doesn't match");
        console.log("password matching validation failed");
        return false;
    }
    if (pw1.length < 6) {
        $(".messageText").text("length of the password must be greater than 6");
        console.log("password length validation failed");
        return false;
    }

    return true;

}

