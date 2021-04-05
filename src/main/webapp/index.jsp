<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="Product" uri="/WEB-INF/tlds/ProductTagLib.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<!-- Basic -->

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- Mobile Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Site Metas -->
    <title>Home</title>
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

    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
<jsp:include page="header.jsp"/>

<!-- Start Slider -->
<div id="slides-shop" class="cover-slides">
    <ul class="slides-container">
        <li class="text-center">
            <img src="images/banner-01.jpg" alt="">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <h1 class="m-b-20"><strong>Welcome To <br> Freshshop</strong></h1>
<%--                        <p class="m-b-40">See how your users experience your website in realtime or view <br> trends to--%>
<%--                            see any changes in performance over time.</p>--%>
<%--                        <p><a class="btn hvr-hover" href="#">Shop New</a></p>--%>
                    </div>
                </div>
            </div>
        </li>
        <li class="text-center">
            <img src="images/banner-02.jpg" alt="">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <h1 class="m-b-20"><strong>Welcome To <br> Freshshop</strong></h1>
<%--                        <p class="m-b-40">See how your users experience your website in realtime or view <br> trends to--%>
<%--                            see any changes in performance over time.</p>--%>
<%--                        <p><a class="btn hvr-hover" href="#">Shop New</a></p>--%>
                    </div>
                </div>
            </div>
        </li>
        <li class="text-center">
            <img src="images/banner-03.jpg" alt="">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <h1 class="m-b-20"><strong>Welcome To <br> Freshshop</strong></h1>
<%--                        <p class="m-b-40">See how your users experience your website in realtime or view <br> trends to--%>
<%--                            see any changes in performance over time.</p>--%>
<%--                        <p><a class="btn hvr-hover" href="#">Shop New</a></p>--%>
                    </div>
                </div>
            </div>
        </li>
    </ul>
    <div class="slides-navigation">
        <a href="#" class="next"><i class="fa fa-angle-right" aria-hidden="true"></i></a>
        <a href="#" class="prev"><i class="fa fa-angle-left" aria-hidden="true"></i></a>
    </div>
</div>
<!-- End Slider -->

<!-- Start Categories  -->
<div class="categories-shop">
    <div class="container">
        <div class="row">
            <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                <div class="shop-cat-box">
                    <img class="img-fluid"
                         src="https://cdn.shopify.com/s/files/1/0448/0371/9326/products/fresh-fruits-box-large.png?v=1596505432" alt=""/>
                    <a class="btn hvr-hover" href="#">Fruits</a>
                </div>
            </div>
            <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                <div class="shop-cat-box">
                    <img class="img-fluid"
                         src="https://www.canal-supplier.com/ship/wp-content/uploads/2015/11/FRESH-VEGETABLES-600x600.jpg"
                         alt=""/>
                    <a class="btn hvr-hover" href="#">Veges</a>
                </div>
            </div>
            <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                <div class="shop-cat-box">
                    <img class="img-fluid"
                         src="https://storcpdkenticomedia.blob.core.windows.net/media/recipemanagementsystem/media/recipe-media-files/recipes/retail/x17/2018_sweet-sallty-snack-mix_5817_600x600.jpg?ext=.jpg"
                         alt=""/>
                    <a class="btn hvr-hover" href="#">Snacks</a>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- End Categories -->

<div class="box-add-products">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 col-md-6 col-sm-12">
                <div class="offer-box-products">
                    <img class="img-fluid" src="images/add-img-01.jpg" alt=""/>
                </div>
            </div>
            <div class="col-lg-6 col-md-6 col-sm-12">
                <div class="offer-box-products">
                    <img class="img-fluid" src="images/add-img-02.jpg" alt=""/>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Start Products  -->
<div class="products-box">
    <div class="container">
        <div class="row">
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="special-menu text-center">
                    <div class="button-group filter-button-group">
                        <button data-filter=".best-seller" class="active selected">Recently added</button>
                    </div>
                </div>
            </div>
        </div>

        <div class="row container special-list" id="productsList">
            <c:forEach items="${requestScope.lastRecentProducts}" var="product">
                <Product:Product productName="${product.productName}"
                                 productImageURL="${product.productImageURL}"
                                 productPrice="${product.productPrice}"
                                 productId="${product.productID}" productStatus="${product.productStatus}"/>
            </c:forEach>
        </div>
    </div>
</div>
<!-- End Products  -->

<!-- Start Blog  -->
<div class="latest-blog">
    <div class="container">
