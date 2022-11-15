<%-- 
    Document   : allscripts
    Created on : Aug 28, 2022, 12:26:25 PM
    Author     : Umesh
--%>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="https://unpkg.com/flowbite@1.5.3/dist/flowbite.min.css" />
<script src="https://unpkg.com/flowbite@1.5.3/dist/flowbite.js"></script>
<script src="https://cdn.tailwindcss.com"></script>
<link rel="stylesheet" href="css/allcss.css"></link>

<script>
//    setTimeout(() => {
//        const box = document.getElementById('toast-warning');
//        box.style.display = 'none';
//    }, 3500);

    var opacity = 1;
    var intervalID = 0;

    setTimeout(function () {
        if (document.getElementById("toast-warning")) {
            fadeout();
            function fadeout() {
                setInterval(hide, 60);
            }
            function hide() {
                var toast1 = document.getElementById("toast-warning");
                if (opacity > 0) {
                    opacity = opacity - 0.1;
                    toast1.style.opacity = opacity;
                } else {
                    toast1.style.display = 'none';
                    clearInterval(intervalID);
                    return;
                }
            }
            
        } else if (document.getElementById("toast-success")) {
            fadeout();
            function fadeout() {
                setInterval(hide, 60);
            }
            function hide() {
                var toast1 = document.getElementById("toast-success");
                if (opacity > 0) {
                    opacity = opacity - 0.1;
                    toast1.style.opacity = opacity;
                } else {
                    toast1.style.display = 'none';
                    clearInterval(intervalID);
                    return;
                }
            }
        }


    }, 4000);

//    setTimeout(() => {
//        const box2 = document.getElementById('toast-success');
//        box2.style.display = 'none';
//
//    }, 3500);
</script>
