<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<!-- Basic -->

<head>
    <meta charset="utf-8">
    <!-- **search** -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- Mobile Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Site Metas -->
    <title>ThewayShop - Ecommerce Bootstrap 4 HTML Template</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="">

    <%--    <!-- Site Icons -->--%>
    <%--    <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">--%>
    <%--    <link rel="apple-touch-icon" href="images/apple-touch-icon.png">--%>

    <%--    <!-- Bootstrap CSS -->--%>
    <%--    <link rel="stylesheet" href="css/bootstrap.min.css">--%>
    <%--    <!-- Site CSS -->--%>
    <%--    <link rel="stylesheet" href="css/style.css">--%>
    <%--    <!-- Responsive CSS -->--%>
    <%--    <link rel="stylesheet" href="css/responsive.css">--%>
    <%--    <!-- Custom CSS -->--%>
    <%--    <link rel="stylesheet" href="css/custom.css">--%>
    <!-- Site Icons -->
    <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
    <link rel="apple-touch-icon" href="images/apple-touch-icon.png">

    <%--  login form links   --%>
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="forms/css/style.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- Site CSS -->
    <link rel="stylesheet" href="css/style.css">
    <!-- Responsive CSS -->
    <link rel="stylesheet" href="css/responsive.css">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/custom.css">

    <!-- **check** -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
<jsp:include page="header.jsp"/>

<!-- Start All Title Box -->
<div class="all-title-box">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <h2>Cart</h2>
                <ul class="breadcrumb">
                    <li class="breadcrumb-item"><a href="shop">Shop</a></li>
                    <li class="breadcrumb-item active">Cart</li>
                </ul>
            </div>
        </div>
    </div>
</div>
<!-- End All Title Box -->

<!-- cart items HERE --->
<!-- Start Cart  -->
<div class="cart-box-main">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="table-main table-responsive">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>Images</th>
                            <th>Product Name</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Total</th>
                            <th>Remove</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${sessionScope.cartItems}" var="cartItem">

                            <tr id="product${cartItem.product.productID}">
                                <td class="thumbnail-img">
                                    <a href="#"><img class="img-fluid" src="${cartItem.product.productImageURL}"
                                                     alt=""/></a>
                                </td>
                                <td class="name-pr">
                                    <a href="#">${cartItem.product.productName}</a>
                                </td>
                                <td class="price-pr">
                                    <p>$ ${cartItem.product.productPrice}</p>
                                </td>
                                <!-- max="" according to the available quantity of the product -->
                                <td class="quantity-box"><input type="number" size="4" value="${cartItem.quantity}"
                                                                id="cartItem${cartItem.product.productID}"
                                                                onchange="setQuantity(${cartItem.product.productID},${cartItem.product.quantity},${cartItem.product.productPrice});"
                                                                min="1"
                                                                step="1" class="c-input-text qty text">
                                    <br>
                                    <span id="productError${cartItem.product.productID}" class="text-danger"></span>
                                </td>
                                <!-- should be calculated according to the no. of qunatities chosen -->
                                <td class="total-pr">
                                    <p id="prodPrice${cartItem.product.productID}">
                                        $ ${cartItem.quantity * cartItem.product.productPrice}</p>
                                </td>
                                <!-- should actually remove the item -->
                                <!-- also can't find the class "fas fa-times" !! -->
                                <td class="remove-pr">
                                    <a onclick="deleteProduct(${cartItem.product.productID});"><i
                                            class="fas fa-times"></i></a>
                                </td>
                            </tr>

                        </c:forEach>

                        <%--                                <tr>--%>
                        <%--                                    <td class="thumbnail-img">--%>
                        <%--                                        <a href="#"><img class="img-fluid" src="images/img-pro-02.jpg" alt="" /></a>--%>
                        <%--                                    </td>--%>
                        <%--                                    <td class="name-pr">--%>
                        <%--                                        <a href="#">Lorem ipsum dolor sit amet</a>--%>
                        <%--                                    </td>--%>
                        <%--                                    <td class="price-pr">--%>
                        <%--                                        <p>$ 60.0</p>--%>
                        <%--                                    </td>--%>
                        <%--                                    <td class="quantity-box"><input type="number" size="4" value="1" min="0" step="1" class="c-input-text qty text"></td>--%>
                        <%--                                    <td class="total-pr">--%>
                        <%--                                        <p>$ 80.0</p>--%>
                        <%--                                    </td>--%>
                        <%--                                    <td class="remove-pr">--%>
                        <%--                                        <a href="#"><i class="fas fa-times"></i></a>--%>
                        <%--                                    </td>--%>
                        <%--                                </tr>--%>

                        <%--                                <tr>--%>
                        <%--                                    <td class="thumbnail-img">--%>
                        <%--                                        <a href="#"><img class="img-fluid" src="images/img-pro-03.jpg" alt="" /></a>--%>
                        <%--                                    </td>--%>
                        <%--                                    <td class="name-pr">--%>
                        <%--                                        <a href="#">Lorem ipsum dolor sit amet</a>--%>
                        <%--                                    </td>--%>
                        <%--                                    <td class="price-pr">--%>
                        <%--                                        <p>$ 30.0</p>--%>
                        <%--                                    </td>--%>
                        <%--                                    <td class="quantity-box"><input type="number" size="4" value="1" min="0" step="1" class="c-input-text qty text"></td>--%>
                        <%--                                    <td class="total-pr">--%>
                        <%--                                        <p>$ 80.0</p>--%>
                        <%--                                    </td>--%>
                        <%--                                    <td class="remove-pr">--%>
                        <%--                                        <a href="#"><i class="fas fa-times"></i></a>--%>
                        <%--                                    </td>--%>
                        <%--                                </tr>--%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <form method="post" action="checkout">

            <div class="order-box">
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="cc-num">Credit card number</label>
                        <input type="text" class="form-control" id="cc-num" name="cc-num" placeholder="" required>
                        <small
                                class="text-muted">Credit card number as displayed on card</small>
                        <div class="invalid-feedback"> Credit card number is required</div>
                    </div>
                    <div class="col-md-3 mb-3">
                        <label for="cc-cvv">CVV</label>
                        <input type="text" class="form-control" id="cc-cvv" name="cc-cvv" placeholder="" required>
                        <div class="invalid-feedback"> Security code required</div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="cc-num">Address</label>
                        <input type="text" class="form-control" id="shippingAddress" name="shippingAddress"
                               placeholder="" required> <small
                            class="text-muted">Address of the order to be shipped to</small>
                        <div class="invalid-feedback"> Invalid Address</div>
                    </div>
                </div>
                <hr>
                <div class="d-flex gr-total">
                    <h5>Grand Total</h5>
                    <fmt:formatNumber var="cartTotalPrice"
                                      value="${sessionScope.totalPrice}"
                                      maxFractionDigits="2"/>
                    <div class="ml-auto h5" id="totalPrice"> $ ${cartTotalPrice}</div>
                </div>
                <hr>
            </div>
            <c:if test="${! empty requestScope.Error}">
                <span class="text-danger" id="validationSpan">Checkout Failed please enter valid data</span>
            </c:if>
            <%--            </div>--%>
            <div class="col-12 d-flex shopping-box"><input type="submit" class="ml-auto btn hvr-hover"
                                                           value="Checkout"/>
            </div>
        </form>
        <%--            <div class="col-lg-8 col-sm-12"></div>--%>
        <%--        </div>--%>

    </div>
