<%-- 
    Document   : navigation-bar
    Created on : Aug 6, 2022, 6:20:48 PM
    Author     : Umesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <!--Top Navigation bar section-->
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
        <!--Top Navigation bar section-->

    </body>
</html>
