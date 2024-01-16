<?php 

session_start();

 ?>

<!DOCTYPE html>
<html>
<head>
    <!--Title at the top left--> 
    <title>Header</title>

    <!--I have no idea--> 
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!--links to External CSS--> 
    <link rel="stylesheet" href="main.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body>

<!-- container for imported header content-->
<div id="header">

    <!-- container for the header code-->
    <div class="header">

        <!--Menu Button--> 
        <div>
            <a href="#default"button class="logo" onclick="w3_open()">&#9776;</a>
        </div>

        <!--Logo--> 
        <a href="../home/home.php" class="logo">STI</a>

        <!--profile button--> 
        <nav>
            <img src="../images/img_avatar.png" class="user-pic" onclick="toggleMenu()">
        </nav> 

        <!--Profile onClick--> 
        <div class="sub-menu-wrap" id="subMenu">
            <div class="sub-menu">
                <div class="user-info">
                    <img src="../images/img_avatar.png">
                    <h3><?php echo $_SESSION['user_name']; ?><h3>
                </div>
                
                <hr>
                <a href="../profile/profile.html" class="sub-menu-link">
                <p>Edit Profile</p>
                <span>></span>
                </a>

                <a href="../settings/settings.html" class="sub-menu-link">
                <p>Settings</p>
                <span>></span>
                </a>

                <a href="../logout.php" class="sub-menu-link">
                <p>Logout</p>
                <span>></span>
                </a>
            </div> 
        </div>
    </div>

    <!--No Idea--> 
    <div class="w3-sidebar w3-bar-block w3-white w3-animate-left" style="display:none" id="mySidebar">
        <button class="w3-bar-item w3-button w3-large"
            onclick="w3_close()">
            Close &times;
        </button>

        <!--Imported Sidebar--> 
        <a href="../home/home.php" class="w3-bar-item w3-button"><i class="fa fa-home">Home</i></a>
        <a href="#" class="w3-bar-item w3-button"><i class="fa fa-search">Search</i></a>
        <a href="#" class="w3-bar-item w3-button"><i class="fa fa-envelope">Email</i></a>
        <a href="#" class="w3-bar-item w3-button"><i class="fa fa-globe"></i>History</a>
        <a href="#" class="w3-bar-item w3-button"><i class="fa fa-trash"></i>Delete</a>
    </div>

    <!--Script for Displaying Sidebar-->
    <script>
        function w3_open() {
            document.getElementById("mySidebar").style.display = "block";
        }
        function w3_close() {
            document.getElementById("mySidebar").style.display = "none";
        }
    </script>
    
    <!--Script for Displaying Profile Click-->
    <script>
        let subMenu = document.getElementById("subMenu");

        function toggleMenu(){
            subMenu.classList.toggle("open-menu");
        }
    </script>  
</div>  
</body>
</html>

 ?>