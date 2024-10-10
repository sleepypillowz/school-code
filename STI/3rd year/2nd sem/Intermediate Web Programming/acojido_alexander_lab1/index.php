<html>

<head>
  <title>Student Information</title>
</head>

<body>
  <?php

  $firstName = "Alexander Thomas";
  $middleInitial = "B.";
  $lastName = "Acojido";
  $studentNumber = 2000311248;
  $program = "BSCS";
  $age = 21;
  $gender = "Male";
  $year = "3rd year";
  $section = "BS501";

  echo "<p>Name: $lastName $firstName $middleInitial</p>";
  echo "<p>Year: $year $program $section</p>";
  echo "<p>ID: $studentNumber</p>";
  echo "<p>Info: $gender $age</p>";

  ?>
</body>

</html>