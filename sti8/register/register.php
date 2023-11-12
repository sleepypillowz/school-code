<?php
$DATABASE_HOST = 'localhost';
$DATABASE_USER = 'root';
$DATABASE_PASS = '';
$DATABASE_NAME = 'test_db';

$con = mysqli_connect($DATABASE_HOST, $DATABASE_USER, $DATABASE_PASS, $DATABASE_NAME, 3307);

if(mysqli_connect_error()) {
	exit('Error connecting to the database' . mysqli_connect_error());
}

if(!isset($_POST['username'],$_POST['password'])) {
	exit('Empty Field(s)');
}

if(empty($_POST['username'] || empty($_POST['password']))) {
	exit('Values Empty');
}

if($stmt = $con->prepare('SELECT id,password FROM users WHERE username = ?')) {
	$stmt->bind_param('s',$_POST['username']);
	$stmt->execute();
	$stmt->store_result();

	if($stmt->num_rows>0) {
		echo 'username Already Exists. Try Again';
	}
	else {
		if($stmt = $con->prepare('INSERT INTO users (username, password) VALUES (?, ?)')) {
			$hashed_password = password_hash($_POST['password'], PASSWORD_DEFAULT);
			$stmt->bind_param('ss', $_POST['username'], $hashed_password);
			$stmt->execute();
			echo 'Successfully Registed';	
		}
		else{
			echo 'Error Occured';
		}
	}


	$stmt->close();
}
else{
	echo 'Error Occured';
}
$con->close();
?>