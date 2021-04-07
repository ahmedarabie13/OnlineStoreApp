var request = null;


function updateProfile() {
    let validData = checkValidations();
    if (validData === true) {

        let email = $("#email").val();
        let password = $("#pass").val();
        let firstName = $("#fn").val();
        let lastName = $("#ln").val();
        let phone = $("#phoneField").val();
        let job = $("#job").val();
        let dob = $("#dob").val();
        let street = $("#street").val();
        let city = $("#ciTy").val();
        let jsonObj = {
            "email": email, "password": password, "firstName": firstName, "lastName": lastName,
            "phone": phone, "job": job, "dob": dob, "street": street, "city": city
        };


        $.post("editProfile", jsonObj, AjaxCallBack);
    } else {
        return false;
    }
}

function AjaxCallBack(responseTxt, statusTxt, xhr) {
    let xmlvalue;
    if (statusTxt == "success") {
        xmlvalue = responseTxt;
        if (xmlvalue === "Valid") {
            $("#updated").show();
            $("#failed").hide();
            $("input").prop('disabled', true);
            setTimeout(function(){
                $("#updated").hide();
            }, 3000);
            return;
        } else {
            $("#updated").hide();
            $("#failed").show();
            return;
        }
    }
}

// function checkValidations() {
//
//     var validationFailed = false;
//
//     if ($("#fn").val() === "" || $("#ln").val() === "" || $("#email").val() === ""
//         || $("#phoneField").val() === "" || $("#pass").val() === "" || $("#passConf").val() === "") {
//         validationFailed = true;
//
//     }
//     if (validationFailed) {
//
//         return false;
//     }
//     return true;
// }
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
    return true;
    //});
}

function disable() {
    $("input").prop('disabled', true);
    $("#updated").hide();
    $("#failed").hide();
}

function enable() {
    $("input").prop('disabled', false);
    $("#updated").hide();
    $("#failed").hide();
}

function emailValidate() {
    let email = $("#email").val();
    let currentUserEmail = document.getElementById("myEmail").textContent;
    if(email===currentUserEmail){
        console.log("same");
        $("#invalidEmail").hide();
        return
    }
    var regex = /(^[A-Za-z0-9._-]+@[A-Za-z0-9]+\.[A-Za-z]{2,6}$)| [ \t\n]*/
    if (email.match(regex)) {
        console.log("valid email format");
        $("#invalidEmail").hide();
        let jsonEmail = {"email": email}
        $.post("emailRegistered", jsonEmail, emailCallBack);

        function emailCallBack(responseJson, status, xhr) {
            if (status === "success" && responseJson === "false") {
                console.log("email doesn't exist")
                $("#invalidEmail").hide();
                $("#emailExist").hide();
                return
            } else {
                console.log("email does exist")
                $("#invalidEmail").hide();
                $("#emailExist").show();
                return
            }
        }
    } else {
        console.log("valid email format");
        $("#invalidEmail").show();
    }
}