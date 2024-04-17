<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reverse String</title>
</head>
<body>
    <h2>Enter a String:</h2>
    <form action="Q1.jsp" method="post">
        <input type="text" name="inputString">
        <input type="submit" value="Submit">
    </form>
    <%
        // Get the input string from the request
        String inputString = request.getParameter("inputString");

        if (inputString != null) {
            // Reverse the string
            StringBuilder reversedString = new StringBuilder(inputString).reverse();

            // Display the reversed string
            out.println("<h2>Reversed String:</h2>");
            out.println("<p>" + reversedString + "</p>");
        }
    %>
</body>
</html>
