<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Web Portfolio</title>
</head>

<body>

  <?php

  $name = "Alexander Acojido";

  $headline = "Software Developer";

  $title = array("Skills", "Projects");

  $skills = array("Tailwind", "React");

  $projects = array("FAQ Accordion", "Blog Preview", "Recipe Page");

  ?>

  <style>
    body {
      background-color: #e4e4e7;
      color: #27272a;
    }

    #container {
      display: flex;
      flex-direction: column;
      margin-left: auto;
      margin-right: auto;
      max-width: 64rem;
    }

    .card {
      background-color: rgb(250 250 250);
      border: none black;
      border-radius: 0.5rem;
      padding: 1rem;
      padding-top: 0.25rem;
      padding-bottom: 0.25rem;
      margin-bottom: 1rem;
    }

    ul {
      list-style-type: none;
    }

    li {
      font-size: 1.25rem;
      line-height: 1.75rem;
      padding-bottom: 0.5rem;
    }
  </style>


  <main id="container">
    <div class="card">
      <h1><?php echo $name ?></h1>
      <h2><?php echo $headline ?></h2>
    </div>
    <div class="card">
      <h1><?php echo $title[0] ?></h1>
      <ul>
        <?php
        foreach ($skills as $skill) {
          echo "<li>$skill</li>";
        }
        ?>
      </ul>
    </div>

    <div class="card">
      <h1><?php echo $title[1] ?></h1>
      <ul>
        <?php
        foreach ($projects as $project) {
          echo "<li>$project</li>";
        }
        ?>
      </ul>
    </div>
  </main>
</body>

</html>