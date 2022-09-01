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
        <link rel="stylesheet" href="css/allcss.css"></link>
        <title>Books</title>
    </head>
    <body>

        <!--navigation section-->
        <jsp:include page="navigation-bar.jsp"/>
        <!--navigation section ends--> 

        <div class="flex p-2 justify-around w-full">
            <!--product list section-->
            <div class="max-w-2xl mx-4 py-2 px-2 sm:px-6 lg:max-w-7xl lg:px-8">
                <h3 class="text-2xl font-bold tracking-tight text-gray-900">Books</h3>

                <div class="mt-6 grid grid-cols-1 gap-y-10 gap-x-6 sm:grid-cols-2 lg:grid-cols-5 xl:gap-x-8 w-full">
                    <c:forEach var="book" items="${booklist}">
                        <div class="group relative hover:scale-105 ease-in duration-200">
                            <a href="<c:out value='home?action=book-detail&id=${book.id}'/>">
                                <div class="flex w-full min-h-80 bg-gray-200 rounded-md overflow-hidden lg:h-80 lg:aspect-none justify-center">
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
            <!--product list section-->
        </div>
    </body>
</html>
