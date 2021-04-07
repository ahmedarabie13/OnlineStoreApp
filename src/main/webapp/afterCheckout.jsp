<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="Product" uri="/WEB-INF/tlds/ProductTagLib.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<!-- Basic -->

<head>
    <title>Checkout Succeeded</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- Mobile Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Site Metas -->
    <title>Home</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="">
    <style>

        .myNav-link{
            /*float: left;*/
        }
        .myNav-link ul li{
            display: inline-block;
            border-right: 1px solid #ffffff;
            padding: 0px 10px;
            line-height: 14px;
        }
        .myNav-link ul{
            line-height: 30px;
        }
        .myNav-link ul li a{
            color: #000000;
            font-weight: 700;
            text-transform: uppercase;
            font-size: 14px;
        }
        .myNav-link ul li a:hover{
            color: #b0b435;
        }
        .myNav-link ul li:last-child{
            border: none;
        }
    </style>
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
<%--    <link rel="stylesheet" href="css/custom.css">--%>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- Site CSS -->
    <link rel="stylesheet" href="css/style.css">
    <!-- Responsive CSS -->
    <link rel="stylesheet" href="css/responsive.css">
    <!-- Custom CSS -->

    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<jsp:include page="header.jsp"/>

<div class="box-add-products" align="center" style="align-self: center">
    <div class="container" align="center">
        <div class="row">
            <div class="col-2"></div>
            <div class="col-lg-8 col-md-8 col-sm-12">
                <div class="offer-box-products">

                    <p style="font-size: xx-large; color: #b0b435; align-content: center; font-style: inherit">
                        Checkout Done successfully <br>
                    <div class="myNav-link">
                        <ul>
                            <li><a href="main">BACK TO HOME</a></li>
                            <li><a href="shop">BACK TO SHOP</a></li>
                        </ul>
                    </div>
<%--                    <a href="main">BACK TO HOME</a>--%>
<%--                    <br>--%>
<%--                    &lt;%&ndash;                    <li style="display:inline;"><a href="main">BACK TO HOME</a></li>&ndash;%&gt;--%>
<%--                    <a href="shop">BACK TO SHOP</a>--%>
                    </p>
                    <br>
                    <img class="img-fluid" src="images/msgs/checkout.png" alt=""/>
                </div>
            </div>
            <div class="col-2"></div>
        </div>
    </div>
</div>

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
<%--for the error $(...).slider is not a function--%>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
</body>
</html>
