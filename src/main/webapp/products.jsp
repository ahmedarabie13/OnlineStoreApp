<%@ taglib prefix="Product" uri="/WEB-INF/tlds/ProductTagLib2.tld" %>
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

        <!-- Site Icons -->
        <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
        <link rel="apple-touch-icon" href="images/apple-touch-icon.png">

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
    <script src="customValidations/products.js"></script>

</head>
<body>

<jsp:include page="header.jsp"/>

<!-- Start All Title Box -->
<div class="all-title-box">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <h2>Products</h2>
                <ul class="breadcrumb">
                    <li class="breadcrumb-item"><a href="main">Home</a></li>
                    <li class="breadcrumb-item active">Manage Products</li>
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
                    <div class="product-item-filter row">
                        <div class="col-12 col-sm-8 text-center text-sm-left">
                            <div class="toolbar-sorter-right" style="align-items: center">
                                <a class="btn hvr-hover" data-fancybox-close="" href="addProduct.jsp" style="width:400px;"><b>ADD NEW PRODUCT</b></a>
                            </div>
                        </div>
                    </div>
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
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xl-3 col-lg-3 col-sm-12 col-xs-12 sidebar-shop-left">
                <div class="product-categori">
                    <div class="search-product">
                        <form action="#">
                            <input class="form-control" placeholder="Search here..." type="text">
                            <button type="submit"><i class="fa fa-search"></i></button>
                        </form>
                    </div>
                    <div class="filter-sidebar-left">
                        <div class="title-left">
                            <h3>Categories</h3>
                        </div>
                        <div class="list-group list-group-collapse list-group-sm list-group-tree" id="list-group-men"
                             data-children=".sub-men">
                            <a href="products?page=1" class="list-group-item list-group-item-action">All</a>
                            <c:forEach items="${requestScope.categories}" var="category">
                                <a href="products?page=1&cat=${category.id}"
                                   class="list-group-item list-group-item-action"
                                   id="catId" name="${category.id}">${category.name}</a>
                            </c:forEach>
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
                                   href="products?page=${pageNum}&cat=${param.cat}">${pageNum}</a>
                            </c:if>
                            <c:if test="${empty param.cat}">
                                <a class="submit-button btn hvr-hover" style="background-color: #856404;"
                                   href="products?page=${pageNum}">${pageNum}</a>
                            </c:if>
                        </c:when>
                        <c:when test="${requestScope.currentPage != (pageNum)}">
                            <c:if test="${not empty param.cat}">
                                <a class="submit-button btn hvr-hover"
                                   href="products?page=${pageNum}&cat=${param.cat}">${pageNum}</a>
                            </c:if>
                            <c:if test="${empty param.cat}">
                                <a class="submit-button btn hvr-hover"
                                   href="products?page=${pageNum}">${pageNum}</a>
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
<script src="customValidations/products.js"></script>


<%--for the error $(...).slider is not a function--%>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script src="customValidations/cat.js"></script>
</body>

</html>