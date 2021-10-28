package com.tricon.BengaluruOffice.Controller;


import com.tricon.BengaluruOffice.Model.Employee;
import com.tricon.BengaluruOffice.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/home")
    public String homepage()
    {
        return "Tricon Infotech Employee Management System \n" +
                "\n"+
                "use @post /Create to add an employee\n" +
                "use @get /Employees to get record of all the employees \n" +
                "use @get /Employee/EmployeeId to get record of employee according to Employee Id \n" +
                "use @put /Update to update an employee record\n" +
                "use @delete /Remove/EmployeeId to remove an employee record\n";
    }

    @PostMapping(value = "/Create",consumes = "application/json")
    public Employee addEmployee(@RequestBody Employee employee)
    {
        return this.employeeService.createEmployee(employee);
    }

    @GetMapping("/Employees")
    public List<Employee> getAllEmployees()
    {
        return this.employeeService.getAllEmployees();
    }

    @GetMapping("/Employee/{employeeId}")
    public Employee getEmployee(@PathVariable String employeeId)
    {
        return this.employeeService.getEmployee(Long.parseLong(employeeId));
    }

    @DeleteMapping("/Remove/{employeeId}")
    public ResponseEntity<HttpStatus> deletePerson(@PathVariable String employeeId)
    {
        try {
            this.employeeService.removeEmployee(Long.parseLong(employeeId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/Update",consumes = "application/json")
    public Employee updateEmployee(@RequestBody Employee employee)
    {
        return this.employeeService.updateEmployee(employee);
    }
}
