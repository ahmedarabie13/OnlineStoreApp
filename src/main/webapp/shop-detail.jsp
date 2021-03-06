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
                <h2>Shop Detail</h2>
                <ul class="breadcrumb">
                    <li class="breadcrumb-item"><a href="shop">Shop</a></li>
                    <li class="breadcrumb-item active">Shop Detail</li>
                </ul>
            </div>
        </div>
    </div>
</div>
<!-- End All Title Box -->

<!-- Start Shop Detail  -->
<div class="shop-detail-box-main">
    <div class="container">
        <div class="row">
            <div class="col-xl-5 col-lg-5 col-md-6">
                <div id="carousel-example-1" class="single-product-slider carousel slide" data-ride="carousel">
                    <div class="carousel-inner" role="listbox">
                        <c:if test="${not empty requestScope.productObj}">
                            <div class="carousel-item active"><img class="d-block w-100"
                                                                   src="${requestScope.productObj.photo}"
                                                                   alt="First slide"></div>
                            <div class="carousel-item"><img class="d-block w-100" src="${requestScope.productObj.photo}"
                                                            alt="Second slide"></div>
                            <div class="carousel-item"><img class="d-block w-100" src="${requestScope.productObj.photo}"
                                                            alt="Third slide"></div>
                        </c:if>
                        <c:if test="${empty requestScope.productObj}">
                            <div class="carousel-item active"><img class="d-block w-100" src="images/big-img-01.jpg"
                                                                   alt="First slide"></div>
                            <div class="carousel-item"><img class="d-block w-100" src="images/big-img-02.jpg"
                                                            alt="Second slide"></div>
                            <div class="carousel-item"><img class="d-block w-100" src="images/big-img-03.jpg"
                                                            alt="Third slide"></div>
                        </c:if>
                    </div>
                    <a class="carousel-control-prev" href="#carousel-example-1" role="button" data-slide="prev">
                        <i class="fa fa-angle-left" aria-hidden="true"></i>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carousel-example-1" role="button" data-slide="next">
                        <i class="fa fa-angle-right" aria-hidden="true"></i>
                        <span class="sr-only">Next</span>
                    </a>
                    <ol class="carousel-indicators">
                        <li data-target="#carousel-example-1" data-slide-to="0" class="active">
                            <c:if test="${not empty requestScope.productObj}">
                                <img class="d-block w-100 img-fluid" src="${requestScope.productObj.photo}"
                                     alt="${requestScope.productObj.productName}"/>
                            </c:if>
                            <c:if test="${empty requestScope.productObj}">
                                <img class="d-block w-100 img-fluid" src="images/smp-img-01.jpg" alt=""/>
                            </c:if>
                        </li>
                        <li data-target="#carousel-example-1" data-slide-to="1">
                            <c:if test="${not empty requestScope.productObj}">
                                <img class="d-block w-100 img-fluid" src="${requestScope.productObj.photo}"
                                     alt="${requestScope.productObj.productName}"/>
                            </c:if>
                            <c:if test="${empty requestScope.productObj}">
                                <img class="d-block w-100 img-fluid" src="images/smp-img-02.jpg" alt=""/>
                            </c:if>
                        </li>
                        <li data-target="#carousel-example-1" data-slide-to="2">
                            <c:if test="${not empty requestScope.productObj}">
                                <img class="d-block w-100 img-fluid" src="${requestScope.productObj.photo}"
                                     alt="${requestScope.productObj.productName}"/>
                            </c:if>
                            <c:if test="${empty requestScope.productObj}">
                                <img class="d-block w-100 img-fluid" src="images/smp-img-03.jpg" alt=""/>
                            </c:if>
                        </li>
                    </ol>
                </div>
            </div>
            <div class="col-xl-7 col-lg-7 col-md-6">
                <div class="single-product-details">
                    <c:choose>
                        <c:when test="${not empty requestScope.productObj}">
                            <h2>${requestScope.productObj.productName}</h2>
                            <h5>${requestScope.productObj.price}</h5>
                            <p class="available-stock"><span>${requestScope.productObj.quantity} in stock</span>
                            <p>
                            <h4>Description:</h4>
                            <p>${requestScope.productObj.productDescription}.</p>
                        </c:when>
                        <c:when test="${empty requestScope.productObj}">
                            <h2>Fachion Lorem ipsum dolor sit amet</h2>
                            <h5>
                                <del>$ 60.00</del>
                                $40.79
                            </h5>
                            <p class="available-stock"><span> More than 20 available / <a href="#">8 sold </a></span>
                            <p>
                            <h4>Short Description:</h4>
                            <p>Nam sagittis a augue eget scelerisque. Nullam lacinia consectetur sagittis. Nam sed neque
                                id eros fermentum dignissim quis at tortor. Nullam ultricies urna quis sem sagittis
                                pharetra. Nam erat turpis, cursus in ipsum at,
                                tempor imperdiet metus. In interdum id nulla tristique accumsan. Ut semper in quam nec
                                pretium. Donec egestas finibus suscipit. Curabitur tincidunt convallis arcu. </p>
                        </c:when>
                    </c:choose>
                    <ul>
                        <li>
                            <div class="form-group quantity-box">
                                <label class="control-label">Quantity</label>
                                <input class="form-control" value="0" min="0" id="cartItemQuantity"
                                       onchange="setQuantity(${requestScope.productObj.id},${requestScope.productObj.quantity})" type="number">
                            </div>
                        </li>
                    </ul>
                    <span class="text-danger" id="prodError${requestScope.productObj.id}"></span>
                    <div class="price-box-bar">
                        <div class="cart-and-bay-btn">
                            <%--								<a class="btn hvr-hover" data-fancybox-close="" href="#">Buy New</a>--%>
                            <%--                                do the same as the one in the products page--%>
                            <c:if test="${requestScope.productObj.quantity == 0}">
                                <a class="btn hvr-hover"
                                   data-fancybox-close="" style="pointer-events: none">
                                    <del>Add to cart</del>
                                </a>
                            </c:if>
                            <c:if test="${requestScope.productObj.quantity > 0}">
                                <a class="btn hvr-hover" data-fancybox-close="" onclick="addToCart(${requestScope.productObj.id})">Add to cart</a>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <%--			<div class="row my-5">--%>
        <%--				<div class="card card-outline-secondary my-4">--%>
        <%--					<div class="card-header">--%>
        <%--						<h2>Product Reviews</h2>--%>
        <%--					</div>--%>
        <%--					<div class="card-body">--%>
        <%--						<div class="media mb-3">--%>
        <%--							<div class="mr-2"> --%>
        <%--								<img class="rounded-circle border p-1" src="data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%2264%22%20height%3D%2264%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%2064%2064%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_160c142c97c%20text%20%7B%20fill%3Argba(255%2C255%2C255%2C.75)%3Bfont-weight%3Anormal%3Bfont-family%3AHelvetica%2C%20monospace%3Bfont-size%3A10pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_160c142c97c%22%3E%3Crect%20width%3D%2264%22%20height%3D%2264%22%20fill%3D%22%23777%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%2213.5546875%22%20y%3D%2236.5%22%3E64x64%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E" alt="Generic placeholder image">--%>
        <%--							</div>--%>
        <%--							<div class="media-body">--%>
        <%--								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis et enim aperiam inventore, similique necessitatibus neque non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum. Sequi mollitia, necessitatibus quae sint natus.</p>--%>
        <%--								<small class="text-muted">Posted by Anonymous on 3/1/18</small>--%>
        <%--							</div>--%>
        <%--						</div>--%>
        <%--						<hr>--%>
        <%--						<div class="media mb-3">--%>
        <%--							<div class="mr-2"> --%>
        <%--								<img class="rounded-circle border p-1" src="data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%2264%22%20height%3D%2264%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%2064%2064%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_160c142c97c%20text%20%7B%20fill%3Argba(255%2C255%2C255%2C.75)%3Bfont-weight%3Anormal%3Bfont-family%3AHelvetica%2C%20monospace%3Bfont-size%3A10pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_160c142c97c%22%3E%3Crect%20width%3D%2264%22%20height%3D%2264%22%20fill%3D%22%23777%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%2213.5546875%22%20y%3D%2236.5%22%3E64x64%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E" alt="Generic placeholder image">--%>
        <%--							</div>--%>
        <%--							<div class="media-body">--%>
        <%--								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis et enim aperiam inventore, similique necessitatibus neque non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum. Sequi mollitia, necessitatibus quae sint natus.</p>--%>
        <%--								<small class="text-muted">Posted by Anonymous on 3/1/18</small>--%>
        <%--							</div>--%>
        <%--						</div>--%>
        <%--						<hr>--%>
        <%--						<div class="media mb-3">--%>
        <%--							<div class="mr-2"> --%>
        <%--								<img class="rounded-circle border p-1" src="data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%2264%22%20height%3D%2264%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%2064%2064%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_160c142c97c%20text%20%7B%20fill%3Argba(255%2C255%2C255%2C.75)%3Bfont-weight%3Anormal%3Bfont-family%3AHelvetica%2C%20monospace%3Bfont-size%3A10pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_160c142c97c%22%3E%3Crect%20width%3D%2264%22%20height%3D%2264%22%20fill%3D%22%23777%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%2213.5546875%22%20y%3D%2236.5%22%3E64x64%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E" alt="Generic placeholder image">--%>
        <%--							</div>--%>
        <%--							<div class="media-body">--%>
        <%--								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis et enim aperiam inventore, similique necessitatibus neque non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum. Sequi mollitia, necessitatibus quae sint natus.</p>--%>
        <%--								<small class="text-muted">Posted by Anonymous on 3/1/18</small>--%>
        <%--							</div>--%>
        <%--						</div>--%>
        <%--						<hr>--%>
        <%--						<a href="#" class="btn hvr-hover">Leave a Review</a>--%>
        <%--					</div>--%>
        <%--				  </div>--%>
        <%--			</div>--%>

        <div class="row my-5">
            <div class="col-lg-12">
                <div class="title-all text-center">
                    <h1>Coming Soon</h1>
                    <%--                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sit amet lacus enim.</p>--%>
                </div>
                <div class="featured-products-box owl-carousel owl-theme">
                    <div class="item">
                        <div class="products-single fix">
                            <div class="box-img-hover">
                                <img src="images/img-pro-01.jpg" class="img-fluid" alt="Image">
                                <div class="mask-icon">
                                    <%--                                        <ul>--%>
                                    <%--                                            <li><a href="#" data-toggle="tooltip" data-placement="right" title="View"><i class="fas fa-eye"></i></a></li>--%>
                                    <%--                                            <li><a href="#" data-toggle="tooltip" data-placement="right" title="Compare"><i class="fas fa-sync-alt"></i></a></li>--%>
                                    <%--                                            <li><a href="#" data-toggle="tooltip" data-placement="right" title="Add to Wishlist"><i class="far fa-heart"></i></a></li>--%>
                                    <%--                                        </ul>--%>
                                    <%--                                        <a class="cart" href="#">Add to Cart</a>--%>
                                </div>
                            </div>
                            <div class="why-text">
                                <h4>Baby Carrots</h4>
                                <%--                                    <h5> $9.79</h5>--%>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <div class="products-single fix">
                            <div class="box-img-hover">
                                <img src="images/img-pro-02.jpg" class="img-fluid" alt="Image">
                                <div class="mask-icon">
                                    <ul>
                                        <%--                                            <li><a href="#" data-toggle="tooltip" data-placement="right" title="View"><i class="fas fa-eye"></i></a></li>--%>
                                        <%--                                            <li><a href="#" data-toggle="tooltip" data-placement="right" title="Compare"><i class="fas fa-sync-alt"></i></a></li>--%>
                                        <%--                                            <li><a href="#" data-toggle="tooltip" data-placement="right" title="Add to Wishlist"><i class="far fa-heart"></i></a></li>--%>
                                    </ul>
                                    <%--                                        <a class="cart" href="#">Add to Cart</a>--%>
                                </div>
                            </div>
                            <div class="why-text">
                                <h4>Juicy Tomato</h4>
                                <%--                                    <h5> $9.79</h5>--%>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <div class="products-single fix">
                            <div class="box-img-hover">
                                <img src="images/img-pro-03.jpg" class="img-fluid" alt="Image">
                                <div class="mask-icon">
                                    <ul>
                                        <%--                                            <li><a href="#" data-toggle="tooltip" data-placement="right" title="View"><i class="fas fa-eye"></i></a></li>--%>
                                        <%--                                            <li><a href="#" data-toggle="tooltip" data-placement="right" title="Compare"><i class="fas fa-sync-alt"></i></a></li>--%>
                                        <%--                                            <li><a href="#" data-toggle="tooltip" data-placement="right" title="Add to Wishlist"><i class="far fa-heart"></i></a></li>--%>
                                    </ul>
