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

// Calculate total earnings
$total = $basic + $da + $hra;

// Print employee information
echo "<h2>Employee Information</h2>";
echo "Employee Number: $eno<br>";
echo "Employee Name: $ename<br>";
echo "Address: $address<br>";
echo "Basic: $basic<br>";
echo "DA: $da<br>";
echo "HRA: $hra<br>";
echo "Total: $total<br>";

// Destroy session
session_destroy();
?>
