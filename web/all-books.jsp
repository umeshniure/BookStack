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
        <jsp:include page="allscripts.jsp"/>
        <title>Books</title>
    </head>
    <body>

        <!--navigation section-->
        <jsp:include page="navigation-bar.jsp"/>
        <!--navigation section ends--> 

        <div class="flex p-2 justify-around w-full">
            <!--product list section-->


            <div class="max-w-2xl mx-4 py-2 px-2 sm:px-6 lg:max-w-7xl lg:px-8">
                <!--Search section-->
                <form method="GET" action="search" class="flex items-center mb-4">   
                    <label for="voice-search" class="sr-only">Search</label>
                    <div class="relative w-full">
                        <div class="flex absolute inset-y-0 left-0 items-center pl-3 pointer-events-none">
                            <svg class="w-5 h-5 text-gray-500 dark:text-gray-400" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M8 4a4 4 0 100 8 4 4 0 000-8zM2 8a6 6 0 1110.89 3.476l4.817 4.817a1 1 0 01-1.414 1.414l-4.816-4.816A6 6 0 012 8z" clip-rule="evenodd"></path></svg>
                        </div>
                        <input name="search" type="text" id="Search" onkeyup="myFunction()" value="${searchedQuery}" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full pl-10 p-2.5  dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="Search by Title/Author/ISBN" required>
                        <button type="button" class="flex absolute inset-y-0 right-0 items-center pr-3">
                            <svg class="w-4 h-4 text-gray-500 dark:text-gray-400 hover:text-gray-900 dark:hover:text-white" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M7 4a3 3 0 016 0v4a3 3 0 11-6 0V4zm4 10.93A7.001 7.001 0 0017 8a1 1 0 10-2 0A5 5 0 015 8a1 1 0 00-2 0 7.001 7.001 0 006 6.93V17H6a1 1 0 100 2h8a1 1 0 100-2h-3v-2.07z" clip-rule="evenodd"></path></svg>
                        </button>
                    </div>
                    <button type="submit" class="inline-flex items-center py-2.5 px-3 ml-2 text-sm font-medium text-white bg-purple-600 rounded-lg border border-purple-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800"><svg class="mr-2 -ml-1 w-5 h-5" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z"></path></svg>Search</button>
                </form>
                <!--search section ends-->

                <h3 class="text-2xl font-bold tracking-tight text-gray-900"><c:out value="${name}"/></h3>
                <div class="mt-6 grid grid-cols-1 gap-y-10 gap-x-6 sm:grid-cols-2 lg:grid-cols-5 xl:gap-x-8 w-full">
                    <c:if test="${booklist != null && booklist.isEmpty()}">
                        <h3 class="text-xl font-normal tracking-tight text-gray-900 justify-self-center">Sorry! no books found.</h3>
                    </c:if>
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
                                    <a href="home?action=category&id=<c:out value="${book.category}"/>">
                                        <p class="mt-1 text-sm font-bold text-purple-600 hover:text-purple-800"><c:out value="${book.category_name}" /></p>                                                    
                                    </a>
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

        <!--footer section-->
        <jsp:include page="footer.jsp"/>
        <!--footer section ends-->

    </body>
</html>
