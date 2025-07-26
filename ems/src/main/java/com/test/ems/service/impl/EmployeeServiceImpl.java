package com.test.ems.service.impl;

import com.test.ems.dto.EmployeeDto;
import com.test.ems.dto.EmployeeEvent;
import com.test.ems.entity.Employee;
import com.test.ems.exception.EmployeeAlreadyExistsException;
import com.test.ems.publisher.EmployeeEventPublisher;
import com.test.ems.repository.EmployeeRepository;
import com.test.ems.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeEventPublisher eventPublisher;
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * @param employeeDto
     * @return
     */
    @Override
    public Employee createEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        try{
            Employee existingEmployeeByEmail = employeeRepository.findByEmailId(employeeDto.getEmailId());
            Employee existingEmployeeByPhoneNumber = employeeRepository.findByPhoneNumber(employeeDto.getPhoneNumber());
            if (existingEmployeeByEmail!=null) {
                throw new EmployeeAlreadyExistsException("Employee with email already exists: " + employeeDto.getEmailId());
            }
            // Check for duplicate phone number
            if (existingEmployeeByPhoneNumber!=null) {
                throw new EmployeeAlreadyExistsException("Employee with phone number already exists: " + employeeDto.getPhoneNumber());
            }
            employee.setFirstName(employeeDto.getFirstName());
            employee.setLastName(employeeDto.getLastName());
            employee.setAddress(employeeDto.getAddress());
            employee.setEmailId(employeeDto.getEmailId());
            employee.setDateOfBirth(employeeDto.getDateOfBirth());
            employee.setPhoneNumber(employeeDto.getPhoneNumber());
            employee.setHireDate(employeeDto.getHireDate());
            employee.setCreateAt(new Date());
            employee.setUpdatedAt(new Date());
            employee.setCreatedBy(employeeDto.getCreatedBy());
            employee.setLastModifiedBy(employeeDto.getLastModifiedBy());
            log.info("Before Saving employee {}", employee);
            employee = employeeRepository.save(employee);

            EmployeeEvent event = new EmployeeEvent(
                "Employee",
                    employee
            );

            // Publish to RabbitMQ
            eventPublisher.publishEmployeeUpdate(event);
        } catch (EmployeeAlreadyExistsException e) {
            log.error(e.getMessage());
            throw new EmployeeAlreadyExistsException("Failed to save employee" + e.getMessage());
        }
        return employee;
    }
}
