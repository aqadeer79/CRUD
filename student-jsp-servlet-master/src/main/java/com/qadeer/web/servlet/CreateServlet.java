package com.qadeer.web.servlet;

import com.qadeer.web.dao.StudentDao;
import com.qadeer.web.model.Student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        String name=request.getParameter("name");
        int rollno = Integer.parseInt(request.getParameter("rollno"));
        int age = Integer.parseInt(request.getParameter("age"));

        Student myStudent = new Student();
        myStudent.setName(name);
        myStudent.setRollno(rollno);
        myStudent.setAge(age);

        int status= StudentDao.create(myStudent);
        if(status>0){
            out.print("<p>Student Created successfully!</p>");
            request.getRequestDispatcher("index.html").include(request, response);
        }else{
            out.println("Student Entry Failed!. Please check if the rollno is unique");
        }

        out.close();
    }

}
