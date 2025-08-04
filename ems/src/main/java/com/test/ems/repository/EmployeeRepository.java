package com.test.ems.repository;

import com.test.ems.entity.Employee;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;
// JPA already has @Repository annotation so no need it on top this interface
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmailId(String emailId);
    Employee findByPhoneNumber(String phoneNumber);
}
