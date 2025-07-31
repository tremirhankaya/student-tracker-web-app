<%--
  Created by IntelliJ IDEA.
  User: ekaya
  Date: 7/31/2025
  Time: 3:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.ekaya.studenttracker.web.*" %>

<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Tracker App</title>
</head>
<%
List<Student> theStudents= (List <Student>) request.getAttribute("student_list");


%>
<body>
<%=theStudents %>

</body>
</html>
