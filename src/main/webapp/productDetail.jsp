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
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"--%>
<%--          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"--%>
<%--            integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous">--%>
<%--    </script>--%>

</head>

<body>
<jsp:include page="admin-header.jsp"/>

    <!-- Start All Title Box -->
    <div class="all-title-box">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <h2>Product Detail</h2>
                    <ul class="breadcrumb">
                        <li class="breadcrumb-item"><a href="products">Products</a></li>
                        <li class="breadcrumb-item active">Product Detail </li>
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
                            <div class="carousel-item active"> <img class="d-block w-100" src="images/big-img-01.jpg" alt="First slide"> </div>
                            <div class="carousel-item"> <img class="d-block w-100" src="images/big-img-02.jpg" alt="Second slide"> </div>
                            <div class="carousel-item"> <img class="d-block w-100" src="images/big-img-03.jpg" alt="Third slide"> </div>
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
                                <img class="d-block w-100 img-fluid" src="images/smp-img-01.jpg" alt="" />
                            </li>
                            <li data-target="#carousel-example-1" data-slide-to="1">
                                <img class="d-block w-100 img-fluid" src="images/smp-img-02.jpg" alt="" />
                            </li>
                            <li data-target="#carousel-example-1" data-slide-to="2">
                                <img class="d-block w-100 img-fluid" src="images/smp-img-03.jpg" alt="" />
                            </li>
                        </ol>
                    </div>
                </div>
                <div class="col-xl-7 col-lg-7 col-md-6">
                    <div class="single-product-details">
                        <c:choose>
                            <c:when test="${not empty requestScope.productObj}">
                                <label style="display:none;" id="prodId">${requestScope.productObj.id}</label>
                                <h2 contentEditable="true" id="prodName">${requestScope.productObj.productName}</h2>
                                <label id="prodPriceL" style="text-space: 50">Price</label>
                                <input type="text" value="${requestScope.productObj.price}" id="prodPrice" style="margin-left: 40px;" onblur="priceValidator()">
                                <span id="negPrice" style="display: none; font-size: larger; color: red">Please Enter a Correct Price Number</span>
                                <br>
                                <br>
                                <label id="prodQuanL">Quantity</label>
                                <input type="text" value="${requestScope.productObj.quantity}" id="prodQuan" style="margin-left: 21px;" onblur="quantityValidator()">
                                <span id="wrongQuan" style="display: none; font-size: larger; color: red">Please Enter a Correct Quantity Number</span>
                                <br>
                                <br>
                                <br>
                                <div>
                                    <select id="statusList" style="border-color: #777620; width:200px; border-radius: 10px; ">
                                        <c:if test="${requestScope.productObj.status.equals('NEW')}">
                                            <option value="NEW" selected>NEW</option>
                                            <option value="SALE">SALE</option>
                                            <option value="SOLD_OUT">SOLD_OUT</option>
                                        </c:if>
                                        <c:if test="${requestScope.productObj.status.equals('SALE')}">
                                            <option value="NEW">NEW</option>
                                            <option value="SALE" selected>SALE</option>
                                            <option value="SOLD_OUT">SOLD_OUT</option>
                                        </c:if>
                                        <c:if test="${requestScope.productObj.status.equals('SOLD_OUT')}">
                                            <option value="NEW">NEW</option>
                                            <option value="SALE">SALE</option>
                                            <option value="SOLD_OUT" selected>SOLD_OUT</option>
                                        </c:if>
                                    </select>
                                </div>
                                <br>
                                <h4>Description:</h4>
                                <p contentEditable="true" id="prodDesc">${requestScope.productObj.productDescription}.</p>
                            </c:when>
                            <c:when test="${empty requestScope.productObj}">
                                <h2 contentEditable="true">Fachion Lorem ipsum dolor sit amet</h2>
                                <label id="newPrice" style="text-space: 50">Price</label>
                                <p class="available-stock"><span> More than 20 available / <a href="#">8 sold </a></span><p>
                                <h4>Short Description:</h4>
                                <p contentEditable="true">Nam sagittis a augue eget scelerisque. Nullam lacinia consectetur sagittis. Nam sed neque id eros fermentum dignissim quis at tortor. Nullam ultricies urna quis sem sagittis pharetra. Nam erat turpis, cursus in ipsum at,
                                    tempor imperdiet metus. In interdum id nulla tristique accumsan. Ut semper in quam nec pretium. Donec egestas finibus suscipit. Curabitur tincidunt convallis arcu. </p>
                            </c:when>
                        </c:choose>
						<div class="price-box-bar">
							<div class="cart-and-bay-btn">
								<a class="btn hvr-hover" data-fancybox-close="" onclick="updateProduct()">Update</a>
                                <br>
                                <br>
								<a class="btn hvr-hover" data-fancybox-close="" onclick="deleteProduct()">Delete</a>
                                <br>
                                <div>
                                    <br>
                                    <input type="file" class="btn hvr-hover" data-fancybox-close="">
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
    <script src="customValidations/productCruds.js"></script>
    <script src="customValidations/productValidations.js"></script>

    <%--for the error $(...).slider is not a function--%>
    <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
</body>

</html>