<%--                                    <a class="cart" href="#">Add to Cart</a>--%>
                                </div>
                            </div>
                            <div class="why-text">
                                <h4>Greenish Olives</h4>
                                <%--                                    <h5> $9.79</h5>--%>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <div class="products-single fix">
                            <div class="box-img-hover">
                                <img src="images/img-pro-04.jpg" class="img-fluid" alt="Image">
                                <div class="mask-icon">
                                    <ul>
                                        <%--                                            <li><a href="#" data-toggle="tooltip" data-placement="right" title="View"><i class="fas fa-eye"></i></a></li>--%>
                                        <%--                                            <li><a href="#" data-toggle="tooltip" data-placement="right" title="Compare"><i class="fas fa-sync-alt"></i></a></li>--%>
                                        <%--                                            <li><a href="#" data-toggle="tooltip" data-placement="right" title="Add to Wishlist"><i class="far fa-heart"></i></a></li>--%>
                                    </ul>
                                    <%--                                        <a class="cart" href="#">Add to Cart</a>--%>
                                </div>
                            </div>
                            <div class="why-text">
                                <h4>Super Papaya</h4>
                                <%--                                    <h5> $9.79</h5>--%>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <div class="products-single fix">
                            <div class="box-img-hover">
                                <img src="images/img-pro-01.jpg" class="img-fluid" alt="Image">
                                <div class="mask-icon">
                                    <ul>
                                        <%--                                            <li><a href="#" data-toggle="tooltip" data-placement="right" title="View"><i class="fas fa-eye"></i></a></li>--%>
                                        <%--                                            <li><a href="#" data-toggle="tooltip" data-placement="right" title="Compare"><i class="fas fa-sync-alt"></i></a></li>--%>
                                        <%--                                            <li><a href="#" data-toggle="tooltip" data-placement="right" title="Add to Wishlist"><i class="far fa-heart"></i></a></li>--%>
                                    </ul>
                                    <%--                                        <a class="cart" href="#">Add to Cart</a>--%>
                                </div>
                            </div>
                            <div class="why-text">
                                <h4>Baby Carrots</h4>
                                <%--                                    <h5> $9.79</h5>--%>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <div class="products-single fix">
                            <div class="box-img-hover">
                                <img src="images/img-pro-02.jpg" class="img-fluid" alt="Image">
                                <div class="mask-icon">
                                    <ul>
                                        <%--                                            <li><a href="#" data-toggle="tooltip" data-placement="right" title="View"><i class="fas fa-eye"></i></a></li>--%>
                                        <%--                                            <li><a href="#" data-toggle="tooltip" data-placement="right" title="Compare"><i class="fas fa-sync-alt"></i></a></li>--%>
                                        <%--                                            <li><a href="#" data-toggle="tooltip" data-placement="right" title="Add to Wishlist"><i class="far fa-heart"></i></a></li>--%>
                                    </ul>
                                    <%--                                        <a class="cart" href="#">Add to Cart</a>--%>
                                </div>
                            </div>
                            <div class="why-text">
                                <h4>Juicy Tomato</h4>
                                <%--                                    <h5> $9.79</h5>--%>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <div class="products-single fix">
                            <div class="box-img-hover">
                                <img src="images/img-pro-03.jpg" class="img-fluid" alt="Image">
                                <div class="mask-icon">
                                    <ul>
                                        <%--                                            <li><a href="#" data-toggle="tooltip" data-placement="right" title="View"><i class="fas fa-eye"></i></a></li>--%>
                                        <%--                                            <li><a href="#" data-toggle="tooltip" data-placement="right" title="Compare"><i class="fas fa-sync-alt"></i></a></li>--%>
                                        <%--                                            <li><a href="#" data-toggle="tooltip" data-placement="right" title="Add to Wishlist"><i class="far fa-heart"></i></a></li>--%>
                                    </ul>
                                    <%--                                        <a class="cart" href="#">Add to Cart</a>--%>
                                </div>
                            </div>
                            <div class="why-text">
                                <h4>Greenish Olives</h4>
                                <%--                                    <h5> $9.79</h5>--%>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <div class="products-single fix">
                            <div class="box-img-hover">
                                <img src="images/img-pro-04.jpg" class="img-fluid" alt="Image">
                                <div class="mask-icon">
                                    <ul>
                                        <%--                                            <li><a href="#" data-toggle="tooltip" data-placement="right" title="View"><i class="fas fa-eye"></i></a></li>--%>
                                        <%--                                            <li><a href="#" data-toggle="tooltip" data-placement="right" title="Compare"><i class="fas fa-sync-alt"></i></a></li>--%>
                                        <%--                                            <li><a href="#" data-toggle="tooltip" data-placement="right" title="Add to Wishlist"><i class="far fa-heart"></i></a></li>--%>
                                    </ul>
                                    <a class="cart" href="#">Add to Cart</a>
                                </div>
                            </div>
                            <div class="why-text">
                                <h4>Super Papaya</h4>
                                <%--                                    <h5> $9.79</h5>--%>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
