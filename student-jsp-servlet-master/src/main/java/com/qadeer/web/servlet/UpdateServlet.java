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


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int rollno = Integer.parseInt(request.getParameter("rollno"));
        int age = Integer.parseInt(request.getParameter("age"));


        Student myStudent = new Student();
        myStudent.setId(id);
        myStudent.setName(name);
        myStudent.setRollno(rollno);
        myStudent.setAge(age);

        int status = StudentDao.update(myStudent);
        if(status>0){
            response.sendRedirect("view.jsp");
        }else{
            out.println("Sorry! unable to update record");
        }

        out.close();
    }

}