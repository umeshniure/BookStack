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
        <script src="https://cdn.tailwindcss.com"></script>
        <title>Book detail</title>    
        <script>
            // tailwind.config.js
            module.exports = {
                // ...
                theme: {
                    extend: {
                        gridTemplateRows: {
                            '[auto,auto,1fr]': 'auto auto 1fr',
                        },
                    },
                },
                plugins: [
                    // ...
                    require('@tailwindcss/aspect-ratio'),
                ],
            }
        </script>
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
                                <a href="#" class="mr-2 text-sm font-medium text-gray-900"> home </a>
                                <svg width="16" height="20" viewBox="0 0 16 20" fill="currentColor" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" class="w-4 h-5 text-gray-300">
                                <path d="M5.697 4.34L8.98 16.532h1.327L7.025 4.341H5.697z" />
                                </svg>
                            </div>
                        </li>

                        <li>
                            <div class="flex items-center">
                                <a href="#" class="mr-2 text-sm font-medium text-gray-900"> Books </a>
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
                <div class="mt-6 max-w-2xl mx-auto sm:px-6 lg:max-w-7xl lg:px-8 lg:grid lg:grid-cols-3 lg:gap-x-8">
                    <div class="aspect-w-4 aspect-h-5 sm:rounded-lg sm:overflow-hidden lg:aspect-w-3 lg:aspect-h-4 lg:border-r lg:border-gray-200 lg:pr-8 lg:block">
                        <img src="images/book_cover_photos/<c:out value='${book.cover_photo_name}'/>" alt="<c:out value='${book.name}'/>" class="w-full h-full object-center object-cover">
                    </div>
                    <!-- <div class="hidden aspect-w-3 aspect-h-4 rounded-lg overflow-hidden sm:rounded-lg sm:overflow-hidden  ">
                         <img src="https://tailwindui.com/img/ecommerce-images/product-page-02-secondary-product-shot.jpg" alt="Two each of gray, white, and black shirts laying flat." class="w-full h-full object-center object-cover">
                     </div>-->

                    <!-- Options -->
                    <div class="mt-4 lg:mt-0 lg:row-span-1 sm:ml-2 sm:mr-2">
                        <p class="tracking-tight text-3xl"><c:out value='${book.name}'/></p>
                        <h2 class="sr-only">Product information</h2>
                        <p class="tracking-tight text-xl text-gray-900 mt-2">By <a href="#" class="font-bold-medium text-purple-800"> ${book.author} </a></p>

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
                                <h3 class="text-md text-gray-900 font-medium">Category: <a href="#" class="font-bold-medium text-purple-800"> <c:out value='${category.category_name}'/> </a> </h3>
                            </div>

                            <div class="mt-5">
                                <h3 class="text-md text-gray-900 font-medium">Seller:  <a href="#" class="font-bold-medium text-purple-800"> <c:out value='${vendor.store_name}'/> </a> </h3>
                            </div>

                            <!-- Sizes -->
                            <div class="mt-10">
                                <div class="flex items-center justify-between">
                                    <h3 class="text-sm text-gray-900 font-medium">Size</h3>
                                    <a href="#" class="text-sm font-medium text-indigo-600 hover:text-indigo-500">Size guide</a>
                                </div>                                    
                            </div>

                            <form name="addToCartForm" method="POST" action="cart">
                                <input type="hidden" name="book_id" value="<c:out value='${book.id}'/>">
                                <input type="hidden" name="action" value="add-to-cart">
                                <button type="submit" class="mt-10 w-full bg-purple-600 border border-transparent rounded-md py-3 px-8 flex items-center justify-center text-base font-medium text-white hover:bg-purple-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-purple-500">
                                    Add to cart
                                </button>
                            </form>

                        </div>
                    </div>
                </div>                

                <!-- Product info -->
                <div class="max-w-2xl mx-auto pt-10 pb-16 px-4 sm:px-6 lg:max-w-7xl lg:pt-16 lg:pb-24 lg:px-8 lg:grid lg:grid-cols-3 lg:grid-rows-[auto,auto,1fr] lg:gap-x-8">
                    <div class="lg:col-span-2 lg:border-r lg:border-gray-200 lg:pr-8">
                        <h1 class="text-2xl font-bold tracking-tight text-gray-900 sm:tracking-tight sm:text-3xl">Description</h1>
                    </div>  

                    <!--add to cart portion here-->

                    <div class="py-10 lg:pt-6 lg:pb-16 lg:col-start-1 lg:col-span-2 lg:border-r lg:border-gray-200 lg:pr-8">
                        <!-- Description and details -->
                        <div>
                            <h3 class="sr-only">Synopsis</h3>

                            <div class="space-y-6">
                                <p class="text-base text-gray-900"> <c:out value='${book.description}'/> </p>
                            </div>
                        </div>

                        <div class="mt-10">
                            <h3 class="text-sm font-medium text-gray-900">Highlights</h3>

                            <div class="mt-4">
                                <ul role="list" class="pl-4 list-disc text-sm space-y-2">
                                    <li class="text-gray-400"><span class="text-gray-600"> Book name: <c:out value='${book.name}'/> </span></li>

                                    <li class="text-gray-400"><span class="text-gray-600"> Author: <c:out value='${book.author}'/> </span></li>

                                    <li class="text-gray-400"><span class="text-gray-600"> ISBN: <c:out value='${book.isbn}'/> </span></li>

                                    <li class="text-gray-400"><span class="text-gray-600"> Category: <c:out value='${category.category_name}'/> </span></li>

                                    <li class="text-gray-400"><span class="text-gray-600"> Published year: <c:out value='${book.published_year}'/> </span></li>

                                    <li class="text-gray-400"><span class="text-gray-600"> Language: <c:out value='${language.language_name}'/> </span></li>

                                    <li class="text-gray-400"><span class="text-gray-600"> Cover type: <c:out value='${coverType.cover_type}'/> </span></li>

                                    <li class="text-gray-400"><span class="text-gray-600"> Book type: <c:out value='${bookType.type}'/> </span></li>

                                    <li class="text-gray-400"><span class="text-gray-600"> Seller: <c:out value='${vendor.store_name}'/> </span></li>                                        

                                </ul>
                            </div>
                        </div>

                        <div class="mt-10">
                            <h2 class="text-sm font-medium text-gray-900">Details</h2>

                            <div class="mt-4 space-y-6">
                                <p class="text-sm text-gray-600">The 6-Pack includes two black, two white, and two heather gray Basic Tees. Sign up for our subscription service and be the first to get new, exciting colors, like our upcoming &quot;Charcoal Gray&quot; limited release.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
