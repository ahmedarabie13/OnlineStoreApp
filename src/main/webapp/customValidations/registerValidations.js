function phoneValidator() {
    let phone = $("#phoneField").val();
    console.log(phone)
    var regex =/^(\+2)?01\d{9}$/
    if(phone.match(regex)) {
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
    let password = $("#pass").val()
    console.log(password)
    var regex =/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/
    if(password.match(regex)) {
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

function emailValidator(){
    let email = $("#email").val()
    var regex =/(^[A-Za-z0-9._-]+@[A-Za-z0-9]+\.[A-Za-z]{2,6}$)| [ \t\n]*/
    if(email.match(regex)) {
        console.log("valid email format");
        $("#invalidEmail").hide();
        let jsonEmail = {"email": email}
        $.post("emailRegistered", jsonEmail , emailCallBack);
        function emailCallBack(responseJson, status, xhr){
            if(status === "success" && responseJson === "false"){
                console.log("email doesn't exist")
                $("#emailExist").hide();
                return
            } else {
                console.log("email does exist")
                $("#emailExist").show();
                return
            }
        }
        // let eReq = null;
        //     console.log("inside the check username aka email");
        //     eReq = getXMLHttpReq();
        //     eReq.onreadystatechange = handleCheckUnameReq;
        //     var un = email
        //     eReq.open("GET", "zft?un=" + un, true);
        //     eReq.send(null);
        // function handleCheckUnameReq(){
        //     if(eReq.readyState === 4 && eReq.status === 200){
        //         console.log("inside the check username aka email1");
        //     } else {
        //         console.log("inside the check username aka email2");
        //     }
        // }
    }
    else {
        console.log("invalid email format");
        $("#invalidEmail").show();
        return;
    }
}

function getXMLHttpReq(){
    if(window.XMLHttpRequest){
        return new XMLHttpRequest();
    } else if(window.ActiveXObject){
        return new ActiveXObject(Microsoft.XMLHTTP);
    }
}

function fnValidator(){
    let fn = $("#fn").val()
    if(fn.length < 3){
        console.log("firstname < 3 chars")
        $("#shortFnLength").show();
    } else if(fn.length > 15){
        console.log("firstname > 15 chars")
        $("#longFnLength").show();
    } else {
        console.log("valid firstname chars length")
        $("#longFnLength").hide();
        $("#shortFnLength").hide();
    }
}

function lnValidator(){
    let ln = $("#ln").val()
    if(ln.length < 3){
        console.log("lastname < 3 chars")
        $("#shortLnLength").show();
    } else if(ln.length > 15){
        console.log("lastname > 15 chars")
        $("#longLnLength").show();
    } else {
        console.log("valid lastname chars length")
        $("#longLnLength").hide();
        $("#shortLnLength").hide();
    }
}

function checkValidations(){
    //$("form").submit(function (e) {
        console.log("here1")
        var validationFailed = false;
        console.log("here2" + validationFailed)
        if($("#invalidPhone").is(":visible") || $("#invalidPassword").is(":visible") || $("#invalidConf").is(":visible")
            || $("#invalidEmail").is(":visible") || $("#emailExist").is(":visible") || $("#shortFnLength").is(":visible") || $("#shortLnLength").is(":visible")){
            validationFailed = true;
            console.log("here3" + validationFailed)
        } else if($("#fn").val() === "" || $("#ln").val() === "" || $("#email").val() === ""
            || $("#phoneField").val() === "" || $("#pass").val() === "" || $("#passConf").val() === ""){
            validationFailed = true;
            console.log("here4" + validationFailed)
        }
        if (validationFailed) {
            console.log("here5" + validationFailed)
            //$("#regForm").preventDefault();
            return false;
        }
    //});
}