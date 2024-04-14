<html>
<head>
    <title>Palindrome and Reverse</title>
</head>
<body>
    <form action="<?php echo $_SERVER['PHP_SELF']; ?>" method="POST">
        Enter Number: <input type="text" name="t1"><br>
        <input type="radio" name="r1" value="1">Check whether it is palindrome or not<br>
        <input type="radio" name="r1" value="2">Reverse the number using Recursion<br>
        <input type="submit" value="Convert"><br>
    </form>

    <?php
    $num = $_POST['t1'];
    $op = $_POST['r1'];

    function palindrome($num) {
        $temp = $num;
        $m = 0;
        while ($num > 1) {
            $r = $num % 10;
            $m = $m * 10 + $r;
            $num = $num / 10;
        }
        if ($temp == $m) {
            echo "It is a Palindrome number";
        } else {
            echo "It is Not a Palindrome number";
        }
    }

    function reverse($num) {
        static $m = 0;
        if ($num > 1) {
            $r = $num % 10;
            $m = $m * 10 + $r;
            reverse($num / 10);
        } else {
            echo "Reverse of the number is: $m";
        }
    }

    switch ($op) {
        case 1:
            palindrome($num);
            break;
        case 2:
            reverse($num);
            break;
    }
    ?>
</body>
</html>
