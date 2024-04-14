<?php
// Create student data
$students = [
    ["roll_no" => "1", "name" => "John Doe", "address" => "123 Main St", "college" => "ABC College", "course" => "Computer Science"],
    ["roll_no" => "2", "name" => "Alice Smith", "address" => "456 Elm St", "college" => "XYZ College", "course" => "Engineering"],
    ["roll_no" => "3", "name" => "Michael Johnson", "address" => "789 Oak St", "college" => "PQR College", "course" => "Computer Science"],
    ["roll_no" => "4", "name" => "Sarah Lee", "address" => "101 Maple St", "college" => "LMN College", "course" => "Engineering"],
];

// Create XML file
$xml = new SimpleXMLElement('<students></students>');

foreach ($students as $student) {
    $student_node = $xml->addChild('student');
    $student_node->addChild('roll_no', $student['roll_no']);
    $student_node->addChild('name', $student['name']);
    $student_node->addChild('address', $student['address']);
    $student_node->addChild('college', $student['college']);
    $student_node->addChild('course', $student['course']);
}

// Save XML to file
$xml_file = 'students.xml';
$xml->asXML($xml_file);

echo "student.xml file created successfully.<br>";

// Accept course as input
if (isset($_GET['course'])) {
    $course = $_GET['course'];

    // Print students detail of specific course in tabular format
    echo "<h2>Students Details for Course: $course</h2>";
    echo "<table border='1'>";
    echo "<tr><th>Roll No</th><th>Name</th><th>Address</th><th>College</th><th>Course</th></tr>";
    foreach ($students as $student) {
        if ($student['course'] == $course) {
            echo "<tr>";
            echo "<td>{$student['roll_no']}</td>";
            echo "<td>{$student['name']}</td>";
            echo "<td>{$student['address']}</td>";
            echo "<td>{$student['college']}</td>";
            echo "<td>{$student['course']}</td>";
            echo "</tr>";
        }
    }
    echo "</table>";
}
?>

<!-- Form to accept course input -->
<form action="" method="get">
    <label for="course">Enter Course:</label>
    <input type="text" name="course" id="course">
    <input type="submit" value="Submit">
</form>
