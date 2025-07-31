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
        try {
            listStudents(req,resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    private void listStudents(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        List<Student> students = studentDbUtil.getStudents();
        req.setAttribute("student_list", students);
        RequestDispatcher rd = req.getRequestDispatcher("list_students.jsp");
        rd.forward(req,resp);


    }


}
