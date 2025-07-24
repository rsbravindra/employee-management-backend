package com.test.ems.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;
@Data
public class EmployeeDto {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private LocalDate hireDate;
    private String emailId;
    private String phoneNumber;
    private String address;
    private String createdBy;
    private String lastModifiedBy;
}
