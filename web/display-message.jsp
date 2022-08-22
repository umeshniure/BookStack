<!--Error alert message section-->
<c:if test="${errorMessage != null}">
    <section class="mr-6 ml-6">
        <div class="bg-red-400 alert alert-dismissible fade show rounded-lg py-4 px-6 text-white md:flex justify-between items-center text-center md:text-left">
            <div class="md:mb-0 flex items-center flex-wrap justify-center md:justify-start">
                <svg aria-hidden="true" focusable="false" data-prefix="fas" data-icon="times-circle" class="w-4 h-4 mr-2 fill-current" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
                    <path fill="currentColor" d="M256 8C119 8 8 119 8 256s111 248 248 248 248-111 248-248S393 8 256 8zm121.6 313.1c4.7 4.7 4.7 12.3 0 17L338 377.6c-4.7 4.7-12.3 4.7-17 0L256 312l-65.1 65.6c-4.7 4.7-12.3 4.7-17 0L134.4 338c-4.7-4.7-4.7-12.3 0-17l65.6-65-65.6-65.1c-4.7-4.7-4.7-12.3 0-17l39.6-39.6c4.7-4.7 12.3-4.7 17 0l65 65.7 65.1-65.6c4.7-4.7 12.3-4.7 17 0l39.6 39.6c4.7 4.7 4.7 12.3 0 17L312 256l65.6 65.1z"></path>
                </svg>
                <c:out value="${errorMessage}"/>
            </div>
            <div class="flex items-center justify-center">
                <a class="inline-block px-6 py-2.5 bg-white text-gray-700 font-medium text-xs leading-tight uppercase rounded shadow-md hover:bg-gray-100 hover:shadow-lg focus:bg-gray-100 focus:shadow-lg focus:outline-none focus:ring-0 active:bg-gray-200 active:shadow-lg transition duration-150 ease-in-out mr-4"
                   href="" role="button" data-bs-dismiss="alert" aria-label="Close" data-mdb-ripple="true" data-mdb-ripple-color="light">Dismiss</a>
<!--                <a href="" class="text-white" data-bs-dismiss="alert" aria-label="Close">
                    <svg class="w-4 h-4" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 352 512">
                        <path fill="currentColor"
                              d="M242.72 256l100.07-100.07c12.28-12.28 12.28-32.19 0-44.48l-22.24-22.24c-12.28-12.28-32.19-12.28-44.48 0L176 189.28 75.93 89.21c-12.28-12.28-32.19-12.28-44.48 0L9.21 111.45c-12.28 12.28-12.28 32.19 0 44.48L109.28 256 9.21 356.07c-12.28 12.28-12.28 32.19 0 44.48l22.24 22.24c12.28 12.28 32.2 12.28 44.48 0L176 322.72l100.07 100.07c12.28 12.28 32.2 12.28 44.48 0l22.24-22.24c12.28-12.28 12.28-32.19 0-44.48L242.72 256z">
                        </path>
                    </svg>
                </a>-->
            </div>
        </div>
    </section>
</c:if>
<!--Error alert message section ends-->


<!--Success alert message section-->
<c:if test="${successMessage != null}">
    <section class="mr-6 ml-6">
        <div class="bg-green-300 alert alert-dismissible fade show rounded-lg py-4 px-6 text-green-900 md:flex justify-between items-center text-center md:text-left">
            <div class="md:mb-0 flex items-center flex-wrap justify-center md:justify-start">
                <svg aria-hidden="true" focusable="false" data-prefix="fas" data-icon="check-circle" class="w-4 h-4 mr-2 fill-current" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
                    <path fill="currentColor" d="M504 256c0 136.967-111.033 248-248 248S8 392.967 8 256 119.033 8 256 8s248 111.033 248 248zM227.314 387.314l184-184c6.248-6.248 6.248-16.379 0-22.627l-22.627-22.627c-6.248-6.249-16.379-6.249-22.628 0L216 308.118l-70.059-70.059c-6.248-6.248-16.379-6.248-22.628 0l-22.627 22.627c-6.248 6.248-6.248 16.379 0 22.627l104 104c6.249 6.249 16.379 6.249 22.628.001z"></path>
                </svg>
                <c:out value="${successMessage}"/>
            </div>
            <div class="flex items-center justify-center">
                <a class="inline-block px-6 py-2.5 bg-white text-gray-700 font-medium text-xs leading-tight uppercase rounded shadow-md hover:bg-gray-100 hover:shadow-lg focus:bg-gray-100 focus:shadow-lg focus:outline-none focus:ring-0 active:bg-gray-200 active:shadow-lg transition duration-150 ease-in-out mr-4"
                   href="" role="button" data-bs-dismiss="alert" aria-label="Close" data-mdb-ripple="true" data-mdb-ripple-color="light">Dismiss</a>
            </div>
        </div>
    </section>
</c:if>
<!--Success alert message section ends-->
