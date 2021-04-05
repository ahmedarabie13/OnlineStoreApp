<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>
<!-- Start Main Top -->
<div class="main-top">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                <%--                <div class="custom-select-box">--%>
                <%--                    <select id="basic" class="selectpicker show-tick form-control" data-placeholder="$ USD">--%>
                <%--                        <option>¥ JPY</option>--%>
                <%--                        <option>$ USD</option>--%>
                <%--                        <option>€ EUR</option>--%>
                <%--                    </select>--%>
                <%--                </div>--%>
                <%--                <div class="right-phone-box">--%>
                <%--                    <p>Call US :- <a href="#"> +11 900 800 100</a></p>--%>
                <%--                </div>  --%>
                <%--                <div class="our-link">--%>
                <%--                    <ul>--%>
                <%--                        <li><a href="#"><i class="fa fa-user s_color"></i> My Account</a></li>--%>
                <%--                        <li><a href="#"><i class="fas fa-location-arrow"></i> Our location</a></li>--%>
                <%--                        <li><a href="#"><i class="fas fa-headset"></i> Contact Us</a></li>--%>
                <%--                    </ul>--%>
                <%--                </div>--%>
                <c:if test="${! empty sessionScope.currentUser}">

                    <div class="our-link">
                        <ul>
                        <a href="myAccount" style="color: white; text-decoration: underline">Welcome ya, ${sessionScope.currentUser.firstName}</a>
                        </ul>
                    </div>
                </c:if>
            </div>
            <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                <c:choose>

                    <c:when test="${sessionScope.currentUser==null}">
                        <div class="login-box">
                            <a href="register">
                                <button style="background-color: #b0b435; color: whitesmoke; border-radius: 5px">
                                    Register
                                </button>
                            </a>
                            <a href="login">
                                <button style="background-color: #b0b435; color: whitesmoke; border-radius: 5px">Sign
                                    In
                                </button>
                            </a>
                        </div>
                    </c:when>
                    <c:when test="${sessionScope.currentUser != null}">
                        <div class="login-box">
                            <a href="logout">
                                <button style="background-color: #b0b435; color: whitesmoke; border-radius: 5px">Sign
                                    Out
                                </button>
                            </a>
                        </div>
                    </c:when>

                </c:choose>
                <%--                    <select id="basic" class="selectpicker show-tick form-control" data-placeholder="Sign In">--%>
                <%--                        <option>Register Here</option>--%>
                <%--                        <option>Sign In</option>--%>
                <%--                    </select>--%>

                <%--                <div class="text-slid-box">--%>
                <%--                    <div id="offer-box" class="carouselTicker">--%>
                <%--                        <ul class="offer-box">--%>
                <%--                            <li>--%>
                <%--                                <i class="fab fa-opencart"></i> 20% off Entire Purchase Promo code: offT80--%>
                <%--                            </li>--%>
                <%--                            <li>--%>
                <%--                                <i class="fab fa-opencart"></i> 50% - 80% off on Vegetables--%>
                <%--                            </li>--%>
                <%--                            <li>--%>
                <%--                                <i class="fab fa-opencart"></i> Off 10%! Shop Vegetables--%>
                <%--                            </li>--%>
                <%--                            <li>--%>
                <%--                                <i class="fab fa-opencart"></i> Off 50%! Shop Now--%>
                <%--                            </li>--%>
                <%--                            <li>--%>
                <%--                                <i class="fab fa-opencart"></i> Off 10%! Shop Vegetables--%>
                <%--                            </li>--%>
                <%--                            <li>--%>
                <%--                                <i class="fab fa-opencart"></i> 50% - 80% off on Vegetables--%>
                <%--                            </li>--%>
                <%--                            <li>--%>
                <%--                                <i class="fab fa-opencart"></i> 20% off Entire Purchase Promo code: offT30--%>
                <%--                            </li>--%>
                <%--                            <li>--%>
                <%--                                <i class="fab fa-opencart"></i> Off 50%! Shop Now--%>
                <%--                            </li>--%>
                <%--                        </ul>--%>
                <%--                    </div>--%>
                <%--                </div>--%>
            </div>
        </div>
    </div>
</div>
<!-- End Main Top -->

