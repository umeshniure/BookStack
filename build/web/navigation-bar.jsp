<%-- 
    Document   : navigation-bar
    Created on : Aug 6, 2022, 6:20:48 PM
    Author     : Umesh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="bg-gray-100 px-2 sm:px-4 py-2.5 mb-2 rounded shadow-md">
    <div class="container flex flex-wrap justify-between items-center mx-auto rounded">
        <a href="home" >
            <div class="flex items-center h-20 w-20">
                <img src="images/bookstack-logo.png" class="ml-4 h-full w-auto" alt="Bookstack Logo">
                    <!--<span class="self-center text-xl font-semibold whitespace-nowrap dark:text-grey">Bookstack</span>-->
            </div>
        </a>
        <c:if test="${sessionScope.id == null}">
            <div class="flex md:order-2 space-x-5">
                <a href="signup"><button type="button" class="text-purple-700 bg-gray-200 hover:bg-gray-300 hover:text-purple-800 font-medium rounded-lg text-sm px-5 py-2.5 text-center mr-3 md:mr-0 md:visible sm:invisible">Register</button></a>
                <a href="login"><button type="button" class="text-white bg-purple-700 hover:bg-purple-800 font-medium rounded-lg text-sm px-5 py-2.5 text-center mr-3 md:mr-0">Log in</button></a>
                <button data-collapse-toggle="navbar-cta" type="button" class="inline-flex items-center p-2 text-sm text-gray-500 rounded-lg md:hidden hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-gray-200 dark:text-gray-400 dark:hover:bg-gray-700 dark:focus:ring-gray-600" aria-controls="navbar-cta" aria-expanded="false">
                    <span class="sr-only">Open main menu</span>
                    <svg class="w-6 h-6" aria-hidden="true" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg" style="--darkreader-inline-fill: currentColor;" data-darkreader-inline-fill=""><path fill-rule="evenodd" d="M3 5a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 10a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 15a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1z" clip-rule="evenodd"></path></svg>
                </button>
            </div>
        </c:if>
        <c:if test="${sessionScope.id != null}">

            <div class="flex md:order-2 space-x-5 items-center">
                <a href="cart"><div class="flex -space-x-2 overflow-hidden hover:text-purple-500" title="My cart">
                        <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-8 h-8">
                            <path stroke-linecap="round" stroke-linejoin="round" d="M15.75 10.5V6a3.75 3.75 0 10-7.5 0v4.5m11.356-1.993l1.263 12c.07.665-.45 1.243-1.119 1.243H4.25a1.125 1.125 0 01-1.12-1.243l1.264-12A1.125 1.125 0 015.513 7.5h12.974c.576 0 1.059.435 1.119 1.007zM8.625 10.5a.375.375 0 11-.75 0 .375.375 0 01.75 0zm7.5 0a.375.375 0 11-.75 0 .375.375 0 01.75 0z" />
                        </svg>
                    </div></a>
                <div class="flex -space-x-2 overflow-hidden">
                    <c:if test="${user.profile_pic_name == null}">
                        <img  data-popover-target="popover-user-profile" title="My profile" class="inline-block h-10 w-10 rounded-full ring-2 ring-white" src="https://www.pngitem.com/pimgs/m/24-248235_user-profile-avatar-login-account-fa-user-circle.png" alt="">
                        </c:if>
                        <c:if test="${user.profile_pic_name != null}">
                            <img  data-popover-target="popover-user-profile" title="My profile" class="inline-block h-10 w-10 rounded-full ring-2 ring-white" src="images/user_profiles/${user.profile_pic_name}" alt="">
                            </c:if>

                            <!--profile cards-->
                            <div data-popover id="popover-user-profile" role="tooltip" class="inline-block absolute invisible z-40 w-96 text-sm font-light text-gray-500 bg-white rounded-lg border border-gray-200 shadow-sm opacity-0 transition-opacity duration-300 dark:text-gray-400 dark:bg-gray-800 dark:border-gray-600">

                                <div class="bg-white shadow rounded-lg">
                                    <div class="flex justify-center">
                                        <c:if test="${user.profile_pic_name == null}">
                                            <img src="https://www.pngitem.com/pimgs/m/24-248235_user-profile-avatar-login-account-fa-user-circle.png" alt="" class="rounded-full mx-auto absolute -top-20 w-32 h-32 shadow-md border-4 border-white transition duration-200 transform hover:scale-110">
                                            </c:if>
                                            <c:if test="${user.profile_pic_name != null}">
                                                <img src="images/user_profiles/${user.profile_pic_name}" alt="" class="rounded-full mx-auto absolute -top-20 w-32 h-32 shadow-md border-4 border-white transition duration-200 transform hover:scale-110">
                                                </c:if>
                                                </div>

                                                <div class="mt-16">
                                                    <h1 class="font-bold text-center text-3xl text-gray-900">${user.firstname} ${user.lastname}</h1>
                                                    <p class="text-center text-sm text-gray-400 font-medium">${user.email}</p>
                                                    <p class="text-center text-sm text-gray-400 font-medium">${user.phone_number}</p>
                                                    <p>
                                                        <span>

                                                        </span>
                                                    </p>
                                                    <div class="my-5 px-6">
                                                        <a href="#" class="text-gray-100 block rounded-lg text-center font-medium leading-6 px-6 py-3 bg-purple-600 hover:bg-purple-700 hover:text-white">Edit Profile</span></a>
                                                    </div>
                                                    <div class="flex justify-between items-center my-5 px-6">
                                                        <a href="#" class="text-gray-500 hover:text-gray-900 hover:bg-gray-100 rounded transition duration-150 ease-in font-medium text-sm text-center w-full py-3">My orders</a>
                                                        <a href="#" class="text-gray-500 hover:text-gray-900 hover:bg-gray-100 rounded transition duration-150 ease-in font-medium text-sm text-center w-full py-3">Order history</a>
                                                        <a href="#" class="text-gray-500 hover:text-gray-900 hover:bg-gray-100 rounded transition duration-150 ease-in font-medium text-sm text-center w-full py-3">My wishlist</a>
                                                        <!--<a href="" class="text-gray-500 hover:text-gray-900 hover:bg-gray-100 rounded transition duration-150 ease-in font-medium text-sm text-center w-full py-3">Email</a>-->
                                                    </div>

                                                    <div class="w-full">
                                                        <h3 class="font-medium text-gray-900 text-left px-6">Shipping information</h3>
                                                        <div class="mt-5 w-full flex flex-col items-center overflow-hidden text-sm">
                                                            <a href="#" class="w-full border-t border-gray-100 text-gray-600 py-4 pl-6 pr-3 w-full block hover:bg-gray-100 transition duration-150">
                                                                <img src="https://avatars0.githubusercontent.com/u/35900628?v=4" alt="" class="rounded-full h-6 shadow-md inline-block mr-2">
                                                                    Updated his status
                                                                    <span class="text-gray-500 text-xs">24 min ago</span>
                                                            </a>

                                                            <a href="#" class="w-full border-t border-gray-100 text-gray-600 py-4 pl-6 pr-3 w-full block hover:bg-gray-100 transition duration-150">
                                                                <img src="https://avatars0.githubusercontent.com/u/35900628?v=4" alt="" class="rounded-full h-6 shadow-md inline-block mr-2">
                                                                    Added new profile picture
                                                                    <span class="text-gray-500 text-xs">42 min ago</span>
                                                            </a>

                                                            <a href="#" class="w-full border-t border-gray-100 text-gray-600 py-4 pl-6 pr-3 w-full block hover:bg-gray-100 transition duration-150">
                                                                <img src="https://avatars0.githubusercontent.com/u/35900628?v=4" alt="" class="rounded-full h-6 shadow-md inline-block mr-2">
                                                                    Posted new article in <span class="font-bold">#Web Dev</span>
                                                                    <span class="text-gray-500 text-xs">49 min ago</span>
                                                            </a>
                                                        </div>
                                                    </div>
                                                    <div class="my-5 px-6">
                                                        <a href="logout" class="text-gray-100 block rounded-lg text-center font-medium leading-6 px-6 py-3 bg-purple-600 hover:bg-purple-700 hover:text-white">LogOut</span></a>
                                                    </div>
                                                </div>
                                                </div>

                                                <!--                            <div class="p-3">
                                                                                <div class="flex justify-between items-center mb-2">
                                                                                    <a href="#">
                                                                                        <img class="w-10 h-10 rounded-full" src="/docs/images/people/profile-picture-1.jpg" alt="user profile">
                                                                                    </a>
                                                                                    <div>
                                                                                        <button type="button" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-xs px-3 py-1.5 dark:bg-blue-600 dark:hover:bg-blue-700 focus:outline-none dark:focus:ring-blue-800">Edit</button>
                                                                                    </div>
                                                                                </div>
                                                                                <p class="text-base font-semibold leading-none text-gray-900 dark:text-white">
                                                                                    <a href="#">${user.firstname}</a>
                                                                                </p>
                                                                                <p class="mb-3 text-sm font-normal">
                                                                                    <a href="#" class="hover:underline">${user.email}</a>
                                                                                </p>
                                                                                <p class="mb-4 text-sm font-light">Open-source contributor. Building <a href="#" class="text-blue-600 dark:text-blue-500 hover:underline">flowbite.com</a>.</p>
                                                                                <ul class="flex text-sm font-light">
                                                                                    <li class="mr-2">
                                                                                        <a href="#" class="hover:underline">
                                                                                            <span class="font-semibold text-gray-900 dark:text-white">799</span>
                                                                                            <spa>Following</span>
                                                                                        </a>
                                                                                    </li>
                                                                                    <li>
                                                                                        <a href="#" class="hover:underline">
                                                                                            <span class="font-semibold text-gray-900 dark:text-white">3,758</span>
                                                                                            <span>Followers</span>
                                                                                        </a>
                                                                                    </li>
                                                                                </ul>
                                                                                <a href="logout"><button type="button" class="w-full bg-purple-600 rounded text-white inline-block">Log out</button> </a>
                                                                            </div>-->
                                                <div data-popper-arrow></div>
                                                </div>
                                                <!--profile card ends-->

                                                </div>
                                                <button data-collapse-toggle="navbar-cta" type="button" class="inline-flex items-center p-2 text-sm text-gray-500 rounded-lg md:hidden hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-gray-200 dark:text-gray-400 dark:hover:bg-gray-700 dark:focus:ring-gray-600" aria-controls="navbar-cta" aria-expanded="false">
                                                    <span class="sr-only">Open main menu</span>
                                                    <svg class="w-6 h-6" aria-hidden="true" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg" style="--darkreader-inline-fill: currentColor;" data-darkreader-inline-fill=""><path fill-rule="evenodd" d="M3 5a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 10a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 15a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1z" clip-rule="evenodd"></path></svg>
                                                </button>
                                                </div>
                                            </c:if>
                                            <div class="hidden justify-between items-center w-full md:flex md:w-auto md:order-1" id="navbar-cta">
                                                <ul class="flex flex-col p-4 rounded-lg md:flex-row md:space-x-8 md:mt-0 md:text-auto md:font-medium md:bg-white">
                                                    <li>
                                                        <a href="home" class="block py-2 pr-4 pl-3 text-gray-200 bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white" aria-current="page">Home</a>
                                                    </li>
                                                    <li>
                                                        <a href="#" class="block py-2 pr-4 pl-3 text-gray-700 rounded hover:bg-gray-100 md:hover:bg-transparent md:hover:text-blue-700 md:p-0 md:dark:hover:text-white dark:text-gray-400 dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent dark:border-gray-700">About</a>
                                                    </li>
                                                    <li>
                                                        <a href="#" class="block py-2 pr-4 pl-3 text-gray-700 rounded hover:bg-gray-100 md:hover:bg-transparent md:hover:text-blue-700 md:p-0 md:dark:hover:text-white dark:text-gray-400 dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent dark:border-gray-700">Services</a>
                                                    </li>
                                                    <li>
                                                        <a href="#" class="block py-2 pr-4 pl-3 text-gray-700 rounded hover:bg-gray-100 md:hover:bg-transparent md:hover:text-blue-700 md:p-0 md:dark:hover:text-white dark:text-gray-400 dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent dark:border-gray-700">Contact</a>
                                                    </li>
                                                    <li>
                                                        <a href="vendor_registration" class="block py-2 pr-4 pl-3 text-gray-700 rounded hover:bg-gray-100 md:hover:bg-transparent md:hover:text-blue-700 md:p-0 md:dark:hover:text-white dark:text-gray-400 dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent dark:border-gray-700">Sell on bookstack</a>
                                                    </li>
                                                </ul>
                                            </div>
                                            </div>
                                            </nav>
