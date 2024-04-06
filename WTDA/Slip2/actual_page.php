<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Actual Page with Preferences</title>
    <?php
    // Retrieve preferences from cookies
    $font_style = $_COOKIE['font_style'];
    $font_size = $_COOKIE['font_size'];
    $font_color = $_COOKIE['font_color'];
    $bg_color = $_COOKIE['bg_color'];
    ?>
    <style>
        body {
            font-family: <?php echo $font_style; ?>;
            font-size: <?php echo $font_size; ?>;
            color: <?php echo $font_color; ?>;
            background-color: <?php echo $bg_color; ?>;
        }
    </style>
</head>
<body>
    <h2>Actual Page with Preferences</h2>
    <p>This is an example of a page with user-selected preferences.</p>
</body>
</html>
