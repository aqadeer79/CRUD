package com.qadeer.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class UtilityDao {

    public static Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root1234"); //
        }catch(Exception e){System.out.println(e.getMessage());}
        return con;
    }

    static String createQuery = "insert into student(name,rollno,age) values (?,?,?)";
    static String updateQuery = "update student set name=?,rollno=?,age=? where id=?";
    static String deleteQuery = "delete from student where id=?";
    static String readQuery = "select * from student where id=?";
    static String readAllQuery = "select * from student";
    static String readRollNoQuery = "select * from student where rollNo=?";

}
