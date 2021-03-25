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
    <link rel="stylesheet" href="css/edit-profile.css">
    <!--[if lt IE 9]>

    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>

    <![endif]-->
    <script src="customValidations/registerValidations.js"></script>
    <script src="customValidations/editProfile.js"></script>
</head>

<body onload="disable()">
<jsp:include page="header.jsp"/>

<!-- Start All Title Box -->
<div class="all-title-box">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <h2>My Account</h2>
                <ul class="breadcrumb">
                    <li class="breadcrumb-item"><a href="#">Shop</a></li>
                    <li class="breadcrumb-item active">My Account</li>
                </ul>
            </div>
        </div>
    </div>
</div>
<!-- End All Title Box -->
<section class="ftco-section">
    <div class="container">
        <div class="row gutters">
            <div class="col-xl-3 col-lg-3 col-md-12 col-sm-12 col-12">
                <div class="card h-100">
                    <div class="card-body">
                        <div class="account-settings">
                            <div class="user-profile">
                                <div class="user-avatar">
                                    <img src="https://bootdey.com/img/Content/avatar/avatar7.png" alt="Maxwell Admin">
                                </div>
                                <div class="pl-sm-4 pl-2" id="img-section"><b>Profile Photo</b>
                                    <p></p>
                                    <button class="btn btn-primary"><b>Upload</b></button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-xl-9 col-lg-9 col-md-12 col-sm-12 col-12">


                <div class="card h-100">
                    <div class="card-body">
                        <div class="text-right">
                            <button onclick="enable()" type="button" class="btn btn-light" width="50%"><i
                                    class="fa fa-edit"></i> Edit
                            </button>
                        </div>
                        <form action="editProfile" method="post" id="edit-form">
                        <div class="row gutters">
                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                <h6 class="mb-2 text-primary">Personal Details</h6>

                            </div>


                                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">

                                        <div class="form-group">
                                            <label for="fn">First Name</label>
                                            <input type="text" class="form-control" name="firstName"
                                                   placeholder="Enter First name" id="fn" onblur="fnValidator()">
                                            <span id="shortFnLength"
                                                  style="display: none; font-size: small; color: red">3 Characters Minimum</span>
                                            <span id="longFnLength" style="display: none; font-size: small; color: red">15 Characters Maximum</span>
                                        </div>

                                    </div>


                                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                        <div class="form-group">
                                            <label for="ln">Last Name</label>
                                            <input type="text" class="form-control" name="lastName"
                                                   placeholder="Enter Last Name" id="ln" onblur="lnValidator()">
                                            <span id="shortLnLength"
                                                  style="display: none; font-size: small; color: red">3 Characters Minimum</span>
                                            <span id="longLnLength" style="display: none; font-size: small; color: red">15 Characters Maximum</span>
                                        </div>
                                    </div>

                                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                        <div class="form-group">
                                            <label for="email">Email</label>
                                            <input type="email" class="form-control" name="email"
                                                   placeholder="Enter email ID" id="email" onblur="emailValidator()">
                                            <span id="invalidEmail" style="display: none; font-size: small; color: red">Invalid Email Format</span>
                                            <span id="emailExist" style="display: none; font-size: small; color: red">Email Already Registered</span>
                                        </div>
                                    </div>
                                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                        <div class="form-group">
                                            <label for="phoneField">Phone</label>
                                            <input type="text" class="form-control" name="phone"
                                                   placeholder="Enter phone number" id="phoneField"
                                                   onblur="phoneValidator()">
                                            <span id="invalidPhone" style="display: none; font-size: small; color: red">Must be 11 digits and being with 01</span>
                                        </div>
                                    </div>
                                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                        <div class="form-group">
                                            <label for="job">Job</label>
                                            <input type="text" class="form-control" name="job" id="job"
                                                   placeholder="Enter Your Job">
                                        </div>
                                    </div>
                                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                        <div class="form-group">
                                            <label>Birthday</label>
                                            <input type="date" name="bod" id="dob" class="form-control">
                                        </div>
                                    </div>
                                </div>

                                    <div class="row gutters">
                                        <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                            <h6 class="mt-3 mb-2 text-primary">Address</h6>
                                        </div>
                                        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                            <div class="form-group">
                                                <label for="Street">Street</label>
                                                <input type="name" name="Street" class="form-control" id="Street"
                                                       placeholder="Enter Street">
                                            </div>
                                        </div>
                                        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                            <div class="form-group">
                                                <label for="ciTy">City</label>
                                                <input list="cities" id="ciTy" name="city" class="form-control" placeholder="Enter City"
                                                       form="edit-form">
                                                <datalist id="cities">
                                                    <option value="Alexandria">Alexandria</option>
                                                    <option value="Aswan">Aswan</option>
                                                    <option value="Cairo">Cairo</option>
                                                    <option value="Damietta">Damietta</option>
                                                    <option value="Minya">Minya</option>
                                                    <option value="Sharqia">Sharqia</option>
                                                    <option value="Luxor">Luxor</option>
                                                    <option value="Giza">Giza</option>
                                                </datalist>
                                            </div>
                                        </div>

                                        <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                            <h6 class="mt-3 mb-2 text-primary">Password</h6>
                                        </div>
                                        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                            <div class="form-group">
                                                <label for="pass">New Password</label>
                                                <input name="password" type="password" class="form-control" id="pass"
                                                       placeholder="Enter New Password" onblur="passwordValidator()">
                                                <span id="invalidPassword"
                                                      style="display: none; font-size: small; color: red">Min 8 characters, at least one uppercase letter, one lowercase letter, one number and one special character(@$!%*?&)</span>
                                            </div>
                                        </div>
                                        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                            <div class="form-group">
                                                <label for="passConf">Confirm New Password</label>
                                                <input type="password" class="form-control"
                                                       placeholder="Confirm New Password"
                                                       id="passConf" onblur="passwordConfirmation()">
                                                <span id="invalidConf"
                                                      style="display: none; font-size: small; color: red">Password Doesn't Match</span>

                                            </div>
                                        </div>
                                    </div>
                                    <div class="row gutters">
                                        <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                            <div class="text-right">

                                                <span id="updated"
                                                      style="display: none; font-size: small; color: green">Updated Successfully</span>
                                                <span id="failed" style="display: none; font-size: small; color: red">Failed To Update </span>
                                                <input type="button" class="btn btn-primary rounded submit"
                                                       value="Update"
                                                       onclick="updateProfile()">
                                            </div>

                                        </div>

                                    </div>
                                </form>


                        </div>
                    </div>

                </div>

            </div>

        </div>

    </div>


    </div>
</section>
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
</body>

</html>