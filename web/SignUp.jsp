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
        <title>User registration page</title>
    </head>
    <!--<body style="background-image: url('images/book1.jpg');">-->
    <body>

        <!--navigation section-->
        <jsp:include page="navigation-bar.jsp"/>
        <!--navigation section ends--> 

        <section class="h-full gradient-form bg-gray-200">
            <div class="container py-12 px-6 h-full">
                <div class="flex justify-center items-center flex-wrap h-full g-6 text-gray-800">
                    <div class="xl:w-10/12">
                        <div class="block bg-white shadow-lg rounded-lg">
                            <div class="lg:flex lg:flex-wrap g-0">
                                <div class="lg:w-6/12 flex items-center lg:rounded-r-none rounded-b-none lg:rounded-bl-lg lg:rounded-tl-lg"
                                     style="background: linear-gradient(to left, #C2DBFE, #bf66bf, #b44cb4, #950095);">
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
                                <div class="lg:w-6/12 px-4 md:px-0">
                                    <div class="md:p-12 md:mx-6">
                                        <div class="text-center">
                                            <img class="mx-auto w-28" src="./images/static/bookstack_logos/bookstack-logo.png" alt="Bookstack"/>
                                            <h4 class="text-xl font-semibold mt-1 mb-12 pb-1">We are The Bookstack Team</h4>
                                        </div>

                                        <form action="signup" method="post">
                                            <p class="mb-4">Please register your account</p>
                                            <div class="w-full md:w-6/12 float-left pr-1">
                                                <div class="relative w-full mb-3">
                                                    <input
                                                        type="text"
                                                        name="firstname" 
                                                        class="form-control block w-full px-3 py-1.5 text-base font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none"
                                                        id="exampleFormControlInput1"
                                                        placeholder="First name"
                                                        value="${firstname}"
                                                        />
                                                </div>
                                            </div>
                                            <div class="w-full md:w-6/12 float-right pl-1">
                                                <div class="relative w-full mb-3">
                                                    <input
                                                        type="text"
                                                        name="lastname" 
                                                        class="form-control block w-full px-3 py-1.5 text-base font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none"
                                                        id="exampleFormControlInput2"
                                                        placeholder="Last name"
                                                        value="${lastname}"
                                                        />
                                                </div>
                                            </div>

                                            <!--                                            <div class="md:w-1/2 mb-3 col-span-3 sm:col-span-3 w-auto inline-block">
                                                                                            <input
                                                                                                type="text"
                                                                                                name="firstname" 
                                                                                                class="form-control block w-full px-3 py-1.5 text-base font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none"
                                                                                                id="exampleFormControlInput1"
                                                                                                placeholder="First name"
                                                                                                value="${firstname}"
                                                                                                />
                                                                                        </div>
                                                                                        <div class="md:w-1/2 mb-3 col-span-3 sm:col-span-3 w-auto inline-block">
                                                                                            <input
                                                                                                type="text"
                                                                                                name="lastname" 
                                                                                                class="form-control block w-full px-3 py-1.5 text-base font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none"
                                                                                                id="exampleFormControlInput2"
                                                                                                placeholder="Last name"
                                                                                                value="${lastname}"
                                                                                                />
                                                                                        </div>-->
                                            <div class="mb-3">
                                                <input type="text" name="email" 
                                                       class="form-control block w-full px-3 py-1.5 text-base font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none"
                                                       id="exampleFormControlInput3" placeholder="Email" value="${email}"/>
                                            </div>                                            
                                            <div class="mb-3">
                                                <input
                                                    type="password"
                                                    name="password"
                                                    class="form-control block w-full px-3 py-1.5 text-base font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none"
                                                    id="exampleFormControlInput4"
                                                    placeholder="Password"
                                                    />
                                            </div>
                                            <div class="mb-3">
                                                <input
                                                    type="password"
                                                    name="password2"
                                                    class="form-control block w-full px-3 py-1.5 text-base font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none"
                                                    id="exampleFormControlInput5"
                                                    placeholder="Re-enter password"
                                                    />
                                            </div>

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
                                                <button
                                                    class="inline-block px-6 py-2.5 text-white font-medium text-xs leading-tight uppercase rounded shadow-md hover:bg-blue-700 hover:shadow-lg focus:shadow-lg focus:outline-none focus:ring-0 active:shadow-lg transition duration-150 ease-in-out w-full mb-3"
                                                    type="submit"
                                                    data-mdb-ripple="true"
                                                    data-mdb-ripple-color="light"
                                                    style="background: linear-gradient(to left, #C2DBFE, #bf66bf, #b44cb4, #950095);">
                                                    Register
                                                </button>
                                            </div>
                                            <div class="flex items-center justify-between pb-6">
                                                <p class="mb-0 mr-2">Already have an account?</p>
                                                <a href="login" type="button" class="inline-block px-6 py-2 border-2 border-purple-600 text-purple-600 font-medium text-xs leading-tight uppercase rounded hover:bg-purple-600 hover:text-white focus:outline-none focus:ring-0 transition duration-150 ease-in-out"
                                                   data-mdb-ripple="true"
                                                   data-mdb-ripple-color="light">
                                                    Login
                                                </a>
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

        <!--footer section-->
        <jsp:include page="footer.html"/>
        <!--footer section ends-->

    </body>
</html>