<!-- Start Main Top -->
<header class="main-header">
    <!-- Start Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light navbar-default bootsnav">
        <div class="container">
            <!-- Start Header Navigation -->
            <div class="navbar-header">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-menu"
                        aria-controls="navbars-rs-food" aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand" href="main"><img src="images/logo.png" class="logo" alt=""></a>
            </div>
            <!-- End Header Navigation -->

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="navbar-menu">
                <ul class="nav navbar-nav ml-auto" data-in="fadeInDown" data-out="fadeOutUp">
                    <li class="nav-item"><a class="nav-link" href="main">Home</a></li>
                    <li class="nav-item"><a class="nav-link" href="about">About Us</a></li>
                    <li class="dropdown">
                        <a href="#" class="nav-link dropdown-toggle arrow" data-toggle="dropdown">SHOP</a>
                        <ul class="dropdown-menu">
                            <li><a href="shop">Shop</a></li>
                            <%--                            <li><a href="shopDetail">Shop Detail</a></li>--%>
                            <li><a href="cart">Cart</a></li>
                            <li><a href="checkout">Checkout</a></li>
                            <li><a href="myAccount">My Account</a></li>
                            <%--                            <li><a href="wishlist">Wishlist</a></li>--%>
                        </ul>
                    </li>
                    <li class="nav-item"><a class="nav-link" href="gallery">Gallery</a></li>
                    <li class="nav-item"><a class="nav-link" href="contactUs">Contact Us</a></li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->

            <!-- Start Atribute Navigation -->
            <div class="attr-nav">
                <ul>
                    <li class="search"><a href="#"><i class="fa fa-search"></i></a></li>
                    <c:choose>

                        <c:when test="${sessionScope.currentUser!=null}">
                            <li class="side-menu"><a onclick="fetchCartItems()">
                                <i class="fa fa-shopping-bag"></i>
                                <span id="cartSize" class="badge">${sessionScope.cartItems.size()}</span>
                                <p>My Cart</p>
                            </a></li>
                        </c:when><c:when test="${sessionScope.currentUser==null}">
                        <li class="side"><a href="#">
                            <i class="fa fa-shopping-bag"></i>
                            <span class="badge"></span>
                                <%--                                <p>My Cart</p>--%>
                        </a></li>
                    </c:when>
                    </c:choose>

                </ul>
            </div>
            <!-- End Atribute Navigation -->
        </div>
        <!-- Start Side Menu -->
        <div class="side">
            <a href="#" class="close-side"><i class="fa fa-times"></i></a>
            <li class="cart-box">
                <ul class="cart-list" id="cartItems">
                    <%--                <c:if test="${! empty sessionScope.currentUser}" >--%>

                    <%--                        <c:forEach items='${sessionScope.cartItems}' var="cartItem">--%>
                    <%--                            <li>--%>
                    <%--                                <a class="photo"><img src="${cartItem.product.photo}" class="cart-thumb" alt=""/></a>--%>
                    <%--                                <h6><a >${cartItem.product.productName}</a></h6>--%>
                    <%--                                <p>${cartItem.quantity}x - <span class="price">$${cartItem.product.price}</span></p>--%>
                    <%--                            </li>--%>
                    <%--                        </c:forEach>--%>


                    <%--                </c:if>--%>
                    <%--                    <li>--%>
                    <%--                        <a href="#" class="photo"><img src="images/img-pro-02.jpg" class="cart-thumb" alt=""/></a>--%>
                    <%--                        <h6><a href="#">Omnes ocurreret</a></h6>--%>
                    <%--                        <p>1x - <span class="price">$60.00</span></p>--%>
                    <%--                    </li>--%>
                    <%--                    <li>--%>
                    <%--                        <a href="#" class="photo"><img src="images/img-pro-03.jpg" class="cart-thumb" alt=""/></a>--%>
                    <%--                        <h6><a href="#">Agam facilisis</a></h6>--%>
                    <%--                        <p>1x - <span class="price">$40.00</span></p>--%>
                    <%--                    </li>--%>


                    <%--                    <li class="total">--%>
                    <%--                        <a href="#" class="btn btn-default hvr-hover btn-cart">VIEW CART</a>--%>
                    <%--                        <span class="float-right"><strong>Total</strong>: $180.00</span>--%>
                    <%--                    </li>--%>
                </ul>
            </li>
        </div>
        <!-- End Side Menu -->
    </nav>
    <!-- End Navigation -->
</header>
<!-- End Main Top -->

<!-- Start Top Search -->
<div class="top-search">
    <div class="container">
        <div class="input-group">
            <span class="input-group-addon"><i class="fa fa-search"></i></span>
            <input type="text" class="form-control" placeholder="Search">
            <span class="input-group-addon close-search"><i class="fa fa-times"></i></span>
        </div>
    </div>
</div>

<script>
    function fetchCartItems() {
        console.log("fetching cart Items")
        let jsonData = {};
        $.post("cart", jsonData, done);

        function done(data) {
            console.log(data);
            let cartItems = JSON.parse(data);
            $('#cartItems').empty();
            let totalPrice = 0;
            cartItems.forEach(cartItem => {
                // console.log(cartItem);
                totalPrice = totalPrice + (cartItem.product.productPrice * cartItem.quantity);
                $('#cartItems').append("<li>\n" +
                    "                                <a class=\"photo\"><img src=\"" + cartItem.product.productImageURL + "\" class=\"cart-thumb\" alt=\"\"/></a>\n" +
                    "                                <h6><a >" + cartItem.product.productName + "</a></h6>\n" +
                    "                                <p>" + cartItem.quantity + "x - <span class=\"price\">$" + cartItem.product.productPrice + "</span></p>\n" +
                    "                            </li>\n");
            });
            <%--$('#cartItems').empty();--%>
            <%--$('#cartItems').append("<c:forEach items='${sessionScope.cartItems}' var='cartItem'>\n" +--%>
            <%--    "                            <li>\n" +--%>
            <%--    "                                <a class=\"photo\"><img src=\"${cartItem.product.photo}\" class=\"cart-thumb\" alt=\"\"/></a>\n" +--%>
            <%--    "                                <h6><a >${cartItem.product.productName}</a></h6>\n" +--%>
            <%--    "                                <p>${cartItem.quantity}x - <span class=\"price\">$${cartItem.product.price}</span></p>\n" +--%>
            <%--    "                            </li>\n" +--%>
            <%--    "                        </c:forEach>"+--%>

            // console.log(totalPrice);
            // totalPrice=(totalPrice.toString()).replace(/^0+|(\.\d*[1-9])(0+)$/g, '$1');
            // console.log(totalPrice);

            $('#cartItems').append("<li class=\"total\">\n" +
                "                        <a href=\"cart\" class=\"btn btn-default hvr-hover btn-cart\">VIEW CART</a>\n" +
                "                        <span class=\"float-right\"><strong>Total</strong>: $" + parseFloat(totalPrice.toFixed(2)) + "</span>\n" +
                "                    </li>");

            console.log("done fetching");
        }
    }
</script>
<!-- End Top Search -->

<%--</body>--%>
<%--</html>--%>

