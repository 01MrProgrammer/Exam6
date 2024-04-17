<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Patient Details</title>
</head>
<body>

<%
// Sample patient data
String[][] patients = {
    {"101", "John Doe", "123 Main St", "35", "Fever"},
    {"102", "Jane Smith", "456 Elm St", "45", "Headache"},
    {"103", "Alice Johnson", "789 Oak St", "28", "Stomachache"}
};
%>

<h2>Patient Details</h2>

<table border="1">
    <tr>
        <th>Patient Number</th>
        <th>Name</th>
        <th>Address</th>
        <th>Age</th>
        <th>Disease</th>
    </tr>
    <% for (String[] patient : patients) { %>
    <tr>
        <td><%= patient[0] %></td>
        <td><%= patient[1] %></td>
        <td><%= patient[2] %></td>
        <td><%= patient[3] %></td>
        <td><%= patient[4] %></td>
    </tr>
    <% } %>
</table>

</body>
</html>
