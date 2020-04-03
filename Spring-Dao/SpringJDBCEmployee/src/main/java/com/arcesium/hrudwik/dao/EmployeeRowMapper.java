package com.arcesium.hrudwik.dao;

import com.arcesium.hrudwik.model.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setId( rs.getInt("id") );
        employee.setFirst_name( rs.getString("first_name") );
        employee.setLast_name( rs.getString("last_name") );
        employee.setLevel( rs.getString("level") );
        return employee;
    }
}
