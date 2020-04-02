package com.arcesium.hrudwik.dao.impl;

import com.arcesium.hrudwik.Employee;
import com.arcesium.hrudwik.dao.EmployeeDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    private Connection connection;
    private Statement stmt;
    public EmployeeDaoImpl(Connection connection) throws SQLException {
        this.connection = connection;
        stmt = connection.createStatement();
    }
    @Override
    public void createEmployee() {
        try {
            stmt = connection.createStatement();

            String sql = "CREATE TABLE Employee " +
                    "(ID numeric PRIMARY KEY NOT NULL," +
                    " FIRST_NAME character varying, " +
                    " LAST_NAME character varying, " +
                    " level character varying)";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertEmployee(Employee e) {
        String sql = "INSERT INTO EMPLOYEE (id, first_name, last_name, level) "
                + "VALUES (" +e.getId()+ ", '" + e.getFirst_name() + "', '"+e.getLast_name()+"', '"+e.getLevel()+"' );";
        System.out.println(sql);
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Employee getEmployee(Integer id) {

        try {
            Employee employee = new Employee();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Employee WHERE id=" + id);
            if(rs.next())
            {
                employee.setId( rs.getInt("id") );
                employee.setFirst_name( rs.getString("first_name") );
                employee.setLast_name( rs.getString("last_name") );
                employee.setLevel( rs.getString("level") );
            }

            return employee;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Employee> getEmployeesByLevel(String level) {
        List<Employee> employees = new ArrayList<>();
        Employee employee = new Employee();
        try {
            String sql = "SELECT * FROM Employee WHERE level='" + level +"'";
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next())
            {
                employee = (Employee) employee.clone();
                employee.setId( rs.getInt("id") );
                employee.setFirst_name( rs.getString("first_name") );
                employee.setLast_name( rs.getString("last_name") );
                employee.setLevel( rs.getString("level") );

                employees.add(employee);
            }

            return employees;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void updateEmployeeLevel(Integer id, String level) {
        try {
            String sql = "UPDATE Employee set Level = '"+ level +"' where ID= "+id+";";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployeeByID(Integer id) {
        try {
            String sql = "Delete from Employee where ID= "+id+";";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
