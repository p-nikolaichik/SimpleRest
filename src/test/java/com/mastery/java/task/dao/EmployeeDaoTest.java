package com.mastery.java.task.dao;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.dto.Gender;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EmployeeDaoTest {

    @Resource
    private EmployeeDao employeeDao;

    @Test
    public void getAllEmployee() {
        Assert.assertTrue(employeeDao.findAll() != null);
    }

    @Test
    public void getEmployee() {
        Optional optionalEmployee = employeeDao.findById((long) 1);
        Employee employee = (Employee) optionalEmployee.get();
        Assert.assertEquals("PETR", employee.getFirstName());
        Assert.assertEquals("PETROV", employee.getLastName());
        Assert.assertEquals("4", employee.getDepartmentId());
    }

    @Test
    public void saveEmployee() {
        Employee employee = createNewEmployee();
        employeeDao.save(createNewEmployee());
        Optional optionalEmployee = employeeDao.findById((long) 3);
        Employee addedEmployee = (Employee) optionalEmployee.get();
        Assert.assertEquals(employee.getFirstName(), addedEmployee.getFirstName());
    }

    private Employee createNewEmployee() {
        return new Employee("Test", "Test", "0", "developer", Gender.MALE, "01.01.1993");
    }
}
