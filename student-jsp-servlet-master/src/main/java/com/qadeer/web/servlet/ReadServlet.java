package com.qadeer.web.servlet;

import com.qadeer.web.dao.StudentDao;
import com.qadeer.web.model.Student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ReadServlet")
public class ReadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        int rollno = Integer.parseInt(request.getParameter("rollno"));
        Student myStudent = StudentDao.getStudentByRollNo(rollno);

        request.setAttribute("student", myStudent);
        RequestDispatcher rd = request.getRequestDispatcher("read.jsp");
        rd.forward(request, response);


        out.close();
    }

}