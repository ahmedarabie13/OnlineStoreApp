function phoneValidator() {
    let inputtxt = $("#phoneField").val();
    console.log(inputtxt)
    var regex =/^(\+2)?01\d{9}$/
    if(inputtxt.match(regex)) {
        console.log("valid phone format");
        $("#invalidPhone").hide();
        return;
    }
    else {
        console.log("invalid phone format");
        $("#invalidPhone").show();
        return;
    }
}

function passwordValidator() {
    let inputtxt = $("#pass").val()
    console.log(inputtxt)
    var regex =/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/
    if(inputtxt.match(regex)) {
        console.log("valid password format");
        $("#invalidPassword").hide();
        return;
    }
    else {
        console.log("invalid password format");
        $("#invalidPassword").show();
        return;
    }
}

function passwordConfirmation(){
    let pass = $("#pass").val()
    let confPass = $("#passConf").val()
    if($("#invalidPassword").is(":visible") === true) return;
    if(pass === confPass){
        console.log("password match")
        $("#invalidConf").hide();
        return;
    } else {
        console.log("password doesn't match")
        $("#invalidConf").show();
        return;
    }
}