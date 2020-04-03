package com.arcesium.hrudwik.dao.impl;

import com.arcesium.hrudwik.dao.EmployeeDao;
import com.arcesium.hrudwik.dao.EmployeeRowMapper;
import com.arcesium.hrudwik.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createEmployee() {
        String sql = "CREATE TABLE Employee " +
                "(ID numeric PRIMARY KEY NOT NULL," +
                " FIRST_NAME character varying, " +
                " LAST_NAME character varying, " +
                " level character varying)";
        jdbcTemplate.execute(sql);
    }

    @Override
    public int insertEmployee(Employee e) {
        String sql = "INSERT INTO EMPLOYEE (id, first_name, last_name, level) "
                + "VALUES (" +e.getId()+ ", '" + e.getFirst_name() + "', '"+e.getLast_name()+"', '"+e.getLevel()+"' );";

        return jdbcTemplate.update(sql);
    }

    @Override
    public Employee getEmployee(Integer id) {
        String sql = "SELECT * FROM Employee WHERE id=" + id+";";

        //We can use BeanPropertyRowMapper for ease of use, instead of custom mapper
        //return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Employee.class));

        return jdbcTemplate.queryForObject(sql, new EmployeeRowMapper());
    }

    @Override
    public List<Employee> getEmployeesByLevel(String level) {
        String sql = "SELECT * FROM Employee WHERE level='" + level +"'";

        /*We can use BeanPropertyRowMapper for ease of use, instead of custom mapper
        List<Employee> employees = jdbcTemplate.query(
                sql,
                BeanPropertyRowMapper.newInstance(Employee.class));*/

        List<Employee> employees = jdbcTemplate.query(
                sql,
                new EmployeeRowMapper());

        return employees;
    }

    @Override
    public int updateEmployeeLevel(Integer id, String level) {
        String sql = "UPDATE Employee set Level = '"+ level +"' where ID= "+id+";";
        return jdbcTemplate.update(sql);
    }

    @Override
    public int deleteEmployeeByID(Integer id) {
        String sql = "Delete from Employee where ID= "+id+";";
        return jdbcTemplate.update(sql);
    }
}
