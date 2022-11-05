<%-- 
    Document   : vendor-book-list
    Created on : Aug 28, 2022, 2:10:44 PM
    Author     : Umesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="allscripts.jsp"/>
        <title>Vendor book list</title>
    </head>
    <body>

        <!--aside navigation bar-->
        <jsp:include page="vendor-dashboard-aside.jsp"/>
        <!--aside navigation bar ends-->

        <div class="ml-auto mb-6 lg:w-[75%] xl:w-[80%] 2xl:w-[85%]">

            <!--navigation bar-->
            <jsp:include page="vendor-dashboard-navbar.jsp"/>
            <!--navigation bar ends-->

            <div class="flex p-2 justify-around w-full">
                <!--product list section-->
                <div class="max-w-2xl mx-4 py-2 px-2 sm:px-6 lg:max-w-7xl lg:px-8">
                    <!--<h3 class="text-2xl font-bold tracking-tight text-gray-900">Books</h3>-->
                    <c:if test="${books.size() == 0}">
                        No books to show!
                    </c:if>
                    <div class="mt-6 grid grid-cols-1 gap-y-10 gap-x-6 sm:grid-cols-2 lg:grid-cols-5 xl:gap-x-8 w-full">
                        
                        <c:forEach var="book" items="${books}">
                            <div class="group hover:scale-105 ease-in duration-200">
                                <a href="<c:out value='vendorbook?action=updateform&id=${book.id}'/>">
                                    <div class="flex w-full min-h-80 bg-gray-200 rounded-md overflow-hidden lg:h-80 lg:aspect-none justify-center">
                                        <img src="images/book_cover_photos/<c:out value="${book.vendor_id}"/>/<c:out value="${book.cover_photo_name}"/>" alt="<c:out value="${book.name}"/>" title="Click to edit - <c:out value='${book.name}'/>" class="w-auto h-full object-center object-cover lg:w-full lg:h-full rounded">
                                    </div>
                                </a>
                                <div class="mt-4 flex justify-between">
                                    <div class="overflow-hidden w-2/3">
                                        <h3 class="text-sm text-gray-700">
                                            <a href="#" class="line-clamp" title="<c:out value='${book.name}'/>" >
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
                                    <a href="vendorbook?action=delete&id=<c:out value='${book.id}'/>">
                                        <button onclick="" type="button" data-bs-toggle="modal" data-bs-target="#deleteConfirmModal" class="w-full inline-block px-6 py-2 border-2 border-red-400 text-red-400 font-medium text-xs leading-tight uppercase rounded hover:bg-red-400 hover:text-white focus:outline-none focus:ring-0 transition duration-150 ease-in-out">
                                            Delete
                                        </button>
                                    </a>
                                </div>
                            </div>

                            <!--modal section-->
                            <!--                            <div class="modal fade fixed top-0 left-0 hidden w-full h-full outline-none overflow-x-hidden overflow-y-auto" id="deleteConfirmModal" tabindex="-1" aria-labelledby="deleteConfirmModalTitle" aria-modal="true" role="dialog">
                                                            <div class="modal-dialog modal-dialog-centered relative w-auto pointer-events-none">
                                                                <div class="modal-content border-none shadow-lg relative flex flex-col w-full pointer-events-auto bg-white bg-clip-padding rounded-md outline-none text-current">
                                                                    <div class="modal-header flex flex-shrink-0 items-center justify-between p-4 border-b border-gray-200 rounded-t-md">
                                                                        <h5 class="text-xl font-medium leading-normal text-gray-800" id="exampleModalScrollableLabel">
                                                                            Delete confirmation
                                                                        </h5>
                                                                        <button type="button"
                                                                                class="btn-close box-content w-4 h-4 p-1 text-black border-none rounded-none opacity-50 focus:shadow-none focus:outline-none focus:opacity-100 hover:text-black hover:opacity-75 hover:no-underline"
                                                                                data-bs-dismiss="modal" aria-label="Close"></button>
                                                                    </div>
                                                                    <div class="modal-body relative p-4">
                                                                        <p>Are you sure you want to delete?</p>
                                                                        <p>This book will be deleted from everywhere and customers wont be able to see or search it.</p>
                                                                    </div>
                                                                    <div
                                                                        class="modal-footer flex flex-shrink-0 flex-wrap items-center justify-end p-4 border-t border-gray-200 rounded-b-md">
                                                                        <button type="button"
                                                                                class="inline-block px-6 py-2.5 bg-purple-600 text-white font-medium text-xs leading-tight uppercase rounded shadow-md hover:bg-purple-700 hover:shadow-lg focus:bg-purple-700 focus:shadow-lg focus:outline-none focus:ring-0 active:bg-purple-800 active:shadow-lg transition duration-150 ease-in-out"
                                                                                data-bs-dismiss="modal">
                                                                            Cancel
                                                                        </button>
                                                                        <a href="vendorbook?action=delete&id=<c:out value='${book.id}'/>">
                                                                            <button type="button" class="inline-block px-6 py-2.5 bg-purple-600 text-white font-medium text-xs leading-tight uppercase rounded shadow-md hover:bg-blue-700 hover:shadow-lg focus:bg-blue-700 focus:shadow-lg focus:outline-none focus:ring-0 active:bg-blue-800 active:shadow-lg transition duration-150 ease-in-out ml-1">
                                                                                Confirm delete
                                                                            </button>
                                                                        </a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>-->
                            <!--modal section ends-->
                        </c:forEach>  


                    </div>
                </div>
                <!--product list section-->
            </div>
        </div>
    </body>
</html>



