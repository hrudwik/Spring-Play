package org.zoo.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.zoo.config.AppConfig;
import org.zoo.domain.Employee;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestAppConfig.class)
@Transactional
public class EmployeeDaoImplTest {

    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void testInsert() {
        Employee employee = new Employee(90, "Harry", "Potter", 900);
        boolean b = employeeDao.create(employee);
        assertTrue(b);
        Employee byId = employeeDao.getById(90);
        assertNotNull(byId);
        assertEquals(byId, employee);
    }
}