function updateProduct(){
    // debugger
    let checkVal = checkValidationsForUpdate();
    if(checkVal === true) return;
    let id = $("#prodId").text()
    let newName = $("#prodName").html()
    let newPrice = $("#prodPrice").val()
    let newQuantity = $("#prodQuan").val()
    let newDesc = $("#prodDesc").text()
    let status = $("#statusList").val();
    let product =
        {
            "id": id,
            "newName": newName,
            "newPrice": newPrice,
            "newQuantity": newQuantity,
            "newDesc": newDesc,
            "status": status
        }
    $.post("updateProduct", product , productUpdateCallBack);
    function productUpdateCallBack(responseJson, status, xhr){
        if(status === "success" && responseJson === "true"){
            console.log("updated")
            window.location.href=`productDetail?id=${id}`
        }
        else {
            console.log("failed to update")
            // window.location.href=`opsUpd.jsp?pid=${id}`
        }
    }
}

function deleteProduct(){
    let id = $("#prodId").text();
    let product = {"id": id}
    $.post("deleteProduct", product , productUpdateCallBack);
    function productUpdateCallBack(responseJson, status, xhr){
        if(status === "success" && responseJson === "true"){
            console.log("deleted")
            window.location.href="products"
        } else {
            console.log("failed to update")
            // window.location.href=`opsDel.jsp`
        }
    }
}

function addProduct(){
    let imgFile = $("#chosenFile").html()
    let imgFile1 = $("#chosenFile").files[0]
    console.log(imgFile)
    console.log(imgFile1)
    let checkVal = checkValidations();
    if(checkVal === false) return;
    // debugger
    // let newName = $("#prodName").val()
    // let newPrice = $("#prodPrice").val()
    // let newQuantity = $("#prodQuan").val()
    // let newDesc = $("#prodDesc").text()
    // let cats = $("#catList").val();
    // let product =
    //     {
    //         "name": newName,
    //         "price": newPrice,
    //         "quan": newQuantity,
    //         "desc": newDesc,
    //         "cats": cats
    //     }
    //     console.log(product.cats)
    // // product = JSON.stringify(product);
    // $.post("products", product , productUpdateCallBack);
    // function productUpdateCallBack(responseJson, status, xhr){
    //     if(status === "success" && responseJson === "true"){
    //         console.log("added")
    //         window.location.href='products'
    //     } else {
    //         console.log("failed to add")
    //         window.location.href='opsAdd.jsp'
    //     }
    // }
}

function checkValidations(){
    var validationFailed = false;
    console.log($("#prodName").text() + "Text");
    console.log($("#prodName").val() + "Val");
    console.log($("#prodName").html() + "html");
    if($("#negPrice").is(":visible") || $("#wrongQuan").is(":visible")
        || $("#prodName").val() === "" || $("#prodPrice").val() === "" || $("#prodQuan").val() === "" || $("#prodDesc").val() === ""){
        validationFailed = true;
    }
    return validationFailed
}

function checkValidationsForUpdate(){
    var validationFailed = false;
    console.log($("#prodName").text() + "Text");
    console.log($("#prodName").val() + "Val");
    console.log($("#prodName").html() + "html");
    if($("#negPrice").is(":visible") || $("#wrongQuan").is(":visible")
        || $("#prodName").text() === "" || $("#prodPrice").val() === "" || $("#prodQuan").val() === "" || $("#prodDesc").text() === ""){
        validationFailed = true;
    }
    return validationFailed
}