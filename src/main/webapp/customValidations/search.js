var request = null;
function searchForProduct() {
    if (window.XMLHttpRequest)
        request = new XMLHttpRequest();
    else if
    (window.ActiveXObject)
        request = new ActiveXObject(Microsoft.XMLHTTP);
    let searchFor = $("#searchFor").val();

    let jsonObj = {
        "productName": searchFor
    }
    request.open("Post","search", true);
    request.setRequestHeader("content-type","application/x-www-form-urlencoded");
    request.send("productName="+searchFor);


}
