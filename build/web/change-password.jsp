<%-- 
    Document   : change-password
    Created on : Sep 17, 2022, 11:16:42 PM
    Author     : Umesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="allscripts.jsp"/>
        <title>Change Password</title>
    </head>
    <body>

        <!--navigation section-->
        <jsp:include page="navigation-bar.jsp"/>
        <!--navigation section ends--> 

        <!-- Container -->
        <div class="container mx-auto">
            <div class="flex justify-center px-6 my-12">
                <!-- Row -->
                <div class="w-full xl:w-3/4 lg:w-11/12 flex">
                    <!-- Col -->
                    <div class="w-full h-auto hidden lg:block lg:w-1/2 bg-cover rounded-lg"
                         style="background-size:contain; background-repeat: no-repeat; background-image: url('https://img.freepik.com/free-vector/personal-data-protection-concept-with-3d-computer-shielf-with-fingerprint-human-character-isometric_1284-63719.jpg?w=740&t=st=1663511922~exp=1663512522~hmac=521a40db6ceedb15fbd5ac849696e00dd9f3c09fba6c6e5f12dfb5f73a8a307b')">
                    </div>
                    <!-- Col -->
                    <div class="w-full lg:w-1/2 bg-white p-5 rounded-lg border shadow-lg">
                        <div class="px-8 mb-4 text-center">
                            <h3 class="pt-4 mb-2 text-2xl">Forgot Your Password?</h3>
                            <p class="mb-4 text-sm text-gray-700">
                                We get it, stuff happens. Just enter your old password and the new password you want
                                and you will be good to go.
                            </p>
                            <p class="mb-4 text-sm text-red-700 font-medium">
                                (Please choose STRONG password as possible for security)
                            </p>
                        </div>
                        <form action="changePassword" method="post" class="px-8 pt-6 bg-white rounded">
                            <div class="mb-4">
                                <label class="block mb-2 text-sm font-bold text-gray-500" for="email">
                                    Old password
                                </label>
                                <input class="w-full mb-6 px-3 py-2 text-sm leading-tight text-gray-700 border rounded shadow appearance-none focus:outline-none focus:shadow-outline"
                                       name="old_password" id="password" type="password" placeholder="Enter your old password"/>
                                <label class="block mb-2 text-sm font-bold text-gray-500" for="email">
                                    New password
                                </label>
                                <input class="w-full mb-6 px-3 py-2 text-sm leading-tight text-gray-700 border rounded shadow appearance-none focus:outline-none focus:shadow-outline"
                                       name="new_password" id="password1" type="password" placeholder="Enter your new password"/>
                                <label class="block mb-2 text-sm font-bold text-gray-500" for="email">
                                    Confirm new password
                                </label>
                                <input class="w-full px-3 py-2 text-sm leading-tight text-gray-700 border rounded shadow appearance-none focus:outline-none focus:shadow-outline"
                                       name="confirm_password" id="password2" type="password" placeholder="Confirm your new password"/>
                            </div>

                            <c:if test="${not empty message}">
                                <div class="flex p-4 mb-4 text-sm text-red-700 bg-red-100 rounded-lg dark:bg-red-200 dark:text-red-800" role="alert">
                                    <svg aria-hidden="true" class="flex-shrink-0 inline w-7 h-7 mr-3" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M18 10a8 8 0 11-16 0 8 8 0 0116 0zm-7-4a1 1 0 11-2 0 1 1 0 012 0zM9 9a1 1 0 000 2v3a1 1 0 001 1h1a1 1 0 100-2v-3a1 1 0 00-1-1H9z" clip-rule="evenodd"></path></svg>
                                    <span class="sr-only">Info</span>
                                    <div>
                                        <span class="font-medium">${message}</span>
                                    </div>
                                </div>
                            </c:if>

                            <div class="mb-6 mt-6 text-center">
                                <button class="w-full px-4 py-2 font-bold text-white bg-purple-600 rounded-lg hover:bg-purple-700 focus:outline-none focus:shadow-outline" type="submit" >
                                    Reset Password
                                </button>
                            </div>
                        </form>
                        <hr class="mb-6 border-t" />
                        <div class="text-center">
                            <a class="inline-block text-sm text-blue-500 align-baseline hover:text-blue-800" href="signup">
                                Create an Account!
                            </a>
                        </div>
                        <div class="text-center">
                            <a class="inline-block text-sm text-blue-500 align-baseline hover:text-blue-800" href="login">
                                Already have an account? Login!
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!--footer section-->
        <jsp:include page="footer.html"/>
        <!--footer section ends-->

    </body>
</html>
