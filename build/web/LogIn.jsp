<%-- 
    Document   : index
    Created on : Jun 7, 2022, 3:34:06 PM
    Author     : Umesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>

        <link href="CSS//beauty.cxss" rel="stylesheet">
        <link href="CSS//signin.css" rel="stylesheet">
    </head>
    <body class="text-center" style="background-image: url('images/book1.jpg'); background-size: 100% 100%;">
        <main class="form-signin m-auto">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="container-md-12  rounded-4" style="background-color: #f5f5f5; border-style: solid; border-color: rgb(149,0,149);">
                            <form autocomplete="off" class = " mt-3 mb-3 p-2" action="login" method="post">
                                <img class="mb-2" src="images/booklogo.png" alt="" width="72" height="72">
                                <h1 class="h4 mb-3 fw-normal text-start">Sign in</h1>

                                <div class="form-floating">
                                    <input type="text" class="form-control" name="email" id="floatingInput" value="${email}">
                                    <label for="floatingInput">Email</label>
                                </div>
                                <div class="form-floating mt-3">
                                    <input type="password" class="form-control" name = "password" id="floatingPassword" value="">
                                    <label for="floatingPassword">Password</label>
                                    <a href="forgotPassword" class="text-end" style="color: blue; font-size: 10px; float:right";> 
                                        Forgot password? </a>
                                </div>
                                <br>
                                <div>
                                    <span style="color: red; float:left">
                                        ${message}
                                    </span>
                                </div><br>
                                <div><hr></div>
                                <button id ="btn1" class="w-100 btn btn-lg" style="color: white; background-color: #950095" type="submit">Sign in</button>
                                <a class="nav-link" href="signup">Sign up</a>
                            </form>
                        </div>  
                        <a class="nav-link" href="home.jsp">home</a>
                    </div>
                </div>
            </div>
        </main>
    </body>
</html>











