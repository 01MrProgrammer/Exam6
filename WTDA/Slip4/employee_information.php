<?php
session_start();

// Retrieve employee details from session
$eno = $_SESSION['eno'];
$ename = $_SESSION['ename'];
$address = $_SESSION['address'];

// Retrieve earning details from form submission
$basic = $_POST['basic'];
$da = $_POST['da'];
$hra = $_POST['hra'];

// Calculate total earning
$total = $basic + $da + $hra;
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Information</title>
</head>
<body>
    <h2>Employee Information</h2>
    <p>Employee Number: <?php echo $eno; ?></p>
    <p>Employee Name: <?php echo $ename; ?></p>
    <p>Address: <?php echo $address; ?></p>
    <p>Basic: <?php echo $basic; ?></p>
    <p>DA: <?php echo $da; ?></p>
    <p>HRA: <?php echo $hra; ?></p>
    <p>Total Earning: <?php echo $total; ?></p>
</body>
</html>
