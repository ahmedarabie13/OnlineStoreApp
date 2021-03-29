var request = null;

function getProducts() {
    console.log("function called");

    if(window.XMLHttpRequest){
        request = new XMLHttpRequest();//for Chrome, mozilla etc
    }
    else if(window.ActiveXObject) {
        request = new ActiveXObject("Microsoft.XMLHTTP");//for IE only
    }
    request.onreadystatechange  = function() {
        if (request.readyState == 4) {
            var products = JSON.parse(request.responseText);//JSON.parse() returns JSON object
            console.log(products);
            for (let i = 0; i < products.length; i++) {
                let product = products[i];
                console.log(product);
                let productName = product.productName;
                let productImageURL = product.productImageURL;
                $("#productsList")
                    .append(
                "                <div class=\"col-lg-3 col-md-6 special-grid best-seller\">\n" +
                "                    <div class=\"products-single fix\">\n" +
                "                        <div class=\"box-img-hover\">\n" +
                "                            <div class=\"type-lb\">\n" +
                "                                <p class=\"sale\">Sale</p>\n" +
                "                            </div>\n" +
                "                            <img src=\"images/img-pro-01.jpg\" class=\"img-fluid\" alt=\"Image\">\n" +
                "                            <div class=\"mask-icon\">\n" +
                "                                <ul>\n" +
                "                                    <li><a href=\"#\" data-toggle=\"tooltip\" data-placement=\"right\" title=\"View\"><i class=\"fas fa-eye\"></i></a></li>\n" +
                "                                    <li><a href=\"#\" data-toggle=\"tooltip\" data-placement=\"right\" title=\"Compare\"><i class=\"fas fa-sync-alt\"></i></a></li>\n" +
                "                                    <li><a href=\"#\" data-toggle=\"tooltip\" data-placement=\"right\" title=\"Add to Wishlist\"><i class=\"far fa-heart\"></i></a></li>\n" +
                "                                </ul>\n" +
                "                                <a class=\"cart\" href=\"#\">Add to Cart</a>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                        <div class=\"why-text\">\n" +
                "                            <h4>" + productName + "</h4>\n" +
                "                            <h5> $7.79</h5>\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                </div>\n");
            }
        }
    }
        request.open("POST", "products", true);
        request.send();


    // $.ajax({
    //         url: "products",
    //         type: "POST",
    //         contentType: "application/json",
    //         dataType: "json",
    //         success: (data) => {
    //             let products = JSON.parse(data);
    //             for (let i = 0; i < products.length; i++) {
    //                 let product = products[i];
    //                 let productName = product.getProductName();
    //                 // let productImageURL = product.getProductImageURL();
    //                 $("#productsList")
    //                     .append("<Product:Product productName=" + productName + "\n" +
    //                     "productImageURL=\"images/gallery-img-0${cnt}.jpg\"\n" +
    //                     "productPrice=\"2${cnt}.1\"\n" +
    //                     "productStatus=\"New\"/>\n");
    //             }
    //         }
    //     }
    // )
}
function addToCart(productId){
    console.log("added id: "+productId+" to cart");
}