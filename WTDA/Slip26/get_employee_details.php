<?php
// Establish database connection
$servername = "localhost";
$username = "username"; // Change to your database username
$password = "password"; // Change to your database password
$dbname = "your_database"; // Change to your database name

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Get selected employee name from Ajax request
$selectedEmployee = $_POST['employee_name'];

// Retrieve employee details from database
$sql = "SELECT * FROM EMP WHERE ename = '$selectedEmployee'";
$result = $conn->query($sql);

// Display employee details
if ($result->num_rows > 0) {
    // Output data of each row
    while($row = $result->fetch_assoc()) {
        echo "Employee Number: " . $row["eno"]. "<br>";
        echo "Employee Name: " . $row["ename"]. "<br>";
        echo "Designation: " . $row["designation"]. "<br>";
        echo "Salary: " . $row["salary"]. "<br>";
    }
} else {
    echo "No employee found with the name: " . $selectedEmployee;
}

$conn->close();
?>
