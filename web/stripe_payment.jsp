<%-- 
    Document   : stripe_payment
    Created on : May 27, 2023, 1:36:58 PM
    Author     : Umesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Stripe Payment Page</title>
    </head>
    <body>
        <form action="secureStripePayment" method="POST">
            <script
                src="https://checkout.stripe.com/checkout.js" class="stripe-button"
                data-key="pk_test_51NCHgbAnmHEqWsDuMYOjvcPlDgaVaKdkyd0ynk0euUfkn7SOQPgnUgMYdtX6no8T19o3RwZ1F0Dz5rnQwpOQJJFC00tjYdoYrM"
                data-amount="999"
                data-name="Bookstack"
                data-description="Book Purchase"
                data-image="https://stripe.com/img/documentation/checkout/marketplace.png"
                data-locale="auto"
                data-currency="jpy">
            </script>
        </form>
    </body>
</html>
