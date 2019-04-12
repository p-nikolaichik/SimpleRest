package com.mastery.java.task.dao;

import com.mastery.java.task.dto.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for {@link com.mastery.java.task.dto.Employee} class.
 */
public interface EmployeeDao extends JpaRepository<Employee, Long> {

}
