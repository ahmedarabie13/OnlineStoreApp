<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="main-top">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                <div class="right-phone-box">
                    <p>Call US :- <a href="#"> +11 900 800 100</a></p>
                </div>
                <div class="our-link">
                    <ul>
<%--                        <li><a href="#"><i class="fa fa-user s_color"></i> My Account</a></li>--%>
                        <li><a href="#"><i class="fas fa-location-arrow"></i> Our location</a></li>
                        <li><a href="#"><i class="fas fa-headset"></i> Contact Us</a></li>
                    </ul>
                </div>
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
                <a class="navbar-brand" href="panel"><img src="images/logo.png" class="logo" alt=""></a>
            </div>
            <!-- End Header Navigation -->

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="navbar-menu">
                <ul class="nav navbar-nav ml-auto" data-in="fadeInDown" data-out="fadeOutUp">
                    <li class="nav-item"><a class="nav-link" href="panel">Home</a></li>
                    <li class="dropdown">
                        <a href="#" class="nav-link arrow" data-toggle="dropdown">DISPLAY</a>
                        <ul class="dropdown-menu">
                            <li><a href="products">Products</a></li>
                            <li><a href="customers">Customers</a></li>
                        </ul>
                    </li>
                    <li class="nav-item"><a class="nav-link" href="addProduct">Add Product</a></li>
                    <li class="nav-item"><a class="nav-link" href="underDev.jsp">Contact Us</a></li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->

<%--            <!-- Start Atribute Navigation -->--%>
<%--            <div class="attr-nav">--%>
<%--                <ul>--%>
<%--                    <li class="search"><a href="#"><i class="fa fa-search"></i></a></li>--%>
<%--                    <c:choose>--%>

<%--                        <c:when test="${sessionScope.currentUser!=null}">--%>
<%--                            <li class="side-menu"><a href="#">--%>
<%--                                <i class="fa fa-shopping-bag"></i>--%>
<%--                                <span class="badge">3</span>--%>
<%--&lt;%&ndash;                                <p>My Cart</p>&ndash;%&gt;--%>
<%--                            </a></li>--%>
<%--                        </c:when><c:when test="${sessionScope.currentUser==null}">--%>
<%--                            <li class="side"><a href="#">--%>
<%--                                <i class="fa fa-shopping-bag"></i>--%>
<%--                                <span class="badge"></span>--%>
<%--&lt;%&ndash;                                <p>My Cart</p>&ndash;%&gt;--%>
<%--                            </a></li>--%>
<%--                        </c:when>--%>
<%--                    </c:choose>--%>

<%--                </ul>--%>
<%--            </div>--%>
<%--            <!-- End Atribute Navigation -->--%>
        </div>
    </nav>
    <!-- End Navigation -->
</header>
<!-- End Main Top -->

<!-- Start Top Search -->
<%--<div class="top-search">--%>
<%--    <div class="container">--%>
<%--        <div class="input-group">--%>
<%--            <span class="input-group-addon"><i class="fa fa-search"></i></span>--%>
<%--            <input type="text" class="form-control" placeholder="Search">--%>
<%--            <span class="input-group-addon close-search"><i class="fa fa-times"></i></span>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<!-- End Top Search -->

<%--</body>--%>
<%--</html>--%>

