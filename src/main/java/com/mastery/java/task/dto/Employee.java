package com.mastery.java.task.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Simple JavaBean domain object that represents Employee
 */
@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employee extends BaseEntity {

    @JsonProperty("firstName")
    @Column(name = "first_name")
    private String firstName;

    @JsonProperty("lastName")
    @Column(name = "last_name")
    private String lastName;

    @JsonProperty("departmentId")
    @Column(name = "department_id")
    private String departmentId;

    @JsonProperty("jobTitle")
    @Column(name = "job_title")
    private String jobTitle;

    @JsonProperty("gender")
    @Column(name = "gender")
    private String gender;

    @JsonProperty("dateOfBirth")
    @Column(name = "date_of_birth")
    private String dateOfBirth;

    public Employee(String firstName, String lastName, String departmentId, String jobTitle, String gender, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentId = departmentId;
        this.jobTitle = jobTitle;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }
}
