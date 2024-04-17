<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Prime Number Checker</title>
</head>
<body>
    <h2>Prime Number Checker</h2>
    <form method="post">
        Enter a number: <input type="number" name="number" required><br>
        <input type="submit" value="Check">
    </form>
    <%
        // Function to check whether a number is prime
        boolean isPrime(int n) {
            if (n <= 1) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }

        if (request.getMethod().equals("POST")) {
            int number = Integer.parseInt(request.getParameter("number"));
            boolean prime = isPrime(number);

            out.println("<p>");
            if (prime) {
                out.println(number + " is a prime number.");
            } else {
                out.println(number + " is not a prime number.");
            }
            out.println("</p>");
        }
    %>
</body>
</html>
