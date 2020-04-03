package org.zoo;

import org.jeasy.random.EasyRandom;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.zoo.config.AppConfig;
import org.zoo.dao.EmployeeDao;
import org.zoo.domain.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        EmployeeDao employeeDao = context.getBean(EmployeeDao.class);

        Employee batman = new Employee(7, "Bruce", "Wayne", 100);
        boolean created = employeeDao.create(batman);
        assert created;

        Employee byId = employeeDao.getById(7);
        System.out.println("Get employee by id : "+ byId);
        assert batman.equals(byId);

        Employee superman = new Employee(16, "Clark", "Kent", 500);
        created = employeeDao.create(superman);
        assert created;

        List<Employee> allByLevel = employeeDao.getAllByLevel(500);
        System.out.println("All 500 level employees :"+allByLevel);
        assert allByLevel.size() == 1;

        batman.setLevel(500);
        boolean updated = employeeDao.update(batman);
        assert updated;

        allByLevel = employeeDao.getAllByLevel(500);
        System.out.println("All 500 level employees :"+allByLevel);

        assert allByLevel.size() == 2;

        employeeDao.delete(batman);
        employeeDao.delete(superman);
        assert employeeDao.getById(7) == null;

        //Create Random objects
        EasyRandom easyRandom = new EasyRandom();
        List<Employee> employees = easyRandom.objects(Employee.class, 10).collect(Collectors.toList());
        boolean isBatchUpdateSuccessfull = employeeDao.create(employees);
        assert isBatchUpdateSuccessfull;

        boolean isBatchDeleteSuccessfull = employeeDao.delete(employees);
        assert isBatchDeleteSuccessfull;
    }
}
