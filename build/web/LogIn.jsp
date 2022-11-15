<%-- 
    Document   : index
    Created on : Jun 7, 2022, 3:34:06 PM
    Author     : Umesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="allscripts.jsp"/>
        <script src="https://apis.google.com/js/platform.js" async defer></script>
        <meta name="google-signin-client_id" content="180318505646-2lvpct5e8m50rs5htitavjr408l65lqs.apps.googleusercontent.com">
        <title>Login Page</title>
    </head>
    <body>

        <!--navigation section-->
        <jsp:include page="navigation-bar.jsp"/>
        <!--navigation section ends-->

        <jsp:include page="display-message.jsp"/>

        <section class="h-full gradient-form">
            <div class="container py-4 px-6 h-full">
                <div class="flex justify-center items-center flex-wrap h-full g-6 text-gray-800">
                    <div class="xl:w-10/12">
                        <div class="block bg-white drop-shadow-lg rounded-lg">
                            <div class="lg:flex lg:flex-wrap g-0">
                                <div class="lg:w-6/12 px-4 md:px-0">
                                    <div class="md:p-12 md:mx-6">
                                        <div class="text-center">
                                            <img
                                                class="mx-auto w-28"
                                                src="./images/static/bookstack_logos/bookstack-logo.png"
                                                alt="Bookstack"
                                                />
                                            <h4 class="text-xl font-semibold mt-1 mb-12 pb-1">We are The Bookstack Team</h4>
                                        </div>

                                        <form action="login" method="post">
                                            <p class="mb-4">Please login to your account</p>
                                            <div class="mb-3">
                                                <label for="email" class="block text-sm font-medium text-gray-500 text-base">Email</label>
                                                <input type="text" name="email"  class="mt-1 form-control block w-full px-3 py-1.5 text-base font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none"
                                                       id="exampleFormControlInput1" value="${email}"/>
                                            </div>
                                            <div class=" relative mb-3">
                                                <div class="absolute inset-y-0 right-0 top-7 flex items-center px-1">
                                                    <input class="hidden js-password-toggle" id="toggle" type="checkbox"/>
                                                    <label class="rounded px-2 py-1 text-sm text-gray-600 font-mono cursor-pointer js-password-label" for="toggle">
                                                        <i class="fa fa-eye" aria-hidden="true"></i>
                                                    </label>
                                                </div>
                                                <label for="password" class="block text-sm font-medium text-gray-500 text-base">Password</label>
                                                <input type="password" name="password"
                                                       class="js-password appearance-none form-control mt-1 block w-full px-3 py-1.5 text-base font-normal text-gray-700
                                                       bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700
                                                       focus:bg-white focus:border-blue-600 focus:outline-none"
                                                       id="password" autocomplete="off"/>
                                            </div>
                                            <input  type="hidden" name="loginType" value="normalLogin"/>

                                            <c:if test="${not empty message}">
                                                <div class="flex p-4 mb-4 text-sm text-red-700 bg-red-100 rounded-lg dark:bg-red-200 dark:text-red-800" role="alert">
                                                    <svg aria-hidden="true" class="flex-shrink-0 inline w-5 h-5 mr-3" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M18 10a8 8 0 11-16 0 8 8 0 0116 0zm-7-4a1 1 0 11-2 0 1 1 0 012 0zM9 9a1 1 0 000 2v3a1 1 0 001 1h1a1 1 0 100-2v-3a1 1 0 00-1-1H9z" clip-rule="evenodd"></path></svg>
                                                    <span class="sr-only">Info</span>
                                                    <div>
                                                        <span class="font-medium">${message}</span>
                                                    </div>
                                                </div>
                                            </c:if>

                                            <div class="text-center pt-1 mb-12 pb-1">
                                                <button class="inline-block px-6 py-2.5 text-white font-medium text-xs leading-tight uppercase rounded shadow-md hover:bg-blue-700 hover:shadow-lg focus:shadow-lg focus:outline-none focus:ring-0 active:shadow-lg transition duration-150 ease-in-out w-full mb-3"
                                                        type="submit" data-mdb-ripple="true" data-mdb-ripple-color="light"
                                                        style=" background: linear-gradient(to right, #C2DBFE, #bf66bf, #b44cb4, #950095);">
                                                    Log in
                                                </button>
                                                <a class="text-gray-500 hover:text-purple-600" href="forgotPassword">Forgot password?</a>
                                            </div>


                                            <div class="flex items-center justify-between pb-6">
                                                <p class="mb-0 mr-2">Don't have an account?</p>
                                                <a href ="signup" type="button" class="inline-block px-6 py-2 border-2 border-purple-600 text-purple-600 font-medium text-xs leading-tight uppercase rounded hover:bg-purple-600 hover:text-white focus:outline-none focus:ring-0 transition duration-150 ease-in-out"
                                                   data-mdb-ripple="true"
                                                   data-mdb-ripple-color="light">
                                                    Register
                                                </a>
                                            </div>
                                        </form>

                                    </div>
                                </div>
                                <div class="lg:w-6/12 flex items-center lg:rounded-r-lg rounded-b-lg lg:rounded-bl-none"
                                     style=" background: linear-gradient(to right, #C2DBFE, #bf66bf, #b44cb4, #950095);">
                                    <div class="text-white px-4 py-6 md:p-12 md:mx-6">
                                        <h4 class="text-xl font-semibold mb-6">We are more than just a company</h4>
                                        <p class="text-sm">
                                            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                                            tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
                                            quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
                                            consequat.
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>  

        <!--footer section-->
        <jsp:include page="footer.html"/>
        <!--footer section ends-->

    </body>

    <script>
        const passwordToggle = document.querySelector(".js-password-toggle");

        passwordToggle.addEventListener("click", function () {
            const password = document.querySelector(".js-password"),
                    passwordLabel = document.querySelector(".js-password-label");

            if (password.type === "password") {
                password.type = "text";
                passwordLabel.innerHTML = '<i class="fa fa-eye-slash" aria-hidden="true"></i>';
            } else {
                password.type = "password";
                passwordLabel.innerHTML = '<i class="fa fa-eye" aria-hidden="true"></i>';
            }

        });
    </script>

</html>











