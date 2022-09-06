<%-- 
    Document   : language-insert-form
    Created on : Sep 5, 2022, 11:14:49 PM
    Author     : Umesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="allscripts.jsp"/>
        <title>Language</title>
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
                    <div class="mt-5 md:col-span-2 md:mt-0">
                        <c:if test='${action == "update"}'>
                            <label class="block text-xl font-medium text-gray-700">Update language</label>
                        </c:if>
                        <c:if test='${action == "insert"}'>
                            <label class="block text-xl font-medium text-gray-700">Add new language</label>
                        </c:if>
                        <form action="adminDatabase" method="POST">
                            <div class="overflow-hidden shadow sm:rounded-md">
                                <div class="bg-white px-4 py-5 sm:p-6">
                                    <div class="grid grid-cols-6 gap-6">
                                        <div class="col-span-6 sm:col-span-4">

                                            <c:if test='${action == "update"}'>
                                                <label for="id" class="block text-sm font-medium text-gray-700 select-none">Language ID</label>
                                                <input type="number" name='id' value="${language.id}" class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-500 focus:ring-indigo-500 sm:text-sm select-none cursor-not-allowed" readonly>
                                                <input type="hidden" name="action" value="updateLanguage">
                                            </c:if>
                                            <c:if test='${action == "insert"}'>
                                                <input type="hidden" name="action" value="insertLanguage">
                                            </c:if>
                                        </div>
                                        <div class="col-span-6 sm:col-span-4">
                                            <label for="email-address" class="block text-sm font-medium text-gray-700">Language name</label>
                                            <input type="text" name="language" value="${language.language_name}" class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-500 focus:ring-indigo-500 sm:text-sm">
                                        </div>
                                    </div>
                                </div>
                                <div class="flex px-4 py-3 text-right sm:px-6 w-auto justify-left" >
                                    <c:if test='${action == "update"}'>
                                        <button type="submit" class="justify-center rounded-md border border-transparent bg-purple-600 py-2 px-4 text-sm font-medium text-white shadow-sm hover:bg-purple-700 focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:ring-offset-2">Update</button>
                                    </c:if>
                                    <c:if test='${action == "insert"}'>
                                        <button type="submit" class="justify-center rounded-md border border-transparent bg-purple-600 py-2 px-4 text-sm font-medium text-white shadow-sm hover:bg-purple-700 focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:ring-offset-2">Insert</button>
                                    </c:if>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

