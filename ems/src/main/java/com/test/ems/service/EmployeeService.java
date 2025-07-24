package com.test.ems.service;

import com.test.ems.dto.EmployeeDto;
import com.test.ems.entity.Employee;

public interface EmployeeService {
    public Employee createEmployee(EmployeeDto employeeDto);
}
