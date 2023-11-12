<?php 

session_start();

if (isset($_SESSION['id']) && isset($_SESSION['user_name'])) {

 ?>

<!DOCTYPE html>
<html>
<head>
    <!--Title at the top left--> 
    <title>Home</title>

    <!--I have no idea--> 
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!--links to External CSS--> 
    <link rel="stylesheet" href="../main.css">
    <link rel="stylesheet" href="home.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

    <!--JQuery Script to import header.html--> 
    <script
        src="https://code.jquery.com/jquery-3.3.1.js"
        integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
        crossorigin="anonymous">
    </script>

<!--Load Script-->
<script> 
$(function(){
  $("#header").load("../header.php"); 
});
</script>  

</head>
<body>
    <!--imported header-->
    <div id="header"></div>
    <!--Professor List-->
    <div class="row">
        <!-- <div id="imgcycle"></div> -->
        <div id ="clone"></div>
    </div>   

<!--Cycle on each Image
<script>
    const img = ["argel", "alberto","oliveros","lacudine","del_rosario","guzman"];
    var x ="", i;
    for (i=0; i<=5; i++) {
    x = x + "<div class='column'><img src='../images/"+img[i]+".png'></div>"
    }
    document.getElementById("imgcycle").innerHTML = x;
</script>
-->

<!--Repeating Image-->
<script>
    var x ="", i;
    for (i=1; i<=10; i++) {
    x = x + "<div class='column'><img src='../images/alberto.png'></div>"
    }
    document.getElementById("clone").innerHTML = x;
</script>

</body>
</html>

<?php 

}else{

     header("Location: ../login/index.php");

     exit();

}

 ?>