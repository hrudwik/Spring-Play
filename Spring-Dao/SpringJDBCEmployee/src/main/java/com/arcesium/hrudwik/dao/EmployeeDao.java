package com.arcesium.hrudwik.dao;

import com.arcesium.hrudwik.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface EmployeeDao {

    void createEmployee();
    Employee getEmployee(Integer id);
    List<Employee> getEmployeesByLevel(String level);
    int insertEmployee(Employee e);
    int updateEmployeeLevel(Integer id, String level);
    int deleteEmployeeByID(Integer id);
}
