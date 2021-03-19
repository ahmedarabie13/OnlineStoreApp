<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- Mobile Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Site Metas -->
    <title>Registration</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="">

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
    <script src="customValidations/registerValidations.js"></script>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>


<body>
<jsp:include page="header.jsp"/>

<%--<div style="margin-left: auto; margin-right: auto; margin-top: 60px; margin-bottom: 200px;" class="col-sm-8">--%>
<%--    <form class="mt-3  review-form-box" id="formLogin">--%>
<%--        <div class="form-row col-sm-6">--%>
<%--            <div class="form-group col-md-6">--%>
<%--                <label for="InputEmail" class="mb-0">Email Address</label>--%>
<%--                <input type="email" class="form-control" id="InputEmail" placeholder="Enter Email">--%>
<%--            </div>--%>
<%--            <br>--%>
<%--            <div class="form-group col-md-6">--%>
<%--                <label for="InputPassword" class="mb-0">Password</label>--%>
<%--                <input type="password" class="form-control" id="InputPassword" placeholder="Password">--%>
<%--            </div>--%>
<%--            <br>--%>
<%--        </div>--%>
<%--        <button type="submit" class="btn hvr-hover">Login</button>--%>
<%--    </form>--%>
<%--</div>--%>
<jsp:include page="forms/registrationForm.jsp"/>

<jsp:include page="footer.jsp"/>

<script src="forms/js/jquery.min.js"></script>
<script src="forms/js/popper.js"></script>
<script src="forms/js/bootstrap.min.js"></script>
<%--<script src="login/js/main.js"></script>--%>
<script src="forms/js/main.js"></script>
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
