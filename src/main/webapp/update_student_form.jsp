<!DOCTYPE html>
<html>
<head>
    <title>Update Student</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            display: flex;
            flex-direction: column;
            align-items: center;
            min-height: 100vh;
        }

        #wrapper {
            width: 100%;
        }

        #header {
            background-color: #3366CC;
            color: white;
            padding: 20px;
            text-align: center;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
            flex-shrink: 0;
        }

        #header h2 {
            margin: 0;
            font-size: 2.2em;
            font-weight: bold;
        }

        #container {
            background-color: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
            margin: 30px auto;
            width: 400px;
            flex-grow: 1;
            display: flex;
            flex-direction: column;
            justify-content: center;
        }

        h3 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        form table {
            width: 100%;
            border-collapse: collapse;
        }

        form table td {
            padding: 10px 0;
            vertical-align: top;
        }

        form label {
            display: inline-block;
            margin-right: 10px;
            color: #555;
            font-weight: bold;
        }

        form input[type="text"],
        form input[type="email"] {
            width: calc(100% - 22px);
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            font-size: 1em;
        }

        form input[type="text"]:focus,
        form input[type="email"]:focus {
            outline: none;
            border-color: #3366CC;
            box-shadow: 0 0 5px rgba(51, 102, 204, 0.5);
        }

        .save {
            width: auto;
            padding: 10px 20px;
            background-color: #5cb85c;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 1em;
            transition: background-color 0.3s ease;
            display: block;
            margin-top: 5px;
        }

        .save:hover {
            background-color: #4cae4c;
        }

        p a {
            color: #3366CC;
            text-decoration: none;
            font-weight: bold;
            display: block;
            text-align: center;
            margin-top: 20px;
        }

        p a:hover {
            text-decoration: underline;
        }

        .clear {
            clear: both;
        }
    </style>
</head>

<body>
<div id="wrapper">
    <div id="header">
        <h2>FooBar University</h2>
    </div>
</div>

<div id="container">
    <h3>Add Student</h3>

    <form action="StudentControllerServlet" method="GET">

        <input type="hidden" name="command" value="UPDATE"/>
        <input type="hidden" name="studentId" value="${student.id}"/>

        <table>
            <tbody>
            <tr>
                <td><label>First name:</label></td>
                <td><input type="text" name="firstName"
                           value="${student.firstName}"/></td>
            </tr>

            <tr>
                <td><label>Last name:</label></td>
                <td><input type="text" name="lastName"
                           value="${student.lastName}"/>
                </td>
            </tr>

            <tr>
                <td><label>Email:</label></td>
                <td><input type="text" name="email"
                           value="${student.email}"/></td>
            </tr>

            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" class="save"/>
                </td>
            </tr>

            </tbody>
        </table>
    </form>

    <div style="clear: both;"></div>

    <p>
        <a href="StudentControllerServlet">Back to List</a>
    </p>
</div>
</body>

</html>