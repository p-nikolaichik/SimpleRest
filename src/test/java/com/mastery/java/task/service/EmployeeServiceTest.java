package com.mastery.java.task.service;

import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.dto.Gender;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class EmployeeServiceTest {

    @Mock
    EmployeeDao dao;

    @InjectMocks
    EmployeeServiceImpl service;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllEmployeesTest() {
        List<Employee> list = new ArrayList<Employee>();
        list.add(createNewEmployee());
        list.add(createNewEmployee());
        Mockito.when(dao.findAll()).thenReturn(list);
        List<Employee> empList = service.getAll();
        assertEquals(2, empList.size());
        verify(dao, times(1)).findAll();
    }

    @Test
    public void getEmployeeByIdTest() {
        Employee expEmployee = createNewEmployee();
        Mockito.when(dao.getOne((long) 1)).thenReturn(expEmployee);
        Employee actEmp = service.getById((long) 1);
        assertEquals(expEmployee.getFirstName(), actEmp.getFirstName());
        assertEquals(expEmployee.getLastName(), actEmp.getLastName());
        assertEquals(expEmployee.getDepartmentId(), actEmp.getDepartmentId());
    }

    @Test
    public void createEmployeeTest() {
        Employee employee = createNewEmployee();
        service.save(employee);
        verify(dao, times(1)).save(employee);
    }

    private Employee createNewEmployee() {
        String randomString = RandomStringUtils.random(5, true, false);
        return new Employee(randomString, randomString, "0", "developer", Gender.MALE, "01.01.1993");
    }
}
