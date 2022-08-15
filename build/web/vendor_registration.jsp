<%-- 
    Document   : home
    Created on : Jun 15, 2022, 10:07:33 PM
    Author     : Umesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
        <title>Bookstack: Home</title>
        <!-- Section: Design Block -->
    </head>
    <body>

        <!--navigation section-->
        <jsp:include page="navigation-bar.jsp"/>
        <!--navigation section ends-->

        <section class="background-radial-gradient overflow-hidden">
            <style>
                .background-radial-gradient {
                    background-color: hsl(218, 41%, 15%);
                    background-image: radial-gradient(650px circle at 0% 0%,
                        hsl(218, 41%, 35%) 15%,
                        hsl(218, 41%, 30%) 35%,
                        hsl(218, 41%, 20%) 75%,
                        hsl(218, 41%, 19%) 80%,
                        transparent 100%),
                        radial-gradient(1250px circle at 100% 100%,
                        hsl(218, 41%, 45%) 15%,
                        hsl(218, 41%, 30%) 35%,
                        hsl(218, 41%, 20%) 75%,
                        hsl(218, 41%, 19%) 80%,
                        transparent 100%);
                }

                #radius-shape-1 {
                    height: 220px;
                    width: 220px;
                    top: -60px;
                    left: -130px;
                    background: radial-gradient(#44006b, #ad1fff);
                    overflow: hidden;
                }

                #radius-shape-2 {
                    border-radius: 38% 62% 63% 37% / 70% 33% 67% 30%;
                    bottom: -60px;
                    right: -110px;
                    width: 300px;
                    height: 300px;
                    background: radial-gradient(#44006b, #ad1fff);
                    overflow: hidden;
                }

                .bg-glass {
                    background-color: hsla(0, 0%, 100%, 0.9) !important;
                    backdrop-filter: saturate(200%) blur(25px);
                }
            </style>


            <div class="container px-4 py-5 px-md-5 text-center text-lg-start my-5">
                <div class="row gx-lg-5 align-items-center mb-5">
                    <div class="col-lg-6 mb-5 mb-lg-0" style="z-index: 10">
                        <h1 class="my-5 display-5 fw-bold ls-tight" style="color: hsl(218, 81%, 95%)">
                            The best offer <br />
                            <span style="color: hsl(218, 81%, 75%)">for your business</span>
                        </h1>
                        <p class="mb-4 opacity-70" style="color: hsl(218, 81%, 85%)">
                            Lorem ipsum dolor, sit amet consectetur adipisicing elit.
                            Temporibus, expedita iusto veniam atque, magni tempora mollitia
                            dolorum consequatur nulla, neque debitis eos reprehenderit quasi
                            ab ipsum nisi dolorem modi. Quos?
                        </p>
                    </div>

                    <div class="col-lg-6 mb-5 mb-lg-0 position-relative">
                        <div id="radius-shape-1" class="position-absolute rounded-circle shadow-5-strong"></div>
                        <div id="radius-shape-2" class="position-absolute shadow-5-strong"></div>

                        <div class="card bg-glass">
                            <div class="card-body px-4 py-5 px-md-5">
                                <form method="POST" action="vendor_registration" enctype='multipart/form-data'>
                                    <!-- 2 column grid layout with text inputs for the first and last names -->
                                    <div class="form-outline mb-4">
                                        <input name="store_name" type="pphone" id="form3Example33" class="form-control" value="${store_name}"/>
                                        <label class="form-label" for="form3Example33">Store name</label>
                                    </div>

                                    <!-- phone input -->
                                    <div class="form-outline mb-4">
                                        <input name="phone_number" type="phone" id="form3Example3" class="form-control" maxlength="10" value="${phone_number}"/>
                                        <label class="form-label" for="form3Example3">Phone</label>
                                    </div>

                                    <!-- Email input -->
                                    <div class="form-outline mb-4">
                                        <input name="email" type="email" id="form3Example3" class="form-control" value="${email}"/>
                                        <label class="form-label" for="form3Example3">Email address</label>
                                    </div>

                                    <!-- Password input -->                                                                   
                                    <div class="row">
                                        <div class="col-md-6 mb-4">
                                            <div class="form-outline">
                                                <input name="password1" type="password" id="form3Example10" class="form-control" />
                                                <label class="form-label" for="form3Example10">Password</label>
                                            </div>
                                        </div>
                                        <div class="col-md-6 mb-4">
                                            <div class="form-outline">
                                                <input name="password2" type="password" id="form3Example20" class="form-control" />
                                                <label class="form-label" for="form3Example20">Confirm password</label>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-outline mb-4">
                                        <input name="profile_pic" class="form-control" type="file" id="formFile">
                                        <label for="formFile" class="form-label">Upload an image/logo for public profile</label>
                                    </div>

                                    <c:if test="${not empty vendorRegistrationError}">
                                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                                            <strong>Error! </strong> ${vendorRegistrationError}
                                            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                                        </div>
                                    </c:if>

                                    <!-- Checkbox -->
                                    <div class="form-check d-flex justify-content-center mb-4">
                                        <input class="form-check-input me-2" type="checkbox" value="" id="form2Example33" required/>
                                        <label class="form-check-label" for="form2Example33">
                                            I herby accept all the terms and conditions presented by Bookstack
                                        </label>
                                    </div>

                                    <!-- Submit button -->
                                    <button type="submit" class="btn btn-primary btn-block mb-4" style="width: 100%;">
                                        Sign up
                                    </button>
                                    <!-- Register buttons --> 

                                    <div class="flex items-center justify-between pb-6">
                                        <span class="mb-0 mr-2">Already have vendor account?? </span>
                                        <!--<button type="button" class="inline-block px-6 py-2 border-2 border-purple-600 text-purple-600 font-medium text-xs leading-tight uppercase rounded hover:bg-black hover:bg-opacity-5 focus:outline-none focus:ring-0 transition duration-150 ease-in-out"
                                            data-mdb-ripple="true"
                                            data-mdb-ripple-color="light">
                                            Register
                                        </button> -->
                                        <a href ="login" type="button" class="btn btn-outline-primary float-right"
                                           data-mdb-ripple="true"
                                           data-mdb-ripple-color="light">
                                            Sign in
                                        </a>

                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Section: Design Block -->
    </body>
</html>
