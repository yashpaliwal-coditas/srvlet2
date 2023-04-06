<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>
	<h1>Registration Form</h1>
    <form action="register" method="get" enctype="multipart/form-data">
        <label for="first-name">First Name:</label>
        <input type="text" id="first-name" name="first-name" required><br><br>
        <label for="last-name">Last Name:</label>
        <input type="text" id="last-name" name="last-name" required><br><br>
        <label for="dob">Date of Birth:</label>
        <input type="text" id="dob" name="dob" required><br><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
        <label for="profile-image">Profile Image:</label>
        <input type="file" id="profile-image" name="profile-image"><br><br>
        <label for="Resume">Resume:</label>
        <input type="file" id="resume" name="resume"><br><br>
        <label for="address">Address:</label>
        <textarea id="address" name="address" rows="3" cols="30" required></textarea><br><br>
        <label for="phone">Phone Number:</label>
        <input type="text" id="phone" name="phone" required><br><br>
        <input type="submit" value="Submit">
        <input type="reset" value="Reset">
    </form>
    <form action="redirectLogin" method="get">
        <input type="submit" value="Submit">
    </form>

</body>
</html>
