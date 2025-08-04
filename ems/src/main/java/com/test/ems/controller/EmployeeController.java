package com.test.ems.controller;

import com.test.ems.dto.EmployeeDto;
import com.test.ems.entity.Employee;
import com.test.ems.exception.EmployeeAlreadyExistsException;
import com.test.ems.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.Validation;
import jakarta.validation.ValidationException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/employees", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@Tag(
        name = "CRUD REST APIs for EMS in employee management backend",
        description = "CRUD REST APIs for EMS to CREATE, UPDATE, FETCH AND DELETE EMPLOYEE DETAILS"
)
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping
    @Operation(
            summary = "Create Employee API",
            description = "REST API to create new employee"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status: Employee Created"
    )
    public ResponseEntity<?> createEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        try {
            Employee createdEmployee = employeeService.createEmployee(employeeDto);
            log.info("Employee created {}", createdEmployee);
            return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
        } catch (ValidationException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