<!-- End Cart -->

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
<script>
    function setQuantity(productId, productQuantity) {
        let newVal = $('#cartItemQuantity').val();
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
        if (cartItemData.cartItemQuantity === 0) {
            console.log("calling delete");
            deleteProduct(productId);
        } else {
            console.log("calling Update");
            $.post("updateCart", "cartItemData=" + jsonData, done);
        }

        function done(data) {
            let output = JSON.parse(data);
            // if(data==="success"){
            if (output.status === "success") {
                // $('#prodPrice' + productId).empty();
                // let price = parseFloat(productPrice).toFixed(2) * parseInt(newVal);
                // price = parseFloat(price).toFixed();
                // $('#prodPrice' + productId).append("$ " + price);
                // $('#totalPrice').empty();
                // let totalPrice = parseFloat(output.totalPrice).toFixed(2);
                // console.log("totalPrice " + totalPrice);
                // $('#totalPrice').append("$ " + totalPrice);
                // // $('#productError' + productId).empty();
                $('#cartItemQuantity').css("border-color", "#B0B435");

                console.log("res" + data);
            } else {
                // $('#productError' + productId).text("invalid Quantity");
                $('cartItemQuantity').css("border-color", "#DC3545");
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
            // $('#product' + productId).remove();
            // $('#productError' + productId).remove();
            console.log("totalPrice: " + response.totalPrice);
            let cartSize = parseInt($('#cartSize').text()) - 1;
            console.log("cartSize: " + cartSize);
            $('#cartSize').text(cartSize);
            // $('#totalPrice').empty();
            // $('#totalPrice').append(response.totalPrice);
            console.log("deleteCallBack: " + response);
            // window.location.reload(true);
        }
    }
</script>


<%--for the error $(...).slider is not a function--%>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
</body>

</html>