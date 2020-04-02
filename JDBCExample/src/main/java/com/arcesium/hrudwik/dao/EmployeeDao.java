package com.arcesium.hrudwik.dao;

import com.arcesium.hrudwik.Employee;

import java.util.List;

public interface EmployeeDao {
    void createEmployee();
    void insertEmployee(Employee e);
    Employee getEmployee(Integer id);
    List<Employee> getEmployeesByLevel(String level);
    void updateEmployeeLevel(Integer id, String level);
    void deleteEmployeeByID(Integer id);
}