</div>
<!-- End Cart -->

<!-- CAN BE PRODUCTS RATHER THAN SOME PHOTOS? -->
<jsp:include page="footer.jsp"/>

<a href="#" id="back-to-top" title="Back to top" style="display: none;">&uarr;</a>

<!-- ALL JS FILES -->
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<!-- ALL PLUGINS -->
<script src="js/jquery.superslides.min.js"></script>
<script src="js/bootstrap-select.js"></script>
<script src="js/inewsticker.js"></script>
<script src="js/bootsnav.js"></script>
<script src="js/images-loded.min.js"></script>
<script src="js/isotope.min.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/baguetteBox.min.js"></script>
<script src="js/form-validator.min.js"></script>
<script src="js/contact-form-script.js"></script>
<script src="js/custom.js"></script>
<script>
    function setQuantity(productId, productQuantity, productPrice) {
        let newVal = $('#cartItem' + productId).val();
        console.log("new value: " + newVal);
        console.log("change: " + productId);
        if (newVal > productQuantity) {
            console.log("error");
        }

        let cartItemData = new Object();
        cartItemData.operation = "updateQuantity";
        cartItemData.productId = productId;
        cartItemData.cartItemQuantity = parseInt(newVal);
        let jsonData = JSON.stringify(cartItemData);
        $.post("updateCart", "cartItemData=" + jsonData, done);

        function done(data) {
            let output = JSON.parse(data);
            // if(data==="success"){
            if (output.status === "success") {
                $('#prodPrice' + productId).empty();
                let price = parseFloat(productPrice).toFixed(2) * parseInt(newVal);
                price = parseFloat(price).toFixed();
                $('#prodPrice' + productId).append("$ " + price);
                $('#totalPrice').empty();
                let totalPrice = parseFloat(output.totalPrice).toFixed(2);
                console.log("totalPrice " + totalPrice);
                $('#totalPrice').append("$ " + totalPrice);
                // $('#productError' + productId).empty();
                $('#cartItem' + productId).css("border-color", "#B0B435");

                console.log("res" + data);
            } else {
                // $('#productError' + productId).text("invalid Quantity");
                $('#cartItem' + productId).css("border-color", "#DC3545");
                console.log("failed: " + data);
            }
            console.log("done");
        }
    }

    function deleteProduct(productId) {
        let cartItemData = new Object();
        cartItemData.operation = "deleteCartItem";
        cartItemData.productId = productId;
        let jsonData = JSON.stringify(cartItemData);

        $.post("updateCart", "cartItemData=" + jsonData, done);

        function done(data) {
            let response = JSON.parse(data);
            $('#product' + productId).remove();
            $('#productError' + productId).remove();
            console.log("tor=talPrice: " + response.totalPrice);
            let cartSize = parseInt($('#cartSize').text()) - 1;
            console.log("cartSize: " + cartSize);
            $('#cartSize').text(cartSize);
            $('#totalPrice').empty();
            $('#totalPrice').append(response.totalPrice);
            console.log("deleteCallBack: " + response);
            // window.location.reload(true);
        }
    }
</script>
<%--for the error $(...).slider is not a function--%>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

</body>

</html>