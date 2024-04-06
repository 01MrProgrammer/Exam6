<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Display Preferences</title>
</head>
<body>
    <h2>Selected Preferences</h2>
    <?php
    // Retrieve preferences from cookies
    $font_style = $_COOKIE['font_style'];
    $font_size = $_COOKIE['font_size'];
    $font_color = $_COOKIE['font_color'];
    $bg_color = $_COOKIE['bg_color'];
    ?>
    <p>Font Style: <?php echo $font_style; ?></p>
    <p>Font Size: <?php echo $font_size; ?></p>
    <p>Font Color: <span style="color: <?php echo $font_color; ?>"><?php echo $font_color; ?></span></p>
    <p>Background Color: <span style="background-color: <?php echo $bg_color; ?>"><?php echo $bg_color; ?></span></p>
    <p><a href="actual_page.php">Go to Actual Page</a></p>
</body>
</html>




