<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Patient Details</title>
</head>
<body>

<h2>Enter Patient Details</h2>

<form action="PatientDetails.jsp" method="post">
    <label for="pno">Patient Number:</label>
    <input type="text" id="pno" name="pno"><br>
    
    <label for="pname">Patient Name:</label>
    <input type="text" id="pname" name="pname"><br>
    
    <label for="address">Address:</label>
    <input type="text" id="address" name="address"><br>
    
    <label for="age">Age:</label>
    <input type="text" id="age" name="age"><br>
    
    <label for="disease">Disease:</label>
    <input type="text" id="disease" name="disease"><br>
    
    <input type="submit" value="Submit">
</form>

<%
// Retrieve submitted form data
String pno = request.getParameter("pno");
String pname = request.getParameter("pname");
String address = request.getParameter("address");
String age = request.getParameter("age");
String disease = request.getParameter("disease");

// Display patient details in tabular form if form is submitted
if (pno != null && pname != null && address != null && age != null && disease != null) {
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
    <tr>
        <td><%= pno %></td>
        <td><%= pname %></td>
        <td><%= address %></td>
        <td><%= age %></td>
        <td><%= disease %></td>
    </tr>
</table>

<%
}
%>

</body>
</html>
