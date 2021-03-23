var request = null;


function updateProfile() {
    let validData = checkValidations();
    if(validData ===true ){
    if (window.XMLHttpRequest)
        request = new XMLHttpRequest();
    else if
    (window.ActiveXObject)
        request = new ActiveXObject(Microsoft.XMLHTTP);
    let email = $("#email").val();
    let password = $("#pass").val();
    let firstName = $("#fn").val();
    let lastName = $("#ln").val();
    let phone = $("#phoneField").val();
    let job = $("#job").val();
    let dob = $("#dob").val();
    let street = $("#street").val();
    let city = $("#ciTy").val();
    request.onreadystatechange = handleStateChangee;
    let jsonObj = {
        "email": email, "password": password, "firstName": firstName, "lastName": lastName,
        "phone": phone, "job": job, "dob": dob, "street": street, "city": city
    }
    request.open("Post", "editProfile", true);
    request.send(jsonObj);
}
    else {return false;}}

function handleStateChangee() {
    let xmlvalue;
    if (request.readyState == 4 && request.status == 200) {
        xmlvalue = request.responseText;
        if(xmlvalue==="Valid"){
        $("#updated").show();
        $("input").prop('disabled', true);
        return;
    }
        else{
            $("#failed").show();
            return;}
} }

function checkValidations(){

    var validationFailed = false;

     if($("#fn").val() === "" || $("#ln").val() === "" || $("#email").val() === ""
        || $("#phoneField").val() === "" || $("#pass").val() === "" || $("#passConf").val() === ""){
        validationFailed = true;

    }
    if (validationFailed) {

        return false;
    }
    return true;
}

function disable(){
    $("input").prop('disabled', true);
}

function enable(){
    $("input").prop('disabled', false);
}