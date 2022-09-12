<%-- 
    Document   : book-detail
    Created on : Aug 16, 2022, 9:39:03 PM
    Author     : Umesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="allscripts.jsp"/>
        <title>Book detail</title>         
    </head>
    <body>

        <!--navigation section-->
        <jsp:include page="navigation-bar.jsp"/>
        <!--navigation section ends-->

        <div class="bg-white">
            <div class="pt-6">
                <nav aria-label="Breadcrumb">
                    <ol role="list" class="max-w-2xl mx-auto px-4 flex items-center space-x-2 sm:px-6 lg:max-w-7xl lg:px-8">
                        <li>
                            <div class="flex items-center">
                                <a href="home" class="mr-2 text-sm font-medium text-gray-900"> home </a>
                                <svg width="16" height="20" viewBox="0 0 16 20" fill="currentColor" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" class="w-4 h-5 text-gray-300">
                                <path d="M5.697 4.34L8.98 16.532h1.327L7.025 4.341H5.697z" />
                                </svg>
                            </div>
                        </li>

                        <li>
                            <div class="flex items-center">
                                <a href="books" class="mr-2 text-sm font-medium text-gray-900"> Books </a>
                                <svg width="16" height="20" viewBox="0 0 16 20" fill="currentColor" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" class="w-4 h-5 text-gray-300">
                                <path d="M5.697 4.34L8.98 16.532h1.327L7.025 4.341H5.697z" />
                                </svg>
                            </div>
                        </li>

                        <li class="text-sm">
                            <a href="#" aria-current="page" class="font-medium text-gray-500 hover:text-gray-600"> <c:out value='${book.name}'/> </a>
                        </li>
                    </ol>
                </nav>

                <!-- Image gallery -->                
                <div class="mt-6 max-w-2xl mx-auto px-4 lg:max-w-7xl lg:px-8 lg:grid lg:grid-cols-3 lg:gap-x-8">
                    <div class="flex h-96 w-auto sm:overflow-hidden lg:border-r lg:border-gray-200 mr-6">
                        <img src="images/book_cover_photos/<c:out value="${book.vendor_id}"/>/<c:out value='${book.cover_photo_name}'/>" alt="<c:out value='${book.name}'/>" class="w-auto h-full object-center object-cover rounded-lg">
                    </div>

                    <!-- Options -->
                    <div class="mt-4 lg:mt-0 lg:row-span-1 sm:ml-2 sm:mr-2 lg:border-r lg:border-gray-200 lg:pr-10">
                        <p class="tracking-tight text-3xl"><c:out value='${book.name}'/></p>
                        <h2 class="sr-only">Product information</h2>
                        <p class="tracking-tight text-xl text-gray-900 mt-2">By <a href="home?action=author&name=${book.author}" class="font-bold-medium text-purple-800"> ${book.author} </a></p>

                        <!-- Reviews -->
                        <div class="mt-6">
                            <h3 class="sr-only">Reviews</h3>
                            <div class="flex items-center">
                                <div class="flex items-center">
                                    <!--
                                      Heroicon name: solid/star
                      
                                      Active: "text-gray-900", Default: "text-gray-200"
                                    -->
                                    <svg class="text-gray-900 h-5 w-5 flex-shrink-0" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                                    <path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z" />
                                    </svg>

                                    <!-- Heroicon name: solid/star -->
                                    <svg class="text-gray-900 h-5 w-5 flex-shrink-0" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                                    <path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z" />
                                    </svg>

                                    <!-- Heroicon name: solid/star -->
                                    <svg class="text-gray-900 h-5 w-5 flex-shrink-0" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                                    <path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z" />
                                    </svg>

                                    <!-- Heroicon name: solid/star -->
                                    <svg class="text-gray-900 h-5 w-5 flex-shrink-0" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                                    <path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z" />
                                    </svg>

                                    <!-- Heroicon name: solid/star -->
                                    <svg class="text-gray-200 h-5 w-5 flex-shrink-0" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                                    <path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z" />
                                    </svg>
                                </div>
                                <p class="sr-only">4 out of 5 stars</p>
                                <a href="#" class="ml-3 text-sm font-medium text-indigo-600 hover:text-indigo-500">117 reviews</a>
                            </div>
                        </div>

                        <div class="mt-4">
                            <c:if test="${book.discounted_price != ''}">
                                <span class="tracking-tight text-xl text-gray-900 mt-2">NPR. <c:out value='${book.discounted_price}'/></span>
                                <span class="tracking-tight text-xl text-gray-900 mt-2 text-xs line-through font-semibold">NPR. <c:out value='${book.price}'/></span>
                            </c:if>
                            <c:if test="${book.discounted_price == ''}">
                                <p class="tracking-tight text-xl text-gray-900 mt-2">NPR. <c:out value='${book.price}'/></p>
                            </c:if>
                        </div> 


                        <div class="mt-5">
                            <!-- Colors -->
                            <div>
                                <h3 class="text-md text-gray-900 font-medium mt-2">ISBN:  <c:out value='${book.isbn}'/> </h3>
                                <h3 class="text-md text-gray-900 font-medium">Category: <a href="<c:out value='home?action=category&id=${book.category}'/>" class="font-bold-medium text-purple-800"> <c:out value='${book.category_name}'/> </a> </h3>
                            </div>

                            <div class="mt-5">
                                <h3 class="text-md text-gray-900 font-medium">Seller:  <a href="<c:out value='home?action=vendor&id=${book.vendor_id}'/>" class="font-bold-medium text-purple-800"> <c:out value='${book.vendor}'/> </a> </h3>
                            </div>

                            <!-- Sizes -->
                            <div class="mt-5">
                                <div class="flex items-center">
                                    <h3 class="text-sm text-gray-900 font-medium">Status: <span class="text-green-500 text-base"> In stock </span></h3>
                                </div>                                    
                            </div>

                            <form name="addToCartForm" method="POST" action="cart">
                                <input type="hidden" name="book_id" value="<c:out value='${book.id}'/>">
                                <input type="hidden" name="action" value="add-to-cart">
                                <button type="submit" class="mt-5 w-full bg-purple-600 border border-transparent rounded-md py-3 px-8 flex items-center justify-center text-base font-medium text-white hover:bg-purple-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-purple-500">
                                    Add to cart
                                </button>
                            </form>

                        </div>
                    </div>

                    <div class="mt-10 lg:mt-0">
                        <h3 class="text-lg font-medium text-gray-900">Highlights</h3>
                        <div class="mt-4">
                            <ul role="list" class="pl-4 list-disc text-sm space-y-2 text-base">
                                <li class="text-gray-400"><span class="text-gray-600"> Book name: <c:out value='${book.name}'/> </span></li>

                                <li class="text-gray-400"><span class="text-gray-600"> Author: <a href="home?action=author&name=${book.author}" class="font-bold-medium text-purple-800"><c:out value='${book.author}'/></a> </span></li>

                                <li class="text-gray-400"><span class="text-gray-600"> ISBN: <c:out value='${book.isbn}'/> </span></li>

                                <li class="text-gray-400"><span class="text-gray-600"> Category: <a href="<c:out value='home?action=category&id=${book.category}'/>" class="font-bold-medium text-purple-800"><c:out value='${book.category_name}'/></a> </span></li>

                                <li class="text-gray-400"><span class="text-gray-600"> Published year: <c:out value='${book.published_year}'/> </span></li>

                                <li class="text-gray-400"><span class="text-gray-600"> Language: <a href="home?action=language&id=${book.language}" class="font-bold-medium text-purple-800"><c:out value='${book.language_name}'/></a> </span></li>

                                <li class="text-gray-400"><span class="text-gray-600"> Cover type: <a href="home?action=coverType&id=${book.cover_type}" class="font-bold-medium text-purple-800"><c:out value='${book.cover}'/></a> </span></li>

                                <li class="text-gray-400"><span class="text-gray-600"> Book type: <a href="home?action=bookType&id=${book.type}" class="font-bold-medium text-purple-800"><c:out value='${book.book_type}'/></a> </span></li>

                                <li class="text-gray-400"><span class="text-gray-600"> Seller: <a href="<c:out value='home?action=vendor&id=${book.vendor_id}'/>" class="font-bold-medium text-purple-800"><c:out value='${book.vendor}'/></a> </span></li>                                        

                            </ul>
                        </div>
                    </div>

                </div>                

                <!-- Product info -->
                <div class="max-w-2xl mx-auto pt-10 px-4 sm:px-6 lg:max-w-7xl lg:pt-16 lg:grid lg:grid-cols-3 lg:grid-rows-[auto,auto,1fr] lg:gap-x-8">
                    <div class="lg:col-span-2 lg:pr-8">
                        <h1 class="text-2xl font-bold tracking-tight text-gray-900 sm:tracking-tight sm:text-3xl">Synopsis</h1>
                    </div>  

                    <!--add to cart portion here-->

                    <div class="py-10 lg:pt-6 lg:pb-16 lg:col-start-1 lg:col-span-2 lg:pr-8">
                        <!-- Description and details -->
                        <div>
                            <h3 class="sr-only">Synopsis</h3>

                            <div class="space-y-6">
                                <p class="text-base text-gray-900 text-justify"> <c:out value='${book.description}'/> </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <div class="flex p-2 justify-around w-full">
                <!--product list section-->
                <div class="max-w-2xl mx-4 py-2 px-2 lg:max-w-7xl lg:px-8">
                    <h3 class="text-2xl font-bold tracking-tight text-gray-900">Similar books</h3>

                    <div class="mt-6 grid grid-cols-1 gap-y-10 gap-x-6 sm:grid-cols-2 lg:grid-cols-5 xl:gap-x-8 w-full">
                        <c:forEach var="book" items="${SameCategoryBook}">
                            <div class="group relative hover:scale-105 ease-in duration-200">
                                <a href="<c:out value='home?action=book-detail&id=${book.id}'/>">
                                    <div class="flex w-full min-h-40 bg-gray-200 rounded-md overflow-hidden lg:h-80 lg:aspect-none justify-center">
                                        <img src="images/book_cover_photos/${book.vendor_id}/<c:out value="${book.cover_photo_name}"/>" alt="<c:out value="${book.name}"/>" title="<c:out value='${book.name}'/>" class="w-auto h-full object-center object-cover lg:w-full lg:h-full rounded">
                                    </div>
                                </a>
                                <div class="mt-4 flex justify-between">
                                    <div class="overflow-hidden w-2/3">
                                        <h3 class="text-sm text-gray-700">
                                            <a href="<c:out value='home?action=book-detail&id=${book.id}'/>" class="line-clamp" title="<c:out value='${book.name}'/>" >
                                                <span aria-hidden="true" class="absolute line-clamp-1" ></span>
                                                <c:out value="${book.name}"/>
                                            </a>
                                        </h3>
                                        <p class="mt-1 text-sm text-gray-500"><c:out value="${book.category_name}" /></p>                                                    

                                    </div>
                                    <c:if test="${book.discounted_price != ''}">
                                        <div class="overflow-hidden  w-1/3 items-end">
                                            <p class="text-lbaseg font-medium text-gray-900">NPR. <c:out value="${book.discounted_price}" /></p>
                                            <p class="text-xs font-medium text-gray-900 line-through">NPR. <c:out value="${book.price}" /></p>
                                        </div>
                                    </c:if>
                                    <c:if test="${book.discounted_price == ''}">
                                        <div class="overflow-hidden  w-1/3 items-end">
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
            </div>


            <div class="flex p-2 justify-around w-full">
                <!--product list section-->
                <div class="max-w-2xl mx-4 py-2 px-2 lg:max-w-7xl lg:px-8">
                    <h3 class="text-2xl font-bold tracking-tight text-gray-900">More from same author</h3>

                    <div class="mt-6 grid grid-cols-1 gap-y-10 gap-x-6 sm:grid-cols-2 lg:grid-cols-5 xl:gap-x-8 w-full">
                        <c:forEach var="book" items="${SameAuthorBook}">
                            <div class="group relative hover:scale-105 ease-in duration-200">
                                <a href="<c:out value='home?action=book-detail&id=${book.id}'/>">
                                    <div class="flex w-full min-h-40 bg-gray-200 rounded-md overflow-hidden lg:h-80 lg:aspect-none justify-center">
                                        <img src="images/book_cover_photos/${book.vendor_id}/<c:out value="${book.cover_photo_name}"/>" alt="<c:out value="${book.name}"/>" title="<c:out value='${book.name}'/>" class="w-auto h-full object-center object-cover lg:w-full lg:h-full rounded">
                                    </div>
                                </a>
                                <div class="mt-4 flex justify-between">
                                    <div class="overflow-hidden w-2/3">
                                        <h3 class="text-sm text-gray-700">
                                            <a href="<c:out value='home?action=book-detail&id=${book.id}'/>" class="line-clamp" title="<c:out value='${book.name}'/>" >
                                                <span aria-hidden="true" class="absolute line-clamp-1" ></span>
                                                <c:out value="${book.name}"/>
                                            </a>
                                        </h3>
                                        <p class="mt-1 text-sm text-gray-500"><c:out value="${book.category_name}" /></p>                                                    

                                    </div>
                                    <c:if test="${book.discounted_price != ''}">
                                        <div class="overflow-hidden  w-1/3 items-end">
                                            <p class="text-lbaseg font-medium text-gray-900">NPR. <c:out value="${book.discounted_price}" /></p>
                                            <p class="text-xs font-medium text-gray-900 line-through">NPR. <c:out value="${book.price}" /></p>
                                        </div>
                                    </c:if>
                                    <c:if test="${book.discounted_price == ''}">
                                        <div class="overflow-hidden  w-1/3 items-end">
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
            </div>


        </div>
    </body>

    <!--footer section-->
    <jsp:include page="footer.html"/>
    <!--footer section ends-->

</html>
