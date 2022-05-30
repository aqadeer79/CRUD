<%@ page import = "com.qadeer.web.dao.StudentDao, com.qadeer.web.model.Student"%>
<%@ page import = "java.io.IOException, java.io.PrintWriter"%>

<h1>Update Student</h1>

<% String sid=request.getParameter("id");
int id=Integer.parseInt(sid);
Student e= StudentDao.getStudentById(id);
%>

<form action='UpdateServlet' method='post'>
<table>
<%
    out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");
    out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");
    out.print("<tr><td>RollNo:</td><td><input type='rollno' name='rollno' value='"+e.getRollno()+"'/></td></tr>");
    out.print("<tr><td>Age:</td><td><input type='age' name='age' value='"+e.getAge()+"'/></td></tr>");
    out.print("</select>");
%>
</td></tr>
<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>
</table>
</form>

 <% out.close();%>
    }
}