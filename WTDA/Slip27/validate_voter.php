<?php
// Retrieve voter details from Ajax request
$name = $_POST['name'];
$age = $_POST['age'];
$nationality = $_POST['nationality'];

// Perform validation
$errors = [];

// Validate name (should be in upper case)
if ($name !== strtoupper($name)) {
    $errors[] = "Name should be in upper case letters only.";
}

// Validate age (should be >= 18)
if ($age < 18) {
    $errors[] = "Age should not be less than 18 years.";
}

// Validate nationality (should be Indian)
if (strtolower($nationality) !== 'indian') {
    $errors[] = "Nationality should be Indian.";
}

// Return response
if (empty($errors)) {
    echo "Voter details are valid.";
} else {
    echo implode("\n", $errors);
}
?>
