
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
                <div class="right-phone-box">
                    <p>Call US :- <a href="#"> +11 900 800 100</a></p>
                </div>
                <div class="our-link">
                    <ul>
                        <li><a href="#"><i class="fa fa-user s_color"></i> My Account</a></li>
                        <li><a href="#"><i class="fas fa-location-arrow"></i> Our location</a></li>
                        <li><a href="#"><i class="fas fa-headset"></i> Contact Us</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                <div class="login-box">
                    <a href="registration.jsp"><button style="background-color: #b0b435; color: whitesmoke; border-radius: 5px">Register</button></a>
                    <a href="login.jsp"><button style="background-color: #b0b435; color: whitesmoke; border-radius: 5px">Sign In</button></a>
<%--                    <select id="basic" class="selectpicker show-tick form-control" data-placeholder="Sign In">--%>
<%--                        <option>Register Here</option>--%>
<%--                        <option>Sign In</option>--%>
<%--                    </select>--%>
                </div>
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
                <a class="navbar-brand" href="index.jsp"><img src="images/logo.png" class="logo" alt=""></a>
            </div>
            <!-- End Header Navigation -->

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="navbar-menu">
                <ul class="nav navbar-nav ml-auto" data-in="fadeInDown" data-out="fadeOutUp">
                    <li class="nav-item"><a class="nav-link" href="index.jsp">Home</a></li>
                    <li class="nav-item active"><a class="nav-link" href="about.jsp">About Us</a></li>
                    <li class="dropdown">
                        <a href="#" class="nav-link dropdown-toggle arrow" data-toggle="dropdown">SHOP</a>
                        <ul class="dropdown-menu">
                            <li><a href="shop">Sidebar Shop</a></li>
                            <li><a href="shop-detail.jsp">Shop Detail</a></li>
                            <li><a href="cart.jsp">Cart</a></li>
                            <li><a href="checkout.jsp">Checkout</a></li>
                            <li><a href="my-account.jsp">My Account</a></li>
                            <li><a href="wishlist.jsp">Wishlist</a></li>
                        </ul>
                    </li>
                    <li class="nav-item"><a class="nav-link" href="gallery.jsp">Gallery</a></li>
                    <li class="nav-item"><a class="nav-link" href="contact-us.jsp">Contact Us</a></li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->

            <!-- Start Atribute Navigation -->
            <div class="attr-nav">
                <ul>
                    <li class="search"><a href="#"><i class="fa fa-search"></i></a></li>
                    <li class="side-menu"><a href="#">
                        <i class="fa fa-shopping-bag"></i>
                        <span class="badge">3</span>
                        <p>My Cart</p>
                    </a></li>
                </ul>
            </div>
            <!-- End Atribute Navigation -->
        </div>
        <!-- Start Side Menu -->
        <div class="side">
            <a href="#" class="close-side"><i class="fa fa-times"></i></a>
            <li class="cart-box">
                <ul class="cart-list">
                    <li>
                        <a href="#" class="photo"><img src="images/img-pro-01.jpg" class="cart-thumb" alt=""/></a>
                        <h6><a href="#">Delica omtantur </a></h6>
                        <p>1x - <span class="price">$80.00</span></p>
                    </li>
                    <li>
                        <a href="#" class="photo"><img src="images/img-pro-02.jpg" class="cart-thumb" alt=""/></a>
                        <h6><a href="#">Omnes ocurreret</a></h6>
                        <p>1x - <span class="price">$60.00</span></p>
                    </li>
                    <li>
                        <a href="#" class="photo"><img src="images/img-pro-03.jpg" class="cart-thumb" alt=""/></a>
                        <h6><a href="#">Agam facilisis</a></h6>
                        <p>1x - <span class="price">$40.00</span></p>
                    </li>
                    <li class="total">
                        <a href="#" class="btn btn-default hvr-hover btn-cart">VIEW CART</a>
                        <span class="float-right"><strong>Total</strong>: $180.00</span>
                    </li>
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
<!-- End Top Search -->

<%--</body>--%>
<%--</html>--%>

