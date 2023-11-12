<!DOCTYPE html>
<?php session_start() ?>
<html>
<head>
	<!-- we used js and css for scanner -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/vue/2.1.10/vue.min.js"></script>
	<script type="text/javascript" src="https://rawgit.com/schmich/instascan-builds/master/instascan.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<!-- yung bootstrap is para sa html design -->
</head>
<body style="background-color:powderblue;">
	<h1 style="color:white; text-align: center; "><b> STI </b></h1>
	<hr>
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<!-- to use webcam for scanning the qr code -->
				<video id="preview" width="100%"></video>
				<!-- message indicator if success yung pag timein -->
				<?php
				    if(isset($_SESSION['error'])){
				    	echo"
				    	    <div class='alert alert-danger'>
				    	    <h4>Error!</h4>
				    	    ".$_SESSION['error']."
				    	    </div>
				    	";
				    }

				    if(isset($_SESSION['success'])){
				    	echo"
				    	    <div class='alert alert-success'>
				    	    <h4>Success!</h4>
				    	    ".$_SESSION['success']."
				    	    </div>
				    	";
				    }
				?>
		    </div>
		    <div class="col-md-6">
		    	<form action="insert1.php" method="post" class="form-horizontal">
		    		<!-- pagtapos ma scan ng qr, yung result ipapakita dito -->
			        <label>SCAN QR CODE</label>
			        <input type="text" name="text" id="text" readonly="" placeholder="" class="form-control">
		    	</form>
		    	<!-- table in front page para makita yung mga na iinsert sa database -->
		    	<table class="table table-bordered">
		    		<thead>
		    			<tr>
		    				<td>ROOMINFO</td>
		    				<td>TIME IN</td>
		    			</tr>
		    		</thead>
		    		<!-- connect to database -->
		    		<tbody>
		    			<?php
		    			$server = "localhost";
                        $username = "root";
                        $password = "";
                        $dbname = "qrcodedb";

                        //to connect
                        $conn = new mysqli($server, $username, $password,$dbname, 3307);

                        //to check connection
                        if($conn->connect_error)
                        {
    	                    die("Connection failed" .$conn->connect_error);
                        }
                        // para makuha yung nailagay sa database
                            $sql ="SELECT * FROM table_attendance WHERE DATE(TIMEIN)=CURDATE()";
                            $query = $conn->query($sql);
                            while ($row = $query->fetch_assoc())
                        {
		    			?>
		    			<!-- para mapunta sa frontpage yung na insert sa database -->
		    			<tr>
		    				<td><?php echo $row['ROOMINFO'];?></td>
		    				<td><?php echo $row['TIMEIN'];?></td>
		    			</tr>
		    			<?php
		    		    }
		    		    ?>
		    		</tbody>
		    	</table>

			</div>
		</div>
	</div>

	<!-- use camera and scan qr code -->
	<script>
		let scanner = new Instascan.Scanner({ video: document.getElementById('preview')});
		Instascan.Camera.getCameras().then(function(cameras){
			if(cameras.length > 0 )
			{
				//Zero for front camera
				scanner.start(cameras[0]);
			} else{
				alert('No cameras found');
			}
		}).catch(function(e) {
			console.error(e);
		});

		scanner.addListener('scan',function(c){
			document.getElementById('text').value=c;
			document.forms[0].submit(); //kukunin yung value ng input type tas tritrigger niya then mag insert siya sa database
		});

	</script>

</body>
</html>