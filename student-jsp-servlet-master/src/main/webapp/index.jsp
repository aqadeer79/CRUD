<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student app</title>
</head>
<body>
<a href="view.jsp">view all students</a>

<h1>Add New Student</h1>
<form action="CreateServlet" method="post">
<table>
<tr><td>Name:</td><td><input type="text" name="name"/></td></tr>
<tr><td>RollNo:</td><td><input type="rollno" name="rollno"/></td></tr>
<tr><td>Age:</td><td><input type="age" name="age"/></td></tr>
</td></tr>
<tr><td colspan="2"><input type="submit" value="Save Student"/></td></tr>
</table>
</form>

<h1>Search Student by Rollno</h1>
<form action="ReadServlet" method="post">
<table>
<tr><td>RollNo:</td><td><input type="rollno" name="rollno"/></td></tr>
<tr><td colspan="2"><input type="submit" value="Search student"/></td></tr>
</table>
</form>
<br/>

</body>
</html>