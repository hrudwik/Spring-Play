package com.arcesium.hrudwik;

import com.arcesium.hrudwik.dao.impl.EmployeeDaoImpl;
import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class PostgreSQLJDBC {

    public static final String URL      = "jdbc:postgresql://localhost:5432/postgres";   //database specific url.
    public static final String USER     = "postgres";
    public static final String PASSWORD = "password";

    public static Connection getConnection()
    {
        try {
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }

    public static void main(String[] args) throws SQLException {
        PostgreSQLJDBC postgreSQLJDBC = new PostgreSQLJDBC();
        Connection connection = postgreSQLJDBC.getConnection();

        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl(connection);

        //To create table
        employeeDao.createEmployee();

        //Inserting Record in Table
        employeeDao.insertEmployee(new Employee(1, "DD", "DD", "MD"));
        employeeDao.insertEmployee(new Employee(2, "BB", "BB", "MC"));
        employeeDao.insertEmployee(new Employee(3, "CC", "CC", "MC"));


        //Updating Record in Table
        employeeDao.updateEmployeeLevel(1, "MA");

        //get employee by Id
        Employee emp2 = employeeDao.getEmployee(1);
        System.out.println(emp2);

        //Delete employee by Id
        employeeDao.deleteEmployeeByID(1);

        //Get all employees by level
        List<Employee> employees = employeeDao.getEmployeesByLevel("MC");
        System.out.println(employees.size());
        employees.forEach(e -> System.out.println(e));
    }
}
