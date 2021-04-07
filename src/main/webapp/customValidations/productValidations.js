function priceValidator(){
    let price = $("#prodPrice").val();
    let sign = Math.sign(price);
    if(sign === -1 || sign === 0 || sign === -0 || isNaN(sign)) {
        $("#negPrice").show();
    } else{
        $("#negPrice").hide();
    }
}

function quantityValidator(){
    // debugger
    let price = $("#prodQuan").val();
    let sign = Math.sign(price);
    if(sign === -1 || isNaN(sign)) {
        $("#wrongQuan").show();
    } else {
        $("#wrongQuan").hide();
    }
}

function descValidator(){
    let quan = $("#prodDesc").val();
    if(quan === "") {
        $("#empDesc").show();
    } else {
        $("#empDesc").hide();
    }
}