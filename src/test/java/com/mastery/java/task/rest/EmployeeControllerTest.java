package com.mastery.java.task.rest;

import com.mastery.java.task.dto.Employee;
import io.restassured.http.ContentType;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class EmployeeControllerTest {

  private static final String BASE_PATH = "http://localhost:8081/api/v1/employees/";

  private Employee employee;

  {
    employee = createNewEmployee();
  }

  @Test
  public void addNewEmployee() {
    given()
        .contentType(ContentType.JSON)
        .body(employee)
    .when()
        .post(BASE_PATH)
    .then()
        .assertThat()
        .statusCode(201)
        .body("firstName", equalTo(employee.getFirstName()));
  }

  @Test
  public void getAllEmployees() {
    given()
        .contentType(ContentType.JSON)
    .when()
        .get(BASE_PATH)
    .then()
        .assertThat()
        .statusCode(200);
  }

  @Test
  public void getEmployeeById() {
    given()
        .contentType(ContentType.JSON)
    .when()
        .get(BASE_PATH + "1")
    .then()
        .assertThat()
        .statusCode(200)
        .body("firstName", equalTo("PETR"));
  }

  @Test
  public void updateEmployee() {
//    given()
//        .contentType(ContentType.JSON)
//        .body(employee)
//    .when()
//        .put(BASE_PATH)
//    .then()
//        .assertThat()
//        .statusCode(201)
//        .body(newName, equalTo(employee.getFirstName()));
  }

  private Employee createNewEmployee() {
    String randomString = RandomStringUtils.random(5, true, false);
    return new Employee(randomString, "TEST", "1", "developer'", "Male", "01.01.1993");
  }
}
