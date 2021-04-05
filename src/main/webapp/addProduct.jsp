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

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous">
    </script>
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
<jsp:include page="admin-header.jsp"/>

    <!-- Start All Title Box -->
    <div class="all-title-box">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <h2>Add New Product</h2>
                    <ul class="breadcrumb">
                        <li class="breadcrumb-item"><a href="products">Products</a></li>
                        <li class="breadcrumb-item active">Add New Product</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!-- End All Title Box -->

    <!-- Start Shop Detail  -->
    <form action="products" enctype="multipart/form-data" method="post" id="productFormId">
        <div class="shop-detail-box-main">
            <div class="container">
                <div class="row">
                    <div class="col-xl-7 col-lg-7 col-md-6">
                        <div class="single-product-details">
                            <c:if test="${not empty requestScope.error}">
                                <span id="negPrice" style="display: none; font-size: larger; color: red">Something Went Wrong Please Try Again</span>
                            </c:if>
                            <h2 id="prodNameL" style="text-space: 50">Product Name</h2>
                            <input type="text" id="prodName" name="prodName" placeholder="Enter Product Name Here" style="margin-left: 40px; width: 400px;">
                            <br>
                            <br>
                            <h2 id="prodPriceL" style="text-space: 50">Product Price</h2>
                            <input type="text" id="prodPrice" name="prodPrice" placeholder="Enter Product Price Here" style="margin-left: 42px;width: 300px;" onblur="priceValidator()">
                            <span id="negPrice" style="display: none; font-size: medium; color: red">Negative Prices Are Usually Bad For The Business!</span>
                            <br>
                            <br>
                            <h2 id="prodQuanL">Quantity</h2>
                            <input type="text" id="prodQuan" name="prodQuan" placeholder="Enter Product Quantity Here" style="margin-left: 41px; width: 300px;" onblur="quantityValidator()">
                            <span id="wrongQuan" style="display: none; font-size: larger; color: red">Please Enter a Correct Quantity Number</span>
                            <br>
                            <br>
                            <h2>Description</h2>
<%--                            <p contentEditable="true" id="prodDesc"  style="border-style: solid; border-radius: 3px; border-color: #777620"></p>--%>
                            <div class="form-floating">
                                <textarea class="form-control" placeholder="Leave a comment here" id="prodDesc" name="desc" onblur="descValidator()"></textarea>
                                <span id="empDesc" style="display: none; font-size: large; color: red">Please Enter A Description For Your Product</span>
                            </div>
                            <br>
                            <label style="font-size: larger">You may click Control (Windows) or click Command (Mac) to select more than one.</label>
                            <br>
                            <%--                        <select id="catList" class="selectpicker show-tick form-control" data-placeholder="$ USD" multiple>--%>
                            <select id="catList" name="cats" class="form-select" multiple aria-label="multiple select example" multiple>
                                <option data-display="Select" value="0" selected disabled>Nothing</option>
                                <c:forEach items="${requestScope.categories}" var="category">
                                    <option value="${category.id}">${category.name}</option>
                                </c:forEach>
                            </select>
                            <br>
                            <br>
                            <div class="price-box-bar">
                                <div class="cart-and-bay-btn">
                                    <div>
                                        <input type="file" name="filename" class="btn hvr-hover" data-fancybox-close="" id="chosenFile">
                                        <br>
                                        <br>
                                    </div>
                                    <br>
<%--                                    <a class="btn hvr-hover" data-fancybox-close="" onclick="addProduct()">Add</a>--%>
                                    <input type="submit" onclick="return submitAddProduct()" name="Add" class="btn hvr-hover" data-fancybox-close=""/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>

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

    <script>
        function submitAddProduct(){
            debugger
             if(checkValidations() === false){
                 document.getElementById("productFormId").submit();
             } else {
                 return false;
             }
        }
    </script>
</body>

</html>