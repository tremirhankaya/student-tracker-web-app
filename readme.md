\# Java Student Tracker Web Application



\## Project Description

This is a fundamental Java web application designed for tracking student information. It showcases core concepts of Java web development using Servlets for controller logic, JDBC for database interaction (specifically with PostgreSQL), and JavaServer Pages (JSP) for the view layer. The application is built to run on Apache Tomcat, emphasizing clear, clean, and readable code. It serves as a practical learning resource for those getting started with Java web development.



\## Features

\* Displaying a list of students from a PostgreSQL database.

\* (Future: Adding new students)

\* (Future: Updating existing student information)

\* (Future: Deleting student records)



\## Technologies Used

\* \*\*Java (JDK 8 or higher recommended)\*\*

\* \*\*Apache Tomcat (9.x or higher recommended)\*\*

\* \*\*PostgreSQL\*\*

\* \*\*Servlets\*\*

\* \*\*JSP (JavaServer Pages)\*\*

\* \*\*JDBC (Java Database Connectivity)\*\*

\* \*\*Maven\*\* (for project build and dependency management)



\## Setup and Running the Application



\### Prerequisites

\* Java Development Kit (JDK) installed.

\* Apache Tomcat installed and configured.

\* PostgreSQL installed and running.



\### Database Setup

1\.  \*\*Create a PostgreSQL Database:\*\*

&nbsp;   You can create a new database using `psql` or a graphical tool like pgAdmin.

&nbsp;   ```sql

&nbsp;   CREATE DATABASE studenttrackerdb;

&nbsp;   ```

2\.  \*\*Create the `student` table:\*\*

&nbsp;   Connect to the `studenttrackerdb` and execute the following SQL to create the table:

&nbsp;   ```sql

&nbsp;   CREATE TABLE student (

&nbsp;       id SERIAL PRIMARY KEY,

&nbsp;       first\_name VARCHAR(45) NOT NULL,

&nbsp;       last\_name VARCHAR(45) NOT NULL,

&nbsp;       email VARCHAR(45) NOT NULL

&nbsp;   );

&nbsp;   ```

3\.  \*\*Insert Sample Data (Optional):\*\*

&nbsp;   You can insert some initial data into your table:

&nbsp;   ```sql

&nbsp;   INSERT INTO student (first\_name, last\_name, email) VALUES ('John', 'Doe', 'john.doe@example.com');

&nbsp;   INSERT INTO student (first\_name, last\_name, email) VALUES ('Jane', 'Smith', 'jane.smith@example.com');

&nbsp;   ```

