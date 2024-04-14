<?php
session_start();

// Store employee details in session
$_SESSION['eno'] = $_POST['eno'];
$_SESSION['ename'] = $_POST['ename'];
$_SESSION['address'] = $_POST['address'];
?>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Earnings - Page 2</title>
</head>
<body>
    <h2>Enter Employee Earnings</h2>
    <form action="employee_info.php" method="POST">
        Basic: <input type="text" name="basic"><br>
        DA: <input type="text" name="da"><br>
        HRA: <input type="text" name="hra"><br>
        <input type="submit" value="Next">
    </form>
</body>
</html>
