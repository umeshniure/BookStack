<%-- 
    Document   : user-order-history
    Created on : Oct 23, 2022, 1:17:10 PM
    Author     : Umesh
--%>

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

        <div class="py-14 px-4 md:px-6 2xl:px-20 2xl:container 2xl:mx-auto">
            <div class="flex justify-start item-start space-y-2 flex-col">
                <h1 class="text-3xl dark:text-white lg:text-4xl font-semibold leading-7 lg:leading-9 text-gray-800">Order #13432</h1>
                <p class="text-base dark:text-gray-300 font-medium leading-6 text-gray-600">21st Mart 2021 at 10:34 PM</p>
            </div> 
            <div class="mt-10 flex flex-col xl:flex-row jusitfy-center items-stretch w-full xl:space-x-8 space-y-4 md:space-y-6 xl:space-y-0">
                <div class="flex flex-col justify-start items-start w-full space-y-4 md:space-y-6 xl:space-y-8">
                    <div class="flex flex-col justify-start items-start dark:bg-gray-800 bg-gray-50 px-4 py-4 md:py-6 md:p-6 xl:p-8 w-full rounded-md">
                        <div class="flex w-full text-lg md:text-xl dark:text-white font-semibold leading-6 xl:leading-5 text-gray-800 mb-2 justify-between">
                            <div class="flex items-center">
                                <span>Order: #xCW0LetSmA</span>
                                <span class="font-normal invisible sm:visible"> &nbsp; | &nbsp; </span>
                                <div class="flex items-center mt-2 sm:mt-0">
                                    <span class="text-sm font-normal">Ordered on: Sept 23, 2022</span>
                                </div>
                            </div>
                            <div>
                                <span class="text-sm font-semibold text-purple-600 hover:text-purple-800">View invoice</span>
                            </div>
                        </div>

                        <div class="flex justify-center flex-col md:flex-row flex-col items-stretch w-full space-y-4 md:space-y-0 md:space-x-6 xl:space-x-8 mb-4">
                            <div class="flex flex-col px-4 py-6 md:p-6 xl:p-8 w-full bg-gray-100 dark:bg-gray-800 space-y-2 rounded-md">
                                <div class="flex rounded border-b pb-2"> <!-- product -->
                                    <div class="w-20 rounded">
                                        <img class="h-24 rounded" src="https://edit.org/photos/images/cat/book-covers-big-2019101610.jpg-1300.jpg" alt="<c:out value="${cartItem.book_name}"/>                                                 
                                    </div>
                                    <div class="flex flex-col justify-between ml-4 flex-grow">
                                        <div>
                                            <p class="font-bold text-auto">The Subtle Art of not Giving a fuck </p> 
                                            <span class="text-gray-600 text-xs font-semibold">NPR. 430.00</span> 
                                        </div>
                                        <div>
                                            <span class="text-gray-600 text-xs">Quantity: 1</span>                                                 
                                        </div>
                                    </div>
                                </div>
                                <div class="flex rounded pb-2"> <!-- product -->
                                    <div class="w-20 rounded">
                                        <img class="h-24 rounded" src="https://edit.org/photos/images/cat/book-covers-big-2019101610.jpg-1300.jpg" alt="<c:out value="${cartItem.book_name}"/>                                                 
                                    </div>
                                    <div class="flex flex-col justify-between ml-4 flex-grow">
                                        <div>
                                            <p class="font-bold text-auto">The Subtle Art of not Giving a fuck </p> 
                                            <span class="text-gray-600 text-xs font-semibold">NPR. 430.00</span> 
                                        </div>
                                        <div>
                                            <span class="text-gray-600 text-xs">Quantity: 1</span>                                                 
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="flex flex-col px-4 py-6 md:p-6 xl:p-8 w-full bg-gray-100 dark:bg-gray-800 space-y-6 rounded-md">
                                <h3 class="text-xl dark:text-white font-semibold leading-5 text-gray-800">Summary</h3>
                                <div class="flex justify-center items-center w-full space-y-4 flex-col border-gray-200 border-b pb-4">
                                    <div class="flex justify-between w-full">
                                        <p class="text-base dark:text-white leading-4 text-gray-800">Subtotal</p>
                                        <p class="text-base dark:text-gray-300 leading-4 text-gray-600">$56.00</p>
                                    </div>
                                    <div class="flex justify-between items-center w-full">
                                        <p class="text-base dark:text-white leading-4 text-gray-800">Discount <span class="bg-gray-200 p-1 text-xs font-medium dark:bg-white dark:text-gray-800 leading-3 text-gray-800">STUDENT</span></p>
                                        <p class="text-base dark:text-gray-300 leading-4 text-gray-600">-$28.00 (50%)</p>
                                    </div>
                                    <div class="flex justify-between items-center w-full">
                                        <p class="text-base dark:text-white leading-4 text-gray-800">Shipping</p>
                                        <p class="text-base dark:text-gray-300 leading-4 text-gray-600">$8.00</p>
                                    </div>
                                </div>
                                <div class="flex justify-between items-center w-full">
                                    <p class="text-base dark:text-white font-semibold leading-4 text-gray-800">Total</p>
                                    <p class="text-base dark:text-gray-300 font-semibold leading-4 text-gray-600">$36.00</p>
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
                                    <div class="absolute right-0 -mr-2">
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
                                    </div>
                                    <div class="bg-indigo-700 h-6 w-6 rounded-full shadow flex items-center justify-center -ml-2">
                                        <img src="https://tuk-cdn.s3.amazonaws.com/can-uploader/thin_with_steps-svg1.svg" alt="check"/>
                                    </div>
                                    <div class="bg-white dark:bg-gray-700 h-6 w-6 rounded-full shadow flex items-center justify-center -mr-3 relative">
                                        <div class="h-3 w-3 bg-indigo-700 rounded-full"></div>
                                    </div>
                                </div>
                                <div class="w-1/3 flex justify-end">
                                    <div class="bg-white dark:bg-gray-700 h-6 w-6 rounded-full shadow"></div>
                                </div>
                            </div>
                        </div>
                        <!--progress bar ends-->

                    </div>
                                    
                    <div class="flex justify-center flex-col md:flex-row flex-col items-stretch w-full space-y-4 md:space-y-0 md:space-x-6 xl:space-x-8">
                        <div class="flex flex-col px-4 py-6 md:p-6 xl:p-8 w-full bg-gray-50 dark:bg-gray-800 space-y-6">
                            <h3 class="text-xl dark:text-white font-semibold leading-5 text-gray-800">Summary</h3>
                            <div class="flex justify-center items-center w-full space-y-4 flex-col border-gray-200 border-b pb-4">
                                <div class="flex justify-between w-full">
                                    <p class="text-base dark:text-white leading-4 text-gray-800">Subtotal</p>
                                    <p class="text-base dark:text-gray-300 leading-4 text-gray-600">$56.00</p>
                                </div>
                                <div class="flex justify-between items-center w-full">
                                    <p class="text-base dark:text-white leading-4 text-gray-800">Discount <span class="bg-gray-200 p-1 text-xs font-medium dark:bg-white dark:text-gray-800 leading-3 text-gray-800">STUDENT</span></p>
                                    <p class="text-base dark:text-gray-300 leading-4 text-gray-600">-$28.00 (50%)</p>
                                </div>
                                <div class="flex justify-between items-center w-full">
                                    <p class="text-base dark:text-white leading-4 text-gray-800">Shipping</p>
                                    <p class="text-base dark:text-gray-300 leading-4 text-gray-600">$8.00</p>
                                </div>
                            </div>
                            <div class="flex justify-between items-center w-full">
                                <p class="text-base dark:text-white font-semibold leading-4 text-gray-800">Total</p>
                                <p class="text-base dark:text-gray-300 font-semibold leading-4 text-gray-600">$36.00</p>
                            </div>
                        </div>
                        <div class="flex flex-col justify-center px-4 py-6 md:p-6 xl:p-8 w-full bg-gray-50 dark:bg-gray-800 space-y-6">
                            <h3 class="text-xl dark:text-white font-semibold leading-5 text-gray-800">Shipping</h3>
                            <div class="flex justify-between items-start w-full">
                                <div class="flex justify-center items-center space-x-4">
                                    <div class="w-8 h-8">
                                        <img class="w-full h-full" alt="logo" src="https://i.ibb.co/L8KSdNQ/image-3.png" />
                                    </div>
                                    <div class="flex flex-col justify-start items-center">
                                        <p class="text-lg leading-6 dark:text-white font-semibold text-gray-800">DPD Delivery<br /><span class="font-normal">Delivery with 24 Hours</span></p>
                                    </div>
                                </div>
                                <p class="text-lg font-semibold leading-6 dark:text-white text-gray-800">$8.00</p>
                            </div>
                            <div class="w-full flex justify-center items-center">
                                <button class="hover:bg-black dark:bg-white dark:text-gray-800 dark:hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-gray-800 py-5 w-96 md:w-full bg-gray-800 text-base font-medium leading-4 text-white">View Carrier Details</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="bg-gray-50 dark:bg-gray-800 w-full xl:w-96 flex justify-between items-center md:items-start px-4 py-6 md:p-6 xl:p-8 flex-col">
                    <h3 class="text-xl dark:text-white font-semibold leading-5 text-gray-800">Customer</h3>
                    <div class="flex flex-col md:flex-row xl:flex-col justify-start items-stretch h-full w-full md:space-x-6 lg:space-x-8 xl:space-x-0">
                        <div class="flex flex-col justify-start items-start flex-shrink-0">
                            <div class="flex justify-center w-full md:justify-start items-center space-x-4 py-8 border-b border-gray-200">
                                <img src="https://i.ibb.co/5TSg7f6/Rectangle-18.png" alt="avatar" />
                                <div class="flex justify-start items-start flex-col space-y-2">
                                    <p class="text-base dark:text-white font-semibold leading-4 text-left text-gray-800">David Kent</p>
                                    <p class="text-sm dark:text-gray-300 leading-5 text-gray-600">10 Previous Orders</p>
                                </div>
                            </div>

                            <div class="flex justify-center text-gray-800 dark:text-white md:justify-start items-center space-x-4 py-4 border-b border-gray-200 w-full">
                                <img class="dark:hidden" src="https://tuk-cdn.s3.amazonaws.com/can-uploader/order-summary-3-svg1.svg" alt="email">
                                <img class="hidden dark:block" src="https://tuk-cdn.s3.amazonaws.com/can-uploader/order-summary-3-svg1dark.svg" alt="email">
                                <p class="cursor-pointer text-sm leading-5 ">david89@gmail.com</p>
                            </div>
                        </div>
                        <div class="flex justify-between xl:h-full items-stretch w-full flex-col mt-6 md:mt-0">
                            <div class="flex justify-center md:justify-start xl:flex-col flex-col md:space-x-6 lg:space-x-8 xl:space-x-0 space-y-4 xl:space-y-12 md:space-y-0 md:flex-row items-center md:items-start">
                                <div class="flex justify-center md:justify-start items-center md:items-start flex-col space-y-4 xl:mt-8">
                                    <p class="text-base dark:text-white font-semibold leading-4 text-center md:text-left text-gray-800">Shipping Address</p>
                                    <p class="w-48 lg:w-full dark:text-gray-300 xl:w-48 text-center md:text-left text-sm leading-5 text-gray-600">180 North King Street, Northhampton MA 1060</p>
                                </div>
                                <div class="flex justify-center md:justify-start items-center md:items-start flex-col space-y-4">
                                    <p class="text-base dark:text-white font-semibold leading-4 text-center md:text-left text-gray-800">Billing Address</p>
                                    <p class="w-48 lg:w-full dark:text-gray-300 xl:w-48 text-center md:text-left text-sm leading-5 text-gray-600">180 North King Street, Northhampton MA 1060</p>
                                </div>
                            </div>
                            <div class="flex w-full justify-center items-center md:justify-start md:items-start">
                                <button class="mt-6 md:mt-0 dark:border-white dark:hover:bg-gray-900 dark:bg-transparent dark:text-white py-5 hover:bg-gray-200 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-gray-800 border border-gray-800 font-medium w-96 2xl:w-full text-base font-medium leading-4 text-gray-800">Edit Details</button>
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
