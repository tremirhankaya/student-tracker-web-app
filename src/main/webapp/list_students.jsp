<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Student Tracker App</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        .header {
            background-color: #3366CC;
            color: white;
            padding: 20px;
            text-align: center;
            font-size: 2.2em;
            font-weight: bold;
            box-shadow: 0 2px 5px rgba(0,0,0,0.2);
        }

        .container {
            width: 80%;
            margin: 30px auto;
            background-color: white;
            box-shadow: 0 0 15px rgba(0,0,0,0.1);
            border-radius: 8px;
            overflow: hidden;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th {
            background-color: #3366CC;
            color: white;
            padding: 15px;
            text-align: left;
            font-weight: bold;
            text-transform: uppercase;
            font-size: 0.9em;
            letter-spacing: 0.05em;
        }

        td {
            padding: 12px 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
            color: #333;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:nth-child(odd) {
            background-color: #ffffff;
        }

        tr:hover {
            background-color: #e0e0e0;
            cursor: pointer;
        }

        tr:last-child td {
            border-bottom: none;
        }

        .add-button-container {
            text-align: left; 
            margin-bottom: 20px;
            padding-left: 15px;
        }

        .add-button {
            display: inline-block;
            background-color: #3366CC;
            color: white;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            font-size: 1em;
            border-radius: 5px;
            transition: background-color 0.3s ease;
            border: none;
            cursor: pointer;
            margin-top: 14px;
        }

        .add-button:hover {
            background-color: #2c55a5;
        }
    </style>
</head>
<body>
<div class="header">
    FooBar University
</div>

<div class="container">
    <div class="add-button-container">
        <a href="add_student_form.jsp" class="add-button">Add Student</a>
    </div>

    <table>
        <thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="tempStudent" items="${student_list}">
            <tr>
                <td><c:out value="${tempStudent.firstName}"/></td>
                <td><c:out value="${tempStudent.lastName}"/></td>
                <td><c:out value="${tempStudent.email}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>