function validateForm() {
    // Get username and password input values
    var username = document.getElementById('username').value;
    var password = document.getElementById('password').value;

    // Regular expressions for validation
    var usernameRegex = /^[a-zA-Z0-9_]{4,16}$/; // Username must be alphanumeric with underscores and between 4 to 16 characters
    var passwordRegex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$/; // Password must be at least 8 characters long, contain at least one digit, one lowercase and one uppercase letter

    // Validate username
    if (!usernameRegex.test(username)) {
        alert('Username must be alphanumeric with underscores and between 4 to 16 characters.');
        return false;
    }

    // Validate password
    if (!passwordRegex.test(password)) {
        alert('Password must be at least 8 characters long, contain at least one digit, one lowercase and one uppercase letter.');
        return false;
    }

    // If both username and password are valid
    alert('Form submitted successfully!');
    return true;
}
