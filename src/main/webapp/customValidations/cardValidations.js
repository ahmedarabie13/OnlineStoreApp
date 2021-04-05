function cnumValidator(){
    let cnum = $("#cc-num").val()
    if(cnum.length !== 11 || cnum === "" || isNaN(cnum)){
        $("#num").show();
    } else {
        $("#num").hide();
    }
}

function cvvValidator(){
    let cvv = $("#cc-cvv").val()
    if(cvv.length !== 3 || cvv === "" || isNaN(cvv)){
        $("#cvv").show();
    } else {
        $("#cvv").hide();
    }
}