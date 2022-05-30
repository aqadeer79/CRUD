<%@page import = "com.qadeer.web.model.Student"%>
<%@page import = "com.qadeer.web.dao.StudentDao"%>
<%@page import = "java.util.*"%>
<html>
<body>
<h1>Student List</h1>
<table border='1' width='100%'>
<tr><th>Id</th><th>Name</th><th>RollNo</th><th>Age</th></tr>
<%

    List<Student> list = StudentDao.getAllStudents();
    for(Student e:list){
       out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getRollno()+"</td><td>"+e.getAge()+"</td><td>" + "<a href='edit.jsp?id="+e.getId()+"'>edit</a></td><td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>");
    }
%>
</table>
</body>
</html>