<html>

<head>
  <title>Laboratory Exercise 2</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <link rel="stylesheet" href="style.css" />
</head>

<body>
  <div class="row header-content">
    <div class="column-12">
      Juan Dela Cruz
    </div>
  </div>

  <div class="row">
    <div class="column-3 border-profile">
      <div class="row">
        <div class="column-12">
          <img src="./images/login_logo.png" />
        </div>
      </div>
      <div class="row">
        <div class="column-12">
          <p>Name: Juan Dela Cruz</p>
        </div>
      </div>
      <div class="row">
        <div class="col-12 menu">
          <ul>
            <?php
            $links = ["Home", "Subjects", "Assignment", "Quiz", "About"];
            foreach ($links as $link) {
              echo "<li>$link</li>";
            }
            ?>
          </ul>
        </div>
      </div>
    </div>
    <div class="column-9">
      <div class="row">
        <div class="column-4 menu">
          <div class="border-subjects">
            <div class="row">
              <div class="column-12">
                <img src="./images/html.png" />
              </div>
            </div>
            <div class="row">
              <div class="column-12">
                <ul>
                  <li class="subject">Web Programming</li>
                  <?php
                  $webLanguages = ["HTML, CSS, and JavaScript", "PHP", "ASP.NET"];
                  foreach ($webLanguages as $webLanguage) {
                    echo "<li>$webLanguage</li>";
                  }
                  ?>
                </ul>
              </div>
            </div>
          </div>
        </div>
        <div class="column-4 menu">
          <div class="border-subjects">
            <div class="row">
              <div class="column-12">
                <img id="img-android" src=./images/android.png />
              </div>
            </div>
            <div class="row">
              <div class="column-12">
                <ul>
                  <li class="subject">Mobile Programming</li>
                  <?php
                  $operatingSystems = ["Android", "iOS", "Windows"];
                  foreach ($operatingSystems as $operatingSystem) {
                    echo "<li>$operatingSystem</li>";
                  }
                  ?>
                </ul>
              </div>
            </div>
          </div>
        </div>
        <div class="column-4 menu">
          <div class="border-subjects">
            <div class="row">
              <div class="column-12">
                <img src="./images/java.png" />
              </div>
            </div>
            <div class="row">
              <div class="column-12">
                <ul>
                  <li class="subject">Desktop Programmming</li>
                  <?php
                  $desktopLanguages = ["Java", "C#", "Python"];
                  foreach ($desktopLanguages as $desktopLanguage) {
                    echo "<li>$desktopLanguage</li>";
                  }
                  ?>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>

</html>