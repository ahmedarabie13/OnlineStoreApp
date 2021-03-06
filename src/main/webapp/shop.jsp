<%@ taglib prefix="Product" uri="/WEB-INF/tlds/ProductTagLib.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<!-- Basic -->

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- Mobile Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Site Metas -->
    <title>Freshshop - Ecommerce Bootstrap 4 HTML Template</title>
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
<%--<!--    <script src="customValidations/products.js"></script>-->--%>
    <![endif]-->
    <%--    <script src="customValidations/products.js"></script>--%>

</head>
<%--<body onload="setParameters('<%= request.getAttribute("filterStart")%>',--%>
<%--        '<%= request.getAttribute("filterEnd")%>' ,--%>
<%--        '<%= request.getAttribute("currentCategory")%>', '<%= request.getAttribute("currentPage")%>')">--%>
<body onload="setParameters('${requestScope.filterStart}', '${requestScope.filterEnd}',
        '${requestScope.currentCategory}', '${requestScope.currentPage}')">

<jsp:include page="header.jsp"/>

<!-- Start All Title Box -->
<div class="all-title-box">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <h2>Shop</h2>
                <ul class="breadcrumb">
                    <li class="breadcrumb-item"><a href="main">Home</a></li>
                    <li class="breadcrumb-item active">Shop</li>
                </ul>
            </div>
        </div>
    </div>
</div>
<!-- End All Title Box -->

