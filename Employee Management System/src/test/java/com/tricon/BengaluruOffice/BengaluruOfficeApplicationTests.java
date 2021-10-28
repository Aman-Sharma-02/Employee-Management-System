package com.tricon.BengaluruOffice;

import com.tricon.BengaluruOffice.Model.Employee;
import com.tricon.BengaluruOffice.Repository.EmployeeRepository;
import com.tricon.BengaluruOffice.Services.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class BengaluruOfficeApplicationTests {

	@Autowired
	private EmployeeService employeeService;

	@MockBean
	private EmployeeRepository employeeRepository;

	@Test
	public void getAllEmployeesTest()
	{
		when(employeeRepository.findAll()).thenReturn(Stream.of(new Employee(),new Employee()).collect(Collectors.toList()));
		assertEquals(2,employeeService.getAllEmployees().size());
	}


}
