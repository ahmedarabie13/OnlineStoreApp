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
        $.get("zft", jsonEmail , emailCallBack);
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

    function getXMLHttpReq(){
        if(window.XMLHttpRequest){
            return new XMLHttpRequest();
        } else if(window.ActiveXObject){
            return new ActiveXObject(Microsoft.XMLHTTP);
        }
    }
}