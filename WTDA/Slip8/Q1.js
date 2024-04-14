// Display message using alert box
alert('Exams are near, have you started preparing for?');

// Prompt user to enter two numbers
var num1 = parseFloat(prompt('Enter the first number:'));
var num2 = parseFloat(prompt('Enter the second number:'));

// Check if the user has entered valid numbers
if (!isNaN(num1) && !isNaN(num2)) {
    // Calculate the addition of two numbers
    var sum = num1 + num2;
    
    // Display the addition result
    alert('The addition of ' + num1 + ' and ' + num2 + ' is: ' + sum);
} else {
    // Display an error message if invalid input is entered
    alert('Please enter valid numbers.');
}
