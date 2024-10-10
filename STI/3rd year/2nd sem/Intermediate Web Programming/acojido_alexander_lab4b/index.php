<h1>Know your Healthful Food!</h1>

<?php

$food = "brocollis";

switch ($food) {
  case "almond":
    echo "<h2>Almond has magnesium, vitamin E, iron, calcium, and fiber.</h2>";
    break;
  case "oatmeal":
    echo "<h2>Oats contains complex carbohydrates, as well as water-soluble fiber.</h2>";
    break;
  case "brocolli":
    echo "<h2>Brocolli provides good amounts of fiber, calcium, potassium, folate, and phtonutrient.</h2>";
    break;
  case "apple":
    echo "<h2>Apples are an excellent source of antioxidants, which combat free radicals.</h2>";
    break;
  case "avocados":
    echo "<h2>Avocados provide healthful fats, as well as B vitamins, vitamin K, and vitamin E.</h2>";
    break;
  case "chicken":
    echo "<h2>Chicken is cost-effective meat that is an excellent source of protein.</h2>";
    break;
  default:
    echo "<h2>Data for Chips is not available. Please try again!</h2>";
}

?>