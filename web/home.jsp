<%-- 
    Document   : index
    Created on : Jun 22, 2022, 6:42:26 PM
    Author     : Umesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset=UTF-8">
        <jsp:include page="allscripts.jsp"/>
        <title>Bookstack: Home</title>
        <!--<link rel = "icon" href="favicon.ico" type = "image/x-icon">-->
    </head>
    <body>

        <!--navigation section-->
        <jsp:include page="navigation-bar.jsp"/>
        <!--navigation section ends--> 

        <jsp:include page="display-message.jsp"/>



        <!--carousal section-->
        <!--        <div id="carouselExampleIndicators" class="carousel slide relative mr-6 ml-6 rounded" data-bs-ride="carousel">
                    <div class="carousel-indicators absolute right-0 bottom-0 left-0 flex justify-center p-0 mb-4">
                        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0"
                                class="active" aria-current="true" aria-label="Slide 1"></button>
                        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
                                aria-label="Slide 2"></button>
                        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"
                                aria-label="Slide 3"></button>
                    </div>
                    <div class="carousel-inner relative w-full rounded">
                        <div class="carousel-item active bg-black rounded">
                            <div class="flex relative text-center rounded">
                                <h1 class="text-3xl tracking-wider text-white text-sha uppercase font-bold p-4 self-center z-10 content-center absolute text-center w-full md:text-4xl">Welcome to Lightning deals</h1>
                                <img class="w-full object-cover h-80 block mx-auto  sm:block sm:w-full rounded" 
                                     src="https://dealsoftheday.net/wp-content/uploads/2021/09/0001-8193923584_20210919_175608_0000-1.png"
                                     alt="Banner" width="1920" height="288" />
                            </div>
                        </div>
                        <div class="carousel-item bg-black rounded">
                            <div class="flex relative text-center rounded">
                                <h1 class="text-3xl tracking-wider text-white text-sha uppercase font-bold p-4 self-center z-10 content-center absolute text-center w-full md:text-4xl">Your only book hub</h1>
                                <img class="w-full object-cover h-80 block mx-auto  sm:block sm:w-full rounded" 
                                     src="https://cdn.pixabay.com/photo/2020/04/26/01/34/books-5093228_960_720.png"
                                     alt="Banner" width="1920" height="288" />
                            </div>
                        </div>
                        <div class="carousel-item bg-black rounded">
                            <div class="flex relative text-center rounded">
                                <h1 class="text-3xl tracking-wider text-white text-sha uppercase font-bold p-4 self-center z-10 content-center absolute text-center w-full md:text-4xl">Unbelievable discount on bundles</h1>
                                <img class="w-full object-cover h-80 block mx-auto  sm:block sm:w-full rounded" 
                                     src="https://waukeepubliclibrary.org/sites/default/files/BookBundles.png"
                                     alt="Banner" width="1920" height="288" />
                            </div>
                        </div>
                    </div>
                    <button
                        class="carousel-control-prev absolute top-0 bottom-0 flex items-center justify-center p-0 text-center border-0 hover:outline-none hover:no-underline focus:outline-none focus:no-underline left-0"
                        type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
                        <span class="carousel-control-prev-icon inline-block bg-no-repeat" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </button>
                    <button
                        class="carousel-control-next absolute top-0 bottom-0 flex items-center justify-center p-0 text-center border-0 hover:outline-none hover:no-underline focus:outline-none focus:no-underline right-0"
                        type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
                        <span class="carousel-control-next-icon inline-block bg-no-repeat" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                    </button>
                </div>-->


        <div id="default-carousel" class="relative mr-6 ml-6" data-carousel="slide">
            <!-- Carousel wrapper -->
            <div class="relative h-56 overflow-hidden rounded-lg md:h-96 bg-gray-900">
                <!-- Item 1 -->
                <div class="flex text-center duration-700 ease-in-out absolute inset-0 transition-all transform translate-x-0 z-10" data-carousel-item="">
                    <img src="https://dealsoftheday.net/wp-content/uploads/2021/09/0001-8193923584_20210919_175608_0000-1.png" class="w-full h-auto absolute block w-full -translate-x-1/2 -translate-y-1/2 top-1/2 left-1/2" alt="...">
                    <h1 class="mb-7 text-3xl tracking-wider text-white text-sha uppercase font-bold p-4 self-end z-10 content-center absolute text-center w-full md:text-4xl">Welcome to Lightning deals</h1>
                </div>
                <!-- Item 2 -->
                <div class="flex duration-700 ease-in-out absolute inset-0 transition-all transform translate-x-full z-10 content-center" data-carousel-item="">
                    <img src="https://images.unsplash.com/photo-1495446815901-a7297e633e8d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80" class="w-full h-auto absolute block w-full -translate-x-1/2 -translate-y-1/2 top-1/2 left-1/2" alt="...">
                    <h1 class="mb-7 text-3xl tracking-wider text-white text-sha uppercase font-bold p-4 self-end z-10 content-center absolute text-center w-full md:text-4xl">Your only book hub</h1>
                </div>
                <!-- Item 3 -->
                <div class="flex duration-700 ease-in-out absolute inset-0 transition-all transform -translate-x-full z-10" data-carousel-item="">
                    <img src="https://waukeepubliclibrary.org/sites/default/files/BookBundles.png" class="absolute block w-full -translate-x-1/2 -translate-y-1/2 top-1/2 left-1/2" alt="...">
                    <h1 class="mb-7 text-3xl tracking-wider text-white text-sha uppercase font-bold p-4 self-end z-10 content-center absolute text-center w-full md:text-4xl">Unbelievable discount on bundles</h1>
                </div>
            </div>
            <!-- Slider indicators -->
            <div class="absolute z-30 flex space-x-3 -translate-x-1/2 bottom-5 left-1/2">
                <button type="button" class="w-3 h-3 rounded-full bg-white dark:bg-gray-800" aria-current="true" aria-label="Slide 1" data-carousel-slide-to="0"></button>
                <button type="button" class="w-3 h-3 rounded-full bg-white/50 dark:bg-gray-800/50 hover:bg-white dark:hover:bg-gray-800" aria-current="false" aria-label="Slide 2" data-carousel-slide-to="1"></button>
                <button type="button" class="w-3 h-3 rounded-full bg-white/50 dark:bg-gray-800/50 hover:bg-white dark:hover:bg-gray-800" aria-current="false" aria-label="Slide 3" data-carousel-slide-to="2"></button>
            </div>
            <!-- Slider controls -->
            <button type="button" class="absolute top-0 left-0 z-30 flex items-center justify-center h-full px-4 cursor-pointer group focus:outline-none" data-carousel-prev="">
                <span class="inline-flex items-center justify-center w-8 h-8 rounded-full sm:w-10 sm:h-10 bg-white/30 dark:bg-gray-800/30 group-hover:bg-white/50 dark:group-hover:bg-gray-800/60">
                    <svg aria-hidden="true" class="w-5 h-5 text-white sm:w-6 sm:h-6 dark:text-gray-800" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" data-darkreader-inline-stroke="" style="--darkreader-inline-stroke:currentColor;"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15 19l-7-7 7-7"></path></svg>
                    <span class="sr-only">Previous</span>
                </span>
            </button>
            <button type="button" class="absolute top-0 right-0 z-30 flex items-center justify-center h-full px-4 cursor-pointer group focus:outline-none" data-carousel-next="">
                <span class="inline-flex items-center justify-center w-8 h-8 rounded-full sm:w-10 sm:h-10 bg-white/30 dark:bg-gray-800/30 group-hover:bg-white/50 dark:group-hover:bg-gray-800/60">
                    <svg aria-hidden="true" class="w-5 h-5 text-white sm:w-6 sm:h-6 dark:text-gray-800" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" data-darkreader-inline-stroke="" style="--darkreader-inline-stroke:currentColor;"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 5l7 7-7 7"></path></svg>
                    <span class="sr-only">Next</span>
                </span>
            </button>
        </div>

        <!--carausal section end-->


        <div class="flex">
            <div class="flex flex-col w-64 h-screen px-4 py-8 hidden md:table-cell">
                <div class="flex flex-col mt-4">
                    <!--sidebar section-->
                    <aside class="w-64 text-black" aria-label="Sidebar">
                        <div class="overflow-y-auto py-4 px-3 bg-gray-50 rounded dark:bg-gray-800">
                            <ul class="space-y-2 text-black">
                                <li>
                                    <p  class="flex items-center p-2 text-base font-normal text-gray-900 rounded-lg">
                                        <svg aria-hidden="true" class="flex-shrink-0 w-6 h-6 text-gray-500 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path d="M5 3a2 2 0 00-2 2v2a2 2 0 002 2h2a2 2 0 002-2V5a2 2 0 00-2-2H5zM5 11a2 2 0 00-2 2v2a2 2 0 002 2h2a2 2 0 002-2v-2a2 2 0 00-2-2H5zM11 5a2 2 0 012-2h2a2 2 0 012 2v2a2 2 0 01-2 2h-2a2 2 0 01-2-2V5zM11 13a2 2 0 012-2h2a2 2 0 012 2v2a2 2 0 01-2 2h-2a2 2 0 01-2-2v-2z"></path></svg>
                                        <span class="flex-1 ml-3 whitespace-nowrap">Categories</span>
                                    </p>
                                </li>
                            </ul>
                            <ul class="mt-2 pt-2 space-y-2 text-black border-t border-gray-200">
                                <c:forEach var="category" items="${categoryList}">
                                    <li>
                                        <a href="home?action=category&id=<c:out value="${category.id}"/>" class="flex items-center p-2 text-base font-normal text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700">
                                            <span class="ml-3"><c:out value="${category.category_name}"/></span>
                                        </a>
                                    </li>
                                </c:forEach>
                            </ul>
                            <ul class="pt-4 mt-4 space-y-2 border-t border-gray-200 dark:border-gray-700">
                                <li>
                                    <a href="#" class="flex items-center p-2 text-base font-normal text-gray-900 rounded-lg transition duration-75 hover:bg-gray-100 dark:hover:bg-gray-700 dark:text-white group">
                                        <svg aria-hidden="true" class="flex-shrink-0 w-6 h-6 text-gray-500 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path d="M7 3a1 1 0 000 2h6a1 1 0 100-2H7zM4 7a1 1 0 011-1h10a1 1 0 110 2H5a1 1 0 01-1-1zM2 11a2 2 0 012-2h12a2 2 0 012 2v4a2 2 0 01-2 2H4a2 2 0 01-2-2v-4z"></path></svg>
                                        <span class="ml-3">All Categories</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#" class="flex items-center p-2 text-base font-normal text-gray-900 rounded-lg transition duration-75 hover:bg-gray-100 dark:hover:bg-gray-700 dark:text-white group">
                                        <svg aria-hidden="true" class="flex-shrink-0 w-6 h-6 text-gray-500 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M18 10a8 8 0 11-16 0 8 8 0 0116 0zm-2 0c0 .993-.241 1.929-.668 2.754l-1.524-1.525a3.997 3.997 0 00.078-2.183l1.562-1.562C15.802 8.249 16 9.1 16 10zm-5.165 3.913l1.58 1.58A5.98 5.98 0 0110 16a5.976 5.976 0 01-2.516-.552l1.562-1.562a4.006 4.006 0 001.789.027zm-4.677-2.796a4.002 4.002 0 01-.041-2.08l-.08.08-1.53-1.533A5.98 5.98 0 004 10c0 .954.223 1.856.619 2.657l1.54-1.54zm1.088-6.45A5.974 5.974 0 0110 4c.954 0 1.856.223 2.657.619l-1.54 1.54a4.002 4.002 0 00-2.346.033L7.246 4.668zM12 10a2 2 0 11-4 0 2 2 0 014 0z" clip-rule="evenodd"></path></svg>
                                        <span class="ml-3">Help</span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </aside>
                    <!--sidebar section end-->
                </div>
            </div>           


            <div class="w-full h-full m-8">
                <div class="flex p-2">


                    <!--product list section-->
                    <div class="max-w-2xl mx-4 py-2 px-2 sm:px-6 lg:max-w-7xl lg:px-8">

                        <!--Search section-->
                        <form method="GET" action="search" class="flex items-center mb-4">   
                            <label for="voice-search" class="sr-only">Search</label>
                            <div class="relative w-full">
                                <div class="flex absolute inset-y-0 left-0 items-center pl-3 pointer-events-none">
                                    <svg class="w-5 h-5 text-gray-500 dark:text-gray-400" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M8 4a4 4 0 100 8 4 4 0 000-8zM2 8a6 6 0 1110.89 3.476l4.817 4.817a1 1 0 01-1.414 1.414l-4.816-4.816A6 6 0 012 8z" clip-rule="evenodd"></path></svg>
                                </div>
                                <input name="search" type="text" id="Search" onkeyup="myFunction()" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full pl-10 p-2.5  dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="Search by Title/Author/ISBN" required>
                                <button type="button" class="flex absolute inset-y-0 right-0 items-center pr-3">
                                    <svg class="w-4 h-4 text-gray-500 dark:text-gray-400 hover:text-gray-900 dark:hover:text-white" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M7 4a3 3 0 016 0v4a3 3 0 11-6 0V4zm4 10.93A7.001 7.001 0 0017 8a1 1 0 10-2 0A5 5 0 015 8a1 1 0 00-2 0 7.001 7.001 0 006 6.93V17H6a1 1 0 100 2h8a1 1 0 100-2h-3v-2.07z" clip-rule="evenodd"></path></svg>
                                </button>
                            </div>
                            <button type="submit" class="inline-flex items-center py-2.5 px-3 ml-2 text-sm font-medium text-white bg-purple-600 rounded-lg border border-purple-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800"><svg class="mr-2 -ml-1 w-5 h-5" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z"></path></svg>Search</button>
                        </form>
                        <!--search section ends-->


                        <h3 class="text-2xl font-bold tracking-tight text-gray-900">New Arrivals</h3>

                        <div class="mt-6 grid grid-cols-1 gap-y-10 gap-x-6 sm:grid-cols-2 lg:grid-cols-4 xl:gap-x-8">
                            <c:forEach var="book" items="${booklist}">
                                <div class="group relative mr-3 hover:scale-105 ease-in duration-200">
                                    <a href="<c:out value='home?action=book-detail&id=${book.id}'/>">
                                        <div class="flex w-full min-h-64 rounded-md overflow-hidden lg:h-80 lg:aspect-none justify-center">
                                            <img src="images/book_cover_photos/<c:out value="${book.vendor_id}"/>/<c:out value="${book.cover_photo_name}"/>" alt="<c:out value="${book.name}"/>" title="<c:out value='${book.name}'/>" class="w-auto h-full object-center object-cover lg:w-auto lg:h-full rounded">
                                        </div>
                                    </a>
                                    <div class="mt-4 flex justify-between">
                                        <div class="overflow-hidden inline">
                                            <h3 class="text-sm text-gray-700">
                                                <a href="<c:out value='home?action=book-detail&id=${book.id}'/>" class="line-clamp" title="<c:out value='${book.name}'/>" >
                                                    <span aria-hidden="true" class="absolute line-clamp-1" ></span>
                                                    <c:out value="${book.name}"/>
                                                </a>
                                            </h3>
                                            <a href="home?action=category&id=<c:out value="${book.category}"/>">
                                                <p class="mt-1 text-sm font-bold text-purple-600 hover:text-purple-800"><c:out value="${book.category_name}" /></p>                                                    
                                            </a>
                                        </div>
                                        <c:if test="${book.discounted_price != ''}">
                                            <div class="overflow-hidden grid inline flex-none">
                                                <p class="text-lbaseg font-medium text-gray-900">NPR. <c:out value="${book.discounted_price}" /></p>
                                                <p class="text-xs font-medium text-gray-900 line-through">NPR. <c:out value="${book.price}" /></p>
                                            </div>
                                        </c:if>
                                        <c:if test="${book.discounted_price == ''}">
                                            <div class="overflow-hidden inline flex-none">
                                                <p class="text-base font-medium text-gray-900">NPR. <c:out value="${book.price}" /></p>
                                            </div>
                                        </c:if>
                                    </div>
                                    <div class="mt-2">
                                        <form name="addToCartForm" method="POST" action="cart">
                                            <input type="hidden" name="book_id" value="<c:out value='${book.id}'/>">
                                            <input type="hidden" name="action" value="add-to-cart">
                                            <button type="submit" class="w-full inline-block px-6 py-2 border-2 border-purple-600 text-purple-600 font-medium text-xs leading-tight uppercase rounded hover:bg-purple-600 hover:text-white focus:outline-none focus:ring-0 transition duration-150 ease-in-out">
                                                Add to cart
                                            </button>
                                        </form>
                                    </div>
                                </div>
                                <!-- More products... -->

                            </c:forEach>
                        </div>


                    </div>
                    <!--product list section-->
                </div>


                <!--hero section-->
                <div class="ml-10 mr-10 mb-4 mt-6 relative overflow-hidden bg-no-repeat bg-cover rounded" style="background-position: 50%;
                     background-image: url('https://images.unsplash.com/photo-1507842217343-583bb7270b66?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1290&q=80'); height: 350px;">
                    <div class="absolute top-0 right-0 bottom-0 left-0 w-full h-full overflow-hidden bg-fixed"
                         style="background-color: rgba(0, 0, 0, 0.3)">
                        <div class="flex justify-center items-center h-full overflow-auto">
                            <div class="text-center text-white px-6 md:px-12">
                                <h1 class="text-5xl font-bold mt-0 mb-6">We have more than 100 books to choose from</h1>
                                <h3 class="text-3xl font-bold mb-8">All the books you need right at one place</h3>
                                <a href="books"> <button type="button"
                                                         class="inline-block px-6 py-2.5 border-2 border-white font-medium text-xs leading-tight uppercase rounded hover:text-gray-800 hover:bg-white  focus:outline-none focus:ring-0 transition duration-150 ease-in-out"
                                                         data-mdb-ripple="true" data-mdb-ripple-color="light">
                                        Explore
                                    </button></a>
                            </div>
                        </div>
                    </div>
                </div>
                <!--hero section ends-->




                <div class="flex p-2">
                    <!--product list section-->
                    <div class="max-w-2xl mx-4 py-2 px-2 sm:px-6 lg:max-w-7xl lg:px-8">
                        <h3 class="text-2xl font-bold tracking-tight text-gray-900">Best sellers</h3>

                        <div class="mt-6 grid grid-cols-1 gap-y-10 gap-x-6 sm:grid-cols-2 lg:grid-cols-4 xl:gap-x-8">
                            <c:forEach var="book" items="${booklist}">
                                <div class="group relative mr-3 hover:scale-105 ease-in duration-200">
                                    <a href="<c:out value='home?action=book-detail&id=${book.id}'/>">
                                        <div class="flex w-full min-h-80 rounded-md overflow-hidden lg:h-80 lg:aspect-none justify-center">
                                            <img src="images/book_cover_photos/<c:out value="${book.vendor_id}"/>/<c:out value="${book.cover_photo_name}"/>" alt="<c:out value="${book.name}"/>" title="<c:out value='${book.name}'/>" class="w-auto h-full object-center object-cover lg:h-full rounded">
                                        </div>
                                    </a>
                                    <div class="mt-4 flex justify-between">
                                        <div class="overflow-hidden inline">
                                            <h3 class="text-sm text-gray-700">
                                                <a href="<c:out value='home?action=book-detail&id=${book.id}'/>" class="line-clamp" title="<c:out value='${book.name}'/>" >
                                                    <span aria-hidden="true" class="absolute line-clamp-1" ></span>
                                                    <c:out value="${book.name}"/>
                                                </a>
                                            </h3>
                                            <a href="home?action=category&id=<c:out value="${book.category}"/>">
                                                <p class="mt-1 text-sm font-bold text-purple-600 hover:text-purple-800"><c:out value="${book.category_name}" /></p>                                                    
                                            </a>
                                        </div>
                                        <c:if test="${book.discounted_price != ''}">
                                            <div class="overflow-hidden inline flex-none">
                                                <p class="text-lbaseg font-medium text-gray-900">NPR. <c:out value="${book.discounted_price}" /></p>
                                                <p class="text-xs font-medium text-gray-900 line-through">NPR. <c:out value="${book.price}" /></p>
                                            </div>
                                        </c:if>
                                        <c:if test="${book.discounted_price == ''}">
                                            <div class="overflow-hidden inline flex-none">
                                                <p class="text-base font-medium text-gray-900">NPR. <c:out value="${book.price}" /></p>
                                            </div>
                                        </c:if>
                                    </div>
                                    <div class="mt-2">
                                        <form name="addToCartForm" method="POST" action="cart">
                                            <input type="hidden" name="book_id" value="<c:out value='${book.id}'/>">
                                            <input type="hidden" name="action" value="add-to-cart">
                                            <button type="submit" class="w-full inline-block px-6 py-2 border-2 border-purple-600 text-purple-600 font-medium text-xs leading-tight uppercase rounded hover:bg-purple-600 hover:text-white focus:outline-none focus:ring-0 transition duration-150 ease-in-out">
                                                Add to cart
                                            </button>
                                        </form>
                                    </div>
                                </div>
                                <!-- More products... -->

                            </c:forEach>
                        </div>


                    </div>
                    <!--product list section-->
                </div>


            </div>
        </div>

    </body>

    <!--footer section-->
    <jsp:include page="footer.html"/>
    <!--footer section ends-->

</html>
