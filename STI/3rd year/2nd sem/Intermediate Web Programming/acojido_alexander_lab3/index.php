<html>

<body>

  <form method="POST">
    <label>
      First Number:
      <br>
      <input type="text" name="x">
      <br>
    </label>

    <label>
      Second Number:
      <br>
      <input type="text" name="y">
      <br>
    </label>

    <label>
      <input type="radio" name="operation" value="add">
      Add
    </label>
    <br>

    <label>
      <input type="radio" name="operation" value="subtract">
      Subtract
    </label>
    <br>

    <label>
      <input type="radio" name="operation" value="multiply">
      Multiply
    </label>
    <br>

    <label>
      <input type="radio" name="operation" value="divide">
      Divide
    </label>
    <br>

    <input type="submit" value="Enter">
  </form>

  <?php

  if ($_SERVER["REQUEST_METHOD"] == "POST") {
    if (isset($_POST['x']) && isset($_POST['y']) && isset($_POST['operation'])) {
      $x = $_POST['x'];
      $y = $_POST['y'];
      $operation = $_POST['operation'];

      if (is_numeric($x) && is_numeric($y)) {

        if ($operation == "add") {
          $result = add($x, $y);
        } elseif ($operation == "subtract") {
          $result = subtract($x, $y);
        } elseif ($operation == "multiply") {
          $result = multiply($x, $y);
        } elseif ($operation == "divide") {
          $result = divide($x, $y);
        }
        echo "Result: $result";
      }
    }
  }
  function add($x, $y)
  {
    return $x + $y;
  }

  function subtract($x, $y)
  {
    return $x - $y;
  }

  function multiply($x, $y)
  {
    return $x * $y;
  }

  function divide($x, $y)
  {
    return $x / $y;
  }
  ?>

</body>

</html>