<!-- Start Shop Page  -->
<div class="shop-box-inner">
    <div class="container">
        <div class="row">
            <div class="col-xl-9 col-lg-9 col-sm-12 col-xs-12 shop-content-right">
                <div class="right-product-box">


                    <div class="product-categorie-box">
                        <div class="tab-content">
                            <div role="tabpanel" class="tab-pane fade show active" id="grid-view">

                                <div class="row container special-list" id="productsDiv">
                                    <c:forEach items="${requestScope.products}" var="product">
                                        <Product:Product productName="${product.productName}"
                                                         productImageURL="${product.productImageURL}"
                                                         productPrice="${product.productPrice}"
                                                         productStatus="${product.productStatus}"
                                                         productId="${product.productID}"
                                        />
                                    </c:forEach>
                                </div>
                                <c:if test="${empty requestScope.products && requestScope.nothing ==false }">
                                    <span id="emptyList"
                                          style="font-size:larger; color: black;"> Your search for "${requestScope.searchFor}" did not yield any results.</span>
                                </c:if>

                                <c:if test="${ requestScope.nothing ==true}">
                                <span id="emptyList"
                                      style="font-size:larger; color: black;"> Please enter the name of product you search for </span>
                                </c:if>

                            </div>
                            <div role="tabpanel" class="tab-pane fade" id="list-view">
                                <div class="list-view-box">
                                    <div class="row">
                                        <div class="col-sm-6 col-md-6 col-lg-4 col-xl-4">
                                            <div class="products-single fix">
                                                <div class="box-img-hover">
                                                    <div class="type-lb">
                                                        <p class="new">New</p>
                                                    </div>
                                                    <img src="images/img-pro-01.jpg" class="img-fluid" alt="Image">
                                                    <div class="mask-icon">
                                                        <ul>
                                                            <li><a href="#" data-toggle="tooltip" data-placement="right"
                                                                   title="View"><i class="fas fa-eye"></i></a></li>
                                                            <li><a href="#" data-toggle="tooltip" data-placement="right"
                                                                   title="Compare"><i class="fas fa-sync-alt"></i></a>
                                                            </li>
                                                            <li><a href="#" data-toggle="tooltip" data-placement="right"
                                                                   title="Add to Wishlist"><i class="far fa-heart"></i></a>
                                                            </li>
                                                        </ul>

                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-6 col-md-6 col-lg-8 col-xl-8">
                                            <div class="why-text full-width">
                                                <h4>Lorem ipsum dolor sit amet</h4>
                                                <h5>
                                                    <del>$ 60.00</del>
                                                    $40.79
                                                </h5>
                                                <p>Integer tincidunt aliquet nibh vitae dictum. In turpis sapien,
                                                    imperdiet quis magna nec, iaculis ultrices ante. Integer vitae
                                                    suscipit nisi. Morbi dignissim risus sit amet orci porta, eget
                                                    aliquam purus
                                                    sollicitudin. Cras eu metus felis. Sed arcu arcu, sagittis in
                                                    blandit eu, imperdiet sit amet eros. Donec accumsan nisi purus, quis
                                                    euismod ex volutpat in. Vestibulum eleifend eros ac lobortis
                                                    aliquet.
                                                    Suspendisse at ipsum vel lacus vehicula blandit et sollicitudin
                                                    quam. Praesent vulputate semper libero pulvinar consequat. Etiam ut
                                                    placerat lectus.</p>
                                                <a class="btn hvr-hover" href="#">Add to Cart</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="list-view-box">
                                    <div class="row">
                                        <div class="col-sm-6 col-md-6 col-lg-4 col-xl-4">
                                            <div class="products-single fix">
                                                <div class="box-img-hover">
                                                    <div class="type-lb">
                                                        <p class="sale">Sale</p>
                                                    </div>
                                                    <img src="images/img-pro-02.jpg" class="img-fluid" alt="Image">
                                                    <div class="mask-icon">
                                                        <ul>
                                                            <li><a href="#" data-toggle="tooltip" data-placement="right"
                                                                   title="View"><i class="fas fa-eye"></i></a></li>
                                                            <li><a href="#" data-toggle="tooltip" data-placement="right"
                                                                   title="Compare"><i class="fas fa-sync-alt"></i></a>
                                                            </li>
                                                            <li><a href="#" data-toggle="tooltip" data-placement="right"
                                                                   title="Add to Wishlist"><i class="far fa-heart"></i></a>
                                                            </li>
                                                        </ul>

                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-6 col-md-6 col-lg-8 col-xl-8">
                                            <div class="why-text full-width">
                                                <h4>Lorem ipsum dolor sit amet</h4>
                                                <h5>
                                                    <del>$ 60.00</del>
                                                    $40.79
                                                </h5>
                                                <p>Integer tincidunt aliquet nibh vitae dictum. In turpis sapien,
                                                    imperdiet quis magna nec, iaculis ultrices ante. Integer vitae
                                                    suscipit nisi. Morbi dignissim risus sit amet orci porta, eget
                                                    aliquam purus
                                                    sollicitudin. Cras eu metus felis. Sed arcu arcu, sagittis in
                                                    blandit eu, imperdiet sit amet eros. Donec accumsan nisi purus, quis
                                                    euismod ex volutpat in. Vestibulum eleifend eros ac lobortis
                                                    aliquet.
                                                    Suspendisse at ipsum vel lacus vehicula blandit et sollicitudin
                                                    quam. Praesent vulputate semper libero pulvinar consequat. Etiam ut
                                                    placerat lectus.</p>
                                                <a class="btn hvr-hover" href="#">Add to Cart</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="list-view-box">
                                    <div class="row">
                                        <div class="col-sm-6 col-md-6 col-lg-4 col-xl-4">
                                            <div class="products-single fix">
                                                <div class="box-img-hover">
                                                    <div class="type-lb">
                                                        <p class="sale">Sale</p>
                                                    </div>
                                                    <img src="images/img-pro-03.jpg" class="img-fluid" alt="Image">
                                                    <div class="mask-icon">
                                                        <ul>
                                                            <li><a href="#" data-toggle="tooltip" data-placement="right"
                                                                   title="View"><i class="fas fa-eye"></i></a></li>
                                                            <li><a href="#" data-toggle="tooltip" data-placement="right"
                                                                   title="Compare"><i class="fas fa-sync-alt"></i></a>
                                                            </li>
                                                            <li><a href="#" data-toggle="tooltip" data-placement="right"
                                                                   title="Add to Wishlist"><i class="far fa-heart"></i></a>
                                                            </li>
                                                        </ul>

                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-6 col-md-6 col-lg-8 col-xl-8">
                                            <div class="why-text full-width">
                                                <h4>Lorem ipsum dolor sit amet</h4>
                                                <h5>
                                                    <del>$ 60.00</del>
                                                    $40.79
                                                </h5>
                                                <p>Integer tincidunt aliquet nibh vitae dictum. In turpis sapien,
                                                    imperdiet quis magna nec, iaculis ultrices ante. Integer vitae
                                                    suscipit nisi. Morbi dignissim risus sit amet orci porta, eget
                                                    aliquam purus
                                                    sollicitudin. Cras eu metus felis. Sed arcu arcu, sagittis in
                                                    blandit eu, imperdiet sit amet eros. Donec accumsan nisi purus, quis
                                                    euismod ex volutpat in. Vestibulum eleifend eros ac lobortis
                                                    aliquet.
                                                    Suspendisse at ipsum vel lacus vehicula blandit et sollicitudin
                                                    quam. Praesent vulputate semper libero pulvinar consequat. Etiam ut
                                                    placerat lectus.</p>
                                                <a class="btn hvr-hover" href="#">Add to Cart</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xl-3 col-lg-3 col-sm-12 col-xs-12 sidebar-shop-left">
                <div class="product-categori">
                    <div class="search-product">
                        <form action="search" method="post">
                            <input name="searchFor" class="form-control" placeholder="Search here..." type="text">
                            <button type="submit"><i class="fa fa-search"></i></button>
                        </form>
                    </div>
                    <div class="filter-sidebar-left">
                        <div class="title-left">
                            <h3>Categories</h3>
                        </div>
                        <div class="list-group list-group-collapse list-group-sm list-group-tree" id="list-group-men"
                             data-children=".sub-men">
                            <a href="shop?page=1" class="list-group-item list-group-item-action">All</a>
                            <c:forEach items="${requestScope.categories}" var="category">
                                <%--                                <a href="shop?page=1&cat=${category.id}" class="list-group-item list-group-item-action"--%>
                                <%--                                <a href="shop?page=${requestScope.currentPage}&cat=${category.id}&filterStart=${requestScope.filterStart}&filterEnd=${requestScope.filterEnd}"--%>
                                <a href="shop?page=1&cat=${category.id}"
                                   class="list-group-item list-group-item-action"
                                   id="catId" name="${category.id}">${category.name}</a>
                            </c:forEach>

                        </div>
                    </div>
                    <div class="filter-price-left">
                        <div class="title-left">
                            <h3>Price</h3>
                        </div>
                        <div class="price-box-slider">
                            <div id="slider-range"></div>
                            <p>
                                <input type="text" id="amount" readonly
                                       style="border:0; color:#fbb714; font-weight:bold;">
                                <button class="btn hvr-hover" onclick="filter()">Filter</button>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="row">
    <div class="col-lg-12">
        <div class="special-menu text-center">
            <div class="button-group">
                <c:forEach begin="1" end="${requestScope.numOfPages}" step="1" var="pageNumber">
                    <fmt:parseNumber var="pageNum" value="${pageNumber}" integerOnly="true"/>
                    <c:choose>
                        <c:when test="${requestScope.currentPage == (pageNum)}">
                            <c:if test="${not empty param.cat}">
                                <a class="submit-button btn hvr-hover" style="background-color: #856404;"
                                   href="shop?page=${pageNum}&cat=${param.cat}&filterStart=${requestScope.filterStart}&filterEnd=${requestScope.filterEnd}">${pageNum}</a>
                            </c:if>
                            <c:if test="${empty param.cat}">
                                <a class="submit-button btn hvr-hover" style="background-color: #856404;"
                                   href="shop?page=${pageNum}&filterStart=${requestScope.filterStart}&filterEnd=${requestScope.filterEnd}">${pageNum}</a>
                            </c:if>
                        </c:when>
                        <c:when test="${requestScope.currentPage != (pageNum)}">
                            <c:if test="${not empty param.cat}">
                                <a class="submit-button btn hvr-hover"
                                   href="shop?page=${pageNum}&cat=${param.cat}&filterStart=${requestScope.filterStart}&filterEnd=${requestScope.filterEnd}">${pageNum}</a>
                            </c:if>
                            <c:if test="${empty param.cat}">
                                <a class="submit-button btn hvr-hover"
                                   href="shop?page=${pageNum}&filterStart=${requestScope.filterStart}&filterEnd=${requestScope.filterEnd}">${pageNum}</a>
                            </c:if>
                        </c:when>
                    </c:choose>
                </c:forEach>
            </div>
        </div>
    </div>
</div>


<!-- End Shop Page -->

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
<script src="js/jquery-ui.js"></script>
<script src="js/jquery.nicescroll.min.js"></script>
<script src="js/form-validator.min.js"></script>
<script src="js/contact-form-script.js"></script>
<script src="js/custom.js"></script>
<script>
    function addToCart(productId) {

        console.log("added id: " + productId + " to cart");
        let jsonData = {"productId": productId};
        console.log("sdff");
        // let cartSize = parseInt($('#cartSize').text()) + 1;
        // $('#cartSize').text(cartSize);
        $.post("addToCart", jsonData, done);

        function done(data) {
            console.log(data);
            let output = JSON.parse(data);
            if (output.status === "new") {
                console.log($('#cartSize').text());
                let cartSize = parseInt($('#cartSize').text()) + 1;
                console.log("cartSize: " + cartSize);
                $('#cartSize').text(cartSize);
            } else if (output.status === "error") {
                console.log("error");
                $('#prodError' + productId).text('No Enough Goods');
            }
        }
    }
</script>
<script src="customValidations/products.js"></script>


<%--for the error $(...).slider is not a function--%>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script src="customValidations/cat.js"></script>
</body>

</html>