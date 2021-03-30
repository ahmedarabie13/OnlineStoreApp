function updateProduct(){
    // debugger
    let id = $("#prodId").text()
    let newName = $("#prodName").html()
    let newPrice = $("#prodPrice").val()
    let newQuantity = $("#prodQuan").val()
    let newDesc = $("#prodDesc").text()
    let product =
        {
            "update": true,
            "id": id,
            "newName": newName,
            "newPrice": newPrice,
            "newQuantity": newQuantity,
            "newDesc": newDesc,
        }
    $.post("products", product , productUpdateCallBack);
    function productUpdateCallBack(responseJson, status, xhr){
        if(status === "success" && responseJson === "true"){
            console.log("updated")
            window.location.href=`productDetail?id=${id}`
        } else {
            console.log("failed to update")
            return
        }
    }
}

function deleteProduct(){
    let id = $("#prodId").text();
    let product = {"id": id, "delete": true}
    $.post("products", product , productUpdateCallBack);
    function productUpdateCallBack(responseJson, status, xhr){
        if(status === "success" && responseJson === "true"){
            console.log("updated")
            window.location.href="products"
        } else {
            console.log("failed to update")
            return
        }
    }
}

function addProduct(){
    // debugger
    let newName = $("#prodName").val()
    let newPrice = $("#prodPrice").val()
    let newQuantity = $("#prodQuan").val()
    let newDesc = $("#prodDesc").text()
    let product =
        {
            "name": newName,
            "price": newPrice,
            "quan": newQuantity,
            "desc": newDesc,
        }
    $.post("products", product , productUpdateCallBack);
    function productUpdateCallBack(responseJson, status, xhr){
        if(status === "success" && responseJson === "true"){
            console.log("added")
            window.location.href='products'
        } else {
            console.log("failed to add")
            return
        }
    }
}