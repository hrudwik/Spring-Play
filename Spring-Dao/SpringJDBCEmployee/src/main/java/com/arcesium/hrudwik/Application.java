package com.arcesium.hrudwik;

import com.arcesium.hrudwik.configuration.AppConfig;
import com.arcesium.hrudwik.dao.EmployeeDao;
import com.arcesium.hrudwik.dao.impl.EmployeeDaoImpl;
import com.arcesium.hrudwik.model.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Application {

    public static void main(String[] args) throws SQLException {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        //This will get the bean EmployeeDaoImpl as there is only one implementation of it
        EmployeeDao employeeDao = context.getBean(EmployeeDao.class);


        //To create table
        //employeeDao.createEmployee();

        //Inserting Record in Table
        //Just creating Employees using new instead of getting it from container
        employeeDao.insertEmployee(new Employee(1, "AA", "AA", "MD"));
        employeeDao.insertEmployee(new Employee(2, "BB", "BB", "MB"));
        employeeDao.insertEmployee(new Employee(3, "CC", "CC", "MC"));


        //Updating Record in Table
        employeeDao.updateEmployeeLevel(2, "MX");
        employeeDao.updateEmployeeLevel(3, "MX");

        //get employee by Id
        Employee emp2 = employeeDao.getEmployee(1);
        System.out.println(emp2);

        //Delete employee by Id
        employeeDao.deleteEmployeeByID(1);

        //Get all employees by level
        List<Employee> employees = employeeDao.getEmployeesByLevel("MX");
        System.out.println(employees.size());
        employees.forEach(e -> System.out.println(e));
    }
}