<%--        <div class="row">--%>
        <%--            <div class="col-lg-12">--%>
        <%--                <div class="title-all text-center">--%>
        <%--                    <h1>latest blog</h1>--%>
        <%--                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sit amet lacus enim.</p>--%>
        <%--                </div>--%>
        <%--            </div>--%>
        <%--        </div>--%>
        <%--        <div class="row">--%>
            <%--                <div class="col-md-6 col-lg-4 col-xl-4">--%>
            <%--                    <div class="blog-box">--%>
            <%--                        <div class="blog-img">--%>
            <%--                            <img class="img-fluid" src="images/blog-img.jpg" alt="" />--%>
            <%--                        </div>--%>
            <%--                        <div class="blog-content">--%>
            <%--                            <div class="title-blog">--%>
            <%--                                <h3>Fusce in augue non nisi fringilla</h3>--%>
            <%--                                <p>Nulla ut urna egestas, porta libero id, suscipit orci. Quisque in lectus sit amet urna dignissim feugiat. Mauris molestie egestas pharetra. Ut finibus cursus nunc sed mollis. Praesent laoreet lacinia elit id lobortis.</p>--%>
            <%--                            </div>--%>
            <%--                            <ul class="option-blog">--%>
            <%--                                <li><a href="#"><i class="far fa-heart"></i></a></li>--%>
            <%--                                <li><a href="#"><i class="fas fa-eye"></i></a></li>--%>
            <%--                                <li><a href="#"><i class="far fa-comments"></i></a></li>--%>
            <%--                            </ul>--%>
            <%--                        </div>--%>
            <%--                    </div>--%>
            <%--                </div>--%>
            <%--                <div class="col-md-6 col-lg-4 col-xl-4">--%>
            <%--                    <div class="blog-box">--%>
            <%--                        <div class="blog-img">--%>
            <%--                            <img class="img-fluid" src="images/blog-img-01.jpg" alt="" />--%>
            <%--                        </div>--%>
            <%--                        <div class="blog-content">--%>
            <%--                            <div class="title-blog">--%>
            <%--                                <h3>Fusce in augue non nisi fringilla</h3>--%>
            <%--                                <p>Nulla ut urna egestas, porta libero id, suscipit orci. Quisque in lectus sit amet urna dignissim feugiat. Mauris molestie egestas pharetra. Ut finibus cursus nunc sed mollis. Praesent laoreet lacinia elit id lobortis.</p>--%>
            <%--                            </div>--%>
            <%--                            <ul class="option-blog">--%>
            <%--                                <li><a href="#"><i class="far fa-heart"></i></a></li>--%>
            <%--                                <li><a href="#"><i class="fas fa-eye"></i></a></li>--%>
            <%--                                <li><a href="#"><i class="far fa-comments"></i></a></li>--%>
            <%--                            </ul>--%>
            <%--                        </div>--%>
            <%--                    </div>--%>
            <%--                </div>--%>
            <%--                <div class="col-md-6 col-lg-4 col-xl-4">--%>
            <%--                    <div class="blog-box">--%>
            <%--                        <div class="blog-img">--%>
            <%--                            <img class="img-fluid" src="images/blog-img-02.jpg" alt="" />--%>
            <%--                        </div>--%>
            <%--                        <div class="blog-content">--%>
            <%--                            <div class="title-blog">--%>
            <%--                                <h3>Fusce in augue non nisi fringilla</h3>--%>
            <%--                                <p>Nulla ut urna egestas, porta libero id, suscipit orci. Quisque in lectus sit amet urna dignissim feugiat. Mauris molestie egestas pharetra. Ut finibus cursus nunc sed mollis. Praesent laoreet lacinia elit id lobortis.</p>--%>
            <%--                            </div>--%>
            <%--                            <ul class="option-blog">--%>
            <%--                                <li><a href="#"><i class="far fa-heart"></i></a></li>--%>
            <%--                                <li><a href="#"><i class="fas fa-eye"></i></a></li>--%>
            <%--                                <li><a href="#"><i class="far fa-comments"></i></a></li>--%>
            <%--                            </ul>--%>
            <%--                        </div>--%>
            <%--                    </div>--%>
            <%--                </div>--%>
        </div>
    </div>
</div>
<!-- End Blog  -->


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

<script src="customValidations/products.js"></script>
<script src="js/jquery.nicescroll.min.js"></script>
</body>

<%--for the error $(...).slider is not a function--%>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

</html>