<?php
// Start the session
session_start();

// Check if the counter variable is set in the session
if (!isset($_SESSION['page_visit_count'])) {
    // If not set, initialize it to 1
    $_SESSION['page_visit_count'] = 1;
} else {
    // If set, increment the counter
    $_SESSION['page_visit_count']++;
}

// Display the number of page visits
echo "You have visited this page ".$_SESSION['page_visit_count']." times.";

// You can display the rest of your webpage content here
?>
