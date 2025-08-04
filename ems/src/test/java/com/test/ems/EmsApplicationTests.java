package com.test.ems;

import com.test.ems.entity.Employee;
import com.test.ems.repository.EmployeeRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // to maintain the order of execution of test methods based on specified order
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // is to disiable autoconfiguration of DB for JUNIT test cases when we are using externa datasources
class EmsApplicationTests {

	@Autowired private EmployeeRepository employeeRepository;

	@Test
	@Order(1)
	@Rollback(value = false) // since each method runs in its own transaction and when using order we should avoid rollback
	public void saveEmployeeTest() {
		Employee employee = Employee.builder()
				.firstName("Ravindra")
				.lastName("Bankapur")
				.address("London")
				.phoneNumber("9872521716")
				.dateOfBirth(LocalDate.parse("2023-01-01"))
				.hireDate(LocalDate.parse("1990-05-15"))
				.emailId("brs@gmail.com")
				.createdBy("Admin")
				.LastModifiedBy("Admin")
				.build();
		employeeRepository.save(employee);
		Assertions.assertThat(employee.getEmployeeId()).isGreaterThan(0);
	}
}
