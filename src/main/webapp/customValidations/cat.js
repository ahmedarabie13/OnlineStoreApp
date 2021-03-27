$('.category').click(function (e){
    let categoryInfo = {"categoryId": +e.target.name, "page": 1}
    $.post("shop", categoryInfo , shopCallBack);
    function shopCallBack(responseJson, status, xhr){
        if(status === "success"){
            console.log("went to shop servlet successfully")
            $('#productsDiv').innerHTML += "<br> hi"
        } else {
            console.log("didnt go to the shop servlet")
        }
    }
})

