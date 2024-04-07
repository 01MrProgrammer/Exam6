<?php
session_start();

// Store employee details in session
$_SESSION['eno'] = $_POST['eno'];
$_SESSION['ename'] = $_POST['ename'];
$_SESSION['address'] = $_POST['address'];
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Earning Details</title>
</head>
<body>
    <h2>Earning Details</h2>
    <form action="employee_information.php" method="post">
        Basic: <input type="text" name="basic"><br>
        DA: <input type="text" name="da"><br>
        HRA: <input type="text" name="hra"><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
