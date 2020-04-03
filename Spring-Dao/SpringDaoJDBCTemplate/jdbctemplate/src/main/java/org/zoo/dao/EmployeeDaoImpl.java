package org.zoo.dao;

import org.zoo.domain.Employee;

import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public boolean create(Employee employee) {
        return false;
    }

    @Override
    public boolean update(Employee employee) {
        return false;
    }

    @Override
    public boolean delete(Employee employee) {
        return false;
    }

    @Override
    public Employee getById(Integer id) {
        return null;
    }

    @Override
    public List<Employee> getAllByLevel(Integer level) {
        return null;
    }

    @Override
    public boolean create(List<Employee> employees) {
        return false;
    }

    @Override
    public boolean delete(List<Employee> employees) {
        return false;
    }
}
