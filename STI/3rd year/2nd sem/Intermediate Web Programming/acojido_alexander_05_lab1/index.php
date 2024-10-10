<h1>D-I-Y Cake</h1>

<table border="1">
  <tr>
    <th>Cake Shape</th>
    <th>Cake Flavor</th>
    <th>Cake Toppings</th>
  </tr>
  <tr>
    <td>
      <?php
      $cakeShapes = ["Heart", "Rectangle", "Square", "Round"];
      foreach ($cakeShapes as $cakeShape) {
        echo "<input type='radio'>$cakeShape</br>";
      }
      ?>
    </td>
    <td>
      <?php
      $cakeFlavors = ["Chocolate", "Vanilla", "Lemon", "Cheesecake"];
      foreach ($cakeFlavors as $cakeFlavor) {
        echo "<input type='radio'>$cakeFlavor</br>";
      }
      ?>
    </td>
    <td>
      <?php
      $cakeToppings = ["Cookies", "Spun-sugar Flowers", "Mini Chocolate Candies", "Marshmallows"];
      foreach ($cakeToppings as $cakeTopping) {
        echo "<input type='radio'>$cakeTopping</br>";
      }
      ?>
    </td>
  </tr>
</table>