package com.test.ems.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "employee",
    uniqueConstraints = {
            @UniqueConstraint(columnNames = "emailId"),
            @UniqueConstraint(columnNames = "phoneNumber")
    }
)
@Data
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employee_id")
    private int employeeId;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name = "dob")
    private LocalDate dateOfBirth;
    @Column(name = "hire_date")
    private LocalDate hireDate;
    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @Column(nullable = false, unique = true, name = "email_id")
    private String emailId;
    @Pattern(regexp = "^(\\+91[-\\s]?)?[6-9]\\d{4}[-\\s]?\\d{5}$", message = "Phone number should be a valid 10-digit Indian number starting with 6-9")
    @NotNull(message = "Phone number must not be null.")
    @NotBlank(message = "Phone number is required")
    @Column(nullable = false, unique = true, name = "phone_number")
    private String phoneNumber;
    @Column(name = "address")
    private String address;
    @CreatedDate
    @Column(name = "created_at")
    private Date createAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;
//    @CreatedBy
    @Column(name = "created_by")
    private String createdBy;
//    @LastModifiedBy
    @Column(name = "last_modified_by")
    private String LastModifiedBy;
}
