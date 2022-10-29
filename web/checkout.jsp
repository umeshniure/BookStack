<%-- 
    Document   : checkout
    Created on : Aug 24, 2022, 9:08:12 PM
    Author     : Umesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">   
        <jsp:include page="allscripts.jsp"/>
        <title>Place order</title>
    </head>

    <!--navigation section-->
    <jsp:include page="navigation-bar.jsp"/>
    <!--navigation section ends--> 

    <c:if test="${sessionScope.errorMessage != null}">
        <div id="toast-warning" class="flex absolute top-3 z-20 right-3 items-center p-4 w-full max-w-lg text-white bg-red-400 rounded-lg shadow dark:text-gray-400 dark:bg-gray-800" role="alert">
            <div class="inline-flex flex-shrink-0 justify-center items-center w-8 h-8 text-orange-600 bg-orange-100 rounded-lg dark:bg-orange-700 dark:text-orange-200">
                <svg aria-hidden="true" class="w-8 h-8" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M8.257 3.099c.765-1.36 2.722-1.36 3.486 0l5.58 9.92c.75 1.334-.213 2.98-1.742 2.98H4.42c-1.53 0-2.493-1.646-1.743-2.98l5.58-9.92zM11 13a1 1 0 11-2 0 1 1 0 012 0zm-1-8a1 1 0 00-1 1v3a1 1 0 002 0V6a1 1 0 00-1-1z" clip-rule="evenodd"></path></svg>
                <span class="sr-only">Warning icon</span>
            </div>
            <div class="ml-3 text-sm font-normal w-auto"><c:out value="${sessionScope.errorMessage}"/></div>
            <% request.getSession(false).removeAttribute("errorMessage");%>
            <button type="button" class="ml-auto -mx-1.5 -my-1.5 text-gray-800 hover:text-red-500 rounded-lg p-1.5 inline-flex h-8 w-8 dark:text-gray-500 dark:hover:text-white dark:bg-gray-800 dark:hover:bg-gray-700" data-dismiss-target="#toast-warning" aria-label="Close" title="Dismiss">
                <span class="sr-only">Close</span>
                <svg aria-hidden="true" class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z" clip-rule="evenodd"></path></svg>
            </button>
        </div>
    </c:if>

    <c:if test="${sessionScope.successMessage != null}">
        <div id="toast-success" class="flex absolute top-3 z-20 right-3 items-center p-4 mb-4 w-full max-w-lg text-white bg-green-400 rounded-lg shadow dark:text-gray-400 dark:bg-gray-800" role="alert">
            <div class="inline-flex flex-shrink-0 justify-center items-center w-8 h-8 text-green-500 bg-green-100 rounded-lg dark:bg-green-800 dark:text-green-200">
                <svg aria-hidden="true" class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M16.707 5.293a1 1 0 010 1.414l-8 8a1 1 0 01-1.414 0l-4-4a1 1 0 011.414-1.414L8 12.586l7.293-7.293a1 1 0 011.414 0z" clip-rule="evenodd"></path></svg>
                <span class="sr-only">Check icon</span>
            </div>
            <div class="ml-3 text-sm font-normal"><c:out value="${sessionScope.successMessage}"/></div>
            <% request.getSession(false).removeAttribute("successMessage");%>
            <button type="button" class="ml-auto -mx-1.5 -my-1.5 text-gray-800 hover:text-red-500 rounded-lg p-1.5 inline-flex h-8 w-8 dark:text-gray-500 dark:hover:text-white dark:bg-gray-800 dark:hover:bg-gray-700" data-dismiss-target="#toast-success" aria-label="Close" title="Dismiss">
                <span class="sr-only">Close</span>
                <svg aria-hidden="true" class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z" clip-rule="evenodd"></path></svg>
            </button>
        </div>
    </c:if>

    <body><!-- component -->
        <div class="ml-6 mr-6">
            <div class="py-16 px-4 md:px-6 2xl:px-0 flex justify-center items-center 2xl:mx-auto 2xl:container">
                <!--- more free and premium Tailwind CSS components at https://tailwinduikit.com/ --->
                <div class="flex flex-col justify-start items-start w-full space-y-9">
                    <div class="flex justify-start flex-col items-start space-y-2 md:ml-10 sm:ml-3">
                        <p class="text-3xl lg:text-4xl font-semibold leading-7 lg:leading-9 text-gray-800 dark:text-gray-50">Checkout</p>
                    </div>

                    <div class="flex flex-col xl:flex-row justify-center xl:justify-between space-y-6 xl:space-y-0 xl:space-x-6 w-full">
                        <div class="xl:w-2/5 flex flex-col sm:flex-row xl:flex-col justify-start items-start bg-white dark:bg-gray-800 sm:py-0 xl:py-0 md:px-10 sm:px-3">

                            <div class="relative flex flex-col min-w-0 mb-4 lg:mb-0 break-words bg-gray-50 dark:bg-gray-800 w-full drop-shadow-lg rounded-md">
                                <div class="px-0">
                                    <div class="flex flex-wrap items-center px-4 py-2">
                                        <div class="relative w-full max-w-full flex-grow flex-1">
                                            <h3 class="font-semibold text-base text-gray-900 dark:text-gray-50">Order summary</h3>
                                        </div>
                                    </div>
                                    <div class="block w-full overflow-x-auto border-b-2 rounded">
                                        <table class="items-start w-full bg-transparent border-collapse">
                                            <thead>
                                                <tr>
                                                    <th class="px-4 bg-gray-100 dark:bg-gray-600 text-gray-500 dark:text-gray-100 align-middle border border-solid border-gray-200 dark:border-gray-500 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left">Book</th>
                                                    <th class="px-4 bg-gray-100 dark:bg-gray-600 text-gray-500 dark:text-gray-100 align-middle border border-solid border-gray-200 dark:border-gray-500 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left">Quantity</th>
                                                    <th class="px-4 bg-gray-100 dark:bg-gray-600 text-gray-500 dark:text-gray-100 align-middle border border-solid border-gray-200 dark:border-gray-500 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left min-w-140-px">Total</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:set var="total_price" value="${0}"/>
                                                <c:forEach var="cartItem" items="${cartItemList}">
                                                    <tr class="text-gray-700 dark:text-gray-100">
                                                        <th class="border-t-0 px-4 content-start border-l-0 border-r-0 text-xs whitespace-nowrap p-4 text-left">
                                                            <div class="flex rounded"> <!-- product -->
                                                                <div class="rounded">
                                                                    <img class="h-10 rounded" src="images/book_cover_photos/<c:out value="${cartItem.vendor_id}"/>/<c:out value="${cartItem.cover_photo_name}"/>" alt="<c:out value="${cartItem.book_name}"/>">                                                  
                                                                </div>
                                                                <div class="flex flex-col ml-4 flex-grow">
                                                                    <span class="font-bold text-auto"><c:out value="${cartItem.book_name}"/></span> 
                                                                    <span class="text-gray-600 text-xs font-light">By: <c:out value="${cartItem.book_author}"/></span>                                                 
                                                                </div>
                                                            </div>

                                                            <%--<c:out value="${cartItem.book_name}"/>--%>
                                                        </th>
                                                        <td class="border-t-0 px-4 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4">${cartItem.quantity}</td>
                                                        <c:if test="${cartItem.discounted_price != ''}">                                                        
                                                            <td class="border-t-0 px-4 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4">${cartItem.discounted_price * cartItem.quantity}</td>
                                                            <c:set var="total_price" value="${total_price + (cartItem.discounted_price * cartItem.quantity)}"/>
                                                        </c:if>
                                                        <c:if test="${cartItem.discounted_price == ''}">                                                        
                                                            <td class="border-t-0 px-4 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4">${cartItem.price * cartItem.quantity}</td>
                                                            <c:set var="total_price" value="${total_price + (cartItem.price * cartItem.quantity) + 0.0}"/>
                                                        </c:if>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="m-5">
                                        <table class="items-start w-full bg-transparent border-collapse">

                                            <tbody>
                                                <tr class="text-gray-700 dark:text-gray-100 justify-end font-normal">
                                                    <th class="border-t-0 px-4 border-l-0 border-r-0 text-xs font-semibold whitespace-nowrap p-4">SubTotal</th>
                                                    <th class="border-t-0 px-4 border-l-0 border-r-0 text-xs font-semibold whitespace-nowrap p-4">NPR. ${total_price+0.0}</th>
                                                </tr>
                                                <tr class="text-gray-700 dark:text-gray-100">
                                                    <th class="border-t-0 px-4 align-middle border-l-0 border-r-0 text-xs font-semibold whitespace-nowrap p-4">Shiping</th>
                                                    <th class="border-t-0 px-4 align-middle border-l-0 border-r-0 text-xs font-semibold whitespace-nowrap p-4">NPR. 0.0</th>
                                                </tr>
                                                <tr class="text-gray-700 dark:text-gray-100">
                                                    <th class="border-t-0 px-4 align-middle border-l-0 border-r-0 text-xs font-semibold whitespace-nowrap p-4">Discounts</th>
                                                    <th class="border-t-0 px-4 align-middle border-l-0 border-r-0 text-xs font-semibold whitespace-nowrap p-4">NPR. 0.0</th>
                                                </tr>
                                                <tr class="text-gray-700 dark:text-gray-100  border-b-2">
                                                    <th class="border-t-0 px-4 align-middle border-l-0 border-r-0 text-xs font-semibold whitespace-nowrap p-4">Taxes</th>
                                                    <th class="border-t-0 px-4 align-middle border-l-0 border-r-0 text-xs font-semibold whitespace-nowrap p-4">NPR. 0.0</th>
                                                </tr>
                                                <tr class="text-gray-700 dark:text-gray-100">
                                                    <th class="border-t-0 px-4 align-middle border-l-0 border-r-0 whitespace-nowrap p-4 text-sm">Total</th>
                                                    <th class="border-t-0 px-4 align-middle border-l-0 border-r-0 whitespace-nowrap p-4 text-sm">NPR. ${total_price+0.0}</th>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>

                            <!--shipping address portion-->
                            <div class="relative flex flex-row min-w-0 mb-4 mt-4 lg:mb-0 break-words bg-gray-50 dark:bg-gray-800 w-full drop-shadow-lg rounded-md">
                                <div class="p-4 space-y-3 w-full">
                                    <div class="flex items-center justify-between w-full">
                                        <h3 class="inline text-lg font-semibold leading-none">Your shipping addresses</h3>
                                        <button type="button" class="px-2 py-2 font-medium tracking-wide text-black rounded-lg hover:bg-gray-200" title="Click to addd/edit your shipping addresses">
                                            <svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 0 24 24" width="24px" fill="#000000">
                                            <path d="M0 0h24v24H0V0z" fill="none"></path>
                                            <path d="M5 18.08V19h.92l9.06-9.06-.92-.92z" opacity=".3"></path>
                                            <path d="M20.71 7.04c.39-.39.39-1.02 0-1.41l-2.34-2.34c-.2-.2-.45-.29-.71-.29s-.51.1-.7.29l-1.83 1.83 3.75 3.75 1.83-1.83zM3 17.25V21h3.75L17.81 9.94l-3.75-3.75L3 17.25zM5.92 19H5v-.92l9.06-9.06.92.92L5.92 19z"></path>
                                            </svg>
                                        </button>
                                    </div>
                                    <c:if test="${addresses.size()== 0}">
                                        <div class="flex items-center w-full">
                                            No address found!
                                        </div>
                                    </c:if>
                                    <c:forEach var="address" items="${addresses}">

                                        <div class="bg-white drop-shadow-md cursor-pointer rounded-md p-4 hover:bg-gray-200" title="Click to use this address">
                                            <a href="order?action=fillAddress&id=${address.id}">
                                                <div class="flex">
                                                    <c:if test="${address.postal_code != null && address.postal_code != 0}">
                                                        <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
                                                        <path stroke-linecap="round" stroke-linejoin="round" d="M15 10.5a3 3 0 11-6 0 3 3 0 016 0z" />
                                                        <path stroke-linecap="round" stroke-linejoin="round" d="M19.5 10.5c0 7.142-7.5 11.25-7.5 11.25S4.5 17.642 4.5 10.5a7.5 7.5 0 1115 0z" />
                                                        </svg> ${address.postal_code} - 
                                                    </c:if>
                                                    ${address.street},
                                                    <c:if test='${address.apartment != null && address.apartment != ""}'>
                                                        ${address.apartment}, 
                                                    </c:if>
                                                    ${address.city_name}, ${address.province_name}, ${address.country_name}
                                                </div>
                                            </a>
                                        </div>
                                    </c:forEach>

                                </div>
                            </div>
                            <!--shipping address portion ends-->

                        </div>

                        <div class="sm:p-8 sm:pt-0 md:p-3 md:pt-0 dark:bg-gray-800 flex flex-col lg:w-full xl:w-3/5">

                            <div>
                                <div class="bg-white rounded-lg shadow">
                                    <div class="flex">
                                        <div class="flex-1 py-4 pl-5 overflow-hidden">
                                            <svg class="inline align-text-top" width="21" height="20.5" xmlns="http://www.w3.org/2000/svg" fill="#000000">
                                            <g>
                                            <path d="m4.88889,2.07407l14.22222,0l0,20l-14.22222,0l0,-20z" fill="none" id="svg_1" stroke="null"></path>
                                            <path d="m7.07935,0.05664c-3.87,0 -7,3.13 -7,7c0,5.25 7,13 7,13s7,-7.75 7,-13c0,-3.87 -3.13,-7 -7,-7zm-5,7c0,-2.76 2.24,-5 5,-5s5,2.24 5,5c0,2.88 -2.88,7.19 -5,9.88c-2.08,-2.67 -5,-7.03 -5,-9.88z" id="svg_2"></path>
                                            <circle cx="7.04807" cy="6.97256" r="2.5" id="svg_3"></circle>
                                            </g>
                                            </svg>
                                            <h1 class="inline text-2xl font-semibold leading-none">Shipping & Billing information</h1>
                                        </div>
                                        <div class="flex-none pt-2.5 pr-2.5 pl-1"></div>
                                    </div>
                                    <form action="order" method="post">
                                        <div class="px-5 pb-5 mt-4">
                                            <span class="block uppercase text-gray-600 text-xs font-bold mb-2">Street name</span>
                                            <input name="street" value="${fillAddress.street}"  placeholder="Street name" class=" mb-8 text-black placeholder-gray-600 border shadow-sm w-full px-4 py-2.5 text-base transition duration-500 ease-in-out transform rounded focus:border-blueGray-500 focus:bg-white dark:focus:bg-gray-800 focus:outline-none focus:shadow-outline focus:ring-2 ring-offset-current ring-offset-2 ring-gray-400"> 
                                            <span class="block uppercase text-gray-600 text-xs font-bold mb-2">Apartment, Suite</span>
                                            <input name="apartment" value="${fillAddress.apartment}" placeholder="Apartment, Suite" class="mb-8 text-black placeholder-gray-600 border shadow-sm w-full px-4 py-2.5 text-base transition duration-500 ease-in-out transform rounded  focus:border-blueGray-500 focus:bg-white dark:focus:bg-gray-800 focus:outline-none focus:shadow-outline focus:ring-2 ring-offset-current ring-offset-2 ring-gray-400"> 
                                            <div class="flex">
                                                <div class="flex-grow w-2/4 pr-2">
                                                    <span class="block uppercase text-gray-600 text-xs font-bold mb-2">Province / State</span>
                                                    <!--<input name="province"  placeholder="Province / State" class="mb-8 text-black placeholder-gray-600 border shadow-sm w-full px-4 py-2.5 text-base transition duration-500 ease-in-out transform rounded focus:border-blueGray-500 focus:bg-white dark:focus:bg-gray-800 focus:outline-none focus:shadow-outline focus:ring-2 ring-offset-current ring-offset-2 ring-gray-400">-->
                                                    <select name="province" class="mb-8 text-black placeholder-gray-600 border shadow-sm w-full px-4 py-2.5 text-base transition duration-500 ease-in-out transform rounded focus:border-blueGray-500 focus:bg-white dark:focus:bg-gray-800 focus:outline-none focus:shadow-outline focus:ring-2 ring-offset-current ring-offset-2 ring-gray-400">
                                                        <option value="${fillAddress.province}">${fillAddress.province_name}</option>
                                                        <c:forEach var="province" items="${provinces}">
                                                            <option value="${province.id}">${province.province_name}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div class="flex-grow w-2/4">
                                                    <span class="block uppercase text-gray-600 text-xs font-bold mb-2">City</span>
                                                    <!--<input name="city" placeholder="City" class="mb-8 text-black placeholder-gray-600 border shadow-sm w-full px-4 py-2.5 text-base transition duration-500 ease-in-out transform rounded focus:border-blueGray-500 focus:bg-white dark:focus:bg-gray-800 focus:outline-none focus:shadow-outline focus:ring-2 ring-offset-current ring-offset-2 ring-gray-400">-->
                                                    <select name="city" class="mb-8 text-black placeholder-gray-600 border shadow-sm w-full px-4 py-2.5 text-base transition duration-500 ease-in-out transform rounded focus:border-blueGray-500 focus:bg-white dark:focus:bg-gray-800 focus:outline-none focus:shadow-outline focus:ring-2 ring-offset-current ring-offset-2 ring-gray-400">
                                                        <option value="${fillAddress.city}">${fillAddress.city_name}</option>
                                                        <c:forEach var="city" items="${cities}">
                                                            <option value="${city.id}">${city.city_name}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="flex">
                                                <div class="flex-grow w-2/4 pr-2">
                                                    <span class="block uppercase text-gray-600 text-xs font-bold mb-2">Postal Code</span>
                                                    <c:if test="${fillAddress.postal_code != 0 && fillAddress.postal_code != null}">
                                                        <input name="postcode" value="${fillAddress.postal_code}" placeholder="Post Code" class="mb-8 text-black placeholder-gray-600 border shadow-sm w-full px-4 py-2.5 text-base transition duration-500 ease-in-out transform rounded  focus:border-blueGray-500 focus:bg-white dark:focus:bg-gray-800 focus:outline-none focus:shadow-outline focus:ring-2 ring-offset-current ring-offset-2 ring-gray-400">
                                                    </c:if>
                                                    <c:if test="${fillAddress.postal_code == 0 || fillAddress.postal_code == null}">
                                                        <input name="postcode" placeholder="Post Code" class="mb-8 text-black placeholder-gray-600 border shadow-sm w-full px-4 py-2.5 text-base transition duration-500 ease-in-out transform rounded  focus:border-blueGray-500 focus:bg-white dark:focus:bg-gray-800 focus:outline-none focus:shadow-outline focus:ring-2 ring-offset-current ring-offset-2 ring-gray-400">
                                                    </c:if>
                                                </div>
                                                <div class="flex-grow w-2/4">
                                                    <span class="block uppercase text-gray-600 text-xs font-bold mb-2">Country</span>
                                                    <!--<input name="country" placeholder="Country" value="Nepal" readonly class="mb-8 text-black placeholder-gray-600 border shadow-sm w-full px-4 py-2.5 text-base transition duration-500 ease-in-out transform rounded focus:border-blueGray-500 focus:bg-white dark:focus:bg-gray-800 focus:outline-none focus:shadow-outline focus:ring-2 ring-offset-current ring-offset-2 ring-gray-400">-->
                                                    <select name="country" class="mb-8 text-black placeholder-gray-600 border shadow-sm w-full px-4 py-2.5 text-base transition duration-500 ease-in-out transform rounded focus:border-blueGray-500 focus:bg-white dark:focus:bg-gray-800 focus:outline-none focus:shadow-outline focus:ring-2 ring-offset-current ring-offset-2 ring-gray-400">
                                                        <option value="${fillAddress.country}">${fillAddress.country_name}</option>
                                                        <c:forEach var="country" items="${countries}">
                                                            <option value="${country.id}">${country.country_name}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                            <span class="block uppercase text-gray-600 text-xs font-bold mb-2">Any Special Instructions?</span>
                                            <textarea name="specialInstruction" placeholder="Please tell us anything you would like us to be cautious/informed of (Optional)..." class="h-40 text-black placeholder-gray-600 border shadow-sm w-full px-4 py-2.5 text-base transition duration-500 ease-in-out transform rounded focus:border-blueGray-500 focus:bg-white dark:focus:bg-gray-800 focus:outline-none focus:shadow-outline focus:ring-2 ring-offset-current ring-offset-2 ring-gray-400"></textarea>  
                                            <input type="hidden" name="order_subtotal" value="${total_price}">
                                            <input type="hidden" name="order_total" value="${total_price}">
                                        </div>
                                        <hr class="mt-4 mx-3">
                                        <div class="flex flex-row-reverse p-3">
                                            <div class="flex-initial pl-3">
                                                <button type="submit" name="action" value="saveAddress" class="flex items-center px-5 py-3 font-medium tracking-wide text-white capitalize bg-purple-600 rounded-md  hover:bg-purple-700 focus:outline-none focus:bg-gray-900  transition duration-50 transform active:scale-95 ease-in-out">
                                                    <svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 0 24 24" width="24px" fill="#FFFFFF">
                                                    <path d="M0 0h24v24H0V0z" fill="none"></path>
                                                    <path d="M5 5v14h14V7.83L16.17 5H5zm7 13c-1.66 0-3-1.34-3-3s1.34-3 3-3 3 1.34 3 3-1.34 3-3 3zm3-8H6V6h9v4z" opacity=".3"></path>
                                                    <path d="M17 3H5c-1.11 0-2 .9-2 2v14c0 1.1.89 2 2 2h14c1.1 0 2-.9 2-2V7l-4-4zm2 16H5V5h11.17L19 7.83V19zm-7-7c-1.66 0-3 1.34-3 3s1.34 3 3 3 3-1.34 3-3-1.34-3-3-3zM6 6h9v4H6z"></path>
                                                    </svg>
                                                    <span class="pl-2 mx-1 uppercase">Save</span>
                                                </button>
                                            </div>
                                            <div class="flex-initial a w-full ">
                                                <button type="submit" name="action" value="submitOrder" class="w-full justify-center p-3 font-medium text-white uppercase bg-purple-600 rounded-md shadow item-center hover:bg-purple-700 focus:shadow-outline focus:outline-none">
                                                    Confirm order
                                                </button>
                                                <!--                                            <button type="button" class="flex items-center px-5 py-2.5 font-medium tracking-wide text-black capitalize rounded-md  hover:bg-red-200 hover:fill-current hover:text-red-600  focus:outline-none  transition duration-300 transform active:scale-95 ease-in-out">
                                                                                                <svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 0 24 24" width="24px">
                                                                                                <path d="M0 0h24v24H0V0z" fill="none"></path>
                                                                                                <path d="M8 9h8v10H8z" opacity=".3"></path>
                                                                                                <path d="M15.5 4l-1-1h-5l-1 1H5v2h14V4zM6 19c0 1.1.9 2 2 2h8c1.1 0 2-.9 2-2V7H6v12zM8 9h8v10H8V9z"></path>
                                                                                                </svg>
                                                                                                <span class="pl-2 mx-1">Delete</span>
                                                                                            </button>-->
                                            </div>
                                        </div>
                                    </form>
                                </div>


                                <div class="mt-5 bg-white shadow cursor-pointer rounded-xl">
                                    <div class="flex">
                                        <div class="flex-1 py-5 pl-5 overflow-hidden">
                                            <ul>
                                                <li class="text-xs text-gray-600 uppercase ">Receiver</li>
                                                <li>Max Mustermann</li>
                                                <li>Musterstrasse 1</li>
                                                <li>4020 Linz</li>
                                            </ul>
                                        </div>
                                        <div class="flex-1 py-5 pl-1 overflow-hidden">
                                            <ul>
                                                <li class="text-xs text-gray-600 uppercase">Sender</li>
                                                <li>Rick Astley</li>
                                                <li>Rickrolled 11</li>
                                                <li>1000 Vienna</li>
                                            </ul>
                                        </div>
                                        <div class="flex-none pt-2.5 pr-2.5 pl-1">
                                            <button type="button" class="px-2 py-2 font-medium tracking-wide text-black capitalize transition duration-300 ease-in-out transform rounded-xl hover:bg-gray-300 focus:outline-none active:scale-95">
                                                <svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 0 24 24" width="24px" fill="#000000">
                                                <path d="M0 0h24v24H0V0z" fill="none"></path>
                                                <path d="M5 18.08V19h.92l9.06-9.06-.92-.92z" opacity=".3"></path>
                                                <path d="M20.71 7.04c.39-.39.39-1.02 0-1.41l-2.34-2.34c-.2-.2-.45-.29-.71-.29s-.51.1-.7.29l-1.83 1.83 3.75 3.75 1.83-1.83zM3 17.25V21h3.75L17.81 9.94l-3.75-3.75L3 17.25zM5.92 19H5v-.92l9.06-9.06.92.92L5.92 19z"></path>
                                                </svg>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>

                </div>
            </div>
        </div>
    </body>

    <!--navigation section-->
    <jsp:include page="footer.html"/>
    <!--navigation section ends--> 

</html>
