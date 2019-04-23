package com.mastery.java.task.rest;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.dto.Gender;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class EmployeeControllerTest {

    private static final String BASE_PATH = "http://localhost:8081/api/v1/employees/";

    private static final String UPDATE_PATH = "update";

    private Employee employee;

    @Test(priority = 1)
    public void addNewEmployee() {
        employee = createNewEmployee();
        ExtractableResponse<Response> response = given()
                .contentType(ContentType.JSON)
                .body(employee)
            .when()
                .post(BASE_PATH)
            .then()
                .assertThat()
                .statusCode(201)
                .body("firstName", equalTo(employee.getFirstName()))
                .extract();
        int id = response.body().jsonPath().get("employee_id");
        employee.setEmployee_id((long) id);
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
            .get(BASE_PATH + 1)
        .then()
            .assertThat()
            .statusCode(200)
            .body("firstName", equalTo("PETR"))
            .body("lastName", equalTo("PETROV"));
    }

    @Test(priority = 2)
    public void updateEmployee() {
        String newName = RandomStringUtils.random(5, true, false);
        employee.setFirstName(newName);
        given()
                .contentType(ContentType.JSON)
                .body(employee)
            .when()
                .put(BASE_PATH + UPDATE_PATH)
            .then()
                .assertThat()
                .statusCode(200)
                .body("firstName", equalTo(employee.getFirstName()));
    }

    @Test(priority = 3)
    public void deleteEmployee() {
        given()
                .contentType(ContentType.JSON)
            .when()
                .delete(BASE_PATH + employee.getEmployee_id())
            .then()
                .assertThat()
                .statusCode(204);
    }

    private Employee createNewEmployee() {
        String randomString = RandomStringUtils.random(5, true, false);
        return new Employee(randomString, "TEST", "1", "developer'", Gender.MALE, "01.01.1993");
    }
}
