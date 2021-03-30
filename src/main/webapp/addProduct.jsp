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
                    <h2>Add New Product</h2>
                    <ul class="breadcrumb">
                        <li class="breadcrumb-item"><a href="#">Products</a></li>
                        <li class="breadcrumb-item active">Add New Product</li>
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
                <div class="col-xl-7 col-lg-7 col-md-6">
                    <div class="single-product-details">
                        <h2 id="prodNameL" style="text-space: 50">Product Name</h2>
                        <input type="text" id="prodName" placeholder="Enter Product Name Here" style="margin-left: 40px; width: 400px;">
                        <br>
                        <br>
                        <h2 id="prodPriceL" style="text-space: 50">Product Price</h2>
                        <input type="text" id="prodPrice" placeholder="Enter Product Price Here" style="margin-left: 42px;width: 300px;">
                        <br>
                        <br>
                        <h2 id="prodQuanL">Quantity</h2>
                        <input type="text" id="prodQuan" placeholder="Enter Product Quantity Here" style="margin-left: 41px; width: 300px;">
                        <br>
                        <br>
                        <h2>Description</h2>
                        <p contentEditable="true" id="prodDesc" style="border-style: solid; border-radius: 3px; border-color: #777620"></p>
                        <br>
						<div class="price-box-bar">
							<div class="cart-and-bay-btn">
                                <div>
                                    <input type="file" class="btn hvr-hover" data-fancybox-close="">
                                    <br>
                                    <br>
                                </div>
                                <br>
                                <a class="btn hvr-hover" data-fancybox-close="" onclick="addProduct()">Add</a>
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

    <%--for the error $(...).slider is not a function--%>
    <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
</body>

</html>