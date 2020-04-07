package com.foo;

import com.foo.config.AppConfig;
import com.foo.dao.EmployeeDao;
import com.foo.domain.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        EmployeeDao employeeDao = context.getBean(EmployeeDao.class);


        //Employee mike = new Employee(2, "MikeB", "Wayne", 100);
        //employeeDao.create(mike);
        /*List<Employee> employees = employeeDao.getAllByLevel(100);
        System.out.println(employees);*/

        Employee retrived = employeeDao.getById(2);
        System.out.println(retrived);


        retrived.setFirstName("LMN");
        employeeDao.update(retrived);
        //employeeDao.delete(retrived);


        context.registerShutdownHook();
    }
}
