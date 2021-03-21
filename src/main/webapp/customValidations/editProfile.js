var request = null;


function updateProfile(){
    if (window.XMLHttpRequest)
        request = new XMLHttpRequest();
    else if
    (window.ActiveXObject)
        request = new ActiveXObject(Microsoft.XMLHTTP);
    let email = $("#email").val();
    let password =$("#pass").val();
    let firstName =$("#fn").val();
    let lastName =$("#ln").val();
    let phone =$("#phoneField").val();
    let job = $("#job").val();
    let dob =$("#dob").val();
    let street= $("#street").val();
    let city=$("#ciTy").val();
    request.onreadystatechange = handleStateChangee;
    let jsonObj = {"email": email , "password":password, "firstName":firstName,"lastName":lastName,
    "phone":phone, "job":job,"dob":dob,"street":street,"city":city}
   request.open( "Post","editProfile", true);
    request.send(jsonObj);
}
function handleStateChangee() {
    if (request.readyState == 4 && request.status == 200) {
        xmlvalue=request.responseText;

            console.log("valid email format");
            $("#updated").show();
            return;
        }


}