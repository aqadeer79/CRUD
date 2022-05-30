package com.qadeer.web.dao;

import com.qadeer.web.model.Student;

import java.util.*;
import java.sql.*;

public class StudentDao {
    public static int create(Student e){
        int status=0;
        try{
            Connection con= UtilityDao.getConnection();
            PreparedStatement ps=con.prepareStatement(UtilityDao.createQuery);
            ps.setString(1,e.getName());
            ps.setInt(2,e.getRollno());
            ps.setInt(3,e.getAge());
            status=ps.executeUpdate();

        }catch(Exception ex){ex.getMessage();}

        return status;
    }
    public static int update(Student e){
        int status=0;
        try{
            Connection con= UtilityDao.getConnection();
            PreparedStatement ps=con.prepareStatement(UtilityDao.updateQuery);
            ps.setString(1,e.getName());
            ps.setInt(2,e.getRollno());
            ps.setInt(3,e.getAge());
            ps.setInt(4,e.getId());

            status=ps.executeUpdate();

            con.close();
        }catch(Exception ex){ex.getMessage();}

        return status;
    }
    public static int delete(int id){
        int status=0;
        try{
            Connection con= UtilityDao.getConnection();
            PreparedStatement ps=con.prepareStatement(UtilityDao.deleteQuery);
            ps.setInt(1,id);
            status=ps.executeUpdate();

            con.close();
        }catch(Exception e){e.getMessage();}

        return status;
    }
    public static Student getStudentById(int id){
        Student myStudent=new Student();

        try{
            Connection con= UtilityDao.getConnection();
            PreparedStatement ps=con.prepareStatement(UtilityDao.readQuery);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                myStudent.setId(rs.getInt(1));
                myStudent.setName(rs.getString(2));
                myStudent.setRollno(rs.getInt(3));
                myStudent.setAge(rs.getInt(4));
            }
            con.close();
        }catch(Exception ex){ex.getMessage(); }

        return myStudent;
    }
    public static Student getStudentByRollNo(int rollNo){
        Student myStudent=new Student();

        try{
            Connection con= UtilityDao.getConnection();
            PreparedStatement ps=con.prepareStatement(UtilityDao.readRollNoQuery);
            ps.setInt(1,rollNo);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                myStudent.setId(rs.getInt(1));
                myStudent.setName(rs.getString(2));
                myStudent.setRollno(rs.getInt(3));
                myStudent.setAge(rs.getInt(4));
            }
            con.close();
        }catch(Exception ex){ex.getMessage();}

        return myStudent;
    }
    public static List<Student> getAllStudents(){
        List<Student> list=new ArrayList<Student>();

        try{
            Connection con= UtilityDao.getConnection();
            PreparedStatement ps=con.prepareStatement(UtilityDao.readAllQuery);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Student myStudent=new Student();
                myStudent.setId(rs.getInt(1));
                myStudent.setName(rs.getString(2));
                myStudent.setRollno(rs.getInt(3));
                myStudent.setAge(rs.getInt(4));
                list.add(myStudent);
            }
            con.close();
        }catch(Exception ex){
            ex.getMessage();
        }

        return list;
    }
}