<!DOCTYPE html>
<html>
<head>
    <title>Number Operations</title>
</head>
<body>
    <h2>Number Operations</h2>
    <form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">
        Enter a number: <input type="number" name="number" required><br><br>
        <input type="submit" name="submit" value="Submit">
    </form>

    <?php
    // Function to calculate Fibonacci series
    function fibonacci($n) {
        $fib = array();
        $fib[0] = 0;
        $fib[1] = 1;
        for ($i = 2; $i < $n; $i++) {
            $fib[$i] = $fib[$i - 1] + $fib[$i - 2];
        }
        return $fib;
    }

    // Function to calculate sum of digits
    function sumOfDigits($number) {
        $sum = 0;
        while ($number != 0) {
            $sum += $number % 10;
            $number = (int)($number / 10);
        }
        return $sum;
    }

    // Check if form is submitted
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $number = $_POST["number"];

        echo "<h3>Results:</h3>";
        echo "Fibonacci Series for the number $number: ";
        $fibonacciSeries = fibonacci($number);
        echo implode(", ", $fibonacciSeries) . "<br>";

        echo "Sum of digits for the number $number: ";
        $sum = sumOfDigits($number);
        echo "$sum<br>";
    }
    ?>

</body>
</html>
