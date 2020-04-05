package com.foo.dao;

import com.foo.domain.Employee;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    @Autowired
    private SqlSession sqlSession;


    @Override
    public boolean create(Employee employee) {
        int noOfRec = sqlSession.insert("Employee.insert", employee);
        sqlSession.commit();
        return noOfRec>0;
    }

    @Override
    public boolean update(Employee employee) {
        int noOfRec = sqlSession.update("Employee.update", employee);
        sqlSession.commit();
        return noOfRec>0;
    }

    @Override
    public boolean delete(Employee employee) {

        int noOfRec = sqlSession.delete("Employee.delete", employee);
        sqlSession.commit();
        return noOfRec>0;
    }

    @Override
    public Employee getById(Integer id) {

        return (Employee) sqlSession.selectOne("Employee.getById", id);
    }

    @Override
    public List<Employee> getAllByLevel(Integer level) {

        List<Employee> employees = sqlSession.selectList("Employee.getAllByLevel", level);
        return employees;
    }

    @Override
    public boolean create(List<Employee> employees) { return false; }

    @Override
    public boolean delete(List<Employee> employees) {
        return false;
    }
}
