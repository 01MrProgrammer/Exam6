<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Voter Details</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function(){
            $('#submitBtn').click(function(){
                var name = $('#name').val();
                var age = $('#age').val();
                var nationality = $('#nationality').val();

                // Send Ajax request to validate voter details
                $.ajax({
                    url: 'validate_voter.php',
                    method: 'POST',
                    data: { name: name, age: age, nationality: nationality },
                    success: function(response){
                        alert(response);
                    },
                    error: function(xhr, status, error){
                        console.error(error);
                    }
                });
            });
        });
    </script>
</head>
<body>
    <h2>Voter Details</h2>
    <form>
        <label for="name">Name (Upper case only):</label>
        <input type="text" id="name" required><br><br>

        <label for="age">Age (>= 18 years):</label>
        <input type="number" id="age" min="18" required><br><br>

        <label for="nationality">Nationality (Indian):</label>
        <input type="text" id="nationality" required><br><br>

        <button type="button" id="submitBtn">Submit</button>
    </form>
</body>
</html>
