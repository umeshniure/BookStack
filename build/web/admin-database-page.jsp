<%-- 
    Document   : admin-database-page
    Created on : Sep 5, 2022, 2:44:44 PM
    Author     : Umesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="allscripts.jsp"/>
        <title>Database</title>
    </head>
    <body>
        <div class="min-h-screen flex flex-col flex-auto flex-shrink-0 antialiased bg-white dark:bg-gray-700 text-black dark:text-white">
            <!--header-->
            <jsp:include page="admin-dashboard-navbar.jsp"/>
            <!--header ends-->

            <!--sidebar-->
            <jsp:include page="admin-dashboard-aside.jsp"/>
            <!--sidebar ends-->
            <div class="h-full ml-14 mt-14 mb-10 md:ml-64">


                <div class="grid grid-cols-1 md:grid-cols-2 xl:grid-cols-3 p-4 gap-4 text-black dark:text-white">
                    <div class="md:col-span-2 xl:col-span-3">
                        <h3 class="text-lg font-semibold">Task summaries of recent sprints</h3>
                    </div>

                    <div class="relative flex flex-col min-w-0 mb-4 lg:mb-0 break-words bg-gray-50 dark:bg-gray-800 w-full shadow-lg rounded">
                        <div class="rounded-t mb-0 px-0 border-0">
                            <div class="flex flex-wrap items-center px-4 py-2">
                                <div class="relative w-full max-w-full flex-grow flex-1">
                                    <h3 class="font-semibold text-base text-gray-900 dark:text-gray-50">Categories</h3>
                                </div>
                                <div class="relative w-full max-w-full flex-grow flex-1 text-right">
                                    <a href="adminDatabase?action=insertCategoryForm">
                                        <button class="bg-blue-500 dark:bg-gray-100 text-white active:bg-blue-600 dark:text-gray-800 dark:active:text-gray-700 text-xs font-bold uppercase px-3 py-1 rounded outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all duration-150" type="button">Add</button>
                                    </a>
                                </div>
                            </div>
                            <div class="block w-full overflow-x-auto">
                                <table class="items-center w-full bg-transparent border-collapse">
                                    <thead>
                                        <tr>
                                            <th class="px-4 bg-gray-100 dark:bg-gray-600 text-gray-500 dark:text-gray-100 align-middle border border-solid border-gray-200 dark:border-gray-500 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left">ID</th>
                                            <th class="px-4 bg-gray-100 dark:bg-gray-600 text-gray-500 dark:text-gray-100 align-middle border border-solid border-gray-200 dark:border-gray-500 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left">Category</th>
                                            <th class="px-4 bg-gray-100 dark:bg-gray-600 text-gray-500 dark:text-gray-100 align-middle border border-solid border-gray-200 dark:border-gray-500 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left min-w-140-px">Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="category" items="${categories}">
                                            <tr class="text-gray-700 dark:text-gray-100">
                                                <th class="border-t-0 px-4 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4 text-left"><c:out value="${category.id}"/></th>
                                                <td class="border-t-0 px-4 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4">${category.category_name}</td>
                                                <td class="border-t-0 px-4 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4">
                                                    <div class="flex items-center">
                                                        <a href="adminDatabase?action=updateForm&id=${category.id}"><span class="mr-2 text-purple-400">Edit</span></a>
                                                        <a href="adminDatabase?action=remove&id=${category.id}"> <span class="mr-2 text-red-800">Remove</span></a>
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        <tr class="text-gray-700 dark:text-gray-100">
                                            <th class="border-t-0 px-4 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4 text-left">Twitter</th>
                                            <td class="border-t-0 px-4 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4">3,380</td>
                                            <td class="border-t-0 px-4 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4">
                                                <div class="flex items-center">
                                                    <span class="mr-2">40%</span>
                                                    <div class="relative w-full">
                                                        <div class="overflow-hidden h-2 text-xs flex rounded bg-blue-200">
                                                            <div style="width: 40%" class="shadow-none flex flex-col text-center whitespace-nowrap text-white justify-center bg-blue-500"></div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr class="text-gray-700 dark:text-gray-100">
                                            <th class="border-t-0 px-4 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4 text-left">Instagram</th>
                                            <td class="border-t-0 px-4 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4">4,105</td>
                                            <td class="border-t-0 px-4 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4">
                                                <div class="flex items-center">
                                                    <span class="mr-2">45%</span>
                                                    <div class="relative w-full">
                                                        <div class="overflow-hidden h-2 text-xs flex rounded bg-pink-200">
                                                            <div style="width: 45%" class="shadow-none flex flex-col text-center whitespace-nowrap text-white justify-center bg-pink-500"></div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr class="text-gray-700 dark:text-gray-100">
                                            <th class="border-t-0 px-4 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4 text-left">Google</th>
                                            <td class="border-t-0 px-4 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4">4,985</td>
                                            <td class="border-t-0 px-4 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4">
                                                <div class="flex items-center">
                                                    <span class="mr-2">60%</span>
                                                    <div class="relative w-full">
                                                        <div class="overflow-hidden h-2 text-xs flex rounded bg-red-200">
                                                            <div style="width: 60%" class="shadow-none flex flex-col text-center whitespace-nowrap text-white justify-center bg-red-500"></div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr class="text-gray-700 dark:text-gray-100">
                                            <th class="border-t-0 px-4 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4 text-left">Linkedin</th>
                                            <td class="border-t-0 px-4 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4">2,250</td>
                                            <td class="border-t-0 px-4 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4">
                                                <div class="flex items-center">
                                                    <span class="mr-2">30%</span>
                                                    <div class="relative w-full">
                                                        <div class="overflow-hidden h-2 text-xs flex rounded bg-blue-200">
                                                            <div style="width: 30%" class="shadow-none flex flex-col text-center whitespace-nowrap text-white justify-center bg-blue-700"></div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                    <div>
                        <div class="rounded bg-gray-200 dark:bg-gray-800 p-3">
                            <div class="flex justify-between py-1 text-black dark:text-white">
                                <h3 class="text-sm font-semibold">Tasks in DEVELOPMENT</h3>
                                <svg class="h-4 fill-current text-gray-600 dark:text-gray-500 cursor-pointer" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M5 10a1.999 1.999 0 1 0 0 4 1.999 1.999 0 1 0 0-4zm7 0a1.999 1.999 0 1 0 0 4 1.999 1.999 0 1 0 0-4zm7 0a1.999 1.999 0 1 0 0 4 1.999 1.999 0 1 0 0-4z" /></svg>
                            </div>
                            <div class="text-sm text-black dark:text-gray-50 mt-2">
                                <div class="bg-white dark:bg-gray-600 hover:bg-gray-50 dark:hover:bg-gray-700 p-2 rounded mt-1 border-b border-gray-100 dark:border-gray-900 cursor-pointer">Delete all references from the wiki</div>
                                <div class="bg-white dark:bg-gray-600 hover:bg-gray-50 dark:hover:bg-gray-700 p-2 rounded mt-1 border-b border-gray-100 dark:border-gray-900 cursor-pointer">Remove analytics code</div>
                                <div class="bg-white dark:bg-gray-600 hover:bg-gray-50 dark:hover:bg-gray-700 p-2 rounded mt-1 border-b border-gray-100 dark:border-gray-900 cursor-pointer">
                                    Do a mobile first layout
                                    <div class="flex justify-between items-start mt-2 ml-2 text-white text-xs">
                                        <span class="bg-pink-600 rounded p-1 text-xs flex items-center">
                                            <svg class="h-4 fill-current" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M12 2c-.8 0-1.5.7-1.5 1.5v.688C7.344 4.87 5 7.62 5 11v4.5l-2 2.313V19h18v-1.188L19 15.5V11c0-3.379-2.344-6.129-5.5-6.813V3.5c0-.8-.7-1.5-1.5-1.5zm-2 18c0 1.102.898 2 2 2 1.102 0 2-.898 2-2z" /></svg>
                                            2
                                        </span>
                                    </div>
                                </div>
                                <div class="bg-white dark:bg-gray-600 hover:bg-gray-50 dark:hover:bg-gray-700 p-2 rounded mt-1 border-b border-gray-100 dark:border-gray-900 cursor-pointer">Check the meta tags</div>
                                <div class="bg-white dark:bg-gray-600 hover:bg-gray-50 dark:hover:bg-gray-700 p-2 rounded mt-1 border-b border-gray-100 dark:border-gray-900 cursor-pointer">
                                    Think more tasks for this example
                                    <div class="text-gray-500 mt-2 ml-2 flex justify-between items-start">
                                        <span class="text-xs flex items-center">
                                            <svg class="h-4 fill-current mr-1" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 50 50"><path d="M11 4c-3.855 0-7 3.145-7 7v28c0 3.855 3.145 7 7 7h28c3.855 0 7-3.145 7-7V11c0-3.855-3.145-7-7-7zm0 2h28c2.773 0 5 2.227 5 5v28c0 2.773-2.227 5-5 5H11c-2.773 0-5-2.227-5-5V11c0-2.773 2.227-5 5-5zm25.234 9.832l-13.32 15.723-8.133-7.586-1.363 1.465 9.664 9.015 14.684-17.324z" /></svg>
                                            0/3
                                        </span>
                                    </div>
                                </div>
                                <p class="mt-3 text-gray-600 dark:text-gray-400">Add a card...</p>
                            </div>
                        </div>
                    </div>
                    <div>
                        <div class="rounded bg-gray-200 dark:bg-gray-800 p-3">
                            <div class="flex justify-between py-1 text-black dark:text-white">
                                <h3 class="text-sm font-semibold">Tasks in QA</h3>
                                <svg class="h-4 fill-current text-gray-600 dark:text-gray-500 cursor-pointer" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M5 10a1.999 1.999 0 1 0 0 4 1.999 1.999 0 1 0 0-4zm7 0a1.999 1.999 0 1 0 0 4 1.999 1.999 0 1 0 0-4zm7 0a1.999 1.999 0 1 0 0 4 1.999 1.999 0 1 0 0-4z" /></svg>
                            </div>
                            <div class="text-sm text-black dark:text-gray-50 mt-2">
                                <div class="bg-white dark:bg-gray-600 hover:bg-gray-50 dark:hover:bg-gray-700 p-2 rounded mt-1 border-b border-gray-100 dark:border-gray-900 cursor-pointer">Delete all references from the wiki</div>
                                <div class="bg-white dark:bg-gray-600 hover:bg-gray-50 dark:hover:bg-gray-700 p-2 rounded mt-1 border-b border-gray-100 dark:border-gray-900 cursor-pointer">Remove analytics code</div>
                                <div class="bg-white dark:bg-gray-600 hover:bg-gray-50 dark:hover:bg-gray-700 p-2 rounded mt-1 border-b border-gray-100 dark:border-gray-900 cursor-pointer">Do a mobile first layout</div>
                                <div class="bg-white dark:bg-gray-600 hover:bg-gray-50 dark:hover:bg-gray-700 p-2 rounded mt-1 border-b border-gray-100 dark:border-gray-900 cursor-pointer">Check the meta tags</div>
                                <div class="bg-white dark:bg-gray-600 hover:bg-gray-50 dark:hover:bg-gray-700 p-2 rounded mt-1 border-b border-gray-100 dark:border-gray-900 cursor-pointer">
                                    Think more tasks for this example
                                    <div class="text-gray-500 dark:text-gray-200 mt-2 ml-2 flex justify-between items-start">
                                        <span class="text-xs flex items-center">
                                            <svg class="h-4 fill-current mr-1" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 50 50"><path d="M11 4c-3.855 0-7 3.145-7 7v28c0 3.855 3.145 7 7 7h28c3.855 0 7-3.145 7-7V11c0-3.855-3.145-7-7-7zm0 2h28c2.773 0 5 2.227 5 5v28c0 2.773-2.227 5-5 5H11c-2.773 0-5-2.227-5-5V11c0-2.773 2.227-5 5-5zm25.234 9.832l-13.32 15.723-8.133-7.586-1.363 1.465 9.664 9.015 14.684-17.324z" /></svg>
                                            0/3
                                        </span>
                                    </div>
                                </div>
                                <p class="mt-3 text-gray-600 dark:text-gray-400">Add a card...</p>
                            </div>
                        </div>
                    </div>
                </div>


            </div>
        </div>
    </body>
</html>
