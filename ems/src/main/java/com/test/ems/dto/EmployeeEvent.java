package com.test.ems.dto;

import com.test.ems.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEvent implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String eventType;
    private Employee employee;
}
