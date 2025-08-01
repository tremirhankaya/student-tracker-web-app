package com.ekaya.studenttracker.web;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDbUtil {
    private DataSource dataSource;

    public StudentDbUtil(DataSource theDataSource) {
        this.dataSource = theDataSource;
    }

    public void updateStudent(Student theStudent) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stms = null;


        try {
            conn = dataSource.getConnection();
            String sql = "UPDATE student SET first_name = ?, last_name = ?, email = ? WHERE id = ?";
            stms = conn.prepareStatement(sql);
            stms.setString(1, theStudent.getFirstName());
            stms.setString(2, theStudent.getLastName());
            stms.setString(3, theStudent.getEmail());
            stms.setInt(4, theStudent.getId());
            stms.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(conn, stms, null);
        }


    }

    public void addStudent(Student theStudent) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = dataSource.getConnection();
            String query = "INSERT INTO student(first_name,last_name,email) VALUES (?,?,?)";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, theStudent.getFirstName());
            stmt.setString(2, theStudent.getLastName());
            stmt.setString(3, theStudent.getEmail());

            stmt.executeUpdate();


        } finally {
            close(conn, stmt, null);
        }

    }

    public List<Student> getStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = dataSource.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from student";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("first_name");
                String surname = rs.getString("last_name");
                String email = rs.getString("email");
                Student student = new Student(id, name, surname, email);
                students.add(student);
            }
            return students;

        } finally {
            close(conn, stmt, rs);
        }

    }

    private void close(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }

        } catch (Exception e) {


        }
    }

    public Student getStudent(String theStudentId) throws Exception {
        Student student = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int studentId;
        try {
            studentId = Integer.parseInt(theStudentId);

            conn = dataSource.getConnection();

            String query = "select * from student where id=?";

            stmt = conn.prepareStatement(query);

            stmt.setInt(1, studentId);

            rs = stmt.executeQuery();

            if (rs.next()) {
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");

                student = new Student(studentId, firstName, lastName, email);
            } else {
                throw new Exception("Could not find student id");
            }


            return student;

        } finally {
            close(conn, stmt, rs);
        }
    }
}
