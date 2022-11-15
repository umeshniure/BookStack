<%-- 
    Document   : user-order-history
    Created on : Oct 23, 2022, 1:17:10 PM
    Author     : Umesh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="allscripts.jsp"/>
        <title>Order History</title>
    </head>
    <body>

        <!--navigation section-->
        <jsp:include page="navigation-bar.jsp"/>
        <!--navigation section ends-->

        <div class="py-10 px-4 md:px-6 2xl:px-20 2xl:container 2xl:mx-auto">
            <div class="flex justify-start item-start space-y-2 flex-col">
                <h1 class="text-3xl dark:text-white lg:text-4xl font-semibold leading-7 lg:leading-9 text-gray-800">Order History</h1>
            </div>
            <div class="mt-10 flex flex-col xl:flex-row jusitfy-center items-stretch w-full xl:space-x-8 space-y-4 md:space-y-6 xl:space-y-0">
                <div class="flex flex-col justify-start items-start w-full space-y-4 md:space-y-6 xl:space-y-8">
                    <c:if test="${orderItems.size()==0}">
                        <div class="flex justify-start item-start space-y-8 flex-col">
                            <div>
                                <h1 class="text-lg dark:text-white lg:text-xl font-normal leading-7 lg:leading-9 text-gray-800">Looks like you have not ordered anything yet!</h1>
                                <h5 class="text-sm dark:text-white font-normal leading-7 lg:leading-9 text-gray-800">First add books to your cart and then you can easily checkout with few clicks.</h5>
                            </div>
                            <a href="home" class="flex font-semibold text-indigo-600 text-sm mt-10">
                                <svg class="fill-current mr-2 text-indigo-600 w-4" viewBox="0 0 448 512"><path d="M134.059 296H436c6.627 0 12-5.373 12-12v-56c0-6.627-5.373-12-12-12H134.059v-46.059c0-21.382-25.851-32.09-40.971-16.971L7.029 239.029c-9.373 9.373-9.373 24.569 0 33.941l86.059 86.059c15.119 15.119 40.971 4.411 40.971-16.971V296z"/></svg>
                                Continue Shopping
                            </a>
                        </div>
                    </c:if>
                    <c:forEach var="order" items="${orders}">
                        <div class="flex flex-col justify-start items-start dark:bg-gray-800 bg-gray-50 px-4 py-4 md:py-6 md:p-6 xl:p-8 w-full rounded-md">
                            <div class="flex w-full text-lg md:text-xl dark:text-white font-semibold leading-6 xl:leading-5 text-gray-800 mb-2 justify-between">
                                <div class="flex items-center">
                                    <span>Order: #${order.id}</span>
                                    <span class="font-normal invisible sm:visible"> &nbsp; | &nbsp; </span>
                                    <div class="flex items-center mt-2 sm:mt-0">
                                        <span class="text-sm font-normal">Ordered on: ${order.order_date}</span>
                                    </div>
                                </div>
                                <div>
                                    <span class="text-sm font-semibold text-purple-600 hover:text-purple-800">View invoice</span>
                                </div>
                            </div>

                            <div class="flex justify-center flex-col md:flex-row flex-col items-stretch w-full space-y-4 md:space-y-0 md:space-x-6 xl:space-x-8 mb-4">
                                <div class="flex-col px-4 py-6 md:p-6 xl:p-8 w-full bg-gray-100 dark:bg-gray-800 space-y-2 rounded-md">

                                    <c:set var="total_shipping" value="${0}"/>
                                    <c:set var="total_tax" value="${0}"/>
                                    <c:forEach var="orderItem" items="${orderItems}">
                                        <c:if test="${orderItem.order_id == order.id}">
                                            <c:set var="total_shipping" value="${total_shipping + orderItem.shipping_amount}"/>
                                            <c:set var="total_tax" value="${total_tax + orderItem.tax_amount}"/>
                                            <div class="flex rounded border-b pb-2">
                                                <div class="w-16 rounded">
                                                    <img class="h-20 rounded" src="images/book_cover_photos/${orderItem.vendor_id}/${orderItem.book_cover_name}" alt="${orderItem.book_name}"/>                                                 
                                                </div>
                                                <div class="flex flex-col justify-between ml-4 flex-grow">
                                                    <div>
                                                        <p class="font-bold text-auto">${orderItem.book_name}</p> 
                                                        <span class="text-gray-600 text-xs font-semibold">NPR. ${orderItem.unit_price}</span> 
                                                    </div>
                                                    <div>
                                                        <span class="text-gray-600 text-xs">Quantity: ${orderItem.quantity}</span>                                                 
                                                    </div>
                                                </div>
                                            </div>
                                        </c:if>
                                    </c:forEach>

                                </div>

                                <div class="flex flex-col px-0 py-2 md:p-0 w-full dark:bg-gray-800 space-y-2 rounded-md">
                                    <div class="flex flex-col px-4 py-6 md:p-2 xl:p-3 w-full bg-white shadow-lg dark:bg-gray-800 space-y-4 md:space-y-3 rounded-md">
                                        <h3 class="text-xl dark:text-white font-semibold leading-5 text-gray-800">Summary</h3>
                                        <div class="flex justify-center items-center px-3 w-fulls space-y-4 md:space-y-3 flex-col border-gray-200 border-b pb-4">
                                            <div class="flex justify-between w-full">
                                                <p class="text-base dark:text-white leading-4 text-gray-800">Subtotal</p>
                                                <p class="text-base dark:text-gray-300 leading-4 text-gray-600">NPR. ${order.order_subtotal_amount}</p>
                                            </div>
                                            <div class="flex justify-between items-center w-full">
                                                <p class="text-base dark:text-white leading-4 text-gray-800">Discount</p>
                                                <p class="text-base dark:text-gray-300 leading-4 text-gray-600">NPR 0.0</p>
                                            </div>
                                            <div class="flex justify-between items-center w-full">
                                                <p class="text-base dark:text-white leading-4 text-gray-800">Shipping</p>
                                                <p class="text-base dark:text-gray-300 leading-4 text-gray-600">NPR. ${total_shipping}</p>
                                            </div>
                                            <div class="flex justify-between items-center w-full">
                                                <p class="text-base dark:text-white leading-4 text-gray-800">Tax amount</p>
                                                <p class="text-base dark:text-gray-300 leading-4 text-gray-600">NPR. ${total_tax}</p>
                                            </div>
                                        </div>
                                        <div class="flex px-3 justify-between items-center w-full">
                                            <p class="text-base dark:text-white font-semibold leading-4 text-gray-800">Total</p>
                                            <p class="text-base dark:text-gray-300 font-semibold leading-4 text-gray-600">NPR. ${order.order_total_amount}</p>
                                        </div>
                                        <div class="flex px-3 justify-between items-center w-full">
                                            <p class="text-normal dark:text-white font-semibold leading-4 text-gray-400">Payment method:  
                                                <span class="font-normal">
                                                    ${order.payment_method}
                                                </span>
                                            </p>
                                        </div>
                                    </div>
                                    <div class="flex flex-col justify-center px-4 py-6 md:p-2 xl:p-3 w-full bg-white shadow-lg dark:bg-gray-800 space-y-4 md:space-y-2 rounded-md">
                                        <h3 class="text-xl dark:text-white font-semibold leading-5 text-gray-800">Shipping</h3>
                                        <div class="flex justify-between items-start w-full">
                                            <div class="flex justify-center items-center space-x-4 md:space-x-2">
                                                <div class="flex flex-col justify-start items-center">
                                                    <p class="text-normal leading-6 dark:text-white font-semibold text-gray-800 px-3">Address<br />
                                                        <span class="font-normal">
                                                            <c:if test="${order.shipping_postcode != null && order.shipping_postcode != 0}">
                                                                ${order.shipping_postcode}
                                                            </c:if>
                                                            <c:if test='${order.shipping_apartment != null && order.shipping_apartment != ""}'>
                                                                ${order.shipping_apartment}, 
                                                            </c:if>
                                                            ${order.shipping_street}, ${order.shipping_city}, 
                                                            <c:if test='${order.shipping_province != null && order.shipping_province != ""}'>
                                                                ${order.shipping_province}, 
                                                            </c:if>
                                                            ${order.shipping_country}
                                                        </span>
                                                    </p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="flex justify-between items-start w-full">
                                            <div class="flex justify-center items-center space-x-2">
                                                <div class="flex flex-col justify-start items-center">
                                                    <p class="text-normal leading-6 dark:text-white font-semibold text-gray-800 ml-3">Method: 
                                                        <span class="font-normal">
                                                            ${order.shipping_method_name}
                                                        </span>
                                                    </p>
                                                </div>
                                            </div>
                                        </div>
                                        <!--                                        <div class="w-full flex justify-center items-center">
                                                                                    <button class="hover:bg-black dark:bg-white dark:text-gray-800 dark:hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-gray-800 py-5 w-96 md:w-full bg-gray-800 text-base font-medium leading-4 text-white">View Carrier Details</button>
                                                                                </div>-->
                                    </div>
                                </div>
                            </div>

                            <!--Progress bar-->
                            <p class="text-lg md:text-xl dark:text-white font-semibold leading-6 xl:leading-5 text-gray-800 mb-2">Status bar </p>
                            <div class="w-full lg:w-full mx-auto p-6">
                                <div class="bg-gray-200 dark:bg-gray-700 h-1 flex items-center justify-between">
                                    <div class="w-1/3 bg-indigo-700 h-1 flex items-center">
                                        <div class="bg-indigo-700 h-6 w-6 rounded-full shadow flex items-center justify-center">
                                            <img src="https://tuk-cdn.s3.amazonaws.com/can-uploader/thin_with_steps-svg1.svg" alt="check"/>
                                        </div>
                                    </div>
                                    <div class="w-1/3 flex justify-between bg-indigo-700 h-1 items-center relative">
                                        <!--                                        <div class="absolute right-0 -mr-2">
                                                                                    <div class="relative bg-white dark:bg-gray-800 shadow-lg px-2 py-1 rounded mt-16 -mr-12">
                                                                                        <svg class="absolute top-0 -mt-1 w-full right-0 left-0 text-white dark:text-gray-800" width="16px" height="8px" viewBox="0 0 16 8" version="1.1" xmlns="http://www.w3.org/2000/svg">
                                                                                        <g id="Page-1" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                                                                                        <g id="Progress-Bars" transform="translate(-322.000000, -198.000000)" fill="currentColor">
                                                                                        <g id="Group-4" transform="translate(310.000000, 198.000000)">
                                                                                        <polygon id="Triangle" points="20 0 28 8 12 8"></polygon>
                                                                                        </g>
                                                                                        </g>
                                                                                        </g>
                                                                                        </svg>
                                                                                        <p tabindex="0" class="focus:outline-none text-indigo-700 dark:text-indigo-400 text-xs font-bold">Step 3: Analyzing</p>
                                                                                    </div>
                                                                                </div>-->
                                        <div class="bg-indigo-700 h-6 w-6 rounded-full shadow flex items-center justify-center -ml-2">
                                            <img src="https://tuk-cdn.s3.amazonaws.com/can-uploader/thin_with_steps-svg1.svg" alt="check"/>
                                        </div>
                                        <!--                                        <div class="bg-white dark:bg-gray-700 h-6 w-6 rounded-full shadow flex items-center justify-center -mr-3 relative">
                                                                                    <div class="h-3 w-3 bg-indigo-700 rounded-full"></div>
                                                                                </div>-->
                                        <div class="bg-indigo-700 dark:bg-gray-700 h-6 w-6 rounded-full shadow flex items-center justify-center -mr-3 relative">
                                            <img src="https://tuk-cdn.s3.amazonaws.com/can-uploader/thin_with_steps-svg1.svg" alt="check"/>
                                        </div>
                                    </div>
                                    <div class="w-1/3 flex justify-end bg-indigo-700 h-1">

                                        <!--                                        <div class="bg-indigo-700 h-6 w-6 rounded-full shadow flex items-center justify-center">
                                                                                    <img src="https://tuk-cdn.s3.amazonaws.com/can-uploader/thin_with_steps-svg1.svg" alt="check"/>
                                                                                </div>-->
                                    </div>
                                    <div class="bg-indigo-700 dark:bg-gray-700 h-6 w-6 rounded-full shadow flex items-center justify-center">
                                        <img src="https://tuk-cdn.s3.amazonaws.com/can-uploader/thin_with_steps-svg1.svg" alt="check"/>
                                    </div>
                                </div>
                            </div>
                            <!--progress bar ends-->

                        </div>
                    </c:forEach>

                </div>


                <div class="bg-gray-50 dark:bg-gray-800 w-full xl:w-96 flex justify-between items-center md:items-start px-4 py-6 md:p-6 xl:p-8 flex-col">
                    <h3 class="text-xl dark:text-white font-semibold leading-5 text-gray-800">Profile</h3>
                    <div class="flex flex-col md:flex-row xl:flex-col justify-start items-stretch h-full w-full md:space-x-6 lg:space-x-8 xl:space-x-0">
                        <div class="flex flex-col justify-start items-start flex-shrink-0">
                            <div class="flex justify-center w-full md:justify-start md:items-center items-center space-x-4 py-8 border-b border-gray-200">
                                <div class=" w-16 h-16 rounded-lg">
                                    <c:if test='${user.profile_pic_name == null}'>
                                        <img src="./images/static/general_images/empty_profile_pic.png" alt="" class="rounded-lg h-auto w-full"/>
                                    </c:if>
                                    <c:if test='${user.profile_pic_name != null}'>
                                        <img src="./images/user_profiles/${user.profile_pic_name}" alt="${user.firstname}" class="rounded-lg h-auto w-full"/>
                                    </c:if> 
                                </div>
                                <div class="flex justify-start items-start flex-col space-y-2">
                                    <p class="text-base dark:text-white font-semibold leading-4 text-left text-gray-800">${user.firstname} ${user.lastname}</p>
                                    <p class="text-sm dark:text-gray-300 leading-5 text-gray-600">${orders.size()} Previous Orders</p>
                                </div>
                            </div>

                            <div class="flex justify-center text-gray-800 dark:text-white md:justify-start items-center space-x-4 py-4 border-b border-gray-200 w-full">
                                <img class="dark:hidden" src="https://tuk-cdn.s3.amazonaws.com/can-uploader/order-summary-3-svg1.svg" alt="email">
                                <img class="hidden dark:block" src="https://tuk-cdn.s3.amazonaws.com/can-uploader/order-summary-3-svg1dark.svg" alt="email">
                                <p class="cursor-pointer text-sm leading-5 ">${user.email}</p>
                            </div>
                        </div>
                        <div class="flex justify-between xl:h-full items-stretch w-full flex-col mt-6 md:mt-0 space-y-4">
                            <div class="flex justify-center md:justify-start xl:flex-col flex-col md:space-x-6 lg:space-x-8 xl:space-x-0 space-y-4 xl:space-y-6 md:space-y-0 md:flex-row items-center md:items-start">
                                <div class="flex justify-center md:justify-start items-center md:items-start flex-col space-y-3 xl:mt-8">
                                    <p class="text-base dark:text-white font-semibold leading-4 text-center md:text-left text-gray-800">Shipping Address</p>
                                    <c:if test="${addresses.size()== 0}">
                                        <div class="flex items-center w-full">
                                            No address found!
                                        </div>
                                    </c:if>
                                    <c:forEach var="address" items="${addresses}">
                                        <a href="updateProfile">
                                            <div class="drop-shadow-md cursor-pointer rounded-md hover:bg-white p-2 text-sm font-light" title="Edit this address">
                                                <div class="flex">
                                                    <c:if test="${address.postal_code != null && address.postal_code != 0}">
                                                        ${address.postal_code} - 
                                                    </c:if>
                                                    ${address.street},
                                                    <c:if test='${address.apartment != null && address.apartment != ""}'>
                                                        ${address.apartment}, 
                                                    </c:if>
                                                    ${address.city_name}, ${address.province_name}, ${address.country_name}
                                                </div>
                                            </div>
                                        </a>
                                    </c:forEach>
                                </div>
                                <div class="flex justify-center md:justify-start items-center md:items-start flex-col space-y-4">
                                    <p class="w-48 lg:w-full dark:text-gray-300 xl:w-48 text-center md:text-left text-sm font_normal leading-5 text-gray-600 text-justified">NOTE: Shipping and billing address are same for all orders.</p>
                                </div>
                            </div>
                            <div class="flex w-full justify-center items-center md:justify-start md:items-start">
                                <a href="updateProfile" class="w-full"><button class="mt-6 md:mt-0 dark:border-white dark:hover:bg-gray-900 dark:bg-transparent dark:text-white py-5 hover:bg-purple-600 hover:text-white focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-gray-800 border border-purple-600 font-medium w-96 2xl:w-full text-base font-medium leading-4 text-gray-800 rounded-md">
                                        Edit Details
                                    </button></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!--footer section-->
        <jsp:include page="footer.html"/>
        <!--footer section ends-->

    </body>
</html>
