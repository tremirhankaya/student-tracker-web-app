# 🚀 Java Student Tracker Web Application

![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=openjdk&logoColor=white)
![Apache Tomcat](https://img.shields.io/badge/Apache%20Tomcat-F8DC75?style=for-the-badge&logo=apache-tomcat&logoColor=black)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![JDBC](https://img.shields.io/badge/JDBC-007396?style=for-the-badge&logo=java&logoColor=white)
![JSP](https://img.shields.io/badge/JSP-F05032?style=for-the-badge&logo=java&logoColor=white)
![Servlets](https://img.shields.io/badge/Servlets-F05032?style=for-the-badge&logo=java&logoColor=white)

## 💡 Project Origin
This project is developed by following the comprehensive **"JSP, Servlets and JDBC for Beginners: Build a Database App"** course by **Chad Darby**. It serves as a practical implementation of the concepts taught, focusing on building a robust backend for web applications.

## 📝 Project Description
This is a fundamental Java web application designed for tracking student information. Its **primary focus is on demonstrating core backend concepts and CRUD (Create, Read, Update, Delete) operations**, rather than complex UI design. The application utilizes **Servlets** for handling controller logic and **JDBC** for robust database interaction (specifically with **PostgreSQL**). Running efficiently on **Apache Tomcat**, the front-end is built using **JavaServer Pages (JSP)**, providing a **functional and straightforward user interface** to facilitate interaction with the core backend functionalities.

## ✨ Features
* 📊 Displaying a list of students from a PostgreSQL database.
* ➕ Adding new students to the database.
* ✏️ Updating existing student information.
* 🗑️ Deleting student records with a confirmation prompt.

## 🛠️ Technologies Used
* **Java (JDK 8 or higher recommended)**
* **Apache Tomcat (9.x or higher recommended)**
* **PostgreSQL**
* **Servlets**
* **JSP (JavaServer Pages)**
* **JDBC (Java Database Connectivity)**
* **Maven** (for project build and dependency management)

## ⚙️ Setup and Running the Application

### Prerequisites
* ☕ Java Development Kit (JDK) installed.
* 🐱 Apache Tomcat installed and configured.
* 🐘 PostgreSQL installed and running.

### Database Setup
1.  **Create a PostgreSQL Database:**
    You can create a new database using `psql` or a graphical tool like pgAdmin.
    ```sql
    CREATE DATABASE studenttrackerdb;
    ```
2.  **Create the `student` table:**
    Connect to the `studenttrackerdb` and execute the following SQL to create the table:
    ```sql
    CREATE TABLE student (
        id SERIAL PRIMARY KEY,
        first_name VARCHAR(45) NOT NULL,
        last_name VARCHAR(45) NOT NULL,
        email VARCHAR(45) NOT NULL
    );
    ```
3.  **Insert Sample Data (Optional):**
    You can insert some initial data into your table:
    ```sql
    INSERT INTO student (first_name, last_name, email) VALUES ('John', 'Doe', 'john.doe@example.com');
    INSERT INTO student (first_name, last_name, email) VALUES ('Jane', 'Smith', 'jane.smith@example.com');
    ```