<%-- 
    Document   : vendor-book-upload
    Created on : Aug 6, 2022, 6:33:42 PM
    Author     : Umesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="allscripts.jsp"/>
        <title>Book upload form</title>
    </head>
    <body>

        <!--aside navigation bar-->
        <jsp:include page="vendor-dashboard-aside.jsp"/>
        <!--aside navigation bar ends-->

        <div class="ml-auto mb-6 lg:w-[75%] xl:w-[80%] 2xl:w-[85%]">

            <!--vendor navigation bar-->
            <jsp:include page="vendor-dashboard-navbar.jsp"/>
            <!--vendor navigation bar ends-->

            <section class=" py-1 bg-blueGray-50">
                <div class="w-full lg:w-8/12 px-4 mx-auto mt-6">
                    <div class="flex flex-col min-w-0 break-words w-full mb-6 shadow-lg rounded-lg bg-blueGray-100 border-0">
                        <div class="rounded-t bg-white mb-0 px-6 py-6">
                            <div class="text-center flex justify-between">
                                <h6 class="text-blueGray-700 text-xl font-bold">
                                    Vendor book upload form
                                </h6>
                                <a href="vendorbook">
                                    <button class="bg-purple-500 text-white active:bg-purple-600 font-bold uppercase text-xs px-4 py-2 rounded shadow hover:shadow-md outline-none focus:outline-none mr-1 ease-linear transition-all duration-150" type="button">
                                        Back
                                    </button>
                                </a>
                            </div>
                        </div>
                        <div class="flex-auto px-4 lg:px-10 py-10 pt-0">
                            <c:if test='${action == "update"}'>
                                <form method="POST" action="vendorbook" enctype='multipart/form-data'>
                                </c:if>
                                <c:if test='${action == "insert"}'>
                                    <form method="POST" action="UploadBook" enctype='multipart/form-data'>
                                    </c:if>
                                    <h6 class="text-blueGray-400 text-sm mt-3 mb-6 font-bold uppercase">
                                        General book information
                                    </h6>
                                    <div class="flex flex-wrap">
                                        <div class="w-full md:w-6/12 px-4">
                                            <div class="relative w-full mb-3">
                                                <label class="block uppercase text-blueGray-600 text-xs font-bold mb-2" htmlfor="grid-password">
                                                    Book full name
                                                </label>
                                                <input name="bookname" type="text" class="border border-solid border-gray-300 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" value="<c:out value="${book.name}"/>">
                                                <input name="id" type="hidden" value="<c:out value='${book.id}'/>">
                                            </div>
                                        </div>
                                        <div class="w-full md:w-6/12 px-4">
                                            <div class="relative w-full mb-3">
                                                <label class="block uppercase text-blueGray-600 text-xs font-bold mb-2" htmlfor="grid-password">
                                                    ISBN
                                                </label>
                                                <input name="isbn" type="number" class="border border-solid border-gray-300 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" value="<c:out value="${book.isbn}"/>">
                                            </div>
                                        </div>
                                        <div class="w-full md:w-6/12 px-4">
                                            <div class="relative w-full mb-3">
                                                <label class="block uppercase text-blueGray-600 text-xs font-bold mb-2" htmlfor="grid-password">
                                                    Category
                                                </label>
                                                <select name="category" class="border border-solid border-gray-300 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150">
                                                    <option value="${book.category}">${book.category_name}</option>
                                                    <c:forEach var="category" items="${categories}">
                                                        <option value="${category.id}">${category.category_name}</option>
                                                    </c:forEach>
                                                </select>
                                                <!--<input name="category" type="text" class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" value="">-->
                                            </div>
                                        </div>
                                        <div class="w-full md:w-6/12 px-4">
                                            <div class="relative w-full mb-3">
                                                <label class="block uppercase text-blueGray-600 text-xs font-bold mb-2" htmlfor="grid-password">
                                                    Cover Type
                                                </label>
                                                <select name="cover_type" class="border border-solid border-gray-300 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150">
                                                    <option value="${book.cover_type}">${book.cover}</option>
                                                    <c:forEach var="cover" items="${bookCover}">
                                                        <option value="${cover.id}">${cover.cover_type}</option>
                                                    </c:forEach>
                                                </select>
                                                <!--<input name="cover_type" type="text" class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" value="">-->
                                            </div>
                                        </div>
                                        <div class="w-full md:w-6/12 px-4">
                                            <div class="relative w-full mb-3">
                                                <label name="" class="block uppercase text-blueGray-600 text-xs font-bold mb-2" htmlfor="grid-password">
                                                    Price
                                                </label>
                                                <input name="price" type="number" class="border border-solid border-gray-300 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" value="<c:out value="${book.price}"/>">
                                            </div>
                                        </div>
                                        <div class="w-full md:w-6/12 px-4">
                                            <div class="relative w-full mb-3">
                                                <label name="" class="block uppercase text-blueGray-600 text-xs font-bold mb-2" htmlfor="grid-password">
                                                    Discounted price
                                                </label>
                                                <c:if test='${book.discounted_price != null}'>
                                                    <input name="discounted_price" type="number" class="border border-solid border-gray-300 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" value="<c:out value="${book.discounted_price}"/>">
                                                </c:if>
                                                <c:if test='${book.discounted_price == null}'>
                                                    <input name="discounted_price" type="number" class="border border-solid border-gray-300 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150">
                                                </c:if>
                                            </div>
                                        </div>
                                        <div class="w-full md:w-4/12 px-4">
                                            <div class="relative w-full mb-3">
                                                <label class="block uppercase text-blueGray-600 text-xs font-bold mb-2" htmlfor="grid-password">
                                                    Language
                                                </label>
                                                <select name="language" class="border border-solid border-gray-300 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150">
                                                    <option value="${book.language}">${book.language_name}</option>
                                                    <c:forEach var="language" items="${language}">
                                                        <option value="${language.id}">${language.language_name}</option>
                                                    </c:forEach>
                                                </select>
                                                <!--<input name="language" type="text" class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" value="">-->
                                            </div>
                                        </div>
                                        <div class="w-full md:w-4/12 px-4">
                                            <div class="relative w-full mb-3">
                                                <label class="block uppercase text-blueGray-600 text-xs font-bold mb-2" htmlfor="grid-password">
                                                    Book type
                                                </label>
                                                <select name="book_type" class="border border-solid border-gray-300 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150">
                                                    <option value="${book.type}">${book.book_type}</option>
                                                    <c:forEach var="type" items="${bookType}">
                                                        <option value="${type.id}">${type.type}</option>
                                                    </c:forEach>
                                                </select>
                                                <!--<input name="book_type" type="text" class="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" value="">-->
                                            </div>
                                        </div>
                                        <div class="w-full md:w-4/12 px-4">
                                            <div class="relative w-full mb-3">
                                                <label class="block uppercase text-blueGray-400 text-xs font-bold mb-2" htmlfor="grid-password">
                                                    Quantity
                                                </label>
                                                <input name="quantity" type="number" value="${book.quantity}" class="border border-solid border-gray-300 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" value="">
                                            </div>
                                        </div>
                                    </div>

                                    <hr class="mt-6 border-b-1 border-blueGray-300">

                                    <h6 class="text-blueGray-400 text-sm mt-3 mb-6 font-bold uppercase">
                                        Author and publication
                                    </h6>
                                    <div class="flex flex-wrap">
                                        <div class="w-full md:w-12/12 px-4">
                                            <div class="relative w-full mb-3">
                                                <label class="block uppercase text-blueGray-600 text-xs font-bold mb-2" htmlfor="grid-password">
                                                    Author full name
                                                </label>
                                                <input name="authorname" value="${book.author}" type="text" class="border border-solid border-gray-300 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150">
                                            </div>
                                        </div>
                                        <div class="w-full md:w-8/12 px-4">
                                            <div class="relative w-full mb-3">
                                                <label class="block uppercase text-blueGray-600 text-xs font-bold mb-2" htmlfor="grid-password">
                                                    Publication name
                                                </label>
                                                <input name="publication" value="${book.publication}" type="text" class="border border-solid border-gray-300 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150">
                                            </div>
                                        </div>
                                        <div class="w-full md:w-4/12 px-4">
                                            <div class="relative w-full mb-3">
                                                <label class="block uppercase text-blueGray-600 text-xs font-bold mb-2" htmlfor="grid-password">
                                                    Published date
                                                </label>
                                                <input name="published_year" value="${book.published_year}" type="year" class="border border-solid border-gray-300 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150">
                                            </div>
                                        </div>
                                    </div>

                                    <hr class="mt-6 border-b-1 border-blueGray-300">

                                    <h6 class="text-blueGray-400 text-sm mt-3 mb-6 font-bold uppercase">
                                        About Book
                                    </h6>
                                    <div class="flex flex-wrap">
                                        <div class="w-full md:w-12/12 px-4">
                                            <div class="relative w-full mb-3">
                                                <label class="block uppercase text-blueGray-600 text-xs font-bold mb-2" htmlfor="grid-password">
                                                    short book description
                                                </label>
                                                <textarea name="description" type="text" class="border border-solid border-gray-300 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150" rows="5" placeholder="Describe about book in 150/200 words. You can write the content from back of the book.">${book.description}</textarea>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="flex flex-wrap">
                                        <div class="w-full md:w-12/12 px-4">
                                            <label class="block uppercase text-blueGray-600 text-xs font-bold mb-2" htmlfor="grid-password">
                                                Book cover photo
                                            </label>
                                            <div class="flex justify-center items-center w-full">                                    
                                                <label for="dropzone-file" class="flex flex-col justify-center items-center w-full h-64 bg-gray-50 rounded-lg border-2 border-gray-300 border-dashed cursor-pointer dark:hover:bg-bray-800 dark:bg-gray-700 hover:bg-gray-100 dark:border-gray-600 dark:hover:border-gray-500 dark:hover:bg-gray-600">
                                                    <div class="flex flex-col justify-center items-center pt-5 pb-6">
                                                        <svg aria-hidden="true" class="mb-3 w-10 h-10 text-gray-400" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M7 16a4 4 0 01-.88-7.903A5 5 0 1115.9 6L16 6a5 5 0 011 9.9M15 13l-3-3m0 0l-3 3m3-3v12"></path></svg>
                                                        <p class="mb-2 text-sm text-gray-500 dark:text-gray-400"><span class="font-semibold">Click to upload</span> or drag and drop</p>
                                                        <p class="text-xs text-gray-500 dark:text-gray-400">SVG, PNG, JPG or GIF (MAX. 800x400px)</p>
                                                        <p class="text-xs text-gray-500 dark:text-gray-400">(to be displayed to the users)</p>
                                                    </div>
                                                    <input name="cover_photo" id="dropzone-file" type="file" class="hidden" />
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="mt-3 flex flex-wrap">
                                        <div class="w-full md:w-12/12 px-4">
                                            <c:if test='${action == "update"}'>
                                                <button type="submit" class="justify-center items-center w-full text-white bg-purple-700 hover:bg-purple-800 focus:ring-4 focus:outline-none focus:ring-purple-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center inline-flex items-center dark:bg-purple-600 dark:hover:bg-purple-700 dark:focus:ring-purple-800">
                                                    Update 
                                                    <svg aria-hidden="true" class="ml-2 -mr-1 w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M10.293 3.293a1 1 0 011.414 0l6 6a1 1 0 010 1.414l-6 6a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-4.293-4.293a1 1 0 010-1.414z" clip-rule="evenodd"></path></svg>
                                                </button>
                                            </c:if>
                                            <c:if test='${action == "insert"}'>
                                                <button type="submit" class="justify-center items-center w-full text-white bg-purple-700 hover:bg-purple-800 focus:ring-4 focus:outline-none focus:ring-purple-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center inline-flex items-center dark:bg-purple-600 dark:hover:bg-purple-700 dark:focus:ring-purple-800">
                                                    Submit 
                                                    <svg aria-hidden="true" class="ml-2 -mr-1 w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M10.293 3.293a1 1 0 011.414 0l6 6a1 1 0 010 1.414l-6 6a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-4.293-4.293a1 1 0 010-1.414z" clip-rule="evenodd"></path></svg>
                                                </button>
                                            </c:if>
                                        </div>
                                    </div>                            
                                </form>
                        </div>
                    </div>                
                </div>
            </section>
        </div>
    </body>
</html>
