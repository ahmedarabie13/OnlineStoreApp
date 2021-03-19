<%--<!doctype html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--    <title>Login 03</title>--%>
<%--    <meta charset="utf-8">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">--%>

<%--    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">--%>

<%--    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">--%>

<%--    <link rel="stylesheet" href="css/style.css">--%>

<%--</head>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<body>--%>
<section class="ftco-section">
    <div class="container">
        <%--        <div class="row justify-content-center">--%>
        <%--            <div class="col-md-6 text-center mb-5">--%>
        <%--                <h2 class="heading-section">Login #03</h2>--%>
        <%--            </div>--%>
        <%--        </div>--%>
        <div class="row justify-content-center">
            <div class="col-md-7 col-lg-5">
                <div class="login-wrap p-4 p-md-5">
                    <div class="d-flex">
                        <div class="w-100">
                            <h2 class="mb-4 checkbox-primary"><b>Registration</b></h2>
                        </div>
                        <%--                        <div class="w-100">--%>
                        <%--                            <p class="social-media d-flex justify-content-end">--%>
                        <%--                                <a href="#" class="social-icon d-flex align-items-center justify-content-center"><span--%>
                        <%--                                        class="fa fa-facebook"></span></a>--%>
                        <%--                                <a href="#" class="social-icon d-flex align-items-center justify-content-center"><span--%>
                        <%--                                        class="fa fa-twitter"></span></a>--%>
                        <%--                            </p>--%>
                        <%--                        </div>--%>
                    </div>
                    <form id="regForm" action="register" class="login-form" method="post" onsubmit="return checkValidations()">
                        <div class="form-group">
                            <div class="icon d-flex align-items-center justify-content-center"><span
                                    class="fa fa-user"></span></div>
                            <input type="text" name="firstName" style="padding-left: 60px;" class="form-control rounded-left" placeholder="First Name" minlength="3" maxlength="15" id="fn" onblur="fnValidator()">
                            <span id="shortFnLength" style="display: none; font-size: small; color: red">3 Characters Minimum</span>
                            <span id="longFnLength" style="display: none; font-size: small; color: red">15 Characters Maximum</span>
                        </div>
                        <div class="form-group">
                            <div class="icon d-flex align-items-center justify-content-center"><span
                                    class="fa fa-user"></span></div>
                            <input type="text" name="lastName" style="padding-left: 60px" class="form-control rounded-left" placeholder="Last Name" minlength="3" maxlength="15" id="ln" onblur="lnValidator()">
                            <span id="shortLnLength" style="display: none; font-size: small; color: red">3 Characters Maximum</span>
                            <span id="longLnLength" style="display: none; font-size: small; color: red">15 Characters Maximum</span>
                        </div>
                        <div class="form-group">
                            <div class="icon d-flex align-items-center justify-content-center"><span
                                    class="fa fa-envelope"></span></div>
                            <input type="text" name="email" style="padding-left: 60px" class="form-control rounded-left" placeholder="Email" id="email" onblur="emailValidator()">
                            <span id="invalidEmail" style="display: none; font-size: small; color: red">Invalid Email Format</span>
                            <span id="emailExist" style="display: none; font-size: small; color: red">Email Already Registered</span>
                        </div>
                        <div class="form-group">
                            <div class="icon d-flex align-items-center justify-content-center"><span
                                    class="fa fa-phone"></span></div>
                            <input type="text" name="phone" style="padding-left: 60px" class="form-control rounded-left" placeholder="Phone Number" id="phoneField" onblur="phoneValidator()">
                            <span id="invalidPhone" style="display: none; font-size: small; color: red">Must be 11 digits and being with 01</span>
                        </div>
                        <div class="form-group">
                            <div class="icon d-flex align-items-center justify-content-center"><span
                                    class="fa fa-lock"></span></div>
                            <input type="password" name="password" style="padding-left: 60px" class="form-control rounded-left" placeholder="Password" id="pass" onblur="passwordValidator()">
                            <span id="invalidPassword" style="display: none; font-size: small; color: red">Min 8 characters, at least one uppercase letter, one lowercase letter, one number and one special character(@$!%*?&)</span>
                        </div>
                        <div class="form-group">
                            <div class="icon d-flex align-items-center justify-content-center"><span
                                    class="fa fa-lock"></span></div>
                            <input type="password" name="passConf" style="padding-left: 60px" class="form-control rounded-left" placeholder="Confirm Password" id="passConf" onblur="passwordConfirmation()">
                            <span id="invalidConf" style="display: none; font-size: small; color: red">Password Doesn't Match</span>
                        </div>
                        <div class="form-group d-flex align-items-center">
<%--                            <div class="w-100">--%>
<%--                                <label class="checkbox-wrap checkbox-primary mb-0" style="font-size: 12px">Save Password--%>
<%--                                    <input type="checkbox" checked>--%>
<%--                                    <span class="checkmark"></span>--%>
<%--                                </label>--%>
<%--                            </div>--%>
                            <div class="w-100 d-flex justify-content-end">
                                <button type="submit" class="btn btn-primary rounded submit">Register</button>
                            </div>
                        </div>
                        <c:if test="${!empty requestScope.RegistrationFailed}">
                            <div class="form-group mt-4">
                                <div class="w-100 text-danger text-center">
                                    <p class="mb-1" style="font-size: large">Registration Failed Please Try Again</p>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${!empty param.val}">
                            <div class="form-group mt-4">
                                <div class="w-100 text-danger text-center">
                                    <p class="mb-1" style="font-size: large">Registration Failed Please Try Again</p>
                                </div>
                            </div>
                        </c:if>
                        <div class="form-group mt-4">
                            <div class="w-100 text-center">
                                <p class="mb-1">Already have an account? <a href="login.jsp">Sign In</a></p>
                                <%--                                <p><a href="#">Forgot Password</a></p>--%>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>

<%--<script src="js/jquery.min.js"></script>--%>
<%--<script src="js/popper.js"></script>--%>
<%--<script src="js/bootstrap.min.js"></script>--%>
<%--<script src="js/main.js"></script>--%>

<%--</body>--%>
<%--</html>--%>

