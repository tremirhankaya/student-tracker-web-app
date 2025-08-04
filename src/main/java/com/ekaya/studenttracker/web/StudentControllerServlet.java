package com.ekaya.studenttracker.web;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
    private StudentDbUtil studentDbUtil;
    @Resource(name = "jdbc/postgres")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();
        try{
            studentDbUtil=new StudentDbUtil(dataSource);


        }catch (Exception e){
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try{

        String theCommand = req.getParameter("command");
        if(theCommand==null){
            theCommand="LIST";
        }
        switch(theCommand){
            case "LIST":
                listStudents(req,resp);
                break;


            case "LOAD":
                loadStudent(req,resp);
                break;

            case "UPDATE":
                updateStudent(req,resp);
                break;

                case "DELETE":
                    deleteStudent(req,resp);
                    break;


            default:
                listStudents(req,resp);
                break;
        }

    }catch(Exception e){
        throw new ServletException(e);
    }


    }

    private void deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, SQLException, IOException {
     String theStudentId =req.getParameter("studentId");
     studentDbUtil.deleteStudent(theStudentId);
     listStudents(req, resp);


    }

    private void updateStudent(HttpServletRequest req, HttpServletResponse resp) throws Exception {
    int id=Integer.parseInt(req.getParameter("studentId"));
    String firstName=req.getParameter("firstName");
    String lastName=req.getParameter("lastName");
    String email=req.getParameter("email");
    Student theStudent=new Student(id,firstName,lastName,email);
    studentDbUtil.updateStudent(theStudent);
    listStudents(req, resp);
    }

    private void loadStudent(HttpServletRequest req, HttpServletResponse resp) throws Exception {
   String theStudentId = req.getParameter("studentId");
   Student theStudent = studentDbUtil.getStudent(theStudentId);
   req.setAttribute("student",theStudent);
   RequestDispatcher rd=  req.getRequestDispatcher("update_student_form.jsp");
   rd.forward(req,resp);
    }

    private void addStudent(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        String firstName=req.getParameter("firstName");
        String lastName=req.getParameter("lastName");
        String email=req.getParameter("email");
        Student theStudent=new Student(firstName,lastName,email);
        studentDbUtil.addStudent(theStudent);
        resp.sendRedirect(req.getContextPath() + "/StudentControllerServlet?command=LIST");
    }

    private void listStudents(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        List<Student> students = studentDbUtil.getStudents();
        req.setAttribute("student_list", students);
        RequestDispatcher rd = req.getRequestDispatcher("list_students.jsp");
        rd.forward(req,resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            // read the "command" parameter
            String theCommand = req.getParameter("command");

            // route to the appropriate method
            switch (theCommand) {

                case "ADD":
                    addStudent(req, resp);
                    break;

                default:
                    listStudents(req, resp);
            }

        }
        catch (Exception exc) {
            throw new ServletException(exc);
        }

    }
    }

