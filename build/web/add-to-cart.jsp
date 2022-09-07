<%-- 
    Document   : add-to-cart
    Created on : Aug 17, 2022, 10:07:04 PM
    Author     : Umesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="allscripts.jsp"/>
        <title>Cart</title>
        <style>
            #summary {
                background-color: #f6f6f6;
            }
        </style>
    </head>

    <body class="bg-gray-100">

        <!--navigation section-->
        <jsp:include page="navigation-bar.jsp"/>
        <!--navigation section ends-->

        <div class="container mx-auto mt-5 rounded">
            <div class="flex shadow-md my-10 ml-4 mr-4 rounded">
                <div class="w-3/4 bg-white px-10 py-10 rounded">
                    <div class="flex justify-between border-b pb-8">
                        <h1 class="font-semibold text-2xl">Shopping Cart</h1>
                        <h2 class="font-semibold text-2xl"><c:out value="${cartItemList.size()}"/> Items</h2>
                    </div>
                    <div class="flex mt-10 mb-5">
                        <h3 class="font-semibold text-gray-600 text-xs uppercase w-2/5">Product Details</h3>
                        <h3 class="font-semibold text-center text-gray-600 text-xs uppercase w-1/5 text-center">Quantity</h3>
                        <h3 class="font-semibold text-center text-gray-600 text-xs uppercase w-1/5 text-center">Price</h3>
                        <h3 class="font-semibold text-center text-gray-600 text-xs uppercase w-1/5 text-center">Total</h3>
                    </div>
                    <c:set var="total_price" value="${0}"/>
                    <c:forEach var="cartItem" items="${cartItemList}">
                        <div class="flex items-center hover:bg-gray-100 -mx-8 px-6 py-5 rounded">
                            <div class="flex w-2/5 rounded"> <!-- product -->
                                <div class="w-20 rounded">
                                    <img class="h-24 rounded" src="images/book_cover_photos/<c:out value="${cartItem.vendor_id}"/>/<c:out value="${cartItem.cover_photo_name}"/>" alt="<c:out value="${cartItem.book_name}"/>">                                                  
                                </div>
                                <div class="flex flex-col justify-between ml-4 flex-grow">
                                    <span class="font-bold text-auto"><c:out value="${cartItem.book_name}"/></span> 
                                    <span class="text-gray-600 text-xs">By: <c:out value="${cartItem.book_author}"/></span>                                                 
                                    <a href="cart?action=remove&id=<c:out value="${cartItem.id}"/>" class="font-semibold hover:text-red-800 text-red-500 text-xs inline">Remove</a>
                                </div>
                            </div>
                            <div class="flex justify-center w-1/5">
                                <a href="cart?action=updateCartQuantity&id=<c:out value="${cartItem.id}"/>&type=subtract" class="flex justify-center"> <svg class="fill-current text-gray-600 w-3" viewBox="0 0 448 512">
                                    <path d="M416 208H32c-17.67 0-32 14.33-32 32v32c0 17.67 14.33 32 32 32h384c17.67 0 32-14.33 32-32v-32c0-17.67-14.33-32-32-32z"/>
                                    </svg> 
                                </a>
                                <input name="quantity" class="mx-2 border text-center w-12 rounded" type="text" value="<c:out value="${cartItem.quantity}"/>" disabled>

                                <a href="cart?action=updateCartQuantity&id=<c:out value="${cartItem.id}"/>&type=add" class="flex justify-center"><svg class="fill-current text-gray-600 w-3" viewBox="0 0 448 512">
                                    <path d="M416 208H272V64c0-17.67-14.33-32-32-32h-32c-17.67 0-32 14.33-32 32v144H32c-17.67 0-32 14.33-32 32v32c0 17.67 14.33 32 32 32h144v144c0 17.67 14.33 32 32 32h32c17.67 0 32-14.33 32-32V304h144c17.67 0 32-14.33 32-32v-32c0-17.67-14.33-32-32-32z"/>
                                    </svg>
                                </a>
                            </div>
                            <c:if test="${cartItem.discounted_price != ''}">
                                <span class="text-center w-1/5">
                                    <span class="text-center w-1/5 font-semibold text-sm">NPR. <c:out value="${cartItem.discounted_price}"/></span><br>
                                    <span class="w-1/5 text-sm line-through text-xs">NPR. <c:out value="${cartItem.price}"/></span>
                                </span>
                                <span class="text-center w-1/5 font-semibold text-sm">NPR. <c:out value="${cartItem.discounted_price * cartItem.quantity}"/></span>                                                  
                                <c:set var="total_price" value="${total_price + (cartItem.discounted_price * cartItem.quantity)}"/>
                            </c:if>
                            <c:if test="${cartItem.discounted_price == ''}">
                                <span class="text-center w-1/5 font-semibold text-sm">NPR. <c:out value="${cartItem.price}"/></span>
                                <span class="text-center w-1/5 font-semibold text-sm">NPR. <c:out value="${cartItem.price * cartItem.quantity}"/></span>                                                  
                                <c:set var="total_price" value="${total_price + (cartItem.price * cartItem.quantity)}"/>
                            </c:if>

                        </div>
                    </c:forEach>

                    <a href="home" class="flex font-semibold text-indigo-600 text-sm mt-10">
                        <svg class="fill-current mr-2 text-indigo-600 w-4" viewBox="0 0 448 512"><path d="M134.059 296H436c6.627 0 12-5.373 12-12v-56c0-6.627-5.373-12-12-12H134.059v-46.059c0-21.382-25.851-32.09-40.971-16.971L7.029 239.029c-9.373 9.373-9.373 24.569 0 33.941l86.059 86.059c15.119 15.119 40.971 4.411 40.971-16.971V296z"/></svg>
                        Continue Shopping
                    </a>
                </div>

                <div id="summary" class="w-1/4 px-8 py-10 rounded overflow-hidden">
                    <h1 class="font-semibold text-2xl border-b pb-8">Order Summary</h1>
                    <div class="flex justify-between mt-10 mb-5">
                        <span class="font-semibold text-sm uppercase">Items <c:out value="${cartItemList.size()}"/></span>
                        <span class="font-semibold text-sm">NPR. <c:out value="${total_price}"/></span>
                    </div>
                    <div>
                        <label class="font-medium inline-block mb-3 text-sm uppercase">Shipping</label>
                        <select class="block p-2 text-gray-600 w-full text-sm rounded">
                            <option>Free shipping - NPR. 0</option>
                            <option disabled>Standard shipping - NPR. 100</option>
                        </select>
                    </div>
                    <div class="py-10">
                        <label for="promo" class="font-semibold inline-block mb-3 text-sm uppercase">Promo Code</label>
                        <input type="text" id="promo" placeholder="Coming soon..." class="p-2 text-sm w-full border rounded" disabled>
                    </div>
                    <button class="bg-red-400 px-5 py-2 text-sm text-gray-300 uppercase rounded" disabled>Apply</button>
                    <div class="border-t mt-8">
                        <div class="flex font-semibold justify-between py-6 text-sm uppercase">
                            <span>Total cost</span>
                            <span>NPR. <c:out value="${total_price}"/></span>
                        </div>
                        <a href="checkout"> <button class="bg-purple-500 font-semibold hover:bg-purple-600 py-3 text-sm text-white uppercase w-full rounded">Checkout</button> </a>
                    </div>
                </div>

            </div>
        </div>
    </body>

    <!--footer section-->
    <jsp:include page="footer.html"/>
    <!--footer section ends-->

</html>