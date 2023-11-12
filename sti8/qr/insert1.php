<!-- connect to database -->
<?php
    session_start();
    $server = "localhost";
    $username = "root";
    $password = "";
    $dbname = "qrcodedb";

    //to connect
    $conn = new mysqli($server, $username, $password,$dbname, 3307);

    //to check connection
    if($conn->connect_error){
    	die("Connection failed" .$conn->connect_error);
    }

    //to insert
    if(isset($_POST['text'])){

    	$text =$_POST['text'];
        

            $sql = "INSERT INTO table_attendance(ROOMINFO,TIMEIN) VALUES('$text', NOW())";
            if($conn->query($sql) ===TRUE ){
            $_SESSION['success']='TIMEIN SUCCESSFULLY';
            }else{
            $_SESSION['error']=$conn->error;
            }
        }
    header("location: index.php");  	

    $conn->close();
?>