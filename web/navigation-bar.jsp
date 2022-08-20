<%-- 
    Document   : navigation-bar
    Created on : Aug 6, 2022, 6:20:48 PM
    Author     : Umesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<script src="https://cdn.tailwindcss.com"></script>-->
        <title>Home</title>
    </head>
    <body>
        <!--
                Top Navigation bar section
                <nav class="navbar navbar-expand-lg bg-light">
                    <div class="container-fluid">
                        <a class="navbar-brand" href="home">Bookstack</a>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarNav">
                            <ul class="navbar-nav">
                                <li class="nav-item">
                                    <a class="nav-link" aria-current="page" href="home">Home</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="login">login</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="signup">signup</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="ValidateVendorRegistration">Sell on bookstack</a>
                                </li>
                            </ul>
                        </div>                
                    </div>            
                </nav> 
                Top Navigation bar section
        -->


        <!-- This example requires Tailwind CSS v2.0+ -->
        <nav class="bg-gray-100">
            <div class="max-w-7xl mx-auto px-2 sm:px-6 lg:px-8 shadow-7-strong">
                <div class="relative flex items-center justify-between h-16">
                    <div class="absolute inset-y-0 left-0 flex items-center sm:hidden">
                        <!-- Mobile menu button-->
                        <button type="button" class="inline-flex items-center justify-center p-2 rounded-md text-gray-400 hover:text-white hover:bg-gray-700 focus:outline-none focus:ring-2 focus:ring-inset focus:ring-white" aria-controls="mobile-menu" aria-expanded="false">
                            <span class="sr-only">Open main menu</span>
                            <svg class="block h-6 w-6" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" aria-hidden="true">
                            <path stroke-linecap="round" stroke-linejoin="round" d="M4 6h16M4 12h16M4 18h16" />
                            </svg>
                            <svg class="hidden h-6 w-6" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" aria-hidden="true">
                            <path stroke-linecap="round" stroke-linejoin="round" d="M6 18L18 6M6 6l12 12" />
                            </svg>
                        </button>
                    </div>
                    <div class="flex-1 flex items-center justify-center sm:items-stretch sm:justify-start">
                        <div class="flex-shrink-0 flex items-center">
                            <a href="home">
                                <img class="block lg:hidden h-12 w-full" src="images/bookstack-logo.png" alt="Bookstack">
                                <img class="hidden lg:block h-12 w-full" src="images/bookstack-logo.png" alt="Bookstack">
                            </a>
                        </div>
                        <div class="hidden sm:block sm:ml-6">
                            <div class="flex space-x-4">
                                <!-- Current: "bg-gray-900 text-white", Default: "text-gray-300 hover:bg-gray-700 hover:text-white" -->
                                <a href="#" class="text-black-900 hover:text-purple px-3 py-2 rounded-md text-sm font-medium" aria-current="page">Dashboard</a>

                                <a href="#" class="text-black-900 hover:text-purple px-3 py-2 rounded-md text-sm font-medium">Team</a>

                                <a href="#" class="text-black-900 hover:text-purple px-3 py-2 rounded-md text-sm font-medium">Projects</a>

                                <a href="#" class="text-black-900 hover:text-purple px-3 py-2 rounded-md text-sm font-medium">Calendar</a>

                                <a class="text-black-900 hover:text-purple px-3 py-2 rounded-md text-sm font-medium" href="vendor_registration">Sell on bookstack</a>

                                <a class="text-black-900 hover:text-purple px-3 py-2 rounded-md text-sm font-medium" href="#"><%=session.getAttribute("id")%> </a>
                                <a class="text-black-900 hover:text-purple px-3 py-2 rounded-md text-sm font-medium" href="#"><%=session.getAttribute("user_type")%> </a>
                            </div>
                        </div>
                    </div>

                    <c:if test="${request.getSession(false).getAttribute('user_type') == null}">
                        <div class="absolute inset-y-0 right-0 flex items-center pr-2 sm:static sm:inset-auto sm:ml-6 sm:pr-0">
                            <div class="hidden md:flex items-center justify-end md:flex-1 lg:w-0">
                                <a href="login" class="whitespace-nowrap text-base font-medium text-gray-500 hover:text-purple-500"> Sign in </a>
                                <a href="signup" class="ml-8 whitespace-nowrap inline-flex items-center justify-center px-4 py-2 border border-transparent rounded-md shadow-sm text-base font-medium text-white bg-purple-600 hover:bg-purple-700"> Sign up </a>
                            </div>
                        </div>
                    </c:if>

                    <c:if test="${request.getSession(false).getAttribute('user_type') == 1}">
                        <div class="absolute inset-y-0 right-0 flex items-center pr-2 sm:static sm:inset-auto sm:ml-6 sm:pr-0">
                            <button type="button" class="bg-purple-600 p-1 rounded-full text-gray-400 hover:text-white focus:outline-purple focus:ring-2 focus:text-white focus:ring-offset-2 focus:ring-offset-white focus:ring-purple-500">
                                <span class="sr-only">View cart</span>
                                Heroicon name: outline/bell 
                                <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                                <path stroke-linecap="round" stroke-linejoin="round" d="M16 11V7a4 4 0 00-8 0v4M5 9h14l1 12H4L5 9z" />
                                </svg><path stroke-linecap="round" stroke-linejoin="round" d="M15 17h5l-1.405-1.405A2.032 2.032 0 0118 14.158V11a6.002 6.002 0 00-4-5.659V5a2 2 0 10-4 0v.341C7.67 6.165 6 8.388 6 11v3.159c0 .538-.214 1.055-.595 1.436L4 17h5m6 0v1a3 3 0 11-6 0v-1m6 0H9" />
                                </svg>
                            </button>

                            <button type="button" class="ml-3 bg-purple-600 p-1 rounded-full text-gray-400 hover:text-white focus:outline-purple focus:ring-2 focus:ring-offset-2 focus:ring-offset-white focus:ring-purple-500">
                                <span class="sr-only">View notifications</span>
                                Heroicon name: outline/bell 
                                <svg class="h-6 w-6" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" aria-hidden="true">
                                <path stroke-linecap="round" stroke-linejoin="round" d="M15 17h5l-1.405-1.405A2.032 2.032 0 0118 14.158V11a6.002 6.002 0 00-4-5.659V5a2 2 0 10-4 0v.341C7.67 6.165 6 8.388 6 11v3.159c0 .538-.214 1.055-.595 1.436L4 17h5m6 0v1a3 3 0 11-6 0v-1m6 0H9" />
                                </svg>
                            </button>

                            Profile dropdown 
                            <div class="ml-3 relative">
                                <div>
                                    <button type="button" class="bg-gray-800 flex text-sm rounded-full focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-offset-purple focus:ring-purple-500" id="user-menu-button" aria-expanded="false" aria-haspopup="true">
                                        <span class="sr-only">Open user menu</span>
                                        <img class="h-8 w-8 rounded-full" src="https://images.unsplash.com/photo-1472099645785-5658abf4ff4e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80" alt="">
                                    </button>
                                </div>
                                <div class=" z-10 origin-top-right absolute right-0 mt-2 w-48 rounded-md shadow-lg py-1 bg-white ring-1 ring-black ring-opacity-5 focus:outline-none" role="menu" aria-orientation="vertical" aria-labelledby="user-menu-button" tabindex="-1">
                                    Active: "bg-gray-100", Not Active: "" 
                                    <a href="#" class="block px-4 py-2 text-sm text-gray-700" role="menuitem" tabindex="-1" id="user-menu-item-0">Your Profile</a>
                                    <a href="#" class="block px-4 py-2 text-sm text-gray-700" role="menuitem" tabindex="-1" id="user-menu-item-1">Settings</a>
                                    <a href="#" class="block px-4 py-2 text-sm text-gray-700" role="menuitem" tabindex="-1" id="user-menu-item-2">Sign out</a>
                                </div>
                            </div>
                        </div>
                    </c:if>
                </div>
            </div>

            <!-- Mobile menu, show/hide based on menu state. -->
            <div class="sm:hidden" id="mobile-menu">
                <div class="px-2 pt-2 pb-3 space-y-1">
                    <!-- Current: "bg-gray-900 text-white", Default: "text-gray-300 hover:bg-gray-700 hover:text-white" -->
                    <a href="#" class="bg-gray-900 text-white block px-3 py-2 rounded-md text-base font-medium" aria-current="page">Dashboard</a>

                    <a href="#" class="text-gray-300 hover:bg-gray-700 hover:text-white block px-3 py-2 rounded-md text-base font-medium">Team</a>

                    <a href="#" class="text-gray-300 hover:bg-gray-700 hover:text-white block px-3 py-2 rounded-md text-base font-medium">Projects</a>

                    <a href="#" class="text-gray-300 hover:bg-gray-700 hover:text-white block px-3 py-2 rounded-md text-base font-medium">Calendar</a>
                </div>
            </div>
        </nav>



    </body>
</html>
