//todo create phone format
function phoneValidator() {
    let inputtxt = $("#phoneField").val();
    console.log(inputtxt)
    var regex = /^01[0125]\\d{8}$/;
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