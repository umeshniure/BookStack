<%-- 
    Document   : all-books
    Created on : Aug 20, 2022, 6:29:03 PM
    Author     : Umesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://cdn.tailwindcss.com"></script>
        <title>Books</title>
    </head>
    <body>
        <div class="flex p-2 border-4 border-dotted ">
            <!--product list section-->
            <div class="max-w-2xl mx-4 py-2 px-2 sm:py-24 sm:px-6 lg:max-w-7xl lg:px-8">
                <h3 class="text-2xl font-bold tracking-tight text-gray-900">New Arrivals</h3>

                <div class="mt-6 grid grid-cols-1 gap-y-10 gap-x-6 sm:grid-cols-2 lg:grid-cols-4 xl:gap-x-8">
                    <c:forEach var="book" items="${booklist}">
                        <div class="group relative mr-3">
                            <a href="<c:out value='home?action=book-detail&id=${book.id}'/>">
                                <div class="w-full min-h-80 bg-gray-200 rounded-md overflow-hidden lg:h-80 lg:aspect-none">
                                    <img src="images/book_cover_photos/<c:out value="${book.cover_photo_name}"/>" alt="<c:out value="${book.name}"/>" title="<c:out value='${book.name}'/>" class="w-full h-full object-center object-cover lg:w-full lg:h-full">
                                </div>
                            </a>
                            <div class="mt-4 flex justify-between">
                                <div class="overflow-hidden">
                                    <h3 class="text-sm text-gray-700">
                                        <a href="#" class="line-clamp-1" title="<c:out value='${book.name}'/>" >
                                            <span aria-hidden="true" class="absolute line-clamp-1" ></span>
                                            <c:out value="${book.name}"/>
                                        </a>
                                    </h3>
                                    <c:forEach var="category" items="${category}">
                                        <c:if test="${book.category == category.id}">
                                            <p class="mt-1 text-sm text-gray-500"><c:out value="${category.category_name}" /></p>                                                    
                                        </c:if>
                                    </c:forEach>
                                </div>
                                <p class="text-sm font-medium text-gray-900"><c:out value="${book.price}" /></p>                                    
                            </div>
                            <div class="mt-2">
                                <a href="addtocart"><button type="button" class="w-full inline-block px-6 py-2 border-2 border-purple-600 text-purple-600 font-medium text-xs leading-tight uppercase rounded hover:bg-purple hover:bg-opacity-5 focus:outline-none focus:ring-0 transition duration-150 ease-in-out">
                                        Add to cart
                                    </button></a>
                            </div>
                        </div>
                        <!-- More products... -->

                    </c:forEach>
                </div>


            </div>
            <!--product list section-->
        </div>
    </body>
</html>
